package tech.jhipster.sample.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MapsIdUserProfileWithDTOMapperTest {

    private MapsIdUserProfileWithDTOMapper mapsIdUserProfileWithDTOMapper;

    @BeforeEach
    public void setUp() {
        mapsIdUserProfileWithDTOMapper = new MapsIdUserProfileWithDTOMapperImpl();
    }
}
