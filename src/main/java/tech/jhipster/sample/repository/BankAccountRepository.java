package tech.jhipster.sample.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.BankAccount;

/**
 * Spring Data SQL reactive repository for the BankAccount entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BankAccountRepository extends R2dbcRepository<BankAccount, Long>, BankAccountRepositoryInternal {
    @Query("SELECT * FROM bank_account entity WHERE entity.user_id = :id")
    Flux<BankAccount> findByUser(Long id);

    @Query("SELECT * FROM bank_account entity WHERE entity.user_id IS NULL")
    Flux<BankAccount> findAllWhereUserIsNull();

    // just to avoid having unambigous methods
    @Override
    Flux<BankAccount> findAll();

    @Override
    Mono<BankAccount> findById(Long id);

    @Override
    <S extends BankAccount> Mono<S> save(S entity);
}

interface BankAccountRepositoryInternal {
    <S extends BankAccount> Mono<S> insert(S entity);
    <S extends BankAccount> Mono<S> save(S entity);
    Mono<Integer> update(BankAccount entity);

    Flux<BankAccount> findAll();
    Mono<BankAccount> findById(Long id);
    Flux<BankAccount> findAllBy(Pageable pageable);
    Flux<BankAccount> findAllBy(Pageable pageable, Criteria criteria);
}
