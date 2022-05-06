package ltd.highsoft.frameworks.persistence.spring;

import ltd.highsoft.frameworks.domain.core.Sort;
import ltd.highsoft.frameworks.domain.core.*;
import org.springframework.data.domain.*;

public class SpringPagination implements Pagination {

    private final Pageable impl;

    public static Pagination of(PageRequest impl) {
        return new SpringPagination(impl);
    }

    protected SpringPagination(Pageable pageable) {
        this.impl = pageable;
    }

    @Override
    public int pageNumber() {
        return impl.getPageNumber();
    }

    @Override
    public int pageSize() {
        return impl.getPageSize();
    }

    @Override
    public Sort sort() {
        return SpringSort.of(impl.getSort());
    }

}
