package tech.jhipster.sample.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.EntityWithPaginationAndDTO;

/**
 * Spring Data SQL reactive repository for the EntityWithPaginationAndDTO entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EntityWithPaginationAndDTORepository
    extends R2dbcRepository<EntityWithPaginationAndDTO, Long>, EntityWithPaginationAndDTORepositoryInternal {
    Flux<EntityWithPaginationAndDTO> findAllBy(Pageable pageable);

    // just to avoid having unambigous methods
    @Override
    Flux<EntityWithPaginationAndDTO> findAll();

    @Override
    Mono<EntityWithPaginationAndDTO> findById(Long id);

    @Override
    <S extends EntityWithPaginationAndDTO> Mono<S> save(S entity);
}

interface EntityWithPaginationAndDTORepositoryInternal {
    <S extends EntityWithPaginationAndDTO> Mono<S> insert(S entity);
    <S extends EntityWithPaginationAndDTO> Mono<S> save(S entity);
    Mono<Integer> update(EntityWithPaginationAndDTO entity);

    Flux<EntityWithPaginationAndDTO> findAll();
    Mono<EntityWithPaginationAndDTO> findById(Long id);
    Flux<EntityWithPaginationAndDTO> findAllBy(Pageable pageable);
    Flux<EntityWithPaginationAndDTO> findAllBy(Pageable pageable, Criteria criteria);
}
