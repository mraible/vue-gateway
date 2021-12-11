package tech.jhipster.sample.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import tech.jhipster.sample.web.rest.TestUtil;

class FieldTestInfiniteScrollEntityTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FieldTestInfiniteScrollEntity.class);
        FieldTestInfiniteScrollEntity fieldTestInfiniteScrollEntity1 = new FieldTestInfiniteScrollEntity();
        fieldTestInfiniteScrollEntity1.setId(1L);
        FieldTestInfiniteScrollEntity fieldTestInfiniteScrollEntity2 = new FieldTestInfiniteScrollEntity();
        fieldTestInfiniteScrollEntity2.setId(fieldTestInfiniteScrollEntity1.getId());
        assertThat(fieldTestInfiniteScrollEntity1).isEqualTo(fieldTestInfiniteScrollEntity2);
        fieldTestInfiniteScrollEntity2.setId(2L);
        assertThat(fieldTestInfiniteScrollEntity1).isNotEqualTo(fieldTestInfiniteScrollEntity2);
        fieldTestInfiniteScrollEntity1.setId(null);
        assertThat(fieldTestInfiniteScrollEntity1).isNotEqualTo(fieldTestInfiniteScrollEntity2);
    }
}
