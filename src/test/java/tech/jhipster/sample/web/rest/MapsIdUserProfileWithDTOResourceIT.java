package tech.jhipster.sample.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
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
import tech.jhipster.sample.domain.MapsIdUserProfileWithDTO;
import tech.jhipster.sample.domain.User;
import tech.jhipster.sample.repository.MapsIdUserProfileWithDTORepository;
import tech.jhipster.sample.service.EntityManager;
import tech.jhipster.sample.service.dto.MapsIdUserProfileWithDTODTO;
import tech.jhipster.sample.service.mapper.MapsIdUserProfileWithDTOMapper;

/**
 * Integration tests for the {@link MapsIdUserProfileWithDTOResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient
@WithMockUser
class MapsIdUserProfileWithDTOResourceIT {

    private static final Instant DEFAULT_DATE_OF_BIRTH = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DATE_OF_BIRTH = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String ENTITY_API_URL = "/api/maps-id-user-profile-with-dtos";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private MapsIdUserProfileWithDTORepository mapsIdUserProfileWithDTORepository;

    @Autowired
    private MapsIdUserProfileWithDTOMapper mapsIdUserProfileWithDTOMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private MapsIdUserProfileWithDTO mapsIdUserProfileWithDTO;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MapsIdUserProfileWithDTO createEntity(EntityManager em) {
        MapsIdUserProfileWithDTO mapsIdUserProfileWithDTO = new MapsIdUserProfileWithDTO().dateOfBirth(DEFAULT_DATE_OF_BIRTH);
        // Add required entity
        User user = em.insert(UserResourceIT.createEntity(em)).block();
        mapsIdUserProfileWithDTO.setUser(user);
        return mapsIdUserProfileWithDTO;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MapsIdUserProfileWithDTO createUpdatedEntity(EntityManager em) {
        MapsIdUserProfileWithDTO mapsIdUserProfileWithDTO = new MapsIdUserProfileWithDTO().dateOfBirth(UPDATED_DATE_OF_BIRTH);
        // Add required entity
        User user = em.insert(UserResourceIT.createEntity(em)).block();
        mapsIdUserProfileWithDTO.setUser(user);
        return mapsIdUserProfileWithDTO;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(MapsIdUserProfileWithDTO.class).block();
        } catch (Exception e) {
            // It can fail, if other entities are still referring this - it will be removed later.
        }
        UserResourceIT.deleteEntities(em);
    }

    @AfterEach
    public void cleanup() {
        deleteEntities(em);
    }

    @BeforeEach
    public void initTest() {
        deleteEntities(em);
        mapsIdUserProfileWithDTO = createEntity(em);
    }

    @Test
    void createMapsIdUserProfileWithDTO() throws Exception {
        int databaseSizeBeforeCreate = mapsIdUserProfileWithDTORepository.findAll().collectList().block().size();
        // Create the MapsIdUserProfileWithDTO
        MapsIdUserProfileWithDTODTO mapsIdUserProfileWithDTODTO = mapsIdUserProfileWithDTOMapper.toDto(mapsIdUserProfileWithDTO);
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(mapsIdUserProfileWithDTODTO))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the MapsIdUserProfileWithDTO in the database
        List<MapsIdUserProfileWithDTO> mapsIdUserProfileWithDTOList = mapsIdUserProfileWithDTORepository.findAll().collectList().block();
        assertThat(mapsIdUserProfileWithDTOList).hasSize(databaseSizeBeforeCreate + 1);
        MapsIdUserProfileWithDTO testMapsIdUserProfileWithDTO = mapsIdUserProfileWithDTOList.get(mapsIdUserProfileWithDTOList.size() - 1);
        assertThat(testMapsIdUserProfileWithDTO.getDateOfBirth()).isEqualTo(DEFAULT_DATE_OF_BIRTH);

        // Validate the id for MapsId, the ids must be same
        assertThat(testMapsIdUserProfileWithDTO.getId()).isEqualTo(testMapsIdUserProfileWithDTO.getUser().getId());
    }

    @Test
    void createMapsIdUserProfileWithDTOWithExistingId() throws Exception {
        // Create the MapsIdUserProfileWithDTO with an existing ID
        mapsIdUserProfileWithDTO.setId(1L);
        MapsIdUserProfileWithDTODTO mapsIdUserProfileWithDTODTO = mapsIdUserProfileWithDTOMapper.toDto(mapsIdUserProfileWithDTO);

        int databaseSizeBeforeCreate = mapsIdUserProfileWithDTORepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(mapsIdUserProfileWithDTODTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the MapsIdUserProfileWithDTO in the database
        List<MapsIdUserProfileWithDTO> mapsIdUserProfileWithDTOList = mapsIdUserProfileWithDTORepository.findAll().collectList().block();
        assertThat(mapsIdUserProfileWithDTOList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void updateMapsIdUserProfileWithDTOMapsIdAssociationWithNewId() throws Exception {
        // Initialize the database
        mapsIdUserProfileWithDTORepository.save(mapsIdUserProfileWithDTO).block();
        int databaseSizeBeforeCreate = mapsIdUserProfileWithDTORepository.findAll().collectList().block().size();

        // Add a new parent entity
        User user = UserResourceIT.createEntity(em);

        // Load the mapsIdUserProfileWithDTO
        MapsIdUserProfileWithDTO updatedMapsIdUserProfileWithDTO = mapsIdUserProfileWithDTORepository
            .findById(mapsIdUserProfileWithDTO.getId())
            .block();
        assertThat(updatedMapsIdUserProfileWithDTO).isNotNull();

        // Update the User with new association value
        updatedMapsIdUserProfileWithDTO.setUser(user);
        MapsIdUserProfileWithDTODTO updatedMapsIdUserProfileWithDTODTO = mapsIdUserProfileWithDTOMapper.toDto(
            updatedMapsIdUserProfileWithDTO
        );
        assertThat(updatedMapsIdUserProfileWithDTODTO).isNotNull();

        // Update the entity
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, updatedMapsIdUserProfileWithDTODTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(updatedMapsIdUserProfileWithDTODTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the MapsIdUserProfileWithDTO in the database
        List<MapsIdUserProfileWithDTO> mapsIdUserProfileWithDTOList = mapsIdUserProfileWithDTORepository.findAll().collectList().block();
        assertThat(mapsIdUserProfileWithDTOList).hasSize(databaseSizeBeforeCreate);
        MapsIdUserProfileWithDTO testMapsIdUserProfileWithDTO = mapsIdUserProfileWithDTOList.get(mapsIdUserProfileWithDTOList.size() - 1);
        // Validate the id for MapsId, the ids must be same
        // Uncomment the following line for assertion. However, please note that there is a known issue and uncommenting will fail the test.
        // Please look at https://github.com/jhipster/generator-jhipster/issues/9100. You can modify this test as necessary.
        // assertThat(testMapsIdUserProfileWithDTO.getId()).isEqualTo(testMapsIdUserProfileWithDTO.getUser().getId());
    }

    @Test
    void getAllMapsIdUserProfileWithDTOSAsStream() {
        // Initialize the database
        mapsIdUserProfileWithDTORepository.save(mapsIdUserProfileWithDTO).block();

        List<MapsIdUserProfileWithDTO> mapsIdUserProfileWithDTOList = webTestClient
            .get()
            .uri(ENTITY_API_URL)
            .accept(MediaType.APPLICATION_NDJSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentTypeCompatibleWith(MediaType.APPLICATION_NDJSON)
            .returnResult(MapsIdUserProfileWithDTODTO.class)
            .getResponseBody()
            .map(mapsIdUserProfileWithDTOMapper::toEntity)
            .filter(mapsIdUserProfileWithDTO::equals)
            .collectList()
            .block(Duration.ofSeconds(5));

        assertThat(mapsIdUserProfileWithDTOList).isNotNull();
        assertThat(mapsIdUserProfileWithDTOList).hasSize(1);
        MapsIdUserProfileWithDTO testMapsIdUserProfileWithDTO = mapsIdUserProfileWithDTOList.get(0);
        assertThat(testMapsIdUserProfileWithDTO.getDateOfBirth()).isEqualTo(DEFAULT_DATE_OF_BIRTH);
    }

    @Test
    void getAllMapsIdUserProfileWithDTOS() {
        // Initialize the database
        mapsIdUserProfileWithDTORepository.save(mapsIdUserProfileWithDTO).block();

        // Get all the mapsIdUserProfileWithDTOList
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
            .value(hasItem(mapsIdUserProfileWithDTO.getId().intValue()))
            .jsonPath("$.[*].dateOfBirth")
            .value(hasItem(DEFAULT_DATE_OF_BIRTH.toString()));
    }

    @Test
    void getMapsIdUserProfileWithDTO() {
        // Initialize the database
        mapsIdUserProfileWithDTORepository.save(mapsIdUserProfileWithDTO).block();

        // Get the mapsIdUserProfileWithDTO
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, mapsIdUserProfileWithDTO.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id")
            .value(is(mapsIdUserProfileWithDTO.getId().intValue()))
            .jsonPath("$.dateOfBirth")
            .value(is(DEFAULT_DATE_OF_BIRTH.toString()));
    }

    @Test
    void getNonExistingMapsIdUserProfileWithDTO() {
        // Get the mapsIdUserProfileWithDTO
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putNewMapsIdUserProfileWithDTO() throws Exception {
        // Initialize the database
        mapsIdUserProfileWithDTORepository.save(mapsIdUserProfileWithDTO).block();

        int databaseSizeBeforeUpdate = mapsIdUserProfileWithDTORepository.findAll().collectList().block().size();

        // Update the mapsIdUserProfileWithDTO
        MapsIdUserProfileWithDTO updatedMapsIdUserProfileWithDTO = mapsIdUserProfileWithDTORepository
            .findById(mapsIdUserProfileWithDTO.getId())
            .block();
        updatedMapsIdUserProfileWithDTO.dateOfBirth(UPDATED_DATE_OF_BIRTH);
        MapsIdUserProfileWithDTODTO mapsIdUserProfileWithDTODTO = mapsIdUserProfileWithDTOMapper.toDto(updatedMapsIdUserProfileWithDTO);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, mapsIdUserProfileWithDTODTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(mapsIdUserProfileWithDTODTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the MapsIdUserProfileWithDTO in the database
        List<MapsIdUserProfileWithDTO> mapsIdUserProfileWithDTOList = mapsIdUserProfileWithDTORepository.findAll().collectList().block();
        assertThat(mapsIdUserProfileWithDTOList).hasSize(databaseSizeBeforeUpdate);
        MapsIdUserProfileWithDTO testMapsIdUserProfileWithDTO = mapsIdUserProfileWithDTOList.get(mapsIdUserProfileWithDTOList.size() - 1);
        assertThat(testMapsIdUserProfileWithDTO.getDateOfBirth()).isEqualTo(UPDATED_DATE_OF_BIRTH);
    }

    @Test
    void putNonExistingMapsIdUserProfileWithDTO() throws Exception {
        int databaseSizeBeforeUpdate = mapsIdUserProfileWithDTORepository.findAll().collectList().block().size();
        mapsIdUserProfileWithDTO.setId(count.incrementAndGet());

        // Create the MapsIdUserProfileWithDTO
        MapsIdUserProfileWithDTODTO mapsIdUserProfileWithDTODTO = mapsIdUserProfileWithDTOMapper.toDto(mapsIdUserProfileWithDTO);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, mapsIdUserProfileWithDTODTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(mapsIdUserProfileWithDTODTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the MapsIdUserProfileWithDTO in the database
        List<MapsIdUserProfileWithDTO> mapsIdUserProfileWithDTOList = mapsIdUserProfileWithDTORepository.findAll().collectList().block();
        assertThat(mapsIdUserProfileWithDTOList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchMapsIdUserProfileWithDTO() throws Exception {
        int databaseSizeBeforeUpdate = mapsIdUserProfileWithDTORepository.findAll().collectList().block().size();
        mapsIdUserProfileWithDTO.setId(count.incrementAndGet());

        // Create the MapsIdUserProfileWithDTO
        MapsIdUserProfileWithDTODTO mapsIdUserProfileWithDTODTO = mapsIdUserProfileWithDTOMapper.toDto(mapsIdUserProfileWithDTO);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(mapsIdUserProfileWithDTODTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the MapsIdUserProfileWithDTO in the database
        List<MapsIdUserProfileWithDTO> mapsIdUserProfileWithDTOList = mapsIdUserProfileWithDTORepository.findAll().collectList().block();
        assertThat(mapsIdUserProfileWithDTOList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamMapsIdUserProfileWithDTO() throws Exception {
        int databaseSizeBeforeUpdate = mapsIdUserProfileWithDTORepository.findAll().collectList().block().size();
        mapsIdUserProfileWithDTO.setId(count.incrementAndGet());

        // Create the MapsIdUserProfileWithDTO
        MapsIdUserProfileWithDTODTO mapsIdUserProfileWithDTODTO = mapsIdUserProfileWithDTOMapper.toDto(mapsIdUserProfileWithDTO);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(mapsIdUserProfileWithDTODTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the MapsIdUserProfileWithDTO in the database
        List<MapsIdUserProfileWithDTO> mapsIdUserProfileWithDTOList = mapsIdUserProfileWithDTORepository.findAll().collectList().block();
        assertThat(mapsIdUserProfileWithDTOList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateMapsIdUserProfileWithDTOWithPatch() throws Exception {
        // Initialize the database
        mapsIdUserProfileWithDTORepository.save(mapsIdUserProfileWithDTO).block();

        int databaseSizeBeforeUpdate = mapsIdUserProfileWithDTORepository.findAll().collectList().block().size();

        // Update the mapsIdUserProfileWithDTO using partial update
        MapsIdUserProfileWithDTO partialUpdatedMapsIdUserProfileWithDTO = new MapsIdUserProfileWithDTO();
        partialUpdatedMapsIdUserProfileWithDTO.setId(mapsIdUserProfileWithDTO.getId());

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedMapsIdUserProfileWithDTO.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedMapsIdUserProfileWithDTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the MapsIdUserProfileWithDTO in the database
        List<MapsIdUserProfileWithDTO> mapsIdUserProfileWithDTOList = mapsIdUserProfileWithDTORepository.findAll().collectList().block();
        assertThat(mapsIdUserProfileWithDTOList).hasSize(databaseSizeBeforeUpdate);
        MapsIdUserProfileWithDTO testMapsIdUserProfileWithDTO = mapsIdUserProfileWithDTOList.get(mapsIdUserProfileWithDTOList.size() - 1);
        assertThat(testMapsIdUserProfileWithDTO.getDateOfBirth()).isEqualTo(DEFAULT_DATE_OF_BIRTH);
    }

    @Test
    void fullUpdateMapsIdUserProfileWithDTOWithPatch() throws Exception {
        // Initialize the database
        mapsIdUserProfileWithDTORepository.save(mapsIdUserProfileWithDTO).block();

        int databaseSizeBeforeUpdate = mapsIdUserProfileWithDTORepository.findAll().collectList().block().size();

        // Update the mapsIdUserProfileWithDTO using partial update
        MapsIdUserProfileWithDTO partialUpdatedMapsIdUserProfileWithDTO = new MapsIdUserProfileWithDTO();
        partialUpdatedMapsIdUserProfileWithDTO.setId(mapsIdUserProfileWithDTO.getId());

        partialUpdatedMapsIdUserProfileWithDTO.dateOfBirth(UPDATED_DATE_OF_BIRTH);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedMapsIdUserProfileWithDTO.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedMapsIdUserProfileWithDTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the MapsIdUserProfileWithDTO in the database
        List<MapsIdUserProfileWithDTO> mapsIdUserProfileWithDTOList = mapsIdUserProfileWithDTORepository.findAll().collectList().block();
        assertThat(mapsIdUserProfileWithDTOList).hasSize(databaseSizeBeforeUpdate);
        MapsIdUserProfileWithDTO testMapsIdUserProfileWithDTO = mapsIdUserProfileWithDTOList.get(mapsIdUserProfileWithDTOList.size() - 1);
        assertThat(testMapsIdUserProfileWithDTO.getDateOfBirth()).isEqualTo(UPDATED_DATE_OF_BIRTH);
    }

    @Test
    void patchNonExistingMapsIdUserProfileWithDTO() throws Exception {
        int databaseSizeBeforeUpdate = mapsIdUserProfileWithDTORepository.findAll().collectList().block().size();
        mapsIdUserProfileWithDTO.setId(count.incrementAndGet());

        // Create the MapsIdUserProfileWithDTO
        MapsIdUserProfileWithDTODTO mapsIdUserProfileWithDTODTO = mapsIdUserProfileWithDTOMapper.toDto(mapsIdUserProfileWithDTO);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, mapsIdUserProfileWithDTODTO.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(mapsIdUserProfileWithDTODTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the MapsIdUserProfileWithDTO in the database
        List<MapsIdUserProfileWithDTO> mapsIdUserProfileWithDTOList = mapsIdUserProfileWithDTORepository.findAll().collectList().block();
        assertThat(mapsIdUserProfileWithDTOList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchMapsIdUserProfileWithDTO() throws Exception {
        int databaseSizeBeforeUpdate = mapsIdUserProfileWithDTORepository.findAll().collectList().block().size();
        mapsIdUserProfileWithDTO.setId(count.incrementAndGet());

        // Create the MapsIdUserProfileWithDTO
        MapsIdUserProfileWithDTODTO mapsIdUserProfileWithDTODTO = mapsIdUserProfileWithDTOMapper.toDto(mapsIdUserProfileWithDTO);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(mapsIdUserProfileWithDTODTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the MapsIdUserProfileWithDTO in the database
        List<MapsIdUserProfileWithDTO> mapsIdUserProfileWithDTOList = mapsIdUserProfileWithDTORepository.findAll().collectList().block();
        assertThat(mapsIdUserProfileWithDTOList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamMapsIdUserProfileWithDTO() throws Exception {
        int databaseSizeBeforeUpdate = mapsIdUserProfileWithDTORepository.findAll().collectList().block().size();
        mapsIdUserProfileWithDTO.setId(count.incrementAndGet());

        // Create the MapsIdUserProfileWithDTO
        MapsIdUserProfileWithDTODTO mapsIdUserProfileWithDTODTO = mapsIdUserProfileWithDTOMapper.toDto(mapsIdUserProfileWithDTO);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(mapsIdUserProfileWithDTODTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the MapsIdUserProfileWithDTO in the database
        List<MapsIdUserProfileWithDTO> mapsIdUserProfileWithDTOList = mapsIdUserProfileWithDTORepository.findAll().collectList().block();
        assertThat(mapsIdUserProfileWithDTOList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteMapsIdUserProfileWithDTO() {
        // Initialize the database
        mapsIdUserProfileWithDTORepository.save(mapsIdUserProfileWithDTO).block();

        int databaseSizeBeforeDelete = mapsIdUserProfileWithDTORepository.findAll().collectList().block().size();

        // Delete the mapsIdUserProfileWithDTO
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, mapsIdUserProfileWithDTO.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<MapsIdUserProfileWithDTO> mapsIdUserProfileWithDTOList = mapsIdUserProfileWithDTORepository.findAll().collectList().block();
        assertThat(mapsIdUserProfileWithDTOList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
