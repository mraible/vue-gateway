package tech.jhipster.sample.service;

import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.service.dto.EntityWithServiceImplAndDTODTO;

/**
 * Service Interface for managing {@link tech.jhipster.sample.domain.EntityWithServiceImplAndDTO}.
 */
public interface EntityWithServiceImplAndDTOService {
    /**
     * Save a entityWithServiceImplAndDTO.
     *
     * @param entityWithServiceImplAndDTODTO the entity to save.
     * @return the persisted entity.
     */
    Mono<EntityWithServiceImplAndDTODTO> save(EntityWithServiceImplAndDTODTO entityWithServiceImplAndDTODTO);

    /**
     * Partially updates a entityWithServiceImplAndDTO.
     *
     * @param entityWithServiceImplAndDTODTO the entity to update partially.
     * @return the persisted entity.
     */
    Mono<EntityWithServiceImplAndDTODTO> partialUpdate(EntityWithServiceImplAndDTODTO entityWithServiceImplAndDTODTO);

    /**
     * Get all the entityWithServiceImplAndDTOS.
     *
     * @return the list of entities.
     */
    Flux<EntityWithServiceImplAndDTODTO> findAll();

    /**
     * Returns the number of entityWithServiceImplAndDTOS available.
     * @return the number of entities in the database.
     *
     */
    Mono<Long> countAll();

    /**
     * Get the "id" entityWithServiceImplAndDTO.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Mono<EntityWithServiceImplAndDTODTO> findOne(Long id);

    /**
     * Delete the "id" entityWithServiceImplAndDTO.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    Mono<Void> delete(Long id);
}
