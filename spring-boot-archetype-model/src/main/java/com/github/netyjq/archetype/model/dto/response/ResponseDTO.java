package com.github.netyjq.archetype.model.dto.response;

import com.github.netyjq.archetype.common.enums.ErrorEnum;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * common-used response class used to return data to browser by spring controllers.
 * @date 2017/2/20.
 * @author netyjq@gmail.com
 */
@Data
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

}
