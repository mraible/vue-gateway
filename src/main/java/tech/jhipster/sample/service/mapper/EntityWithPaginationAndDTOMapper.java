package tech.jhipster.sample.service.mapper;

import org.mapstruct.*;
import tech.jhipster.sample.domain.EntityWithPaginationAndDTO;
import tech.jhipster.sample.service.dto.EntityWithPaginationAndDTODTO;

/**
 * Mapper for the entity {@link EntityWithPaginationAndDTO} and its DTO {@link EntityWithPaginationAndDTODTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EntityWithPaginationAndDTOMapper extends EntityMapper<EntityWithPaginationAndDTODTO, EntityWithPaginationAndDTO> {}
