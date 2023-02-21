package ltd.highsoft.frameworks.domain.core.fields;

import ltd.highsoft.frameworks.domain.core.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.*;

import static ltd.highsoft.frameworks.domain.core.fields.DomainFieldRule.Anything.anything;
import static ltd.highsoft.frameworks.domain.core.fields.DomainFieldRule.StringThing.string;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class FieldsTest {

    @Nested
    class DomainFieldRuleTest {

        @Test
        void should_allowed_verify_when_value_is_good() {
            DomainFieldRule<String> rule = DomainFieldRule.with(o -> true, "message");
            assertDoesNotThrow(() -> rule.verify("Hello"));
        }

        @Test
        void should_allowed_verify_when_value_is_not_good() {
            DomainFieldRule<String> rule = DomainFieldRule.with(o -> false, "message");
            assertThrows(NotAllowedValueInDomainException.class, () -> rule.verify("Hello"), "message");
        }

        @Test
        void should_not_null_verify_when_value_null() {
            assertThrows(NotAllowedValueInDomainException.class, () -> anything().notNull().verify(null), "error.value-is-null");
        }

        @Test
        void should_not_null_verify_when_value_not_null() {
            assertDoesNotThrow(() -> anything().notNull().verify("Hello"));
        }

        @Test
        void should_not_empty_verify_when_value_empty() {
            assertThrows(NotAllowedValueInDomainException.class, () -> string().notEmpty().verify(""), "error.value-is-empty");
        }

        @Test
        void should_not_empty_verify_when_value_not_empty() {
            assertDoesNotThrow(() -> string().notEmpty().verify("Hello"));
        }

        @Test
        void should_max_length_2_verify_when_value_bigger_than_2() {
            assertThrows(NotAllowedValueInDomainException.class, () -> string().maxLength(2).verify("Neil"), "error.value-is-too-large");
        }

        @Test
        void should_max_length_2_verify_when_value_smaller_than_2() {
            assertDoesNotThrow(() -> string().maxLength(2).verify("H"));
        }

        @Test
        void should_min_length_2_verify_when_value_smaller_than_2() {
            assertThrows(NotAllowedValueInDomainException.class, () -> string().minLength(2).verify("N"), "error.value-is-too-short");
        }

        @Test
        void should_min_length_2_verify_when_value_bigger_than_2() {
            assertDoesNotThrow(() -> string().minLength(2).verify("Neil"));
        }

        @Test
        void should_match_regex() {
            assertThrows(NotAllowedValueInDomainException.class, () -> string().regex("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", "error.value-do-not-match-regex")
                .verify("Neil"), "error.value-do-not-match-regex");
        }

        @Test
        void should_not_match_regex() {
            assertDoesNotThrow(() -> string().regex("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", "error.value-do-not-match-regex")
                .verify("a@qq.com"));
        }

    }

    @Nested
    class DomainFieldRulesTest {

        @Test
        void should_not_allowed_verify_value() {
            DomainFieldRule<String> allowed = DomainFieldRule.with(o -> true, "message");
            DomainFieldRules<String> rules = new DomainFieldRules<>();
            rules.add(allowed);
            assertDoesNotThrow(() -> rules.verify("Hello"));
        }

    }

    @Nested
    class DomainFieldTest {

        @Test
        void should_domain_field_check() {
            DomainField<String> field = new DomainField<>("Hello");
            DomainFieldRule<String> rule = DomainFieldRule.with(o -> true, "error");
            field.addRule(rule);
            assertDoesNotThrow(field::verify);
            assertEquals("Hello", field.get());
        }

    }

    @Nested
    class IdTest {

        @Test
        void should_create_random_id() {
            GlobalIdGeneratorResetter.reset(new UuidBasedIdGenerator());
            assertThat(new Id().get()).hasSize(32);
        }

        @Test
        void should_create_id() {
            assertThat(new Id("1234").get()).isEqualTo("1234");
        }

        @Test
        void should_id_verify_throw_when_id_too_large() {
            assertThrows(NotAllowedValueInDomainException.class, () -> new Id("1234567890123456789012345678901234567890").verify());
        }

    }

    @Nested
    class GeneralInformationTest {

        @Test
        void should_create_general_information() {
            assertEquals("Content", new GeneralInformation("Content").get());
        }

        @ParameterizedTest
        @ValueSource(strings = {
            "",
            "   ",
            "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890" +
                "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901"
        })
        void should_not_pass_when_invalid_general_information(String information) {
            assertThrows(NotAllowedValueInDomainException.class, () -> new GeneralInformation(information).verify());
        }

        @ParameterizedTest
        @ValueSource(strings = {
            "Content."
        })
        void should_pass_when_valid_general_information(String information) {
            assertDoesNotThrow(() -> new GeneralInformation(information).verify());
        }

    }

    @Nested
    class NameTest {

        @Test
        void should_create_name() {
            assertEquals("Neil", new Name("Neil").get());
        }

    }

    @Nested
    class UrlTest {

        @Test
        void should_create_url() {
            assertEquals("https://example.com", new Url("https://example.com").get());
        }

        @ParameterizedTest
        @ValueSource(strings = {
            "hello",
            "https://example【】",
            "hts://example.com",
            "https://example.cn?a=%20example",
        })
        void should_not_pass_when_invalid_url(String url) {
            assertThrows(NotAllowedValueInDomainException.class, () -> new Url(url).verify());
        }

        @ParameterizedTest
        @ValueSource(strings = {
            "https://example.com"
        })
        void should_pass_when_valid_email(String url) {
            assertDoesNotThrow(() -> new Url(url).verify());
        }

    }

    @Nested
    class EmailTest {

        @Test
        void should_create_email() {
            assertEquals("weili.wang@highsoft.ltd", new Email("weili.wang@highsoft.ltd").get());
        }

        @ParameterizedTest
        @ValueSource(strings = {
            "Hello",
            "Hello.",
            "@Hello",
            "@Hello.com",
            "a@Hello.",
            "a@.com",
        })
        void should_not_pass_when_invalid_email(String email) {
            assertThrows(NotAllowedValueInDomainException.class, () -> new Email(email).verify());
        }

        @ParameterizedTest
        @ValueSource(strings = {
            "emailAddress@qq.com",
            "weili.wang@highsoft.ltd",
            "a@qq.com",
            "a@1.c",
        })
        void should_pass_when_valid_email(String email) {
            assertDoesNotThrow(() -> new Email(email).verify());
        }

    }

    @Nested
    class GenderTest {

        @Test
        void should_create_gender_as_expect() {
            assertEquals("Male", Gender.valueOf("MALE").toString());
        }

    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class TextTest {

        @Test
        void should_create_text_as_expect() {
            assertEquals("This is a text.", new Text("This is a text.").get());
        }

        @ParameterizedTest
        @MethodSource("textNotPassSource")
        void should_not_pass_when_invalid_text(String text) {
            assertThrows(NotAllowedValueInDomainException.class, () -> new Text(text).verify());
        }

        @ParameterizedTest
        @ValueSource(strings = {
            "This is a text."
        })
        void should_pass_when_valid_text(String text) {
            assertDoesNotThrow(() -> new Text(text).verify());

        }

        private Stream<Arguments> textNotPassSource() {
            return Stream.of(
                Arguments.of(""),
                Arguments.of("   "),
                Arguments.of(length2000())
            );
        }

        private String length2000() {
            final int length = 2000;
            return IntStream.rangeClosed(0, length).mapToObj(String::valueOf).reduce((o1, o2) -> o1 + o2).orElse("");
        }

    }

    @Nested
    class PasswordTest {

        @Test
        void should_throws_when_get_password_plain_text() {
            assertThrows(IllegalOperationException.class, () -> new Password("P@ssword").get());
        }

        @ParameterizedTest
        @ValueSource(strings = {
            "",
            "  ",
            "PERDICTOR",
            "predictor",
            "@@@@@@@@@",
            "1234567890",
            "HelloWorld",
            "HELLO@@@@@",
            "HELLO12345",
            "hello@@@@@",
            "hello12345",
            "@@@@@12345",
        })
        void should_not_pass_when_invalid_password(String password) {
            assertThrows(NotAllowedValueInDomainException.class, () -> new Password(password).verify());
        }

        @ParameterizedTest
        @ValueSource(strings = {
            "Predict0r",
            "P@ssword",
            "hello_world0",
        })
        void should_pass_when_valid_password(String password) {
            assertDoesNotThrow(() -> new Password(password).verify());
        }

        @Test
        void should_password_encrypt_and_matches_itself() {
            assertTrue(new Password("P@ssword").encrypt().matches(new Password("P@ssword")));
        }

        @Test
        void should_password_encrypt_and_matches_another_word_return_false() {
            assertFalse(new Password("P@ssword").encrypt().matches(new Password("P@ssword2")));
        }

    }

}
