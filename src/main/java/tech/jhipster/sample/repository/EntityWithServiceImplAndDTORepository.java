package tech.jhipster.sample.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.EntityWithServiceImplAndDTO;

/**
 * Spring Data SQL reactive repository for the EntityWithServiceImplAndDTO entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EntityWithServiceImplAndDTORepository
    extends R2dbcRepository<EntityWithServiceImplAndDTO, Long>, EntityWithServiceImplAndDTORepositoryInternal {
    // just to avoid having unambigous methods
    @Override
    Flux<EntityWithServiceImplAndDTO> findAll();

    @Override
    Mono<EntityWithServiceImplAndDTO> findById(Long id);

    @Override
    <S extends EntityWithServiceImplAndDTO> Mono<S> save(S entity);
}

interface EntityWithServiceImplAndDTORepositoryInternal {
    <S extends EntityWithServiceImplAndDTO> Mono<S> insert(S entity);
    <S extends EntityWithServiceImplAndDTO> Mono<S> save(S entity);
    Mono<Integer> update(EntityWithServiceImplAndDTO entity);

    Flux<EntityWithServiceImplAndDTO> findAll();
    Mono<EntityWithServiceImplAndDTO> findById(Long id);
    Flux<EntityWithServiceImplAndDTO> findAllBy(Pageable pageable);
    Flux<EntityWithServiceImplAndDTO> findAllBy(Pageable pageable, Criteria criteria);
}
