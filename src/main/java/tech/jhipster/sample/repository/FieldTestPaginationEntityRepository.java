package tech.jhipster.sample.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.FieldTestPaginationEntity;

/**
 * Spring Data SQL reactive repository for the FieldTestPaginationEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FieldTestPaginationEntityRepository
    extends R2dbcRepository<FieldTestPaginationEntity, Long>, FieldTestPaginationEntityRepositoryInternal {
    Flux<FieldTestPaginationEntity> findAllBy(Pageable pageable);

    // just to avoid having unambigous methods
    @Override
    Flux<FieldTestPaginationEntity> findAll();

    @Override
    Mono<FieldTestPaginationEntity> findById(Long id);

    @Override
    <S extends FieldTestPaginationEntity> Mono<S> save(S entity);
}

interface FieldTestPaginationEntityRepositoryInternal {
    <S extends FieldTestPaginationEntity> Mono<S> insert(S entity);
    <S extends FieldTestPaginationEntity> Mono<S> save(S entity);
    Mono<Integer> update(FieldTestPaginationEntity entity);

    Flux<FieldTestPaginationEntity> findAll();
    Mono<FieldTestPaginationEntity> findById(Long id);
    Flux<FieldTestPaginationEntity> findAllBy(Pageable pageable);
    Flux<FieldTestPaginationEntity> findAllBy(Pageable pageable, Criteria criteria);
}
