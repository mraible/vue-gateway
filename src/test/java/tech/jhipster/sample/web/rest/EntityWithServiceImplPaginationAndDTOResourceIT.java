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
import tech.jhipster.sample.domain.EntityWithServiceImplPaginationAndDTO;
import tech.jhipster.sample.repository.EntityWithServiceImplPaginationAndDTORepository;
import tech.jhipster.sample.service.EntityManager;
import tech.jhipster.sample.service.dto.EntityWithServiceImplPaginationAndDTODTO;
import tech.jhipster.sample.service.mapper.EntityWithServiceImplPaginationAndDTOMapper;

/**
 * Integration tests for the {@link EntityWithServiceImplPaginationAndDTOResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient
@WithMockUser
class EntityWithServiceImplPaginationAndDTOResourceIT {

    private static final String DEFAULT_THEO = "AAAAAAAAAA";
    private static final String UPDATED_THEO = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/entity-with-service-impl-pagination-and-dtos";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private EntityWithServiceImplPaginationAndDTORepository entityWithServiceImplPaginationAndDTORepository;

    @Autowired
    private EntityWithServiceImplPaginationAndDTOMapper entityWithServiceImplPaginationAndDTOMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private EntityWithServiceImplPaginationAndDTO entityWithServiceImplPaginationAndDTO;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static EntityWithServiceImplPaginationAndDTO createEntity(EntityManager em) {
        EntityWithServiceImplPaginationAndDTO entityWithServiceImplPaginationAndDTO = new EntityWithServiceImplPaginationAndDTO()
            .theo(DEFAULT_THEO);
        return entityWithServiceImplPaginationAndDTO;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static EntityWithServiceImplPaginationAndDTO createUpdatedEntity(EntityManager em) {
        EntityWithServiceImplPaginationAndDTO entityWithServiceImplPaginationAndDTO = new EntityWithServiceImplPaginationAndDTO()
            .theo(UPDATED_THEO);
        return entityWithServiceImplPaginationAndDTO;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(EntityWithServiceImplPaginationAndDTO.class).block();
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
        entityWithServiceImplPaginationAndDTO = createEntity(em);
    }

    @Test
    void createEntityWithServiceImplPaginationAndDTO() throws Exception {
        int databaseSizeBeforeCreate = entityWithServiceImplPaginationAndDTORepository.findAll().collectList().block().size();
        // Create the EntityWithServiceImplPaginationAndDTO
        EntityWithServiceImplPaginationAndDTODTO entityWithServiceImplPaginationAndDTODTO = entityWithServiceImplPaginationAndDTOMapper.toDto(
            entityWithServiceImplPaginationAndDTO
        );
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceImplPaginationAndDTODTO))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the EntityWithServiceImplPaginationAndDTO in the database
        List<EntityWithServiceImplPaginationAndDTO> entityWithServiceImplPaginationAndDTOList = entityWithServiceImplPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplPaginationAndDTOList).hasSize(databaseSizeBeforeCreate + 1);
        EntityWithServiceImplPaginationAndDTO testEntityWithServiceImplPaginationAndDTO = entityWithServiceImplPaginationAndDTOList.get(
            entityWithServiceImplPaginationAndDTOList.size() - 1
        );
        assertThat(testEntityWithServiceImplPaginationAndDTO.getTheo()).isEqualTo(DEFAULT_THEO);
    }

    @Test
    void createEntityWithServiceImplPaginationAndDTOWithExistingId() throws Exception {
        // Create the EntityWithServiceImplPaginationAndDTO with an existing ID
        entityWithServiceImplPaginationAndDTO.setId(1L);
        EntityWithServiceImplPaginationAndDTODTO entityWithServiceImplPaginationAndDTODTO = entityWithServiceImplPaginationAndDTOMapper.toDto(
            entityWithServiceImplPaginationAndDTO
        );

        int databaseSizeBeforeCreate = entityWithServiceImplPaginationAndDTORepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceImplPaginationAndDTODTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the EntityWithServiceImplPaginationAndDTO in the database
        List<EntityWithServiceImplPaginationAndDTO> entityWithServiceImplPaginationAndDTOList = entityWithServiceImplPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplPaginationAndDTOList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void getAllEntityWithServiceImplPaginationAndDTOS() {
        // Initialize the database
        entityWithServiceImplPaginationAndDTORepository.save(entityWithServiceImplPaginationAndDTO).block();

        // Get all the entityWithServiceImplPaginationAndDTOList
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
            .value(hasItem(entityWithServiceImplPaginationAndDTO.getId().intValue()))
            .jsonPath("$.[*].theo")
            .value(hasItem(DEFAULT_THEO));
    }

    @Test
    void getEntityWithServiceImplPaginationAndDTO() {
        // Initialize the database
        entityWithServiceImplPaginationAndDTORepository.save(entityWithServiceImplPaginationAndDTO).block();

        // Get the entityWithServiceImplPaginationAndDTO
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, entityWithServiceImplPaginationAndDTO.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id")
            .value(is(entityWithServiceImplPaginationAndDTO.getId().intValue()))
            .jsonPath("$.theo")
            .value(is(DEFAULT_THEO));
    }

    @Test
    void getNonExistingEntityWithServiceImplPaginationAndDTO() {
        // Get the entityWithServiceImplPaginationAndDTO
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putNewEntityWithServiceImplPaginationAndDTO() throws Exception {
        // Initialize the database
        entityWithServiceImplPaginationAndDTORepository.save(entityWithServiceImplPaginationAndDTO).block();

        int databaseSizeBeforeUpdate = entityWithServiceImplPaginationAndDTORepository.findAll().collectList().block().size();

        // Update the entityWithServiceImplPaginationAndDTO
        EntityWithServiceImplPaginationAndDTO updatedEntityWithServiceImplPaginationAndDTO = entityWithServiceImplPaginationAndDTORepository
            .findById(entityWithServiceImplPaginationAndDTO.getId())
            .block();
        updatedEntityWithServiceImplPaginationAndDTO.theo(UPDATED_THEO);
        EntityWithServiceImplPaginationAndDTODTO entityWithServiceImplPaginationAndDTODTO = entityWithServiceImplPaginationAndDTOMapper.toDto(
            updatedEntityWithServiceImplPaginationAndDTO
        );

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, entityWithServiceImplPaginationAndDTODTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceImplPaginationAndDTODTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the EntityWithServiceImplPaginationAndDTO in the database
        List<EntityWithServiceImplPaginationAndDTO> entityWithServiceImplPaginationAndDTOList = entityWithServiceImplPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplPaginationAndDTOList).hasSize(databaseSizeBeforeUpdate);
        EntityWithServiceImplPaginationAndDTO testEntityWithServiceImplPaginationAndDTO = entityWithServiceImplPaginationAndDTOList.get(
            entityWithServiceImplPaginationAndDTOList.size() - 1
        );
        assertThat(testEntityWithServiceImplPaginationAndDTO.getTheo()).isEqualTo(UPDATED_THEO);
    }

    @Test
    void putNonExistingEntityWithServiceImplPaginationAndDTO() throws Exception {
        int databaseSizeBeforeUpdate = entityWithServiceImplPaginationAndDTORepository.findAll().collectList().block().size();
        entityWithServiceImplPaginationAndDTO.setId(count.incrementAndGet());

        // Create the EntityWithServiceImplPaginationAndDTO
        EntityWithServiceImplPaginationAndDTODTO entityWithServiceImplPaginationAndDTODTO = entityWithServiceImplPaginationAndDTOMapper.toDto(
            entityWithServiceImplPaginationAndDTO
        );

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, entityWithServiceImplPaginationAndDTODTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceImplPaginationAndDTODTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the EntityWithServiceImplPaginationAndDTO in the database
        List<EntityWithServiceImplPaginationAndDTO> entityWithServiceImplPaginationAndDTOList = entityWithServiceImplPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplPaginationAndDTOList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchEntityWithServiceImplPaginationAndDTO() throws Exception {
        int databaseSizeBeforeUpdate = entityWithServiceImplPaginationAndDTORepository.findAll().collectList().block().size();
        entityWithServiceImplPaginationAndDTO.setId(count.incrementAndGet());

        // Create the EntityWithServiceImplPaginationAndDTO
        EntityWithServiceImplPaginationAndDTODTO entityWithServiceImplPaginationAndDTODTO = entityWithServiceImplPaginationAndDTOMapper.toDto(
            entityWithServiceImplPaginationAndDTO
        );

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceImplPaginationAndDTODTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the EntityWithServiceImplPaginationAndDTO in the database
        List<EntityWithServiceImplPaginationAndDTO> entityWithServiceImplPaginationAndDTOList = entityWithServiceImplPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplPaginationAndDTOList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamEntityWithServiceImplPaginationAndDTO() throws Exception {
        int databaseSizeBeforeUpdate = entityWithServiceImplPaginationAndDTORepository.findAll().collectList().block().size();
        entityWithServiceImplPaginationAndDTO.setId(count.incrementAndGet());

        // Create the EntityWithServiceImplPaginationAndDTO
        EntityWithServiceImplPaginationAndDTODTO entityWithServiceImplPaginationAndDTODTO = entityWithServiceImplPaginationAndDTOMapper.toDto(
            entityWithServiceImplPaginationAndDTO
        );

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceImplPaginationAndDTODTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the EntityWithServiceImplPaginationAndDTO in the database
        List<EntityWithServiceImplPaginationAndDTO> entityWithServiceImplPaginationAndDTOList = entityWithServiceImplPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplPaginationAndDTOList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateEntityWithServiceImplPaginationAndDTOWithPatch() throws Exception {
        // Initialize the database
        entityWithServiceImplPaginationAndDTORepository.save(entityWithServiceImplPaginationAndDTO).block();

        int databaseSizeBeforeUpdate = entityWithServiceImplPaginationAndDTORepository.findAll().collectList().block().size();

        // Update the entityWithServiceImplPaginationAndDTO using partial update
        EntityWithServiceImplPaginationAndDTO partialUpdatedEntityWithServiceImplPaginationAndDTO = new EntityWithServiceImplPaginationAndDTO();
        partialUpdatedEntityWithServiceImplPaginationAndDTO.setId(entityWithServiceImplPaginationAndDTO.getId());

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedEntityWithServiceImplPaginationAndDTO.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedEntityWithServiceImplPaginationAndDTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the EntityWithServiceImplPaginationAndDTO in the database
        List<EntityWithServiceImplPaginationAndDTO> entityWithServiceImplPaginationAndDTOList = entityWithServiceImplPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplPaginationAndDTOList).hasSize(databaseSizeBeforeUpdate);
        EntityWithServiceImplPaginationAndDTO testEntityWithServiceImplPaginationAndDTO = entityWithServiceImplPaginationAndDTOList.get(
            entityWithServiceImplPaginationAndDTOList.size() - 1
        );
        assertThat(testEntityWithServiceImplPaginationAndDTO.getTheo()).isEqualTo(DEFAULT_THEO);
    }

    @Test
    void fullUpdateEntityWithServiceImplPaginationAndDTOWithPatch() throws Exception {
        // Initialize the database
        entityWithServiceImplPaginationAndDTORepository.save(entityWithServiceImplPaginationAndDTO).block();

        int databaseSizeBeforeUpdate = entityWithServiceImplPaginationAndDTORepository.findAll().collectList().block().size();

        // Update the entityWithServiceImplPaginationAndDTO using partial update
        EntityWithServiceImplPaginationAndDTO partialUpdatedEntityWithServiceImplPaginationAndDTO = new EntityWithServiceImplPaginationAndDTO();
        partialUpdatedEntityWithServiceImplPaginationAndDTO.setId(entityWithServiceImplPaginationAndDTO.getId());

        partialUpdatedEntityWithServiceImplPaginationAndDTO.theo(UPDATED_THEO);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedEntityWithServiceImplPaginationAndDTO.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedEntityWithServiceImplPaginationAndDTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the EntityWithServiceImplPaginationAndDTO in the database
        List<EntityWithServiceImplPaginationAndDTO> entityWithServiceImplPaginationAndDTOList = entityWithServiceImplPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplPaginationAndDTOList).hasSize(databaseSizeBeforeUpdate);
        EntityWithServiceImplPaginationAndDTO testEntityWithServiceImplPaginationAndDTO = entityWithServiceImplPaginationAndDTOList.get(
            entityWithServiceImplPaginationAndDTOList.size() - 1
        );
        assertThat(testEntityWithServiceImplPaginationAndDTO.getTheo()).isEqualTo(UPDATED_THEO);
    }

    @Test
    void patchNonExistingEntityWithServiceImplPaginationAndDTO() throws Exception {
        int databaseSizeBeforeUpdate = entityWithServiceImplPaginationAndDTORepository.findAll().collectList().block().size();
        entityWithServiceImplPaginationAndDTO.setId(count.incrementAndGet());

        // Create the EntityWithServiceImplPaginationAndDTO
        EntityWithServiceImplPaginationAndDTODTO entityWithServiceImplPaginationAndDTODTO = entityWithServiceImplPaginationAndDTOMapper.toDto(
            entityWithServiceImplPaginationAndDTO
        );

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, entityWithServiceImplPaginationAndDTODTO.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceImplPaginationAndDTODTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the EntityWithServiceImplPaginationAndDTO in the database
        List<EntityWithServiceImplPaginationAndDTO> entityWithServiceImplPaginationAndDTOList = entityWithServiceImplPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplPaginationAndDTOList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchEntityWithServiceImplPaginationAndDTO() throws Exception {
        int databaseSizeBeforeUpdate = entityWithServiceImplPaginationAndDTORepository.findAll().collectList().block().size();
        entityWithServiceImplPaginationAndDTO.setId(count.incrementAndGet());

        // Create the EntityWithServiceImplPaginationAndDTO
        EntityWithServiceImplPaginationAndDTODTO entityWithServiceImplPaginationAndDTODTO = entityWithServiceImplPaginationAndDTOMapper.toDto(
            entityWithServiceImplPaginationAndDTO
        );

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceImplPaginationAndDTODTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the EntityWithServiceImplPaginationAndDTO in the database
        List<EntityWithServiceImplPaginationAndDTO> entityWithServiceImplPaginationAndDTOList = entityWithServiceImplPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplPaginationAndDTOList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamEntityWithServiceImplPaginationAndDTO() throws Exception {
        int databaseSizeBeforeUpdate = entityWithServiceImplPaginationAndDTORepository.findAll().collectList().block().size();
        entityWithServiceImplPaginationAndDTO.setId(count.incrementAndGet());

        // Create the EntityWithServiceImplPaginationAndDTO
        EntityWithServiceImplPaginationAndDTODTO entityWithServiceImplPaginationAndDTODTO = entityWithServiceImplPaginationAndDTOMapper.toDto(
            entityWithServiceImplPaginationAndDTO
        );

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceImplPaginationAndDTODTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the EntityWithServiceImplPaginationAndDTO in the database
        List<EntityWithServiceImplPaginationAndDTO> entityWithServiceImplPaginationAndDTOList = entityWithServiceImplPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplPaginationAndDTOList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteEntityWithServiceImplPaginationAndDTO() {
        // Initialize the database
        entityWithServiceImplPaginationAndDTORepository.save(entityWithServiceImplPaginationAndDTO).block();

        int databaseSizeBeforeDelete = entityWithServiceImplPaginationAndDTORepository.findAll().collectList().block().size();

        // Delete the entityWithServiceImplPaginationAndDTO
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, entityWithServiceImplPaginationAndDTO.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<EntityWithServiceImplPaginationAndDTO> entityWithServiceImplPaginationAndDTOList = entityWithServiceImplPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceImplPaginationAndDTOList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
