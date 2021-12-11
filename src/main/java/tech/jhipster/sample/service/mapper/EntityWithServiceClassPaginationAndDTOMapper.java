package tech.jhipster.sample.service.mapper;

import org.mapstruct.*;
import tech.jhipster.sample.domain.EntityWithServiceClassPaginationAndDTO;
import tech.jhipster.sample.service.dto.EntityWithServiceClassPaginationAndDTODTO;

/**
 * Mapper for the entity {@link EntityWithServiceClassPaginationAndDTO} and its DTO {@link EntityWithServiceClassPaginationAndDTODTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EntityWithServiceClassPaginationAndDTOMapper
    extends EntityMapper<EntityWithServiceClassPaginationAndDTODTO, EntityWithServiceClassPaginationAndDTO> {}
