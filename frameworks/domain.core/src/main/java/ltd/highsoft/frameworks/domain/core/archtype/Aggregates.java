package ltd.highsoft.frameworks.domain.core.archtype;

import java.util.*;

public interface Aggregates<Aggregate extends ltd.highsoft.frameworks.domain.core.archtype.Aggregate> {

    Aggregate get(String id);

    Optional<Aggregate> getOptional(String id);

    void add(Aggregate aggregate);

    void addAll(List<Aggregate> aggregates);

    void remove(String id);

    void remove(Collection<String> ids);

    void removeAll();

    List<Aggregate> list(List<String> ids);

}
