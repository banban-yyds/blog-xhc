package com.atguigu.blogxhc.exception;

import com.atguigu.blogxhc.result.Result;
import com.atguigu.blogxhc.result.ResultCodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e){
        return Result.fail();
    }
    @ExceptionHandler(UserPasswordNotFindException.class)
    public Result userExceptionHandlder(AbstractException e){
        System.out.println(e.toString());
        return Result.build(null, e.getResultCodeEnum());
    }
}
