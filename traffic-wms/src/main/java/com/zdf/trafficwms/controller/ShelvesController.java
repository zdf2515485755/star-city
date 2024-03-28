package com.zdf.trafficwms.controller;

import com.zdf.internalcommon.request.AddWmsShelvesRequestDto;
import com.zdf.internalcommon.request.QueryShelvesRequestDto;
import com.zdf.internalcommon.request.UpdateWmsShelvesRequestDto;
import com.zdf.internalcommon.result.ResponseResult;
import com.zdf.trafficwms.entity.WmsShelvesEntity;
import com.zdf.trafficwms.service.impl.WmsShelvesServiceImpl;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *@Description API for operating user information
 *@Author mrzhang
 *@Date 2024/3/27 19:20
 */
@RestController
@RequestMapping("/shelves")
public class ShelvesController {

    @Resource
    private WmsShelvesServiceImpl wmsShelvesService;
    /**
     * @param queryShelvesRequestDto:
     * @return ResponseResult<List<WmsShelves>>
     * @author mrzhang
     * @description Query shelves
     * @date 2024/3/27 21:45
     */
    @PostMapping("/queryShelves")
    public ResponseResult<List<WmsShelvesEntity>>queryShelves(@RequestBody QueryShelvesRequestDto queryShelvesRequestDto){
        return wmsShelvesService.queryShelves(queryShelvesRequestDto);
    }
    /**
     * @param addWmsShelvesRequestDto:
     * @return ResponseResult<Integer>
     * @author mrzhang
     * @description Add shelves
     * @date 2024/3/27 21:46
     */
    @PostMapping("/addShelves")
    public ResponseResult<Integer>addShelves(@Validated @RequestBody AddWmsShelvesRequestDto addWmsShelvesRequestDto){
        return wmsShelvesService.addShelves(addWmsShelvesRequestDto);
    }
    /**
     * @param sid:
     * @return ResponseResult<Integer>
     * @author mrzhang
     * @description Delete shelves by sid
     * @date 2024/3/27 21:46
     */
    @GetMapping("/deleteShelves")
    public ResponseResult<Integer>deleteShelves(@NotNull @RequestParam Integer sid){
        return wmsShelvesService.deleteShelves(sid);
    }
    /**
     * @param updateWmsShelvesRequestDto:
     * @return ResponseResult<Integer>
     * @author mrzhang
     * @description update shelves
     * @date 2024/3/27 21:47
     */
    @PostMapping("/updateShelves")
    public ResponseResult<Integer>updateShelves(@RequestBody UpdateWmsShelvesRequestDto updateWmsShelvesRequestDto){
        return wmsShelvesService.updateShelves(updateWmsShelvesRequestDto);
    }
}
