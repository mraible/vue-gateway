package tech.jhipster.sample.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.FieldTestEnumWithValue;

/**
 * Spring Data SQL reactive repository for the FieldTestEnumWithValue entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FieldTestEnumWithValueRepository
    extends R2dbcRepository<FieldTestEnumWithValue, Long>, FieldTestEnumWithValueRepositoryInternal {
    // just to avoid having unambigous methods
    @Override
    Flux<FieldTestEnumWithValue> findAll();

    @Override
    Mono<FieldTestEnumWithValue> findById(Long id);

    @Override
    <S extends FieldTestEnumWithValue> Mono<S> save(S entity);
}

interface FieldTestEnumWithValueRepositoryInternal {
    <S extends FieldTestEnumWithValue> Mono<S> insert(S entity);
    <S extends FieldTestEnumWithValue> Mono<S> save(S entity);
    Mono<Integer> update(FieldTestEnumWithValue entity);

    Flux<FieldTestEnumWithValue> findAll();
    Mono<FieldTestEnumWithValue> findById(Long id);
    Flux<FieldTestEnumWithValue> findAllBy(Pageable pageable);
    Flux<FieldTestEnumWithValue> findAllBy(Pageable pageable, Criteria criteria);
}
