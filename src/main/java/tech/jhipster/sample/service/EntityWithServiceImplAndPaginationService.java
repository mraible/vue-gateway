package tech.jhipster.sample.service;

import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.EntityWithServiceImplAndPagination;

/**
 * Service Interface for managing {@link EntityWithServiceImplAndPagination}.
 */
public interface EntityWithServiceImplAndPaginationService {
    /**
     * Save a entityWithServiceImplAndPagination.
     *
     * @param entityWithServiceImplAndPagination the entity to save.
     * @return the persisted entity.
     */
    Mono<EntityWithServiceImplAndPagination> save(EntityWithServiceImplAndPagination entityWithServiceImplAndPagination);

    /**
     * Partially updates a entityWithServiceImplAndPagination.
     *
     * @param entityWithServiceImplAndPagination the entity to update partially.
     * @return the persisted entity.
     */
    Mono<EntityWithServiceImplAndPagination> partialUpdate(EntityWithServiceImplAndPagination entityWithServiceImplAndPagination);

    /**
     * Get all the entityWithServiceImplAndPaginations.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Flux<EntityWithServiceImplAndPagination> findAll(Pageable pageable);

    /**
     * Returns the number of entityWithServiceImplAndPaginations available.
     * @return the number of entities in the database.
     *
     */
    Mono<Long> countAll();

    /**
     * Get the "id" entityWithServiceImplAndPagination.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Mono<EntityWithServiceImplAndPagination> findOne(Long id);

    /**
     * Delete the "id" entityWithServiceImplAndPagination.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    Mono<Void> delete(Long id);
}
