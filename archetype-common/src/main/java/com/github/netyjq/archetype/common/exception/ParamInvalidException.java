package com.github.netyjq.archetype.common.exception;

import com.github.netyjq.archetype.common.enums.ErrorEnum;
import lombok.Data;

/**
 * 参数异常
 * @author netyjq@gmail.com
 * @date 2019-04-28
 */
@Data
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

}
