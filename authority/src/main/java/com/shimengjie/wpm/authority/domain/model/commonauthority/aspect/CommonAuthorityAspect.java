package com.shimengjie.wpm.authority.domain.model.commonauthority.aspect;

import com.github.benmanes.caffeine.cache.LoadingCache;
import com.shimengjie.wpm.authority.domain.model.commonauthority.CommonAuthority;
import com.shimengjie.wpm.authority.domain.model.commonauthority.annotation.EnableCommonAuthority;
import com.shimengjie.wpm.common.exception.AccessDeniedException;
import com.shimengjie.wpm.common.utils.AnnotationUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author shimengjie
 * @date 2021/9/23 18:00
 **/
@Aspect
@Component
public class CommonAuthorityAspect {

    @Resource
    private LoadingCache<String, CommonAuthority> commonAuthorityCache;

    @Pointcut("@annotation(com.shimengjie.wpm.authority.domain.model.commonauthority.annotation.EnableCommonAuthority)")
    public void pointcut() {

    }

    @Before(value = "pointcut()")
    public void before(JoinPoint pjp) {
        EnableCommonAuthority annotation = AnnotationUtil.findAnnotation(pjp, EnableCommonAuthority.class);
        if (null == annotation) {
            return;
        }
        String operateType = annotation.operateType();
        CommonAuthority commonAuthority = commonAuthorityCache.get(operateType);
        if (commonAuthority != null && !commonAuthority.isAllow()) {
            throw new AccessDeniedException();
        }
    }
}
