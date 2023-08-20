package com.atguigu.blogxhc.result;
import lombok.Getter;
@Getter
public enum ResultCodeEnum {

    SUCCESS(200,"成功"),
    FAIL(201, "失败"),
    USERNAME_ERROR(501, "用户名错误"),

    PASSWORD_ERROR(502, "密码错误");

    private Integer code;
    private String message;
    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}