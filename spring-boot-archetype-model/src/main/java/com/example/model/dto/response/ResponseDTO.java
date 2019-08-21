package com.example.model.dto.response;

import com.example.common.enums.ErrorEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用的Response
 * @date 2017/2/20.
 * @author netyjq@gmail.com
 */
public class ResponseDTO {

    /**
     * 响应code
     */
    private Integer result;

    /**
     * 响应的message
     */
    private Object message;

    /**
     * 响应的数据
     */
    private Object data;

    public ResponseDTO() {
        this.result = ErrorEnum.SUCCESS.getCode();
        this.message = ErrorEnum.SUCCESS.getMsg();
    }

    public ResponseDTO(ErrorEnum errorEnum) {
        this.result = errorEnum.getCode();
        this.message = errorEnum.getMsg();
    }

    public ResponseDTO(Object object) {
        this.data = object;
        this.result = ErrorEnum.SUCCESS.getCode();
        this.message = ErrorEnum.SUCCESS.getMsg();
    }

    public ResponseDTO(Object object, String key) {
        Map map = new HashMap();
        map.put(key, object);
        this.data = map;
        this.result = ErrorEnum.SUCCESS.getCode();
        this.message = ErrorEnum.SUCCESS.getMsg();
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
