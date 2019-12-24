package com.github.netyjq.archetype.common.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Back and forth interactive status code
 *
 * @date 2016/12/8.
 * @author netyjq@gmail.com
 */
@NoArgsConstructor
@Getter
public enum ErrorEnum {

    /**
     * request successful
     */
    SUCCESS(200, "success"),

    /**
     * business error
     */
    BIZ_ERROR(1000, "business error"),

    /**
     * session expired
     */
    SESSION_EXPIRED_ERROR(1001, "your session was expired"),

    /**
     * runtime error
     */
    RUNTIME_ERROR(3000, "system error, please try again later"),

    /**
     * parameters error
     */
    WEB_PARAM_ERROR(3001, "parameter error"),

    /**
     * db error
     */
    DB_EXECUTE_ERROR(3002, "db error"),

    /**
     * rpc error
     */
    RPC_ERROR(4000, "remote service error"),

    /**
     * unknown error
     */
    UNKNOWN_ERROR(6000, "unknown error");

    private int code;

    private String msg;

    ErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ErrorEnum buildMessage(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public String toString() {
        return msg + "." + this.name() +  ", code:" + code;
    }

}
