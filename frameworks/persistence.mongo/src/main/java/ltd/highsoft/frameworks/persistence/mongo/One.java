package ltd.highsoft.frameworks.persistence.mongo;

public interface One<Aggregate> {

    Aggregate get();

    String id();

    void add(Aggregate aggregate);

    void callOff();

}
