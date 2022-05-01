package ltd.highsoft.frameworks.persistence.spring;

import lombok.*;
import ltd.highsoft.frameworks.domain.core.SortOrder;
import org.springframework.data.domain.Sort;

@ToString
@EqualsAndHashCode
public class SpringSortOrder implements SortOrder {

    private final Sort.Order impl;

    public static SortOrder of(Sort.Order impl) {
        return new SpringSortOrder(impl);
    }

    protected SpringSortOrder(Sort.Order impl) {
        this.impl = impl;
    }

    @Override
    public String property() {
        return impl.getProperty();
    }

}
