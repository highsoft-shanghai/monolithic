package ltd.highsoft.frameworks.domain.core.archtype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NotHasTest {

    @Test
    void should_not_has_operate() {
        Aggregates<ListManyTest.TestAggregate> impl = mock(Aggregates.class);
        when(impl.get(anyString())).thenReturn(new ListManyTest.TestAggregate());
        NotHas<ListManyTest.TestAggregate> aggregate = new NotHas<>("1", impl);
        assertEquals("1", aggregate.get().id());
        aggregate.add(new ListManyTest.TestAggregate());
        aggregate.callOff();
        assertNull(aggregate.id());
    }

}
