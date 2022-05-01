package ltd.highsoft.frameworks.persistence.spring;

import ltd.highsoft.frameworks.domain.core.Pagination;
import org.springframework.data.domain.Pageable;

public class SpringPagination implements Pagination {

    private final Pageable impl;

    public SpringPagination(Pageable pageable) {
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

}
