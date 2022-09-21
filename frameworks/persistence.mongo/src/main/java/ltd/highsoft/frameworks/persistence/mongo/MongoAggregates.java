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

public class MongoAggregates<
    Data extends ltd.highsoft.frameworks.persistence.mongo.Data<Aggregate>,
    Aggregate extends ltd.highsoft.frameworks.domain.core.fields.Aggregate
    > {

    private final MongoTemplate mongoTemplate;
    private final Class<Data> dataClass;
    private final Function<Aggregate, Data> asData;

    public MongoAggregates(MongoTemplate mongoTemplate, Class<Data> dataClass, Function<Aggregate, Data> asData) {
        this.mongoTemplate = mongoTemplate;
        this.dataClass = dataClass;
        this.asData = asData;
    }

    public Aggregate get(String id) {
        return ensureExistence(mongoTemplate.findById(id, dataClass), () -> id).asDomain();
    }

    public Aggregate get(Query query) {
        return ensureExistence(mongoTemplate.findOne(query, dataClass), query::toString).asDomain();
    }

    public Optional<Aggregate> getOptional(String id) {
        return Optional.ofNullable(mongoTemplate.findById(id, dataClass)).map(ltd.highsoft.frameworks.persistence.mongo.Data::asDomain);
    }

    public Optional<Aggregate> getOptional(Query query) {
        return Optional.ofNullable(mongoTemplate.findOne(query, dataClass)).map(ltd.highsoft.frameworks.persistence.mongo.Data::asDomain);
    }

    public void add(Aggregate aggregate) {
        aggregate.verify();
        mongoTemplate.save(asData.apply(aggregate));
    }

    public void addAll(List<Aggregate> aggregates) {
        mongoTemplate.insertAll(aggregates.stream().peek(Aggregate::verify).map(asData).collect(Collectors.toList()));
    }

    public void remove(String id) {
        mongoTemplate.remove(query(where("id").is(id)), dataClass);
    }

    public void remove(Collection<String> ids) {
        mongoTemplate.remove(query(where("id").in(ids)), dataClass);
    }

    public void removeAll() {
        mongoTemplate.remove(new Query(), dataClass);
    }

    public void removeAll(Query query) {
        mongoTemplate.remove(query, dataClass);
    }

    public List<Aggregate> list(Query query) {
        return mongoTemplate.find(query, dataClass).parallelStream().map(ltd.highsoft.frameworks.persistence.mongo.Data::asDomain).collect(Collectors.toList());
    }

    public Page<Aggregate> list(Query query, Pageable pageable) {
        var aggregates = mongoTemplate.find(Query.of(query).with(pageable), dataClass);
        return SpringPage.from(PageableExecutionUtils.getPage(aggregates, pageable, () -> mongoTemplate.count(query, dataClass)).map(ltd.highsoft.frameworks.persistence.mongo.Data::asDomain));
    }

    public Stream<Aggregate> stream(Query query) {
        return mongoTemplate.stream(query, dataClass).stream().parallel().map(ltd.highsoft.frameworks.persistence.mongo.Data::asDomain);
    }

    public boolean exists(Query query) {
        return mongoTemplate.exists(query, dataClass);
    }

    public long count(Query query) {
        return mongoTemplate.count(Query.of(query), dataClass);
    }

    private Data ensureExistence(Data aggregate, Supplier<String> queryString) {
        if (aggregate != null) return aggregate;
        throw new AggregateNotFoundException(dataClass.getSimpleName(), queryString.get());
    }

}
