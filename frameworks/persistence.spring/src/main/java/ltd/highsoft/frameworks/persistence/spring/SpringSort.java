package ltd.highsoft.frameworks.persistence.spring;

import lombok.*;
import ltd.highsoft.frameworks.domain.core.*;

import java.util.Iterator;

@ToString
@EqualsAndHashCode
public class SpringSort implements Sort {

    private final org.springframework.data.domain.Sort impl;

    public static Sort of(org.springframework.data.domain.Sort impl) {
        return new SpringSort(impl);
    }

    protected SpringSort(org.springframework.data.domain.Sort impl) {
        this.impl = impl;
    }

    @Override
    public Iterator<SortOrder> iterator() {
        return SpringSortOrderIterator.of(impl.iterator());
    }

}
