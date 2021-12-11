package tech.jhipster.sample.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.EntityWithServiceImplAndPagination;

/**
 * Spring Data SQL reactive repository for the EntityWithServiceImplAndPagination entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EntityWithServiceImplAndPaginationRepository
    extends R2dbcRepository<EntityWithServiceImplAndPagination, Long>, EntityWithServiceImplAndPaginationRepositoryInternal {
    Flux<EntityWithServiceImplAndPagination> findAllBy(Pageable pageable);

    // just to avoid having unambigous methods
    @Override
    Flux<EntityWithServiceImplAndPagination> findAll();

    @Override
    Mono<EntityWithServiceImplAndPagination> findById(Long id);

    @Override
    <S extends EntityWithServiceImplAndPagination> Mono<S> save(S entity);
}

interface EntityWithServiceImplAndPaginationRepositoryInternal {
    <S extends EntityWithServiceImplAndPagination> Mono<S> insert(S entity);
    <S extends EntityWithServiceImplAndPagination> Mono<S> save(S entity);
    Mono<Integer> update(EntityWithServiceImplAndPagination entity);

    Flux<EntityWithServiceImplAndPagination> findAll();
    Mono<EntityWithServiceImplAndPagination> findById(Long id);
    Flux<EntityWithServiceImplAndPagination> findAllBy(Pageable pageable);
    Flux<EntityWithServiceImplAndPagination> findAllBy(Pageable pageable, Criteria criteria);
}
