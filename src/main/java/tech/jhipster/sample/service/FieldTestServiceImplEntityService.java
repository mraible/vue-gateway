package tech.jhipster.sample.service;

import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.FieldTestServiceImplEntity;

/**
 * Service Interface for managing {@link FieldTestServiceImplEntity}.
 */
public interface FieldTestServiceImplEntityService {
    /**
     * Save a fieldTestServiceImplEntity.
     *
     * @param fieldTestServiceImplEntity the entity to save.
     * @return the persisted entity.
     */
    Mono<FieldTestServiceImplEntity> save(FieldTestServiceImplEntity fieldTestServiceImplEntity);

    /**
     * Partially updates a fieldTestServiceImplEntity.
     *
     * @param fieldTestServiceImplEntity the entity to update partially.
     * @return the persisted entity.
     */
    Mono<FieldTestServiceImplEntity> partialUpdate(FieldTestServiceImplEntity fieldTestServiceImplEntity);

    /**
     * Get all the fieldTestServiceImplEntities.
     *
     * @return the list of entities.
     */
    Flux<FieldTestServiceImplEntity> findAll();

    /**
     * Returns the number of fieldTestServiceImplEntities available.
     * @return the number of entities in the database.
     *
     */
    Mono<Long> countAll();

    /**
     * Get the "id" fieldTestServiceImplEntity.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Mono<FieldTestServiceImplEntity> findOne(Long id);

    /**
     * Delete the "id" fieldTestServiceImplEntity.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    Mono<Void> delete(Long id);
}
