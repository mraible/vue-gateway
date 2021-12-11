package tech.jhipster.sample.repository;

import static org.springframework.data.relational.core.query.Criteria.where;
import static org.springframework.data.relational.core.query.Query.query;

import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
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
import tech.jhipster.sample.domain.MapsIdUserProfileWithDTO;
import tech.jhipster.sample.repository.rowmapper.MapsIdUserProfileWithDTORowMapper;
import tech.jhipster.sample.repository.rowmapper.UserRowMapper;
import tech.jhipster.sample.service.EntityManager;

/**
 * Spring Data SQL reactive custom repository implementation for the MapsIdUserProfileWithDTO entity.
 */
@SuppressWarnings("unused")
class MapsIdUserProfileWithDTORepositoryInternalImpl implements MapsIdUserProfileWithDTORepositoryInternal {

    private final DatabaseClient db;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;
    private final EntityManager entityManager;

    private final UserRowMapper userMapper;
    private final MapsIdUserProfileWithDTORowMapper mapsiduserprofilewithdtoMapper;

    private static final Table entityTable = Table.aliased("maps_id_user_profile_withdto", EntityManager.ENTITY_ALIAS);
    private static final Table userTable = Table.aliased("_user", "e_user");

    public MapsIdUserProfileWithDTORepositoryInternalImpl(
        R2dbcEntityTemplate template,
        EntityManager entityManager,
        UserRowMapper userMapper,
        MapsIdUserProfileWithDTORowMapper mapsiduserprofilewithdtoMapper
    ) {
        this.db = template.getDatabaseClient();
        this.r2dbcEntityTemplate = template;
        this.entityManager = entityManager;
        this.userMapper = userMapper;
        this.mapsiduserprofilewithdtoMapper = mapsiduserprofilewithdtoMapper;
    }

    @Override
    public Flux<MapsIdUserProfileWithDTO> findAllBy(Pageable pageable) {
        return findAllBy(pageable, null);
    }

    @Override
    public Flux<MapsIdUserProfileWithDTO> findAllBy(Pageable pageable, Criteria criteria) {
        return createQuery(pageable, criteria).all();
    }

    RowsFetchSpec<MapsIdUserProfileWithDTO> createQuery(Pageable pageable, Criteria criteria) {
        List<Expression> columns = MapsIdUserProfileWithDTOSqlHelper.getColumns(entityTable, EntityManager.ENTITY_ALIAS);
        columns.addAll(UserSqlHelper.getColumns(userTable, "user"));
        SelectFromAndJoinCondition selectFrom = Select
            .builder()
            .select(columns)
            .from(entityTable)
            .leftOuterJoin(userTable)
            .on(Column.create("id", entityTable))
            .equals(Column.create("id", userTable));

        String select = entityManager.createSelect(selectFrom, MapsIdUserProfileWithDTO.class, pageable, criteria);
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
    public Flux<MapsIdUserProfileWithDTO> findAll() {
        return findAllBy(null, null);
    }

    @Override
    public Mono<MapsIdUserProfileWithDTO> findById(Long id) {
        return createQuery(null, where("id").is(id)).one();
    }

    private MapsIdUserProfileWithDTO process(Row row, RowMetadata metadata) {
        MapsIdUserProfileWithDTO entity = mapsiduserprofilewithdtoMapper.apply(row, "e");
        entity.setUser(userMapper.apply(row, "user"));
        return entity;
    }

    @Override
    public <S extends MapsIdUserProfileWithDTO> Mono<S> insert(S entity) {
        return entityManager.insert(entity);
    }

    @Override
    public <S extends MapsIdUserProfileWithDTO> Mono<S> save(S entity) {
        if (entity.getId() == null) {
            entity.setId(entity.getUser().getId());
            return insert(entity);
        } else {
            return update(entity)
                .map(numberOfUpdates -> {
                    if (numberOfUpdates.intValue() <= 0) {
                        throw new IllegalStateException("Unable to update MapsIdUserProfileWithDTO with id = " + entity.getId());
                    }
                    return entity;
                });
        }
    }

    @Override
    public Mono<Integer> update(MapsIdUserProfileWithDTO entity) {
        //fixme is this the proper way?
        return r2dbcEntityTemplate.update(entity).thenReturn(1);
    }
}
