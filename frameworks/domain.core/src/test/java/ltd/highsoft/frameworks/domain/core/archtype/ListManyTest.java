package ltd.highsoft.frameworks.domain.core.archtype;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ListManyTest {

    @Test
    void should_create_list_many() {
        Many<TestAggregate> aggregates = new AlreadyHave<>(List.of(new TestAggregate()));
        assertThat(aggregates.getAll()).hasSize(1);
        assertThat(aggregates.findOne("1")).isPresent();
    }

    static class TestAggregate implements Aggregate {

        @Override
        public String id() {
            return "1";
        }

        @Override
        public void verify() {
        }

    }

}
