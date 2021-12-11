package tech.jhipster.sample.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static tech.jhipster.sample.web.rest.TestUtil.sameNumber;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import java.util.UUID;
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
import org.springframework.util.Base64Utils;
import tech.jhipster.sample.IntegrationTest;
import tech.jhipster.sample.domain.BankAccount;
import tech.jhipster.sample.domain.enumeration.BankAccountType;
import tech.jhipster.sample.repository.BankAccountRepository;
import tech.jhipster.sample.service.EntityManager;

/**
 * Integration tests for the {@link BankAccountResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient
@WithMockUser
class BankAccountResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final UUID DEFAULT_GUID = UUID.randomUUID();
    private static final UUID UPDATED_GUID = UUID.randomUUID();

    private static final Integer DEFAULT_BANK_NUMBER = 1;
    private static final Integer UPDATED_BANK_NUMBER = 2;

    private static final Long DEFAULT_AGENCY_NUMBER = 1L;
    private static final Long UPDATED_AGENCY_NUMBER = 2L;

    private static final Float DEFAULT_LAST_OPERATION_DURATION = 1F;
    private static final Float UPDATED_LAST_OPERATION_DURATION = 2F;

    private static final Double DEFAULT_MEAN_OPERATION_DURATION = 1D;
    private static final Double UPDATED_MEAN_OPERATION_DURATION = 2D;

    private static final Duration DEFAULT_MEAN_QUEUE_DURATION = Duration.ofHours(6);
    private static final Duration UPDATED_MEAN_QUEUE_DURATION = Duration.ofHours(12);

    private static final BigDecimal DEFAULT_BALANCE = new BigDecimal(1);
    private static final BigDecimal UPDATED_BALANCE = new BigDecimal(2);

    private static final LocalDate DEFAULT_OPENING_DAY = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_OPENING_DAY = LocalDate.now(ZoneId.systemDefault());

    private static final Instant DEFAULT_LAST_OPERATION_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_LAST_OPERATION_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_ACTIVE = false;
    private static final Boolean UPDATED_ACTIVE = true;

    private static final BankAccountType DEFAULT_ACCOUNT_TYPE = BankAccountType.CHECKING;
    private static final BankAccountType UPDATED_ACCOUNT_TYPE = BankAccountType.SAVINGS;

    private static final byte[] DEFAULT_ATTACHMENT = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_ATTACHMENT = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_ATTACHMENT_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_ATTACHMENT_CONTENT_TYPE = "image/png";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/bank-accounts";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private BankAccount bankAccount;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BankAccount createEntity(EntityManager em) {
        BankAccount bankAccount = new BankAccount()
            .name(DEFAULT_NAME)
            .guid(DEFAULT_GUID)
            .bankNumber(DEFAULT_BANK_NUMBER)
            .agencyNumber(DEFAULT_AGENCY_NUMBER)
            .lastOperationDuration(DEFAULT_LAST_OPERATION_DURATION)
            .meanOperationDuration(DEFAULT_MEAN_OPERATION_DURATION)
            .meanQueueDuration(DEFAULT_MEAN_QUEUE_DURATION)
            .balance(DEFAULT_BALANCE)
            .openingDay(DEFAULT_OPENING_DAY)
            .lastOperationDate(DEFAULT_LAST_OPERATION_DATE)
            .active(DEFAULT_ACTIVE)
            .accountType(DEFAULT_ACCOUNT_TYPE)
            .attachment(DEFAULT_ATTACHMENT)
            .attachmentContentType(DEFAULT_ATTACHMENT_CONTENT_TYPE)
            .description(DEFAULT_DESCRIPTION);
        return bankAccount;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BankAccount createUpdatedEntity(EntityManager em) {
        BankAccount bankAccount = new BankAccount()
            .name(UPDATED_NAME)
            .guid(UPDATED_GUID)
            .bankNumber(UPDATED_BANK_NUMBER)
            .agencyNumber(UPDATED_AGENCY_NUMBER)
            .lastOperationDuration(UPDATED_LAST_OPERATION_DURATION)
            .meanOperationDuration(UPDATED_MEAN_OPERATION_DURATION)
            .meanQueueDuration(UPDATED_MEAN_QUEUE_DURATION)
            .balance(UPDATED_BALANCE)
            .openingDay(UPDATED_OPENING_DAY)
            .lastOperationDate(UPDATED_LAST_OPERATION_DATE)
            .active(UPDATED_ACTIVE)
            .accountType(UPDATED_ACCOUNT_TYPE)
            .attachment(UPDATED_ATTACHMENT)
            .attachmentContentType(UPDATED_ATTACHMENT_CONTENT_TYPE)
            .description(UPDATED_DESCRIPTION);
        return bankAccount;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(BankAccount.class).block();
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
        bankAccount = createEntity(em);
    }

    @Test
    void createBankAccount() throws Exception {
        int databaseSizeBeforeCreate = bankAccountRepository.findAll().collectList().block().size();
        // Create the BankAccount
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(bankAccount))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the BankAccount in the database
        List<BankAccount> bankAccountList = bankAccountRepository.findAll().collectList().block();
        assertThat(bankAccountList).hasSize(databaseSizeBeforeCreate + 1);
        BankAccount testBankAccount = bankAccountList.get(bankAccountList.size() - 1);
        assertThat(testBankAccount.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testBankAccount.getGuid()).isEqualTo(DEFAULT_GUID);
        assertThat(testBankAccount.getBankNumber()).isEqualTo(DEFAULT_BANK_NUMBER);
        assertThat(testBankAccount.getAgencyNumber()).isEqualTo(DEFAULT_AGENCY_NUMBER);
        assertThat(testBankAccount.getLastOperationDuration()).isEqualTo(DEFAULT_LAST_OPERATION_DURATION);
        assertThat(testBankAccount.getMeanOperationDuration()).isEqualTo(DEFAULT_MEAN_OPERATION_DURATION);
        assertThat(testBankAccount.getMeanQueueDuration()).isEqualTo(DEFAULT_MEAN_QUEUE_DURATION);
        assertThat(testBankAccount.getBalance()).isEqualByComparingTo(DEFAULT_BALANCE);
        assertThat(testBankAccount.getOpeningDay()).isEqualTo(DEFAULT_OPENING_DAY);
        assertThat(testBankAccount.getLastOperationDate()).isEqualTo(DEFAULT_LAST_OPERATION_DATE);
        assertThat(testBankAccount.getActive()).isEqualTo(DEFAULT_ACTIVE);
        assertThat(testBankAccount.getAccountType()).isEqualTo(DEFAULT_ACCOUNT_TYPE);
        assertThat(testBankAccount.getAttachment()).isEqualTo(DEFAULT_ATTACHMENT);
        assertThat(testBankAccount.getAttachmentContentType()).isEqualTo(DEFAULT_ATTACHMENT_CONTENT_TYPE);
        assertThat(testBankAccount.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
    }

    @Test
    void createBankAccountWithExistingId() throws Exception {
        // Create the BankAccount with an existing ID
        bankAccount.setId(1L);

        int databaseSizeBeforeCreate = bankAccountRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(bankAccount))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the BankAccount in the database
        List<BankAccount> bankAccountList = bankAccountRepository.findAll().collectList().block();
        assertThat(bankAccountList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void checkNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = bankAccountRepository.findAll().collectList().block().size();
        // set the field null
        bankAccount.setName(null);

        // Create the BankAccount, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(bankAccount))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<BankAccount> bankAccountList = bankAccountRepository.findAll().collectList().block();
        assertThat(bankAccountList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkBalanceIsRequired() throws Exception {
        int databaseSizeBeforeTest = bankAccountRepository.findAll().collectList().block().size();
        // set the field null
        bankAccount.setBalance(null);

        // Create the BankAccount, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(bankAccount))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<BankAccount> bankAccountList = bankAccountRepository.findAll().collectList().block();
        assertThat(bankAccountList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void getAllBankAccountsAsStream() {
        // Initialize the database
        bankAccountRepository.save(bankAccount).block();

        List<BankAccount> bankAccountList = webTestClient
            .get()
            .uri(ENTITY_API_URL)
            .accept(MediaType.APPLICATION_NDJSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentTypeCompatibleWith(MediaType.APPLICATION_NDJSON)
            .returnResult(BankAccount.class)
            .getResponseBody()
            .filter(bankAccount::equals)
            .collectList()
            .block(Duration.ofSeconds(5));

        assertThat(bankAccountList).isNotNull();
        assertThat(bankAccountList).hasSize(1);
        BankAccount testBankAccount = bankAccountList.get(0);
        assertThat(testBankAccount.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testBankAccount.getGuid()).isEqualTo(DEFAULT_GUID);
        assertThat(testBankAccount.getBankNumber()).isEqualTo(DEFAULT_BANK_NUMBER);
        assertThat(testBankAccount.getAgencyNumber()).isEqualTo(DEFAULT_AGENCY_NUMBER);
        assertThat(testBankAccount.getLastOperationDuration()).isEqualTo(DEFAULT_LAST_OPERATION_DURATION);
        assertThat(testBankAccount.getMeanOperationDuration()).isEqualTo(DEFAULT_MEAN_OPERATION_DURATION);
        assertThat(testBankAccount.getMeanQueueDuration()).isEqualTo(DEFAULT_MEAN_QUEUE_DURATION);
        assertThat(testBankAccount.getBalance()).isEqualByComparingTo(DEFAULT_BALANCE);
        assertThat(testBankAccount.getOpeningDay()).isEqualTo(DEFAULT_OPENING_DAY);
        assertThat(testBankAccount.getLastOperationDate()).isEqualTo(DEFAULT_LAST_OPERATION_DATE);
        assertThat(testBankAccount.getActive()).isEqualTo(DEFAULT_ACTIVE);
        assertThat(testBankAccount.getAccountType()).isEqualTo(DEFAULT_ACCOUNT_TYPE);
        assertThat(testBankAccount.getAttachment()).isEqualTo(DEFAULT_ATTACHMENT);
        assertThat(testBankAccount.getAttachmentContentType()).isEqualTo(DEFAULT_ATTACHMENT_CONTENT_TYPE);
        assertThat(testBankAccount.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
    }

    @Test
    void getAllBankAccounts() {
        // Initialize the database
        bankAccountRepository.save(bankAccount).block();

        // Get all the bankAccountList
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
            .value(hasItem(bankAccount.getId().intValue()))
            .jsonPath("$.[*].name")
            .value(hasItem(DEFAULT_NAME))
            .jsonPath("$.[*].guid")
            .value(hasItem(DEFAULT_GUID.toString()))
            .jsonPath("$.[*].bankNumber")
            .value(hasItem(DEFAULT_BANK_NUMBER))
            .jsonPath("$.[*].agencyNumber")
            .value(hasItem(DEFAULT_AGENCY_NUMBER.intValue()))
            .jsonPath("$.[*].lastOperationDuration")
            .value(hasItem(DEFAULT_LAST_OPERATION_DURATION.doubleValue()))
            .jsonPath("$.[*].meanOperationDuration")
            .value(hasItem(DEFAULT_MEAN_OPERATION_DURATION.doubleValue()))
            .jsonPath("$.[*].meanQueueDuration")
            .value(hasItem(DEFAULT_MEAN_QUEUE_DURATION.toString()))
            .jsonPath("$.[*].balance")
            .value(hasItem(sameNumber(DEFAULT_BALANCE)))
            .jsonPath("$.[*].openingDay")
            .value(hasItem(DEFAULT_OPENING_DAY.toString()))
            .jsonPath("$.[*].lastOperationDate")
            .value(hasItem(DEFAULT_LAST_OPERATION_DATE.toString()))
            .jsonPath("$.[*].active")
            .value(hasItem(DEFAULT_ACTIVE.booleanValue()))
            .jsonPath("$.[*].accountType")
            .value(hasItem(DEFAULT_ACCOUNT_TYPE.toString()))
            .jsonPath("$.[*].attachmentContentType")
            .value(hasItem(DEFAULT_ATTACHMENT_CONTENT_TYPE))
            .jsonPath("$.[*].attachment")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_ATTACHMENT)))
            .jsonPath("$.[*].description")
            .value(hasItem(DEFAULT_DESCRIPTION.toString()));
    }

    @Test
    void getBankAccount() {
        // Initialize the database
        bankAccountRepository.save(bankAccount).block();

        // Get the bankAccount
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, bankAccount.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id")
            .value(is(bankAccount.getId().intValue()))
            .jsonPath("$.name")
            .value(is(DEFAULT_NAME))
            .jsonPath("$.guid")
            .value(is(DEFAULT_GUID.toString()))
            .jsonPath("$.bankNumber")
            .value(is(DEFAULT_BANK_NUMBER))
            .jsonPath("$.agencyNumber")
            .value(is(DEFAULT_AGENCY_NUMBER.intValue()))
            .jsonPath("$.lastOperationDuration")
            .value(is(DEFAULT_LAST_OPERATION_DURATION.doubleValue()))
            .jsonPath("$.meanOperationDuration")
            .value(is(DEFAULT_MEAN_OPERATION_DURATION.doubleValue()))
            .jsonPath("$.meanQueueDuration")
            .value(is(DEFAULT_MEAN_QUEUE_DURATION.toString()))
            .jsonPath("$.balance")
            .value(is(sameNumber(DEFAULT_BALANCE)))
            .jsonPath("$.openingDay")
            .value(is(DEFAULT_OPENING_DAY.toString()))
            .jsonPath("$.lastOperationDate")
            .value(is(DEFAULT_LAST_OPERATION_DATE.toString()))
            .jsonPath("$.active")
            .value(is(DEFAULT_ACTIVE.booleanValue()))
            .jsonPath("$.accountType")
            .value(is(DEFAULT_ACCOUNT_TYPE.toString()))
            .jsonPath("$.attachmentContentType")
            .value(is(DEFAULT_ATTACHMENT_CONTENT_TYPE))
            .jsonPath("$.attachment")
            .value(is(Base64Utils.encodeToString(DEFAULT_ATTACHMENT)))
            .jsonPath("$.description")
            .value(is(DEFAULT_DESCRIPTION.toString()));
    }

    @Test
    void getNonExistingBankAccount() {
        // Get the bankAccount
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putNewBankAccount() throws Exception {
        // Initialize the database
        bankAccountRepository.save(bankAccount).block();

        int databaseSizeBeforeUpdate = bankAccountRepository.findAll().collectList().block().size();

        // Update the bankAccount
        BankAccount updatedBankAccount = bankAccountRepository.findById(bankAccount.getId()).block();
        updatedBankAccount
            .name(UPDATED_NAME)
            .guid(UPDATED_GUID)
            .bankNumber(UPDATED_BANK_NUMBER)
            .agencyNumber(UPDATED_AGENCY_NUMBER)
            .lastOperationDuration(UPDATED_LAST_OPERATION_DURATION)
            .meanOperationDuration(UPDATED_MEAN_OPERATION_DURATION)
            .meanQueueDuration(UPDATED_MEAN_QUEUE_DURATION)
            .balance(UPDATED_BALANCE)
            .openingDay(UPDATED_OPENING_DAY)
            .lastOperationDate(UPDATED_LAST_OPERATION_DATE)
            .active(UPDATED_ACTIVE)
            .accountType(UPDATED_ACCOUNT_TYPE)
            .attachment(UPDATED_ATTACHMENT)
            .attachmentContentType(UPDATED_ATTACHMENT_CONTENT_TYPE)
            .description(UPDATED_DESCRIPTION);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, updatedBankAccount.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(updatedBankAccount))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the BankAccount in the database
        List<BankAccount> bankAccountList = bankAccountRepository.findAll().collectList().block();
        assertThat(bankAccountList).hasSize(databaseSizeBeforeUpdate);
        BankAccount testBankAccount = bankAccountList.get(bankAccountList.size() - 1);
        assertThat(testBankAccount.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testBankAccount.getGuid()).isEqualTo(UPDATED_GUID);
        assertThat(testBankAccount.getBankNumber()).isEqualTo(UPDATED_BANK_NUMBER);
        assertThat(testBankAccount.getAgencyNumber()).isEqualTo(UPDATED_AGENCY_NUMBER);
        assertThat(testBankAccount.getLastOperationDuration()).isEqualTo(UPDATED_LAST_OPERATION_DURATION);
        assertThat(testBankAccount.getMeanOperationDuration()).isEqualTo(UPDATED_MEAN_OPERATION_DURATION);
        assertThat(testBankAccount.getMeanQueueDuration()).isEqualTo(UPDATED_MEAN_QUEUE_DURATION);
        assertThat(testBankAccount.getBalance()).isEqualTo(UPDATED_BALANCE);
        assertThat(testBankAccount.getOpeningDay()).isEqualTo(UPDATED_OPENING_DAY);
        assertThat(testBankAccount.getLastOperationDate()).isEqualTo(UPDATED_LAST_OPERATION_DATE);
        assertThat(testBankAccount.getActive()).isEqualTo(UPDATED_ACTIVE);
        assertThat(testBankAccount.getAccountType()).isEqualTo(UPDATED_ACCOUNT_TYPE);
        assertThat(testBankAccount.getAttachment()).isEqualTo(UPDATED_ATTACHMENT);
        assertThat(testBankAccount.getAttachmentContentType()).isEqualTo(UPDATED_ATTACHMENT_CONTENT_TYPE);
        assertThat(testBankAccount.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
    }

    @Test
    void putNonExistingBankAccount() throws Exception {
        int databaseSizeBeforeUpdate = bankAccountRepository.findAll().collectList().block().size();
        bankAccount.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, bankAccount.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(bankAccount))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the BankAccount in the database
        List<BankAccount> bankAccountList = bankAccountRepository.findAll().collectList().block();
        assertThat(bankAccountList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchBankAccount() throws Exception {
        int databaseSizeBeforeUpdate = bankAccountRepository.findAll().collectList().block().size();
        bankAccount.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(bankAccount))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the BankAccount in the database
        List<BankAccount> bankAccountList = bankAccountRepository.findAll().collectList().block();
        assertThat(bankAccountList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamBankAccount() throws Exception {
        int databaseSizeBeforeUpdate = bankAccountRepository.findAll().collectList().block().size();
        bankAccount.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(bankAccount))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the BankAccount in the database
        List<BankAccount> bankAccountList = bankAccountRepository.findAll().collectList().block();
        assertThat(bankAccountList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateBankAccountWithPatch() throws Exception {
        // Initialize the database
        bankAccountRepository.save(bankAccount).block();

        int databaseSizeBeforeUpdate = bankAccountRepository.findAll().collectList().block().size();

        // Update the bankAccount using partial update
        BankAccount partialUpdatedBankAccount = new BankAccount();
        partialUpdatedBankAccount.setId(bankAccount.getId());

        partialUpdatedBankAccount
            .name(UPDATED_NAME)
            .guid(UPDATED_GUID)
            .agencyNumber(UPDATED_AGENCY_NUMBER)
            .meanOperationDuration(UPDATED_MEAN_OPERATION_DURATION)
            .balance(UPDATED_BALANCE)
            .active(UPDATED_ACTIVE)
            .description(UPDATED_DESCRIPTION);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedBankAccount.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedBankAccount))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the BankAccount in the database
        List<BankAccount> bankAccountList = bankAccountRepository.findAll().collectList().block();
        assertThat(bankAccountList).hasSize(databaseSizeBeforeUpdate);
        BankAccount testBankAccount = bankAccountList.get(bankAccountList.size() - 1);
        assertThat(testBankAccount.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testBankAccount.getGuid()).isEqualTo(UPDATED_GUID);
        assertThat(testBankAccount.getBankNumber()).isEqualTo(DEFAULT_BANK_NUMBER);
        assertThat(testBankAccount.getAgencyNumber()).isEqualTo(UPDATED_AGENCY_NUMBER);
        assertThat(testBankAccount.getLastOperationDuration()).isEqualTo(DEFAULT_LAST_OPERATION_DURATION);
        assertThat(testBankAccount.getMeanOperationDuration()).isEqualTo(UPDATED_MEAN_OPERATION_DURATION);
        assertThat(testBankAccount.getMeanQueueDuration()).isEqualTo(DEFAULT_MEAN_QUEUE_DURATION);
        assertThat(testBankAccount.getBalance()).isEqualByComparingTo(UPDATED_BALANCE);
        assertThat(testBankAccount.getOpeningDay()).isEqualTo(DEFAULT_OPENING_DAY);
        assertThat(testBankAccount.getLastOperationDate()).isEqualTo(DEFAULT_LAST_OPERATION_DATE);
        assertThat(testBankAccount.getActive()).isEqualTo(UPDATED_ACTIVE);
        assertThat(testBankAccount.getAccountType()).isEqualTo(DEFAULT_ACCOUNT_TYPE);
        assertThat(testBankAccount.getAttachment()).isEqualTo(DEFAULT_ATTACHMENT);
        assertThat(testBankAccount.getAttachmentContentType()).isEqualTo(DEFAULT_ATTACHMENT_CONTENT_TYPE);
        assertThat(testBankAccount.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
    }

    @Test
    void fullUpdateBankAccountWithPatch() throws Exception {
        // Initialize the database
        bankAccountRepository.save(bankAccount).block();

        int databaseSizeBeforeUpdate = bankAccountRepository.findAll().collectList().block().size();

        // Update the bankAccount using partial update
        BankAccount partialUpdatedBankAccount = new BankAccount();
        partialUpdatedBankAccount.setId(bankAccount.getId());

        partialUpdatedBankAccount
            .name(UPDATED_NAME)
            .guid(UPDATED_GUID)
            .bankNumber(UPDATED_BANK_NUMBER)
            .agencyNumber(UPDATED_AGENCY_NUMBER)
            .lastOperationDuration(UPDATED_LAST_OPERATION_DURATION)
            .meanOperationDuration(UPDATED_MEAN_OPERATION_DURATION)
            .meanQueueDuration(UPDATED_MEAN_QUEUE_DURATION)
            .balance(UPDATED_BALANCE)
            .openingDay(UPDATED_OPENING_DAY)
            .lastOperationDate(UPDATED_LAST_OPERATION_DATE)
            .active(UPDATED_ACTIVE)
            .accountType(UPDATED_ACCOUNT_TYPE)
            .attachment(UPDATED_ATTACHMENT)
            .attachmentContentType(UPDATED_ATTACHMENT_CONTENT_TYPE)
            .description(UPDATED_DESCRIPTION);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedBankAccount.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedBankAccount))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the BankAccount in the database
        List<BankAccount> bankAccountList = bankAccountRepository.findAll().collectList().block();
        assertThat(bankAccountList).hasSize(databaseSizeBeforeUpdate);
        BankAccount testBankAccount = bankAccountList.get(bankAccountList.size() - 1);
        assertThat(testBankAccount.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testBankAccount.getGuid()).isEqualTo(UPDATED_GUID);
        assertThat(testBankAccount.getBankNumber()).isEqualTo(UPDATED_BANK_NUMBER);
        assertThat(testBankAccount.getAgencyNumber()).isEqualTo(UPDATED_AGENCY_NUMBER);
        assertThat(testBankAccount.getLastOperationDuration()).isEqualTo(UPDATED_LAST_OPERATION_DURATION);
        assertThat(testBankAccount.getMeanOperationDuration()).isEqualTo(UPDATED_MEAN_OPERATION_DURATION);
        assertThat(testBankAccount.getMeanQueueDuration()).isEqualTo(UPDATED_MEAN_QUEUE_DURATION);
        assertThat(testBankAccount.getBalance()).isEqualByComparingTo(UPDATED_BALANCE);
        assertThat(testBankAccount.getOpeningDay()).isEqualTo(UPDATED_OPENING_DAY);
        assertThat(testBankAccount.getLastOperationDate()).isEqualTo(UPDATED_LAST_OPERATION_DATE);
        assertThat(testBankAccount.getActive()).isEqualTo(UPDATED_ACTIVE);
        assertThat(testBankAccount.getAccountType()).isEqualTo(UPDATED_ACCOUNT_TYPE);
        assertThat(testBankAccount.getAttachment()).isEqualTo(UPDATED_ATTACHMENT);
        assertThat(testBankAccount.getAttachmentContentType()).isEqualTo(UPDATED_ATTACHMENT_CONTENT_TYPE);
        assertThat(testBankAccount.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
    }

    @Test
    void patchNonExistingBankAccount() throws Exception {
        int databaseSizeBeforeUpdate = bankAccountRepository.findAll().collectList().block().size();
        bankAccount.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, bankAccount.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(bankAccount))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the BankAccount in the database
        List<BankAccount> bankAccountList = bankAccountRepository.findAll().collectList().block();
        assertThat(bankAccountList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchBankAccount() throws Exception {
        int databaseSizeBeforeUpdate = bankAccountRepository.findAll().collectList().block().size();
        bankAccount.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(bankAccount))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the BankAccount in the database
        List<BankAccount> bankAccountList = bankAccountRepository.findAll().collectList().block();
        assertThat(bankAccountList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamBankAccount() throws Exception {
        int databaseSizeBeforeUpdate = bankAccountRepository.findAll().collectList().block().size();
        bankAccount.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(bankAccount))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the BankAccount in the database
        List<BankAccount> bankAccountList = bankAccountRepository.findAll().collectList().block();
        assertThat(bankAccountList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteBankAccount() {
        // Initialize the database
        bankAccountRepository.save(bankAccount).block();

        int databaseSizeBeforeDelete = bankAccountRepository.findAll().collectList().block().size();

        // Delete the bankAccount
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, bankAccount.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<BankAccount> bankAccountList = bankAccountRepository.findAll().collectList().block();
        assertThat(bankAccountList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
