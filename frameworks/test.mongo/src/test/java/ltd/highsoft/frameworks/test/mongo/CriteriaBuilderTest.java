package ltd.highsoft.frameworks.test.mongo;

import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.query.*;

import java.time.Instant;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.collect.Lists.newArrayList;
import static ltd.highsoft.frameworks.test.mongo.CriteriaBuilder.criteriaBuilder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.data.mongodb.core.query.Criteria.where;

class CriteriaBuilderTest {

    @Test
    void should_be_able_to_build_criteria_chain() {
        Criteria criteria = criteriaBuilder().contains("name", "a").build().get(0);
        assertThat(new Query(criteria)).isEqualTo(new Query(where("name").regex(".*a.*")));

        Criteria criteria2 = criteriaBuilder().startWith("name", "a").build().get(0);
        assertThat(new Query(criteria2)).isEqualTo(new Query(where("name").regex("^a.*")));

        Criteria criteria3 = criteriaBuilder().endWith("name", "a").build().get(0);
        assertThat(new Query(criteria3)).isEqualTo(new Query(where("name").regex(".*a$")));

        Criteria criteria4 = criteriaBuilder().in("name", newArrayList("a", "b")).build().get(0);
        assertThat(new Query(criteria4)).isEqualTo(new Query(where("name").in(newArrayList("a", "b"))));

        Criteria criteria5 = criteriaBuilder().inIfNotEmpty("name", newArrayList("a", "b")).build().get(0);
        assertThat(new Query(criteria5)).isEqualTo(new Query(where("name").in(newArrayList("a", "b"))));

        assertThat(criteriaBuilder().containsIfNotBlank("name", "").build()).isEmpty();

        Criteria criteria23 = criteriaBuilder().containsIfNotBlank("name", "123").build().get(0);
        assertThat(new Query(criteria23)).isEqualTo(new Query(where("name").regex(String.format(".*%s.*", "123"))));

        Criteria criteria24 = criteriaBuilder().containsCaseInsensitiveIfNotBlank("name", "123").build().get(0);
        assertThat(new Query(criteria24)).isEqualTo(new Query(where("name").regex(Pattern.compile(String.format(".*%s.*", "123"), Pattern.CASE_INSENSITIVE))));

        assertThat(criteriaBuilder().containsCaseInsensitiveIfNotBlank("name", "").build()).isEmpty();

        Criteria criteria15 = criteriaBuilder().notInIfNotEmpty("name", newArrayList("a", "b")).build().get(0);
        assertThat(new Query(criteria15)).isEqualTo(new Query(where("name").nin(newArrayList("a", "b"))));

        assertThat(criteriaBuilder().notInIfNotEmpty("name", newArrayList()).build()).isEmpty();

        List<Criteria> list = criteriaBuilder().inIfNotEmpty("name", newArrayList()).build();
        assertThat(list).isEmpty();

        Criteria criteria6 = criteriaBuilder().lt("name", 1).build().get(0);
        assertThat(new Query(criteria6)).isEqualTo(new Query(where("name").lt(1)));

        Criteria criteria7 = criteriaBuilder().gt("name", 1).build().get(0);
        assertThat(new Query(criteria7)).isEqualTo(new Query(where("name").gt(1)));

        Criteria criteria18 = criteriaBuilder().gte("name", 1).build().get(0);
        assertThat(new Query(criteria18)).isEqualTo(new Query(where("name").gte(1)));

        Criteria criteria8 = criteriaBuilder().eq("name", "a").build().get(0);
        assertThat(new Query(criteria8)).isEqualTo(new Query(where("name").is("a")));

        Instant startTime = Instant.now();
        Instant endTime = Instant.now().plusSeconds(3);
        Criteria criteria9 = criteriaBuilder().between("date", startTime, null).build().get(0);

        assertThat(new Query(criteria9)).isEqualTo(new Query(where("date").gte(startTime)));
        Criteria criteria10 = criteriaBuilder().between("date", null, endTime).build().get(0);

        assertThat(new Query(criteria10)).isEqualTo(new Query(where("date").lte(endTime)));
        assertThat(criteriaBuilder().between("date", null, null).build()).isEmpty();

        Criteria criteria11 = criteriaBuilder().eq("name", "a").eq("deleted", false).buildAnd();
        assertThat(new Query(criteria11)).isEqualTo(new Query(new Criteria().andOperator(where("name").is("a"), where("deleted").is(false))));

        Criteria criteria12 = criteriaBuilder().eq("name", "a").eq("deleted", false).buildOr();
        assertThat(new Query(criteria12)).isEqualTo(new Query(new Criteria().orOperator(where("name").is("a"), where("deleted").is(false))));

        Criteria criteria13 = criteriaBuilder().eqIfNotBlank("name", "a").build().get(0);
        assertThat(new Query(criteria13)).isEqualTo(new Query(where("name").is("a")));

        Criteria criteria14 = criteriaBuilder().eqIfNotBlank("name", "a").build().get(0);
        assertThat(new Query(criteria14)).isEqualTo(new Query(where("name").is("a")));
        List<Criteria> list2 = criteriaBuilder().eqIfNotBlank("name", null).build();
        assertThat(list2).isEmpty();

        Criteria criteria20 = criteriaBuilder().ne("name", "1").build().get(0);
        assertThat(new Query(criteria20)).isEqualTo(new Query(where("name").ne("1")));

        Criteria criteria21 = criteriaBuilder().neIfNotBlank("name", "1").build().get(0);
        assertThat(new Query(criteria21)).isEqualTo(new Query(where("name").ne("1")));

        assertThat(criteriaBuilder().neIfNotBlank("name", "").build()).isEmpty();

        assertThat(new Query(criteriaBuilder().buildAnd())).isEqualTo(new Query(new Criteria()));
        assertThat(new Query(criteriaBuilder().buildOr())).isEqualTo(new Query(new Criteria()));

        assertThat(criteriaBuilder().with(where("name").is("q")).build()).isEqualTo(newArrayList(where("name").is("q")));
        assertThat(criteriaBuilder().with(newArrayList(where("name").is("q"))).build()).isEqualTo(newArrayList(where("name").is("q")));

    }

}
