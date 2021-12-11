package tech.jhipster.sample.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import tech.jhipster.sample.web.rest.TestUtil;

class EntityWithDTODTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(EntityWithDTODTO.class);
        EntityWithDTODTO entityWithDTODTO1 = new EntityWithDTODTO();
        entityWithDTODTO1.setId(1L);
        EntityWithDTODTO entityWithDTODTO2 = new EntityWithDTODTO();
        assertThat(entityWithDTODTO1).isNotEqualTo(entityWithDTODTO2);
        entityWithDTODTO2.setId(entityWithDTODTO1.getId());
        assertThat(entityWithDTODTO1).isEqualTo(entityWithDTODTO2);
        entityWithDTODTO2.setId(2L);
        assertThat(entityWithDTODTO1).isNotEqualTo(entityWithDTODTO2);
        entityWithDTODTO1.setId(null);
        assertThat(entityWithDTODTO1).isNotEqualTo(entityWithDTODTO2);
    }
}
