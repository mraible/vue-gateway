package tech.jhipster.sample.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.EntityWithServiceImplAndPagination;
import tech.jhipster.sample.repository.EntityWithServiceImplAndPaginationRepository;
import tech.jhipster.sample.service.EntityWithServiceImplAndPaginationService;

/**
 * Service Implementation for managing {@link EntityWithServiceImplAndPagination}.
 */
@Service
@Transactional
public class EntityWithServiceImplAndPaginationServiceImpl implements EntityWithServiceImplAndPaginationService {

    private final Logger log = LoggerFactory.getLogger(EntityWithServiceImplAndPaginationServiceImpl.class);

    private final EntityWithServiceImplAndPaginationRepository entityWithServiceImplAndPaginationRepository;

    public EntityWithServiceImplAndPaginationServiceImpl(
        EntityWithServiceImplAndPaginationRepository entityWithServiceImplAndPaginationRepository
    ) {
        this.entityWithServiceImplAndPaginationRepository = entityWithServiceImplAndPaginationRepository;
    }

    @Override
    public Mono<EntityWithServiceImplAndPagination> save(EntityWithServiceImplAndPagination entityWithServiceImplAndPagination) {
        log.debug("Request to save EntityWithServiceImplAndPagination : {}", entityWithServiceImplAndPagination);
        return entityWithServiceImplAndPaginationRepository.save(entityWithServiceImplAndPagination);
    }

    @Override
    public Mono<EntityWithServiceImplAndPagination> partialUpdate(EntityWithServiceImplAndPagination entityWithServiceImplAndPagination) {
        log.debug("Request to partially update EntityWithServiceImplAndPagination : {}", entityWithServiceImplAndPagination);

        return entityWithServiceImplAndPaginationRepository
            .findById(entityWithServiceImplAndPagination.getId())
            .map(existingEntityWithServiceImplAndPagination -> {
                if (entityWithServiceImplAndPagination.getHugo() != null) {
                    existingEntityWithServiceImplAndPagination.setHugo(entityWithServiceImplAndPagination.getHugo());
                }

                return existingEntityWithServiceImplAndPagination;
            })
            .flatMap(entityWithServiceImplAndPaginationRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<EntityWithServiceImplAndPagination> findAll(Pageable pageable) {
        log.debug("Request to get all EntityWithServiceImplAndPaginations");
        return entityWithServiceImplAndPaginationRepository.findAllBy(pageable);
    }

    public Mono<Long> countAll() {
        return entityWithServiceImplAndPaginationRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<EntityWithServiceImplAndPagination> findOne(Long id) {
        log.debug("Request to get EntityWithServiceImplAndPagination : {}", id);
        return entityWithServiceImplAndPaginationRepository.findById(id);
    }

    @Override
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete EntityWithServiceImplAndPagination : {}", id);
        return entityWithServiceImplAndPaginationRepository.deleteById(id);
    }
}
