package com.atguigu.blogxhc.exception;


import com.atguigu.blogxhc.result.ResultCodeEnum;

public class UserException extends AbstractException{
    public UserException (ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum);
    }


}
