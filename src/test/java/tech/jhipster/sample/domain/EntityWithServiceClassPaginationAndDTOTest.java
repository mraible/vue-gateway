package tech.jhipster.sample.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import tech.jhipster.sample.web.rest.TestUtil;

class EntityWithServiceClassPaginationAndDTOTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(EntityWithServiceClassPaginationAndDTO.class);
        EntityWithServiceClassPaginationAndDTO entityWithServiceClassPaginationAndDTO1 = new EntityWithServiceClassPaginationAndDTO();
        entityWithServiceClassPaginationAndDTO1.setId(1L);
        EntityWithServiceClassPaginationAndDTO entityWithServiceClassPaginationAndDTO2 = new EntityWithServiceClassPaginationAndDTO();
        entityWithServiceClassPaginationAndDTO2.setId(entityWithServiceClassPaginationAndDTO1.getId());
        assertThat(entityWithServiceClassPaginationAndDTO1).isEqualTo(entityWithServiceClassPaginationAndDTO2);
        entityWithServiceClassPaginationAndDTO2.setId(2L);
        assertThat(entityWithServiceClassPaginationAndDTO1).isNotEqualTo(entityWithServiceClassPaginationAndDTO2);
        entityWithServiceClassPaginationAndDTO1.setId(null);
        assertThat(entityWithServiceClassPaginationAndDTO1).isNotEqualTo(entityWithServiceClassPaginationAndDTO2);
    }
}
