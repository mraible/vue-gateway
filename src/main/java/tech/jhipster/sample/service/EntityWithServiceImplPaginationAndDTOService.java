package tech.jhipster.sample.service;

import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.service.dto.EntityWithServiceImplPaginationAndDTODTO;

/**
 * Service Interface for managing {@link tech.jhipster.sample.domain.EntityWithServiceImplPaginationAndDTO}.
 */
public interface EntityWithServiceImplPaginationAndDTOService {
    /**
     * Save a entityWithServiceImplPaginationAndDTO.
     *
     * @param entityWithServiceImplPaginationAndDTODTO the entity to save.
     * @return the persisted entity.
     */
    Mono<EntityWithServiceImplPaginationAndDTODTO> save(EntityWithServiceImplPaginationAndDTODTO entityWithServiceImplPaginationAndDTODTO);

    /**
     * Partially updates a entityWithServiceImplPaginationAndDTO.
     *
     * @param entityWithServiceImplPaginationAndDTODTO the entity to update partially.
     * @return the persisted entity.
     */
    Mono<EntityWithServiceImplPaginationAndDTODTO> partialUpdate(
        EntityWithServiceImplPaginationAndDTODTO entityWithServiceImplPaginationAndDTODTO
    );

    /**
     * Get all the entityWithServiceImplPaginationAndDTOS.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Flux<EntityWithServiceImplPaginationAndDTODTO> findAll(Pageable pageable);

    /**
     * Returns the number of entityWithServiceImplPaginationAndDTOS available.
     * @return the number of entities in the database.
     *
     */
    Mono<Long> countAll();

    /**
     * Get the "id" entityWithServiceImplPaginationAndDTO.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Mono<EntityWithServiceImplPaginationAndDTODTO> findOne(Long id);

    /**
     * Delete the "id" entityWithServiceImplPaginationAndDTO.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    Mono<Void> delete(Long id);
}
