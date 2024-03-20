package com.zdf.trafficsystem.user.service;

import com.zdf.internalcommon.constant.StatusCode;
import com.zdf.internalcommon.constant.UserInfoConstant;
import com.zdf.internalcommon.request.AddUserRequestDto;
import com.zdf.internalcommon.request.BatchDeleteUserRequestDto;
import com.zdf.internalcommon.request.PaginationQueryUserRequestDto;
import com.zdf.internalcommon.request.UpdateUserRequestDto;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.internalcommon.util.JpaUtil;
import com.zdf.trafficsystem.user.entity.RoleEntity;
import com.zdf.trafficsystem.user.entity.UserEntity;
import com.zdf.trafficsystem.user.repo.RoleRepository;
import com.zdf.trafficsystem.user.repo.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.*;


/**
 * @author mrzhang
 * @date 2024/3/16 19:43
 */
@Service
public class UserService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private RoleRepository roleRepository;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseResult<Boolean> addUser(AddUserRequestDto addUserRequestDto){
        logger.info("Start performing the operation of adding user");
        UserEntity userEntity = new UserEntity();
        userEntity.setUtime(LocalDateTime.now());
        BeanUtils.copyProperties(addUserRequestDto, userEntity);
        userEntity.setUpass(DigestUtils.md5Hex(addUserRequestDto.getUpass()));
        try {
            String[] ridList = userEntity.getRid().split(",");
            for (String str : ridList){
                Integer.parseInt(str);
                Optional<RoleEntity> roleEntityOptional = roleRepository.findById(Long.parseLong(str));
                if (!roleEntityOptional.isPresent()){
                    return ResponseResult.fail(StatusCode.ROLE_ID_IS_NOT_EXIT.getCode(), StatusCode.ROLE_ID_IS_NOT_EXIT.getMessage(), Boolean.FALSE);
                }
            }
            userRepository.save(userEntity);
            logger.info("add user success");
        }catch (NumberFormatException e){
            logger.error("rid format is valid");
            return ResponseResult.fail(StatusCode.ROLE_ID_FORMAT_IS_VALID.getCode(), StatusCode.ROLE_ID_FORMAT_IS_VALID.getMessage(), Boolean.FALSE);
        }catch (Exception e){
            logger.error("add user error");
            return ResponseResult.fail(StatusCode.SYSTEM_USER_ADD_ERROR.getCode(), StatusCode.SYSTEM_USER_ADD_ERROR.getMessage(), Boolean.FALSE);
        }
        return ResponseResult.success(Boolean.TRUE);
    }

    public ResponseResult<Boolean>deleteUserByUid(Integer uid){
        logger.info("Start performing the operation of deleting user");
        Optional<UserEntity> userEntityOptional = userRepository.findById(uid.longValue());
        if (userEntityOptional.isPresent()){
            UserEntity userEntity = userEntityOptional.get();
            logger.info("get the userEntity: {}" , userEntity);
            userEntity.setUstatus(UserInfoConstant.USER_STATUS_DELETE);
            userEntity.setUtime(LocalDateTime.now());
            try{
                userRepository.save(userEntity);
                logger.info("delete user success");
            }catch (Exception e){
                logger.error("delete user fail");
                return ResponseResult.fail(StatusCode.SYSTEM_USER_DELETE_ERROR.getCode(), StatusCode.SYSTEM_USER_DELETE_ERROR.getMessage(), Boolean.FALSE);
            }
            return ResponseResult.success(Boolean.TRUE);
        }
        logger.error("user is not exit");
        return ResponseResult.fail(StatusCode.SYSTEM_USER_IS_NOT_EXIT.getCode(), StatusCode.SYSTEM_USER_IS_NOT_EXIT.getMessage(), Boolean.FALSE);
    }

    public ResponseResult<Boolean>batchDeleteUserByUid(BatchDeleteUserRequestDto batchDeleteUserRequestDto){
        logger.info("Start performing the operation of deleting user");
        List<Long> uidList = batchDeleteUserRequestDto.getUidList();
        if (Objects.isNull(uidList) || uidList.isEmpty()){
            logger.error("uidList is empty");
            return ResponseResult.fail(Boolean.FALSE);
        }
        List<UserEntity> userEntityList = userRepository.findAllById(uidList);
        if (userEntityList.size() != uidList.size()){
            logger.error("user is not exit");
            return ResponseResult.fail(StatusCode.SYSTEM_USER_IS_NOT_EXIT.getCode(), StatusCode.SYSTEM_USER_IS_NOT_EXIT.getMessage(), Boolean.FALSE);
        }
        userEntityList.forEach(userEntity -> {
            userEntity.setUstatus(UserInfoConstant.USER_STATUS_DELETE);
            userEntity.setUtime(LocalDateTime.now());
        });
        try{
            userRepository.saveAll(userEntityList);
            logger.info("delete user success");
        }catch (Exception e){
            logger.error("delete user fail");
            return ResponseResult.fail(StatusCode.SYSTEM_USER_DELETE_ERROR.getCode(), StatusCode.SYSTEM_USER_DELETE_ERROR.getMessage(), Boolean.FALSE);
        }
        return ResponseResult.success(Boolean.TRUE);
    }

    public ResponseResult<Boolean>updateUser(UpdateUserRequestDto updateUserRequestDto){
        logger.info("Start performing the operation of updating user");
        Optional<UserEntity> userEntityOptional = userRepository.findById(updateUserRequestDto.getUid());
        if (userEntityOptional.isPresent()){
            JpaUtil.copyNotNullProperties(updateUserRequestDto, userEntityOptional.get());
            userEntityOptional.get().setUtime(LocalDateTime.now());
            try{
                userRepository.save(userEntityOptional.get());
                logger.info("update user success");
            }catch (Exception e){
                logger.error("update user fail");
                return ResponseResult.fail(StatusCode.SYSTEM_USER_UPDATE_ERROR.getCode(), StatusCode.SYSTEM_USER_UPDATE_ERROR.getMessage(), Boolean.FALSE);
            }
            return ResponseResult.success(Boolean.TRUE);
        }
        return ResponseResult.fail(StatusCode.SYSTEM_USER_IS_NOT_EXIT.getCode(),StatusCode.SYSTEM_USER_IS_NOT_EXIT.getMessage(), Boolean.FALSE);
    }

    public ResponseResult<List<UserEntity>>queryAllUser(){
        logger.info("query all user");
        return ResponseResult.success(userRepository.findAll());
    }

    public ResponseResult<Page<UserEntity>>paginationQueryUser(PaginationQueryUserRequestDto paginationQueryUserRequestDto){
        logger.info("Start performing the operation of querying user");
        if (Objects.isNull(paginationQueryUserRequestDto)){
            return ResponseResult.fail(new ArrayList<>());
        }
        Pageable pageRequest = PageRequest.of(paginationQueryUserRequestDto.getCurrentPage(), paginationQueryUserRequestDto.getPageSize());
        String[] notNullPropertyNames = JpaUtil.getNotNullPropertyNames(paginationQueryUserRequestDto);
        String[] notNullPropertyNamesArray = Arrays.copyOfRange(notNullPropertyNames, 1, notNullPropertyNames.length);

        if (Arrays.stream(notNullPropertyNames)
                .anyMatch(str->"pageSize".equals(str) == Boolean.TRUE) &&
                Arrays.stream(notNullPropertyNames).
                        anyMatch(str->"currentPage".equals(str) == Boolean.TRUE) && notNullPropertyNames.length == 2){
            return ResponseResult.success(userRepository.findAll(pageRequest));
        }
        Specification<UserEntity> specification = new Specification<UserEntity>(){
            final BeanWrapper beanWrapper = new BeanWrapperImpl(paginationQueryUserRequestDto);
            final List<Predicate> predicateList = new ArrayList<>();
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                for (String propertyName : notNullPropertyNamesArray){
                    if (!"pageSize".equals(propertyName) && !"currentPage".equals(propertyName)){
                        predicateList.add(criteriaBuilder.equal(root.get(propertyName), beanWrapper.getPropertyValue(propertyName)));
                    }
                }
                Predicate[] predicates = new Predicate[predicateList.size()];
                return criteriaBuilder.and(predicateList.toArray(predicates));
            }
        };

        Page<UserEntity> resultPage = userRepository.findAll(specification, pageRequest);
        logger.info("query user success");
        return ResponseResult.success(resultPage);
    }
}
