package ltd.highsoft.frameworks.test.mongo;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Sort;

import static org.assertj.core.api.Assertions.assertThat;

class GeneralCriteriaTest {

    @Test
    void should_be_able_to_access_field_name() {
        assertThat(GeneralCriteria.FieldName.CREATED_AT).isNotNull();
        assertThat(GeneralCriteria.FieldName.ID).isNotNull();
    }

    @Test
    void should_use_desc_by_id() {
        assertThat(GeneralCriteria.descById()).isEqualTo(Sort.Order.desc(GeneralCriteria.FieldName.ID));
    }

    @Test
    void should_use_desc_by_created_at() {
        assertThat(GeneralCriteria.descByCreatedAt()).isEqualTo(Sort.Order.desc(GeneralCriteria.FieldName.CREATED_AT));
    }

    @Test
    void should_use_desc_by_updated_at() {
        assertThat(GeneralCriteria.descByUpdatedAt()).isEqualTo(Sort.Order.desc(GeneralCriteria.FieldName.UPDATED_AT));
    }

}
