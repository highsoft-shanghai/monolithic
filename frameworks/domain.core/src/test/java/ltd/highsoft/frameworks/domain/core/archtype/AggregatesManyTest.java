package ltd.highsoft.frameworks.domain.core.archtype;

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
        NotHave<ListManyTest.TestAggregate> aggregates = new NotHave<>(List.of("1", "2"), impl);
        List<ListManyTest.TestAggregate> all = aggregates.getAll();
        assertThat(all).hasSize(2);
        assertThat(aggregates.findOne("1")).isPresent();
        assertThat(aggregates.findOne("3")).isNotPresent();
    }

}
