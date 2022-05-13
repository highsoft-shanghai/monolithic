package ltd.highsoft.frameworks.persistence.mongo;

interface TestAggregates {

    void add(TestAggregate2 aggregate);

    void clearByName(String name);

    void clearByNameAndId(String name, String id);

    void clearByNameAndIdAndGender(String name, String id, String gender);

    TestAggregate2 getByName(String name);

    TestAggregate2 getByNameAndId(String name, String id);

    TestAggregate2 getByNameAndIdAndGender(String name, String id, String gender);

    boolean containsByName(String name);

    boolean containsByNameAndId(String name, String id);

    boolean containsByNameAndIdAndGender(String name, String id, String gender);

}
