package ltd.highsoft.frameworks.persistence.spring;

import ltd.highsoft.frameworks.domain.core.Page;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SpringPageTest {

    @Test
    void should_be_able_to_carry_content() {
        Page<String> page = SpringPage.from(new PageImpl<>(List.of("a", "b"), Pageable.ofSize(5), 30));
        assertThat(page.content()).containsExactly("a", "b");
    }

}
