package tech.jhipster.sample.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;
import tech.jhipster.sample.IntegrationTest;
import tech.jhipster.sample.domain.FieldTestEnumWithValue;
import tech.jhipster.sample.domain.enumeration.MyEnumA;
import tech.jhipster.sample.domain.enumeration.MyEnumB;
import tech.jhipster.sample.domain.enumeration.MyEnumC;
import tech.jhipster.sample.repository.FieldTestEnumWithValueRepository;
import tech.jhipster.sample.service.EntityManager;

/**
 * Integration tests for the {@link FieldTestEnumWithValueResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient
@WithMockUser
class FieldTestEnumWithValueResourceIT {

    private static final MyEnumA DEFAULT_MY_FIELD_A = MyEnumA.AAA;
    private static final MyEnumA UPDATED_MY_FIELD_A = MyEnumA.BBB;

    private static final MyEnumB DEFAULT_MY_FIELD_B = MyEnumB.AAA;
    private static final MyEnumB UPDATED_MY_FIELD_B = MyEnumB.BBB;

    private static final MyEnumC DEFAULT_MY_FIELD_C = MyEnumC.AAA;
    private static final MyEnumC UPDATED_MY_FIELD_C = MyEnumC.BBB;

    private static final String ENTITY_API_URL = "/api/field-test-enum-with-values";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private FieldTestEnumWithValueRepository fieldTestEnumWithValueRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private FieldTestEnumWithValue fieldTestEnumWithValue;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FieldTestEnumWithValue createEntity(EntityManager em) {
        FieldTestEnumWithValue fieldTestEnumWithValue = new FieldTestEnumWithValue()
            .myFieldA(DEFAULT_MY_FIELD_A)
            .myFieldB(DEFAULT_MY_FIELD_B)
            .myFieldC(DEFAULT_MY_FIELD_C);
        return fieldTestEnumWithValue;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FieldTestEnumWithValue createUpdatedEntity(EntityManager em) {
        FieldTestEnumWithValue fieldTestEnumWithValue = new FieldTestEnumWithValue()
            .myFieldA(UPDATED_MY_FIELD_A)
            .myFieldB(UPDATED_MY_FIELD_B)
            .myFieldC(UPDATED_MY_FIELD_C);
        return fieldTestEnumWithValue;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(FieldTestEnumWithValue.class).block();
        } catch (Exception e) {
            // It can fail, if other entities are still referring this - it will be removed later.
        }
    }

    @AfterEach
    public void cleanup() {
        deleteEntities(em);
    }

    @BeforeEach
    public void initTest() {
        deleteEntities(em);
        fieldTestEnumWithValue = createEntity(em);
    }

    @Test
    void createFieldTestEnumWithValue() throws Exception {
        int databaseSizeBeforeCreate = fieldTestEnumWithValueRepository.findAll().collectList().block().size();
        // Create the FieldTestEnumWithValue
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEnumWithValue))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the FieldTestEnumWithValue in the database
        List<FieldTestEnumWithValue> fieldTestEnumWithValueList = fieldTestEnumWithValueRepository.findAll().collectList().block();
        assertThat(fieldTestEnumWithValueList).hasSize(databaseSizeBeforeCreate + 1);
        FieldTestEnumWithValue testFieldTestEnumWithValue = fieldTestEnumWithValueList.get(fieldTestEnumWithValueList.size() - 1);
        assertThat(testFieldTestEnumWithValue.getMyFieldA()).isEqualTo(DEFAULT_MY_FIELD_A);
        assertThat(testFieldTestEnumWithValue.getMyFieldB()).isEqualTo(DEFAULT_MY_FIELD_B);
        assertThat(testFieldTestEnumWithValue.getMyFieldC()).isEqualTo(DEFAULT_MY_FIELD_C);
    }

    @Test
    void createFieldTestEnumWithValueWithExistingId() throws Exception {
        // Create the FieldTestEnumWithValue with an existing ID
        fieldTestEnumWithValue.setId(1L);

        int databaseSizeBeforeCreate = fieldTestEnumWithValueRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEnumWithValue))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestEnumWithValue in the database
        List<FieldTestEnumWithValue> fieldTestEnumWithValueList = fieldTestEnumWithValueRepository.findAll().collectList().block();
        assertThat(fieldTestEnumWithValueList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void getAllFieldTestEnumWithValuesAsStream() {
        // Initialize the database
        fieldTestEnumWithValueRepository.save(fieldTestEnumWithValue).block();

        List<FieldTestEnumWithValue> fieldTestEnumWithValueList = webTestClient
            .get()
            .uri(ENTITY_API_URL)
            .accept(MediaType.APPLICATION_NDJSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentTypeCompatibleWith(MediaType.APPLICATION_NDJSON)
            .returnResult(FieldTestEnumWithValue.class)
            .getResponseBody()
            .filter(fieldTestEnumWithValue::equals)
            .collectList()
            .block(Duration.ofSeconds(5));

        assertThat(fieldTestEnumWithValueList).isNotNull();
        assertThat(fieldTestEnumWithValueList).hasSize(1);
        FieldTestEnumWithValue testFieldTestEnumWithValue = fieldTestEnumWithValueList.get(0);
        assertThat(testFieldTestEnumWithValue.getMyFieldA()).isEqualTo(DEFAULT_MY_FIELD_A);
        assertThat(testFieldTestEnumWithValue.getMyFieldB()).isEqualTo(DEFAULT_MY_FIELD_B);
        assertThat(testFieldTestEnumWithValue.getMyFieldC()).isEqualTo(DEFAULT_MY_FIELD_C);
    }

    @Test
    void getAllFieldTestEnumWithValues() {
        // Initialize the database
        fieldTestEnumWithValueRepository.save(fieldTestEnumWithValue).block();

        // Get all the fieldTestEnumWithValueList
        webTestClient
            .get()
            .uri(ENTITY_API_URL + "?sort=id,desc")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.[*].id")
            .value(hasItem(fieldTestEnumWithValue.getId().intValue()))
            .jsonPath("$.[*].myFieldA")
            .value(hasItem(DEFAULT_MY_FIELD_A.toString()))
            .jsonPath("$.[*].myFieldB")
            .value(hasItem(DEFAULT_MY_FIELD_B.toString()))
            .jsonPath("$.[*].myFieldC")
            .value(hasItem(DEFAULT_MY_FIELD_C.toString()));
    }

    @Test
    void getFieldTestEnumWithValue() {
        // Initialize the database
        fieldTestEnumWithValueRepository.save(fieldTestEnumWithValue).block();

        // Get the fieldTestEnumWithValue
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, fieldTestEnumWithValue.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id")
            .value(is(fieldTestEnumWithValue.getId().intValue()))
            .jsonPath("$.myFieldA")
            .value(is(DEFAULT_MY_FIELD_A.toString()))
            .jsonPath("$.myFieldB")
            .value(is(DEFAULT_MY_FIELD_B.toString()))
            .jsonPath("$.myFieldC")
            .value(is(DEFAULT_MY_FIELD_C.toString()));
    }

    @Test
    void getNonExistingFieldTestEnumWithValue() {
        // Get the fieldTestEnumWithValue
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putNewFieldTestEnumWithValue() throws Exception {
        // Initialize the database
        fieldTestEnumWithValueRepository.save(fieldTestEnumWithValue).block();

        int databaseSizeBeforeUpdate = fieldTestEnumWithValueRepository.findAll().collectList().block().size();

        // Update the fieldTestEnumWithValue
        FieldTestEnumWithValue updatedFieldTestEnumWithValue = fieldTestEnumWithValueRepository
            .findById(fieldTestEnumWithValue.getId())
            .block();
        updatedFieldTestEnumWithValue.myFieldA(UPDATED_MY_FIELD_A).myFieldB(UPDATED_MY_FIELD_B).myFieldC(UPDATED_MY_FIELD_C);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, updatedFieldTestEnumWithValue.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(updatedFieldTestEnumWithValue))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the FieldTestEnumWithValue in the database
        List<FieldTestEnumWithValue> fieldTestEnumWithValueList = fieldTestEnumWithValueRepository.findAll().collectList().block();
        assertThat(fieldTestEnumWithValueList).hasSize(databaseSizeBeforeUpdate);
        FieldTestEnumWithValue testFieldTestEnumWithValue = fieldTestEnumWithValueList.get(fieldTestEnumWithValueList.size() - 1);
        assertThat(testFieldTestEnumWithValue.getMyFieldA()).isEqualTo(UPDATED_MY_FIELD_A);
        assertThat(testFieldTestEnumWithValue.getMyFieldB()).isEqualTo(UPDATED_MY_FIELD_B);
        assertThat(testFieldTestEnumWithValue.getMyFieldC()).isEqualTo(UPDATED_MY_FIELD_C);
    }

    @Test
    void putNonExistingFieldTestEnumWithValue() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestEnumWithValueRepository.findAll().collectList().block().size();
        fieldTestEnumWithValue.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, fieldTestEnumWithValue.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEnumWithValue))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestEnumWithValue in the database
        List<FieldTestEnumWithValue> fieldTestEnumWithValueList = fieldTestEnumWithValueRepository.findAll().collectList().block();
        assertThat(fieldTestEnumWithValueList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchFieldTestEnumWithValue() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestEnumWithValueRepository.findAll().collectList().block().size();
        fieldTestEnumWithValue.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEnumWithValue))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestEnumWithValue in the database
        List<FieldTestEnumWithValue> fieldTestEnumWithValueList = fieldTestEnumWithValueRepository.findAll().collectList().block();
        assertThat(fieldTestEnumWithValueList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamFieldTestEnumWithValue() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestEnumWithValueRepository.findAll().collectList().block().size();
        fieldTestEnumWithValue.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEnumWithValue))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the FieldTestEnumWithValue in the database
        List<FieldTestEnumWithValue> fieldTestEnumWithValueList = fieldTestEnumWithValueRepository.findAll().collectList().block();
        assertThat(fieldTestEnumWithValueList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateFieldTestEnumWithValueWithPatch() throws Exception {
        // Initialize the database
        fieldTestEnumWithValueRepository.save(fieldTestEnumWithValue).block();

        int databaseSizeBeforeUpdate = fieldTestEnumWithValueRepository.findAll().collectList().block().size();

        // Update the fieldTestEnumWithValue using partial update
        FieldTestEnumWithValue partialUpdatedFieldTestEnumWithValue = new FieldTestEnumWithValue();
        partialUpdatedFieldTestEnumWithValue.setId(fieldTestEnumWithValue.getId());

        partialUpdatedFieldTestEnumWithValue.myFieldB(UPDATED_MY_FIELD_B);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedFieldTestEnumWithValue.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedFieldTestEnumWithValue))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the FieldTestEnumWithValue in the database
        List<FieldTestEnumWithValue> fieldTestEnumWithValueList = fieldTestEnumWithValueRepository.findAll().collectList().block();
        assertThat(fieldTestEnumWithValueList).hasSize(databaseSizeBeforeUpdate);
        FieldTestEnumWithValue testFieldTestEnumWithValue = fieldTestEnumWithValueList.get(fieldTestEnumWithValueList.size() - 1);
        assertThat(testFieldTestEnumWithValue.getMyFieldA()).isEqualTo(DEFAULT_MY_FIELD_A);
        assertThat(testFieldTestEnumWithValue.getMyFieldB()).isEqualTo(UPDATED_MY_FIELD_B);
        assertThat(testFieldTestEnumWithValue.getMyFieldC()).isEqualTo(DEFAULT_MY_FIELD_C);
    }

    @Test
    void fullUpdateFieldTestEnumWithValueWithPatch() throws Exception {
        // Initialize the database
        fieldTestEnumWithValueRepository.save(fieldTestEnumWithValue).block();

        int databaseSizeBeforeUpdate = fieldTestEnumWithValueRepository.findAll().collectList().block().size();

        // Update the fieldTestEnumWithValue using partial update
        FieldTestEnumWithValue partialUpdatedFieldTestEnumWithValue = new FieldTestEnumWithValue();
        partialUpdatedFieldTestEnumWithValue.setId(fieldTestEnumWithValue.getId());

        partialUpdatedFieldTestEnumWithValue.myFieldA(UPDATED_MY_FIELD_A).myFieldB(UPDATED_MY_FIELD_B).myFieldC(UPDATED_MY_FIELD_C);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedFieldTestEnumWithValue.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedFieldTestEnumWithValue))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the FieldTestEnumWithValue in the database
        List<FieldTestEnumWithValue> fieldTestEnumWithValueList = fieldTestEnumWithValueRepository.findAll().collectList().block();
        assertThat(fieldTestEnumWithValueList).hasSize(databaseSizeBeforeUpdate);
        FieldTestEnumWithValue testFieldTestEnumWithValue = fieldTestEnumWithValueList.get(fieldTestEnumWithValueList.size() - 1);
        assertThat(testFieldTestEnumWithValue.getMyFieldA()).isEqualTo(UPDATED_MY_FIELD_A);
        assertThat(testFieldTestEnumWithValue.getMyFieldB()).isEqualTo(UPDATED_MY_FIELD_B);
        assertThat(testFieldTestEnumWithValue.getMyFieldC()).isEqualTo(UPDATED_MY_FIELD_C);
    }

    @Test
    void patchNonExistingFieldTestEnumWithValue() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestEnumWithValueRepository.findAll().collectList().block().size();
        fieldTestEnumWithValue.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, fieldTestEnumWithValue.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEnumWithValue))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestEnumWithValue in the database
        List<FieldTestEnumWithValue> fieldTestEnumWithValueList = fieldTestEnumWithValueRepository.findAll().collectList().block();
        assertThat(fieldTestEnumWithValueList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchFieldTestEnumWithValue() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestEnumWithValueRepository.findAll().collectList().block().size();
        fieldTestEnumWithValue.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEnumWithValue))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestEnumWithValue in the database
        List<FieldTestEnumWithValue> fieldTestEnumWithValueList = fieldTestEnumWithValueRepository.findAll().collectList().block();
        assertThat(fieldTestEnumWithValueList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamFieldTestEnumWithValue() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestEnumWithValueRepository.findAll().collectList().block().size();
        fieldTestEnumWithValue.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEnumWithValue))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the FieldTestEnumWithValue in the database
        List<FieldTestEnumWithValue> fieldTestEnumWithValueList = fieldTestEnumWithValueRepository.findAll().collectList().block();
        assertThat(fieldTestEnumWithValueList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteFieldTestEnumWithValue() {
        // Initialize the database
        fieldTestEnumWithValueRepository.save(fieldTestEnumWithValue).block();

        int databaseSizeBeforeDelete = fieldTestEnumWithValueRepository.findAll().collectList().block().size();

        // Delete the fieldTestEnumWithValue
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, fieldTestEnumWithValue.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<FieldTestEnumWithValue> fieldTestEnumWithValueList = fieldTestEnumWithValueRepository.findAll().collectList().block();
        assertThat(fieldTestEnumWithValueList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
