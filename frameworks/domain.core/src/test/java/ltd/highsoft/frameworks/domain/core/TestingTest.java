package ltd.highsoft.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestingTest {

    @Test
    void should_test_without_getter() {
        assertEquals("1234", Testing.by(new User("1234")).get("name"));
    }

    private static class User {

        private final String name;

        private User(String name) {
            this.name = name;
        }

        public String name() {
            return name;
        }

    }

}
