package ltd.highsoft.frameworks.test.persistence;

import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Map;
import java.util.function.Supplier;

@SuppressWarnings("all")
public final class Persistences {

    private Persistences() {
    }

    protected static final Map<Class<?>, Supplier<Object>> PERSISTENCE_MAP = Map.of(
        MongoTemplate.class, mongo()
    );

    public static <T> T fetchByType(Class<T> clazz) {
        return (T) PERSISTENCE_MAP.get(clazz).get();
    }

    public static boolean exist(Class<?> clazz) {
        return PERSISTENCE_MAP.containsKey(clazz);
    }

    private static Supplier<Object> mongo() {
        return () -> new MongoTemplate(MongoClients.create(System.getProperty("spring.data.mongodb.uri")), "test");
    }

}
