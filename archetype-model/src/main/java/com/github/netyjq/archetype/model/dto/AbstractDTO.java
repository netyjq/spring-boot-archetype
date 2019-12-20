package com.github.netyjq.archetype.model.dto;

/**
 * abstract DTO class, only with a method validate() used to validate parameters.
 * @author netyjq@gmail.com
 * @date 2019-04-29
 */
public abstract class AbstractDTO {

    /**
     * 参数验证
     * @return boolean
     */
    public abstract boolean validate();

}
