package tech.jhipster.sample.service;

import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.service.dto.MapsIdUserProfileWithDTODTO;

/**
 * Service Interface for managing {@link tech.jhipster.sample.domain.MapsIdUserProfileWithDTO}.
 */
public interface MapsIdUserProfileWithDTOService {
    /**
     * Save a mapsIdUserProfileWithDTO.
     *
     * @param mapsIdUserProfileWithDTODTO the entity to save.
     * @return the persisted entity.
     */
    Mono<MapsIdUserProfileWithDTODTO> save(MapsIdUserProfileWithDTODTO mapsIdUserProfileWithDTODTO);

    /**
     * Partially updates a mapsIdUserProfileWithDTO.
     *
     * @param mapsIdUserProfileWithDTODTO the entity to update partially.
     * @return the persisted entity.
     */
    Mono<MapsIdUserProfileWithDTODTO> partialUpdate(MapsIdUserProfileWithDTODTO mapsIdUserProfileWithDTODTO);

    /**
     * Get all the mapsIdUserProfileWithDTOS.
     *
     * @return the list of entities.
     */
    Flux<MapsIdUserProfileWithDTODTO> findAll();

    /**
     * Returns the number of mapsIdUserProfileWithDTOS available.
     * @return the number of entities in the database.
     *
     */
    Mono<Long> countAll();

    /**
     * Get the "id" mapsIdUserProfileWithDTO.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Mono<MapsIdUserProfileWithDTODTO> findOne(Long id);

    /**
     * Delete the "id" mapsIdUserProfileWithDTO.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    Mono<Void> delete(Long id);
}
