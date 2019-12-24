package com.github.netyjq.archetype.common.exception;

import lombok.Data;

/**
 * @author netyjq@gmail.com
 * @date 2019-04-28
 */
@Data
public abstract class AbstractException extends RuntimeException {

    private String message;

    /**
     * build error message
     * @return String
     */
    abstract String buildErrorMessage();

    public AbstractException(String message) {
        this.message = message;
    }

}
