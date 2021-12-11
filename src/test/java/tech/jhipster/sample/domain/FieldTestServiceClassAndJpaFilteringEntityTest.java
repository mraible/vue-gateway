package tech.jhipster.sample.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import tech.jhipster.sample.web.rest.TestUtil;

class FieldTestServiceClassAndJpaFilteringEntityTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FieldTestServiceClassAndJpaFilteringEntity.class);
        FieldTestServiceClassAndJpaFilteringEntity fieldTestServiceClassAndJpaFilteringEntity1 = new FieldTestServiceClassAndJpaFilteringEntity();
        fieldTestServiceClassAndJpaFilteringEntity1.setId(1L);
        FieldTestServiceClassAndJpaFilteringEntity fieldTestServiceClassAndJpaFilteringEntity2 = new FieldTestServiceClassAndJpaFilteringEntity();
        fieldTestServiceClassAndJpaFilteringEntity2.setId(fieldTestServiceClassAndJpaFilteringEntity1.getId());
        assertThat(fieldTestServiceClassAndJpaFilteringEntity1).isEqualTo(fieldTestServiceClassAndJpaFilteringEntity2);
        fieldTestServiceClassAndJpaFilteringEntity2.setId(2L);
        assertThat(fieldTestServiceClassAndJpaFilteringEntity1).isNotEqualTo(fieldTestServiceClassAndJpaFilteringEntity2);
        fieldTestServiceClassAndJpaFilteringEntity1.setId(null);
        assertThat(fieldTestServiceClassAndJpaFilteringEntity1).isNotEqualTo(fieldTestServiceClassAndJpaFilteringEntity2);
    }
}
