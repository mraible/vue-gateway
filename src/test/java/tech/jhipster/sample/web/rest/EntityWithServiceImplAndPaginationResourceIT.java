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
import tech.jhipster.sample.domain.EntityWithServiceImplAndPagination;
import tech.jhipster.sample.repository.EntityWithServiceImplAndPaginationRepository;
import tech.jhipster.sample.service.EntityManager;

/**
 * Integration tests for the {@link EntityWithServiceImplAndPaginationResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient
@WithMockUser
class EntityWithServiceImplAndPaginationResourceIT {

    private static final String DEFAULT_HUGO = "AAAAAAAAAA";
    private static final String UPDATED_HUGO = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/entity-with-service-impl-and-paginations";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private EntityWithServiceImplAndPaginationRepository entityWithServiceImplAndPaginationRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private EntityWithServiceImplAndPagination entityWithServiceImplAndPagination;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static EntityWithServiceImplAndPagination createEntity(EntityManager em) {
        EntityWithServiceImplAndPagination entityWithServiceImplAndPagination = new EntityWithServiceImplAndPagination().hugo(DEFAULT_HUGO);
        return entityWithServiceImplAndPagination;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static EntityWithServiceImplAndPagination createUpdatedEntity(EntityManager em) {
        EntityWithServiceImplAndPagination entityWithServiceImplAndPagination = new EntityWithServiceImplAndPagination().hugo(UPDATED_HUGO);
        return entityWithServiceImplAndPagination;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(EntityWithServiceImplAndPagination.class).block();
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
        entityWithServiceImplAndPagination = createEntity(em);
    }

    @Test
    void createEntityWithServiceImplAndPagination() throws Exception {
        int databaseSizeBeforeCreate = entityWithServiceImplAndPaginationRepository.findAll().collectList().block().size();
        // Create the EntityWithServiceImplAndPagination
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceImplAndPagination))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the EntityWithServiceImplAndPagination in the database
        List<EntityWithServiceImplAndPagination> entityWithServiceImplAndPaginationList = entityWithServiceImplAndPaginationRepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplAndPaginationList).hasSize(databaseSizeBeforeCreate + 1);
        EntityWithServiceImplAndPagination testEntityWithServiceImplAndPagination = entityWithServiceImplAndPaginationList.get(
            entityWithServiceImplAndPaginationList.size() - 1
        );
        assertThat(testEntityWithServiceImplAndPagination.getHugo()).isEqualTo(DEFAULT_HUGO);
    }

    @Test
    void createEntityWithServiceImplAndPaginationWithExistingId() throws Exception {
        // Create the EntityWithServiceImplAndPagination with an existing ID
        entityWithServiceImplAndPagination.setId(1L);

        int databaseSizeBeforeCreate = entityWithServiceImplAndPaginationRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceImplAndPagination))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the EntityWithServiceImplAndPagination in the database
        List<EntityWithServiceImplAndPagination> entityWithServiceImplAndPaginationList = entityWithServiceImplAndPaginationRepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplAndPaginationList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void getAllEntityWithServiceImplAndPaginations() {
        // Initialize the database
        entityWithServiceImplAndPaginationRepository.save(entityWithServiceImplAndPagination).block();

        // Get all the entityWithServiceImplAndPaginationList
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
            .value(hasItem(entityWithServiceImplAndPagination.getId().intValue()))
            .jsonPath("$.[*].hugo")
            .value(hasItem(DEFAULT_HUGO));
    }

    @Test
    void getEntityWithServiceImplAndPagination() {
        // Initialize the database
        entityWithServiceImplAndPaginationRepository.save(entityWithServiceImplAndPagination).block();

        // Get the entityWithServiceImplAndPagination
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, entityWithServiceImplAndPagination.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id")
            .value(is(entityWithServiceImplAndPagination.getId().intValue()))
            .jsonPath("$.hugo")
            .value(is(DEFAULT_HUGO));
    }

    @Test
    void getNonExistingEntityWithServiceImplAndPagination() {
        // Get the entityWithServiceImplAndPagination
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putNewEntityWithServiceImplAndPagination() throws Exception {
        // Initialize the database
        entityWithServiceImplAndPaginationRepository.save(entityWithServiceImplAndPagination).block();

        int databaseSizeBeforeUpdate = entityWithServiceImplAndPaginationRepository.findAll().collectList().block().size();

        // Update the entityWithServiceImplAndPagination
        EntityWithServiceImplAndPagination updatedEntityWithServiceImplAndPagination = entityWithServiceImplAndPaginationRepository
            .findById(entityWithServiceImplAndPagination.getId())
            .block();
        updatedEntityWithServiceImplAndPagination.hugo(UPDATED_HUGO);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, updatedEntityWithServiceImplAndPagination.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(updatedEntityWithServiceImplAndPagination))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the EntityWithServiceImplAndPagination in the database
        List<EntityWithServiceImplAndPagination> entityWithServiceImplAndPaginationList = entityWithServiceImplAndPaginationRepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplAndPaginationList).hasSize(databaseSizeBeforeUpdate);
        EntityWithServiceImplAndPagination testEntityWithServiceImplAndPagination = entityWithServiceImplAndPaginationList.get(
            entityWithServiceImplAndPaginationList.size() - 1
        );
        assertThat(testEntityWithServiceImplAndPagination.getHugo()).isEqualTo(UPDATED_HUGO);
    }

    @Test
    void putNonExistingEntityWithServiceImplAndPagination() throws Exception {
        int databaseSizeBeforeUpdate = entityWithServiceImplAndPaginationRepository.findAll().collectList().block().size();
        entityWithServiceImplAndPagination.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, entityWithServiceImplAndPagination.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceImplAndPagination))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the EntityWithServiceImplAndPagination in the database
        List<EntityWithServiceImplAndPagination> entityWithServiceImplAndPaginationList = entityWithServiceImplAndPaginationRepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplAndPaginationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchEntityWithServiceImplAndPagination() throws Exception {
        int databaseSizeBeforeUpdate = entityWithServiceImplAndPaginationRepository.findAll().collectList().block().size();
        entityWithServiceImplAndPagination.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceImplAndPagination))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the EntityWithServiceImplAndPagination in the database
        List<EntityWithServiceImplAndPagination> entityWithServiceImplAndPaginationList = entityWithServiceImplAndPaginationRepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplAndPaginationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamEntityWithServiceImplAndPagination() throws Exception {
        int databaseSizeBeforeUpdate = entityWithServiceImplAndPaginationRepository.findAll().collectList().block().size();
        entityWithServiceImplAndPagination.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceImplAndPagination))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the EntityWithServiceImplAndPagination in the database
        List<EntityWithServiceImplAndPagination> entityWithServiceImplAndPaginationList = entityWithServiceImplAndPaginationRepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplAndPaginationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateEntityWithServiceImplAndPaginationWithPatch() throws Exception {
        // Initialize the database
        entityWithServiceImplAndPaginationRepository.save(entityWithServiceImplAndPagination).block();

        int databaseSizeBeforeUpdate = entityWithServiceImplAndPaginationRepository.findAll().collectList().block().size();

        // Update the entityWithServiceImplAndPagination using partial update
        EntityWithServiceImplAndPagination partialUpdatedEntityWithServiceImplAndPagination = new EntityWithServiceImplAndPagination();
        partialUpdatedEntityWithServiceImplAndPagination.setId(entityWithServiceImplAndPagination.getId());

        partialUpdatedEntityWithServiceImplAndPagination.hugo(UPDATED_HUGO);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedEntityWithServiceImplAndPagination.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedEntityWithServiceImplAndPagination))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the EntityWithServiceImplAndPagination in the database
        List<EntityWithServiceImplAndPagination> entityWithServiceImplAndPaginationList = entityWithServiceImplAndPaginationRepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplAndPaginationList).hasSize(databaseSizeBeforeUpdate);
        EntityWithServiceImplAndPagination testEntityWithServiceImplAndPagination = entityWithServiceImplAndPaginationList.get(
            entityWithServiceImplAndPaginationList.size() - 1
        );
        assertThat(testEntityWithServiceImplAndPagination.getHugo()).isEqualTo(UPDATED_HUGO);
    }

    @Test
    void fullUpdateEntityWithServiceImplAndPaginationWithPatch() throws Exception {
        // Initialize the database
        entityWithServiceImplAndPaginationRepository.save(entityWithServiceImplAndPagination).block();

        int databaseSizeBeforeUpdate = entityWithServiceImplAndPaginationRepository.findAll().collectList().block().size();

        // Update the entityWithServiceImplAndPagination using partial update
        EntityWithServiceImplAndPagination partialUpdatedEntityWithServiceImplAndPagination = new EntityWithServiceImplAndPagination();
        partialUpdatedEntityWithServiceImplAndPagination.setId(entityWithServiceImplAndPagination.getId());

        partialUpdatedEntityWithServiceImplAndPagination.hugo(UPDATED_HUGO);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedEntityWithServiceImplAndPagination.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedEntityWithServiceImplAndPagination))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the EntityWithServiceImplAndPagination in the database
        List<EntityWithServiceImplAndPagination> entityWithServiceImplAndPaginationList = entityWithServiceImplAndPaginationRepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplAndPaginationList).hasSize(databaseSizeBeforeUpdate);
        EntityWithServiceImplAndPagination testEntityWithServiceImplAndPagination = entityWithServiceImplAndPaginationList.get(
            entityWithServiceImplAndPaginationList.size() - 1
        );
        assertThat(testEntityWithServiceImplAndPagination.getHugo()).isEqualTo(UPDATED_HUGO);
    }

    @Test
    void patchNonExistingEntityWithServiceImplAndPagination() throws Exception {
        int databaseSizeBeforeUpdate = entityWithServiceImplAndPaginationRepository.findAll().collectList().block().size();
        entityWithServiceImplAndPagination.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, entityWithServiceImplAndPagination.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceImplAndPagination))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the EntityWithServiceImplAndPagination in the database
        List<EntityWithServiceImplAndPagination> entityWithServiceImplAndPaginationList = entityWithServiceImplAndPaginationRepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplAndPaginationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchEntityWithServiceImplAndPagination() throws Exception {
        int databaseSizeBeforeUpdate = entityWithServiceImplAndPaginationRepository.findAll().collectList().block().size();
        entityWithServiceImplAndPagination.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceImplAndPagination))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the EntityWithServiceImplAndPagination in the database
        List<EntityWithServiceImplAndPagination> entityWithServiceImplAndPaginationList = entityWithServiceImplAndPaginationRepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplAndPaginationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamEntityWithServiceImplAndPagination() throws Exception {
        int databaseSizeBeforeUpdate = entityWithServiceImplAndPaginationRepository.findAll().collectList().block().size();
        entityWithServiceImplAndPagination.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceImplAndPagination))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the EntityWithServiceImplAndPagination in the database
        List<EntityWithServiceImplAndPagination> entityWithServiceImplAndPaginationList = entityWithServiceImplAndPaginationRepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplAndPaginationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteEntityWithServiceImplAndPagination() {
        // Initialize the database
        entityWithServiceImplAndPaginationRepository.save(entityWithServiceImplAndPagination).block();

        int databaseSizeBeforeDelete = entityWithServiceImplAndPaginationRepository.findAll().collectList().block().size();

        // Delete the entityWithServiceImplAndPagination
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, entityWithServiceImplAndPagination.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<EntityWithServiceImplAndPagination> entityWithServiceImplAndPaginationList = entityWithServiceImplAndPaginationRepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplAndPaginationList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
