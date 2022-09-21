package ltd.highsoft.frameworks.domain.core.archtype;

import java.util.*;

public interface Many<Aggregate extends ltd.highsoft.frameworks.domain.core.archtype.Aggregate> {

    Optional<Aggregate> findOne(String id);

    Collection<Aggregate> getAll();

}
