package com.example.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.common.exception.ServiceException;
import com.example.common.validation.ValidationMarker;
import com.example.mapper.AppInfoMapper;
import com.example.model.domain.AppInfo;
import com.example.model.dto.request.AppInfoRequestDTO;
import com.example.model.dto.response.ResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * rest controller example
 * @author netyjq@@gmail.com
 * @date 2017/7/5
 */
@RestController
@Api(tags = "AppInfo")
public class AppInfoController {


    @Autowired
    private AppInfoMapper appInfoMapper;

    @ApiOperation(value = "query", notes = "查询")
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public ResponseDTO query(@Validated({ValidationMarker.SelectGroup.class}) AppInfoRequestDTO appInfoRequestDTO, BindingResult result) {
        QueryWrapper<AppInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 1);
        return new ResponseDTO(appInfoMapper.selectList(wrapper));
    }

    @ApiOperation(value = "update", notes = "更新")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseDTO update(@Validated({ValidationMarker.UpdateGroup.class}) AppInfoRequestDTO appInfoRequestDTO, BindingResult result) {
        AppInfo appInfo = appInfoMapper.selectById(appInfoRequestDTO.getId());
        if (null == appInfo) {
            throw new ServiceException("没有找到应用记录！");
        }
        UpdateWrapper<AppInfo> wrapper = new UpdateWrapper<>();
        wrapper.set("name", appInfoRequestDTO.getName());
        int rows = appInfoMapper.update(appInfo, wrapper);
        if (rows == 0) {
            throw new ServiceException("更新失败！");
        }
        return new ResponseDTO(appInfoMapper.selectList(wrapper));
    }


}
