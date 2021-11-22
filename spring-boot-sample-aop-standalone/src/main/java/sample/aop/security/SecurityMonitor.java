package sample.aop.security;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class SecurityMonitor {

    /**
     * Pointcut
     */
    @Pointcut("within(sample.aop..*)")
    public void applicationPointCutSec() {
        // Method is empty as this is just a Pointcut, the implementations are in the method annotated @Around.
    }

    @Around("applicationPointCutSec()")
    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
        if (!SecurityManager.isConnected()) {
            throw new SecurityException("Can't access unless you are connected!");
        }
        try {
            return joinPoint.proceed();
        } catch (IllegalArgumentException e) {
            Logger.getGlobal().warning(String.format("Error, illegal argument %s in %s.", Arrays.toString(joinPoint.getArgs()), joinPoint.getSignature().getName()));
            throw e;
        }
    }
}
