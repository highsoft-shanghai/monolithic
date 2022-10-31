package ltd.highsoft.frameworks.persistence.mongo;

import java.util.function.Function;

public class AlreadyHasOne<Aggregate> implements One<Aggregate> {

    private Aggregate aggregate;
    private final Function<Aggregate, String> getIdFromAggregate;

    public AlreadyHasOne(Aggregate aggregate, Function<Aggregate, String> getIdFromAggregate) {
        this.aggregate = aggregate;
        this.getIdFromAggregate = getIdFromAggregate;
    }

    @Override
    public Aggregate get() {
        return this.aggregate;
    }

    @Override
    public String id() {
        if (aggregate == null) return "";
        return getIdFromAggregate.apply(aggregate);
    }

    @Override
    public void add(Aggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public void callOff() {
        this.aggregate = null;
    }

}
