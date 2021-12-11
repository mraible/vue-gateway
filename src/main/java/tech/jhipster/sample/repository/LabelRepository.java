package tech.jhipster.sample.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.Label;

/**
 * Spring Data SQL reactive repository for the Label entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LabelRepository extends R2dbcRepository<Label, Long>, LabelRepositoryInternal {
    Flux<Label> findAllBy(Pageable pageable);

    // just to avoid having unambigous methods
    @Override
    Flux<Label> findAll();

    @Override
    Mono<Label> findById(Long id);

    @Override
    <S extends Label> Mono<S> save(S entity);
}

interface LabelRepositoryInternal {
    <S extends Label> Mono<S> insert(S entity);
    <S extends Label> Mono<S> save(S entity);
    Mono<Integer> update(Label entity);

    Flux<Label> findAll();
    Mono<Label> findById(Long id);
    Flux<Label> findAllBy(Pageable pageable);
    Flux<Label> findAllBy(Pageable pageable, Criteria criteria);
}
