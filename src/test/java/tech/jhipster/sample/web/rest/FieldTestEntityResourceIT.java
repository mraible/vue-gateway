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
import tech.jhipster.sample.domain.FieldTestEntity;
import tech.jhipster.sample.domain.enumeration.EnumFieldClass;
import tech.jhipster.sample.domain.enumeration.EnumRequiredFieldClass;
import tech.jhipster.sample.repository.FieldTestEntityRepository;
import tech.jhipster.sample.service.EntityManager;

/**
 * Integration tests for the {@link FieldTestEntityResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient
@WithMockUser
class FieldTestEntityResourceIT {

    private static final String DEFAULT_STRING_TOM = "AAAAAAAAAA";
    private static final String UPDATED_STRING_TOM = "BBBBBBBBBB";

    private static final String DEFAULT_STRING_REQUIRED_TOM = "AAAAAAAAAA";
    private static final String UPDATED_STRING_REQUIRED_TOM = "BBBBBBBBBB";

    private static final String DEFAULT_STRING_MINLENGTH_TOM = "AAAAAAAAAA";
    private static final String UPDATED_STRING_MINLENGTH_TOM = "BBBBBBBBBB";

    private static final String DEFAULT_STRING_MAXLENGTH_TOM = "AAAAAAAAAA";
    private static final String UPDATED_STRING_MAXLENGTH_TOM = "BBBBBBBBBB";

    private static final String DEFAULT_STRING_PATTERN_TOM = "AAAAAAAAAA";
    private static final String UPDATED_STRING_PATTERN_TOM = "BBBBBBBBBB";

    private static final String DEFAULT_NUMBER_PATTERN_TOM = "3157";
    private static final String UPDATED_NUMBER_PATTERN_TOM = "34737";

    private static final String DEFAULT_NUMBER_PATTERN_REQUIRED_TOM = "249";
    private static final String UPDATED_NUMBER_PATTERN_REQUIRED_TOM = "7326";

    private static final Integer DEFAULT_INTEGER_TOM = 1;
    private static final Integer UPDATED_INTEGER_TOM = 2;

    private static final Integer DEFAULT_INTEGER_REQUIRED_TOM = 1;
    private static final Integer UPDATED_INTEGER_REQUIRED_TOM = 2;

    private static final Integer DEFAULT_INTEGER_MIN_TOM = 0;
    private static final Integer UPDATED_INTEGER_MIN_TOM = 1;

    private static final Integer DEFAULT_INTEGER_MAX_TOM = 100;
    private static final Integer UPDATED_INTEGER_MAX_TOM = 99;

    private static final Long DEFAULT_LONG_TOM = 1L;
    private static final Long UPDATED_LONG_TOM = 2L;

    private static final Long DEFAULT_LONG_REQUIRED_TOM = 1L;
    private static final Long UPDATED_LONG_REQUIRED_TOM = 2L;

    private static final Long DEFAULT_LONG_MIN_TOM = 0L;
    private static final Long UPDATED_LONG_MIN_TOM = 1L;

    private static final Long DEFAULT_LONG_MAX_TOM = 100L;
    private static final Long UPDATED_LONG_MAX_TOM = 99L;

    private static final Float DEFAULT_FLOAT_TOM = 1F;
    private static final Float UPDATED_FLOAT_TOM = 2F;

    private static final Float DEFAULT_FLOAT_REQUIRED_TOM = 1F;
    private static final Float UPDATED_FLOAT_REQUIRED_TOM = 2F;

    private static final Float DEFAULT_FLOAT_MIN_TOM = 0F;
    private static final Float UPDATED_FLOAT_MIN_TOM = 1F;

    private static final Float DEFAULT_FLOAT_MAX_TOM = 100F;
    private static final Float UPDATED_FLOAT_MAX_TOM = 99F;

    private static final Double DEFAULT_DOUBLE_REQUIRED_TOM = 1D;
    private static final Double UPDATED_DOUBLE_REQUIRED_TOM = 2D;

    private static final Double DEFAULT_DOUBLE_MIN_TOM = 0D;
    private static final Double UPDATED_DOUBLE_MIN_TOM = 1D;

    private static final Double DEFAULT_DOUBLE_MAX_TOM = 100D;
    private static final Double UPDATED_DOUBLE_MAX_TOM = 99D;

    private static final BigDecimal DEFAULT_BIG_DECIMAL_REQUIRED_TOM = new BigDecimal(1);
    private static final BigDecimal UPDATED_BIG_DECIMAL_REQUIRED_TOM = new BigDecimal(2);

    private static final BigDecimal DEFAULT_BIG_DECIMAL_MIN_TOM = new BigDecimal(0);
    private static final BigDecimal UPDATED_BIG_DECIMAL_MIN_TOM = new BigDecimal(1);

    private static final BigDecimal DEFAULT_BIG_DECIMAL_MAX_TOM = new BigDecimal(100);
    private static final BigDecimal UPDATED_BIG_DECIMAL_MAX_TOM = new BigDecimal(99);

    private static final LocalDate DEFAULT_LOCAL_DATE_TOM = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LOCAL_DATE_TOM = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_LOCAL_DATE_REQUIRED_TOM = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LOCAL_DATE_REQUIRED_TOM = LocalDate.now(ZoneId.systemDefault());

    private static final Instant DEFAULT_INSTANT_TOM = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_INSTANT_TOM = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_INSTANT_REQUIRED_TOM = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_INSTANT_REQUIRED_TOM = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final ZonedDateTime DEFAULT_ZONED_DATE_TIME_TOM = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_ZONED_DATE_TIME_TOM = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_ZONED_DATE_TIME_REQUIRED_TOM = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_ZONED_DATE_TIME_REQUIRED_TOM = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final Duration DEFAULT_DURATION_TOM = Duration.ofHours(6);
    private static final Duration UPDATED_DURATION_TOM = Duration.ofHours(12);

    private static final Duration DEFAULT_DURATION_REQUIRED_TOM = Duration.ofHours(6);
    private static final Duration UPDATED_DURATION_REQUIRED_TOM = Duration.ofHours(12);

    private static final Boolean DEFAULT_BOOLEAN_TOM = false;
    private static final Boolean UPDATED_BOOLEAN_TOM = true;

    private static final Boolean DEFAULT_BOOLEAN_REQUIRED_TOM = false;
    private static final Boolean UPDATED_BOOLEAN_REQUIRED_TOM = true;

    private static final EnumFieldClass DEFAULT_ENUM_TOM = EnumFieldClass.ENUM_VALUE_1;
    private static final EnumFieldClass UPDATED_ENUM_TOM = EnumFieldClass.ENUM_VALUE_2;

    private static final EnumRequiredFieldClass DEFAULT_ENUM_REQUIRED_TOM = EnumRequiredFieldClass.ENUM_VALUE_1;
    private static final EnumRequiredFieldClass UPDATED_ENUM_REQUIRED_TOM = EnumRequiredFieldClass.ENUM_VALUE_2;

    private static final UUID DEFAULT_UUID_TOM = UUID.randomUUID();
    private static final UUID UPDATED_UUID_TOM = UUID.randomUUID();

    private static final UUID DEFAULT_UUID_REQUIRED_TOM = UUID.randomUUID();
    private static final UUID UPDATED_UUID_REQUIRED_TOM = UUID.randomUUID();

    private static final byte[] DEFAULT_BYTE_IMAGE_TOM = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_IMAGE_TOM = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_IMAGE_TOM_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_IMAGE_TOM_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_IMAGE_REQUIRED_TOM = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_IMAGE_REQUIRED_TOM = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_IMAGE_REQUIRED_TOM_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_IMAGE_REQUIRED_TOM_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_IMAGE_MINBYTES_TOM = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_IMAGE_MINBYTES_TOM = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_IMAGE_MINBYTES_TOM_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_IMAGE_MINBYTES_TOM_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_IMAGE_MAXBYTES_TOM = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_IMAGE_MAXBYTES_TOM = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_IMAGE_MAXBYTES_TOM_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_IMAGE_MAXBYTES_TOM_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_ANY_TOM = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_ANY_TOM = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_ANY_TOM_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_ANY_TOM_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_ANY_REQUIRED_TOM = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_ANY_REQUIRED_TOM = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_ANY_REQUIRED_TOM_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_ANY_REQUIRED_TOM_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_ANY_MINBYTES_TOM = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_ANY_MINBYTES_TOM = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_ANY_MINBYTES_TOM_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_ANY_MINBYTES_TOM_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_ANY_MAXBYTES_TOM = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_ANY_MAXBYTES_TOM = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_ANY_MAXBYTES_TOM_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_ANY_MAXBYTES_TOM_CONTENT_TYPE = "image/png";

    private static final String DEFAULT_BYTE_TEXT_TOM = "AAAAAAAAAA";
    private static final String UPDATED_BYTE_TEXT_TOM = "BBBBBBBBBB";

    private static final String DEFAULT_BYTE_TEXT_REQUIRED_TOM = "AAAAAAAAAA";
    private static final String UPDATED_BYTE_TEXT_REQUIRED_TOM = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/field-test-entities";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private FieldTestEntityRepository fieldTestEntityRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private FieldTestEntity fieldTestEntity;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FieldTestEntity createEntity(EntityManager em) {
        FieldTestEntity fieldTestEntity = new FieldTestEntity()
            .stringTom(DEFAULT_STRING_TOM)
            .stringRequiredTom(DEFAULT_STRING_REQUIRED_TOM)
            .stringMinlengthTom(DEFAULT_STRING_MINLENGTH_TOM)
            .stringMaxlengthTom(DEFAULT_STRING_MAXLENGTH_TOM)
            .stringPatternTom(DEFAULT_STRING_PATTERN_TOM)
            .numberPatternTom(DEFAULT_NUMBER_PATTERN_TOM)
            .numberPatternRequiredTom(DEFAULT_NUMBER_PATTERN_REQUIRED_TOM)
            .integerTom(DEFAULT_INTEGER_TOM)
            .integerRequiredTom(DEFAULT_INTEGER_REQUIRED_TOM)
            .integerMinTom(DEFAULT_INTEGER_MIN_TOM)
            .integerMaxTom(DEFAULT_INTEGER_MAX_TOM)
            .longTom(DEFAULT_LONG_TOM)
            .longRequiredTom(DEFAULT_LONG_REQUIRED_TOM)
            .longMinTom(DEFAULT_LONG_MIN_TOM)
            .longMaxTom(DEFAULT_LONG_MAX_TOM)
            .floatTom(DEFAULT_FLOAT_TOM)
            .floatRequiredTom(DEFAULT_FLOAT_REQUIRED_TOM)
            .floatMinTom(DEFAULT_FLOAT_MIN_TOM)
            .floatMaxTom(DEFAULT_FLOAT_MAX_TOM)
            .doubleRequiredTom(DEFAULT_DOUBLE_REQUIRED_TOM)
            .doubleMinTom(DEFAULT_DOUBLE_MIN_TOM)
            .doubleMaxTom(DEFAULT_DOUBLE_MAX_TOM)
            .bigDecimalRequiredTom(DEFAULT_BIG_DECIMAL_REQUIRED_TOM)
            .bigDecimalMinTom(DEFAULT_BIG_DECIMAL_MIN_TOM)
            .bigDecimalMaxTom(DEFAULT_BIG_DECIMAL_MAX_TOM)
            .localDateTom(DEFAULT_LOCAL_DATE_TOM)
            .localDateRequiredTom(DEFAULT_LOCAL_DATE_REQUIRED_TOM)
            .instantTom(DEFAULT_INSTANT_TOM)
            .instantRequiredTom(DEFAULT_INSTANT_REQUIRED_TOM)
            .zonedDateTimeTom(DEFAULT_ZONED_DATE_TIME_TOM)
            .zonedDateTimeRequiredTom(DEFAULT_ZONED_DATE_TIME_REQUIRED_TOM)
            .durationTom(DEFAULT_DURATION_TOM)
            .durationRequiredTom(DEFAULT_DURATION_REQUIRED_TOM)
            .booleanTom(DEFAULT_BOOLEAN_TOM)
            .booleanRequiredTom(DEFAULT_BOOLEAN_REQUIRED_TOM)
            .enumTom(DEFAULT_ENUM_TOM)
            .enumRequiredTom(DEFAULT_ENUM_REQUIRED_TOM)
            .uuidTom(DEFAULT_UUID_TOM)
            .uuidRequiredTom(DEFAULT_UUID_REQUIRED_TOM)
            .byteImageTom(DEFAULT_BYTE_IMAGE_TOM)
            .byteImageTomContentType(DEFAULT_BYTE_IMAGE_TOM_CONTENT_TYPE)
            .byteImageRequiredTom(DEFAULT_BYTE_IMAGE_REQUIRED_TOM)
            .byteImageRequiredTomContentType(DEFAULT_BYTE_IMAGE_REQUIRED_TOM_CONTENT_TYPE)
            .byteImageMinbytesTom(DEFAULT_BYTE_IMAGE_MINBYTES_TOM)
            .byteImageMinbytesTomContentType(DEFAULT_BYTE_IMAGE_MINBYTES_TOM_CONTENT_TYPE)
            .byteImageMaxbytesTom(DEFAULT_BYTE_IMAGE_MAXBYTES_TOM)
            .byteImageMaxbytesTomContentType(DEFAULT_BYTE_IMAGE_MAXBYTES_TOM_CONTENT_TYPE)
            .byteAnyTom(DEFAULT_BYTE_ANY_TOM)
            .byteAnyTomContentType(DEFAULT_BYTE_ANY_TOM_CONTENT_TYPE)
            .byteAnyRequiredTom(DEFAULT_BYTE_ANY_REQUIRED_TOM)
            .byteAnyRequiredTomContentType(DEFAULT_BYTE_ANY_REQUIRED_TOM_CONTENT_TYPE)
            .byteAnyMinbytesTom(DEFAULT_BYTE_ANY_MINBYTES_TOM)
            .byteAnyMinbytesTomContentType(DEFAULT_BYTE_ANY_MINBYTES_TOM_CONTENT_TYPE)
            .byteAnyMaxbytesTom(DEFAULT_BYTE_ANY_MAXBYTES_TOM)
            .byteAnyMaxbytesTomContentType(DEFAULT_BYTE_ANY_MAXBYTES_TOM_CONTENT_TYPE)
            .byteTextTom(DEFAULT_BYTE_TEXT_TOM)
            .byteTextRequiredTom(DEFAULT_BYTE_TEXT_REQUIRED_TOM);
        return fieldTestEntity;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FieldTestEntity createUpdatedEntity(EntityManager em) {
        FieldTestEntity fieldTestEntity = new FieldTestEntity()
            .stringTom(UPDATED_STRING_TOM)
            .stringRequiredTom(UPDATED_STRING_REQUIRED_TOM)
            .stringMinlengthTom(UPDATED_STRING_MINLENGTH_TOM)
            .stringMaxlengthTom(UPDATED_STRING_MAXLENGTH_TOM)
            .stringPatternTom(UPDATED_STRING_PATTERN_TOM)
            .numberPatternTom(UPDATED_NUMBER_PATTERN_TOM)
            .numberPatternRequiredTom(UPDATED_NUMBER_PATTERN_REQUIRED_TOM)
            .integerTom(UPDATED_INTEGER_TOM)
            .integerRequiredTom(UPDATED_INTEGER_REQUIRED_TOM)
            .integerMinTom(UPDATED_INTEGER_MIN_TOM)
            .integerMaxTom(UPDATED_INTEGER_MAX_TOM)
            .longTom(UPDATED_LONG_TOM)
            .longRequiredTom(UPDATED_LONG_REQUIRED_TOM)
            .longMinTom(UPDATED_LONG_MIN_TOM)
            .longMaxTom(UPDATED_LONG_MAX_TOM)
            .floatTom(UPDATED_FLOAT_TOM)
            .floatRequiredTom(UPDATED_FLOAT_REQUIRED_TOM)
            .floatMinTom(UPDATED_FLOAT_MIN_TOM)
            .floatMaxTom(UPDATED_FLOAT_MAX_TOM)
            .doubleRequiredTom(UPDATED_DOUBLE_REQUIRED_TOM)
            .doubleMinTom(UPDATED_DOUBLE_MIN_TOM)
            .doubleMaxTom(UPDATED_DOUBLE_MAX_TOM)
            .bigDecimalRequiredTom(UPDATED_BIG_DECIMAL_REQUIRED_TOM)
            .bigDecimalMinTom(UPDATED_BIG_DECIMAL_MIN_TOM)
            .bigDecimalMaxTom(UPDATED_BIG_DECIMAL_MAX_TOM)
            .localDateTom(UPDATED_LOCAL_DATE_TOM)
            .localDateRequiredTom(UPDATED_LOCAL_DATE_REQUIRED_TOM)
            .instantTom(UPDATED_INSTANT_TOM)
            .instantRequiredTom(UPDATED_INSTANT_REQUIRED_TOM)
            .zonedDateTimeTom(UPDATED_ZONED_DATE_TIME_TOM)
            .zonedDateTimeRequiredTom(UPDATED_ZONED_DATE_TIME_REQUIRED_TOM)
            .durationTom(UPDATED_DURATION_TOM)
            .durationRequiredTom(UPDATED_DURATION_REQUIRED_TOM)
            .booleanTom(UPDATED_BOOLEAN_TOM)
            .booleanRequiredTom(UPDATED_BOOLEAN_REQUIRED_TOM)
            .enumTom(UPDATED_ENUM_TOM)
            .enumRequiredTom(UPDATED_ENUM_REQUIRED_TOM)
            .uuidTom(UPDATED_UUID_TOM)
            .uuidRequiredTom(UPDATED_UUID_REQUIRED_TOM)
            .byteImageTom(UPDATED_BYTE_IMAGE_TOM)
            .byteImageTomContentType(UPDATED_BYTE_IMAGE_TOM_CONTENT_TYPE)
            .byteImageRequiredTom(UPDATED_BYTE_IMAGE_REQUIRED_TOM)
            .byteImageRequiredTomContentType(UPDATED_BYTE_IMAGE_REQUIRED_TOM_CONTENT_TYPE)
            .byteImageMinbytesTom(UPDATED_BYTE_IMAGE_MINBYTES_TOM)
            .byteImageMinbytesTomContentType(UPDATED_BYTE_IMAGE_MINBYTES_TOM_CONTENT_TYPE)
            .byteImageMaxbytesTom(UPDATED_BYTE_IMAGE_MAXBYTES_TOM)
            .byteImageMaxbytesTomContentType(UPDATED_BYTE_IMAGE_MAXBYTES_TOM_CONTENT_TYPE)
            .byteAnyTom(UPDATED_BYTE_ANY_TOM)
            .byteAnyTomContentType(UPDATED_BYTE_ANY_TOM_CONTENT_TYPE)
            .byteAnyRequiredTom(UPDATED_BYTE_ANY_REQUIRED_TOM)
            .byteAnyRequiredTomContentType(UPDATED_BYTE_ANY_REQUIRED_TOM_CONTENT_TYPE)
            .byteAnyMinbytesTom(UPDATED_BYTE_ANY_MINBYTES_TOM)
            .byteAnyMinbytesTomContentType(UPDATED_BYTE_ANY_MINBYTES_TOM_CONTENT_TYPE)
            .byteAnyMaxbytesTom(UPDATED_BYTE_ANY_MAXBYTES_TOM)
            .byteAnyMaxbytesTomContentType(UPDATED_BYTE_ANY_MAXBYTES_TOM_CONTENT_TYPE)
            .byteTextTom(UPDATED_BYTE_TEXT_TOM)
            .byteTextRequiredTom(UPDATED_BYTE_TEXT_REQUIRED_TOM);
        return fieldTestEntity;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(FieldTestEntity.class).block();
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
        fieldTestEntity = createEntity(em);
    }

    @Test
    void createFieldTestEntity() throws Exception {
        int databaseSizeBeforeCreate = fieldTestEntityRepository.findAll().collectList().block().size();
        // Create the FieldTestEntity
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the FieldTestEntity in the database
        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeCreate + 1);
        FieldTestEntity testFieldTestEntity = fieldTestEntityList.get(fieldTestEntityList.size() - 1);
        assertThat(testFieldTestEntity.getStringTom()).isEqualTo(DEFAULT_STRING_TOM);
        assertThat(testFieldTestEntity.getStringRequiredTom()).isEqualTo(DEFAULT_STRING_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getStringMinlengthTom()).isEqualTo(DEFAULT_STRING_MINLENGTH_TOM);
        assertThat(testFieldTestEntity.getStringMaxlengthTom()).isEqualTo(DEFAULT_STRING_MAXLENGTH_TOM);
        assertThat(testFieldTestEntity.getStringPatternTom()).isEqualTo(DEFAULT_STRING_PATTERN_TOM);
        assertThat(testFieldTestEntity.getNumberPatternTom()).isEqualTo(DEFAULT_NUMBER_PATTERN_TOM);
        assertThat(testFieldTestEntity.getNumberPatternRequiredTom()).isEqualTo(DEFAULT_NUMBER_PATTERN_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getIntegerTom()).isEqualTo(DEFAULT_INTEGER_TOM);
        assertThat(testFieldTestEntity.getIntegerRequiredTom()).isEqualTo(DEFAULT_INTEGER_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getIntegerMinTom()).isEqualTo(DEFAULT_INTEGER_MIN_TOM);
        assertThat(testFieldTestEntity.getIntegerMaxTom()).isEqualTo(DEFAULT_INTEGER_MAX_TOM);
        assertThat(testFieldTestEntity.getLongTom()).isEqualTo(DEFAULT_LONG_TOM);
        assertThat(testFieldTestEntity.getLongRequiredTom()).isEqualTo(DEFAULT_LONG_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getLongMinTom()).isEqualTo(DEFAULT_LONG_MIN_TOM);
        assertThat(testFieldTestEntity.getLongMaxTom()).isEqualTo(DEFAULT_LONG_MAX_TOM);
        assertThat(testFieldTestEntity.getFloatTom()).isEqualTo(DEFAULT_FLOAT_TOM);
        assertThat(testFieldTestEntity.getFloatRequiredTom()).isEqualTo(DEFAULT_FLOAT_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getFloatMinTom()).isEqualTo(DEFAULT_FLOAT_MIN_TOM);
        assertThat(testFieldTestEntity.getFloatMaxTom()).isEqualTo(DEFAULT_FLOAT_MAX_TOM);
        assertThat(testFieldTestEntity.getDoubleRequiredTom()).isEqualTo(DEFAULT_DOUBLE_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getDoubleMinTom()).isEqualTo(DEFAULT_DOUBLE_MIN_TOM);
        assertThat(testFieldTestEntity.getDoubleMaxTom()).isEqualTo(DEFAULT_DOUBLE_MAX_TOM);
        assertThat(testFieldTestEntity.getBigDecimalRequiredTom()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getBigDecimalMinTom()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MIN_TOM);
        assertThat(testFieldTestEntity.getBigDecimalMaxTom()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MAX_TOM);
        assertThat(testFieldTestEntity.getLocalDateTom()).isEqualTo(DEFAULT_LOCAL_DATE_TOM);
        assertThat(testFieldTestEntity.getLocalDateRequiredTom()).isEqualTo(DEFAULT_LOCAL_DATE_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getInstantTom()).isEqualTo(DEFAULT_INSTANT_TOM);
        assertThat(testFieldTestEntity.getInstantRequiredTom()).isEqualTo(DEFAULT_INSTANT_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getZonedDateTimeTom()).isEqualTo(DEFAULT_ZONED_DATE_TIME_TOM);
        assertThat(testFieldTestEntity.getZonedDateTimeRequiredTom()).isEqualTo(DEFAULT_ZONED_DATE_TIME_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getDurationTom()).isEqualTo(DEFAULT_DURATION_TOM);
        assertThat(testFieldTestEntity.getDurationRequiredTom()).isEqualTo(DEFAULT_DURATION_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getBooleanTom()).isEqualTo(DEFAULT_BOOLEAN_TOM);
        assertThat(testFieldTestEntity.getBooleanRequiredTom()).isEqualTo(DEFAULT_BOOLEAN_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getEnumTom()).isEqualTo(DEFAULT_ENUM_TOM);
        assertThat(testFieldTestEntity.getEnumRequiredTom()).isEqualTo(DEFAULT_ENUM_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getUuidTom()).isEqualTo(DEFAULT_UUID_TOM);
        assertThat(testFieldTestEntity.getUuidRequiredTom()).isEqualTo(DEFAULT_UUID_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getByteImageTom()).isEqualTo(DEFAULT_BYTE_IMAGE_TOM);
        assertThat(testFieldTestEntity.getByteImageTomContentType()).isEqualTo(DEFAULT_BYTE_IMAGE_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteImageRequiredTom()).isEqualTo(DEFAULT_BYTE_IMAGE_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getByteImageRequiredTomContentType()).isEqualTo(DEFAULT_BYTE_IMAGE_REQUIRED_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteImageMinbytesTom()).isEqualTo(DEFAULT_BYTE_IMAGE_MINBYTES_TOM);
        assertThat(testFieldTestEntity.getByteImageMinbytesTomContentType()).isEqualTo(DEFAULT_BYTE_IMAGE_MINBYTES_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteImageMaxbytesTom()).isEqualTo(DEFAULT_BYTE_IMAGE_MAXBYTES_TOM);
        assertThat(testFieldTestEntity.getByteImageMaxbytesTomContentType()).isEqualTo(DEFAULT_BYTE_IMAGE_MAXBYTES_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteAnyTom()).isEqualTo(DEFAULT_BYTE_ANY_TOM);
        assertThat(testFieldTestEntity.getByteAnyTomContentType()).isEqualTo(DEFAULT_BYTE_ANY_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteAnyRequiredTom()).isEqualTo(DEFAULT_BYTE_ANY_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getByteAnyRequiredTomContentType()).isEqualTo(DEFAULT_BYTE_ANY_REQUIRED_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteAnyMinbytesTom()).isEqualTo(DEFAULT_BYTE_ANY_MINBYTES_TOM);
        assertThat(testFieldTestEntity.getByteAnyMinbytesTomContentType()).isEqualTo(DEFAULT_BYTE_ANY_MINBYTES_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteAnyMaxbytesTom()).isEqualTo(DEFAULT_BYTE_ANY_MAXBYTES_TOM);
        assertThat(testFieldTestEntity.getByteAnyMaxbytesTomContentType()).isEqualTo(DEFAULT_BYTE_ANY_MAXBYTES_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteTextTom()).isEqualTo(DEFAULT_BYTE_TEXT_TOM);
        assertThat(testFieldTestEntity.getByteTextRequiredTom()).isEqualTo(DEFAULT_BYTE_TEXT_REQUIRED_TOM);
    }

    @Test
    void createFieldTestEntityWithExistingId() throws Exception {
        // Create the FieldTestEntity with an existing ID
        fieldTestEntity.setId(1L);

        int databaseSizeBeforeCreate = fieldTestEntityRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestEntity in the database
        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void checkStringRequiredTomIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestEntity.setStringRequiredTom(null);

        // Create the FieldTestEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkNumberPatternRequiredTomIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestEntity.setNumberPatternRequiredTom(null);

        // Create the FieldTestEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkIntegerRequiredTomIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestEntity.setIntegerRequiredTom(null);

        // Create the FieldTestEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkLongRequiredTomIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestEntity.setLongRequiredTom(null);

        // Create the FieldTestEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkFloatRequiredTomIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestEntity.setFloatRequiredTom(null);

        // Create the FieldTestEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkDoubleRequiredTomIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestEntity.setDoubleRequiredTom(null);

        // Create the FieldTestEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkBigDecimalRequiredTomIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestEntity.setBigDecimalRequiredTom(null);

        // Create the FieldTestEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkLocalDateRequiredTomIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestEntity.setLocalDateRequiredTom(null);

        // Create the FieldTestEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkInstantRequiredTomIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestEntity.setInstantRequiredTom(null);

        // Create the FieldTestEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkZonedDateTimeRequiredTomIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestEntity.setZonedDateTimeRequiredTom(null);

        // Create the FieldTestEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkDurationRequiredTomIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestEntity.setDurationRequiredTom(null);

        // Create the FieldTestEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkBooleanRequiredTomIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestEntity.setBooleanRequiredTom(null);

        // Create the FieldTestEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkEnumRequiredTomIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestEntity.setEnumRequiredTom(null);

        // Create the FieldTestEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkUuidRequiredTomIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestEntity.setUuidRequiredTom(null);

        // Create the FieldTestEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void getAllFieldTestEntitiesAsStream() {
        // Initialize the database
        fieldTestEntityRepository.save(fieldTestEntity).block();

        List<FieldTestEntity> fieldTestEntityList = webTestClient
            .get()
            .uri(ENTITY_API_URL)
            .accept(MediaType.APPLICATION_NDJSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentTypeCompatibleWith(MediaType.APPLICATION_NDJSON)
            .returnResult(FieldTestEntity.class)
            .getResponseBody()
            .filter(fieldTestEntity::equals)
            .collectList()
            .block(Duration.ofSeconds(5));

        assertThat(fieldTestEntityList).isNotNull();
        assertThat(fieldTestEntityList).hasSize(1);
        FieldTestEntity testFieldTestEntity = fieldTestEntityList.get(0);
        assertThat(testFieldTestEntity.getStringTom()).isEqualTo(DEFAULT_STRING_TOM);
        assertThat(testFieldTestEntity.getStringRequiredTom()).isEqualTo(DEFAULT_STRING_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getStringMinlengthTom()).isEqualTo(DEFAULT_STRING_MINLENGTH_TOM);
        assertThat(testFieldTestEntity.getStringMaxlengthTom()).isEqualTo(DEFAULT_STRING_MAXLENGTH_TOM);
        assertThat(testFieldTestEntity.getStringPatternTom()).isEqualTo(DEFAULT_STRING_PATTERN_TOM);
        assertThat(testFieldTestEntity.getNumberPatternTom()).isEqualTo(DEFAULT_NUMBER_PATTERN_TOM);
        assertThat(testFieldTestEntity.getNumberPatternRequiredTom()).isEqualTo(DEFAULT_NUMBER_PATTERN_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getIntegerTom()).isEqualTo(DEFAULT_INTEGER_TOM);
        assertThat(testFieldTestEntity.getIntegerRequiredTom()).isEqualTo(DEFAULT_INTEGER_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getIntegerMinTom()).isEqualTo(DEFAULT_INTEGER_MIN_TOM);
        assertThat(testFieldTestEntity.getIntegerMaxTom()).isEqualTo(DEFAULT_INTEGER_MAX_TOM);
        assertThat(testFieldTestEntity.getLongTom()).isEqualTo(DEFAULT_LONG_TOM);
        assertThat(testFieldTestEntity.getLongRequiredTom()).isEqualTo(DEFAULT_LONG_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getLongMinTom()).isEqualTo(DEFAULT_LONG_MIN_TOM);
        assertThat(testFieldTestEntity.getLongMaxTom()).isEqualTo(DEFAULT_LONG_MAX_TOM);
        assertThat(testFieldTestEntity.getFloatTom()).isEqualTo(DEFAULT_FLOAT_TOM);
        assertThat(testFieldTestEntity.getFloatRequiredTom()).isEqualTo(DEFAULT_FLOAT_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getFloatMinTom()).isEqualTo(DEFAULT_FLOAT_MIN_TOM);
        assertThat(testFieldTestEntity.getFloatMaxTom()).isEqualTo(DEFAULT_FLOAT_MAX_TOM);
        assertThat(testFieldTestEntity.getDoubleRequiredTom()).isEqualTo(DEFAULT_DOUBLE_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getDoubleMinTom()).isEqualTo(DEFAULT_DOUBLE_MIN_TOM);
        assertThat(testFieldTestEntity.getDoubleMaxTom()).isEqualTo(DEFAULT_DOUBLE_MAX_TOM);
        assertThat(testFieldTestEntity.getBigDecimalRequiredTom()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getBigDecimalMinTom()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MIN_TOM);
        assertThat(testFieldTestEntity.getBigDecimalMaxTom()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MAX_TOM);
        assertThat(testFieldTestEntity.getLocalDateTom()).isEqualTo(DEFAULT_LOCAL_DATE_TOM);
        assertThat(testFieldTestEntity.getLocalDateRequiredTom()).isEqualTo(DEFAULT_LOCAL_DATE_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getInstantTom()).isEqualTo(DEFAULT_INSTANT_TOM);
        assertThat(testFieldTestEntity.getInstantRequiredTom()).isEqualTo(DEFAULT_INSTANT_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getZonedDateTimeTom()).isEqualTo(DEFAULT_ZONED_DATE_TIME_TOM);
        assertThat(testFieldTestEntity.getZonedDateTimeRequiredTom()).isEqualTo(DEFAULT_ZONED_DATE_TIME_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getDurationTom()).isEqualTo(DEFAULT_DURATION_TOM);
        assertThat(testFieldTestEntity.getDurationRequiredTom()).isEqualTo(DEFAULT_DURATION_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getBooleanTom()).isEqualTo(DEFAULT_BOOLEAN_TOM);
        assertThat(testFieldTestEntity.getBooleanRequiredTom()).isEqualTo(DEFAULT_BOOLEAN_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getEnumTom()).isEqualTo(DEFAULT_ENUM_TOM);
        assertThat(testFieldTestEntity.getEnumRequiredTom()).isEqualTo(DEFAULT_ENUM_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getUuidTom()).isEqualTo(DEFAULT_UUID_TOM);
        assertThat(testFieldTestEntity.getUuidRequiredTom()).isEqualTo(DEFAULT_UUID_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getByteImageTom()).isEqualTo(DEFAULT_BYTE_IMAGE_TOM);
        assertThat(testFieldTestEntity.getByteImageTomContentType()).isEqualTo(DEFAULT_BYTE_IMAGE_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteImageRequiredTom()).isEqualTo(DEFAULT_BYTE_IMAGE_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getByteImageRequiredTomContentType()).isEqualTo(DEFAULT_BYTE_IMAGE_REQUIRED_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteImageMinbytesTom()).isEqualTo(DEFAULT_BYTE_IMAGE_MINBYTES_TOM);
        assertThat(testFieldTestEntity.getByteImageMinbytesTomContentType()).isEqualTo(DEFAULT_BYTE_IMAGE_MINBYTES_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteImageMaxbytesTom()).isEqualTo(DEFAULT_BYTE_IMAGE_MAXBYTES_TOM);
        assertThat(testFieldTestEntity.getByteImageMaxbytesTomContentType()).isEqualTo(DEFAULT_BYTE_IMAGE_MAXBYTES_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteAnyTom()).isEqualTo(DEFAULT_BYTE_ANY_TOM);
        assertThat(testFieldTestEntity.getByteAnyTomContentType()).isEqualTo(DEFAULT_BYTE_ANY_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteAnyRequiredTom()).isEqualTo(DEFAULT_BYTE_ANY_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getByteAnyRequiredTomContentType()).isEqualTo(DEFAULT_BYTE_ANY_REQUIRED_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteAnyMinbytesTom()).isEqualTo(DEFAULT_BYTE_ANY_MINBYTES_TOM);
        assertThat(testFieldTestEntity.getByteAnyMinbytesTomContentType()).isEqualTo(DEFAULT_BYTE_ANY_MINBYTES_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteAnyMaxbytesTom()).isEqualTo(DEFAULT_BYTE_ANY_MAXBYTES_TOM);
        assertThat(testFieldTestEntity.getByteAnyMaxbytesTomContentType()).isEqualTo(DEFAULT_BYTE_ANY_MAXBYTES_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteTextTom()).isEqualTo(DEFAULT_BYTE_TEXT_TOM);
        assertThat(testFieldTestEntity.getByteTextRequiredTom()).isEqualTo(DEFAULT_BYTE_TEXT_REQUIRED_TOM);
    }

    @Test
    void getAllFieldTestEntities() {
        // Initialize the database
        fieldTestEntityRepository.save(fieldTestEntity).block();

        // Get all the fieldTestEntityList
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
            .value(hasItem(fieldTestEntity.getId().intValue()))
            .jsonPath("$.[*].stringTom")
            .value(hasItem(DEFAULT_STRING_TOM))
            .jsonPath("$.[*].stringRequiredTom")
            .value(hasItem(DEFAULT_STRING_REQUIRED_TOM))
            .jsonPath("$.[*].stringMinlengthTom")
            .value(hasItem(DEFAULT_STRING_MINLENGTH_TOM))
            .jsonPath("$.[*].stringMaxlengthTom")
            .value(hasItem(DEFAULT_STRING_MAXLENGTH_TOM))
            .jsonPath("$.[*].stringPatternTom")
            .value(hasItem(DEFAULT_STRING_PATTERN_TOM))
            .jsonPath("$.[*].numberPatternTom")
            .value(hasItem(DEFAULT_NUMBER_PATTERN_TOM))
            .jsonPath("$.[*].numberPatternRequiredTom")
            .value(hasItem(DEFAULT_NUMBER_PATTERN_REQUIRED_TOM))
            .jsonPath("$.[*].integerTom")
            .value(hasItem(DEFAULT_INTEGER_TOM))
            .jsonPath("$.[*].integerRequiredTom")
            .value(hasItem(DEFAULT_INTEGER_REQUIRED_TOM))
            .jsonPath("$.[*].integerMinTom")
            .value(hasItem(DEFAULT_INTEGER_MIN_TOM))
            .jsonPath("$.[*].integerMaxTom")
            .value(hasItem(DEFAULT_INTEGER_MAX_TOM))
            .jsonPath("$.[*].longTom")
            .value(hasItem(DEFAULT_LONG_TOM.intValue()))
            .jsonPath("$.[*].longRequiredTom")
            .value(hasItem(DEFAULT_LONG_REQUIRED_TOM.intValue()))
            .jsonPath("$.[*].longMinTom")
            .value(hasItem(DEFAULT_LONG_MIN_TOM.intValue()))
            .jsonPath("$.[*].longMaxTom")
            .value(hasItem(DEFAULT_LONG_MAX_TOM.intValue()))
            .jsonPath("$.[*].floatTom")
            .value(hasItem(DEFAULT_FLOAT_TOM.doubleValue()))
            .jsonPath("$.[*].floatRequiredTom")
            .value(hasItem(DEFAULT_FLOAT_REQUIRED_TOM.doubleValue()))
            .jsonPath("$.[*].floatMinTom")
            .value(hasItem(DEFAULT_FLOAT_MIN_TOM.doubleValue()))
            .jsonPath("$.[*].floatMaxTom")
            .value(hasItem(DEFAULT_FLOAT_MAX_TOM.doubleValue()))
            .jsonPath("$.[*].doubleRequiredTom")
            .value(hasItem(DEFAULT_DOUBLE_REQUIRED_TOM.doubleValue()))
            .jsonPath("$.[*].doubleMinTom")
            .value(hasItem(DEFAULT_DOUBLE_MIN_TOM.doubleValue()))
            .jsonPath("$.[*].doubleMaxTom")
            .value(hasItem(DEFAULT_DOUBLE_MAX_TOM.doubleValue()))
            .jsonPath("$.[*].bigDecimalRequiredTom")
            .value(hasItem(sameNumber(DEFAULT_BIG_DECIMAL_REQUIRED_TOM)))
            .jsonPath("$.[*].bigDecimalMinTom")
            .value(hasItem(sameNumber(DEFAULT_BIG_DECIMAL_MIN_TOM)))
            .jsonPath("$.[*].bigDecimalMaxTom")
            .value(hasItem(sameNumber(DEFAULT_BIG_DECIMAL_MAX_TOM)))
            .jsonPath("$.[*].localDateTom")
            .value(hasItem(DEFAULT_LOCAL_DATE_TOM.toString()))
            .jsonPath("$.[*].localDateRequiredTom")
            .value(hasItem(DEFAULT_LOCAL_DATE_REQUIRED_TOM.toString()))
            .jsonPath("$.[*].instantTom")
            .value(hasItem(DEFAULT_INSTANT_TOM.toString()))
            .jsonPath("$.[*].instantRequiredTom")
            .value(hasItem(DEFAULT_INSTANT_REQUIRED_TOM.toString()))
            .jsonPath("$.[*].zonedDateTimeTom")
            .value(hasItem(sameInstant(DEFAULT_ZONED_DATE_TIME_TOM)))
            .jsonPath("$.[*].zonedDateTimeRequiredTom")
            .value(hasItem(sameInstant(DEFAULT_ZONED_DATE_TIME_REQUIRED_TOM)))
            .jsonPath("$.[*].durationTom")
            .value(hasItem(DEFAULT_DURATION_TOM.toString()))
            .jsonPath("$.[*].durationRequiredTom")
            .value(hasItem(DEFAULT_DURATION_REQUIRED_TOM.toString()))
            .jsonPath("$.[*].booleanTom")
            .value(hasItem(DEFAULT_BOOLEAN_TOM.booleanValue()))
            .jsonPath("$.[*].booleanRequiredTom")
            .value(hasItem(DEFAULT_BOOLEAN_REQUIRED_TOM.booleanValue()))
            .jsonPath("$.[*].enumTom")
            .value(hasItem(DEFAULT_ENUM_TOM.toString()))
            .jsonPath("$.[*].enumRequiredTom")
            .value(hasItem(DEFAULT_ENUM_REQUIRED_TOM.toString()))
            .jsonPath("$.[*].uuidTom")
            .value(hasItem(DEFAULT_UUID_TOM.toString()))
            .jsonPath("$.[*].uuidRequiredTom")
            .value(hasItem(DEFAULT_UUID_REQUIRED_TOM.toString()))
            .jsonPath("$.[*].byteImageTomContentType")
            .value(hasItem(DEFAULT_BYTE_IMAGE_TOM_CONTENT_TYPE))
            .jsonPath("$.[*].byteImageTom")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_TOM)))
            .jsonPath("$.[*].byteImageRequiredTomContentType")
            .value(hasItem(DEFAULT_BYTE_IMAGE_REQUIRED_TOM_CONTENT_TYPE))
            .jsonPath("$.[*].byteImageRequiredTom")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_REQUIRED_TOM)))
            .jsonPath("$.[*].byteImageMinbytesTomContentType")
            .value(hasItem(DEFAULT_BYTE_IMAGE_MINBYTES_TOM_CONTENT_TYPE))
            .jsonPath("$.[*].byteImageMinbytesTom")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_MINBYTES_TOM)))
            .jsonPath("$.[*].byteImageMaxbytesTomContentType")
            .value(hasItem(DEFAULT_BYTE_IMAGE_MAXBYTES_TOM_CONTENT_TYPE))
            .jsonPath("$.[*].byteImageMaxbytesTom")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_MAXBYTES_TOM)))
            .jsonPath("$.[*].byteAnyTomContentType")
            .value(hasItem(DEFAULT_BYTE_ANY_TOM_CONTENT_TYPE))
            .jsonPath("$.[*].byteAnyTom")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_TOM)))
            .jsonPath("$.[*].byteAnyRequiredTomContentType")
            .value(hasItem(DEFAULT_BYTE_ANY_REQUIRED_TOM_CONTENT_TYPE))
            .jsonPath("$.[*].byteAnyRequiredTom")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_REQUIRED_TOM)))
            .jsonPath("$.[*].byteAnyMinbytesTomContentType")
            .value(hasItem(DEFAULT_BYTE_ANY_MINBYTES_TOM_CONTENT_TYPE))
            .jsonPath("$.[*].byteAnyMinbytesTom")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_MINBYTES_TOM)))
            .jsonPath("$.[*].byteAnyMaxbytesTomContentType")
            .value(hasItem(DEFAULT_BYTE_ANY_MAXBYTES_TOM_CONTENT_TYPE))
            .jsonPath("$.[*].byteAnyMaxbytesTom")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_MAXBYTES_TOM)))
            .jsonPath("$.[*].byteTextTom")
            .value(hasItem(DEFAULT_BYTE_TEXT_TOM.toString()))
            .jsonPath("$.[*].byteTextRequiredTom")
            .value(hasItem(DEFAULT_BYTE_TEXT_REQUIRED_TOM.toString()));
    }

    @Test
    void getFieldTestEntity() {
        // Initialize the database
        fieldTestEntityRepository.save(fieldTestEntity).block();

        // Get the fieldTestEntity
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, fieldTestEntity.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id")
            .value(is(fieldTestEntity.getId().intValue()))
            .jsonPath("$.stringTom")
            .value(is(DEFAULT_STRING_TOM))
            .jsonPath("$.stringRequiredTom")
            .value(is(DEFAULT_STRING_REQUIRED_TOM))
            .jsonPath("$.stringMinlengthTom")
            .value(is(DEFAULT_STRING_MINLENGTH_TOM))
            .jsonPath("$.stringMaxlengthTom")
            .value(is(DEFAULT_STRING_MAXLENGTH_TOM))
            .jsonPath("$.stringPatternTom")
            .value(is(DEFAULT_STRING_PATTERN_TOM))
            .jsonPath("$.numberPatternTom")
            .value(is(DEFAULT_NUMBER_PATTERN_TOM))
            .jsonPath("$.numberPatternRequiredTom")
            .value(is(DEFAULT_NUMBER_PATTERN_REQUIRED_TOM))
            .jsonPath("$.integerTom")
            .value(is(DEFAULT_INTEGER_TOM))
            .jsonPath("$.integerRequiredTom")
            .value(is(DEFAULT_INTEGER_REQUIRED_TOM))
            .jsonPath("$.integerMinTom")
            .value(is(DEFAULT_INTEGER_MIN_TOM))
            .jsonPath("$.integerMaxTom")
            .value(is(DEFAULT_INTEGER_MAX_TOM))
            .jsonPath("$.longTom")
            .value(is(DEFAULT_LONG_TOM.intValue()))
            .jsonPath("$.longRequiredTom")
            .value(is(DEFAULT_LONG_REQUIRED_TOM.intValue()))
            .jsonPath("$.longMinTom")
            .value(is(DEFAULT_LONG_MIN_TOM.intValue()))
            .jsonPath("$.longMaxTom")
            .value(is(DEFAULT_LONG_MAX_TOM.intValue()))
            .jsonPath("$.floatTom")
            .value(is(DEFAULT_FLOAT_TOM.doubleValue()))
            .jsonPath("$.floatRequiredTom")
            .value(is(DEFAULT_FLOAT_REQUIRED_TOM.doubleValue()))
            .jsonPath("$.floatMinTom")
            .value(is(DEFAULT_FLOAT_MIN_TOM.doubleValue()))
            .jsonPath("$.floatMaxTom")
            .value(is(DEFAULT_FLOAT_MAX_TOM.doubleValue()))
            .jsonPath("$.doubleRequiredTom")
            .value(is(DEFAULT_DOUBLE_REQUIRED_TOM.doubleValue()))
            .jsonPath("$.doubleMinTom")
            .value(is(DEFAULT_DOUBLE_MIN_TOM.doubleValue()))
            .jsonPath("$.doubleMaxTom")
            .value(is(DEFAULT_DOUBLE_MAX_TOM.doubleValue()))
            .jsonPath("$.bigDecimalRequiredTom")
            .value(is(sameNumber(DEFAULT_BIG_DECIMAL_REQUIRED_TOM)))
            .jsonPath("$.bigDecimalMinTom")
            .value(is(sameNumber(DEFAULT_BIG_DECIMAL_MIN_TOM)))
            .jsonPath("$.bigDecimalMaxTom")
            .value(is(sameNumber(DEFAULT_BIG_DECIMAL_MAX_TOM)))
            .jsonPath("$.localDateTom")
            .value(is(DEFAULT_LOCAL_DATE_TOM.toString()))
            .jsonPath("$.localDateRequiredTom")
            .value(is(DEFAULT_LOCAL_DATE_REQUIRED_TOM.toString()))
            .jsonPath("$.instantTom")
            .value(is(DEFAULT_INSTANT_TOM.toString()))
            .jsonPath("$.instantRequiredTom")
            .value(is(DEFAULT_INSTANT_REQUIRED_TOM.toString()))
            .jsonPath("$.zonedDateTimeTom")
            .value(is(sameInstant(DEFAULT_ZONED_DATE_TIME_TOM)))
            .jsonPath("$.zonedDateTimeRequiredTom")
            .value(is(sameInstant(DEFAULT_ZONED_DATE_TIME_REQUIRED_TOM)))
            .jsonPath("$.durationTom")
            .value(is(DEFAULT_DURATION_TOM.toString()))
            .jsonPath("$.durationRequiredTom")
            .value(is(DEFAULT_DURATION_REQUIRED_TOM.toString()))
            .jsonPath("$.booleanTom")
            .value(is(DEFAULT_BOOLEAN_TOM.booleanValue()))
            .jsonPath("$.booleanRequiredTom")
            .value(is(DEFAULT_BOOLEAN_REQUIRED_TOM.booleanValue()))
            .jsonPath("$.enumTom")
            .value(is(DEFAULT_ENUM_TOM.toString()))
            .jsonPath("$.enumRequiredTom")
            .value(is(DEFAULT_ENUM_REQUIRED_TOM.toString()))
            .jsonPath("$.uuidTom")
            .value(is(DEFAULT_UUID_TOM.toString()))
            .jsonPath("$.uuidRequiredTom")
            .value(is(DEFAULT_UUID_REQUIRED_TOM.toString()))
            .jsonPath("$.byteImageTomContentType")
            .value(is(DEFAULT_BYTE_IMAGE_TOM_CONTENT_TYPE))
            .jsonPath("$.byteImageTom")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_TOM)))
            .jsonPath("$.byteImageRequiredTomContentType")
            .value(is(DEFAULT_BYTE_IMAGE_REQUIRED_TOM_CONTENT_TYPE))
            .jsonPath("$.byteImageRequiredTom")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_REQUIRED_TOM)))
            .jsonPath("$.byteImageMinbytesTomContentType")
            .value(is(DEFAULT_BYTE_IMAGE_MINBYTES_TOM_CONTENT_TYPE))
            .jsonPath("$.byteImageMinbytesTom")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_MINBYTES_TOM)))
            .jsonPath("$.byteImageMaxbytesTomContentType")
            .value(is(DEFAULT_BYTE_IMAGE_MAXBYTES_TOM_CONTENT_TYPE))
            .jsonPath("$.byteImageMaxbytesTom")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_MAXBYTES_TOM)))
            .jsonPath("$.byteAnyTomContentType")
            .value(is(DEFAULT_BYTE_ANY_TOM_CONTENT_TYPE))
            .jsonPath("$.byteAnyTom")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_TOM)))
            .jsonPath("$.byteAnyRequiredTomContentType")
            .value(is(DEFAULT_BYTE_ANY_REQUIRED_TOM_CONTENT_TYPE))
            .jsonPath("$.byteAnyRequiredTom")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_REQUIRED_TOM)))
            .jsonPath("$.byteAnyMinbytesTomContentType")
            .value(is(DEFAULT_BYTE_ANY_MINBYTES_TOM_CONTENT_TYPE))
            .jsonPath("$.byteAnyMinbytesTom")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_MINBYTES_TOM)))
            .jsonPath("$.byteAnyMaxbytesTomContentType")
            .value(is(DEFAULT_BYTE_ANY_MAXBYTES_TOM_CONTENT_TYPE))
            .jsonPath("$.byteAnyMaxbytesTom")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_MAXBYTES_TOM)))
            .jsonPath("$.byteTextTom")
            .value(is(DEFAULT_BYTE_TEXT_TOM.toString()))
            .jsonPath("$.byteTextRequiredTom")
            .value(is(DEFAULT_BYTE_TEXT_REQUIRED_TOM.toString()));
    }

    @Test
    void getNonExistingFieldTestEntity() {
        // Get the fieldTestEntity
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putNewFieldTestEntity() throws Exception {
        // Initialize the database
        fieldTestEntityRepository.save(fieldTestEntity).block();

        int databaseSizeBeforeUpdate = fieldTestEntityRepository.findAll().collectList().block().size();

        // Update the fieldTestEntity
        FieldTestEntity updatedFieldTestEntity = fieldTestEntityRepository.findById(fieldTestEntity.getId()).block();
        updatedFieldTestEntity
            .stringTom(UPDATED_STRING_TOM)
            .stringRequiredTom(UPDATED_STRING_REQUIRED_TOM)
            .stringMinlengthTom(UPDATED_STRING_MINLENGTH_TOM)
            .stringMaxlengthTom(UPDATED_STRING_MAXLENGTH_TOM)
            .stringPatternTom(UPDATED_STRING_PATTERN_TOM)
            .numberPatternTom(UPDATED_NUMBER_PATTERN_TOM)
            .numberPatternRequiredTom(UPDATED_NUMBER_PATTERN_REQUIRED_TOM)
            .integerTom(UPDATED_INTEGER_TOM)
            .integerRequiredTom(UPDATED_INTEGER_REQUIRED_TOM)
            .integerMinTom(UPDATED_INTEGER_MIN_TOM)
            .integerMaxTom(UPDATED_INTEGER_MAX_TOM)
            .longTom(UPDATED_LONG_TOM)
            .longRequiredTom(UPDATED_LONG_REQUIRED_TOM)
            .longMinTom(UPDATED_LONG_MIN_TOM)
            .longMaxTom(UPDATED_LONG_MAX_TOM)
            .floatTom(UPDATED_FLOAT_TOM)
            .floatRequiredTom(UPDATED_FLOAT_REQUIRED_TOM)
            .floatMinTom(UPDATED_FLOAT_MIN_TOM)
            .floatMaxTom(UPDATED_FLOAT_MAX_TOM)
            .doubleRequiredTom(UPDATED_DOUBLE_REQUIRED_TOM)
            .doubleMinTom(UPDATED_DOUBLE_MIN_TOM)
            .doubleMaxTom(UPDATED_DOUBLE_MAX_TOM)
            .bigDecimalRequiredTom(UPDATED_BIG_DECIMAL_REQUIRED_TOM)
            .bigDecimalMinTom(UPDATED_BIG_DECIMAL_MIN_TOM)
            .bigDecimalMaxTom(UPDATED_BIG_DECIMAL_MAX_TOM)
            .localDateTom(UPDATED_LOCAL_DATE_TOM)
            .localDateRequiredTom(UPDATED_LOCAL_DATE_REQUIRED_TOM)
            .instantTom(UPDATED_INSTANT_TOM)
            .instantRequiredTom(UPDATED_INSTANT_REQUIRED_TOM)
            .zonedDateTimeTom(UPDATED_ZONED_DATE_TIME_TOM)
            .zonedDateTimeRequiredTom(UPDATED_ZONED_DATE_TIME_REQUIRED_TOM)
            .durationTom(UPDATED_DURATION_TOM)
            .durationRequiredTom(UPDATED_DURATION_REQUIRED_TOM)
            .booleanTom(UPDATED_BOOLEAN_TOM)
            .booleanRequiredTom(UPDATED_BOOLEAN_REQUIRED_TOM)
            .enumTom(UPDATED_ENUM_TOM)
            .enumRequiredTom(UPDATED_ENUM_REQUIRED_TOM)
            .uuidTom(UPDATED_UUID_TOM)
            .uuidRequiredTom(UPDATED_UUID_REQUIRED_TOM)
            .byteImageTom(UPDATED_BYTE_IMAGE_TOM)
            .byteImageTomContentType(UPDATED_BYTE_IMAGE_TOM_CONTENT_TYPE)
            .byteImageRequiredTom(UPDATED_BYTE_IMAGE_REQUIRED_TOM)
            .byteImageRequiredTomContentType(UPDATED_BYTE_IMAGE_REQUIRED_TOM_CONTENT_TYPE)
            .byteImageMinbytesTom(UPDATED_BYTE_IMAGE_MINBYTES_TOM)
            .byteImageMinbytesTomContentType(UPDATED_BYTE_IMAGE_MINBYTES_TOM_CONTENT_TYPE)
            .byteImageMaxbytesTom(UPDATED_BYTE_IMAGE_MAXBYTES_TOM)
            .byteImageMaxbytesTomContentType(UPDATED_BYTE_IMAGE_MAXBYTES_TOM_CONTENT_TYPE)
            .byteAnyTom(UPDATED_BYTE_ANY_TOM)
            .byteAnyTomContentType(UPDATED_BYTE_ANY_TOM_CONTENT_TYPE)
            .byteAnyRequiredTom(UPDATED_BYTE_ANY_REQUIRED_TOM)
            .byteAnyRequiredTomContentType(UPDATED_BYTE_ANY_REQUIRED_TOM_CONTENT_TYPE)
            .byteAnyMinbytesTom(UPDATED_BYTE_ANY_MINBYTES_TOM)
            .byteAnyMinbytesTomContentType(UPDATED_BYTE_ANY_MINBYTES_TOM_CONTENT_TYPE)
            .byteAnyMaxbytesTom(UPDATED_BYTE_ANY_MAXBYTES_TOM)
            .byteAnyMaxbytesTomContentType(UPDATED_BYTE_ANY_MAXBYTES_TOM_CONTENT_TYPE)
            .byteTextTom(UPDATED_BYTE_TEXT_TOM)
            .byteTextRequiredTom(UPDATED_BYTE_TEXT_REQUIRED_TOM);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, updatedFieldTestEntity.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(updatedFieldTestEntity))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the FieldTestEntity in the database
        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeUpdate);
        FieldTestEntity testFieldTestEntity = fieldTestEntityList.get(fieldTestEntityList.size() - 1);
        assertThat(testFieldTestEntity.getStringTom()).isEqualTo(UPDATED_STRING_TOM);
        assertThat(testFieldTestEntity.getStringRequiredTom()).isEqualTo(UPDATED_STRING_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getStringMinlengthTom()).isEqualTo(UPDATED_STRING_MINLENGTH_TOM);
        assertThat(testFieldTestEntity.getStringMaxlengthTom()).isEqualTo(UPDATED_STRING_MAXLENGTH_TOM);
        assertThat(testFieldTestEntity.getStringPatternTom()).isEqualTo(UPDATED_STRING_PATTERN_TOM);
        assertThat(testFieldTestEntity.getNumberPatternTom()).isEqualTo(UPDATED_NUMBER_PATTERN_TOM);
        assertThat(testFieldTestEntity.getNumberPatternRequiredTom()).isEqualTo(UPDATED_NUMBER_PATTERN_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getIntegerTom()).isEqualTo(UPDATED_INTEGER_TOM);
        assertThat(testFieldTestEntity.getIntegerRequiredTom()).isEqualTo(UPDATED_INTEGER_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getIntegerMinTom()).isEqualTo(UPDATED_INTEGER_MIN_TOM);
        assertThat(testFieldTestEntity.getIntegerMaxTom()).isEqualTo(UPDATED_INTEGER_MAX_TOM);
        assertThat(testFieldTestEntity.getLongTom()).isEqualTo(UPDATED_LONG_TOM);
        assertThat(testFieldTestEntity.getLongRequiredTom()).isEqualTo(UPDATED_LONG_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getLongMinTom()).isEqualTo(UPDATED_LONG_MIN_TOM);
        assertThat(testFieldTestEntity.getLongMaxTom()).isEqualTo(UPDATED_LONG_MAX_TOM);
        assertThat(testFieldTestEntity.getFloatTom()).isEqualTo(UPDATED_FLOAT_TOM);
        assertThat(testFieldTestEntity.getFloatRequiredTom()).isEqualTo(UPDATED_FLOAT_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getFloatMinTom()).isEqualTo(UPDATED_FLOAT_MIN_TOM);
        assertThat(testFieldTestEntity.getFloatMaxTom()).isEqualTo(UPDATED_FLOAT_MAX_TOM);
        assertThat(testFieldTestEntity.getDoubleRequiredTom()).isEqualTo(UPDATED_DOUBLE_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getDoubleMinTom()).isEqualTo(UPDATED_DOUBLE_MIN_TOM);
        assertThat(testFieldTestEntity.getDoubleMaxTom()).isEqualTo(UPDATED_DOUBLE_MAX_TOM);
        assertThat(testFieldTestEntity.getBigDecimalRequiredTom()).isEqualTo(UPDATED_BIG_DECIMAL_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getBigDecimalMinTom()).isEqualTo(UPDATED_BIG_DECIMAL_MIN_TOM);
        assertThat(testFieldTestEntity.getBigDecimalMaxTom()).isEqualTo(UPDATED_BIG_DECIMAL_MAX_TOM);
        assertThat(testFieldTestEntity.getLocalDateTom()).isEqualTo(UPDATED_LOCAL_DATE_TOM);
        assertThat(testFieldTestEntity.getLocalDateRequiredTom()).isEqualTo(UPDATED_LOCAL_DATE_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getInstantTom()).isEqualTo(UPDATED_INSTANT_TOM);
        assertThat(testFieldTestEntity.getInstantRequiredTom()).isEqualTo(UPDATED_INSTANT_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getZonedDateTimeTom()).isEqualTo(UPDATED_ZONED_DATE_TIME_TOM);
        assertThat(testFieldTestEntity.getZonedDateTimeRequiredTom()).isEqualTo(UPDATED_ZONED_DATE_TIME_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getDurationTom()).isEqualTo(UPDATED_DURATION_TOM);
        assertThat(testFieldTestEntity.getDurationRequiredTom()).isEqualTo(UPDATED_DURATION_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getBooleanTom()).isEqualTo(UPDATED_BOOLEAN_TOM);
        assertThat(testFieldTestEntity.getBooleanRequiredTom()).isEqualTo(UPDATED_BOOLEAN_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getEnumTom()).isEqualTo(UPDATED_ENUM_TOM);
        assertThat(testFieldTestEntity.getEnumRequiredTom()).isEqualTo(UPDATED_ENUM_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getUuidTom()).isEqualTo(UPDATED_UUID_TOM);
        assertThat(testFieldTestEntity.getUuidRequiredTom()).isEqualTo(UPDATED_UUID_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getByteImageTom()).isEqualTo(UPDATED_BYTE_IMAGE_TOM);
        assertThat(testFieldTestEntity.getByteImageTomContentType()).isEqualTo(UPDATED_BYTE_IMAGE_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteImageRequiredTom()).isEqualTo(UPDATED_BYTE_IMAGE_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getByteImageRequiredTomContentType()).isEqualTo(UPDATED_BYTE_IMAGE_REQUIRED_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteImageMinbytesTom()).isEqualTo(UPDATED_BYTE_IMAGE_MINBYTES_TOM);
        assertThat(testFieldTestEntity.getByteImageMinbytesTomContentType()).isEqualTo(UPDATED_BYTE_IMAGE_MINBYTES_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteImageMaxbytesTom()).isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_TOM);
        assertThat(testFieldTestEntity.getByteImageMaxbytesTomContentType()).isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteAnyTom()).isEqualTo(UPDATED_BYTE_ANY_TOM);
        assertThat(testFieldTestEntity.getByteAnyTomContentType()).isEqualTo(UPDATED_BYTE_ANY_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteAnyRequiredTom()).isEqualTo(UPDATED_BYTE_ANY_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getByteAnyRequiredTomContentType()).isEqualTo(UPDATED_BYTE_ANY_REQUIRED_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteAnyMinbytesTom()).isEqualTo(UPDATED_BYTE_ANY_MINBYTES_TOM);
        assertThat(testFieldTestEntity.getByteAnyMinbytesTomContentType()).isEqualTo(UPDATED_BYTE_ANY_MINBYTES_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteAnyMaxbytesTom()).isEqualTo(UPDATED_BYTE_ANY_MAXBYTES_TOM);
        assertThat(testFieldTestEntity.getByteAnyMaxbytesTomContentType()).isEqualTo(UPDATED_BYTE_ANY_MAXBYTES_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteTextTom()).isEqualTo(UPDATED_BYTE_TEXT_TOM);
        assertThat(testFieldTestEntity.getByteTextRequiredTom()).isEqualTo(UPDATED_BYTE_TEXT_REQUIRED_TOM);
    }

    @Test
    void putNonExistingFieldTestEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestEntityRepository.findAll().collectList().block().size();
        fieldTestEntity.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, fieldTestEntity.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestEntity in the database
        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchFieldTestEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestEntityRepository.findAll().collectList().block().size();
        fieldTestEntity.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestEntity in the database
        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamFieldTestEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestEntityRepository.findAll().collectList().block().size();
        fieldTestEntity.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the FieldTestEntity in the database
        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateFieldTestEntityWithPatch() throws Exception {
        // Initialize the database
        fieldTestEntityRepository.save(fieldTestEntity).block();

        int databaseSizeBeforeUpdate = fieldTestEntityRepository.findAll().collectList().block().size();

        // Update the fieldTestEntity using partial update
        FieldTestEntity partialUpdatedFieldTestEntity = new FieldTestEntity();
        partialUpdatedFieldTestEntity.setId(fieldTestEntity.getId());

        partialUpdatedFieldTestEntity
            .stringRequiredTom(UPDATED_STRING_REQUIRED_TOM)
            .stringMaxlengthTom(UPDATED_STRING_MAXLENGTH_TOM)
            .integerRequiredTom(UPDATED_INTEGER_REQUIRED_TOM)
            .integerMaxTom(UPDATED_INTEGER_MAX_TOM)
            .longRequiredTom(UPDATED_LONG_REQUIRED_TOM)
            .longMinTom(UPDATED_LONG_MIN_TOM)
            .floatRequiredTom(UPDATED_FLOAT_REQUIRED_TOM)
            .floatMinTom(UPDATED_FLOAT_MIN_TOM)
            .floatMaxTom(UPDATED_FLOAT_MAX_TOM)
            .doubleRequiredTom(UPDATED_DOUBLE_REQUIRED_TOM)
            .doubleMinTom(UPDATED_DOUBLE_MIN_TOM)
            .doubleMaxTom(UPDATED_DOUBLE_MAX_TOM)
            .bigDecimalRequiredTom(UPDATED_BIG_DECIMAL_REQUIRED_TOM)
            .localDateTom(UPDATED_LOCAL_DATE_TOM)
            .instantRequiredTom(UPDATED_INSTANT_REQUIRED_TOM)
            .enumTom(UPDATED_ENUM_TOM)
            .enumRequiredTom(UPDATED_ENUM_REQUIRED_TOM)
            .uuidTom(UPDATED_UUID_TOM)
            .uuidRequiredTom(UPDATED_UUID_REQUIRED_TOM)
            .byteImageRequiredTom(UPDATED_BYTE_IMAGE_REQUIRED_TOM)
            .byteImageRequiredTomContentType(UPDATED_BYTE_IMAGE_REQUIRED_TOM_CONTENT_TYPE)
            .byteImageMaxbytesTom(UPDATED_BYTE_IMAGE_MAXBYTES_TOM)
            .byteImageMaxbytesTomContentType(UPDATED_BYTE_IMAGE_MAXBYTES_TOM_CONTENT_TYPE)
            .byteAnyMinbytesTom(UPDATED_BYTE_ANY_MINBYTES_TOM)
            .byteAnyMinbytesTomContentType(UPDATED_BYTE_ANY_MINBYTES_TOM_CONTENT_TYPE)
            .byteTextTom(UPDATED_BYTE_TEXT_TOM)
            .byteTextRequiredTom(UPDATED_BYTE_TEXT_REQUIRED_TOM);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedFieldTestEntity.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedFieldTestEntity))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the FieldTestEntity in the database
        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeUpdate);
        FieldTestEntity testFieldTestEntity = fieldTestEntityList.get(fieldTestEntityList.size() - 1);
        assertThat(testFieldTestEntity.getStringTom()).isEqualTo(DEFAULT_STRING_TOM);
        assertThat(testFieldTestEntity.getStringRequiredTom()).isEqualTo(UPDATED_STRING_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getStringMinlengthTom()).isEqualTo(DEFAULT_STRING_MINLENGTH_TOM);
        assertThat(testFieldTestEntity.getStringMaxlengthTom()).isEqualTo(UPDATED_STRING_MAXLENGTH_TOM);
        assertThat(testFieldTestEntity.getStringPatternTom()).isEqualTo(DEFAULT_STRING_PATTERN_TOM);
        assertThat(testFieldTestEntity.getNumberPatternTom()).isEqualTo(DEFAULT_NUMBER_PATTERN_TOM);
        assertThat(testFieldTestEntity.getNumberPatternRequiredTom()).isEqualTo(DEFAULT_NUMBER_PATTERN_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getIntegerTom()).isEqualTo(DEFAULT_INTEGER_TOM);
        assertThat(testFieldTestEntity.getIntegerRequiredTom()).isEqualTo(UPDATED_INTEGER_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getIntegerMinTom()).isEqualTo(DEFAULT_INTEGER_MIN_TOM);
        assertThat(testFieldTestEntity.getIntegerMaxTom()).isEqualTo(UPDATED_INTEGER_MAX_TOM);
        assertThat(testFieldTestEntity.getLongTom()).isEqualTo(DEFAULT_LONG_TOM);
        assertThat(testFieldTestEntity.getLongRequiredTom()).isEqualTo(UPDATED_LONG_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getLongMinTom()).isEqualTo(UPDATED_LONG_MIN_TOM);
        assertThat(testFieldTestEntity.getLongMaxTom()).isEqualTo(DEFAULT_LONG_MAX_TOM);
        assertThat(testFieldTestEntity.getFloatTom()).isEqualTo(DEFAULT_FLOAT_TOM);
        assertThat(testFieldTestEntity.getFloatRequiredTom()).isEqualTo(UPDATED_FLOAT_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getFloatMinTom()).isEqualTo(UPDATED_FLOAT_MIN_TOM);
        assertThat(testFieldTestEntity.getFloatMaxTom()).isEqualTo(UPDATED_FLOAT_MAX_TOM);
        assertThat(testFieldTestEntity.getDoubleRequiredTom()).isEqualTo(UPDATED_DOUBLE_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getDoubleMinTom()).isEqualTo(UPDATED_DOUBLE_MIN_TOM);
        assertThat(testFieldTestEntity.getDoubleMaxTom()).isEqualTo(UPDATED_DOUBLE_MAX_TOM);
        assertThat(testFieldTestEntity.getBigDecimalRequiredTom()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getBigDecimalMinTom()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MIN_TOM);
        assertThat(testFieldTestEntity.getBigDecimalMaxTom()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MAX_TOM);
        assertThat(testFieldTestEntity.getLocalDateTom()).isEqualTo(UPDATED_LOCAL_DATE_TOM);
        assertThat(testFieldTestEntity.getLocalDateRequiredTom()).isEqualTo(DEFAULT_LOCAL_DATE_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getInstantTom()).isEqualTo(DEFAULT_INSTANT_TOM);
        assertThat(testFieldTestEntity.getInstantRequiredTom()).isEqualTo(UPDATED_INSTANT_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getZonedDateTimeTom()).isEqualTo(DEFAULT_ZONED_DATE_TIME_TOM);
        assertThat(testFieldTestEntity.getZonedDateTimeRequiredTom()).isEqualTo(DEFAULT_ZONED_DATE_TIME_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getDurationTom()).isEqualTo(DEFAULT_DURATION_TOM);
        assertThat(testFieldTestEntity.getDurationRequiredTom()).isEqualTo(DEFAULT_DURATION_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getBooleanTom()).isEqualTo(DEFAULT_BOOLEAN_TOM);
        assertThat(testFieldTestEntity.getBooleanRequiredTom()).isEqualTo(DEFAULT_BOOLEAN_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getEnumTom()).isEqualTo(UPDATED_ENUM_TOM);
        assertThat(testFieldTestEntity.getEnumRequiredTom()).isEqualTo(UPDATED_ENUM_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getUuidTom()).isEqualTo(UPDATED_UUID_TOM);
        assertThat(testFieldTestEntity.getUuidRequiredTom()).isEqualTo(UPDATED_UUID_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getByteImageTom()).isEqualTo(DEFAULT_BYTE_IMAGE_TOM);
        assertThat(testFieldTestEntity.getByteImageTomContentType()).isEqualTo(DEFAULT_BYTE_IMAGE_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteImageRequiredTom()).isEqualTo(UPDATED_BYTE_IMAGE_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getByteImageRequiredTomContentType()).isEqualTo(UPDATED_BYTE_IMAGE_REQUIRED_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteImageMinbytesTom()).isEqualTo(DEFAULT_BYTE_IMAGE_MINBYTES_TOM);
        assertThat(testFieldTestEntity.getByteImageMinbytesTomContentType()).isEqualTo(DEFAULT_BYTE_IMAGE_MINBYTES_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteImageMaxbytesTom()).isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_TOM);
        assertThat(testFieldTestEntity.getByteImageMaxbytesTomContentType()).isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteAnyTom()).isEqualTo(DEFAULT_BYTE_ANY_TOM);
        assertThat(testFieldTestEntity.getByteAnyTomContentType()).isEqualTo(DEFAULT_BYTE_ANY_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteAnyRequiredTom()).isEqualTo(DEFAULT_BYTE_ANY_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getByteAnyRequiredTomContentType()).isEqualTo(DEFAULT_BYTE_ANY_REQUIRED_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteAnyMinbytesTom()).isEqualTo(UPDATED_BYTE_ANY_MINBYTES_TOM);
        assertThat(testFieldTestEntity.getByteAnyMinbytesTomContentType()).isEqualTo(UPDATED_BYTE_ANY_MINBYTES_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteAnyMaxbytesTom()).isEqualTo(DEFAULT_BYTE_ANY_MAXBYTES_TOM);
        assertThat(testFieldTestEntity.getByteAnyMaxbytesTomContentType()).isEqualTo(DEFAULT_BYTE_ANY_MAXBYTES_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteTextTom()).isEqualTo(UPDATED_BYTE_TEXT_TOM);
        assertThat(testFieldTestEntity.getByteTextRequiredTom()).isEqualTo(UPDATED_BYTE_TEXT_REQUIRED_TOM);
    }

    @Test
    void fullUpdateFieldTestEntityWithPatch() throws Exception {
        // Initialize the database
        fieldTestEntityRepository.save(fieldTestEntity).block();

        int databaseSizeBeforeUpdate = fieldTestEntityRepository.findAll().collectList().block().size();

        // Update the fieldTestEntity using partial update
        FieldTestEntity partialUpdatedFieldTestEntity = new FieldTestEntity();
        partialUpdatedFieldTestEntity.setId(fieldTestEntity.getId());

        partialUpdatedFieldTestEntity
            .stringTom(UPDATED_STRING_TOM)
            .stringRequiredTom(UPDATED_STRING_REQUIRED_TOM)
            .stringMinlengthTom(UPDATED_STRING_MINLENGTH_TOM)
            .stringMaxlengthTom(UPDATED_STRING_MAXLENGTH_TOM)
            .stringPatternTom(UPDATED_STRING_PATTERN_TOM)
            .numberPatternTom(UPDATED_NUMBER_PATTERN_TOM)
            .numberPatternRequiredTom(UPDATED_NUMBER_PATTERN_REQUIRED_TOM)
            .integerTom(UPDATED_INTEGER_TOM)
            .integerRequiredTom(UPDATED_INTEGER_REQUIRED_TOM)
            .integerMinTom(UPDATED_INTEGER_MIN_TOM)
            .integerMaxTom(UPDATED_INTEGER_MAX_TOM)
            .longTom(UPDATED_LONG_TOM)
            .longRequiredTom(UPDATED_LONG_REQUIRED_TOM)
            .longMinTom(UPDATED_LONG_MIN_TOM)
            .longMaxTom(UPDATED_LONG_MAX_TOM)
            .floatTom(UPDATED_FLOAT_TOM)
            .floatRequiredTom(UPDATED_FLOAT_REQUIRED_TOM)
            .floatMinTom(UPDATED_FLOAT_MIN_TOM)
            .floatMaxTom(UPDATED_FLOAT_MAX_TOM)
            .doubleRequiredTom(UPDATED_DOUBLE_REQUIRED_TOM)
            .doubleMinTom(UPDATED_DOUBLE_MIN_TOM)
            .doubleMaxTom(UPDATED_DOUBLE_MAX_TOM)
            .bigDecimalRequiredTom(UPDATED_BIG_DECIMAL_REQUIRED_TOM)
            .bigDecimalMinTom(UPDATED_BIG_DECIMAL_MIN_TOM)
            .bigDecimalMaxTom(UPDATED_BIG_DECIMAL_MAX_TOM)
            .localDateTom(UPDATED_LOCAL_DATE_TOM)
            .localDateRequiredTom(UPDATED_LOCAL_DATE_REQUIRED_TOM)
            .instantTom(UPDATED_INSTANT_TOM)
            .instantRequiredTom(UPDATED_INSTANT_REQUIRED_TOM)
            .zonedDateTimeTom(UPDATED_ZONED_DATE_TIME_TOM)
            .zonedDateTimeRequiredTom(UPDATED_ZONED_DATE_TIME_REQUIRED_TOM)
            .durationTom(UPDATED_DURATION_TOM)
            .durationRequiredTom(UPDATED_DURATION_REQUIRED_TOM)
            .booleanTom(UPDATED_BOOLEAN_TOM)
            .booleanRequiredTom(UPDATED_BOOLEAN_REQUIRED_TOM)
            .enumTom(UPDATED_ENUM_TOM)
            .enumRequiredTom(UPDATED_ENUM_REQUIRED_TOM)
            .uuidTom(UPDATED_UUID_TOM)
            .uuidRequiredTom(UPDATED_UUID_REQUIRED_TOM)
            .byteImageTom(UPDATED_BYTE_IMAGE_TOM)
            .byteImageTomContentType(UPDATED_BYTE_IMAGE_TOM_CONTENT_TYPE)
            .byteImageRequiredTom(UPDATED_BYTE_IMAGE_REQUIRED_TOM)
            .byteImageRequiredTomContentType(UPDATED_BYTE_IMAGE_REQUIRED_TOM_CONTENT_TYPE)
            .byteImageMinbytesTom(UPDATED_BYTE_IMAGE_MINBYTES_TOM)
            .byteImageMinbytesTomContentType(UPDATED_BYTE_IMAGE_MINBYTES_TOM_CONTENT_TYPE)
            .byteImageMaxbytesTom(UPDATED_BYTE_IMAGE_MAXBYTES_TOM)
            .byteImageMaxbytesTomContentType(UPDATED_BYTE_IMAGE_MAXBYTES_TOM_CONTENT_TYPE)
            .byteAnyTom(UPDATED_BYTE_ANY_TOM)
            .byteAnyTomContentType(UPDATED_BYTE_ANY_TOM_CONTENT_TYPE)
            .byteAnyRequiredTom(UPDATED_BYTE_ANY_REQUIRED_TOM)
            .byteAnyRequiredTomContentType(UPDATED_BYTE_ANY_REQUIRED_TOM_CONTENT_TYPE)
            .byteAnyMinbytesTom(UPDATED_BYTE_ANY_MINBYTES_TOM)
            .byteAnyMinbytesTomContentType(UPDATED_BYTE_ANY_MINBYTES_TOM_CONTENT_TYPE)
            .byteAnyMaxbytesTom(UPDATED_BYTE_ANY_MAXBYTES_TOM)
            .byteAnyMaxbytesTomContentType(UPDATED_BYTE_ANY_MAXBYTES_TOM_CONTENT_TYPE)
            .byteTextTom(UPDATED_BYTE_TEXT_TOM)
            .byteTextRequiredTom(UPDATED_BYTE_TEXT_REQUIRED_TOM);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedFieldTestEntity.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedFieldTestEntity))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the FieldTestEntity in the database
        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeUpdate);
        FieldTestEntity testFieldTestEntity = fieldTestEntityList.get(fieldTestEntityList.size() - 1);
        assertThat(testFieldTestEntity.getStringTom()).isEqualTo(UPDATED_STRING_TOM);
        assertThat(testFieldTestEntity.getStringRequiredTom()).isEqualTo(UPDATED_STRING_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getStringMinlengthTom()).isEqualTo(UPDATED_STRING_MINLENGTH_TOM);
        assertThat(testFieldTestEntity.getStringMaxlengthTom()).isEqualTo(UPDATED_STRING_MAXLENGTH_TOM);
        assertThat(testFieldTestEntity.getStringPatternTom()).isEqualTo(UPDATED_STRING_PATTERN_TOM);
        assertThat(testFieldTestEntity.getNumberPatternTom()).isEqualTo(UPDATED_NUMBER_PATTERN_TOM);
        assertThat(testFieldTestEntity.getNumberPatternRequiredTom()).isEqualTo(UPDATED_NUMBER_PATTERN_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getIntegerTom()).isEqualTo(UPDATED_INTEGER_TOM);
        assertThat(testFieldTestEntity.getIntegerRequiredTom()).isEqualTo(UPDATED_INTEGER_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getIntegerMinTom()).isEqualTo(UPDATED_INTEGER_MIN_TOM);
        assertThat(testFieldTestEntity.getIntegerMaxTom()).isEqualTo(UPDATED_INTEGER_MAX_TOM);
        assertThat(testFieldTestEntity.getLongTom()).isEqualTo(UPDATED_LONG_TOM);
        assertThat(testFieldTestEntity.getLongRequiredTom()).isEqualTo(UPDATED_LONG_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getLongMinTom()).isEqualTo(UPDATED_LONG_MIN_TOM);
        assertThat(testFieldTestEntity.getLongMaxTom()).isEqualTo(UPDATED_LONG_MAX_TOM);
        assertThat(testFieldTestEntity.getFloatTom()).isEqualTo(UPDATED_FLOAT_TOM);
        assertThat(testFieldTestEntity.getFloatRequiredTom()).isEqualTo(UPDATED_FLOAT_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getFloatMinTom()).isEqualTo(UPDATED_FLOAT_MIN_TOM);
        assertThat(testFieldTestEntity.getFloatMaxTom()).isEqualTo(UPDATED_FLOAT_MAX_TOM);
        assertThat(testFieldTestEntity.getDoubleRequiredTom()).isEqualTo(UPDATED_DOUBLE_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getDoubleMinTom()).isEqualTo(UPDATED_DOUBLE_MIN_TOM);
        assertThat(testFieldTestEntity.getDoubleMaxTom()).isEqualTo(UPDATED_DOUBLE_MAX_TOM);
        assertThat(testFieldTestEntity.getBigDecimalRequiredTom()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getBigDecimalMinTom()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MIN_TOM);
        assertThat(testFieldTestEntity.getBigDecimalMaxTom()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MAX_TOM);
        assertThat(testFieldTestEntity.getLocalDateTom()).isEqualTo(UPDATED_LOCAL_DATE_TOM);
        assertThat(testFieldTestEntity.getLocalDateRequiredTom()).isEqualTo(UPDATED_LOCAL_DATE_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getInstantTom()).isEqualTo(UPDATED_INSTANT_TOM);
        assertThat(testFieldTestEntity.getInstantRequiredTom()).isEqualTo(UPDATED_INSTANT_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getZonedDateTimeTom()).isEqualTo(UPDATED_ZONED_DATE_TIME_TOM);
        assertThat(testFieldTestEntity.getZonedDateTimeRequiredTom()).isEqualTo(UPDATED_ZONED_DATE_TIME_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getDurationTom()).isEqualTo(UPDATED_DURATION_TOM);
        assertThat(testFieldTestEntity.getDurationRequiredTom()).isEqualTo(UPDATED_DURATION_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getBooleanTom()).isEqualTo(UPDATED_BOOLEAN_TOM);
        assertThat(testFieldTestEntity.getBooleanRequiredTom()).isEqualTo(UPDATED_BOOLEAN_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getEnumTom()).isEqualTo(UPDATED_ENUM_TOM);
        assertThat(testFieldTestEntity.getEnumRequiredTom()).isEqualTo(UPDATED_ENUM_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getUuidTom()).isEqualTo(UPDATED_UUID_TOM);
        assertThat(testFieldTestEntity.getUuidRequiredTom()).isEqualTo(UPDATED_UUID_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getByteImageTom()).isEqualTo(UPDATED_BYTE_IMAGE_TOM);
        assertThat(testFieldTestEntity.getByteImageTomContentType()).isEqualTo(UPDATED_BYTE_IMAGE_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteImageRequiredTom()).isEqualTo(UPDATED_BYTE_IMAGE_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getByteImageRequiredTomContentType()).isEqualTo(UPDATED_BYTE_IMAGE_REQUIRED_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteImageMinbytesTom()).isEqualTo(UPDATED_BYTE_IMAGE_MINBYTES_TOM);
        assertThat(testFieldTestEntity.getByteImageMinbytesTomContentType()).isEqualTo(UPDATED_BYTE_IMAGE_MINBYTES_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteImageMaxbytesTom()).isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_TOM);
        assertThat(testFieldTestEntity.getByteImageMaxbytesTomContentType()).isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteAnyTom()).isEqualTo(UPDATED_BYTE_ANY_TOM);
        assertThat(testFieldTestEntity.getByteAnyTomContentType()).isEqualTo(UPDATED_BYTE_ANY_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteAnyRequiredTom()).isEqualTo(UPDATED_BYTE_ANY_REQUIRED_TOM);
        assertThat(testFieldTestEntity.getByteAnyRequiredTomContentType()).isEqualTo(UPDATED_BYTE_ANY_REQUIRED_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteAnyMinbytesTom()).isEqualTo(UPDATED_BYTE_ANY_MINBYTES_TOM);
        assertThat(testFieldTestEntity.getByteAnyMinbytesTomContentType()).isEqualTo(UPDATED_BYTE_ANY_MINBYTES_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteAnyMaxbytesTom()).isEqualTo(UPDATED_BYTE_ANY_MAXBYTES_TOM);
        assertThat(testFieldTestEntity.getByteAnyMaxbytesTomContentType()).isEqualTo(UPDATED_BYTE_ANY_MAXBYTES_TOM_CONTENT_TYPE);
        assertThat(testFieldTestEntity.getByteTextTom()).isEqualTo(UPDATED_BYTE_TEXT_TOM);
        assertThat(testFieldTestEntity.getByteTextRequiredTom()).isEqualTo(UPDATED_BYTE_TEXT_REQUIRED_TOM);
    }

    @Test
    void patchNonExistingFieldTestEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestEntityRepository.findAll().collectList().block().size();
        fieldTestEntity.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, fieldTestEntity.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestEntity in the database
        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchFieldTestEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestEntityRepository.findAll().collectList().block().size();
        fieldTestEntity.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestEntity in the database
        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamFieldTestEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestEntityRepository.findAll().collectList().block().size();
        fieldTestEntity.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestEntity))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the FieldTestEntity in the database
        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteFieldTestEntity() {
        // Initialize the database
        fieldTestEntityRepository.save(fieldTestEntity).block();

        int databaseSizeBeforeDelete = fieldTestEntityRepository.findAll().collectList().block().size();

        // Delete the fieldTestEntity
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, fieldTestEntity.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<FieldTestEntity> fieldTestEntityList = fieldTestEntityRepository.findAll().collectList().block();
        assertThat(fieldTestEntityList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
