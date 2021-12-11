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
import tech.jhipster.sample.domain.EntityWithServiceClassPaginationAndDTO;
import tech.jhipster.sample.repository.EntityWithServiceClassPaginationAndDTORepository;
import tech.jhipster.sample.service.EntityManager;
import tech.jhipster.sample.service.dto.EntityWithServiceClassPaginationAndDTODTO;
import tech.jhipster.sample.service.mapper.EntityWithServiceClassPaginationAndDTOMapper;

/**
 * Integration tests for the {@link EntityWithServiceClassPaginationAndDTOResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient
@WithMockUser
class EntityWithServiceClassPaginationAndDTOResourceIT {

    private static final String DEFAULT_LENA = "AAAAAAAAAA";
    private static final String UPDATED_LENA = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/entity-with-service-class-pagination-and-dtos";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private EntityWithServiceClassPaginationAndDTORepository entityWithServiceClassPaginationAndDTORepository;

    @Autowired
    private EntityWithServiceClassPaginationAndDTOMapper entityWithServiceClassPaginationAndDTOMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private EntityWithServiceClassPaginationAndDTO entityWithServiceClassPaginationAndDTO;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static EntityWithServiceClassPaginationAndDTO createEntity(EntityManager em) {
        EntityWithServiceClassPaginationAndDTO entityWithServiceClassPaginationAndDTO = new EntityWithServiceClassPaginationAndDTO()
            .lena(DEFAULT_LENA);
        return entityWithServiceClassPaginationAndDTO;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static EntityWithServiceClassPaginationAndDTO createUpdatedEntity(EntityManager em) {
        EntityWithServiceClassPaginationAndDTO entityWithServiceClassPaginationAndDTO = new EntityWithServiceClassPaginationAndDTO()
            .lena(UPDATED_LENA);
        return entityWithServiceClassPaginationAndDTO;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(EntityWithServiceClassPaginationAndDTO.class).block();
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
        entityWithServiceClassPaginationAndDTO = createEntity(em);
    }

    @Test
    void createEntityWithServiceClassPaginationAndDTO() throws Exception {
        int databaseSizeBeforeCreate = entityWithServiceClassPaginationAndDTORepository.findAll().collectList().block().size();
        // Create the EntityWithServiceClassPaginationAndDTO
        EntityWithServiceClassPaginationAndDTODTO entityWithServiceClassPaginationAndDTODTO = entityWithServiceClassPaginationAndDTOMapper.toDto(
            entityWithServiceClassPaginationAndDTO
        );
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceClassPaginationAndDTODTO))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the EntityWithServiceClassPaginationAndDTO in the database
        List<EntityWithServiceClassPaginationAndDTO> entityWithServiceClassPaginationAndDTOList = entityWithServiceClassPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceClassPaginationAndDTOList).hasSize(databaseSizeBeforeCreate + 1);
        EntityWithServiceClassPaginationAndDTO testEntityWithServiceClassPaginationAndDTO = entityWithServiceClassPaginationAndDTOList.get(
            entityWithServiceClassPaginationAndDTOList.size() - 1
        );
        assertThat(testEntityWithServiceClassPaginationAndDTO.getLena()).isEqualTo(DEFAULT_LENA);
    }

    @Test
    void createEntityWithServiceClassPaginationAndDTOWithExistingId() throws Exception {
        // Create the EntityWithServiceClassPaginationAndDTO with an existing ID
        entityWithServiceClassPaginationAndDTO.setId(1L);
        EntityWithServiceClassPaginationAndDTODTO entityWithServiceClassPaginationAndDTODTO = entityWithServiceClassPaginationAndDTOMapper.toDto(
            entityWithServiceClassPaginationAndDTO
        );

        int databaseSizeBeforeCreate = entityWithServiceClassPaginationAndDTORepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceClassPaginationAndDTODTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the EntityWithServiceClassPaginationAndDTO in the database
        List<EntityWithServiceClassPaginationAndDTO> entityWithServiceClassPaginationAndDTOList = entityWithServiceClassPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceClassPaginationAndDTOList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void getAllEntityWithServiceClassPaginationAndDTOS() {
        // Initialize the database
        entityWithServiceClassPaginationAndDTORepository.save(entityWithServiceClassPaginationAndDTO).block();

        // Get all the entityWithServiceClassPaginationAndDTOList
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
            .value(hasItem(entityWithServiceClassPaginationAndDTO.getId().intValue()))
            .jsonPath("$.[*].lena")
            .value(hasItem(DEFAULT_LENA));
    }

    @Test
    void getEntityWithServiceClassPaginationAndDTO() {
        // Initialize the database
        entityWithServiceClassPaginationAndDTORepository.save(entityWithServiceClassPaginationAndDTO).block();

        // Get the entityWithServiceClassPaginationAndDTO
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, entityWithServiceClassPaginationAndDTO.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id")
            .value(is(entityWithServiceClassPaginationAndDTO.getId().intValue()))
            .jsonPath("$.lena")
            .value(is(DEFAULT_LENA));
    }

    @Test
    void getNonExistingEntityWithServiceClassPaginationAndDTO() {
        // Get the entityWithServiceClassPaginationAndDTO
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putNewEntityWithServiceClassPaginationAndDTO() throws Exception {
        // Initialize the database
        entityWithServiceClassPaginationAndDTORepository.save(entityWithServiceClassPaginationAndDTO).block();

        int databaseSizeBeforeUpdate = entityWithServiceClassPaginationAndDTORepository.findAll().collectList().block().size();

        // Update the entityWithServiceClassPaginationAndDTO
        EntityWithServiceClassPaginationAndDTO updatedEntityWithServiceClassPaginationAndDTO = entityWithServiceClassPaginationAndDTORepository
            .findById(entityWithServiceClassPaginationAndDTO.getId())
            .block();
        updatedEntityWithServiceClassPaginationAndDTO.lena(UPDATED_LENA);
        EntityWithServiceClassPaginationAndDTODTO entityWithServiceClassPaginationAndDTODTO = entityWithServiceClassPaginationAndDTOMapper.toDto(
            updatedEntityWithServiceClassPaginationAndDTO
        );

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, entityWithServiceClassPaginationAndDTODTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceClassPaginationAndDTODTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the EntityWithServiceClassPaginationAndDTO in the database
        List<EntityWithServiceClassPaginationAndDTO> entityWithServiceClassPaginationAndDTOList = entityWithServiceClassPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceClassPaginationAndDTOList).hasSize(databaseSizeBeforeUpdate);
        EntityWithServiceClassPaginationAndDTO testEntityWithServiceClassPaginationAndDTO = entityWithServiceClassPaginationAndDTOList.get(
            entityWithServiceClassPaginationAndDTOList.size() - 1
        );
        assertThat(testEntityWithServiceClassPaginationAndDTO.getLena()).isEqualTo(UPDATED_LENA);
    }

    @Test
    void putNonExistingEntityWithServiceClassPaginationAndDTO() throws Exception {
        int databaseSizeBeforeUpdate = entityWithServiceClassPaginationAndDTORepository.findAll().collectList().block().size();
        entityWithServiceClassPaginationAndDTO.setId(count.incrementAndGet());

        // Create the EntityWithServiceClassPaginationAndDTO
        EntityWithServiceClassPaginationAndDTODTO entityWithServiceClassPaginationAndDTODTO = entityWithServiceClassPaginationAndDTOMapper.toDto(
            entityWithServiceClassPaginationAndDTO
        );

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, entityWithServiceClassPaginationAndDTODTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceClassPaginationAndDTODTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the EntityWithServiceClassPaginationAndDTO in the database
        List<EntityWithServiceClassPaginationAndDTO> entityWithServiceClassPaginationAndDTOList = entityWithServiceClassPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceClassPaginationAndDTOList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchEntityWithServiceClassPaginationAndDTO() throws Exception {
        int databaseSizeBeforeUpdate = entityWithServiceClassPaginationAndDTORepository.findAll().collectList().block().size();
        entityWithServiceClassPaginationAndDTO.setId(count.incrementAndGet());

        // Create the EntityWithServiceClassPaginationAndDTO
        EntityWithServiceClassPaginationAndDTODTO entityWithServiceClassPaginationAndDTODTO = entityWithServiceClassPaginationAndDTOMapper.toDto(
            entityWithServiceClassPaginationAndDTO
        );

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceClassPaginationAndDTODTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the EntityWithServiceClassPaginationAndDTO in the database
        List<EntityWithServiceClassPaginationAndDTO> entityWithServiceClassPaginationAndDTOList = entityWithServiceClassPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceClassPaginationAndDTOList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamEntityWithServiceClassPaginationAndDTO() throws Exception {
        int databaseSizeBeforeUpdate = entityWithServiceClassPaginationAndDTORepository.findAll().collectList().block().size();
        entityWithServiceClassPaginationAndDTO.setId(count.incrementAndGet());

        // Create the EntityWithServiceClassPaginationAndDTO
        EntityWithServiceClassPaginationAndDTODTO entityWithServiceClassPaginationAndDTODTO = entityWithServiceClassPaginationAndDTOMapper.toDto(
            entityWithServiceClassPaginationAndDTO
        );

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceClassPaginationAndDTODTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the EntityWithServiceClassPaginationAndDTO in the database
        List<EntityWithServiceClassPaginationAndDTO> entityWithServiceClassPaginationAndDTOList = entityWithServiceClassPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceClassPaginationAndDTOList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateEntityWithServiceClassPaginationAndDTOWithPatch() throws Exception {
        // Initialize the database
        entityWithServiceClassPaginationAndDTORepository.save(entityWithServiceClassPaginationAndDTO).block();

        int databaseSizeBeforeUpdate = entityWithServiceClassPaginationAndDTORepository.findAll().collectList().block().size();

        // Update the entityWithServiceClassPaginationAndDTO using partial update
        EntityWithServiceClassPaginationAndDTO partialUpdatedEntityWithServiceClassPaginationAndDTO = new EntityWithServiceClassPaginationAndDTO();
        partialUpdatedEntityWithServiceClassPaginationAndDTO.setId(entityWithServiceClassPaginationAndDTO.getId());

        partialUpdatedEntityWithServiceClassPaginationAndDTO.lena(UPDATED_LENA);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedEntityWithServiceClassPaginationAndDTO.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedEntityWithServiceClassPaginationAndDTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the EntityWithServiceClassPaginationAndDTO in the database
        List<EntityWithServiceClassPaginationAndDTO> entityWithServiceClassPaginationAndDTOList = entityWithServiceClassPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceClassPaginationAndDTOList).hasSize(databaseSizeBeforeUpdate);
        EntityWithServiceClassPaginationAndDTO testEntityWithServiceClassPaginationAndDTO = entityWithServiceClassPaginationAndDTOList.get(
            entityWithServiceClassPaginationAndDTOList.size() - 1
        );
        assertThat(testEntityWithServiceClassPaginationAndDTO.getLena()).isEqualTo(UPDATED_LENA);
    }

    @Test
    void fullUpdateEntityWithServiceClassPaginationAndDTOWithPatch() throws Exception {
        // Initialize the database
        entityWithServiceClassPaginationAndDTORepository.save(entityWithServiceClassPaginationAndDTO).block();

        int databaseSizeBeforeUpdate = entityWithServiceClassPaginationAndDTORepository.findAll().collectList().block().size();

        // Update the entityWithServiceClassPaginationAndDTO using partial update
        EntityWithServiceClassPaginationAndDTO partialUpdatedEntityWithServiceClassPaginationAndDTO = new EntityWithServiceClassPaginationAndDTO();
        partialUpdatedEntityWithServiceClassPaginationAndDTO.setId(entityWithServiceClassPaginationAndDTO.getId());

        partialUpdatedEntityWithServiceClassPaginationAndDTO.lena(UPDATED_LENA);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedEntityWithServiceClassPaginationAndDTO.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedEntityWithServiceClassPaginationAndDTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the EntityWithServiceClassPaginationAndDTO in the database
        List<EntityWithServiceClassPaginationAndDTO> entityWithServiceClassPaginationAndDTOList = entityWithServiceClassPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceClassPaginationAndDTOList).hasSize(databaseSizeBeforeUpdate);
        EntityWithServiceClassPaginationAndDTO testEntityWithServiceClassPaginationAndDTO = entityWithServiceClassPaginationAndDTOList.get(
            entityWithServiceClassPaginationAndDTOList.size() - 1
        );
        assertThat(testEntityWithServiceClassPaginationAndDTO.getLena()).isEqualTo(UPDATED_LENA);
    }

    @Test
    void patchNonExistingEntityWithServiceClassPaginationAndDTO() throws Exception {
        int databaseSizeBeforeUpdate = entityWithServiceClassPaginationAndDTORepository.findAll().collectList().block().size();
        entityWithServiceClassPaginationAndDTO.setId(count.incrementAndGet());

        // Create the EntityWithServiceClassPaginationAndDTO
        EntityWithServiceClassPaginationAndDTODTO entityWithServiceClassPaginationAndDTODTO = entityWithServiceClassPaginationAndDTOMapper.toDto(
            entityWithServiceClassPaginationAndDTO
        );

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, entityWithServiceClassPaginationAndDTODTO.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceClassPaginationAndDTODTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the EntityWithServiceClassPaginationAndDTO in the database
        List<EntityWithServiceClassPaginationAndDTO> entityWithServiceClassPaginationAndDTOList = entityWithServiceClassPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceClassPaginationAndDTOList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchEntityWithServiceClassPaginationAndDTO() throws Exception {
        int databaseSizeBeforeUpdate = entityWithServiceClassPaginationAndDTORepository.findAll().collectList().block().size();
        entityWithServiceClassPaginationAndDTO.setId(count.incrementAndGet());

        // Create the EntityWithServiceClassPaginationAndDTO
        EntityWithServiceClassPaginationAndDTODTO entityWithServiceClassPaginationAndDTODTO = entityWithServiceClassPaginationAndDTOMapper.toDto(
            entityWithServiceClassPaginationAndDTO
        );

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceClassPaginationAndDTODTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the EntityWithServiceClassPaginationAndDTO in the database
        List<EntityWithServiceClassPaginationAndDTO> entityWithServiceClassPaginationAndDTOList = entityWithServiceClassPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceClassPaginationAndDTOList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamEntityWithServiceClassPaginationAndDTO() throws Exception {
        int databaseSizeBeforeUpdate = entityWithServiceClassPaginationAndDTORepository.findAll().collectList().block().size();
        entityWithServiceClassPaginationAndDTO.setId(count.incrementAndGet());

        // Create the EntityWithServiceClassPaginationAndDTO
        EntityWithServiceClassPaginationAndDTODTO entityWithServiceClassPaginationAndDTODTO = entityWithServiceClassPaginationAndDTOMapper.toDto(
            entityWithServiceClassPaginationAndDTO
        );

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(entityWithServiceClassPaginationAndDTODTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the EntityWithServiceClassPaginationAndDTO in the database
        List<EntityWithServiceClassPaginationAndDTO> entityWithServiceClassPaginationAndDTOList = entityWithServiceClassPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceClassPaginationAndDTOList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteEntityWithServiceClassPaginationAndDTO() {
        // Initialize the database
        entityWithServiceClassPaginationAndDTORepository.save(entityWithServiceClassPaginationAndDTO).block();

        int databaseSizeBeforeDelete = entityWithServiceClassPaginationAndDTORepository.findAll().collectList().block().size();

        // Delete the entityWithServiceClassPaginationAndDTO
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, entityWithServiceClassPaginationAndDTO.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<EntityWithServiceClassPaginationAndDTO> entityWithServiceClassPaginationAndDTOList = entityWithServiceClassPaginationAndDTORepository
            .findAll()
            .collectList()
            .block();
        assertThat(entityWithServiceClassPaginationAndDTOList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
