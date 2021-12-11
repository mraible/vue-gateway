package tech.jhipster.sample.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static tech.jhipster.sample.web.rest.TestUtil.sameInstant;
import static tech.jhipster.sample.web.rest.TestUtil.sameNumber;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
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
import tech.jhipster.sample.domain.FieldTestMapstructAndServiceClassEntity;
import tech.jhipster.sample.domain.enumeration.EnumFieldClass;
import tech.jhipster.sample.domain.enumeration.EnumRequiredFieldClass;
import tech.jhipster.sample.repository.FieldTestMapstructAndServiceClassEntityRepository;
import tech.jhipster.sample.service.EntityManager;
import tech.jhipster.sample.service.dto.FieldTestMapstructAndServiceClassEntityDTO;
import tech.jhipster.sample.service.mapper.FieldTestMapstructAndServiceClassEntityMapper;

/**
 * Integration tests for the {@link FieldTestMapstructAndServiceClassEntityResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient
@WithMockUser
class FieldTestMapstructAndServiceClassEntityResourceIT {

    private static final String DEFAULT_STRING_EVA = "AAAAAAAAAA";
    private static final String UPDATED_STRING_EVA = "BBBBBBBBBB";

    private static final String DEFAULT_STRING_REQUIRED_EVA = "AAAAAAAAAA";
    private static final String UPDATED_STRING_REQUIRED_EVA = "BBBBBBBBBB";

    private static final String DEFAULT_STRING_MINLENGTH_EVA = "AAAAAAAAAA";
    private static final String UPDATED_STRING_MINLENGTH_EVA = "BBBBBBBBBB";

    private static final String DEFAULT_STRING_MAXLENGTH_EVA = "AAAAAAAAAA";
    private static final String UPDATED_STRING_MAXLENGTH_EVA = "BBBBBBBBBB";

    private static final String DEFAULT_STRING_PATTERN_EVA = "AAAAAAAAAA";
    private static final String UPDATED_STRING_PATTERN_EVA = "BBBBBBBBBB";

    private static final Integer DEFAULT_INTEGER_EVA = 1;
    private static final Integer UPDATED_INTEGER_EVA = 2;

    private static final Integer DEFAULT_INTEGER_REQUIRED_EVA = 1;
    private static final Integer UPDATED_INTEGER_REQUIRED_EVA = 2;

    private static final Integer DEFAULT_INTEGER_MIN_EVA = 0;
    private static final Integer UPDATED_INTEGER_MIN_EVA = 1;

    private static final Integer DEFAULT_INTEGER_MAX_EVA = 100;
    private static final Integer UPDATED_INTEGER_MAX_EVA = 99;

    private static final Long DEFAULT_LONG_EVA = 1L;
    private static final Long UPDATED_LONG_EVA = 2L;

    private static final Long DEFAULT_LONG_REQUIRED_EVA = 1L;
    private static final Long UPDATED_LONG_REQUIRED_EVA = 2L;

    private static final Long DEFAULT_LONG_MIN_EVA = 0L;
    private static final Long UPDATED_LONG_MIN_EVA = 1L;

    private static final Long DEFAULT_LONG_MAX_EVA = 100L;
    private static final Long UPDATED_LONG_MAX_EVA = 99L;

    private static final Float DEFAULT_FLOAT_EVA = 1F;
    private static final Float UPDATED_FLOAT_EVA = 2F;

    private static final Float DEFAULT_FLOAT_REQUIRED_EVA = 1F;
    private static final Float UPDATED_FLOAT_REQUIRED_EVA = 2F;

    private static final Float DEFAULT_FLOAT_MIN_EVA = 0F;
    private static final Float UPDATED_FLOAT_MIN_EVA = 1F;

    private static final Float DEFAULT_FLOAT_MAX_EVA = 100F;
    private static final Float UPDATED_FLOAT_MAX_EVA = 99F;

    private static final Double DEFAULT_DOUBLE_REQUIRED_EVA = 1D;
    private static final Double UPDATED_DOUBLE_REQUIRED_EVA = 2D;

    private static final Double DEFAULT_DOUBLE_MIN_EVA = 0D;
    private static final Double UPDATED_DOUBLE_MIN_EVA = 1D;

    private static final Double DEFAULT_DOUBLE_MAX_EVA = 100D;
    private static final Double UPDATED_DOUBLE_MAX_EVA = 99D;

    private static final BigDecimal DEFAULT_BIG_DECIMAL_REQUIRED_EVA = new BigDecimal(1);
    private static final BigDecimal UPDATED_BIG_DECIMAL_REQUIRED_EVA = new BigDecimal(2);

    private static final BigDecimal DEFAULT_BIG_DECIMAL_MIN_EVA = new BigDecimal(0);
    private static final BigDecimal UPDATED_BIG_DECIMAL_MIN_EVA = new BigDecimal(1);

    private static final BigDecimal DEFAULT_BIG_DECIMAL_MAX_EVA = new BigDecimal(100);
    private static final BigDecimal UPDATED_BIG_DECIMAL_MAX_EVA = new BigDecimal(99);

    private static final LocalDate DEFAULT_LOCAL_DATE_EVA = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LOCAL_DATE_EVA = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_LOCAL_DATE_REQUIRED_EVA = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LOCAL_DATE_REQUIRED_EVA = LocalDate.now(ZoneId.systemDefault());

    private static final Instant DEFAULT_INSTANT_EVA = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_INSTANT_EVA = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_INSTANTE_REQUIRED_EVA = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_INSTANTE_REQUIRED_EVA = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final ZonedDateTime DEFAULT_ZONED_DATE_TIME_EVA = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_ZONED_DATE_TIME_EVA = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_ZONED_DATE_TIME_REQUIRED_EVA = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_ZONED_DATE_TIME_REQUIRED_EVA = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final Duration DEFAULT_DURATION_EVA = Duration.ofHours(6);
    private static final Duration UPDATED_DURATION_EVA = Duration.ofHours(12);

    private static final Duration DEFAULT_DURATION_REQUIRED_EVA = Duration.ofHours(6);
    private static final Duration UPDATED_DURATION_REQUIRED_EVA = Duration.ofHours(12);

    private static final Boolean DEFAULT_BOOLEAN_EVA = false;
    private static final Boolean UPDATED_BOOLEAN_EVA = true;

    private static final Boolean DEFAULT_BOOLEAN_REQUIRED_EVA = false;
    private static final Boolean UPDATED_BOOLEAN_REQUIRED_EVA = true;

    private static final EnumFieldClass DEFAULT_ENUM_EVA = EnumFieldClass.ENUM_VALUE_1;
    private static final EnumFieldClass UPDATED_ENUM_EVA = EnumFieldClass.ENUM_VALUE_2;

    private static final EnumRequiredFieldClass DEFAULT_ENUM_REQUIRED_EVA = EnumRequiredFieldClass.ENUM_VALUE_1;
    private static final EnumRequiredFieldClass UPDATED_ENUM_REQUIRED_EVA = EnumRequiredFieldClass.ENUM_VALUE_2;

    private static final UUID DEFAULT_UUID_EVA = UUID.randomUUID();
    private static final UUID UPDATED_UUID_EVA = UUID.randomUUID();

    private static final UUID DEFAULT_UUID_REQUIRED_EVA = UUID.randomUUID();
    private static final UUID UPDATED_UUID_REQUIRED_EVA = UUID.randomUUID();

    private static final byte[] DEFAULT_BYTE_IMAGE_EVA = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_IMAGE_EVA = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_IMAGE_EVA_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_IMAGE_EVA_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_IMAGE_REQUIRED_EVA = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_IMAGE_REQUIRED_EVA = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_IMAGE_REQUIRED_EVA_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_IMAGE_REQUIRED_EVA_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_IMAGE_MINBYTES_EVA = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_IMAGE_MINBYTES_EVA = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_IMAGE_MINBYTES_EVA_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_IMAGE_MINBYTES_EVA_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_IMAGE_MAXBYTES_EVA = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_IMAGE_MAXBYTES_EVA = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_IMAGE_MAXBYTES_EVA_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_IMAGE_MAXBYTES_EVA_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_ANY_EVA = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_ANY_EVA = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_ANY_EVA_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_ANY_EVA_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_ANY_REQUIRED_EVA = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_ANY_REQUIRED_EVA = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_ANY_REQUIRED_EVA_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_ANY_REQUIRED_EVA_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_ANY_MINBYTES_EVA = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_ANY_MINBYTES_EVA = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_ANY_MINBYTES_EVA_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_ANY_MINBYTES_EVA_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_ANY_MAXBYTES_EVA = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_ANY_MAXBYTES_EVA = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_ANY_MAXBYTES_EVA_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_ANY_MAXBYTES_EVA_CONTENT_TYPE = "image/png";

    private static final String DEFAULT_BYTE_TEXT_EVA = "AAAAAAAAAA";
    private static final String UPDATED_BYTE_TEXT_EVA = "BBBBBBBBBB";

    private static final String DEFAULT_BYTE_TEXT_REQUIRED_EVA = "AAAAAAAAAA";
    private static final String UPDATED_BYTE_TEXT_REQUIRED_EVA = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/field-test-mapstruct-and-service-class-entities";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private FieldTestMapstructAndServiceClassEntityRepository fieldTestMapstructAndServiceClassEntityRepository;

    @Autowired
    private FieldTestMapstructAndServiceClassEntityMapper fieldTestMapstructAndServiceClassEntityMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private FieldTestMapstructAndServiceClassEntity fieldTestMapstructAndServiceClassEntity;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FieldTestMapstructAndServiceClassEntity createEntity(EntityManager em) {
        FieldTestMapstructAndServiceClassEntity fieldTestMapstructAndServiceClassEntity = new FieldTestMapstructAndServiceClassEntity()
            .stringEva(DEFAULT_STRING_EVA)
            .stringRequiredEva(DEFAULT_STRING_REQUIRED_EVA)
            .stringMinlengthEva(DEFAULT_STRING_MINLENGTH_EVA)
            .stringMaxlengthEva(DEFAULT_STRING_MAXLENGTH_EVA)
            .stringPatternEva(DEFAULT_STRING_PATTERN_EVA)
            .integerEva(DEFAULT_INTEGER_EVA)
            .integerRequiredEva(DEFAULT_INTEGER_REQUIRED_EVA)
            .integerMinEva(DEFAULT_INTEGER_MIN_EVA)
            .integerMaxEva(DEFAULT_INTEGER_MAX_EVA)
            .longEva(DEFAULT_LONG_EVA)
            .longRequiredEva(DEFAULT_LONG_REQUIRED_EVA)
            .longMinEva(DEFAULT_LONG_MIN_EVA)
            .longMaxEva(DEFAULT_LONG_MAX_EVA)
            .floatEva(DEFAULT_FLOAT_EVA)
            .floatRequiredEva(DEFAULT_FLOAT_REQUIRED_EVA)
            .floatMinEva(DEFAULT_FLOAT_MIN_EVA)
            .floatMaxEva(DEFAULT_FLOAT_MAX_EVA)
            .doubleRequiredEva(DEFAULT_DOUBLE_REQUIRED_EVA)
            .doubleMinEva(DEFAULT_DOUBLE_MIN_EVA)
            .doubleMaxEva(DEFAULT_DOUBLE_MAX_EVA)
            .bigDecimalRequiredEva(DEFAULT_BIG_DECIMAL_REQUIRED_EVA)
            .bigDecimalMinEva(DEFAULT_BIG_DECIMAL_MIN_EVA)
            .bigDecimalMaxEva(DEFAULT_BIG_DECIMAL_MAX_EVA)
            .localDateEva(DEFAULT_LOCAL_DATE_EVA)
            .localDateRequiredEva(DEFAULT_LOCAL_DATE_REQUIRED_EVA)
            .instantEva(DEFAULT_INSTANT_EVA)
            .instanteRequiredEva(DEFAULT_INSTANTE_REQUIRED_EVA)
            .zonedDateTimeEva(DEFAULT_ZONED_DATE_TIME_EVA)
            .zonedDateTimeRequiredEva(DEFAULT_ZONED_DATE_TIME_REQUIRED_EVA)
            .durationEva(DEFAULT_DURATION_EVA)
            .durationRequiredEva(DEFAULT_DURATION_REQUIRED_EVA)
            .booleanEva(DEFAULT_BOOLEAN_EVA)
            .booleanRequiredEva(DEFAULT_BOOLEAN_REQUIRED_EVA)
            .enumEva(DEFAULT_ENUM_EVA)
            .enumRequiredEva(DEFAULT_ENUM_REQUIRED_EVA)
            .uuidEva(DEFAULT_UUID_EVA)
            .uuidRequiredEva(DEFAULT_UUID_REQUIRED_EVA)
            .byteImageEva(DEFAULT_BYTE_IMAGE_EVA)
            .byteImageEvaContentType(DEFAULT_BYTE_IMAGE_EVA_CONTENT_TYPE)
            .byteImageRequiredEva(DEFAULT_BYTE_IMAGE_REQUIRED_EVA)
            .byteImageRequiredEvaContentType(DEFAULT_BYTE_IMAGE_REQUIRED_EVA_CONTENT_TYPE)
            .byteImageMinbytesEva(DEFAULT_BYTE_IMAGE_MINBYTES_EVA)
            .byteImageMinbytesEvaContentType(DEFAULT_BYTE_IMAGE_MINBYTES_EVA_CONTENT_TYPE)
            .byteImageMaxbytesEva(DEFAULT_BYTE_IMAGE_MAXBYTES_EVA)
            .byteImageMaxbytesEvaContentType(DEFAULT_BYTE_IMAGE_MAXBYTES_EVA_CONTENT_TYPE)
            .byteAnyEva(DEFAULT_BYTE_ANY_EVA)
            .byteAnyEvaContentType(DEFAULT_BYTE_ANY_EVA_CONTENT_TYPE)
            .byteAnyRequiredEva(DEFAULT_BYTE_ANY_REQUIRED_EVA)
            .byteAnyRequiredEvaContentType(DEFAULT_BYTE_ANY_REQUIRED_EVA_CONTENT_TYPE)
            .byteAnyMinbytesEva(DEFAULT_BYTE_ANY_MINBYTES_EVA)
            .byteAnyMinbytesEvaContentType(DEFAULT_BYTE_ANY_MINBYTES_EVA_CONTENT_TYPE)
            .byteAnyMaxbytesEva(DEFAULT_BYTE_ANY_MAXBYTES_EVA)
            .byteAnyMaxbytesEvaContentType(DEFAULT_BYTE_ANY_MAXBYTES_EVA_CONTENT_TYPE)
            .byteTextEva(DEFAULT_BYTE_TEXT_EVA)
            .byteTextRequiredEva(DEFAULT_BYTE_TEXT_REQUIRED_EVA);
        return fieldTestMapstructAndServiceClassEntity;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FieldTestMapstructAndServiceClassEntity createUpdatedEntity(EntityManager em) {
        FieldTestMapstructAndServiceClassEntity fieldTestMapstructAndServiceClassEntity = new FieldTestMapstructAndServiceClassEntity()
            .stringEva(UPDATED_STRING_EVA)
            .stringRequiredEva(UPDATED_STRING_REQUIRED_EVA)
            .stringMinlengthEva(UPDATED_STRING_MINLENGTH_EVA)
            .stringMaxlengthEva(UPDATED_STRING_MAXLENGTH_EVA)
            .stringPatternEva(UPDATED_STRING_PATTERN_EVA)
            .integerEva(UPDATED_INTEGER_EVA)
            .integerRequiredEva(UPDATED_INTEGER_REQUIRED_EVA)
            .integerMinEva(UPDATED_INTEGER_MIN_EVA)
            .integerMaxEva(UPDATED_INTEGER_MAX_EVA)
            .longEva(UPDATED_LONG_EVA)
            .longRequiredEva(UPDATED_LONG_REQUIRED_EVA)
            .longMinEva(UPDATED_LONG_MIN_EVA)
            .longMaxEva(UPDATED_LONG_MAX_EVA)
            .floatEva(UPDATED_FLOAT_EVA)
            .floatRequiredEva(UPDATED_FLOAT_REQUIRED_EVA)
            .floatMinEva(UPDATED_FLOAT_MIN_EVA)
            .floatMaxEva(UPDATED_FLOAT_MAX_EVA)
            .doubleRequiredEva(UPDATED_DOUBLE_REQUIRED_EVA)
            .doubleMinEva(UPDATED_DOUBLE_MIN_EVA)
            .doubleMaxEva(UPDATED_DOUBLE_MAX_EVA)
            .bigDecimalRequiredEva(UPDATED_BIG_DECIMAL_REQUIRED_EVA)
            .bigDecimalMinEva(UPDATED_BIG_DECIMAL_MIN_EVA)
            .bigDecimalMaxEva(UPDATED_BIG_DECIMAL_MAX_EVA)
            .localDateEva(UPDATED_LOCAL_DATE_EVA)
            .localDateRequiredEva(UPDATED_LOCAL_DATE_REQUIRED_EVA)
            .instantEva(UPDATED_INSTANT_EVA)
            .instanteRequiredEva(UPDATED_INSTANTE_REQUIRED_EVA)
            .zonedDateTimeEva(UPDATED_ZONED_DATE_TIME_EVA)
            .zonedDateTimeRequiredEva(UPDATED_ZONED_DATE_TIME_REQUIRED_EVA)
            .durationEva(UPDATED_DURATION_EVA)
            .durationRequiredEva(UPDATED_DURATION_REQUIRED_EVA)
            .booleanEva(UPDATED_BOOLEAN_EVA)
            .booleanRequiredEva(UPDATED_BOOLEAN_REQUIRED_EVA)
            .enumEva(UPDATED_ENUM_EVA)
            .enumRequiredEva(UPDATED_ENUM_REQUIRED_EVA)
            .uuidEva(UPDATED_UUID_EVA)
            .uuidRequiredEva(UPDATED_UUID_REQUIRED_EVA)
            .byteImageEva(UPDATED_BYTE_IMAGE_EVA)
            .byteImageEvaContentType(UPDATED_BYTE_IMAGE_EVA_CONTENT_TYPE)
            .byteImageRequiredEva(UPDATED_BYTE_IMAGE_REQUIRED_EVA)
            .byteImageRequiredEvaContentType(UPDATED_BYTE_IMAGE_REQUIRED_EVA_CONTENT_TYPE)
            .byteImageMinbytesEva(UPDATED_BYTE_IMAGE_MINBYTES_EVA)
            .byteImageMinbytesEvaContentType(UPDATED_BYTE_IMAGE_MINBYTES_EVA_CONTENT_TYPE)
            .byteImageMaxbytesEva(UPDATED_BYTE_IMAGE_MAXBYTES_EVA)
            .byteImageMaxbytesEvaContentType(UPDATED_BYTE_IMAGE_MAXBYTES_EVA_CONTENT_TYPE)
            .byteAnyEva(UPDATED_BYTE_ANY_EVA)
            .byteAnyEvaContentType(UPDATED_BYTE_ANY_EVA_CONTENT_TYPE)
            .byteAnyRequiredEva(UPDATED_BYTE_ANY_REQUIRED_EVA)
            .byteAnyRequiredEvaContentType(UPDATED_BYTE_ANY_REQUIRED_EVA_CONTENT_TYPE)
            .byteAnyMinbytesEva(UPDATED_BYTE_ANY_MINBYTES_EVA)
            .byteAnyMinbytesEvaContentType(UPDATED_BYTE_ANY_MINBYTES_EVA_CONTENT_TYPE)
            .byteAnyMaxbytesEva(UPDATED_BYTE_ANY_MAXBYTES_EVA)
            .byteAnyMaxbytesEvaContentType(UPDATED_BYTE_ANY_MAXBYTES_EVA_CONTENT_TYPE)
            .byteTextEva(UPDATED_BYTE_TEXT_EVA)
            .byteTextRequiredEva(UPDATED_BYTE_TEXT_REQUIRED_EVA);
        return fieldTestMapstructAndServiceClassEntity;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(FieldTestMapstructAndServiceClassEntity.class).block();
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
        fieldTestMapstructAndServiceClassEntity = createEntity(em);
    }

    @Test
    void createFieldTestMapstructAndServiceClassEntity() throws Exception {
        int databaseSizeBeforeCreate = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();
        // Create the FieldTestMapstructAndServiceClassEntity
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            fieldTestMapstructAndServiceClassEntity
        );
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the FieldTestMapstructAndServiceClassEntity in the database
        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeCreate + 1);
        FieldTestMapstructAndServiceClassEntity testFieldTestMapstructAndServiceClassEntity = fieldTestMapstructAndServiceClassEntityList.get(
            fieldTestMapstructAndServiceClassEntityList.size() - 1
        );
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringEva()).isEqualTo(DEFAULT_STRING_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringRequiredEva()).isEqualTo(DEFAULT_STRING_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringMinlengthEva()).isEqualTo(DEFAULT_STRING_MINLENGTH_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringMaxlengthEva()).isEqualTo(DEFAULT_STRING_MAXLENGTH_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringPatternEva()).isEqualTo(DEFAULT_STRING_PATTERN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getIntegerEva()).isEqualTo(DEFAULT_INTEGER_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getIntegerRequiredEva()).isEqualTo(DEFAULT_INTEGER_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getIntegerMinEva()).isEqualTo(DEFAULT_INTEGER_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getIntegerMaxEva()).isEqualTo(DEFAULT_INTEGER_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLongEva()).isEqualTo(DEFAULT_LONG_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLongRequiredEva()).isEqualTo(DEFAULT_LONG_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLongMinEva()).isEqualTo(DEFAULT_LONG_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLongMaxEva()).isEqualTo(DEFAULT_LONG_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getFloatEva()).isEqualTo(DEFAULT_FLOAT_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getFloatRequiredEva()).isEqualTo(DEFAULT_FLOAT_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getFloatMinEva()).isEqualTo(DEFAULT_FLOAT_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getFloatMaxEva()).isEqualTo(DEFAULT_FLOAT_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDoubleRequiredEva()).isEqualTo(DEFAULT_DOUBLE_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDoubleMinEva()).isEqualTo(DEFAULT_DOUBLE_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDoubleMaxEva()).isEqualTo(DEFAULT_DOUBLE_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBigDecimalRequiredEva())
            .isEqualByComparingTo(DEFAULT_BIG_DECIMAL_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBigDecimalMinEva()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBigDecimalMaxEva()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLocalDateEva()).isEqualTo(DEFAULT_LOCAL_DATE_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLocalDateRequiredEva()).isEqualTo(DEFAULT_LOCAL_DATE_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getInstantEva()).isEqualTo(DEFAULT_INSTANT_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getInstanteRequiredEva()).isEqualTo(DEFAULT_INSTANTE_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getZonedDateTimeEva()).isEqualTo(DEFAULT_ZONED_DATE_TIME_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getZonedDateTimeRequiredEva())
            .isEqualTo(DEFAULT_ZONED_DATE_TIME_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDurationEva()).isEqualTo(DEFAULT_DURATION_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDurationRequiredEva()).isEqualTo(DEFAULT_DURATION_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBooleanEva()).isEqualTo(DEFAULT_BOOLEAN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBooleanRequiredEva()).isEqualTo(DEFAULT_BOOLEAN_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getEnumEva()).isEqualTo(DEFAULT_ENUM_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getEnumRequiredEva()).isEqualTo(DEFAULT_ENUM_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getUuidEva()).isEqualTo(DEFAULT_UUID_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getUuidRequiredEva()).isEqualTo(DEFAULT_UUID_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageEva()).isEqualTo(DEFAULT_BYTE_IMAGE_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageEvaContentType()).isEqualTo(DEFAULT_BYTE_IMAGE_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageRequiredEva()).isEqualTo(DEFAULT_BYTE_IMAGE_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageRequiredEvaContentType())
            .isEqualTo(DEFAULT_BYTE_IMAGE_REQUIRED_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageMinbytesEva()).isEqualTo(DEFAULT_BYTE_IMAGE_MINBYTES_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageMinbytesEvaContentType())
            .isEqualTo(DEFAULT_BYTE_IMAGE_MINBYTES_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageMaxbytesEva()).isEqualTo(DEFAULT_BYTE_IMAGE_MAXBYTES_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageMaxbytesEvaContentType())
            .isEqualTo(DEFAULT_BYTE_IMAGE_MAXBYTES_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyEva()).isEqualTo(DEFAULT_BYTE_ANY_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyEvaContentType()).isEqualTo(DEFAULT_BYTE_ANY_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyRequiredEva()).isEqualTo(DEFAULT_BYTE_ANY_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyRequiredEvaContentType())
            .isEqualTo(DEFAULT_BYTE_ANY_REQUIRED_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyMinbytesEva()).isEqualTo(DEFAULT_BYTE_ANY_MINBYTES_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyMinbytesEvaContentType())
            .isEqualTo(DEFAULT_BYTE_ANY_MINBYTES_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyMaxbytesEva()).isEqualTo(DEFAULT_BYTE_ANY_MAXBYTES_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyMaxbytesEvaContentType())
            .isEqualTo(DEFAULT_BYTE_ANY_MAXBYTES_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteTextEva()).isEqualTo(DEFAULT_BYTE_TEXT_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteTextRequiredEva()).isEqualTo(DEFAULT_BYTE_TEXT_REQUIRED_EVA);
    }

    @Test
    void createFieldTestMapstructAndServiceClassEntityWithExistingId() throws Exception {
        // Create the FieldTestMapstructAndServiceClassEntity with an existing ID
        fieldTestMapstructAndServiceClassEntity.setId(1L);
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            fieldTestMapstructAndServiceClassEntity
        );

        int databaseSizeBeforeCreate = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestMapstructAndServiceClassEntity in the database
        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void checkStringRequiredEvaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestMapstructAndServiceClassEntity.setStringRequiredEva(null);

        // Create the FieldTestMapstructAndServiceClassEntity, which fails.
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            fieldTestMapstructAndServiceClassEntity
        );

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkIntegerRequiredEvaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestMapstructAndServiceClassEntity.setIntegerRequiredEva(null);

        // Create the FieldTestMapstructAndServiceClassEntity, which fails.
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            fieldTestMapstructAndServiceClassEntity
        );

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkLongRequiredEvaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestMapstructAndServiceClassEntity.setLongRequiredEva(null);

        // Create the FieldTestMapstructAndServiceClassEntity, which fails.
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            fieldTestMapstructAndServiceClassEntity
        );

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkFloatRequiredEvaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestMapstructAndServiceClassEntity.setFloatRequiredEva(null);

        // Create the FieldTestMapstructAndServiceClassEntity, which fails.
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            fieldTestMapstructAndServiceClassEntity
        );

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkDoubleRequiredEvaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestMapstructAndServiceClassEntity.setDoubleRequiredEva(null);

        // Create the FieldTestMapstructAndServiceClassEntity, which fails.
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            fieldTestMapstructAndServiceClassEntity
        );

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkBigDecimalRequiredEvaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestMapstructAndServiceClassEntity.setBigDecimalRequiredEva(null);

        // Create the FieldTestMapstructAndServiceClassEntity, which fails.
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            fieldTestMapstructAndServiceClassEntity
        );

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkLocalDateRequiredEvaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestMapstructAndServiceClassEntity.setLocalDateRequiredEva(null);

        // Create the FieldTestMapstructAndServiceClassEntity, which fails.
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            fieldTestMapstructAndServiceClassEntity
        );

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkInstanteRequiredEvaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestMapstructAndServiceClassEntity.setInstanteRequiredEva(null);

        // Create the FieldTestMapstructAndServiceClassEntity, which fails.
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            fieldTestMapstructAndServiceClassEntity
        );

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkZonedDateTimeRequiredEvaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestMapstructAndServiceClassEntity.setZonedDateTimeRequiredEva(null);

        // Create the FieldTestMapstructAndServiceClassEntity, which fails.
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            fieldTestMapstructAndServiceClassEntity
        );

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkDurationRequiredEvaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestMapstructAndServiceClassEntity.setDurationRequiredEva(null);

        // Create the FieldTestMapstructAndServiceClassEntity, which fails.
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            fieldTestMapstructAndServiceClassEntity
        );

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkBooleanRequiredEvaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestMapstructAndServiceClassEntity.setBooleanRequiredEva(null);

        // Create the FieldTestMapstructAndServiceClassEntity, which fails.
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            fieldTestMapstructAndServiceClassEntity
        );

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkEnumRequiredEvaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestMapstructAndServiceClassEntity.setEnumRequiredEva(null);

        // Create the FieldTestMapstructAndServiceClassEntity, which fails.
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            fieldTestMapstructAndServiceClassEntity
        );

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkUuidRequiredEvaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestMapstructAndServiceClassEntity.setUuidRequiredEva(null);

        // Create the FieldTestMapstructAndServiceClassEntity, which fails.
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            fieldTestMapstructAndServiceClassEntity
        );

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void getAllFieldTestMapstructAndServiceClassEntitiesAsStream() {
        // Initialize the database
        fieldTestMapstructAndServiceClassEntityRepository.save(fieldTestMapstructAndServiceClassEntity).block();

        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = webTestClient
            .get()
            .uri(ENTITY_API_URL)
            .accept(MediaType.APPLICATION_NDJSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentTypeCompatibleWith(MediaType.APPLICATION_NDJSON)
            .returnResult(FieldTestMapstructAndServiceClassEntityDTO.class)
            .getResponseBody()
            .map(fieldTestMapstructAndServiceClassEntityMapper::toEntity)
            .filter(fieldTestMapstructAndServiceClassEntity::equals)
            .collectList()
            .block(Duration.ofSeconds(5));

        assertThat(fieldTestMapstructAndServiceClassEntityList).isNotNull();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(1);
        FieldTestMapstructAndServiceClassEntity testFieldTestMapstructAndServiceClassEntity = fieldTestMapstructAndServiceClassEntityList.get(
            0
        );
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringEva()).isEqualTo(DEFAULT_STRING_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringRequiredEva()).isEqualTo(DEFAULT_STRING_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringMinlengthEva()).isEqualTo(DEFAULT_STRING_MINLENGTH_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringMaxlengthEva()).isEqualTo(DEFAULT_STRING_MAXLENGTH_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringPatternEva()).isEqualTo(DEFAULT_STRING_PATTERN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getIntegerEva()).isEqualTo(DEFAULT_INTEGER_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getIntegerRequiredEva()).isEqualTo(DEFAULT_INTEGER_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getIntegerMinEva()).isEqualTo(DEFAULT_INTEGER_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getIntegerMaxEva()).isEqualTo(DEFAULT_INTEGER_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLongEva()).isEqualTo(DEFAULT_LONG_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLongRequiredEva()).isEqualTo(DEFAULT_LONG_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLongMinEva()).isEqualTo(DEFAULT_LONG_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLongMaxEva()).isEqualTo(DEFAULT_LONG_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getFloatEva()).isEqualTo(DEFAULT_FLOAT_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getFloatRequiredEva()).isEqualTo(DEFAULT_FLOAT_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getFloatMinEva()).isEqualTo(DEFAULT_FLOAT_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getFloatMaxEva()).isEqualTo(DEFAULT_FLOAT_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDoubleRequiredEva()).isEqualTo(DEFAULT_DOUBLE_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDoubleMinEva()).isEqualTo(DEFAULT_DOUBLE_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDoubleMaxEva()).isEqualTo(DEFAULT_DOUBLE_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBigDecimalRequiredEva())
            .isEqualByComparingTo(DEFAULT_BIG_DECIMAL_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBigDecimalMinEva()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBigDecimalMaxEva()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLocalDateEva()).isEqualTo(DEFAULT_LOCAL_DATE_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLocalDateRequiredEva()).isEqualTo(DEFAULT_LOCAL_DATE_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getInstantEva()).isEqualTo(DEFAULT_INSTANT_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getInstanteRequiredEva()).isEqualTo(DEFAULT_INSTANTE_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getZonedDateTimeEva()).isEqualTo(DEFAULT_ZONED_DATE_TIME_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getZonedDateTimeRequiredEva())
            .isEqualTo(DEFAULT_ZONED_DATE_TIME_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDurationEva()).isEqualTo(DEFAULT_DURATION_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDurationRequiredEva()).isEqualTo(DEFAULT_DURATION_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBooleanEva()).isEqualTo(DEFAULT_BOOLEAN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBooleanRequiredEva()).isEqualTo(DEFAULT_BOOLEAN_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getEnumEva()).isEqualTo(DEFAULT_ENUM_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getEnumRequiredEva()).isEqualTo(DEFAULT_ENUM_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getUuidEva()).isEqualTo(DEFAULT_UUID_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getUuidRequiredEva()).isEqualTo(DEFAULT_UUID_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageEva()).isEqualTo(DEFAULT_BYTE_IMAGE_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageEvaContentType()).isEqualTo(DEFAULT_BYTE_IMAGE_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageRequiredEva()).isEqualTo(DEFAULT_BYTE_IMAGE_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageRequiredEvaContentType())
            .isEqualTo(DEFAULT_BYTE_IMAGE_REQUIRED_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageMinbytesEva()).isEqualTo(DEFAULT_BYTE_IMAGE_MINBYTES_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageMinbytesEvaContentType())
            .isEqualTo(DEFAULT_BYTE_IMAGE_MINBYTES_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageMaxbytesEva()).isEqualTo(DEFAULT_BYTE_IMAGE_MAXBYTES_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageMaxbytesEvaContentType())
            .isEqualTo(DEFAULT_BYTE_IMAGE_MAXBYTES_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyEva()).isEqualTo(DEFAULT_BYTE_ANY_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyEvaContentType()).isEqualTo(DEFAULT_BYTE_ANY_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyRequiredEva()).isEqualTo(DEFAULT_BYTE_ANY_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyRequiredEvaContentType())
            .isEqualTo(DEFAULT_BYTE_ANY_REQUIRED_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyMinbytesEva()).isEqualTo(DEFAULT_BYTE_ANY_MINBYTES_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyMinbytesEvaContentType())
            .isEqualTo(DEFAULT_BYTE_ANY_MINBYTES_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyMaxbytesEva()).isEqualTo(DEFAULT_BYTE_ANY_MAXBYTES_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyMaxbytesEvaContentType())
            .isEqualTo(DEFAULT_BYTE_ANY_MAXBYTES_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteTextEva()).isEqualTo(DEFAULT_BYTE_TEXT_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteTextRequiredEva()).isEqualTo(DEFAULT_BYTE_TEXT_REQUIRED_EVA);
    }

    @Test
    void getAllFieldTestMapstructAndServiceClassEntities() {
        // Initialize the database
        fieldTestMapstructAndServiceClassEntityRepository.save(fieldTestMapstructAndServiceClassEntity).block();

        // Get all the fieldTestMapstructAndServiceClassEntityList
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
            .value(hasItem(fieldTestMapstructAndServiceClassEntity.getId().intValue()))
            .jsonPath("$.[*].stringEva")
            .value(hasItem(DEFAULT_STRING_EVA))
            .jsonPath("$.[*].stringRequiredEva")
            .value(hasItem(DEFAULT_STRING_REQUIRED_EVA))
            .jsonPath("$.[*].stringMinlengthEva")
            .value(hasItem(DEFAULT_STRING_MINLENGTH_EVA))
            .jsonPath("$.[*].stringMaxlengthEva")
            .value(hasItem(DEFAULT_STRING_MAXLENGTH_EVA))
            .jsonPath("$.[*].stringPatternEva")
            .value(hasItem(DEFAULT_STRING_PATTERN_EVA))
            .jsonPath("$.[*].integerEva")
            .value(hasItem(DEFAULT_INTEGER_EVA))
            .jsonPath("$.[*].integerRequiredEva")
            .value(hasItem(DEFAULT_INTEGER_REQUIRED_EVA))
            .jsonPath("$.[*].integerMinEva")
            .value(hasItem(DEFAULT_INTEGER_MIN_EVA))
            .jsonPath("$.[*].integerMaxEva")
            .value(hasItem(DEFAULT_INTEGER_MAX_EVA))
            .jsonPath("$.[*].longEva")
            .value(hasItem(DEFAULT_LONG_EVA.intValue()))
            .jsonPath("$.[*].longRequiredEva")
            .value(hasItem(DEFAULT_LONG_REQUIRED_EVA.intValue()))
            .jsonPath("$.[*].longMinEva")
            .value(hasItem(DEFAULT_LONG_MIN_EVA.intValue()))
            .jsonPath("$.[*].longMaxEva")
            .value(hasItem(DEFAULT_LONG_MAX_EVA.intValue()))
            .jsonPath("$.[*].floatEva")
            .value(hasItem(DEFAULT_FLOAT_EVA.doubleValue()))
            .jsonPath("$.[*].floatRequiredEva")
            .value(hasItem(DEFAULT_FLOAT_REQUIRED_EVA.doubleValue()))
            .jsonPath("$.[*].floatMinEva")
            .value(hasItem(DEFAULT_FLOAT_MIN_EVA.doubleValue()))
            .jsonPath("$.[*].floatMaxEva")
            .value(hasItem(DEFAULT_FLOAT_MAX_EVA.doubleValue()))
            .jsonPath("$.[*].doubleRequiredEva")
            .value(hasItem(DEFAULT_DOUBLE_REQUIRED_EVA.doubleValue()))
            .jsonPath("$.[*].doubleMinEva")
            .value(hasItem(DEFAULT_DOUBLE_MIN_EVA.doubleValue()))
            .jsonPath("$.[*].doubleMaxEva")
            .value(hasItem(DEFAULT_DOUBLE_MAX_EVA.doubleValue()))
            .jsonPath("$.[*].bigDecimalRequiredEva")
            .value(hasItem(sameNumber(DEFAULT_BIG_DECIMAL_REQUIRED_EVA)))
            .jsonPath("$.[*].bigDecimalMinEva")
            .value(hasItem(sameNumber(DEFAULT_BIG_DECIMAL_MIN_EVA)))
            .jsonPath("$.[*].bigDecimalMaxEva")
            .value(hasItem(sameNumber(DEFAULT_BIG_DECIMAL_MAX_EVA)))
            .jsonPath("$.[*].localDateEva")
            .value(hasItem(DEFAULT_LOCAL_DATE_EVA.toString()))
            .jsonPath("$.[*].localDateRequiredEva")
            .value(hasItem(DEFAULT_LOCAL_DATE_REQUIRED_EVA.toString()))
            .jsonPath("$.[*].instantEva")
            .value(hasItem(DEFAULT_INSTANT_EVA.toString()))
            .jsonPath("$.[*].instanteRequiredEva")
            .value(hasItem(DEFAULT_INSTANTE_REQUIRED_EVA.toString()))
            .jsonPath("$.[*].zonedDateTimeEva")
            .value(hasItem(sameInstant(DEFAULT_ZONED_DATE_TIME_EVA)))
            .jsonPath("$.[*].zonedDateTimeRequiredEva")
            .value(hasItem(sameInstant(DEFAULT_ZONED_DATE_TIME_REQUIRED_EVA)))
            .jsonPath("$.[*].durationEva")
            .value(hasItem(DEFAULT_DURATION_EVA.toString()))
            .jsonPath("$.[*].durationRequiredEva")
            .value(hasItem(DEFAULT_DURATION_REQUIRED_EVA.toString()))
            .jsonPath("$.[*].booleanEva")
            .value(hasItem(DEFAULT_BOOLEAN_EVA.booleanValue()))
            .jsonPath("$.[*].booleanRequiredEva")
            .value(hasItem(DEFAULT_BOOLEAN_REQUIRED_EVA.booleanValue()))
            .jsonPath("$.[*].enumEva")
            .value(hasItem(DEFAULT_ENUM_EVA.toString()))
            .jsonPath("$.[*].enumRequiredEva")
            .value(hasItem(DEFAULT_ENUM_REQUIRED_EVA.toString()))
            .jsonPath("$.[*].uuidEva")
            .value(hasItem(DEFAULT_UUID_EVA.toString()))
            .jsonPath("$.[*].uuidRequiredEva")
            .value(hasItem(DEFAULT_UUID_REQUIRED_EVA.toString()))
            .jsonPath("$.[*].byteImageEvaContentType")
            .value(hasItem(DEFAULT_BYTE_IMAGE_EVA_CONTENT_TYPE))
            .jsonPath("$.[*].byteImageEva")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_EVA)))
            .jsonPath("$.[*].byteImageRequiredEvaContentType")
            .value(hasItem(DEFAULT_BYTE_IMAGE_REQUIRED_EVA_CONTENT_TYPE))
            .jsonPath("$.[*].byteImageRequiredEva")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_REQUIRED_EVA)))
            .jsonPath("$.[*].byteImageMinbytesEvaContentType")
            .value(hasItem(DEFAULT_BYTE_IMAGE_MINBYTES_EVA_CONTENT_TYPE))
            .jsonPath("$.[*].byteImageMinbytesEva")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_MINBYTES_EVA)))
            .jsonPath("$.[*].byteImageMaxbytesEvaContentType")
            .value(hasItem(DEFAULT_BYTE_IMAGE_MAXBYTES_EVA_CONTENT_TYPE))
            .jsonPath("$.[*].byteImageMaxbytesEva")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_MAXBYTES_EVA)))
            .jsonPath("$.[*].byteAnyEvaContentType")
            .value(hasItem(DEFAULT_BYTE_ANY_EVA_CONTENT_TYPE))
            .jsonPath("$.[*].byteAnyEva")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_EVA)))
            .jsonPath("$.[*].byteAnyRequiredEvaContentType")
            .value(hasItem(DEFAULT_BYTE_ANY_REQUIRED_EVA_CONTENT_TYPE))
            .jsonPath("$.[*].byteAnyRequiredEva")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_REQUIRED_EVA)))
            .jsonPath("$.[*].byteAnyMinbytesEvaContentType")
            .value(hasItem(DEFAULT_BYTE_ANY_MINBYTES_EVA_CONTENT_TYPE))
            .jsonPath("$.[*].byteAnyMinbytesEva")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_MINBYTES_EVA)))
            .jsonPath("$.[*].byteAnyMaxbytesEvaContentType")
            .value(hasItem(DEFAULT_BYTE_ANY_MAXBYTES_EVA_CONTENT_TYPE))
            .jsonPath("$.[*].byteAnyMaxbytesEva")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_MAXBYTES_EVA)))
            .jsonPath("$.[*].byteTextEva")
            .value(hasItem(DEFAULT_BYTE_TEXT_EVA.toString()))
            .jsonPath("$.[*].byteTextRequiredEva")
            .value(hasItem(DEFAULT_BYTE_TEXT_REQUIRED_EVA.toString()));
    }

    @Test
    void getFieldTestMapstructAndServiceClassEntity() {
        // Initialize the database
        fieldTestMapstructAndServiceClassEntityRepository.save(fieldTestMapstructAndServiceClassEntity).block();

        // Get the fieldTestMapstructAndServiceClassEntity
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, fieldTestMapstructAndServiceClassEntity.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id")
            .value(is(fieldTestMapstructAndServiceClassEntity.getId().intValue()))
            .jsonPath("$.stringEva")
            .value(is(DEFAULT_STRING_EVA))
            .jsonPath("$.stringRequiredEva")
            .value(is(DEFAULT_STRING_REQUIRED_EVA))
            .jsonPath("$.stringMinlengthEva")
            .value(is(DEFAULT_STRING_MINLENGTH_EVA))
            .jsonPath("$.stringMaxlengthEva")
            .value(is(DEFAULT_STRING_MAXLENGTH_EVA))
            .jsonPath("$.stringPatternEva")
            .value(is(DEFAULT_STRING_PATTERN_EVA))
            .jsonPath("$.integerEva")
            .value(is(DEFAULT_INTEGER_EVA))
            .jsonPath("$.integerRequiredEva")
            .value(is(DEFAULT_INTEGER_REQUIRED_EVA))
            .jsonPath("$.integerMinEva")
            .value(is(DEFAULT_INTEGER_MIN_EVA))
            .jsonPath("$.integerMaxEva")
            .value(is(DEFAULT_INTEGER_MAX_EVA))
            .jsonPath("$.longEva")
            .value(is(DEFAULT_LONG_EVA.intValue()))
            .jsonPath("$.longRequiredEva")
            .value(is(DEFAULT_LONG_REQUIRED_EVA.intValue()))
            .jsonPath("$.longMinEva")
            .value(is(DEFAULT_LONG_MIN_EVA.intValue()))
            .jsonPath("$.longMaxEva")
            .value(is(DEFAULT_LONG_MAX_EVA.intValue()))
            .jsonPath("$.floatEva")
            .value(is(DEFAULT_FLOAT_EVA.doubleValue()))
            .jsonPath("$.floatRequiredEva")
            .value(is(DEFAULT_FLOAT_REQUIRED_EVA.doubleValue()))
            .jsonPath("$.floatMinEva")
            .value(is(DEFAULT_FLOAT_MIN_EVA.doubleValue()))
            .jsonPath("$.floatMaxEva")
            .value(is(DEFAULT_FLOAT_MAX_EVA.doubleValue()))
            .jsonPath("$.doubleRequiredEva")
            .value(is(DEFAULT_DOUBLE_REQUIRED_EVA.doubleValue()))
            .jsonPath("$.doubleMinEva")
            .value(is(DEFAULT_DOUBLE_MIN_EVA.doubleValue()))
            .jsonPath("$.doubleMaxEva")
            .value(is(DEFAULT_DOUBLE_MAX_EVA.doubleValue()))
            .jsonPath("$.bigDecimalRequiredEva")
            .value(is(sameNumber(DEFAULT_BIG_DECIMAL_REQUIRED_EVA)))
            .jsonPath("$.bigDecimalMinEva")
            .value(is(sameNumber(DEFAULT_BIG_DECIMAL_MIN_EVA)))
            .jsonPath("$.bigDecimalMaxEva")
            .value(is(sameNumber(DEFAULT_BIG_DECIMAL_MAX_EVA)))
            .jsonPath("$.localDateEva")
            .value(is(DEFAULT_LOCAL_DATE_EVA.toString()))
            .jsonPath("$.localDateRequiredEva")
            .value(is(DEFAULT_LOCAL_DATE_REQUIRED_EVA.toString()))
            .jsonPath("$.instantEva")
            .value(is(DEFAULT_INSTANT_EVA.toString()))
            .jsonPath("$.instanteRequiredEva")
            .value(is(DEFAULT_INSTANTE_REQUIRED_EVA.toString()))
            .jsonPath("$.zonedDateTimeEva")
            .value(is(sameInstant(DEFAULT_ZONED_DATE_TIME_EVA)))
            .jsonPath("$.zonedDateTimeRequiredEva")
            .value(is(sameInstant(DEFAULT_ZONED_DATE_TIME_REQUIRED_EVA)))
            .jsonPath("$.durationEva")
            .value(is(DEFAULT_DURATION_EVA.toString()))
            .jsonPath("$.durationRequiredEva")
            .value(is(DEFAULT_DURATION_REQUIRED_EVA.toString()))
            .jsonPath("$.booleanEva")
            .value(is(DEFAULT_BOOLEAN_EVA.booleanValue()))
            .jsonPath("$.booleanRequiredEva")
            .value(is(DEFAULT_BOOLEAN_REQUIRED_EVA.booleanValue()))
            .jsonPath("$.enumEva")
            .value(is(DEFAULT_ENUM_EVA.toString()))
            .jsonPath("$.enumRequiredEva")
            .value(is(DEFAULT_ENUM_REQUIRED_EVA.toString()))
            .jsonPath("$.uuidEva")
            .value(is(DEFAULT_UUID_EVA.toString()))
            .jsonPath("$.uuidRequiredEva")
            .value(is(DEFAULT_UUID_REQUIRED_EVA.toString()))
            .jsonPath("$.byteImageEvaContentType")
            .value(is(DEFAULT_BYTE_IMAGE_EVA_CONTENT_TYPE))
            .jsonPath("$.byteImageEva")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_EVA)))
            .jsonPath("$.byteImageRequiredEvaContentType")
            .value(is(DEFAULT_BYTE_IMAGE_REQUIRED_EVA_CONTENT_TYPE))
            .jsonPath("$.byteImageRequiredEva")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_REQUIRED_EVA)))
            .jsonPath("$.byteImageMinbytesEvaContentType")
            .value(is(DEFAULT_BYTE_IMAGE_MINBYTES_EVA_CONTENT_TYPE))
            .jsonPath("$.byteImageMinbytesEva")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_MINBYTES_EVA)))
            .jsonPath("$.byteImageMaxbytesEvaContentType")
            .value(is(DEFAULT_BYTE_IMAGE_MAXBYTES_EVA_CONTENT_TYPE))
            .jsonPath("$.byteImageMaxbytesEva")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_MAXBYTES_EVA)))
            .jsonPath("$.byteAnyEvaContentType")
            .value(is(DEFAULT_BYTE_ANY_EVA_CONTENT_TYPE))
            .jsonPath("$.byteAnyEva")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_EVA)))
            .jsonPath("$.byteAnyRequiredEvaContentType")
            .value(is(DEFAULT_BYTE_ANY_REQUIRED_EVA_CONTENT_TYPE))
            .jsonPath("$.byteAnyRequiredEva")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_REQUIRED_EVA)))
            .jsonPath("$.byteAnyMinbytesEvaContentType")
            .value(is(DEFAULT_BYTE_ANY_MINBYTES_EVA_CONTENT_TYPE))
            .jsonPath("$.byteAnyMinbytesEva")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_MINBYTES_EVA)))
            .jsonPath("$.byteAnyMaxbytesEvaContentType")
            .value(is(DEFAULT_BYTE_ANY_MAXBYTES_EVA_CONTENT_TYPE))
            .jsonPath("$.byteAnyMaxbytesEva")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_MAXBYTES_EVA)))
            .jsonPath("$.byteTextEva")
            .value(is(DEFAULT_BYTE_TEXT_EVA.toString()))
            .jsonPath("$.byteTextRequiredEva")
            .value(is(DEFAULT_BYTE_TEXT_REQUIRED_EVA.toString()));
    }

    @Test
    void getNonExistingFieldTestMapstructAndServiceClassEntity() {
        // Get the fieldTestMapstructAndServiceClassEntity
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putNewFieldTestMapstructAndServiceClassEntity() throws Exception {
        // Initialize the database
        fieldTestMapstructAndServiceClassEntityRepository.save(fieldTestMapstructAndServiceClassEntity).block();

        int databaseSizeBeforeUpdate = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();

        // Update the fieldTestMapstructAndServiceClassEntity
        FieldTestMapstructAndServiceClassEntity updatedFieldTestMapstructAndServiceClassEntity = fieldTestMapstructAndServiceClassEntityRepository
            .findById(fieldTestMapstructAndServiceClassEntity.getId())
            .block();
        updatedFieldTestMapstructAndServiceClassEntity
            .stringEva(UPDATED_STRING_EVA)
            .stringRequiredEva(UPDATED_STRING_REQUIRED_EVA)
            .stringMinlengthEva(UPDATED_STRING_MINLENGTH_EVA)
            .stringMaxlengthEva(UPDATED_STRING_MAXLENGTH_EVA)
            .stringPatternEva(UPDATED_STRING_PATTERN_EVA)
            .integerEva(UPDATED_INTEGER_EVA)
            .integerRequiredEva(UPDATED_INTEGER_REQUIRED_EVA)
            .integerMinEva(UPDATED_INTEGER_MIN_EVA)
            .integerMaxEva(UPDATED_INTEGER_MAX_EVA)
            .longEva(UPDATED_LONG_EVA)
            .longRequiredEva(UPDATED_LONG_REQUIRED_EVA)
            .longMinEva(UPDATED_LONG_MIN_EVA)
            .longMaxEva(UPDATED_LONG_MAX_EVA)
            .floatEva(UPDATED_FLOAT_EVA)
            .floatRequiredEva(UPDATED_FLOAT_REQUIRED_EVA)
            .floatMinEva(UPDATED_FLOAT_MIN_EVA)
            .floatMaxEva(UPDATED_FLOAT_MAX_EVA)
            .doubleRequiredEva(UPDATED_DOUBLE_REQUIRED_EVA)
            .doubleMinEva(UPDATED_DOUBLE_MIN_EVA)
            .doubleMaxEva(UPDATED_DOUBLE_MAX_EVA)
            .bigDecimalRequiredEva(UPDATED_BIG_DECIMAL_REQUIRED_EVA)
            .bigDecimalMinEva(UPDATED_BIG_DECIMAL_MIN_EVA)
            .bigDecimalMaxEva(UPDATED_BIG_DECIMAL_MAX_EVA)
            .localDateEva(UPDATED_LOCAL_DATE_EVA)
            .localDateRequiredEva(UPDATED_LOCAL_DATE_REQUIRED_EVA)
            .instantEva(UPDATED_INSTANT_EVA)
            .instanteRequiredEva(UPDATED_INSTANTE_REQUIRED_EVA)
            .zonedDateTimeEva(UPDATED_ZONED_DATE_TIME_EVA)
            .zonedDateTimeRequiredEva(UPDATED_ZONED_DATE_TIME_REQUIRED_EVA)
            .durationEva(UPDATED_DURATION_EVA)
            .durationRequiredEva(UPDATED_DURATION_REQUIRED_EVA)
            .booleanEva(UPDATED_BOOLEAN_EVA)
            .booleanRequiredEva(UPDATED_BOOLEAN_REQUIRED_EVA)
            .enumEva(UPDATED_ENUM_EVA)
            .enumRequiredEva(UPDATED_ENUM_REQUIRED_EVA)
            .uuidEva(UPDATED_UUID_EVA)
            .uuidRequiredEva(UPDATED_UUID_REQUIRED_EVA)
            .byteImageEva(UPDATED_BYTE_IMAGE_EVA)
            .byteImageEvaContentType(UPDATED_BYTE_IMAGE_EVA_CONTENT_TYPE)
            .byteImageRequiredEva(UPDATED_BYTE_IMAGE_REQUIRED_EVA)
            .byteImageRequiredEvaContentType(UPDATED_BYTE_IMAGE_REQUIRED_EVA_CONTENT_TYPE)
            .byteImageMinbytesEva(UPDATED_BYTE_IMAGE_MINBYTES_EVA)
            .byteImageMinbytesEvaContentType(UPDATED_BYTE_IMAGE_MINBYTES_EVA_CONTENT_TYPE)
            .byteImageMaxbytesEva(UPDATED_BYTE_IMAGE_MAXBYTES_EVA)
            .byteImageMaxbytesEvaContentType(UPDATED_BYTE_IMAGE_MAXBYTES_EVA_CONTENT_TYPE)
            .byteAnyEva(UPDATED_BYTE_ANY_EVA)
            .byteAnyEvaContentType(UPDATED_BYTE_ANY_EVA_CONTENT_TYPE)
            .byteAnyRequiredEva(UPDATED_BYTE_ANY_REQUIRED_EVA)
            .byteAnyRequiredEvaContentType(UPDATED_BYTE_ANY_REQUIRED_EVA_CONTENT_TYPE)
            .byteAnyMinbytesEva(UPDATED_BYTE_ANY_MINBYTES_EVA)
            .byteAnyMinbytesEvaContentType(UPDATED_BYTE_ANY_MINBYTES_EVA_CONTENT_TYPE)
            .byteAnyMaxbytesEva(UPDATED_BYTE_ANY_MAXBYTES_EVA)
            .byteAnyMaxbytesEvaContentType(UPDATED_BYTE_ANY_MAXBYTES_EVA_CONTENT_TYPE)
            .byteTextEva(UPDATED_BYTE_TEXT_EVA)
            .byteTextRequiredEva(UPDATED_BYTE_TEXT_REQUIRED_EVA);
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            updatedFieldTestMapstructAndServiceClassEntity
        );

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, fieldTestMapstructAndServiceClassEntityDTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the FieldTestMapstructAndServiceClassEntity in the database
        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeUpdate);
        FieldTestMapstructAndServiceClassEntity testFieldTestMapstructAndServiceClassEntity = fieldTestMapstructAndServiceClassEntityList.get(
            fieldTestMapstructAndServiceClassEntityList.size() - 1
        );
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringEva()).isEqualTo(UPDATED_STRING_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringRequiredEva()).isEqualTo(UPDATED_STRING_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringMinlengthEva()).isEqualTo(UPDATED_STRING_MINLENGTH_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringMaxlengthEva()).isEqualTo(UPDATED_STRING_MAXLENGTH_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringPatternEva()).isEqualTo(UPDATED_STRING_PATTERN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getIntegerEva()).isEqualTo(UPDATED_INTEGER_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getIntegerRequiredEva()).isEqualTo(UPDATED_INTEGER_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getIntegerMinEva()).isEqualTo(UPDATED_INTEGER_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getIntegerMaxEva()).isEqualTo(UPDATED_INTEGER_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLongEva()).isEqualTo(UPDATED_LONG_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLongRequiredEva()).isEqualTo(UPDATED_LONG_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLongMinEva()).isEqualTo(UPDATED_LONG_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLongMaxEva()).isEqualTo(UPDATED_LONG_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getFloatEva()).isEqualTo(UPDATED_FLOAT_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getFloatRequiredEva()).isEqualTo(UPDATED_FLOAT_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getFloatMinEva()).isEqualTo(UPDATED_FLOAT_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getFloatMaxEva()).isEqualTo(UPDATED_FLOAT_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDoubleRequiredEva()).isEqualTo(UPDATED_DOUBLE_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDoubleMinEva()).isEqualTo(UPDATED_DOUBLE_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDoubleMaxEva()).isEqualTo(UPDATED_DOUBLE_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBigDecimalRequiredEva()).isEqualTo(UPDATED_BIG_DECIMAL_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBigDecimalMinEva()).isEqualTo(UPDATED_BIG_DECIMAL_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBigDecimalMaxEva()).isEqualTo(UPDATED_BIG_DECIMAL_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLocalDateEva()).isEqualTo(UPDATED_LOCAL_DATE_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLocalDateRequiredEva()).isEqualTo(UPDATED_LOCAL_DATE_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getInstantEva()).isEqualTo(UPDATED_INSTANT_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getInstanteRequiredEva()).isEqualTo(UPDATED_INSTANTE_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getZonedDateTimeEva()).isEqualTo(UPDATED_ZONED_DATE_TIME_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getZonedDateTimeRequiredEva())
            .isEqualTo(UPDATED_ZONED_DATE_TIME_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDurationEva()).isEqualTo(UPDATED_DURATION_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDurationRequiredEva()).isEqualTo(UPDATED_DURATION_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBooleanEva()).isEqualTo(UPDATED_BOOLEAN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBooleanRequiredEva()).isEqualTo(UPDATED_BOOLEAN_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getEnumEva()).isEqualTo(UPDATED_ENUM_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getEnumRequiredEva()).isEqualTo(UPDATED_ENUM_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getUuidEva()).isEqualTo(UPDATED_UUID_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getUuidRequiredEva()).isEqualTo(UPDATED_UUID_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageEva()).isEqualTo(UPDATED_BYTE_IMAGE_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageEvaContentType()).isEqualTo(UPDATED_BYTE_IMAGE_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageRequiredEva()).isEqualTo(UPDATED_BYTE_IMAGE_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageRequiredEvaContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_REQUIRED_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageMinbytesEva()).isEqualTo(UPDATED_BYTE_IMAGE_MINBYTES_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageMinbytesEvaContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_MINBYTES_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageMaxbytesEva()).isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageMaxbytesEvaContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyEva()).isEqualTo(UPDATED_BYTE_ANY_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyEvaContentType()).isEqualTo(UPDATED_BYTE_ANY_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyRequiredEva()).isEqualTo(UPDATED_BYTE_ANY_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyRequiredEvaContentType())
            .isEqualTo(UPDATED_BYTE_ANY_REQUIRED_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyMinbytesEva()).isEqualTo(UPDATED_BYTE_ANY_MINBYTES_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyMinbytesEvaContentType())
            .isEqualTo(UPDATED_BYTE_ANY_MINBYTES_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyMaxbytesEva()).isEqualTo(UPDATED_BYTE_ANY_MAXBYTES_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyMaxbytesEvaContentType())
            .isEqualTo(UPDATED_BYTE_ANY_MAXBYTES_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteTextEva()).isEqualTo(UPDATED_BYTE_TEXT_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteTextRequiredEva()).isEqualTo(UPDATED_BYTE_TEXT_REQUIRED_EVA);
    }

    @Test
    void putNonExistingFieldTestMapstructAndServiceClassEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();
        fieldTestMapstructAndServiceClassEntity.setId(count.incrementAndGet());

        // Create the FieldTestMapstructAndServiceClassEntity
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            fieldTestMapstructAndServiceClassEntity
        );

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, fieldTestMapstructAndServiceClassEntityDTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestMapstructAndServiceClassEntity in the database
        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchFieldTestMapstructAndServiceClassEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();
        fieldTestMapstructAndServiceClassEntity.setId(count.incrementAndGet());

        // Create the FieldTestMapstructAndServiceClassEntity
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            fieldTestMapstructAndServiceClassEntity
        );

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestMapstructAndServiceClassEntity in the database
        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamFieldTestMapstructAndServiceClassEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();
        fieldTestMapstructAndServiceClassEntity.setId(count.incrementAndGet());

        // Create the FieldTestMapstructAndServiceClassEntity
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            fieldTestMapstructAndServiceClassEntity
        );

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the FieldTestMapstructAndServiceClassEntity in the database
        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateFieldTestMapstructAndServiceClassEntityWithPatch() throws Exception {
        // Initialize the database
        fieldTestMapstructAndServiceClassEntityRepository.save(fieldTestMapstructAndServiceClassEntity).block();

        int databaseSizeBeforeUpdate = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();

        // Update the fieldTestMapstructAndServiceClassEntity using partial update
        FieldTestMapstructAndServiceClassEntity partialUpdatedFieldTestMapstructAndServiceClassEntity = new FieldTestMapstructAndServiceClassEntity();
        partialUpdatedFieldTestMapstructAndServiceClassEntity.setId(fieldTestMapstructAndServiceClassEntity.getId());

        partialUpdatedFieldTestMapstructAndServiceClassEntity
            .stringMinlengthEva(UPDATED_STRING_MINLENGTH_EVA)
            .stringMaxlengthEva(UPDATED_STRING_MAXLENGTH_EVA)
            .stringPatternEva(UPDATED_STRING_PATTERN_EVA)
            .integerEva(UPDATED_INTEGER_EVA)
            .integerMinEva(UPDATED_INTEGER_MIN_EVA)
            .longEva(UPDATED_LONG_EVA)
            .longRequiredEva(UPDATED_LONG_REQUIRED_EVA)
            .longMinEva(UPDATED_LONG_MIN_EVA)
            .longMaxEva(UPDATED_LONG_MAX_EVA)
            .floatMaxEva(UPDATED_FLOAT_MAX_EVA)
            .doubleMinEva(UPDATED_DOUBLE_MIN_EVA)
            .doubleMaxEva(UPDATED_DOUBLE_MAX_EVA)
            .bigDecimalRequiredEva(UPDATED_BIG_DECIMAL_REQUIRED_EVA)
            .bigDecimalMinEva(UPDATED_BIG_DECIMAL_MIN_EVA)
            .bigDecimalMaxEva(UPDATED_BIG_DECIMAL_MAX_EVA)
            .localDateRequiredEva(UPDATED_LOCAL_DATE_REQUIRED_EVA)
            .instantEva(UPDATED_INSTANT_EVA)
            .instanteRequiredEva(UPDATED_INSTANTE_REQUIRED_EVA)
            .zonedDateTimeEva(UPDATED_ZONED_DATE_TIME_EVA)
            .booleanRequiredEva(UPDATED_BOOLEAN_REQUIRED_EVA)
            .enumRequiredEva(UPDATED_ENUM_REQUIRED_EVA)
            .byteImageEva(UPDATED_BYTE_IMAGE_EVA)
            .byteImageEvaContentType(UPDATED_BYTE_IMAGE_EVA_CONTENT_TYPE)
            .byteImageRequiredEva(UPDATED_BYTE_IMAGE_REQUIRED_EVA)
            .byteImageRequiredEvaContentType(UPDATED_BYTE_IMAGE_REQUIRED_EVA_CONTENT_TYPE)
            .byteImageMaxbytesEva(UPDATED_BYTE_IMAGE_MAXBYTES_EVA)
            .byteImageMaxbytesEvaContentType(UPDATED_BYTE_IMAGE_MAXBYTES_EVA_CONTENT_TYPE)
            .byteAnyEva(UPDATED_BYTE_ANY_EVA)
            .byteAnyEvaContentType(UPDATED_BYTE_ANY_EVA_CONTENT_TYPE)
            .byteAnyMinbytesEva(UPDATED_BYTE_ANY_MINBYTES_EVA)
            .byteAnyMinbytesEvaContentType(UPDATED_BYTE_ANY_MINBYTES_EVA_CONTENT_TYPE)
            .byteTextEva(UPDATED_BYTE_TEXT_EVA)
            .byteTextRequiredEva(UPDATED_BYTE_TEXT_REQUIRED_EVA);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedFieldTestMapstructAndServiceClassEntity.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedFieldTestMapstructAndServiceClassEntity))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the FieldTestMapstructAndServiceClassEntity in the database
        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeUpdate);
        FieldTestMapstructAndServiceClassEntity testFieldTestMapstructAndServiceClassEntity = fieldTestMapstructAndServiceClassEntityList.get(
            fieldTestMapstructAndServiceClassEntityList.size() - 1
        );
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringEva()).isEqualTo(DEFAULT_STRING_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringRequiredEva()).isEqualTo(DEFAULT_STRING_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringMinlengthEva()).isEqualTo(UPDATED_STRING_MINLENGTH_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringMaxlengthEva()).isEqualTo(UPDATED_STRING_MAXLENGTH_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringPatternEva()).isEqualTo(UPDATED_STRING_PATTERN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getIntegerEva()).isEqualTo(UPDATED_INTEGER_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getIntegerRequiredEva()).isEqualTo(DEFAULT_INTEGER_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getIntegerMinEva()).isEqualTo(UPDATED_INTEGER_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getIntegerMaxEva()).isEqualTo(DEFAULT_INTEGER_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLongEva()).isEqualTo(UPDATED_LONG_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLongRequiredEva()).isEqualTo(UPDATED_LONG_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLongMinEva()).isEqualTo(UPDATED_LONG_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLongMaxEva()).isEqualTo(UPDATED_LONG_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getFloatEva()).isEqualTo(DEFAULT_FLOAT_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getFloatRequiredEva()).isEqualTo(DEFAULT_FLOAT_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getFloatMinEva()).isEqualTo(DEFAULT_FLOAT_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getFloatMaxEva()).isEqualTo(UPDATED_FLOAT_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDoubleRequiredEva()).isEqualTo(DEFAULT_DOUBLE_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDoubleMinEva()).isEqualTo(UPDATED_DOUBLE_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDoubleMaxEva()).isEqualTo(UPDATED_DOUBLE_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBigDecimalRequiredEva())
            .isEqualByComparingTo(UPDATED_BIG_DECIMAL_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBigDecimalMinEva()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBigDecimalMaxEva()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLocalDateEva()).isEqualTo(DEFAULT_LOCAL_DATE_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLocalDateRequiredEva()).isEqualTo(UPDATED_LOCAL_DATE_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getInstantEva()).isEqualTo(UPDATED_INSTANT_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getInstanteRequiredEva()).isEqualTo(UPDATED_INSTANTE_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getZonedDateTimeEva()).isEqualTo(UPDATED_ZONED_DATE_TIME_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getZonedDateTimeRequiredEva())
            .isEqualTo(DEFAULT_ZONED_DATE_TIME_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDurationEva()).isEqualTo(DEFAULT_DURATION_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDurationRequiredEva()).isEqualTo(DEFAULT_DURATION_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBooleanEva()).isEqualTo(DEFAULT_BOOLEAN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBooleanRequiredEva()).isEqualTo(UPDATED_BOOLEAN_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getEnumEva()).isEqualTo(DEFAULT_ENUM_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getEnumRequiredEva()).isEqualTo(UPDATED_ENUM_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getUuidEva()).isEqualTo(DEFAULT_UUID_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getUuidRequiredEva()).isEqualTo(DEFAULT_UUID_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageEva()).isEqualTo(UPDATED_BYTE_IMAGE_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageEvaContentType()).isEqualTo(UPDATED_BYTE_IMAGE_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageRequiredEva()).isEqualTo(UPDATED_BYTE_IMAGE_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageRequiredEvaContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_REQUIRED_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageMinbytesEva()).isEqualTo(DEFAULT_BYTE_IMAGE_MINBYTES_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageMinbytesEvaContentType())
            .isEqualTo(DEFAULT_BYTE_IMAGE_MINBYTES_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageMaxbytesEva()).isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageMaxbytesEvaContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyEva()).isEqualTo(UPDATED_BYTE_ANY_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyEvaContentType()).isEqualTo(UPDATED_BYTE_ANY_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyRequiredEva()).isEqualTo(DEFAULT_BYTE_ANY_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyRequiredEvaContentType())
            .isEqualTo(DEFAULT_BYTE_ANY_REQUIRED_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyMinbytesEva()).isEqualTo(UPDATED_BYTE_ANY_MINBYTES_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyMinbytesEvaContentType())
            .isEqualTo(UPDATED_BYTE_ANY_MINBYTES_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyMaxbytesEva()).isEqualTo(DEFAULT_BYTE_ANY_MAXBYTES_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyMaxbytesEvaContentType())
            .isEqualTo(DEFAULT_BYTE_ANY_MAXBYTES_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteTextEva()).isEqualTo(UPDATED_BYTE_TEXT_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteTextRequiredEva()).isEqualTo(UPDATED_BYTE_TEXT_REQUIRED_EVA);
    }

    @Test
    void fullUpdateFieldTestMapstructAndServiceClassEntityWithPatch() throws Exception {
        // Initialize the database
        fieldTestMapstructAndServiceClassEntityRepository.save(fieldTestMapstructAndServiceClassEntity).block();

        int databaseSizeBeforeUpdate = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();

        // Update the fieldTestMapstructAndServiceClassEntity using partial update
        FieldTestMapstructAndServiceClassEntity partialUpdatedFieldTestMapstructAndServiceClassEntity = new FieldTestMapstructAndServiceClassEntity();
        partialUpdatedFieldTestMapstructAndServiceClassEntity.setId(fieldTestMapstructAndServiceClassEntity.getId());

        partialUpdatedFieldTestMapstructAndServiceClassEntity
            .stringEva(UPDATED_STRING_EVA)
            .stringRequiredEva(UPDATED_STRING_REQUIRED_EVA)
            .stringMinlengthEva(UPDATED_STRING_MINLENGTH_EVA)
            .stringMaxlengthEva(UPDATED_STRING_MAXLENGTH_EVA)
            .stringPatternEva(UPDATED_STRING_PATTERN_EVA)
            .integerEva(UPDATED_INTEGER_EVA)
            .integerRequiredEva(UPDATED_INTEGER_REQUIRED_EVA)
            .integerMinEva(UPDATED_INTEGER_MIN_EVA)
            .integerMaxEva(UPDATED_INTEGER_MAX_EVA)
            .longEva(UPDATED_LONG_EVA)
            .longRequiredEva(UPDATED_LONG_REQUIRED_EVA)
            .longMinEva(UPDATED_LONG_MIN_EVA)
            .longMaxEva(UPDATED_LONG_MAX_EVA)
            .floatEva(UPDATED_FLOAT_EVA)
            .floatRequiredEva(UPDATED_FLOAT_REQUIRED_EVA)
            .floatMinEva(UPDATED_FLOAT_MIN_EVA)
            .floatMaxEva(UPDATED_FLOAT_MAX_EVA)
            .doubleRequiredEva(UPDATED_DOUBLE_REQUIRED_EVA)
            .doubleMinEva(UPDATED_DOUBLE_MIN_EVA)
            .doubleMaxEva(UPDATED_DOUBLE_MAX_EVA)
            .bigDecimalRequiredEva(UPDATED_BIG_DECIMAL_REQUIRED_EVA)
            .bigDecimalMinEva(UPDATED_BIG_DECIMAL_MIN_EVA)
            .bigDecimalMaxEva(UPDATED_BIG_DECIMAL_MAX_EVA)
            .localDateEva(UPDATED_LOCAL_DATE_EVA)
            .localDateRequiredEva(UPDATED_LOCAL_DATE_REQUIRED_EVA)
            .instantEva(UPDATED_INSTANT_EVA)
            .instanteRequiredEva(UPDATED_INSTANTE_REQUIRED_EVA)
            .zonedDateTimeEva(UPDATED_ZONED_DATE_TIME_EVA)
            .zonedDateTimeRequiredEva(UPDATED_ZONED_DATE_TIME_REQUIRED_EVA)
            .durationEva(UPDATED_DURATION_EVA)
            .durationRequiredEva(UPDATED_DURATION_REQUIRED_EVA)
            .booleanEva(UPDATED_BOOLEAN_EVA)
            .booleanRequiredEva(UPDATED_BOOLEAN_REQUIRED_EVA)
            .enumEva(UPDATED_ENUM_EVA)
            .enumRequiredEva(UPDATED_ENUM_REQUIRED_EVA)
            .uuidEva(UPDATED_UUID_EVA)
            .uuidRequiredEva(UPDATED_UUID_REQUIRED_EVA)
            .byteImageEva(UPDATED_BYTE_IMAGE_EVA)
            .byteImageEvaContentType(UPDATED_BYTE_IMAGE_EVA_CONTENT_TYPE)
            .byteImageRequiredEva(UPDATED_BYTE_IMAGE_REQUIRED_EVA)
            .byteImageRequiredEvaContentType(UPDATED_BYTE_IMAGE_REQUIRED_EVA_CONTENT_TYPE)
            .byteImageMinbytesEva(UPDATED_BYTE_IMAGE_MINBYTES_EVA)
            .byteImageMinbytesEvaContentType(UPDATED_BYTE_IMAGE_MINBYTES_EVA_CONTENT_TYPE)
            .byteImageMaxbytesEva(UPDATED_BYTE_IMAGE_MAXBYTES_EVA)
            .byteImageMaxbytesEvaContentType(UPDATED_BYTE_IMAGE_MAXBYTES_EVA_CONTENT_TYPE)
            .byteAnyEva(UPDATED_BYTE_ANY_EVA)
            .byteAnyEvaContentType(UPDATED_BYTE_ANY_EVA_CONTENT_TYPE)
            .byteAnyRequiredEva(UPDATED_BYTE_ANY_REQUIRED_EVA)
            .byteAnyRequiredEvaContentType(UPDATED_BYTE_ANY_REQUIRED_EVA_CONTENT_TYPE)
            .byteAnyMinbytesEva(UPDATED_BYTE_ANY_MINBYTES_EVA)
            .byteAnyMinbytesEvaContentType(UPDATED_BYTE_ANY_MINBYTES_EVA_CONTENT_TYPE)
            .byteAnyMaxbytesEva(UPDATED_BYTE_ANY_MAXBYTES_EVA)
            .byteAnyMaxbytesEvaContentType(UPDATED_BYTE_ANY_MAXBYTES_EVA_CONTENT_TYPE)
            .byteTextEva(UPDATED_BYTE_TEXT_EVA)
            .byteTextRequiredEva(UPDATED_BYTE_TEXT_REQUIRED_EVA);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedFieldTestMapstructAndServiceClassEntity.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedFieldTestMapstructAndServiceClassEntity))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the FieldTestMapstructAndServiceClassEntity in the database
        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeUpdate);
        FieldTestMapstructAndServiceClassEntity testFieldTestMapstructAndServiceClassEntity = fieldTestMapstructAndServiceClassEntityList.get(
            fieldTestMapstructAndServiceClassEntityList.size() - 1
        );
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringEva()).isEqualTo(UPDATED_STRING_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringRequiredEva()).isEqualTo(UPDATED_STRING_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringMinlengthEva()).isEqualTo(UPDATED_STRING_MINLENGTH_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringMaxlengthEva()).isEqualTo(UPDATED_STRING_MAXLENGTH_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getStringPatternEva()).isEqualTo(UPDATED_STRING_PATTERN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getIntegerEva()).isEqualTo(UPDATED_INTEGER_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getIntegerRequiredEva()).isEqualTo(UPDATED_INTEGER_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getIntegerMinEva()).isEqualTo(UPDATED_INTEGER_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getIntegerMaxEva()).isEqualTo(UPDATED_INTEGER_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLongEva()).isEqualTo(UPDATED_LONG_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLongRequiredEva()).isEqualTo(UPDATED_LONG_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLongMinEva()).isEqualTo(UPDATED_LONG_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLongMaxEva()).isEqualTo(UPDATED_LONG_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getFloatEva()).isEqualTo(UPDATED_FLOAT_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getFloatRequiredEva()).isEqualTo(UPDATED_FLOAT_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getFloatMinEva()).isEqualTo(UPDATED_FLOAT_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getFloatMaxEva()).isEqualTo(UPDATED_FLOAT_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDoubleRequiredEva()).isEqualTo(UPDATED_DOUBLE_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDoubleMinEva()).isEqualTo(UPDATED_DOUBLE_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDoubleMaxEva()).isEqualTo(UPDATED_DOUBLE_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBigDecimalRequiredEva())
            .isEqualByComparingTo(UPDATED_BIG_DECIMAL_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBigDecimalMinEva()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MIN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBigDecimalMaxEva()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MAX_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLocalDateEva()).isEqualTo(UPDATED_LOCAL_DATE_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getLocalDateRequiredEva()).isEqualTo(UPDATED_LOCAL_DATE_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getInstantEva()).isEqualTo(UPDATED_INSTANT_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getInstanteRequiredEva()).isEqualTo(UPDATED_INSTANTE_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getZonedDateTimeEva()).isEqualTo(UPDATED_ZONED_DATE_TIME_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getZonedDateTimeRequiredEva())
            .isEqualTo(UPDATED_ZONED_DATE_TIME_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDurationEva()).isEqualTo(UPDATED_DURATION_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getDurationRequiredEva()).isEqualTo(UPDATED_DURATION_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBooleanEva()).isEqualTo(UPDATED_BOOLEAN_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getBooleanRequiredEva()).isEqualTo(UPDATED_BOOLEAN_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getEnumEva()).isEqualTo(UPDATED_ENUM_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getEnumRequiredEva()).isEqualTo(UPDATED_ENUM_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getUuidEva()).isEqualTo(UPDATED_UUID_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getUuidRequiredEva()).isEqualTo(UPDATED_UUID_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageEva()).isEqualTo(UPDATED_BYTE_IMAGE_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageEvaContentType()).isEqualTo(UPDATED_BYTE_IMAGE_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageRequiredEva()).isEqualTo(UPDATED_BYTE_IMAGE_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageRequiredEvaContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_REQUIRED_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageMinbytesEva()).isEqualTo(UPDATED_BYTE_IMAGE_MINBYTES_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageMinbytesEvaContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_MINBYTES_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageMaxbytesEva()).isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteImageMaxbytesEvaContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyEva()).isEqualTo(UPDATED_BYTE_ANY_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyEvaContentType()).isEqualTo(UPDATED_BYTE_ANY_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyRequiredEva()).isEqualTo(UPDATED_BYTE_ANY_REQUIRED_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyRequiredEvaContentType())
            .isEqualTo(UPDATED_BYTE_ANY_REQUIRED_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyMinbytesEva()).isEqualTo(UPDATED_BYTE_ANY_MINBYTES_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyMinbytesEvaContentType())
            .isEqualTo(UPDATED_BYTE_ANY_MINBYTES_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyMaxbytesEva()).isEqualTo(UPDATED_BYTE_ANY_MAXBYTES_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteAnyMaxbytesEvaContentType())
            .isEqualTo(UPDATED_BYTE_ANY_MAXBYTES_EVA_CONTENT_TYPE);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteTextEva()).isEqualTo(UPDATED_BYTE_TEXT_EVA);
        assertThat(testFieldTestMapstructAndServiceClassEntity.getByteTextRequiredEva()).isEqualTo(UPDATED_BYTE_TEXT_REQUIRED_EVA);
    }

    @Test
    void patchNonExistingFieldTestMapstructAndServiceClassEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();
        fieldTestMapstructAndServiceClassEntity.setId(count.incrementAndGet());

        // Create the FieldTestMapstructAndServiceClassEntity
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            fieldTestMapstructAndServiceClassEntity
        );

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, fieldTestMapstructAndServiceClassEntityDTO.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestMapstructAndServiceClassEntity in the database
        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchFieldTestMapstructAndServiceClassEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();
        fieldTestMapstructAndServiceClassEntity.setId(count.incrementAndGet());

        // Create the FieldTestMapstructAndServiceClassEntity
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            fieldTestMapstructAndServiceClassEntity
        );

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestMapstructAndServiceClassEntity in the database
        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamFieldTestMapstructAndServiceClassEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();
        fieldTestMapstructAndServiceClassEntity.setId(count.incrementAndGet());

        // Create the FieldTestMapstructAndServiceClassEntity
        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = fieldTestMapstructAndServiceClassEntityMapper.toDto(
            fieldTestMapstructAndServiceClassEntity
        );

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestMapstructAndServiceClassEntityDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the FieldTestMapstructAndServiceClassEntity in the database
        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteFieldTestMapstructAndServiceClassEntity() {
        // Initialize the database
        fieldTestMapstructAndServiceClassEntityRepository.save(fieldTestMapstructAndServiceClassEntity).block();

        int databaseSizeBeforeDelete = fieldTestMapstructAndServiceClassEntityRepository.findAll().collectList().block().size();

        // Delete the fieldTestMapstructAndServiceClassEntity
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, fieldTestMapstructAndServiceClassEntity.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<FieldTestMapstructAndServiceClassEntity> fieldTestMapstructAndServiceClassEntityList = fieldTestMapstructAndServiceClassEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestMapstructAndServiceClassEntityList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
