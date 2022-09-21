package ltd.highsoft.frameworks.domain.core.fields;

import ltd.highsoft.frameworks.domain.core.*;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class FieldsTest {

    @Nested
    class DomainFieldNotAllowedTest {

        @Test
        void should_allowed_verify_when_value_is_good() {
            DomainFieldNotAllowed<String> allowed = DomainFieldNotAllowed.with(o -> false, "message");
            assertDoesNotThrow(() -> allowed.verify("Hello"));
        }

        @Test
        void should_allowed_verify_when_value_is_not_good() {
            DomainFieldNotAllowed<String> allowed = DomainFieldNotAllowed.with(o -> true, "message");
            assertThrows(NotAllowedValueInDomainException.class, () -> allowed.verify("Hello"));
        }

    }

    @Nested
    class IdTest {

        @Test
        void should_create_random_id() {
            GlobalIdGeneratorResetter.reset(new UuidBasedIdGenerator());
            assertThat(new Id().id()).hasSize(32);
        }

        @Test
        void should_create_id() {
            assertThat(new Id("1234").id()).isEqualTo("1234");
        }

    }

    @Nested
    class NameTest {

        @Test
        void should_create_name() {
            assertEquals("Neil", new Name("Neil").name());
        }

    }

}
