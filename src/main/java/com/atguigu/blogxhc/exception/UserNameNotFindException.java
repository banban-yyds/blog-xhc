package com.atguigu.blogxhc.exception;

import com.atguigu.blogxhc.result.ResultCodeEnum;

public class UserNameNotFindException extends UserException {
    public UserNameNotFindException(){
        super(ResultCodeEnum.USERNAME_ERROR);
    }

}
