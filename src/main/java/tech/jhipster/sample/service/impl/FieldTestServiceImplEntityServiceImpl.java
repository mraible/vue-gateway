package tech.jhipster.sample.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.domain.FieldTestServiceImplEntity;
import tech.jhipster.sample.repository.FieldTestServiceImplEntityRepository;
import tech.jhipster.sample.service.FieldTestServiceImplEntityService;

/**
 * Service Implementation for managing {@link FieldTestServiceImplEntity}.
 */
@Service
@Transactional
public class FieldTestServiceImplEntityServiceImpl implements FieldTestServiceImplEntityService {

    private final Logger log = LoggerFactory.getLogger(FieldTestServiceImplEntityServiceImpl.class);

    private final FieldTestServiceImplEntityRepository fieldTestServiceImplEntityRepository;

    public FieldTestServiceImplEntityServiceImpl(FieldTestServiceImplEntityRepository fieldTestServiceImplEntityRepository) {
        this.fieldTestServiceImplEntityRepository = fieldTestServiceImplEntityRepository;
    }

    @Override
    public Mono<FieldTestServiceImplEntity> save(FieldTestServiceImplEntity fieldTestServiceImplEntity) {
        log.debug("Request to save FieldTestServiceImplEntity : {}", fieldTestServiceImplEntity);
        return fieldTestServiceImplEntityRepository.save(fieldTestServiceImplEntity);
    }

    @Override
    public Mono<FieldTestServiceImplEntity> partialUpdate(FieldTestServiceImplEntity fieldTestServiceImplEntity) {
        log.debug("Request to partially update FieldTestServiceImplEntity : {}", fieldTestServiceImplEntity);

        return fieldTestServiceImplEntityRepository
            .findById(fieldTestServiceImplEntity.getId())
            .map(existingFieldTestServiceImplEntity -> {
                if (fieldTestServiceImplEntity.getStringMika() != null) {
                    existingFieldTestServiceImplEntity.setStringMika(fieldTestServiceImplEntity.getStringMika());
                }
                if (fieldTestServiceImplEntity.getStringRequiredMika() != null) {
                    existingFieldTestServiceImplEntity.setStringRequiredMika(fieldTestServiceImplEntity.getStringRequiredMika());
                }
                if (fieldTestServiceImplEntity.getStringMinlengthMika() != null) {
                    existingFieldTestServiceImplEntity.setStringMinlengthMika(fieldTestServiceImplEntity.getStringMinlengthMika());
                }
                if (fieldTestServiceImplEntity.getStringMaxlengthMika() != null) {
                    existingFieldTestServiceImplEntity.setStringMaxlengthMika(fieldTestServiceImplEntity.getStringMaxlengthMika());
                }
                if (fieldTestServiceImplEntity.getStringPatternMika() != null) {
                    existingFieldTestServiceImplEntity.setStringPatternMika(fieldTestServiceImplEntity.getStringPatternMika());
                }
                if (fieldTestServiceImplEntity.getIntegerMika() != null) {
                    existingFieldTestServiceImplEntity.setIntegerMika(fieldTestServiceImplEntity.getIntegerMika());
                }
                if (fieldTestServiceImplEntity.getIntegerRequiredMika() != null) {
                    existingFieldTestServiceImplEntity.setIntegerRequiredMika(fieldTestServiceImplEntity.getIntegerRequiredMika());
                }
                if (fieldTestServiceImplEntity.getIntegerMinMika() != null) {
                    existingFieldTestServiceImplEntity.setIntegerMinMika(fieldTestServiceImplEntity.getIntegerMinMika());
                }
                if (fieldTestServiceImplEntity.getIntegerMaxMika() != null) {
                    existingFieldTestServiceImplEntity.setIntegerMaxMika(fieldTestServiceImplEntity.getIntegerMaxMika());
                }
                if (fieldTestServiceImplEntity.getLongMika() != null) {
                    existingFieldTestServiceImplEntity.setLongMika(fieldTestServiceImplEntity.getLongMika());
                }
                if (fieldTestServiceImplEntity.getLongRequiredMika() != null) {
                    existingFieldTestServiceImplEntity.setLongRequiredMika(fieldTestServiceImplEntity.getLongRequiredMika());
                }
                if (fieldTestServiceImplEntity.getLongMinMika() != null) {
                    existingFieldTestServiceImplEntity.setLongMinMika(fieldTestServiceImplEntity.getLongMinMika());
                }
                if (fieldTestServiceImplEntity.getLongMaxMika() != null) {
                    existingFieldTestServiceImplEntity.setLongMaxMika(fieldTestServiceImplEntity.getLongMaxMika());
                }
                if (fieldTestServiceImplEntity.getFloatMika() != null) {
                    existingFieldTestServiceImplEntity.setFloatMika(fieldTestServiceImplEntity.getFloatMika());
                }
                if (fieldTestServiceImplEntity.getFloatRequiredMika() != null) {
                    existingFieldTestServiceImplEntity.setFloatRequiredMika(fieldTestServiceImplEntity.getFloatRequiredMika());
                }
                if (fieldTestServiceImplEntity.getFloatMinMika() != null) {
                    existingFieldTestServiceImplEntity.setFloatMinMika(fieldTestServiceImplEntity.getFloatMinMika());
                }
                if (fieldTestServiceImplEntity.getFloatMaxMika() != null) {
                    existingFieldTestServiceImplEntity.setFloatMaxMika(fieldTestServiceImplEntity.getFloatMaxMika());
                }
                if (fieldTestServiceImplEntity.getDoubleRequiredMika() != null) {
                    existingFieldTestServiceImplEntity.setDoubleRequiredMika(fieldTestServiceImplEntity.getDoubleRequiredMika());
                }
                if (fieldTestServiceImplEntity.getDoubleMinMika() != null) {
                    existingFieldTestServiceImplEntity.setDoubleMinMika(fieldTestServiceImplEntity.getDoubleMinMika());
                }
                if (fieldTestServiceImplEntity.getDoubleMaxMika() != null) {
                    existingFieldTestServiceImplEntity.setDoubleMaxMika(fieldTestServiceImplEntity.getDoubleMaxMika());
                }
                if (fieldTestServiceImplEntity.getBigDecimalRequiredMika() != null) {
                    existingFieldTestServiceImplEntity.setBigDecimalRequiredMika(fieldTestServiceImplEntity.getBigDecimalRequiredMika());
                }
                if (fieldTestServiceImplEntity.getBigDecimalMinMika() != null) {
                    existingFieldTestServiceImplEntity.setBigDecimalMinMika(fieldTestServiceImplEntity.getBigDecimalMinMika());
                }
                if (fieldTestServiceImplEntity.getBigDecimalMaxMika() != null) {
                    existingFieldTestServiceImplEntity.setBigDecimalMaxMika(fieldTestServiceImplEntity.getBigDecimalMaxMika());
                }
                if (fieldTestServiceImplEntity.getLocalDateMika() != null) {
                    existingFieldTestServiceImplEntity.setLocalDateMika(fieldTestServiceImplEntity.getLocalDateMika());
                }
                if (fieldTestServiceImplEntity.getLocalDateRequiredMika() != null) {
                    existingFieldTestServiceImplEntity.setLocalDateRequiredMika(fieldTestServiceImplEntity.getLocalDateRequiredMika());
                }
                if (fieldTestServiceImplEntity.getInstantMika() != null) {
                    existingFieldTestServiceImplEntity.setInstantMika(fieldTestServiceImplEntity.getInstantMika());
                }
                if (fieldTestServiceImplEntity.getInstanteRequiredMika() != null) {
                    existingFieldTestServiceImplEntity.setInstanteRequiredMika(fieldTestServiceImplEntity.getInstanteRequiredMika());
                }
                if (fieldTestServiceImplEntity.getZonedDateTimeMika() != null) {
                    existingFieldTestServiceImplEntity.setZonedDateTimeMika(fieldTestServiceImplEntity.getZonedDateTimeMika());
                }
                if (fieldTestServiceImplEntity.getZonedDateTimeRequiredMika() != null) {
                    existingFieldTestServiceImplEntity.setZonedDateTimeRequiredMika(
                        fieldTestServiceImplEntity.getZonedDateTimeRequiredMika()
                    );
                }
                if (fieldTestServiceImplEntity.getDurationMika() != null) {
                    existingFieldTestServiceImplEntity.setDurationMika(fieldTestServiceImplEntity.getDurationMika());
                }
                if (fieldTestServiceImplEntity.getDurationRequiredMika() != null) {
                    existingFieldTestServiceImplEntity.setDurationRequiredMika(fieldTestServiceImplEntity.getDurationRequiredMika());
                }
                if (fieldTestServiceImplEntity.getBooleanMika() != null) {
                    existingFieldTestServiceImplEntity.setBooleanMika(fieldTestServiceImplEntity.getBooleanMika());
                }
                if (fieldTestServiceImplEntity.getBooleanRequiredMika() != null) {
                    existingFieldTestServiceImplEntity.setBooleanRequiredMika(fieldTestServiceImplEntity.getBooleanRequiredMika());
                }
                if (fieldTestServiceImplEntity.getEnumMika() != null) {
                    existingFieldTestServiceImplEntity.setEnumMika(fieldTestServiceImplEntity.getEnumMika());
                }
                if (fieldTestServiceImplEntity.getEnumRequiredMika() != null) {
                    existingFieldTestServiceImplEntity.setEnumRequiredMika(fieldTestServiceImplEntity.getEnumRequiredMika());
                }
                if (fieldTestServiceImplEntity.getUuidMika() != null) {
                    existingFieldTestServiceImplEntity.setUuidMika(fieldTestServiceImplEntity.getUuidMika());
                }
                if (fieldTestServiceImplEntity.getUuidRequiredMika() != null) {
                    existingFieldTestServiceImplEntity.setUuidRequiredMika(fieldTestServiceImplEntity.getUuidRequiredMika());
                }
                if (fieldTestServiceImplEntity.getByteImageMika() != null) {
                    existingFieldTestServiceImplEntity.setByteImageMika(fieldTestServiceImplEntity.getByteImageMika());
                }
                if (fieldTestServiceImplEntity.getByteImageMikaContentType() != null) {
                    existingFieldTestServiceImplEntity.setByteImageMikaContentType(
                        fieldTestServiceImplEntity.getByteImageMikaContentType()
                    );
                }
                if (fieldTestServiceImplEntity.getByteImageRequiredMika() != null) {
                    existingFieldTestServiceImplEntity.setByteImageRequiredMika(fieldTestServiceImplEntity.getByteImageRequiredMika());
                }
                if (fieldTestServiceImplEntity.getByteImageRequiredMikaContentType() != null) {
                    existingFieldTestServiceImplEntity.setByteImageRequiredMikaContentType(
                        fieldTestServiceImplEntity.getByteImageRequiredMikaContentType()
                    );
                }
                if (fieldTestServiceImplEntity.getByteImageMinbytesMika() != null) {
                    existingFieldTestServiceImplEntity.setByteImageMinbytesMika(fieldTestServiceImplEntity.getByteImageMinbytesMika());
                }
                if (fieldTestServiceImplEntity.getByteImageMinbytesMikaContentType() != null) {
                    existingFieldTestServiceImplEntity.setByteImageMinbytesMikaContentType(
                        fieldTestServiceImplEntity.getByteImageMinbytesMikaContentType()
                    );
                }
                if (fieldTestServiceImplEntity.getByteImageMaxbytesMika() != null) {
                    existingFieldTestServiceImplEntity.setByteImageMaxbytesMika(fieldTestServiceImplEntity.getByteImageMaxbytesMika());
                }
                if (fieldTestServiceImplEntity.getByteImageMaxbytesMikaContentType() != null) {
                    existingFieldTestServiceImplEntity.setByteImageMaxbytesMikaContentType(
                        fieldTestServiceImplEntity.getByteImageMaxbytesMikaContentType()
                    );
                }
                if (fieldTestServiceImplEntity.getByteAnyMika() != null) {
                    existingFieldTestServiceImplEntity.setByteAnyMika(fieldTestServiceImplEntity.getByteAnyMika());
                }
                if (fieldTestServiceImplEntity.getByteAnyMikaContentType() != null) {
                    existingFieldTestServiceImplEntity.setByteAnyMikaContentType(fieldTestServiceImplEntity.getByteAnyMikaContentType());
                }
                if (fieldTestServiceImplEntity.getByteAnyRequiredMika() != null) {
                    existingFieldTestServiceImplEntity.setByteAnyRequiredMika(fieldTestServiceImplEntity.getByteAnyRequiredMika());
                }
                if (fieldTestServiceImplEntity.getByteAnyRequiredMikaContentType() != null) {
                    existingFieldTestServiceImplEntity.setByteAnyRequiredMikaContentType(
                        fieldTestServiceImplEntity.getByteAnyRequiredMikaContentType()
                    );
                }
                if (fieldTestServiceImplEntity.getByteAnyMinbytesMika() != null) {
                    existingFieldTestServiceImplEntity.setByteAnyMinbytesMika(fieldTestServiceImplEntity.getByteAnyMinbytesMika());
                }
                if (fieldTestServiceImplEntity.getByteAnyMinbytesMikaContentType() != null) {
                    existingFieldTestServiceImplEntity.setByteAnyMinbytesMikaContentType(
                        fieldTestServiceImplEntity.getByteAnyMinbytesMikaContentType()
                    );
                }
                if (fieldTestServiceImplEntity.getByteAnyMaxbytesMika() != null) {
                    existingFieldTestServiceImplEntity.setByteAnyMaxbytesMika(fieldTestServiceImplEntity.getByteAnyMaxbytesMika());
                }
                if (fieldTestServiceImplEntity.getByteAnyMaxbytesMikaContentType() != null) {
                    existingFieldTestServiceImplEntity.setByteAnyMaxbytesMikaContentType(
                        fieldTestServiceImplEntity.getByteAnyMaxbytesMikaContentType()
                    );
                }
                if (fieldTestServiceImplEntity.getByteTextMika() != null) {
                    existingFieldTestServiceImplEntity.setByteTextMika(fieldTestServiceImplEntity.getByteTextMika());
                }
                if (fieldTestServiceImplEntity.getByteTextRequiredMika() != null) {
                    existingFieldTestServiceImplEntity.setByteTextRequiredMika(fieldTestServiceImplEntity.getByteTextRequiredMika());
                }

                return existingFieldTestServiceImplEntity;
            })
            .flatMap(fieldTestServiceImplEntityRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<FieldTestServiceImplEntity> findAll() {
        log.debug("Request to get all FieldTestServiceImplEntities");
        return fieldTestServiceImplEntityRepository.findAll();
    }

    public Mono<Long> countAll() {
        return fieldTestServiceImplEntityRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<FieldTestServiceImplEntity> findOne(Long id) {
        log.debug("Request to get FieldTestServiceImplEntity : {}", id);
        return fieldTestServiceImplEntityRepository.findById(id);
    }

    @Override
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete FieldTestServiceImplEntity : {}", id);
        return fieldTestServiceImplEntityRepository.deleteById(id);
    }
}
