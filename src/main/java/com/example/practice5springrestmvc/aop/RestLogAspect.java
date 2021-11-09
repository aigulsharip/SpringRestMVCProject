package com.example.practice5springrestmvc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.lang.reflect.Method;

@Aspect
@Component
public class RestLogAspect {

    @Around(value = "@annotation(restLogAnnotation)")
    public Object restLog (ProceedingJoinPoint joinPoint, RestLog restLogAnnotation) throws Throwable {
        long startTime = System.nanoTime();
        Logger log = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        String uri = restLogAnnotation.uri();
        String requestType = getRequestType(joinPoint);
        log.info("Starting {} in {}", requestType, uri);

        Object object = joinPoint.proceed();

        long endTime = System.nanoTime();
        log.info("Time used in ms: {}", (endTime-startTime));
        return object;

    }

    private String getRequestType(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        GetMapping getMapping = method.getAnnotation(GetMapping.class);
        if (getMapping != null) {
            return "GET";
        }

        DeleteMapping deleteMapping = method.getAnnotation(DeleteMapping.class);
        if (deleteMapping != null) {
            return "DELETE";
        }

        PutMapping putMapping = method.getAnnotation(PutMapping.class);
        if (putMapping != null) {
            return "PUT";
        }

        PostMapping postMapping = method.getAnnotation(PostMapping.class);
        if (postMapping != null) {
            return "POST";
        }
        return "N/A";
    }

}
