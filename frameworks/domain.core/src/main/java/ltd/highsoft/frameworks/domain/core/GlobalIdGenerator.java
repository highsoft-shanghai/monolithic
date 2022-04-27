package ltd.highsoft.frameworks.domain.core;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalIdGenerator {

    private static final ThreadLocal<IdGenerator> GENERATOR = new ThreadLocal<>();

    public static String nextId() {
        return generator().nextId();
    }

    public static String nextReadableId() {
        return generator().nextReadableId();
    }

    static void reset(IdGenerator idGenerator) {
        GENERATOR.set(idGenerator);
    }

    private static IdGenerator generator() {
        return GENERATOR.get();
    }

}
