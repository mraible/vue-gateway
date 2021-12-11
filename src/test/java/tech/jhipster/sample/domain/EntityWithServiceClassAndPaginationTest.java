package tech.jhipster.sample.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import tech.jhipster.sample.web.rest.TestUtil;

class EntityWithServiceClassAndPaginationTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(EntityWithServiceClassAndPagination.class);
        EntityWithServiceClassAndPagination entityWithServiceClassAndPagination1 = new EntityWithServiceClassAndPagination();
        entityWithServiceClassAndPagination1.setId(1L);
        EntityWithServiceClassAndPagination entityWithServiceClassAndPagination2 = new EntityWithServiceClassAndPagination();
        entityWithServiceClassAndPagination2.setId(entityWithServiceClassAndPagination1.getId());
        assertThat(entityWithServiceClassAndPagination1).isEqualTo(entityWithServiceClassAndPagination2);
        entityWithServiceClassAndPagination2.setId(2L);
        assertThat(entityWithServiceClassAndPagination1).isNotEqualTo(entityWithServiceClassAndPagination2);
        entityWithServiceClassAndPagination1.setId(null);
        assertThat(entityWithServiceClassAndPagination1).isNotEqualTo(entityWithServiceClassAndPagination2);
    }
}
