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

public class MongoAggregates<Data, Aggregate> {

    private final MongoTemplate mongoTemplate;
    private final Class<Data> dataClass;
    private final Function<Aggregate, Data> asData;
    private final Function<Data, Aggregate> asDomain;
    private final Consumer<Aggregate> verify;

    public MongoAggregates(MongoTemplate mongoTemplate, Class<Data> dataClass, Function<Aggregate, Data> asData, Function<Data, Aggregate> asDomain,
                           Consumer<Aggregate> verify) {
        this.mongoTemplate = mongoTemplate;
        this.dataClass = dataClass;
        this.asData = asData;
        this.asDomain = asDomain;
        this.verify = verify;
    }

    public MongoAggregates(MongoTemplate mongoTemplate, Class<Data> dataClass, Function<Aggregate, Data> asData, Function<Data, Aggregate> asDomain) {
        this(mongoTemplate, dataClass, asData, asDomain, o -> {
        });
    }

    public Aggregate get(String id) {
        return asDomain.apply(ensureExistence(mongoTemplate.findById(id, dataClass), () -> id));
    }

    public Aggregate get(Query query) {
        return asDomain.apply(ensureExistence(mongoTemplate.findOne(query, dataClass), query::toString));
    }

    public Optional<Aggregate> getOptional(String id) {
        return Optional.ofNullable(mongoTemplate.findById(id, dataClass)).map(asDomain);
    }

    public Optional<Aggregate> getOptional(Query query) {
        return Optional.ofNullable(mongoTemplate.findOne(query, dataClass)).map(asDomain);
    }

    public void add(Aggregate aggregate) {
        verify.accept(aggregate);
        mongoTemplate.save(asData.apply(aggregate));
    }

    public void addAll(Collection<Aggregate> aggregates) {
        mongoTemplate.insertAll(aggregates.stream().peek(verify).map(asData).collect(Collectors.toList()));
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

    public List<Aggregate> list(Collection<String> ids) {
        return mongoTemplate.find(query(where("id").in(ids)), dataClass).parallelStream().map(asDomain).collect(Collectors.toList());
    }

    public List<Aggregate> list(Query query) {
        return mongoTemplate.find(query, dataClass).parallelStream().map(asDomain).collect(Collectors.toList());
    }

    public Page<Aggregate> list(Query query, Pageable pageable) {
        var aggregates = mongoTemplate.find(Query.of(query).with(pageable), dataClass);
        return SpringPage.from(PageableExecutionUtils.getPage(aggregates, pageable, () -> mongoTemplate.count(query, dataClass)).map(asDomain));
    }

    public Stream<Aggregate> stream(Query query) {
        return mongoTemplate.find(query, dataClass).stream().parallel().map(asDomain);
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
