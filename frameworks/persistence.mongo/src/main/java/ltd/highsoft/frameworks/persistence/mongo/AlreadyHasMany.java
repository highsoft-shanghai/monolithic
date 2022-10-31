package ltd.highsoft.frameworks.persistence.mongo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AlreadyHasMany<Aggregate> implements Many<Aggregate> {

    private final List<Aggregate> aggregates;
    private final Function<Aggregate, String> getIdFromAggregate;

    public AlreadyHasMany(List<Aggregate> aggregates, Function<Aggregate, String> getIdFromAggregate) {
        this.aggregates = aggregates;
        this.getIdFromAggregate = getIdFromAggregate;
    }

    @Override
    public Optional<Aggregate> findOne(String id) {
        return aggregates.stream().filter(aggregate -> getIdFromAggregate.apply(aggregate).equals(id)).findFirst();
    }

    public void add(Aggregate aggregate) {
        this.aggregates.add(aggregate);
    }

    public void remove(String id) {
        this.aggregates.removeIf(o -> getIdFromAggregate.apply(o).equals(id));
    }

    public List<String> ids() {
        return this.aggregates.parallelStream().map(getIdFromAggregate).collect(Collectors.toList());
    }

    @Override
    public List<Aggregate> getAll() {
        return this.aggregates;
    }

}
