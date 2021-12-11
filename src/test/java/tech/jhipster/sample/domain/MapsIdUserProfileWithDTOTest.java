package tech.jhipster.sample.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import tech.jhipster.sample.web.rest.TestUtil;

class MapsIdUserProfileWithDTOTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MapsIdUserProfileWithDTO.class);
        MapsIdUserProfileWithDTO mapsIdUserProfileWithDTO1 = new MapsIdUserProfileWithDTO();
        mapsIdUserProfileWithDTO1.setId(1L);
        MapsIdUserProfileWithDTO mapsIdUserProfileWithDTO2 = new MapsIdUserProfileWithDTO();
        mapsIdUserProfileWithDTO2.setId(mapsIdUserProfileWithDTO1.getId());
        assertThat(mapsIdUserProfileWithDTO1).isEqualTo(mapsIdUserProfileWithDTO2);
        mapsIdUserProfileWithDTO2.setId(2L);
        assertThat(mapsIdUserProfileWithDTO1).isNotEqualTo(mapsIdUserProfileWithDTO2);
        mapsIdUserProfileWithDTO1.setId(null);
        assertThat(mapsIdUserProfileWithDTO1).isNotEqualTo(mapsIdUserProfileWithDTO2);
    }
}
