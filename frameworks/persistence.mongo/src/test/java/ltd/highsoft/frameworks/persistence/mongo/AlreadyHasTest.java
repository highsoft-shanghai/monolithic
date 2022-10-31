package ltd.highsoft.frameworks.persistence.mongo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlreadyHasTest {

    @Test
    void should_already_has_operate() {
        AlreadyHasOne<ListManyTest.TestAggregate> aggregate = new AlreadyHasOne<>(new ListManyTest.TestAggregate(), ListManyTest.TestAggregate::id);
        aggregate.add(new ListManyTest.TestAggregate());
        assertEquals("1", aggregate.get().id());
        assertEquals("1", aggregate.id());
        aggregate.callOff();
        assertNull(aggregate.get());
        assertEquals("", aggregate.id());
    }

}
