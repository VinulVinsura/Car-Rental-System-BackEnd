package com.example.carrentalsystemcarsv.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component  // Put this class Spring Object Container
@Aspect
@Slf4j
public class AuditLogAspect {

    @Around("@annotation(AuditTime)")
    public Object returnProceedTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long proceedTime = System.currentTimeMillis() - startTime;
        log.info("Execution Time {}ms ",proceedTime);
        System.out.println(proceedTime);

        return proceed;

    }
}
