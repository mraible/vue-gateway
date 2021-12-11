package tech.jhipster.sample.service.mapper;

import org.mapstruct.*;
import tech.jhipster.sample.domain.FieldTestMapstructAndServiceClassEntity;
import tech.jhipster.sample.service.dto.FieldTestMapstructAndServiceClassEntityDTO;

/**
 * Mapper for the entity {@link FieldTestMapstructAndServiceClassEntity} and its DTO {@link FieldTestMapstructAndServiceClassEntityDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface FieldTestMapstructAndServiceClassEntityMapper
    extends EntityMapper<FieldTestMapstructAndServiceClassEntityDTO, FieldTestMapstructAndServiceClassEntity> {}
