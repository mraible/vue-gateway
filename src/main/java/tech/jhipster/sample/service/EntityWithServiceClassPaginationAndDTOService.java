package tech.jhipster.sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.EntityWithServiceClassPaginationAndDTO;
import tech.jhipster.sample.repository.EntityWithServiceClassPaginationAndDTORepository;
import tech.jhipster.sample.service.dto.EntityWithServiceClassPaginationAndDTODTO;
import tech.jhipster.sample.service.mapper.EntityWithServiceClassPaginationAndDTOMapper;

/**
 * Service Implementation for managing {@link EntityWithServiceClassPaginationAndDTO}.
 */
@Service
@Transactional
public class EntityWithServiceClassPaginationAndDTOService {

    private final Logger log = LoggerFactory.getLogger(EntityWithServiceClassPaginationAndDTOService.class);

    private final EntityWithServiceClassPaginationAndDTORepository entityWithServiceClassPaginationAndDTORepository;

    private final EntityWithServiceClassPaginationAndDTOMapper entityWithServiceClassPaginationAndDTOMapper;

    public EntityWithServiceClassPaginationAndDTOService(
        EntityWithServiceClassPaginationAndDTORepository entityWithServiceClassPaginationAndDTORepository,
        EntityWithServiceClassPaginationAndDTOMapper entityWithServiceClassPaginationAndDTOMapper
    ) {
        this.entityWithServiceClassPaginationAndDTORepository = entityWithServiceClassPaginationAndDTORepository;
        this.entityWithServiceClassPaginationAndDTOMapper = entityWithServiceClassPaginationAndDTOMapper;
    }

    /**
     * Save a entityWithServiceClassPaginationAndDTO.
     *
     * @param entityWithServiceClassPaginationAndDTODTO the entity to save.
     * @return the persisted entity.
     */
    public Mono<EntityWithServiceClassPaginationAndDTODTO> save(
        EntityWithServiceClassPaginationAndDTODTO entityWithServiceClassPaginationAndDTODTO
    ) {
        log.debug("Request to save EntityWithServiceClassPaginationAndDTO : {}", entityWithServiceClassPaginationAndDTODTO);
        return entityWithServiceClassPaginationAndDTORepository
            .save(entityWithServiceClassPaginationAndDTOMapper.toEntity(entityWithServiceClassPaginationAndDTODTO))
            .map(entityWithServiceClassPaginationAndDTOMapper::toDto);
    }

    /**
     * Partially update a entityWithServiceClassPaginationAndDTO.
     *
     * @param entityWithServiceClassPaginationAndDTODTO the entity to update partially.
     * @return the persisted entity.
     */
    public Mono<EntityWithServiceClassPaginationAndDTODTO> partialUpdate(
        EntityWithServiceClassPaginationAndDTODTO entityWithServiceClassPaginationAndDTODTO
    ) {
        log.debug("Request to partially update EntityWithServiceClassPaginationAndDTO : {}", entityWithServiceClassPaginationAndDTODTO);

        return entityWithServiceClassPaginationAndDTORepository
            .findById(entityWithServiceClassPaginationAndDTODTO.getId())
            .map(existingEntityWithServiceClassPaginationAndDTO -> {
                entityWithServiceClassPaginationAndDTOMapper.partialUpdate(
                    existingEntityWithServiceClassPaginationAndDTO,
                    entityWithServiceClassPaginationAndDTODTO
                );

                return existingEntityWithServiceClassPaginationAndDTO;
            })
            .flatMap(entityWithServiceClassPaginationAndDTORepository::save)
            .map(entityWithServiceClassPaginationAndDTOMapper::toDto);
    }

    /**
     * Get all the entityWithServiceClassPaginationAndDTOS.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Flux<EntityWithServiceClassPaginationAndDTODTO> findAll(Pageable pageable) {
        log.debug("Request to get all EntityWithServiceClassPaginationAndDTOS");
        return entityWithServiceClassPaginationAndDTORepository
            .findAllBy(pageable)
            .map(entityWithServiceClassPaginationAndDTOMapper::toDto);
    }

    /**
     * Returns the number of entityWithServiceClassPaginationAndDTOS available.
     * @return the number of entities in the database.
     *
     */
    public Mono<Long> countAll() {
        return entityWithServiceClassPaginationAndDTORepository.count();
    }

    /**
     * Get one entityWithServiceClassPaginationAndDTO by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Mono<EntityWithServiceClassPaginationAndDTODTO> findOne(Long id) {
        log.debug("Request to get EntityWithServiceClassPaginationAndDTO : {}", id);
        return entityWithServiceClassPaginationAndDTORepository.findById(id).map(entityWithServiceClassPaginationAndDTOMapper::toDto);
    }

    /**
     * Delete the entityWithServiceClassPaginationAndDTO by id.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete EntityWithServiceClassPaginationAndDTO : {}", id);
        return entityWithServiceClassPaginationAndDTORepository.deleteById(id);
    }
}
