package com.example.model.dto.request;

import com.example.common.validation.ValidationMarker;

import javax.validation.constraints.NotNull;

/**
 * AppInfo RequestDTO Example
 * @date 2017/7/30
 * @author netyjq@gamil.com
 */
public class AppInfoRequestDTO extends PageRequestDTO {

    @NotNull(groups = {ValidationMarker.UpdateGroup.class})
    private Integer id;

    @NotNull(groups = {ValidationMarker.InsertGroup.class, ValidationMarker.UpdateGroup.class})
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean validate() {
        return true;
    }
}
