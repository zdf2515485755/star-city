package com.zdf.trafficwms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zdf.internalcommon.constant.ShelvesConstant;
import com.zdf.internalcommon.constant.StatusCode;
import com.zdf.internalcommon.request.AddWmsShelvesRequestDto;
import com.zdf.internalcommon.request.QueryShelvesRequestDto;
import com.zdf.internalcommon.request.RequestDto;
import com.zdf.internalcommon.request.UpdateWmsShelvesRequestDto;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.internalcommon.util.JpaUtil;
import com.zdf.trafficsystem.user.entity.UserEntity;
import com.zdf.trafficwms.entity.WmsShelvesEntity;
import com.zdf.trafficwms.mapper.WmsShelvesMapper;
import com.zdf.trafficwms.remote.TrafficSystemClient;
import com.zdf.trafficwms.service.WmsShelvesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.*;

/**
* @author mrzhang
* @description 针对表【wms_shelves】的数据库操作Service实现
* @createDate 2024-03-27 01:30:07
*/
@Service
public class WmsShelvesServiceImpl extends ServiceImpl<WmsShelvesMapper, WmsShelvesEntity>
    implements WmsShelvesService {
    @Resource
    private WmsShelvesMapper wmsShelvesMapper;
    @Resource
    private TrafficSystemClient trafficSystemClient;
    private final Logger logger = LoggerFactory.getLogger(WmsShelvesServiceImpl.class);

    public ResponseResult<List<WmsShelvesEntity>> queryShelves(QueryShelvesRequestDto queryShelvesRequestDto){
        logger.info("start query");
        QueryWrapper<WmsShelvesEntity> wmsShelvesQueryWrapper = new QueryWrapper<>();
        Map<String, Object> propertyHashMap;
        try{
            propertyHashMap = packagingParameters(queryShelvesRequestDto);
        }catch(NumberFormatException e){
            logger.error(ShelvesConstant.NUMBER_FORMAT_ERROR_MESSAGE);
            return ResponseResult.fail(StatusCode.NUMBER_FORMAT_ERROR.getCode(), StatusCode.NUMBER_FORMAT_ERROR.getMessage(), ShelvesConstant.NUMBER_FORMAT_ERROR_CODE);
        }
        return ResponseResult.success(wmsShelvesMapper.selectList(wmsShelvesQueryWrapper.allEq(propertyHashMap)));
    }
    public ResponseResult<Integer>addShelves(AddWmsShelvesRequestDto addWmsShelvesRequestDto){
        logger.info("start query");
        WmsShelvesEntity wmsShelvesEntity = new WmsShelvesEntity();
        BeanUtils.copyProperties(addWmsShelvesRequestDto, wmsShelvesEntity);
        int count = wmsShelvesMapper.insert(wmsShelvesEntity);
        if (count <= 0){
            logger.error("add Shelves error");
            return ResponseResult.fail(StatusCode.SHELVES_ADD_ERROR.getCode(), StatusCode.SHELVES_ADD_ERROR.getMessage(), count);
        }
        return ResponseResult.success(count);
    }

    private Map<String, Object>packagingParameters(RequestDto requestDto) throws NumberFormatException{
        BeanWrapper beanWrapper = new BeanWrapperImpl(requestDto);
        String[] notNullPropertyNames = JpaUtil.getNotNullPropertyNames(requestDto);
        String[] notNullPropertyNamesArray = Arrays.copyOfRange(notNullPropertyNames, ShelvesConstant.INDEX, notNullPropertyNames.length);
        Map<String, Object> propertyHashMap = new HashMap<>(notNullPropertyNamesArray.length);
        for (String propertyName : notNullPropertyNamesArray){
            try{
                Integer.valueOf(String.valueOf(beanWrapper.getPropertyValue(propertyName)));
            }catch (NumberFormatException e){
                throw new NumberFormatException();
            }
            propertyHashMap.put(propertyName, beanWrapper.getPropertyValue(propertyName));
        }
        return propertyHashMap;
    }

    public ResponseResult<Integer>deleteShelves(Integer sid){
        logger.info("start delete");
        WmsShelvesEntity wmsShelvesEntity = wmsShelvesMapper.selectById(sid);
        if (Objects.isNull(wmsShelvesEntity)){
            logger.error("shelves is not exit");
            return ResponseResult.fail(StatusCode.SHELVES_IS_NOT_EXIT.getCode(), StatusCode.SHELVES_IS_NOT_EXIT.getMessage(), ShelvesConstant.NOT_EXIT_CODE);
        }
        int count = wmsShelvesMapper.deleteById(wmsShelvesEntity);
        if (count <= 0){
            logger.error("delete shelves error");
            return ResponseResult.fail(StatusCode.SHELVES_DELETE_ERROR.getCode(), StatusCode.SHELVES_DELETE_ERROR.getMessage(), count);
        }
        return ResponseResult.success(count);
    }

    public ResponseResult<Integer>updateShelves(@RequestBody UpdateWmsShelvesRequestDto updateWmsShelvesRequestDto){
        logger.info("start update");
        WmsShelvesEntity wmsShelvesEntity = wmsShelvesMapper.selectById(updateWmsShelvesRequestDto.getSid());
        if (Objects.isNull(wmsShelvesEntity)){
            logger.error("shelves is not exit");
            return ResponseResult.fail(StatusCode.SHELVES_IS_NOT_EXIT.getCode(), StatusCode.SHELVES_IS_NOT_EXIT.getMessage(), ShelvesConstant.NOT_EXIT_CODE);
        }
        JpaUtil.copyNotNullProperties(updateWmsShelvesRequestDto, wmsShelvesEntity);
        int count = wmsShelvesMapper.updateById(wmsShelvesEntity);
        if (count <= 0){
            logger.error("update shelves error");
            return ResponseResult.fail(StatusCode.SHELVES_UPDATE_ERROR.getCode(), StatusCode.SHELVES_UPDATE_ERROR.getMessage(), count);
        }
        return ResponseResult.success(count);
    }

    public ResponseResult<List<UserEntity>> queryAllUser(){
        ResponseResult<List<UserEntity>> listResponseResult;
        try{
            listResponseResult = trafficSystemClient.queryAllUser();
        }catch (Exception e){
            logger.error("REMOTE REQUEST ERROR");
            return ResponseResult.fail(StatusCode.REMOTE_REQUEST_ERROR.getCode(), StatusCode.REMOTE_REQUEST_ERROR.getMessage(), null);
        }
        if (Objects.isNull(listResponseResult)){
            return ResponseResult.fail(StatusCode.REMOTE_REQUEST_ERROR.getCode(), StatusCode.REMOTE_REQUEST_ERROR.getMessage(), null);
        }
        return listResponseResult;
    }
}




