package com.atguigu.blogxhc.exception;

import com.atguigu.blogxhc.result.ResultCodeEnum;

public class UserPasswordNotFindException extends UserException{
    public UserPasswordNotFindException(){
        super(ResultCodeEnum.PASSWORD_ERROR);
    }
}
