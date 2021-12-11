package tech.jhipster.sample.service;

import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.BankAccount;

/**
 * Service Interface for managing {@link BankAccount}.
 */
public interface BankAccountService {
    /**
     * Save a bankAccount.
     *
     * @param bankAccount the entity to save.
     * @return the persisted entity.
     */
    Mono<BankAccount> save(BankAccount bankAccount);

    /**
     * Partially updates a bankAccount.
     *
     * @param bankAccount the entity to update partially.
     * @return the persisted entity.
     */
    Mono<BankAccount> partialUpdate(BankAccount bankAccount);

    /**
     * Get all the bankAccounts.
     *
     * @return the list of entities.
     */
    Flux<BankAccount> findAll();

    /**
     * Returns the number of bankAccounts available.
     * @return the number of entities in the database.
     *
     */
    Mono<Long> countAll();

    /**
     * Get the "id" bankAccount.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Mono<BankAccount> findOne(Long id);

    /**
     * Delete the "id" bankAccount.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    Mono<Void> delete(Long id);
}
