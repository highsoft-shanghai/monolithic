package ltd.highsoft.frameworks.domain.core;


public class FixedIdGenerator implements IdGenerator {

    private final String id;

    public FixedIdGenerator(String id) {
        this.id = id;
    }

    @Override
    public String nextId() {
        return nextReadableId();
    }

    @Override
    public String nextReadableId() {
        return id;
    }

}
