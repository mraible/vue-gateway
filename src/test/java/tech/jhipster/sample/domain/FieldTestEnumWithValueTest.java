package tech.jhipster.sample.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import tech.jhipster.sample.web.rest.TestUtil;

class FieldTestEnumWithValueTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FieldTestEnumWithValue.class);
        FieldTestEnumWithValue fieldTestEnumWithValue1 = new FieldTestEnumWithValue();
        fieldTestEnumWithValue1.setId(1L);
        FieldTestEnumWithValue fieldTestEnumWithValue2 = new FieldTestEnumWithValue();
        fieldTestEnumWithValue2.setId(fieldTestEnumWithValue1.getId());
        assertThat(fieldTestEnumWithValue1).isEqualTo(fieldTestEnumWithValue2);
        fieldTestEnumWithValue2.setId(2L);
        assertThat(fieldTestEnumWithValue1).isNotEqualTo(fieldTestEnumWithValue2);
        fieldTestEnumWithValue1.setId(null);
        assertThat(fieldTestEnumWithValue1).isNotEqualTo(fieldTestEnumWithValue2);
    }
}
