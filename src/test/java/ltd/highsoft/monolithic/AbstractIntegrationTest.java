package ltd.highsoft.monolithic;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@SpringBootTest
@ExtendWith(TestContainersInitializerExtension.class)
public @interface AbstractIntegrationTest {

    Class<?>[] containers() default {};

}
