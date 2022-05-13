package ltd.highsoft.frameworks.persistence.mongo;

import lombok.*;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.data.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@MockitoSettings(strictness = Strictness.LENIENT)
public class MongoAggregatesTest {
    private @Mock TestRepository testRepository;
    private MongoAggregates<TestAggregate, TestData, TestRepository, String> aggregates;

    @BeforeEach
    void setUp() {
        when(testRepository.findByName("test")).thenReturn(new TestData(new TestAggregate("test")));
        when(testRepository.findByNameAndId("test", "id")).thenReturn(new TestData(new TestAggregate("test")));
        when(testRepository.findByNameAndIdAndGender("test", "id", "gender")).thenReturn(new TestData(new TestAggregate("test")));
        when(testRepository.existsByName("test")).thenReturn(true);
        when(testRepository.existsByNameAndId("test", "id")).thenReturn(true);
        when(testRepository.existsByNameAndIdAndGender("test", "id", "gender")).thenReturn(true);
        when(testRepository.findByNameAndIdAndGender("test null", "id", "gender")).thenReturn(null);
        aggregates = new MongoAggregates<>(testRepository, TestData::new, TestData::asDomain);
    }

    @Test
    void should_be_able_to_accept_one_aggregate_consumer() {
        aggregates.acceptByAggregate(TestRepository::save, new TestAggregate(""));
        then(testRepository).should(only()).save(new TestData(new TestAggregate("")));
    }

    @Test
    void should_be_able_to_accept_one_param_consumer() {
        aggregates.accept(TestRepository::deleteByName, "test");
        then(testRepository).should(only()).deleteByName("test");
    }

    @Test
    void should_be_able_to_apply_one_aggregate_function() {
        TestAggregate aggregate = aggregates.applyAsAggregate(TestRepository::findByName, "test");
        assertEquals(aggregate.name, "test");
    }

    @Test
    void should_be_able_to_apply_one_param_function() {
        assertEquals(aggregates.apply(TestRepository::existsByName, "test"), true);
    }

    @Test
    void should_be_able_to_accept_two_param_consumer() {
        aggregates.accept(TestRepository::deleteByNameAndId, "name", "id");
        then(testRepository).should(only()).deleteByNameAndId("name", "id");
    }

    @Test
    void should_be_able_to_apply_two_aggregates_function() {
        TestAggregate aggregate = aggregates.applyAsAggregate(TestRepository::findByNameAndId, "test", "id");
        assertEquals(aggregate.name, "test");
    }

    @Test
    void should_be_able_to_apply_two_params_function() {
        assertEquals(aggregates.apply(TestRepository::existsByNameAndId, "test", "id"), true);
    }

    @Test
    void should_be_able_to_accept_three_param_consumer() {
        aggregates.accept(TestRepository::deleteByNameAndIdAndGender, "name", "id", "gender");
        then(testRepository).should(only()).deleteByNameAndIdAndGender("name", "id", "gender");
    }

    @Test
    void should_be_able_to_apply_three_aggregates_function() {
        TestAggregate aggregate = aggregates.applyAsAggregate(TestRepository::findByNameAndIdAndGender, "test", "id", "gender");
        assertEquals(aggregate.name, "test");
    }

    @Test
    void should_be_able_to_apply_three_params_function() {
        assertEquals(aggregates.apply(TestRepository::existsByNameAndIdAndGender, "test", "id", "gender"), true);
    }

    @Test
    void should_throw_exception_when_query_null() {
        assertThrows(RuntimeException.class, () -> aggregates.applyAsAggregate(TestRepository::findByNameAndIdAndGender,
            "test null", "id", "gender"), "error.can-not-get-aggregate");
    }

    @SuppressWarnings("all")
    private interface TestRepository extends Repository<TestData, String> {
        void save(TestData data);
        void deleteByName(String name);
        void deleteByNameAndId(String name, String id);
        void deleteByNameAndIdAndGender(String name, String id, String gender);
        TestData findByName(String name);
        TestData findByNameAndId(String name, String id);
        TestData findByNameAndIdAndGender(String name, String id, String gender);
        boolean existsByName(String name);
        boolean existsByNameAndId(String name, String id);
        boolean existsByNameAndIdAndGender(String name, String id, String gender);
    }

    @EqualsAndHashCode
    private static class TestData {
        private final String name;

        public TestData(TestAggregate testData) {
            this.name = testData.name;
        }

        public TestAggregate asDomain() {
            return new TestAggregate(this.name);
        }
    }

    @AllArgsConstructor
    @EqualsAndHashCode
    private static class TestAggregate {
        private final String name;
    }
}
