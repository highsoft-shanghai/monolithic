package ltd.highsoft.frameworks.persistence.mongo;

import ltd.highsoft.frameworks.persistence.mongo.AggregatesConsumers.*;
import ltd.highsoft.frameworks.persistence.mongo.AggregatesFunctions.*;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.function.Function;

public class MongoAggregates<A, D, R extends Repository<D, ID>, ID> {

    private final R repository;
    private final Function<A, D> asData;
    private final Function<D, A> asDomain;

    public MongoAggregates(R repository, Function<A, D> asData, Function<D, A> asDomain) {
        this.repository = repository;
        this.asData = asData;
        this.asDomain = asDomain;
    }

    public void acceptByAggregate(Consumer1<D, ID, R, D> consumer, A aggregate) {
        this.accept(consumer, asData.apply(aggregate));
    }

    public <P> void accept(Consumer1<D, ID, R, P> consumer, P param) {
        consumer.accept(repository, param);
    }

    public <P1, P2> void accept(Consumer2<D, ID, R, P1, P2> consumer, P1 param1, P2 param2) {
        consumer.accept(repository, param1, param2);
    }

    public <P1, P2, P3> void accept(Consumer3<D, ID, R, P1, P2, P3> consumer, P1 param1, P2 param2, P3 param3) {
        consumer.accept(repository, param1, param2, param3);
    }

    public <P> A applyAsAggregate(Function1<D, ID, R, P, D> function, P param) {
        return asDomain.apply(ensureExistence(apply(function, param)));
    }

    public <P1, P2> A applyAsAggregate(Function2<D, ID, R, P1, P2, D> function, P1 param1, P2 param2) {
        return asDomain.apply(ensureExistence(apply(function, param1, param2)));
    }

    public <P1, P2, P3> A applyAsAggregate(Function3<D, ID, R, P1, P2, P3, D> function, P1 param1, P2 param2, P3 param3) {
        return asDomain.apply(ensureExistence(apply(function, param1, param2, param3)));
    }

    public <P, E> E apply(Function1<D, ID, R, P, E> function, P param) {
        return function.apply(repository, param);
    }

    public <P1, P2, E> E apply(Function2<D, ID, R, P1, P2, E> function, P1 param1, P2 param2) {
        return function.apply(repository, param1, param2);
    }

    public <P1, P2, P3, E> E apply(Function3<D, ID, R, P1, P2, P3, E> function, P1 param1, P2 param2, P3 param3) {
        return function.apply(repository, param1, param2, param3);
    }

    private D ensureExistence(D data) {
        return Optional.ofNullable(data).orElseThrow(() -> new RuntimeException("error.can-not-get-aggregate"));
    }

}
