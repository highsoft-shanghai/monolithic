package ltd.highsoft.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IdentityTest {

    @Test
    void should_be_able_to_hold_id_and_name() {
        Identity identity = new Identity("john", "John");
        assertThat(identity.id()).isEqualTo("john");
        assertThat(identity.name()).isEqualTo("John");
    }

}
