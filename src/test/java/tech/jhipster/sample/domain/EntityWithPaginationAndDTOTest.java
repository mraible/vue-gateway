package tech.jhipster.sample.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import tech.jhipster.sample.web.rest.TestUtil;

class EntityWithPaginationAndDTOTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(EntityWithPaginationAndDTO.class);
        EntityWithPaginationAndDTO entityWithPaginationAndDTO1 = new EntityWithPaginationAndDTO();
        entityWithPaginationAndDTO1.setId(1L);
        EntityWithPaginationAndDTO entityWithPaginationAndDTO2 = new EntityWithPaginationAndDTO();
        entityWithPaginationAndDTO2.setId(entityWithPaginationAndDTO1.getId());
        assertThat(entityWithPaginationAndDTO1).isEqualTo(entityWithPaginationAndDTO2);
        entityWithPaginationAndDTO2.setId(2L);
        assertThat(entityWithPaginationAndDTO1).isNotEqualTo(entityWithPaginationAndDTO2);
        entityWithPaginationAndDTO1.setId(null);
        assertThat(entityWithPaginationAndDTO1).isNotEqualTo(entityWithPaginationAndDTO2);
    }
}
