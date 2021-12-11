package tech.jhipster.sample.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import tech.jhipster.sample.web.rest.TestUtil;

class FieldTestMapstructAndServiceClassEntityDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(FieldTestMapstructAndServiceClassEntityDTO.class);
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO1 = new FieldTestMapstructAndServiceClassEntityDTO();
        fieldTestMapstructAndServiceClassEntityDTO1.setId(1L);
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO2 = new FieldTestMapstructAndServiceClassEntityDTO();
        assertThat(fieldTestMapstructAndServiceClassEntityDTO1).isNotEqualTo(fieldTestMapstructAndServiceClassEntityDTO2);
        fieldTestMapstructAndServiceClassEntityDTO2.setId(fieldTestMapstructAndServiceClassEntityDTO1.getId());
        assertThat(fieldTestMapstructAndServiceClassEntityDTO1).isEqualTo(fieldTestMapstructAndServiceClassEntityDTO2);
        fieldTestMapstructAndServiceClassEntityDTO2.setId(2L);
        assertThat(fieldTestMapstructAndServiceClassEntityDTO1).isNotEqualTo(fieldTestMapstructAndServiceClassEntityDTO2);
        fieldTestMapstructAndServiceClassEntityDTO1.setId(null);
        assertThat(fieldTestMapstructAndServiceClassEntityDTO1).isNotEqualTo(fieldTestMapstructAndServiceClassEntityDTO2);
    }
}
