package ltd.highsoft.frameworks.persistence.mongo;

import java.util.*;

public interface Many<Aggregate> {

    Optional<Aggregate> findOne(String id);

    Collection<Aggregate> getAll();

}
