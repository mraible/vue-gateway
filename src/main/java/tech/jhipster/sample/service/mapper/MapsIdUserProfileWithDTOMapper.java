package tech.jhipster.sample.service.mapper;

import org.mapstruct.*;
import tech.jhipster.sample.domain.MapsIdUserProfileWithDTO;
import tech.jhipster.sample.service.dto.MapsIdUserProfileWithDTODTO;

/**
 * Mapper for the entity {@link MapsIdUserProfileWithDTO} and its DTO {@link MapsIdUserProfileWithDTODTO}.
 */
@Mapper(componentModel = "spring", uses = { UserMapper.class })
public interface MapsIdUserProfileWithDTOMapper extends EntityMapper<MapsIdUserProfileWithDTODTO, MapsIdUserProfileWithDTO> {
    @Mapping(target = "user", source = "user", qualifiedByName = "login")
    MapsIdUserProfileWithDTODTO toDto(MapsIdUserProfileWithDTO s);
}
