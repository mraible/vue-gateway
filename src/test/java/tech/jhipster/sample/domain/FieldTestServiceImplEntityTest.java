package tech.jhipster.sample.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import tech.jhipster.sample.web.rest.TestUtil;

class FieldTestServiceImplEntityTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FieldTestServiceImplEntity.class);
        FieldTestServiceImplEntity fieldTestServiceImplEntity1 = new FieldTestServiceImplEntity();
        fieldTestServiceImplEntity1.setId(1L);
        FieldTestServiceImplEntity fieldTestServiceImplEntity2 = new FieldTestServiceImplEntity();
        fieldTestServiceImplEntity2.setId(fieldTestServiceImplEntity1.getId());
        assertThat(fieldTestServiceImplEntity1).isEqualTo(fieldTestServiceImplEntity2);
        fieldTestServiceImplEntity2.setId(2L);
        assertThat(fieldTestServiceImplEntity1).isNotEqualTo(fieldTestServiceImplEntity2);
        fieldTestServiceImplEntity1.setId(null);
        assertThat(fieldTestServiceImplEntity1).isNotEqualTo(fieldTestServiceImplEntity2);
    }
}
