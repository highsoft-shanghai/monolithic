package ltd.highsoft.frameworks.application.spring;

import ltd.highsoft.frameworks.application.core.UseCase;
import ltd.highsoft.frameworks.security.core.Authorizer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Aspect
@Component
public class UseCaseAspect {

    private final Authorizer authorizer = new Authorizer();
    private @Resource ExceptionTranslator exceptionTranslator;

    @Around("@within(useCase)")
    public Object process(ProceedingJoinPoint joinPoint, UseCase useCase) {
        try {
            return tryToProceed(joinPoint, useCase.requiredAuthorities());
        } catch (Throwable e) {
            throw exceptionTranslator.translate(e);
        }
    }

    private Object tryToProceed(ProceedingJoinPoint joinPoint, String[] requiredAuthorities) throws Throwable {
        authorizer.authorize(requiredAuthorities);
        return joinPoint.proceed();
    }

}
