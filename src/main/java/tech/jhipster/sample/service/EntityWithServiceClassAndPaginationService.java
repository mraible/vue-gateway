package tech.jhipster.sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.EntityWithServiceClassAndPagination;
import tech.jhipster.sample.repository.EntityWithServiceClassAndPaginationRepository;

/**
 * Service Implementation for managing {@link EntityWithServiceClassAndPagination}.
 */
@Service
@Transactional
public class EntityWithServiceClassAndPaginationService {

    private final Logger log = LoggerFactory.getLogger(EntityWithServiceClassAndPaginationService.class);

    private final EntityWithServiceClassAndPaginationRepository entityWithServiceClassAndPaginationRepository;

    public EntityWithServiceClassAndPaginationService(
        EntityWithServiceClassAndPaginationRepository entityWithServiceClassAndPaginationRepository
    ) {
        this.entityWithServiceClassAndPaginationRepository = entityWithServiceClassAndPaginationRepository;
    }

    /**
     * Save a entityWithServiceClassAndPagination.
     *
     * @param entityWithServiceClassAndPagination the entity to save.
     * @return the persisted entity.
     */
    public Mono<EntityWithServiceClassAndPagination> save(EntityWithServiceClassAndPagination entityWithServiceClassAndPagination) {
        log.debug("Request to save EntityWithServiceClassAndPagination : {}", entityWithServiceClassAndPagination);
        return entityWithServiceClassAndPaginationRepository.save(entityWithServiceClassAndPagination);
    }

    /**
     * Partially update a entityWithServiceClassAndPagination.
     *
     * @param entityWithServiceClassAndPagination the entity to update partially.
     * @return the persisted entity.
     */
    public Mono<EntityWithServiceClassAndPagination> partialUpdate(
        EntityWithServiceClassAndPagination entityWithServiceClassAndPagination
    ) {
        log.debug("Request to partially update EntityWithServiceClassAndPagination : {}", entityWithServiceClassAndPagination);

        return entityWithServiceClassAndPaginationRepository
            .findById(entityWithServiceClassAndPagination.getId())
            .map(existingEntityWithServiceClassAndPagination -> {
                if (entityWithServiceClassAndPagination.getEnzo() != null) {
                    existingEntityWithServiceClassAndPagination.setEnzo(entityWithServiceClassAndPagination.getEnzo());
                }

                return existingEntityWithServiceClassAndPagination;
            })
            .flatMap(entityWithServiceClassAndPaginationRepository::save);
    }

    /**
     * Get all the entityWithServiceClassAndPaginations.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Flux<EntityWithServiceClassAndPagination> findAll(Pageable pageable) {
        log.debug("Request to get all EntityWithServiceClassAndPaginations");
        return entityWithServiceClassAndPaginationRepository.findAllBy(pageable);
    }

    /**
     * Returns the number of entityWithServiceClassAndPaginations available.
     * @return the number of entities in the database.
     *
     */
    public Mono<Long> countAll() {
        return entityWithServiceClassAndPaginationRepository.count();
    }

    /**
     * Get one entityWithServiceClassAndPagination by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Mono<EntityWithServiceClassAndPagination> findOne(Long id) {
        log.debug("Request to get EntityWithServiceClassAndPagination : {}", id);
        return entityWithServiceClassAndPaginationRepository.findById(id);
    }

    /**
     * Delete the entityWithServiceClassAndPagination by id.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete EntityWithServiceClassAndPagination : {}", id);
        return entityWithServiceClassAndPaginationRepository.deleteById(id);
    }
}
