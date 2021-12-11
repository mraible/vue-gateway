package tech.jhipster.sample.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.FieldTestServiceClassAndJpaFilteringEntity;
import tech.jhipster.sample.repository.FieldTestServiceClassAndJpaFilteringEntityRepository;

/**
 * Service Implementation for managing {@link FieldTestServiceClassAndJpaFilteringEntity}.
 */
@Service
@Transactional
public class FieldTestServiceClassAndJpaFilteringEntityService {

    private final Logger log = LoggerFactory.getLogger(FieldTestServiceClassAndJpaFilteringEntityService.class);

    private final FieldTestServiceClassAndJpaFilteringEntityRepository fieldTestServiceClassAndJpaFilteringEntityRepository;

    public FieldTestServiceClassAndJpaFilteringEntityService(
        FieldTestServiceClassAndJpaFilteringEntityRepository fieldTestServiceClassAndJpaFilteringEntityRepository
    ) {
        this.fieldTestServiceClassAndJpaFilteringEntityRepository = fieldTestServiceClassAndJpaFilteringEntityRepository;
    }

    /**
     * Save a fieldTestServiceClassAndJpaFilteringEntity.
     *
     * @param fieldTestServiceClassAndJpaFilteringEntity the entity to save.
     * @return the persisted entity.
     */
    public Mono<FieldTestServiceClassAndJpaFilteringEntity> save(
        FieldTestServiceClassAndJpaFilteringEntity fieldTestServiceClassAndJpaFilteringEntity
    ) {
        log.debug("Request to save FieldTestServiceClassAndJpaFilteringEntity : {}", fieldTestServiceClassAndJpaFilteringEntity);
        return fieldTestServiceClassAndJpaFilteringEntityRepository.save(fieldTestServiceClassAndJpaFilteringEntity);
    }

    /**
     * Partially update a fieldTestServiceClassAndJpaFilteringEntity.
     *
     * @param fieldTestServiceClassAndJpaFilteringEntity the entity to update partially.
     * @return the persisted entity.
     */
    public Mono<FieldTestServiceClassAndJpaFilteringEntity> partialUpdate(
        FieldTestServiceClassAndJpaFilteringEntity fieldTestServiceClassAndJpaFilteringEntity
    ) {
        log.debug(
            "Request to partially update FieldTestServiceClassAndJpaFilteringEntity : {}",
            fieldTestServiceClassAndJpaFilteringEntity
        );

        return fieldTestServiceClassAndJpaFilteringEntityRepository
            .findById(fieldTestServiceClassAndJpaFilteringEntity.getId())
            .map(existingFieldTestServiceClassAndJpaFilteringEntity -> {
                if (fieldTestServiceClassAndJpaFilteringEntity.getStringBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setStringBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getStringBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getStringRequiredBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setStringRequiredBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getStringRequiredBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getStringMinlengthBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setStringMinlengthBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getStringMinlengthBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getStringMaxlengthBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setStringMaxlengthBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getStringMaxlengthBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getStringPatternBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setStringPatternBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getStringPatternBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getIntegerBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setIntegerBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getIntegerBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getIntegerRequiredBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setIntegerRequiredBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getIntegerRequiredBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getIntegerMinBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setIntegerMinBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getIntegerMinBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getIntegerMaxBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setIntegerMaxBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getIntegerMaxBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getLongBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setLongBob(fieldTestServiceClassAndJpaFilteringEntity.getLongBob());
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getLongRequiredBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setLongRequiredBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getLongRequiredBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getLongMinBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setLongMinBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getLongMinBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getLongMaxBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setLongMaxBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getLongMaxBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getFloatBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setFloatBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getFloatBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getFloatRequiredBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setFloatRequiredBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getFloatRequiredBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getFloatMinBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setFloatMinBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getFloatMinBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getFloatMaxBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setFloatMaxBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getFloatMaxBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getDoubleRequiredBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setDoubleRequiredBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getDoubleRequiredBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getDoubleMinBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setDoubleMinBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getDoubleMinBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getDoubleMaxBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setDoubleMaxBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getDoubleMaxBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getBigDecimalRequiredBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setBigDecimalRequiredBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getBigDecimalRequiredBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getBigDecimalMinBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setBigDecimalMinBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getBigDecimalMinBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getBigDecimalMaxBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setBigDecimalMaxBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getBigDecimalMaxBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getLocalDateBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setLocalDateBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getLocalDateBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getLocalDateRequiredBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setLocalDateRequiredBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getLocalDateRequiredBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getInstantBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setInstantBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getInstantBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getInstanteRequiredBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setInstanteRequiredBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getInstanteRequiredBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getZonedDateTimeBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setZonedDateTimeBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getZonedDateTimeBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getZonedDateTimeRequiredBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setZonedDateTimeRequiredBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getZonedDateTimeRequiredBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getDurationBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setDurationBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getDurationBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getDurationRequiredBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setDurationRequiredBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getDurationRequiredBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getBooleanBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setBooleanBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getBooleanBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getBooleanRequiredBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setBooleanRequiredBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getBooleanRequiredBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getEnumBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setEnumBob(fieldTestServiceClassAndJpaFilteringEntity.getEnumBob());
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getEnumRequiredBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setEnumRequiredBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getEnumRequiredBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getUuidBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setUuidBob(fieldTestServiceClassAndJpaFilteringEntity.getUuidBob());
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getUuidRequiredBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setUuidRequiredBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getUuidRequiredBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getByteImageBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setByteImageBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getByteImageBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getByteImageBobContentType() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setByteImageBobContentType(
                        fieldTestServiceClassAndJpaFilteringEntity.getByteImageBobContentType()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getByteImageRequiredBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setByteImageRequiredBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getByteImageRequiredBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getByteImageRequiredBobContentType() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setByteImageRequiredBobContentType(
                        fieldTestServiceClassAndJpaFilteringEntity.getByteImageRequiredBobContentType()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getByteImageMinbytesBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setByteImageMinbytesBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getByteImageMinbytesBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getByteImageMinbytesBobContentType() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setByteImageMinbytesBobContentType(
                        fieldTestServiceClassAndJpaFilteringEntity.getByteImageMinbytesBobContentType()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getByteImageMaxbytesBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setByteImageMaxbytesBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getByteImageMaxbytesBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getByteImageMaxbytesBobContentType() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setByteImageMaxbytesBobContentType(
                        fieldTestServiceClassAndJpaFilteringEntity.getByteImageMaxbytesBobContentType()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getByteAnyBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setByteAnyBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getByteAnyBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getByteAnyBobContentType() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setByteAnyBobContentType(
                        fieldTestServiceClassAndJpaFilteringEntity.getByteAnyBobContentType()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getByteAnyRequiredBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setByteAnyRequiredBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getByteAnyRequiredBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getByteAnyRequiredBobContentType() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setByteAnyRequiredBobContentType(
                        fieldTestServiceClassAndJpaFilteringEntity.getByteAnyRequiredBobContentType()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getByteAnyMinbytesBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setByteAnyMinbytesBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getByteAnyMinbytesBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getByteAnyMinbytesBobContentType() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setByteAnyMinbytesBobContentType(
                        fieldTestServiceClassAndJpaFilteringEntity.getByteAnyMinbytesBobContentType()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getByteAnyMaxbytesBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setByteAnyMaxbytesBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getByteAnyMaxbytesBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getByteAnyMaxbytesBobContentType() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setByteAnyMaxbytesBobContentType(
                        fieldTestServiceClassAndJpaFilteringEntity.getByteAnyMaxbytesBobContentType()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getByteTextBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setByteTextBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getByteTextBob()
                    );
                }
                if (fieldTestServiceClassAndJpaFilteringEntity.getByteTextRequiredBob() != null) {
                    existingFieldTestServiceClassAndJpaFilteringEntity.setByteTextRequiredBob(
                        fieldTestServiceClassAndJpaFilteringEntity.getByteTextRequiredBob()
                    );
                }

                return existingFieldTestServiceClassAndJpaFilteringEntity;
            })
            .flatMap(fieldTestServiceClassAndJpaFilteringEntityRepository::save);
    }

    /**
     * Get all the fieldTestServiceClassAndJpaFilteringEntities.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Flux<FieldTestServiceClassAndJpaFilteringEntity> findAll() {
        log.debug("Request to get all FieldTestServiceClassAndJpaFilteringEntities");
        return fieldTestServiceClassAndJpaFilteringEntityRepository.findAll();
    }

    /**
     * Returns the number of fieldTestServiceClassAndJpaFilteringEntities available.
     * @return the number of entities in the database.
     *
     */
    public Mono<Long> countAll() {
        return fieldTestServiceClassAndJpaFilteringEntityRepository.count();
    }

    /**
     * Get one fieldTestServiceClassAndJpaFilteringEntity by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Mono<FieldTestServiceClassAndJpaFilteringEntity> findOne(Long id) {
        log.debug("Request to get FieldTestServiceClassAndJpaFilteringEntity : {}", id);
        return fieldTestServiceClassAndJpaFilteringEntityRepository.findById(id);
    }

    /**
     * Delete the fieldTestServiceClassAndJpaFilteringEntity by id.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete FieldTestServiceClassAndJpaFilteringEntity : {}", id);
        return fieldTestServiceClassAndJpaFilteringEntityRepository.deleteById(id);
    }
}
