package ltd.highsoft.frameworks.persistence.spring;

import ltd.highsoft.frameworks.domain.core.Page;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SpringPageTest {

    @Test
    void should_be_able_to_carry_content() {
        Page<String> page = SpringPage.from(new PageImpl<>(List.of("a", "b"), Pageable.ofSize(5).next().next(), 30));
        assertThat(page.content()).containsExactly("a", "b");
    }

    @Test
    void should_be_able_to_carry_number_of_elements() {
        Page<String> page = SpringPage.from(new PageImpl<>(List.of("a", "b"), Pageable.ofSize(5).next().next(), 30));
        assertThat(page.numberOfElements()).isEqualTo(2);
    }

    @Test
    void should_be_able_to_carry_page_number() {
        Page<String> page = SpringPage.from(new PageImpl<>(List.of("a", "b"), Pageable.ofSize(5).next().next(), 30));
        assertThat(page.number()).isEqualTo(2);
    }

    @Test
    void should_be_able_to_carry_page_size() {
        Page<String> page = SpringPage.from(new PageImpl<>(List.of("a", "b"), Pageable.ofSize(5).next().next(), 30));
        assertThat(page.size()).isEqualTo(5);
    }

    @Test
    void should_be_able_to_carry_total_number_of_elements() {
        Page<String> page = SpringPage.from(new PageImpl<>(List.of("a", "b"), Pageable.ofSize(5).next().next(), 30));
        assertThat(page.numberOfTotalElements()).isEqualTo(30);
    }

    @Test
    void should_be_able_to_carry_total_number_of_pages() {
        Page<String> page = SpringPage.from(new PageImpl<>(List.of("a", "b"), Pageable.ofSize(5).next().next(), 30));
        assertThat(page.numberOfTotalPages()).isEqualTo(6);
    }

    @Test
    void should_be_able_to_indicate_first_page_reached() {
        Page<String> page = SpringPage.from(new PageImpl<>(List.of("a", "b"), Pageable.ofSize(5), 30));
        assertThat(page.first()).isTrue();
    }

    @Test
    void should_be_able_to_indicate_last_page_reached() {
        Page<String> page = SpringPage.from(new PageImpl<>(List.of("a", "b"), Pageable.ofSize(5).next(), 2));
        assertThat(page.last()).isTrue();
    }

    @Test
    void should_be_able_to_map_to_others() {
        Page<String> page = SpringPage.from(new PageImpl<>(List.of("a", "b"), Pageable.ofSize(5).next().next(), 30));
        assertThat(page.map(x -> x + x).content()).containsExactly("aa", "bb");
    }

}
