package tech.jhipster.sample.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.EntityWithServiceClassAndPagination;

/**
 * Spring Data SQL reactive repository for the EntityWithServiceClassAndPagination entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EntityWithServiceClassAndPaginationRepository
    extends R2dbcRepository<EntityWithServiceClassAndPagination, Long>, EntityWithServiceClassAndPaginationRepositoryInternal {
    Flux<EntityWithServiceClassAndPagination> findAllBy(Pageable pageable);

    // just to avoid having unambigous methods
    @Override
    Flux<EntityWithServiceClassAndPagination> findAll();

    @Override
    Mono<EntityWithServiceClassAndPagination> findById(Long id);

    @Override
    <S extends EntityWithServiceClassAndPagination> Mono<S> save(S entity);
}

interface EntityWithServiceClassAndPaginationRepositoryInternal {
    <S extends EntityWithServiceClassAndPagination> Mono<S> insert(S entity);
    <S extends EntityWithServiceClassAndPagination> Mono<S> save(S entity);
    Mono<Integer> update(EntityWithServiceClassAndPagination entity);

    Flux<EntityWithServiceClassAndPagination> findAll();
    Mono<EntityWithServiceClassAndPagination> findById(Long id);
    Flux<EntityWithServiceClassAndPagination> findAllBy(Pageable pageable);
    Flux<EntityWithServiceClassAndPagination> findAllBy(Pageable pageable, Criteria criteria);
}
