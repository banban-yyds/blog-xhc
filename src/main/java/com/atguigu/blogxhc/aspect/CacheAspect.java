package com.atguigu.blogxhc.aspect;


import com.atguigu.blogxhc.annotation.QueryCache;
import com.atguigu.blogxhc.pojos.Category;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class CacheAspect {
    @Autowired
    private RedisTemplate redisTemplate;

    // 1.切入点
    @Pointcut("@annotation(com.atguigu.blogxhc.annotation.QueryCache)")
    public void cacheToFindAll(){};

    //2.通知
    @Around("cacheToFindAll()")
    public <T> T queryCache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        // 1.获取redis缓存中的key
//        List<Category> categoryList = (List<Category>) redisTemplate.opsForValue().get("category:list");
//        if (categoryList == null || categoryList.size() <= 0){
//            // 1.2.redis缓存中没有key，直接查询mysql
//            categoryList = (List<Category>) proceedingJoinPoint.proceed();
//            // 1.3.将mysql查出的数据存入redis缓存
//            redisTemplate.opsForValue().set("category:list", categoryList);
//        }
//        // 2.环绕方法返回 需要返回的值
//        return categoryList;

        //===============================优 化=====================================

        // 1.获取目标方法 注解上对应值(前缀)，准备阶段，获取目标方法的信息
        // 1.1获取目标方法的方法签名
        MethodSignature methodSignature =(MethodSignature) proceedingJoinPoint.getSignature();
        // 1.2获取目标方法的注解
        QueryCache queryCache = methodSignature.getMethod().getAnnotation(QueryCache.class);
        // 1.3获取目标方法的keyPrifix(前缀)
        String keyPrefix = queryCache.keyPrefix();

        // 2.获取目标方法的参数
        Object[] args = proceedingJoinPoint.getArgs();
        // 2.1遍历添加到keyPrefix前缀后边 实现不同查询方法前缀不同时的复用
        if (args != null && args.length > 0){
            for (Object arg : args) {
                keyPrefix += (":" + arg);
            }
        }
        // 3.略...........
        T o = (T)redisTemplate.opsForValue().get(keyPrefix);
        if (o == null){
            o = (T)proceedingJoinPoint.proceed();
            redisTemplate.opsForValue().set(keyPrefix, o);
        }
        return o;
    }
}
