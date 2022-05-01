package ltd.highsoft.frameworks.persistence.spring;

import ltd.highsoft.frameworks.domain.core.Page;
import org.junit.jupiter.api.*;
import org.springframework.data.domain.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SpringPageTest {

    private Page<String> page;

    @BeforeEach
    void setUp() {
        page = SpringPage.from(new PageImpl<>(List.of("a", "b"), Pageable.ofSize(5).next().next(), 30));
    }

    @Test
    void should_be_able_to_carry_content() {
        assertThat(page.content()).containsExactly("a", "b");
    }

    @Test
    void should_be_able_to_carry_number_of_elements() {
        assertThat(page.numberOfElements()).isEqualTo(2);
    }

    @Test
    void should_be_able_to_carry_page_number() {
        assertThat(page.number()).isEqualTo(2);
    }

    @Test
    void should_be_able_to_carry_page_size() {
        assertThat(page.size()).isEqualTo(5);
    }

    @Test
    void should_be_able_to_carry_total_number_of_elements() {
        assertThat(page.numberOfTotalElements()).isEqualTo(30);
    }

    @Test
    void should_be_able_to_carry_number_of_total_pages() {
        assertThat(page.numberOfTotalPages()).isEqualTo(6);
    }

    @Test
    void should_be_able_to_map_to_others() {
        assertThat(page.map(x -> x + x).content()).containsExactly("aa", "bb");
    }

}
