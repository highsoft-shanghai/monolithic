package ltd.highsoft.frameworks.persistence.mongo;

import java.util.Optional;
import java.util.function.Function;

public class NotHasOne<Data, Aggregate> implements One<Aggregate> {

    private String id;
    private final MongoAggregates<Data, Aggregate> aggregates;
    private final Function<Aggregate, String> getIdFromAggregate;

    private Optional<Aggregate> cached;

    public NotHasOne(String id, MongoAggregates<Data, Aggregate> aggregates, Function<Aggregate, String> getIdFromAggregate) {
        this.id = id;
        this.aggregates = aggregates;
        this.getIdFromAggregate = getIdFromAggregate;
        this.cached = Optional.empty();
    }

    @Override
    public Aggregate get() {
        if (cached.isEmpty()) {
            Aggregate aggregate = aggregates.get(id);
            cached = Optional.ofNullable(aggregate);
        }
        return cached.get();
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public void add(Aggregate aggregate) {
        this.id = getIdFromAggregate.apply(aggregate);
    }

    @Override
    public void callOff() {
        this.id = null;
    }

}
