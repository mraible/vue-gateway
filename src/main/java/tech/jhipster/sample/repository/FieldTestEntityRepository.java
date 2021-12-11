package tech.jhipster.sample.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.FieldTestEntity;

/**
 * Spring Data SQL reactive repository for the FieldTestEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FieldTestEntityRepository extends R2dbcRepository<FieldTestEntity, Long>, FieldTestEntityRepositoryInternal {
    // just to avoid having unambigous methods
    @Override
    Flux<FieldTestEntity> findAll();

    @Override
    Mono<FieldTestEntity> findById(Long id);

    @Override
    <S extends FieldTestEntity> Mono<S> save(S entity);
}

interface FieldTestEntityRepositoryInternal {
    <S extends FieldTestEntity> Mono<S> insert(S entity);
    <S extends FieldTestEntity> Mono<S> save(S entity);
    Mono<Integer> update(FieldTestEntity entity);

    Flux<FieldTestEntity> findAll();
    Mono<FieldTestEntity> findById(Long id);
    Flux<FieldTestEntity> findAllBy(Pageable pageable);
    Flux<FieldTestEntity> findAllBy(Pageable pageable, Criteria criteria);
}
