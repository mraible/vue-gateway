package tech.jhipster.sample.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.FieldTestServiceClassAndJpaFilteringEntity;

/**
 * Spring Data SQL reactive repository for the FieldTestServiceClassAndJpaFilteringEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FieldTestServiceClassAndJpaFilteringEntityRepository
    extends
        R2dbcRepository<FieldTestServiceClassAndJpaFilteringEntity, Long>, FieldTestServiceClassAndJpaFilteringEntityRepositoryInternal {
    // just to avoid having unambigous methods
    @Override
    Flux<FieldTestServiceClassAndJpaFilteringEntity> findAll();

    @Override
    Mono<FieldTestServiceClassAndJpaFilteringEntity> findById(Long id);

    @Override
    <S extends FieldTestServiceClassAndJpaFilteringEntity> Mono<S> save(S entity);
}

interface FieldTestServiceClassAndJpaFilteringEntityRepositoryInternal {
    <S extends FieldTestServiceClassAndJpaFilteringEntity> Mono<S> insert(S entity);
    <S extends FieldTestServiceClassAndJpaFilteringEntity> Mono<S> save(S entity);
    Mono<Integer> update(FieldTestServiceClassAndJpaFilteringEntity entity);

    Flux<FieldTestServiceClassAndJpaFilteringEntity> findAll();
    Mono<FieldTestServiceClassAndJpaFilteringEntity> findById(Long id);
    Flux<FieldTestServiceClassAndJpaFilteringEntity> findAllBy(Pageable pageable);
    Flux<FieldTestServiceClassAndJpaFilteringEntity> findAllBy(Pageable pageable, Criteria criteria);
}
