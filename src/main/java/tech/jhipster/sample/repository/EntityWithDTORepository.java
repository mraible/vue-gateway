package tech.jhipster.sample.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.EntityWithDTO;

/**
 * Spring Data SQL reactive repository for the EntityWithDTO entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EntityWithDTORepository extends R2dbcRepository<EntityWithDTO, Long>, EntityWithDTORepositoryInternal {
    // just to avoid having unambigous methods
    @Override
    Flux<EntityWithDTO> findAll();

    @Override
    Mono<EntityWithDTO> findById(Long id);

    @Override
    <S extends EntityWithDTO> Mono<S> save(S entity);
}

interface EntityWithDTORepositoryInternal {
    <S extends EntityWithDTO> Mono<S> insert(S entity);
    <S extends EntityWithDTO> Mono<S> save(S entity);
    Mono<Integer> update(EntityWithDTO entity);

    Flux<EntityWithDTO> findAll();
    Mono<EntityWithDTO> findById(Long id);
    Flux<EntityWithDTO> findAllBy(Pageable pageable);
    Flux<EntityWithDTO> findAllBy(Pageable pageable, Criteria criteria);
}
