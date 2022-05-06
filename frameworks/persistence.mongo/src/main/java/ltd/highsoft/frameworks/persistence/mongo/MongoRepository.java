package ltd.highsoft.frameworks.persistence.mongo;

import ltd.highsoft.frameworks.domain.core.*;
import ltd.highsoft.frameworks.persistence.spring.SpringPage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

public class MongoRepository<D, A> {

    private final MongoTemplate mongoTemplate;
    private final Class<D> aggregateClass;
    private final Function<A, D> asData;
    private final Function<D, A> asDomain;

    public MongoRepository(MongoTemplate mongoTemplate, Class<D> dataClass, Function<A, D> asData, Function<D, A> asDomain) {
        this.mongoTemplate = mongoTemplate;
        this.aggregateClass = dataClass;
        this.asData = asData;
        this.asDomain = asDomain;
    }

    public A get(String id) {
        return asDomain.apply(ensureExistence(mongoTemplate.findById(id, aggregateClass), () -> id));
    }

    public A get(Query query) {
        return asDomain.apply(ensureExistence(mongoTemplate.findOne(query, aggregateClass), query::toString));
    }

    public Optional<A> getOptional(String id) {
        return Optional.ofNullable(mongoTemplate.findById(id, aggregateClass)).map(asDomain);
    }

    public Optional<A> getOptional(Query query) {
        return Optional.ofNullable(mongoTemplate.findOne(query, aggregateClass)).map(asDomain);
    }

    public void put(A aggregate) {
        mongoTemplate.save(asData.apply(aggregate));
    }

    public void putAll(List<A> aggregates) {
        mongoTemplate.insertAll(aggregates.stream().map(asData).collect(Collectors.toList()));
    }

    public void remove(String id) {
        mongoTemplate.remove(query(where("id").is(id)), aggregateClass);
    }

    public void remove(Collection<String> ids) {
        mongoTemplate.remove(query(where("id").in(ids)), aggregateClass);
    }

    public void removeAll() {
        mongoTemplate.remove(new Query(), aggregateClass);
    }

    public void removeAll(Query query) {
        mongoTemplate.remove(query, aggregateClass);
    }

    public List<A> list(Query query) {
        return mongoTemplate.find(query, aggregateClass).stream().map(asDomain).collect(Collectors.toList());
    }

    public Page<A> list(Query query, Pageable pageable) {
        var aggregates = mongoTemplate.find(Query.of(query).with(pageable), aggregateClass);
        return SpringPage.from(PageableExecutionUtils.getPage(aggregates, pageable, () -> mongoTemplate.count(query, aggregateClass)).map(asDomain));
    }

    public Stream<A> stream(Query query) {
        return mongoTemplate.stream(query, aggregateClass).stream().map(asDomain);
    }

    public boolean exists(Query query) {
        return mongoTemplate.exists(query, aggregateClass);
    }

    public long count(Query query) {
        return mongoTemplate.count(Query.of(query), aggregateClass);
    }

    private D ensureExistence(D aggregate, Supplier<String> queryString) {
        if (aggregate != null) return aggregate;
        throw new AggregateNotFoundException(aggregateClass.getSimpleName(), queryString.get());
    }

}
