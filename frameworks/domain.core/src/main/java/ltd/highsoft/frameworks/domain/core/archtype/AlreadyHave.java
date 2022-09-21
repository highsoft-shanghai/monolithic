package ltd.highsoft.frameworks.domain.core.archtype;

import java.util.*;

public class AlreadyHave<Aggregate extends ltd.highsoft.frameworks.domain.core.archtype.Aggregate> implements Many<Aggregate> {

    private final List<Aggregate> aggregates;

    public AlreadyHave(List<Aggregate> aggregates) {
        this.aggregates = aggregates;
    }

    @Override
    public Optional<Aggregate> findOne(String id) {
        return aggregates.stream().filter(aggregate -> aggregate.id().equals(id)).findFirst();
    }

    public void add(Aggregate aggregate) {
        this.aggregates.add(aggregate);
    }

    @Override
    public void remove(String id) {
        this.aggregates.removeIf(o -> o.id().equals(id));
    }

    @Override
    public List<Aggregate> getAll() {
        return this.aggregates;
    }

}
