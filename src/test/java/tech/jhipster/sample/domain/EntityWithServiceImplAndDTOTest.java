package tech.jhipster.sample.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import tech.jhipster.sample.web.rest.TestUtil;

class EntityWithServiceImplAndDTOTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(EntityWithServiceImplAndDTO.class);
        EntityWithServiceImplAndDTO entityWithServiceImplAndDTO1 = new EntityWithServiceImplAndDTO();
        entityWithServiceImplAndDTO1.setId(1L);
        EntityWithServiceImplAndDTO entityWithServiceImplAndDTO2 = new EntityWithServiceImplAndDTO();
        entityWithServiceImplAndDTO2.setId(entityWithServiceImplAndDTO1.getId());
        assertThat(entityWithServiceImplAndDTO1).isEqualTo(entityWithServiceImplAndDTO2);
        entityWithServiceImplAndDTO2.setId(2L);
        assertThat(entityWithServiceImplAndDTO1).isNotEqualTo(entityWithServiceImplAndDTO2);
        entityWithServiceImplAndDTO1.setId(null);
        assertThat(entityWithServiceImplAndDTO1).isNotEqualTo(entityWithServiceImplAndDTO2);
    }
}
