package com.shimengjie.wpm.common.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author shimengjie
 * @date 2021/11/19 9:25
 **/
public class AnnotationUtil {

    /**
     * 从切点上查询指定的注解
     *
     * @param pjp            切点
     * @param annotationType 要查询的注解
     * @param <T>            泛型
     * @return Annotation
     */
    public static <T extends Annotation> T findAnnotation(JoinPoint pjp, Class<T> annotationType) {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        boolean flag = method.isAnnotationPresent(annotationType);
        if (flag) {
            // 从方法上拿到 注解
            return method.getAnnotation(annotationType);
        } else {
            // 从类上拿 注解
            return AnnotationUtils.findAnnotation(pjp.getSignature().getDeclaringType(), annotationType);
        }
    }
}
