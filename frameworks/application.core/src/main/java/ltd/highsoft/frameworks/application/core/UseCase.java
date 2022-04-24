package ltd.highsoft.frameworks.application.core;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
@Transactional
public @interface UseCase {

    @AliasFor(attribute = "requiredAuthorities")
    String[] value();

    @AliasFor(attribute = "value")
    String[] requiredAuthorities() default {};

}
