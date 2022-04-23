package ltd.highsoft.monolithic;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@AbstractIntegrationTest(containers = {PostgresContainer.class})
public @interface IntegrationTest {
}
