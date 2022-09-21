package ltd.highsoft.frameworks.domain.core;

import ltd.highsoft.frameworks.domain.core.fields.Id;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IdTest {

    @BeforeEach
    void setUp() {
        GlobalIdGenerator.reset(new UuidBasedIdGenerator());
    }

    @Test
    void should_id_equals_with_id() {
        assertEquals(new Id("1"), new Id("1"));
    }

    @Test
    void should_create_uuid_id() {
        assertThat(new Id().get()).hasSize(32);
    }

    @Test
    void should_create_id_by_customize() {
        assertEquals("123", new Id("123").get());
    }

}
