package tech.jhipster.sample.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.EntityWithServiceClassPaginationAndDTO;

/**
 * Spring Data SQL reactive repository for the EntityWithServiceClassPaginationAndDTO entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EntityWithServiceClassPaginationAndDTORepository
    extends R2dbcRepository<EntityWithServiceClassPaginationAndDTO, Long>, EntityWithServiceClassPaginationAndDTORepositoryInternal {
    Flux<EntityWithServiceClassPaginationAndDTO> findAllBy(Pageable pageable);

    // just to avoid having unambigous methods
    @Override
    Flux<EntityWithServiceClassPaginationAndDTO> findAll();

    @Override
    Mono<EntityWithServiceClassPaginationAndDTO> findById(Long id);

    @Override
    <S extends EntityWithServiceClassPaginationAndDTO> Mono<S> save(S entity);
}

interface EntityWithServiceClassPaginationAndDTORepositoryInternal {
    <S extends EntityWithServiceClassPaginationAndDTO> Mono<S> insert(S entity);
    <S extends EntityWithServiceClassPaginationAndDTO> Mono<S> save(S entity);
    Mono<Integer> update(EntityWithServiceClassPaginationAndDTO entity);

    Flux<EntityWithServiceClassPaginationAndDTO> findAll();
    Mono<EntityWithServiceClassPaginationAndDTO> findById(Long id);
    Flux<EntityWithServiceClassPaginationAndDTO> findAllBy(Pageable pageable);
    Flux<EntityWithServiceClassPaginationAndDTO> findAllBy(Pageable pageable, Criteria criteria);
}
