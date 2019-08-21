package com.example.web.controller;

import com.example.common.validation.ValidationMarker;
import com.example.model.domain.AppInfo;
import com.example.model.dto.request.AppInfoRequestDTO;
import com.example.model.dto.response.ResponseDTO;
import com.example.service.AppInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * rest controller example
 * @author netyjq@@gmail.com
 * @date 2017/7/5
 */
@RestController
public class AppInfoController {

    @Autowired
    private AppInfoService appInfoService;

    @RequestMapping("/update")
    public ResponseDTO update(@Validated({ValidationMarker.UpdateGroup.class}) AppInfoRequestDTO appInfoRequestDTO, BindingResult result) {
//        appInfoService.updateAppInfo(appInfoRequestDTO);
        return new ResponseDTO();
    }

    @RequestMapping("/insert")
    public ResponseDTO insert(@Validated({ValidationMarker.InsertGroup.class}) AppInfoRequestDTO appInfoRequestDTO, BindingResult result) {
        appInfoService.insertAppInfo(appInfoRequestDTO);
        return new ResponseDTO();
    }

    @RequestMapping("/query")
    public ResponseDTO query(@Validated({ValidationMarker.SelectGroup.class}) AppInfoRequestDTO appInfoRequestDTO, BindingResult result) {
        PageInfo<AppInfo> page = appInfoService.listPage(appInfoRequestDTO);
        return new ResponseDTO(page);
    }



}
