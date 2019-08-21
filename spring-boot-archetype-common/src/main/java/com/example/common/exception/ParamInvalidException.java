package com.example.common.exception;

import com.example.common.enums.ErrorEnum;

/**
 * 参数异常
 * @author netyjq@gmail.com
 * @date 2019-04-28
 */
public class ParamInvalidException extends AbstractException {

    private String field;

    @Override
    String buildErrorMessage() {
        return ErrorEnum.WEB_PARAM_ERROR.buildMessage(this.getMessage()).toString();
    }

    public ParamInvalidException(String field, String message) {
        super("参数" + field + message);
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
