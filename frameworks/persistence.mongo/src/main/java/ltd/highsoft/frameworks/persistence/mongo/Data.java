package ltd.highsoft.frameworks.persistence.mongo;

public interface Data<Aggregate extends ltd.highsoft.frameworks.domain.core.fields.Aggregate> {

    Aggregate asDomain();

}
