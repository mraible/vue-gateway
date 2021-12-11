package tech.jhipster.sample.service.mapper;

import org.mapstruct.*;
import tech.jhipster.sample.domain.EntityWithServiceImplPaginationAndDTO;
import tech.jhipster.sample.service.dto.EntityWithServiceImplPaginationAndDTODTO;

/**
 * Mapper for the entity {@link EntityWithServiceImplPaginationAndDTO} and its DTO {@link EntityWithServiceImplPaginationAndDTODTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EntityWithServiceImplPaginationAndDTOMapper
    extends EntityMapper<EntityWithServiceImplPaginationAndDTODTO, EntityWithServiceImplPaginationAndDTO> {}
