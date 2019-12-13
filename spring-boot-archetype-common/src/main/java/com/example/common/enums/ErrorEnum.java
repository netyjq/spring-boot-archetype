package com.example.common.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 前后交互状态码
 * @date 2016/12/8.
 * @author netyjq@gmail.com
 */
@NoArgsConstructor
@Getter
public enum ErrorEnum {

    /**
     * 请求成功
     * 200 成功/正常
     */
    SUCCESS(200, "请求成功"),

    /**
     * 业务异常
     */
    BIZ_ERROR(1000, "业务异常"),

    /**
     * 用户会话异常
     */
    SESSION_LOST_ERROR(1001, "用户会话异常"),

    /**
     * 系统运行期异常
     */
    RUNTIME_ERROR(3000, "系统运行期异常"),

    /**
     * 前端传入参数错误，一般表现为：参数漏传，类型传错
     */
    WEB_PARAM_ERROR(3001, "入参错误"),

    /**
     * 数据库执行异常
     */
    DB_EXECUTE_ERROR(3002, "数据库执行异常"),

    /**
     * 唯一索引
     */
    DB_UNIQUE_ERROR(3003, "无法操作成功，破坏了数据库唯一索引"),

    /**
     * RPC服务调用异常
     */
    RPC_ERROR(4000, "系统运行期异常"),

    /**
     * 系统未知系统
     */
    UNKNOWN_ERROR(6000, "系统未知异常");


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
