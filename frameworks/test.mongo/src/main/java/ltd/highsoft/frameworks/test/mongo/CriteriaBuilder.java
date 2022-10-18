package ltd.highsoft.frameworks.test.mongo;

import ltd.highsoft.frameworks.domain.core.CollectionUtils;
import org.apache.commons.lang3.*;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.*;
import java.util.regex.Pattern;

public final class CriteriaBuilder {

    private final List<Criteria> criterias;

    private CriteriaBuilder() {
        this.criterias = new ArrayList<>();
    }

    public static CriteriaBuilder criteriaBuilder() {
        return new CriteriaBuilder();
    }

    public CriteriaBuilder contains(String fieldName, String value) {
        criterias.add(new Criteria(fieldName).regex(String.format(".*%s.*", value)));
        return this;
    }

    public CriteriaBuilder containsIfNotBlank(String fieldName, String value) {
        if (StringUtils.isNotBlank(value)) {
            criterias.add(Criteria.where(fieldName).regex(String.format(".*%s.*", value)));
        }
        return this;
    }

    public CriteriaBuilder containsCaseInsensitiveIfNotBlank(String fieldName, String value) {
        if (StringUtils.isNotBlank(value)) {
            criterias.add(Criteria.where(fieldName).regex(Pattern.compile(String.format(".*%s.*", value), Pattern.CASE_INSENSITIVE)));
        }
        return this;
    }

    public CriteriaBuilder startWith(String fieldName, String value) {
        criterias.add(Criteria.where(fieldName).regex(String.format("^%s.*", value)));
        return this;
    }

    public CriteriaBuilder endWith(String fieldName, String value) {
        criterias.add(Criteria.where(fieldName).regex(String.format(".*%s$", value)));
        return this;
    }

    public CriteriaBuilder in(String fieldName, Collection<?> values) {
        criterias.add(Criteria.where(fieldName).in(values));
        return this;
    }

    public CriteriaBuilder notInIfNotEmpty(String fieldName, Collection<?> values) {
        if (CollectionUtils.isNotEmpty(values)) {
            criterias.add(Criteria.where(fieldName).nin(values));
        }
        return this;
    }

    public CriteriaBuilder inIfNotEmpty(String fieldName, Collection<?> values) {
        if (CollectionUtils.isNotEmpty(values)) {
            criterias.add(Criteria.where(fieldName).in(values));
        }
        return this;
    }

    public CriteriaBuilder lt(String fieldName, Object value) {
        criterias.add(Criteria.where(fieldName).lt(value));
        return this;
    }

    public CriteriaBuilder gt(String fieldName, Object value) {
        criterias.add(Criteria.where(fieldName).gt(value));
        return this;
    }

    public CriteriaBuilder gte(String fieldName, Object value) {
        criterias.add(Criteria.where(fieldName).gte(value));
        return this;
    }

    public CriteriaBuilder eq(String fieldName, Object value) {
        criterias.add(new Criteria(fieldName).is(value));
        return this;
    }

    public CriteriaBuilder eqIfNotBlank(String fieldName, Object value) {
        if (ObjectUtils.isNotEmpty(value)) {
            criterias.add(new Criteria(fieldName).is(value));
        }
        return this;
    }

    public CriteriaBuilder ne(String fieldName, Object value) {
        criterias.add(new Criteria(fieldName).ne(value));
        return this;
    }

    public CriteriaBuilder neIfNotBlank(String fieldName, Object value) {
        if (ObjectUtils.isNotEmpty(value)) {
            criterias.add(new Criteria(fieldName).ne(value));
        }
        return this;
    }

    public CriteriaBuilder between(String fieldName, Object start, Object end) {
        if (start != null || end != null) {
            Criteria createdDateCriteria = new Criteria(fieldName);
            Optional.ofNullable(start).ifPresent(instant -> createdDateCriteria.gte(start));
            Optional.ofNullable(end).ifPresent(instant -> createdDateCriteria.lte(end));
            criterias.add(createdDateCriteria);
        }
        return this;
    }

    public List<Criteria> build() {
        return criterias;
    }

    public Criteria buildAnd() {
        if (CollectionUtils.isNotEmpty(criterias)) {
            return new Criteria().andOperator(criterias());
        }
        return new Criteria();
    }

    public Criteria buildOr() {
        if (CollectionUtils.isNotEmpty(criterias)) {
            return new Criteria().orOperator(criterias());
        }
        return new Criteria();
    }

    public CriteriaBuilder with(Criteria criteria) {
        this.criterias.add(criteria);
        return this;
    }

    public CriteriaBuilder with(List<Criteria> criterias) {
        this.criterias.addAll(criterias);
        return this;
    }

    private Criteria[] criterias() {
        return criterias.toArray(new Criteria[0]);
    }

}
