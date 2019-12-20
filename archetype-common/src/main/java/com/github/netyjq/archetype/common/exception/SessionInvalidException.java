package com.github.netyjq.archetype.common.exception;

/**
 * @author netyjq@gmail.com
 * @date 2019-05-05
 */
public class SessionInvalidException extends AbstractException {

    public SessionInvalidException(String message) {
        super(message);
    }

    @Override
    String buildErrorMessage() {
        return null;
    }
}
