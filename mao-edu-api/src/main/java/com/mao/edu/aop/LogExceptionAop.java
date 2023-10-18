package com.mao.edu.aop;

import com.mao.edu.base.BaseApiController;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author chenyao
 * @date 2023-10-18 13:26
 */
@Aspect
@Component
@Slf4j
public class LogExceptionAop extends BaseApiController
{
    /**
     * aop环绕通知
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around(value = "execution(public * com.mao.edu.controller..*.*(..))")
    public Object currentLimit(ProceedingJoinPoint pjp) throws Throwable {

        try {
            // 目标方法
            return pjp.proceed();
        } catch (Exception e) {
            log.error("e:{}", e);
            return setResultError();
        }
    }
}
