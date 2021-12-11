package tech.jhipster.sample.repository;

import static org.springframework.data.relational.core.query.Criteria.where;
import static org.springframework.data.relational.core.query.Query.query;

import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.UUID;
import java.util.function.BiFunction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Select;
import org.springframework.data.relational.core.sql.SelectBuilder.SelectFromAndJoin;
import org.springframework.data.relational.core.sql.Table;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.r2dbc.core.RowsFetchSpec;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.FieldTestEntity;
import tech.jhipster.sample.domain.enumeration.EnumFieldClass;
import tech.jhipster.sample.domain.enumeration.EnumRequiredFieldClass;
import tech.jhipster.sample.repository.rowmapper.FieldTestEntityRowMapper;
import tech.jhipster.sample.service.EntityManager;

/**
 * Spring Data SQL reactive custom repository implementation for the FieldTestEntity entity.
 */
@SuppressWarnings("unused")
class FieldTestEntityRepositoryInternalImpl implements FieldTestEntityRepositoryInternal {

    private final DatabaseClient db;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;
    private final EntityManager entityManager;

    private final FieldTestEntityRowMapper fieldtestentityMapper;

    private static final Table entityTable = Table.aliased("field_test_entity", EntityManager.ENTITY_ALIAS);

    public FieldTestEntityRepositoryInternalImpl(
        R2dbcEntityTemplate template,
        EntityManager entityManager,
        FieldTestEntityRowMapper fieldtestentityMapper
    ) {
        this.db = template.getDatabaseClient();
        this.r2dbcEntityTemplate = template;
        this.entityManager = entityManager;
        this.fieldtestentityMapper = fieldtestentityMapper;
    }

    @Override
    public Flux<FieldTestEntity> findAllBy(Pageable pageable) {
        return findAllBy(pageable, null);
    }

    @Override
    public Flux<FieldTestEntity> findAllBy(Pageable pageable, Criteria criteria) {
        return createQuery(pageable, criteria).all();
    }

    RowsFetchSpec<FieldTestEntity> createQuery(Pageable pageable, Criteria criteria) {
        List<Expression> columns = FieldTestEntitySqlHelper.getColumns(entityTable, EntityManager.ENTITY_ALIAS);
        SelectFromAndJoin selectFrom = Select.builder().select(columns).from(entityTable);

        String select = entityManager.createSelect(selectFrom, FieldTestEntity.class, pageable, criteria);
        String alias = entityTable.getReferenceName().getReference();
        String selectWhere = Optional
            .ofNullable(criteria)
            .map(crit ->
                new StringBuilder(select)
                    .append(" ")
                    .append("WHERE")
                    .append(" ")
                    .append(alias)
                    .append(".")
                    .append(crit.toString())
                    .toString()
            )
            .orElse(select); // TODO remove once https://github.com/spring-projects/spring-data-jdbc/issues/907 will be fixed
        return db.sql(selectWhere).map(this::process);
    }

    @Override
    public Flux<FieldTestEntity> findAll() {
        return findAllBy(null, null);
    }

    @Override
    public Mono<FieldTestEntity> findById(Long id) {
        return createQuery(null, where("id").is(id)).one();
    }

    private FieldTestEntity process(Row row, RowMetadata metadata) {
        FieldTestEntity entity = fieldtestentityMapper.apply(row, "e");
        return entity;
    }

    @Override
    public <S extends FieldTestEntity> Mono<S> insert(S entity) {
        return entityManager.insert(entity);
    }

    @Override
    public <S extends FieldTestEntity> Mono<S> save(S entity) {
        if (entity.getId() == null) {
            return insert(entity);
        } else {
            return update(entity)
                .map(numberOfUpdates -> {
                    if (numberOfUpdates.intValue() <= 0) {
                        throw new IllegalStateException("Unable to update FieldTestEntity with id = " + entity.getId());
                    }
                    return entity;
                });
        }
    }

    @Override
    public Mono<Integer> update(FieldTestEntity entity) {
        //fixme is this the proper way?
        return r2dbcEntityTemplate.update(entity).thenReturn(1);
    }
}
