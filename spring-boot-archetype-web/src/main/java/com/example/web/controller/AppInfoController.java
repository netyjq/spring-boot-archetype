package com.example.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.common.exception.ServiceException;
import com.example.common.validation.ValidationMarker;
import com.example.model.domain.AppInfo;
import com.example.model.dto.request.AppInfoRequestDTO;
import com.example.model.dto.response.ResponseDTO;
import com.example.service.AppInfoService;
import com.google.common.base.Strings;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * rest example controller
 * @author netyjq@@gmail.com
 * @date 2017/7/5
 */
@RestController
@Api(tags = "AppInfo")
public class AppInfoController {

    @Resource
    private AppInfoService appInfoService;

    @ApiOperation(value = "query", notes = "查询")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public ResponseDTO query(@Validated({ValidationMarker.SelectGroup.class}) AppInfoRequestDTO requestDTO, BindingResult result) {
        IPage<AppInfo> page = appInfoService.selectPage(requestDTO.getPageNum(),  requestDTO.getPageSize(),
                new QueryWrapper<AppInfo>()
                        .lambda()
                        .eq(!Strings.isNullOrEmpty(requestDTO.getName()), AppInfo::getName, requestDTO.getName())
        );
        return new ResponseDTO(page);
    }

    @ApiOperation(value = "update", notes = "更新")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseDTO update(@Validated({ValidationMarker.UpdateGroup.class}) AppInfoRequestDTO appInfoRequestDTO, BindingResult result) {
        AppInfo appInfo = appInfoService.selectById(appInfoRequestDTO.getId());
        if (null == appInfo) {
            throw new ServiceException("没有找到应用记录！");
        }
        int rows = appInfoService.update(appInfo, new UpdateWrapper<AppInfo>()
                .lambda()
                .set(AppInfo::getName, appInfoRequestDTO.getName())
                .eq(AppInfo::getId, appInfoRequestDTO.getId())
        );
        if (rows == 0) {
            throw new ServiceException("更新失败！");
        }
        return new ResponseDTO(appInfoService.selectList(new QueryWrapper<>()));
    }


}
