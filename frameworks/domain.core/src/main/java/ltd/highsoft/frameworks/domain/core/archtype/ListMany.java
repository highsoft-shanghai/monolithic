package ltd.highsoft.frameworks.domain.core.archtype;

import java.util.*;

public class ListMany<Aggregate extends ltd.highsoft.frameworks.domain.core.archtype.Aggregate> implements Many<Aggregate> {

    private final List<Aggregate> aggregates;

    public ListMany(List<Aggregate> aggregates) {
        this.aggregates = aggregates;
    }

    @Override
    public Optional<Aggregate> findOne(String id) {
        return aggregates.stream().filter(aggregate -> aggregate.id().equals(id)).findFirst();
    }

    @Override
    public List<Aggregate> findAll() {
        return this.aggregates;
    }

    @Override
    public Iterator<Aggregate> iterator() {
        return aggregates.iterator();
    }

}
