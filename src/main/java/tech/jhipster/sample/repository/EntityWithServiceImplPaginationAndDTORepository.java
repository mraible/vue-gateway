package tech.jhipster.sample.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.EntityWithServiceImplPaginationAndDTO;

/**
 * Spring Data SQL reactive repository for the EntityWithServiceImplPaginationAndDTO entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EntityWithServiceImplPaginationAndDTORepository
    extends R2dbcRepository<EntityWithServiceImplPaginationAndDTO, Long>, EntityWithServiceImplPaginationAndDTORepositoryInternal {
    Flux<EntityWithServiceImplPaginationAndDTO> findAllBy(Pageable pageable);

    // just to avoid having unambigous methods
    @Override
    Flux<EntityWithServiceImplPaginationAndDTO> findAll();

    @Override
    Mono<EntityWithServiceImplPaginationAndDTO> findById(Long id);

    @Override
    <S extends EntityWithServiceImplPaginationAndDTO> Mono<S> save(S entity);
}

interface EntityWithServiceImplPaginationAndDTORepositoryInternal {
    <S extends EntityWithServiceImplPaginationAndDTO> Mono<S> insert(S entity);
    <S extends EntityWithServiceImplPaginationAndDTO> Mono<S> save(S entity);
    Mono<Integer> update(EntityWithServiceImplPaginationAndDTO entity);

    Flux<EntityWithServiceImplPaginationAndDTO> findAll();
    Mono<EntityWithServiceImplPaginationAndDTO> findById(Long id);
    Flux<EntityWithServiceImplPaginationAndDTO> findAllBy(Pageable pageable);
    Flux<EntityWithServiceImplPaginationAndDTO> findAllBy(Pageable pageable, Criteria criteria);
}
