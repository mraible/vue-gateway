package tech.jhipster.sample.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.FieldTestMapstructAndServiceClassEntity;

/**
 * Spring Data SQL reactive repository for the FieldTestMapstructAndServiceClassEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FieldTestMapstructAndServiceClassEntityRepository
    extends R2dbcRepository<FieldTestMapstructAndServiceClassEntity, Long>, FieldTestMapstructAndServiceClassEntityRepositoryInternal {
    // just to avoid having unambigous methods
    @Override
    Flux<FieldTestMapstructAndServiceClassEntity> findAll();

    @Override
    Mono<FieldTestMapstructAndServiceClassEntity> findById(Long id);

    @Override
    <S extends FieldTestMapstructAndServiceClassEntity> Mono<S> save(S entity);
}

interface FieldTestMapstructAndServiceClassEntityRepositoryInternal {
    <S extends FieldTestMapstructAndServiceClassEntity> Mono<S> insert(S entity);
    <S extends FieldTestMapstructAndServiceClassEntity> Mono<S> save(S entity);
    Mono<Integer> update(FieldTestMapstructAndServiceClassEntity entity);

    Flux<FieldTestMapstructAndServiceClassEntity> findAll();
    Mono<FieldTestMapstructAndServiceClassEntity> findById(Long id);
    Flux<FieldTestMapstructAndServiceClassEntity> findAllBy(Pageable pageable);
    Flux<FieldTestMapstructAndServiceClassEntity> findAllBy(Pageable pageable, Criteria criteria);
}
