package ltd.highsoft.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IdentityTest {

    @Test
    void should_be_able_to_hold_id_and_name() {
        var identity = new Identity("john", "John");
        assertThat(identity.id()).isEqualTo("john");
        assertThat(identity.name()).isEqualTo("John");
    }

    @Test
    void should_be_able_to_compare_others_by_content() {
        assertThat(new Identity("john", "John")).isEqualTo(new Identity("john", "John"));
    }

}
