package ltd.highsoft.frameworks.persistence.mongo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

class NotHasTest {

    @Test
    void should_not_has_operate() {
        MongoAggregates<ListManyTest.DbTestAggregate, ListManyTest.TestAggregate> impl = mock(MongoAggregates.class);
        when(impl.get(anyString())).thenReturn(new ListManyTest.TestAggregate());
        NotHasOne<ListManyTest.DbTestAggregate, ListManyTest.TestAggregate> aggregate = new NotHasOne<>("1", impl, ListManyTest.TestAggregate::id);
        assertEquals("1", aggregate.get().id());
        assertEquals("1", aggregate.get().id());
        aggregate.add(new ListManyTest.TestAggregate());
        aggregate.callOff();
        assertNull(aggregate.id());
        then(impl).should(only()).get(anyString());
    }

}
