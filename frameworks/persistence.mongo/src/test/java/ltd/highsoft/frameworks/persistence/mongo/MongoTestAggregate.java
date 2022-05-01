package ltd.highsoft.frameworks.persistence.mongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.*;

@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document(collection = "test_documents")
public class MongoTestAggregate {

    private @Id String id;
    private @Field(name = "name") String name;

    public MongoTestAggregate(TestAggregate aggregate) {
        this.id = aggregate.id();
        this.name = aggregate.name();
    }

    public TestAggregate asDomain() {
        return new TestAggregate(id, name);
    }

}
