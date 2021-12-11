package tech.jhipster.sample.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.EntityWithServiceImplPaginationAndDTO;
import tech.jhipster.sample.repository.EntityWithServiceImplPaginationAndDTORepository;
import tech.jhipster.sample.service.EntityWithServiceImplPaginationAndDTOService;
import tech.jhipster.sample.service.dto.EntityWithServiceImplPaginationAndDTODTO;
import tech.jhipster.sample.service.mapper.EntityWithServiceImplPaginationAndDTOMapper;

/**
 * Service Implementation for managing {@link EntityWithServiceImplPaginationAndDTO}.
 */
@Service
@Transactional
public class EntityWithServiceImplPaginationAndDTOServiceImpl implements EntityWithServiceImplPaginationAndDTOService {

    private final Logger log = LoggerFactory.getLogger(EntityWithServiceImplPaginationAndDTOServiceImpl.class);

    private final EntityWithServiceImplPaginationAndDTORepository entityWithServiceImplPaginationAndDTORepository;

    private final EntityWithServiceImplPaginationAndDTOMapper entityWithServiceImplPaginationAndDTOMapper;

    public EntityWithServiceImplPaginationAndDTOServiceImpl(
        EntityWithServiceImplPaginationAndDTORepository entityWithServiceImplPaginationAndDTORepository,
        EntityWithServiceImplPaginationAndDTOMapper entityWithServiceImplPaginationAndDTOMapper
    ) {
        this.entityWithServiceImplPaginationAndDTORepository = entityWithServiceImplPaginationAndDTORepository;
        this.entityWithServiceImplPaginationAndDTOMapper = entityWithServiceImplPaginationAndDTOMapper;
    }

    @Override
    public Mono<EntityWithServiceImplPaginationAndDTODTO> save(
        EntityWithServiceImplPaginationAndDTODTO entityWithServiceImplPaginationAndDTODTO
    ) {
        log.debug("Request to save EntityWithServiceImplPaginationAndDTO : {}", entityWithServiceImplPaginationAndDTODTO);
        return entityWithServiceImplPaginationAndDTORepository
            .save(entityWithServiceImplPaginationAndDTOMapper.toEntity(entityWithServiceImplPaginationAndDTODTO))
            .map(entityWithServiceImplPaginationAndDTOMapper::toDto);
    }

    @Override
    public Mono<EntityWithServiceImplPaginationAndDTODTO> partialUpdate(
        EntityWithServiceImplPaginationAndDTODTO entityWithServiceImplPaginationAndDTODTO
    ) {
        log.debug("Request to partially update EntityWithServiceImplPaginationAndDTO : {}", entityWithServiceImplPaginationAndDTODTO);

        return entityWithServiceImplPaginationAndDTORepository
            .findById(entityWithServiceImplPaginationAndDTODTO.getId())
            .map(existingEntityWithServiceImplPaginationAndDTO -> {
                entityWithServiceImplPaginationAndDTOMapper.partialUpdate(
                    existingEntityWithServiceImplPaginationAndDTO,
                    entityWithServiceImplPaginationAndDTODTO
                );

                return existingEntityWithServiceImplPaginationAndDTO;
            })
            .flatMap(entityWithServiceImplPaginationAndDTORepository::save)
            .map(entityWithServiceImplPaginationAndDTOMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<EntityWithServiceImplPaginationAndDTODTO> findAll(Pageable pageable) {
        log.debug("Request to get all EntityWithServiceImplPaginationAndDTOS");
        return entityWithServiceImplPaginationAndDTORepository.findAllBy(pageable).map(entityWithServiceImplPaginationAndDTOMapper::toDto);
    }

    public Mono<Long> countAll() {
        return entityWithServiceImplPaginationAndDTORepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<EntityWithServiceImplPaginationAndDTODTO> findOne(Long id) {
        log.debug("Request to get EntityWithServiceImplPaginationAndDTO : {}", id);
        return entityWithServiceImplPaginationAndDTORepository.findById(id).map(entityWithServiceImplPaginationAndDTOMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete EntityWithServiceImplPaginationAndDTO : {}", id);
        return entityWithServiceImplPaginationAndDTORepository.deleteById(id);
    }
}
