package ltd.highsoft.frameworks.persistence.mongo;

import org.springframework.data.repository.Repository;

public final class AggregatesConsumers {
    private AggregatesConsumers() {
    }

    public interface Consumer1<D, ID, R extends Repository<D, ID>, P1> {
        void accept(R repo, P1 p1);
    }

    public interface Consumer2<D, ID, R extends Repository<D, ID>, P1, P2> {
        void accept(R repo, P1 p1, P2 p2);
    }

    public interface Consumer3<D, ID, R extends Repository<D, ID>, P1, P2, P3> {
        void accept(R repo, P1 p1, P2 p2, P3 p3);
    }
}
