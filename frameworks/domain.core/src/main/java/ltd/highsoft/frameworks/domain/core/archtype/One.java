package ltd.highsoft.frameworks.domain.core.archtype;

public interface One<Aggregate extends ltd.highsoft.frameworks.domain.core.archtype.Aggregate> {

    Aggregate get();

    void add(Aggregate aggregate);

    void callOff();

}
