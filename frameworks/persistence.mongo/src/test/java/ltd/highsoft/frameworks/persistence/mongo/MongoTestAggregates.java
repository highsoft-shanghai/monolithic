package ltd.highsoft.frameworks.persistence.mongo;

final class MongoTestAggregates implements TestAggregates {

    private final MongoAggregates<TestAggregate2, TestData, TestRepository, String> aggregates;

    public MongoTestAggregates(TestRepository repository) {
        this.aggregates = new MongoAggregates<>(repository, TestData::new, TestData::asDomain);
    }

    @Override
    public void add(TestAggregate2 aggregate) {
        aggregates.acceptByAggregate(TestRepository::save, aggregate);
    }

    @Override
    public void clearByName(String name) {
        aggregates.accept(TestRepository::deleteByName, name);
    }

    @Override
    public void clearByNameAndId(String name, String id) {
        aggregates.accept(TestRepository::deleteByNameAndId, name, id);
    }

    @Override
    public void clearByNameAndIdAndGender(String name, String id, String gender) {
        aggregates.accept(TestRepository::deleteByNameAndIdAndGender, name, id, gender);
    }

    @Override
    public TestAggregate2 getByName(String name) {
        return aggregates.applyAsAggregate(TestRepository::findByName, name);
    }

    @Override
    public TestAggregate2 getByNameAndId(String name, String id) {
        return aggregates.applyAsAggregate(TestRepository::findByNameAndId, name, id);
    }

    @Override
    public TestAggregate2 getByNameAndIdAndGender(String name, String id, String gender) {
        return aggregates.applyAsAggregate(TestRepository::findByNameAndIdAndGender, name, id, gender);
    }

    @Override
    public boolean containsByName(String name) {
        return aggregates.apply(TestRepository::existsByName, name);
    }

    @Override
    public boolean containsByNameAndId(String name, String id) {
        return aggregates.apply(TestRepository::existsByNameAndId, name, id);
    }

    @Override
    public boolean containsByNameAndIdAndGender(String name, String id, String gender) {
        return aggregates.apply(TestRepository::existsByNameAndIdAndGender, name, id, gender);
    }

}
