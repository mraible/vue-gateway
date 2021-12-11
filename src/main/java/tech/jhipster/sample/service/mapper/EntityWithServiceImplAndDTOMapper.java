package tech.jhipster.sample.service.mapper;

import org.mapstruct.*;
import tech.jhipster.sample.domain.EntityWithServiceImplAndDTO;
import tech.jhipster.sample.service.dto.EntityWithServiceImplAndDTODTO;

/**
 * Mapper for the entity {@link EntityWithServiceImplAndDTO} and its DTO {@link EntityWithServiceImplAndDTODTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EntityWithServiceImplAndDTOMapper extends EntityMapper<EntityWithServiceImplAndDTODTO, EntityWithServiceImplAndDTO> {}
