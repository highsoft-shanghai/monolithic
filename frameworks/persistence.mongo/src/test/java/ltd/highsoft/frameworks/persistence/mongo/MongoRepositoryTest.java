package ltd.highsoft.frameworks.persistence.mongo;

import ltd.highsoft.frameworks.domain.core.AggregateNotFoundException;
import ltd.highsoft.frameworks.test.mongo.MongoTest;
import org.junit.jupiter.api.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Query;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.data.domain.Sort.by;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

public class MongoRepositoryTest extends MongoTest {

    private MongoAggregates<MongoTestAggregate, TestAggregate> aggregates;
    private MongoAggregates<MongoTestAggregate, TestAggregate> aggregatesWithoutVerify;

    @BeforeEach
    void setUp() {
        aggregates = new MongoAggregates<>(mongoTemplate(), MongoTestAggregate.class, MongoTestAggregate::new, MongoTestAggregate::asDomain, TestAggregate::verify);
        aggregatesWithoutVerify = new MongoAggregates<>(mongoTemplate(), MongoTestAggregate.class, MongoTestAggregate::new, MongoTestAggregate::asDomain);
    }

    @Test
    void should_be_able_to_put_aggregates_to_database() {
        aggregates.add(new TestAggregate("1", "hello"));
        assertThat(mongoTemplate().findById("1", MongoTestAggregate.class)).isEqualTo(new MongoTestAggregate(new TestAggregate("1", "hello")));
    }

    @Test
    void should_be_able_to_put_batch_of_aggregates_to_database() {
        aggregates.addAll(List.of(new TestAggregate("1", "hello"), new TestAggregate("2", "hello2")));
        assertThat(mongoTemplate().findById("1", MongoTestAggregate.class)).isEqualTo(new MongoTestAggregate(new TestAggregate("1", "hello")));
        assertThat(mongoTemplate().findById("2", MongoTestAggregate.class)).isEqualTo(new MongoTestAggregate(new TestAggregate("2", "hello2")));
    }

    @Test
    void should_be_able_to_get_aggregates_from_database() {
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("1", "hello")));
        assertThat(aggregates.get("1")).isEqualTo(new TestAggregate("1", "hello"));
    }

    @Test
    void should_failed_to_get_aggregate_from_database_when_aggregate_not_found() {
        var throwable = catchThrowable(() -> aggregates.get("not-existed-id"));
        assertThat(throwable).isInstanceOf(AggregateNotFoundException.class);
        assertThat(throwable).hasMessage("error.aggregate-not-found: [MongoTestAggregate, not-existed-id]");
    }

    @Test
    void should_be_able_to_get_aggregates_from_database_by_queries() {
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("1", "hello")));
        assertThat(aggregates.get(query(where("id").is("1")))).isEqualTo(new TestAggregate("1", "hello"));
    }

    @Test
    void should_failed_to_get_aggregate_from_database_by_query_when_aggregate_not_found() {
        var throwable = catchThrowable(() -> aggregates.get(query(where("id").is("not-existed-id"))));
        assertThat(throwable).isInstanceOf(AggregateNotFoundException.class);
        assertThat(throwable).hasMessage("error.aggregate-not-found: [MongoTestAggregate, Query: { \"id\" : \"not-existed-id\"}, Fields: {}, Sort: {}]");
    }

    @Test
    void should_be_able_to_get_optional_aggregates_from_database() {
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("1", "hello")));
        assertThat(aggregates.getOptional("1")).isEqualTo(Optional.of(new TestAggregate("1", "hello")));
    }

    @Test
    void should_be_able_to_get_optional_aggregates_from_database_when_aggregate_not_exist() {
        assertThat(aggregates.getOptional("not-exist")).isEqualTo(Optional.empty());
    }

    @Test
    void should_be_able_to_get_optional_aggregates_from_database_by_queries() {
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("1", "hello")));
        assertThat(aggregates.getOptional(query(where("id").is("1")))).isEqualTo(Optional.of(new TestAggregate("1", "hello")));
    }

    @Test
    void should_be_able_to_get_optional_aggregates_from_database_by_queries_when_aggregate_not_exist() {
        assertThat(aggregates.getOptional(query(where("id").is("not-exist")))).isEqualTo(Optional.empty());
    }

    @Test
    void should_be_able_to_remove_aggregates_from_database() {
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("1", "hello")));
        aggregates.remove("1");
        assertThat(mongoTemplate().findById("1", MongoTestAggregate.class)).isNull();
    }

    @Test
    void should_be_able_to_remove_all_aggregates_from_database() {
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("1", "hello")));
        aggregates.removeAll();
        assertThat(mongoTemplate().findById("1", MongoTestAggregate.class)).isNull();
    }

    @Test
    void should_be_able_to_remove_all_matched_aggregates_from_database() {
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("1", "hello")));
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("2", "hello2")));
        aggregates.removeAll(query(where("name").regex("hello")));
        assertThat(mongoTemplate().count(new Query(), MongoTestAggregate.class)).isEqualTo(0);
    }

    @Test
    void should_be_able_to_remove_aggregates_from_database_by_ids() {
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("1", "hello")));
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("2", "hello2")));
        aggregates.remove(List.of("1", "2"));
        assertThat(mongoTemplate().count(new Query(), MongoTestAggregate.class)).isEqualTo(0);
    }

    @Test
    void should_be_able_to_find_aggregates_from_database() {
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("1", "hello3")));
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("2", "hello1")));
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("3", "hello2")));
        assertThat(aggregates.list(query(where("name").regex("hello")))).hasSize(3);
        assertThat(aggregates.list(List.of("1", "2", "3"))).hasSize(3);
    }

    @Test
    void should_be_able_to_find_paged_aggregates_from_database() {
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("1", "hello3")));
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("2", "hello1")));
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("3", "hello2")));
        var found = aggregates.list(query(where("name").regex("hello")), PageRequest.of(1, 1, by("name").descending()));
        assertThat(found.content()).hasSize(1);
        assertThat(found.content()).containsExactly(new TestAggregate("3", "hello2"));
    }

    @Test
    void should_be_able_to_find_aggregates_from_database_as_streams() {
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("1", "hello3")));
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("2", "hello1")));
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("3", "hello2")));
        assertThat(aggregates.stream(query(where("name").regex("hello")))).hasSize(3);
    }

    @Test
    void should_be_able_to_count_aggregates_from_database() {
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("1", "hello")));
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("2", "hello2")));
        assertThat(aggregates.count(query(where("name").regex("hello")))).isEqualTo(2);
    }

    @Test
    void should_be_able_to_test_aggregate_existence_from_database() {
        mongoTemplate().save(new MongoTestAggregate(new TestAggregate("1", "hello")));
        assertThat(aggregates.exists(Query.query(where("id").is("1")))).isTrue();
        assertThat(aggregates.exists(Query.query(where("id").is("2")))).isFalse();
    }

    @Test
    void should_test_aggregate_existence_from_database_when_aggregate_2() {
        aggregatesWithoutVerify.addAll(List.of(new TestAggregate("1", "hello"), new TestAggregate("2", "hello2")));
        assertThat(aggregatesWithoutVerify.exists(Query.query(where("id").is("1")))).isTrue();
        assertThat(aggregatesWithoutVerify.exists(Query.query(where("id").is("3")))).isFalse();
    }

    @AfterEach
    void tearDown() {
        mongoTemplate().dropCollection(MongoTestAggregate.class);
    }

}
