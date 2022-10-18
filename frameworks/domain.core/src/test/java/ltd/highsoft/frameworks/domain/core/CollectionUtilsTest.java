package ltd.highsoft.frameworks.domain.core;

import com.google.common.collect.ImmutableList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionUtilsTest {
    @Test
    void should_normal_input_list() {
        Assertions.assertThat(CollectionUtils.defaultList(ImmutableList.of(1))).isEqualTo(ImmutableList.of(1));
        Assertions.assertThat(CollectionUtils.defaultList(null)).isEqualTo(ImmutableList.of());
    }

    @Test
    @SuppressWarnings("all")
    public void should_be_able_to_check_empty_collection(){
        assertThat(CollectionUtils.isEmpty(null)).isEqualTo(Boolean.TRUE);
        assertThat(CollectionUtils.isEmpty(Collections.emptyList())).isEqualTo(Boolean.TRUE);
        assertThat(CollectionUtils.isEmpty(ImmutableList.of("list"))).isEqualTo(Boolean.FALSE);
    }
}
