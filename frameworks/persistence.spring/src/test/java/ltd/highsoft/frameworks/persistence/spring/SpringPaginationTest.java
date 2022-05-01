package ltd.highsoft.frameworks.persistence.spring;

import ltd.highsoft.frameworks.domain.core.Pagination;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;

import static org.assertj.core.api.Assertions.assertThat;

class SpringPaginationTest {

    @Test
    void should_be_able_to_carry_page_number() {
        Pagination pagination = SpringPagination.of(PageRequest.of(3, 10));
        assertThat(pagination.pageNumber()).isEqualTo(3);
    }

}
