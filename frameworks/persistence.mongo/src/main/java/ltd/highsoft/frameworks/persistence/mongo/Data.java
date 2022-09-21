package ltd.highsoft.frameworks.persistence.mongo;

import ltd.highsoft.frameworks.domain.core.fields.Aggregate;

public interface Data<A extends Aggregate> {

    A asDomain();

}
