package tech.jhipster.sample.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static tech.jhipster.sample.web.rest.TestUtil.sameNumber;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.jhipster.sample.IntegrationTest;
import tech.jhipster.sample.domain.Operation;
import tech.jhipster.sample.repository.OperationRepository;
import tech.jhipster.sample.service.EntityManager;

/**
 * Integration tests for the {@link OperationResource} REST controller.
 */
@IntegrationTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureWebTestClient
@WithMockUser
class OperationResourceIT {

    private static final Instant DEFAULT_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_AMOUNT = new BigDecimal(2);

    private static final String ENTITY_API_URL = "/api/operations";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private OperationRepository operationRepository;

    @Mock
    private OperationRepository operationRepositoryMock;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private Operation operation;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Operation createEntity(EntityManager em) {
        Operation operation = new Operation().date(DEFAULT_DATE).description(DEFAULT_DESCRIPTION).amount(DEFAULT_AMOUNT);
        return operation;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Operation createUpdatedEntity(EntityManager em) {
        Operation operation = new Operation().date(UPDATED_DATE).description(UPDATED_DESCRIPTION).amount(UPDATED_AMOUNT);
        return operation;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll("rel_operation__label").block();
            em.deleteAll(Operation.class).block();
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
        operation = createEntity(em);
    }

    @Test
    void createOperation() throws Exception {
        int databaseSizeBeforeCreate = operationRepository.findAll().collectList().block().size();
        // Create the Operation
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(operation))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the Operation in the database
        List<Operation> operationList = operationRepository.findAll().collectList().block();
        assertThat(operationList).hasSize(databaseSizeBeforeCreate + 1);
        Operation testOperation = operationList.get(operationList.size() - 1);
        assertThat(testOperation.getDate()).isEqualTo(DEFAULT_DATE);
        assertThat(testOperation.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testOperation.getAmount()).isEqualByComparingTo(DEFAULT_AMOUNT);
    }

    @Test
    void createOperationWithExistingId() throws Exception {
        // Create the Operation with an existing ID
        operation.setId(1L);

        int databaseSizeBeforeCreate = operationRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(operation))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Operation in the database
        List<Operation> operationList = operationRepository.findAll().collectList().block();
        assertThat(operationList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void checkDateIsRequired() throws Exception {
        int databaseSizeBeforeTest = operationRepository.findAll().collectList().block().size();
        // set the field null
        operation.setDate(null);

        // Create the Operation, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(operation))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<Operation> operationList = operationRepository.findAll().collectList().block();
        assertThat(operationList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkAmountIsRequired() throws Exception {
        int databaseSizeBeforeTest = operationRepository.findAll().collectList().block().size();
        // set the field null
        operation.setAmount(null);

        // Create the Operation, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(operation))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<Operation> operationList = operationRepository.findAll().collectList().block();
        assertThat(operationList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void getAllOperations() {
        // Initialize the database
        operationRepository.save(operation).block();

        // Get all the operationList
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
            .value(hasItem(operation.getId().intValue()))
            .jsonPath("$.[*].date")
            .value(hasItem(DEFAULT_DATE.toString()))
            .jsonPath("$.[*].description")
            .value(hasItem(DEFAULT_DESCRIPTION))
            .jsonPath("$.[*].amount")
            .value(hasItem(sameNumber(DEFAULT_AMOUNT)));
    }

    @SuppressWarnings({ "unchecked" })
    void getAllOperationsWithEagerRelationshipsIsEnabled() {
        when(operationRepositoryMock.findAllWithEagerRelationships(any())).thenReturn(Flux.empty());

        webTestClient.get().uri(ENTITY_API_URL + "?eagerload=true").exchange().expectStatus().isOk();

        verify(operationRepositoryMock, times(1)).findAllWithEagerRelationships(any());
    }

    @SuppressWarnings({ "unchecked" })
    void getAllOperationsWithEagerRelationshipsIsNotEnabled() {
        when(operationRepositoryMock.findAllWithEagerRelationships(any())).thenReturn(Flux.empty());

        webTestClient.get().uri(ENTITY_API_URL + "?eagerload=true").exchange().expectStatus().isOk();

        verify(operationRepositoryMock, times(1)).findAllWithEagerRelationships(any());
    }

    @Test
    void getOperation() {
        // Initialize the database
        operationRepository.save(operation).block();

        // Get the operation
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, operation.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id")
            .value(is(operation.getId().intValue()))
            .jsonPath("$.date")
            .value(is(DEFAULT_DATE.toString()))
            .jsonPath("$.description")
            .value(is(DEFAULT_DESCRIPTION))
            .jsonPath("$.amount")
            .value(is(sameNumber(DEFAULT_AMOUNT)));
    }

    @Test
    void getNonExistingOperation() {
        // Get the operation
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putNewOperation() throws Exception {
        // Initialize the database
        operationRepository.save(operation).block();

        int databaseSizeBeforeUpdate = operationRepository.findAll().collectList().block().size();

        // Update the operation
        Operation updatedOperation = operationRepository.findById(operation.getId()).block();
        updatedOperation.date(UPDATED_DATE).description(UPDATED_DESCRIPTION).amount(UPDATED_AMOUNT);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, updatedOperation.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(updatedOperation))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the Operation in the database
        List<Operation> operationList = operationRepository.findAll().collectList().block();
        assertThat(operationList).hasSize(databaseSizeBeforeUpdate);
        Operation testOperation = operationList.get(operationList.size() - 1);
        assertThat(testOperation.getDate()).isEqualTo(UPDATED_DATE);
        assertThat(testOperation.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testOperation.getAmount()).isEqualTo(UPDATED_AMOUNT);
    }

    @Test
    void putNonExistingOperation() throws Exception {
        int databaseSizeBeforeUpdate = operationRepository.findAll().collectList().block().size();
        operation.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, operation.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(operation))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Operation in the database
        List<Operation> operationList = operationRepository.findAll().collectList().block();
        assertThat(operationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchOperation() throws Exception {
        int databaseSizeBeforeUpdate = operationRepository.findAll().collectList().block().size();
        operation.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(operation))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Operation in the database
        List<Operation> operationList = operationRepository.findAll().collectList().block();
        assertThat(operationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamOperation() throws Exception {
        int databaseSizeBeforeUpdate = operationRepository.findAll().collectList().block().size();
        operation.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(operation))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the Operation in the database
        List<Operation> operationList = operationRepository.findAll().collectList().block();
        assertThat(operationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateOperationWithPatch() throws Exception {
        // Initialize the database
        operationRepository.save(operation).block();

        int databaseSizeBeforeUpdate = operationRepository.findAll().collectList().block().size();

        // Update the operation using partial update
        Operation partialUpdatedOperation = new Operation();
        partialUpdatedOperation.setId(operation.getId());

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedOperation.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedOperation))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the Operation in the database
        List<Operation> operationList = operationRepository.findAll().collectList().block();
        assertThat(operationList).hasSize(databaseSizeBeforeUpdate);
        Operation testOperation = operationList.get(operationList.size() - 1);
        assertThat(testOperation.getDate()).isEqualTo(DEFAULT_DATE);
        assertThat(testOperation.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testOperation.getAmount()).isEqualByComparingTo(DEFAULT_AMOUNT);
    }

    @Test
    void fullUpdateOperationWithPatch() throws Exception {
        // Initialize the database
        operationRepository.save(operation).block();

        int databaseSizeBeforeUpdate = operationRepository.findAll().collectList().block().size();

        // Update the operation using partial update
        Operation partialUpdatedOperation = new Operation();
        partialUpdatedOperation.setId(operation.getId());

        partialUpdatedOperation.date(UPDATED_DATE).description(UPDATED_DESCRIPTION).amount(UPDATED_AMOUNT);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedOperation.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedOperation))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the Operation in the database
        List<Operation> operationList = operationRepository.findAll().collectList().block();
        assertThat(operationList).hasSize(databaseSizeBeforeUpdate);
        Operation testOperation = operationList.get(operationList.size() - 1);
        assertThat(testOperation.getDate()).isEqualTo(UPDATED_DATE);
        assertThat(testOperation.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testOperation.getAmount()).isEqualByComparingTo(UPDATED_AMOUNT);
    }

    @Test
    void patchNonExistingOperation() throws Exception {
        int databaseSizeBeforeUpdate = operationRepository.findAll().collectList().block().size();
        operation.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, operation.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(operation))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Operation in the database
        List<Operation> operationList = operationRepository.findAll().collectList().block();
        assertThat(operationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchOperation() throws Exception {
        int databaseSizeBeforeUpdate = operationRepository.findAll().collectList().block().size();
        operation.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(operation))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Operation in the database
        List<Operation> operationList = operationRepository.findAll().collectList().block();
        assertThat(operationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamOperation() throws Exception {
        int databaseSizeBeforeUpdate = operationRepository.findAll().collectList().block().size();
        operation.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(operation))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the Operation in the database
        List<Operation> operationList = operationRepository.findAll().collectList().block();
        assertThat(operationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteOperation() {
        // Initialize the database
        operationRepository.save(operation).block();

        int databaseSizeBeforeDelete = operationRepository.findAll().collectList().block().size();

        // Delete the operation
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, operation.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<Operation> operationList = operationRepository.findAll().collectList().block();
        assertThat(operationList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
