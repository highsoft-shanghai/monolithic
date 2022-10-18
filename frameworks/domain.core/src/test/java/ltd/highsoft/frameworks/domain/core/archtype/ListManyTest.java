package ltd.highsoft.frameworks.domain.core.archtype;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ListManyTest {

    @Test
    void should_create_list_many() {
        Many<TestAggregate> aggregates = new AlreadyHasMany<>(List.of(new TestAggregate()));
        assertThat(aggregates.getAll()).hasSize(1);
        assertThat(aggregates.findOne("1")).isPresent();
    }

    @Test
    void should_list_many_add() {
        AlreadyHasMany<TestAggregate> aggregates = new AlreadyHasMany<>(Lists.newArrayList(new TestAggregate()));
        aggregates.add(new TestAggregate());
        assertThat(aggregates.getAll()).hasSize(2);
    }

    @Test
    void should_list_many_return_ids() {
        AlreadyHasMany<TestAggregate> aggregates = new AlreadyHasMany<>(Lists.newArrayList(new TestAggregate()));
        assertThat(aggregates.ids()).containsExactly("1");
    }

    @Test
    void should_remove_in_already_have() {
        AlreadyHasMany<TestAggregate> aggregates = new AlreadyHasMany<>(Lists.newArrayList(new TestAggregate()));
        aggregates.remove("1");
        assertThat(aggregates.getAll()).isEmpty();
    }

    static class TestAggregate implements Aggregate {

        @Override
        public String id() {
            return "1";
        }

    }

}
