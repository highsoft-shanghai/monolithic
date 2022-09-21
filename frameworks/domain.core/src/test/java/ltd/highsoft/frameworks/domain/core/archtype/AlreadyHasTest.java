package ltd.highsoft.frameworks.domain.core.archtype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlreadyHasTest {

    @Test
    void should_already_has_operate() {
        AlreadyHas<ListManyTest.TestAggregate> aggregate = new AlreadyHas<>(new ListManyTest.TestAggregate());
        aggregate.add(new ListManyTest.TestAggregate());
        assertEquals("1", aggregate.get().id());
        aggregate.callOff();
        assertNull(aggregate.get());
    }

}
