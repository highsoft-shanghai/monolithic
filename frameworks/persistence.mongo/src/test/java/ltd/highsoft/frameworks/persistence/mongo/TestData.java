package ltd.highsoft.frameworks.persistence.mongo;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class TestData {

    private final String name;

    public TestData(TestAggregate2 testData) {
        this.name = testData.name();
    }

    public TestAggregate2 asDomain() {
        return new TestAggregate2(this.name);
    }

}
