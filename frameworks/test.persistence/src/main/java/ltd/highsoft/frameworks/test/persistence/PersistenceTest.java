package ltd.highsoft.frameworks.test.persistence;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(PersistenceExtension.class)
public @interface PersistenceTest {
}
