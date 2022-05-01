package ltd.highsoft.frameworks.persistence.spring;

import ltd.highsoft.frameworks.domain.core.SortOrder;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Sort;

import static org.assertj.core.api.Assertions.assertThat;

class SpringSortOrderTest {

    @Test
    void should_be_able_to_carry_sort_field_name() {
        SortOrder order = SpringSortOrder.of(Sort.Order.asc("a"));
        assertThat(order.property()).isEqualTo("a");
    }

}
