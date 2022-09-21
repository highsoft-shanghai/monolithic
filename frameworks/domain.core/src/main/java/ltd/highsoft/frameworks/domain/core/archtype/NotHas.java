package ltd.highsoft.frameworks.domain.core.archtype;

public class NotHas<Aggregate extends ltd.highsoft.frameworks.domain.core.archtype.Aggregate> implements One<Aggregate> {

    private String id;
    private final Aggregates<Aggregate> aggregates;

    public NotHas(String id, Aggregates<Aggregate> aggregates) {
        this.id = id;
        this.aggregates = aggregates;
    }

    @Override
    public Aggregate get() {
        return aggregates.get(id);
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public void add(Aggregate aggregate) {
        this.id = aggregate.id();
    }

    @Override
    public void callOff() {
        this.id = null;
    }

}
