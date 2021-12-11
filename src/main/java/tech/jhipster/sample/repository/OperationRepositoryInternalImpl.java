package tech.jhipster.sample.repository;

import static org.springframework.data.relational.core.query.Criteria.where;
import static org.springframework.data.relational.core.query.Query.query;

import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import java.math.BigDecimal;
import java.time.Instant;
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
import org.springframework.data.relational.core.sql.SelectBuilder.SelectFromAndJoinCondition;
import org.springframework.data.relational.core.sql.Table;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.r2dbc.core.RowsFetchSpec;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.Label;
import tech.jhipster.sample.domain.Operation;
import tech.jhipster.sample.repository.rowmapper.BankAccountRowMapper;
import tech.jhipster.sample.repository.rowmapper.OperationRowMapper;
import tech.jhipster.sample.service.EntityManager;
import tech.jhipster.sample.service.EntityManager.LinkTable;

/**
 * Spring Data SQL reactive custom repository implementation for the Operation entity.
 */
@SuppressWarnings("unused")
class OperationRepositoryInternalImpl implements OperationRepositoryInternal {

    private final DatabaseClient db;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;
    private final EntityManager entityManager;

    private final BankAccountRowMapper bankaccountMapper;
    private final OperationRowMapper operationMapper;

    private static final Table entityTable = Table.aliased("operation", EntityManager.ENTITY_ALIAS);
    private static final Table bankAccountTable = Table.aliased("bank_account", "bankAccount");

    private static final EntityManager.LinkTable labelLink = new LinkTable("rel_operation__label", "operation_id", "label_id");

    public OperationRepositoryInternalImpl(
        R2dbcEntityTemplate template,
        EntityManager entityManager,
        BankAccountRowMapper bankaccountMapper,
        OperationRowMapper operationMapper
    ) {
        this.db = template.getDatabaseClient();
        this.r2dbcEntityTemplate = template;
        this.entityManager = entityManager;
        this.bankaccountMapper = bankaccountMapper;
        this.operationMapper = operationMapper;
    }

    @Override
    public Flux<Operation> findAllBy(Pageable pageable) {
        return findAllBy(pageable, null);
    }

    @Override
    public Flux<Operation> findAllBy(Pageable pageable, Criteria criteria) {
        return createQuery(pageable, criteria).all();
    }

    RowsFetchSpec<Operation> createQuery(Pageable pageable, Criteria criteria) {
        List<Expression> columns = OperationSqlHelper.getColumns(entityTable, EntityManager.ENTITY_ALIAS);
        columns.addAll(BankAccountSqlHelper.getColumns(bankAccountTable, "bankAccount"));
        SelectFromAndJoinCondition selectFrom = Select
            .builder()
            .select(columns)
            .from(entityTable)
            .leftOuterJoin(bankAccountTable)
            .on(Column.create("bank_account_id", entityTable))
            .equals(Column.create("id", bankAccountTable));

        String select = entityManager.createSelect(selectFrom, Operation.class, pageable, criteria);
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
    public Flux<Operation> findAll() {
        return findAllBy(null, null);
    }

    @Override
    public Mono<Operation> findById(Long id) {
        return createQuery(null, where("id").is(id)).one();
    }

    @Override
    public Mono<Operation> findOneWithEagerRelationships(Long id) {
        return findById(id);
    }

    @Override
    public Flux<Operation> findAllWithEagerRelationships() {
        return findAll();
    }

    @Override
    public Flux<Operation> findAllWithEagerRelationships(Pageable page) {
        return findAllBy(page);
    }

    private Operation process(Row row, RowMetadata metadata) {
        Operation entity = operationMapper.apply(row, "e");
        entity.setBankAccount(bankaccountMapper.apply(row, "bankAccount"));
        return entity;
    }

    @Override
    public <S extends Operation> Mono<S> insert(S entity) {
        return entityManager.insert(entity);
    }

    @Override
    public <S extends Operation> Mono<S> save(S entity) {
        if (entity.getId() == null) {
            return insert(entity).flatMap(savedEntity -> updateRelations(savedEntity));
        } else {
            return update(entity)
                .map(numberOfUpdates -> {
                    if (numberOfUpdates.intValue() <= 0) {
                        throw new IllegalStateException("Unable to update Operation with id = " + entity.getId());
                    }
                    return entity;
                })
                .then(updateRelations(entity));
        }
    }

    @Override
    public Mono<Integer> update(Operation entity) {
        //fixme is this the proper way?
        return r2dbcEntityTemplate.update(entity).thenReturn(1);
    }

    @Override
    public Mono<Void> deleteById(Long entityId) {
        return deleteRelations(entityId)
            .then(r2dbcEntityTemplate.delete(Operation.class).matching(query(where("id").is(entityId))).all().then());
    }

    protected <S extends Operation> Mono<S> updateRelations(S entity) {
        Mono<Void> result = entityManager.updateLinkTable(labelLink, entity.getId(), entity.getLabels().stream().map(Label::getId)).then();
        return result.thenReturn(entity);
    }

    protected Mono<Void> deleteRelations(Long entityId) {
        return entityManager.deleteFromLinkTable(labelLink, entityId);
    }
}
