package ltd.highsoft.frameworks.domain.core.archtype;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class AggregatesManyTest {

    @Test
    void should_create_many_with_aggregates() {
        Aggregates<ListManyTest.TestAggregate> impl = mock(Aggregates.class);
        when(impl.list(List.of("1", "2"))).thenReturn(List.of(new ListManyTest.TestAggregate(), new ListManyTest.TestAggregate()));
        when(impl.getOptional("1")).thenReturn(Optional.of(new ListManyTest.TestAggregate()));
        NotHasMany<ListManyTest.TestAggregate> aggregates = new NotHasMany<>(List.of("1", "2"), impl);
        List<ListManyTest.TestAggregate> all = aggregates.getAll();
        assertThat(all).hasSize(2);
        assertThat(aggregates.findOne("1")).isPresent();
        assertThat(aggregates.findOne("3")).isNotPresent();
    }

    @Test
    void should_add_id_in_not_have() {
        NotHasMany<ListManyTest.TestAggregate> aggregates = new NotHasMany<>(Lists.newArrayList("1", "2"), null);
        aggregates.add("3");
        assertThat(aggregates.ids()).containsExactly("1", "2", "3");
    }

    @Test
    void should_remove_id_in_not_have() {
        NotHasMany<ListManyTest.TestAggregate> aggregates = new NotHasMany<>(Lists.newArrayList("1", "2"), null);
        aggregates.remove("2");
        assertThat(aggregates.ids()).containsExactly("1");
    }

}
