package com.xxxx.intelligence.vo;

import com.xxxx.intelligence.enums.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO {

    private Integer code;
    private String message;
    private Object data;

    public static ResponseVO success(ResponseEnum responseEnum) {
        return new ResponseVO(responseEnum.getCode(), responseEnum.getMessage(), null);
    }

    public static ResponseVO success(ResponseEnum responseEnum, Object data) {
        return new ResponseVO(responseEnum.getCode(), responseEnum.getMessage(), data);
    }

    public static ResponseVO error(ResponseEnum responseEnum) {
        return new ResponseVO(responseEnum.getCode(), responseEnum.getMessage(), null);
    }

}
