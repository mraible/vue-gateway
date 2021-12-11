package tech.jhipster.sample.service.mapper;

import org.mapstruct.*;
import tech.jhipster.sample.domain.EntityWithDTO;
import tech.jhipster.sample.service.dto.EntityWithDTODTO;

/**
 * Mapper for the entity {@link EntityWithDTO} and its DTO {@link EntityWithDTODTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EntityWithDTOMapper extends EntityMapper<EntityWithDTODTO, EntityWithDTO> {}
