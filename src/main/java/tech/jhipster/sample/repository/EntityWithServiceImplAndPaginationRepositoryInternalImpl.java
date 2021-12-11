package tech.jhipster.sample.repository;

import static org.springframework.data.relational.core.query.Criteria.where;
import static org.springframework.data.relational.core.query.Query.query;

import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
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
import tech.jhipster.sample.domain.EntityWithServiceImplAndPagination;
import tech.jhipster.sample.repository.rowmapper.EntityWithServiceImplAndPaginationRowMapper;
import tech.jhipster.sample.service.EntityManager;

/**
 * Spring Data SQL reactive custom repository implementation for the EntityWithServiceImplAndPagination entity.
 */
@SuppressWarnings("unused")
class EntityWithServiceImplAndPaginationRepositoryInternalImpl implements EntityWithServiceImplAndPaginationRepositoryInternal {

    private final DatabaseClient db;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;
    private final EntityManager entityManager;

    private final EntityWithServiceImplAndPaginationRowMapper entitywithserviceimplandpaginationMapper;

    private static final Table entityTable = Table.aliased("entity_with_service_impl_and_pagination", EntityManager.ENTITY_ALIAS);

    public EntityWithServiceImplAndPaginationRepositoryInternalImpl(
        R2dbcEntityTemplate template,
        EntityManager entityManager,
        EntityWithServiceImplAndPaginationRowMapper entitywithserviceimplandpaginationMapper
    ) {
        this.db = template.getDatabaseClient();
        this.r2dbcEntityTemplate = template;
        this.entityManager = entityManager;
        this.entitywithserviceimplandpaginationMapper = entitywithserviceimplandpaginationMapper;
    }

    @Override
    public Flux<EntityWithServiceImplAndPagination> findAllBy(Pageable pageable) {
        return findAllBy(pageable, null);
    }

    @Override
    public Flux<EntityWithServiceImplAndPagination> findAllBy(Pageable pageable, Criteria criteria) {
        return createQuery(pageable, criteria).all();
    }

    RowsFetchSpec<EntityWithServiceImplAndPagination> createQuery(Pageable pageable, Criteria criteria) {
        List<Expression> columns = EntityWithServiceImplAndPaginationSqlHelper.getColumns(entityTable, EntityManager.ENTITY_ALIAS);
        SelectFromAndJoin selectFrom = Select.builder().select(columns).from(entityTable);

        String select = entityManager.createSelect(selectFrom, EntityWithServiceImplAndPagination.class, pageable, criteria);
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
    public Flux<EntityWithServiceImplAndPagination> findAll() {
        return findAllBy(null, null);
    }

    @Override
    public Mono<EntityWithServiceImplAndPagination> findById(Long id) {
        return createQuery(null, where("id").is(id)).one();
    }

    private EntityWithServiceImplAndPagination process(Row row, RowMetadata metadata) {
        EntityWithServiceImplAndPagination entity = entitywithserviceimplandpaginationMapper.apply(row, "e");
        return entity;
    }

    @Override
    public <S extends EntityWithServiceImplAndPagination> Mono<S> insert(S entity) {
        return entityManager.insert(entity);
    }

    @Override
    public <S extends EntityWithServiceImplAndPagination> Mono<S> save(S entity) {
        if (entity.getId() == null) {
            return insert(entity);
        } else {
            return update(entity)
                .map(numberOfUpdates -> {
                    if (numberOfUpdates.intValue() <= 0) {
                        throw new IllegalStateException("Unable to update EntityWithServiceImplAndPagination with id = " + entity.getId());
                    }
                    return entity;
                });
        }
    }

    @Override
    public Mono<Integer> update(EntityWithServiceImplAndPagination entity) {
        //fixme is this the proper way?
        return r2dbcEntityTemplate.update(entity).thenReturn(1);
    }
}
