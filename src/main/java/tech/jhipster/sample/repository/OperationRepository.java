package tech.jhipster.sample.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.Operation;

/**
 * Spring Data SQL reactive repository for the Operation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OperationRepository extends R2dbcRepository<Operation, Long>, OperationRepositoryInternal {
    Flux<Operation> findAllBy(Pageable pageable);

    @Override
    Mono<Operation> findOneWithEagerRelationships(Long id);

    @Override
    Flux<Operation> findAllWithEagerRelationships();

    @Override
    Flux<Operation> findAllWithEagerRelationships(Pageable page);

    @Override
    Mono<Void> deleteById(Long id);

    @Query("SELECT * FROM operation entity WHERE entity.bank_account_id = :id")
    Flux<Operation> findByBankAccount(Long id);

    @Query("SELECT * FROM operation entity WHERE entity.bank_account_id IS NULL")
    Flux<Operation> findAllWhereBankAccountIsNull();

    @Query(
        "SELECT entity.* FROM operation entity JOIN rel_operation__label joinTable ON entity.id = joinTable.operation_id WHERE joinTable.label_id = :id"
    )
    Flux<Operation> findByLabel(Long id);

    // just to avoid having unambigous methods
    @Override
    Flux<Operation> findAll();

    @Override
    Mono<Operation> findById(Long id);

    @Override
    <S extends Operation> Mono<S> save(S entity);
}

interface OperationRepositoryInternal {
    <S extends Operation> Mono<S> insert(S entity);
    <S extends Operation> Mono<S> save(S entity);
    Mono<Integer> update(Operation entity);

    Flux<Operation> findAll();
    Mono<Operation> findById(Long id);
    Flux<Operation> findAllBy(Pageable pageable);
    Flux<Operation> findAllBy(Pageable pageable, Criteria criteria);

    Mono<Operation> findOneWithEagerRelationships(Long id);

    Flux<Operation> findAllWithEagerRelationships();

    Flux<Operation> findAllWithEagerRelationships(Pageable page);

    Mono<Void> deleteById(Long id);
}
