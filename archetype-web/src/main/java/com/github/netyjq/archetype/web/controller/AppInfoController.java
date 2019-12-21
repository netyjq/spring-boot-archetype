package com.github.netyjq.archetype.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.netyjq.archetype.common.exception.ServiceException;
import com.github.netyjq.archetype.common.validation.ValidationMarker;
import com.github.netyjq.archetype.model.domain.AppInfo;
import com.github.netyjq.archetype.model.dto.request.AppInfoRequestDTO;
import com.github.netyjq.archetype.model.dto.response.ResponseDTO;
import com.github.netyjq.archetype.service.AppInfoService;
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

    @ApiOperation(value = "query", notes = "query example")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public ResponseDTO query(@Validated({ValidationMarker.SelectGroup.class}) AppInfoRequestDTO requestDTO, BindingResult result) {
        IPage<AppInfo> page = appInfoService.page(new Page<>(requestDTO.getPageNum(),  requestDTO.getPageSize()),
                new QueryWrapper<AppInfo>()
                        .lambda()
                        .eq(!Strings.isNullOrEmpty(requestDTO.getName()), AppInfo::getName, requestDTO.getName())
        );
        return new ResponseDTO(page);
    }

    @ApiOperation(value = "update", notes = "update example")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseDTO update(@Validated({ValidationMarker.UpdateGroup.class}) AppInfoRequestDTO appInfoRequestDTO, BindingResult result) {
        AppInfo appInfo = appInfoService.getById(appInfoRequestDTO.getId());
        if (null == appInfo) {
            throw new ServiceException("no AppInfo was found.");
        }
        boolean isSuccess = appInfoService.update(appInfo, new UpdateWrapper<AppInfo>()
                .lambda()
                .set(AppInfo::getName, appInfoRequestDTO.getName())
                .eq(AppInfo::getId, appInfoRequestDTO.getId())
        );
        if (!isSuccess) {
            throw new ServiceException("update failed, please try again later.");
        }
        return new ResponseDTO(appInfoService.list(new QueryWrapper<>()));
    }


}
