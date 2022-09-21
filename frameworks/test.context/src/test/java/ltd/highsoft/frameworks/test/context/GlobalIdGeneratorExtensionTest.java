package ltd.highsoft.frameworks.test.context;

import ltd.highsoft.frameworks.domain.core.GlobalIdGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@WithId(value = "a-fixed-id")
public class GlobalIdGeneratorExtensionTest {

    @Test
    void should_be_able_to_reset_security_context() {
        assertThat(GlobalIdGenerator.nextId()).isEqualTo("a-fixed-id");
        assertThat(GlobalIdGenerator.nextReadableId()).isEqualTo("a-fixed-id");
    }

}
