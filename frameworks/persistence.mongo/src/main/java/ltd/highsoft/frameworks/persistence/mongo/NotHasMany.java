package ltd.highsoft.frameworks.persistence.mongo;

import java.util.*;
import java.util.function.Function;

public class NotHasMany<Data, Aggregate> implements Many<Aggregate> {

    private final List<String> ids;
    private final MongoAggregates<Data, Aggregate> aggregates;
    private final Function<Aggregate, String> getIdFromAggregate;

    private Optional<List<Aggregate>> cached;

    public NotHasMany(List<String> ids, MongoAggregates<Data, Aggregate> aggregates, Function<Aggregate, String> getIdFromAggregate) {
        this.ids = ids;
        this.aggregates = aggregates;
        this.getIdFromAggregate = getIdFromAggregate;
        this.cached = Optional.empty();
    }

    @Override
    public Optional<Aggregate> findOne(String id) {
        if (!ids.contains(id)) return Optional.empty();
        return cached.map(list -> list.stream().filter(o -> getIdFromAggregate.apply(o).equals(id)).findFirst())
            .orElseGet(() -> aggregates.getOptional(id));
    }

    @Override
    public List<Aggregate> getAll() {
        if (cached.isEmpty()) {
            this.cached = Optional.ofNullable(aggregates.list(this.ids));
        }
        return cached.get();
    }

    public void add(String id) {
        this.ids.add(id);
    }

    public void remove(String id) {
        this.ids.remove(id);
    }

    public List<String> ids() {
        return this.ids;
    }

}
