package com.atguigu.blogxhc.exception;

import com.atguigu.blogxhc.result.ResultCodeEnum;

public abstract class AbstractException extends RuntimeException{
    private ResultCodeEnum resultCodeEnum;

    public AbstractException(){}

    public AbstractException(ResultCodeEnum resultCodeEnum){
        this.resultCodeEnum = resultCodeEnum;
    }

    public ResultCodeEnum getResultCodeEnum() {
        return resultCodeEnum;
    }
}
