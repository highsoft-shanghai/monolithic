package ltd.highsoft.frameworks.domain.core;

import java.util.List;
import java.util.function.Function;

public interface Page<T> {

    List<T> content();

    long numberOfTotalElements();

    int size();

    int number();

    int numberOfElements();

    <U> Page<U> map(Function<? super T, ? extends U> converter);

}
