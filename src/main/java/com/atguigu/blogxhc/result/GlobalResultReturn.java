package com.atguigu.blogxhc.result;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(basePackages = "com.atguigu.blogxhc.controller")
public class GlobalResultReturn implements ResponseBodyAdvice  {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        System.out.println(body);
        if (body instanceof Result || body instanceof String){
            return body;
        }else if(body instanceof Boolean){
            if ((Boolean) body){
                return Result.ok();
            }else {
                return Result.fail();
            }
        }else {
            return Result.ok(body);
        }


    }
}
