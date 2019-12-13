package com.example.common.exception;

import lombok.Data;

/**
 * @author netyjq@gmail.com
 * @date 2019-04-28
 */
@Data
public abstract class AbstractException extends RuntimeException {

    private String message;

    /**
     * 构建异常信息
     * @return String
     */
    abstract String buildErrorMessage();

    public AbstractException(String message) {
        this.message = message;
    }

}
