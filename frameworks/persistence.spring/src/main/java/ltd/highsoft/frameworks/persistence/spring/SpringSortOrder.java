package ltd.highsoft.frameworks.persistence.spring;

import lombok.*;
import ltd.highsoft.frameworks.domain.core.*;
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

    @Override
    public SortDirection direction() {
        return asSortDirection(impl.getDirection());
    }

    private SortDirection asSortDirection(Sort.Direction direction) {
        if (Sort.Direction.DESC.equals(direction)) return SortDirection.DESC;
        return SortDirection.ASC;
    }

}
