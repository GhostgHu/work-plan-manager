package com.shimengjie.wpm.authority.domain.model.commonauthority.annotation;


import com.shimengjie.wpm.authority.domain.model.commonauthority.ICommonAuthConstant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author shimengjie
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableCommonAuthority {

    /**
     * 默认的操作类型
     */
    String operateType() default ICommonAuthConstant.OperateType.COMMENT;
}
