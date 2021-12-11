package tech.jhipster.sample.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.FieldTestServiceImplEntity;

/**
 * Spring Data SQL reactive repository for the FieldTestServiceImplEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FieldTestServiceImplEntityRepository
    extends R2dbcRepository<FieldTestServiceImplEntity, Long>, FieldTestServiceImplEntityRepositoryInternal {
    // just to avoid having unambigous methods
    @Override
    Flux<FieldTestServiceImplEntity> findAll();

    @Override
    Mono<FieldTestServiceImplEntity> findById(Long id);

    @Override
    <S extends FieldTestServiceImplEntity> Mono<S> save(S entity);
}

interface FieldTestServiceImplEntityRepositoryInternal {
    <S extends FieldTestServiceImplEntity> Mono<S> insert(S entity);
    <S extends FieldTestServiceImplEntity> Mono<S> save(S entity);
    Mono<Integer> update(FieldTestServiceImplEntity entity);

    Flux<FieldTestServiceImplEntity> findAll();
    Mono<FieldTestServiceImplEntity> findById(Long id);
    Flux<FieldTestServiceImplEntity> findAllBy(Pageable pageable);
    Flux<FieldTestServiceImplEntity> findAllBy(Pageable pageable, Criteria criteria);
}
