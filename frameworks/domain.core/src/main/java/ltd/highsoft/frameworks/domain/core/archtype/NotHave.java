package ltd.highsoft.frameworks.domain.core.archtype;

import java.util.*;

public class NotHave<Aggregate extends ltd.highsoft.frameworks.domain.core.archtype.Aggregate> implements Many<Aggregate> {

    private final List<String> ids;
    private final Aggregates<Aggregate> aggregates;

    public NotHave(List<String> ids, Aggregates<Aggregate> aggregates) {
        this.ids = ids;
        this.aggregates = aggregates;
    }

    @Override
    public Optional<Aggregate> findOne(String id) {
        if (!ids.contains(id)) return Optional.empty();
        return aggregates.getOptional(id);
    }

    @Override
    public List<Aggregate> getAll() {
        return aggregates.list(this.ids);
    }

    public void add(String id) {
        this.ids.add(id);
    }

    @Override
    public void remove(String id) {
        this.ids.remove(id);
    }

    public List<String> ids() {
        return this.ids;
    }

}
