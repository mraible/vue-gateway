package tech.jhipster.sample.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import tech.jhipster.sample.web.rest.TestUtil;

class FieldTestMapstructAndServiceClassEntityTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FieldTestMapstructAndServiceClassEntity.class);
        FieldTestMapstructAndServiceClassEntity fieldTestMapstructAndServiceClassEntity1 = new FieldTestMapstructAndServiceClassEntity();
        fieldTestMapstructAndServiceClassEntity1.setId(1L);
        FieldTestMapstructAndServiceClassEntity fieldTestMapstructAndServiceClassEntity2 = new FieldTestMapstructAndServiceClassEntity();
        fieldTestMapstructAndServiceClassEntity2.setId(fieldTestMapstructAndServiceClassEntity1.getId());
        assertThat(fieldTestMapstructAndServiceClassEntity1).isEqualTo(fieldTestMapstructAndServiceClassEntity2);
        fieldTestMapstructAndServiceClassEntity2.setId(2L);
        assertThat(fieldTestMapstructAndServiceClassEntity1).isNotEqualTo(fieldTestMapstructAndServiceClassEntity2);
        fieldTestMapstructAndServiceClassEntity1.setId(null);
        assertThat(fieldTestMapstructAndServiceClassEntity1).isNotEqualTo(fieldTestMapstructAndServiceClassEntity2);
    }
}
