package com.github.netyjq.archetype.model.dto.request;

import com.github.netyjq.archetype.common.validation.ValidationMarker;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * AppInfo RequestDTO Example
 * @date 2017/7/30
 * @author netyjq@gamil.com
 */
@Data
public class AppInfoRequestDTO extends PageRequestDTO {

    @NotNull(groups = {ValidationMarker.UpdateGroup.class})
    private Integer id;

    @NotNull(groups = {ValidationMarker.InsertGroup.class, ValidationMarker.UpdateGroup.class})
    private String name;

    @Override
    public boolean validate() {
        return true;
    }
}
