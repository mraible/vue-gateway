package tech.jhipster.sample.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import tech.jhipster.sample.web.rest.TestUtil;

class FieldTestPaginationEntityTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FieldTestPaginationEntity.class);
        FieldTestPaginationEntity fieldTestPaginationEntity1 = new FieldTestPaginationEntity();
        fieldTestPaginationEntity1.setId(1L);
        FieldTestPaginationEntity fieldTestPaginationEntity2 = new FieldTestPaginationEntity();
        fieldTestPaginationEntity2.setId(fieldTestPaginationEntity1.getId());
        assertThat(fieldTestPaginationEntity1).isEqualTo(fieldTestPaginationEntity2);
        fieldTestPaginationEntity2.setId(2L);
        assertThat(fieldTestPaginationEntity1).isNotEqualTo(fieldTestPaginationEntity2);
        fieldTestPaginationEntity1.setId(null);
        assertThat(fieldTestPaginationEntity1).isNotEqualTo(fieldTestPaginationEntity2);
    }
}
