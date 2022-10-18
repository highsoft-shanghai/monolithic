package ltd.highsoft.frameworks.domain.core;

import lombok.*;

import javax.annotation.Nullable;
import java.util.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CollectionUtils {
    public static <T> List<T> defaultList(@Nullable List<T> list) {
        return list != null ? list : Collections.emptyList();
    }


    public static boolean isEmpty(final Collection<?> coll) {
        return coll == null || coll.isEmpty();
    }

    public static boolean isNotEmpty(final Collection<?> coll) {
        return !isEmpty(coll);
    }
}
