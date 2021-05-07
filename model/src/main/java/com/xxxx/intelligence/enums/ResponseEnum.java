package com.xxxx.intelligence.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum ResponseEnum {
    SUCCESS(200, "操作成功"),
    ERROR(500,"服务器异常");

    private Integer code;
    private String message;
}
