package ltd.highsoft.frameworks.persistence.mongo;

import org.springframework.data.repository.Repository;

public final class AggregatesFunctions {
    private AggregatesFunctions() {
    }

    public interface Function1<D, ID, R extends Repository<D, ID>, P1, E> {
        E apply(R repo, P1 p1);
    }

    public interface Function2<D, ID, R extends Repository<D, ID>, P1, P2, E> {
        E apply(R repo, P1 p1, P2 p2);
    }

    public interface Function3<D, ID, R extends Repository<D, ID>, P1, P2, P3, E> {
        E apply(R repo, P1 p1, P2 p2, P3 p3);
    }
}
