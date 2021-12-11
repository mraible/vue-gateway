package tech.jhipster.sample.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.FieldTestInfiniteScrollEntity;

/**
 * Spring Data SQL reactive repository for the FieldTestInfiniteScrollEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FieldTestInfiniteScrollEntityRepository
    extends R2dbcRepository<FieldTestInfiniteScrollEntity, Long>, FieldTestInfiniteScrollEntityRepositoryInternal {
    Flux<FieldTestInfiniteScrollEntity> findAllBy(Pageable pageable);

    // just to avoid having unambigous methods
    @Override
    Flux<FieldTestInfiniteScrollEntity> findAll();

    @Override
    Mono<FieldTestInfiniteScrollEntity> findById(Long id);

    @Override
    <S extends FieldTestInfiniteScrollEntity> Mono<S> save(S entity);
}

interface FieldTestInfiniteScrollEntityRepositoryInternal {
    <S extends FieldTestInfiniteScrollEntity> Mono<S> insert(S entity);
    <S extends FieldTestInfiniteScrollEntity> Mono<S> save(S entity);
    Mono<Integer> update(FieldTestInfiniteScrollEntity entity);

    Flux<FieldTestInfiniteScrollEntity> findAll();
    Mono<FieldTestInfiniteScrollEntity> findById(Long id);
    Flux<FieldTestInfiniteScrollEntity> findAllBy(Pageable pageable);
    Flux<FieldTestInfiniteScrollEntity> findAllBy(Pageable pageable, Criteria criteria);
}
