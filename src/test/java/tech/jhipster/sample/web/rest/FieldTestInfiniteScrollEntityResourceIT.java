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
import tech.jhipster.sample.domain.FieldTestInfiniteScrollEntity;
import tech.jhipster.sample.domain.enumeration.EnumFieldClass;
import tech.jhipster.sample.domain.enumeration.EnumRequiredFieldClass;
import tech.jhipster.sample.repository.FieldTestInfiniteScrollEntityRepository;
import tech.jhipster.sample.service.EntityManager;

/**
 * Integration tests for the {@link FieldTestInfiniteScrollEntityResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient
@WithMockUser
class FieldTestInfiniteScrollEntityResourceIT {

    private static final String DEFAULT_STRING_HUGO = "AAAAAAAAAA";
    private static final String UPDATED_STRING_HUGO = "BBBBBBBBBB";

    private static final String DEFAULT_STRING_REQUIRED_HUGO = "AAAAAAAAAA";
    private static final String UPDATED_STRING_REQUIRED_HUGO = "BBBBBBBBBB";

    private static final String DEFAULT_STRING_MINLENGTH_HUGO = "AAAAAAAAAA";
    private static final String UPDATED_STRING_MINLENGTH_HUGO = "BBBBBBBBBB";

    private static final String DEFAULT_STRING_MAXLENGTH_HUGO = "AAAAAAAAAA";
    private static final String UPDATED_STRING_MAXLENGTH_HUGO = "BBBBBBBBBB";

    private static final String DEFAULT_STRING_PATTERN_HUGO = "AAAAAAAAAA";
    private static final String UPDATED_STRING_PATTERN_HUGO = "BBBBBBBBBB";

    private static final Integer DEFAULT_INTEGER_HUGO = 1;
    private static final Integer UPDATED_INTEGER_HUGO = 2;

    private static final Integer DEFAULT_INTEGER_REQUIRED_HUGO = 1;
    private static final Integer UPDATED_INTEGER_REQUIRED_HUGO = 2;

    private static final Integer DEFAULT_INTEGER_MIN_HUGO = 0;
    private static final Integer UPDATED_INTEGER_MIN_HUGO = 1;

    private static final Integer DEFAULT_INTEGER_MAX_HUGO = 100;
    private static final Integer UPDATED_INTEGER_MAX_HUGO = 99;

    private static final Long DEFAULT_LONG_HUGO = 1L;
    private static final Long UPDATED_LONG_HUGO = 2L;

    private static final Long DEFAULT_LONG_REQUIRED_HUGO = 1L;
    private static final Long UPDATED_LONG_REQUIRED_HUGO = 2L;

    private static final Long DEFAULT_LONG_MIN_HUGO = 0L;
    private static final Long UPDATED_LONG_MIN_HUGO = 1L;

    private static final Long DEFAULT_LONG_MAX_HUGO = 100L;
    private static final Long UPDATED_LONG_MAX_HUGO = 99L;

    private static final Float DEFAULT_FLOAT_HUGO = 1F;
    private static final Float UPDATED_FLOAT_HUGO = 2F;

    private static final Float DEFAULT_FLOAT_REQUIRED_HUGO = 1F;
    private static final Float UPDATED_FLOAT_REQUIRED_HUGO = 2F;

    private static final Float DEFAULT_FLOAT_MIN_HUGO = 0F;
    private static final Float UPDATED_FLOAT_MIN_HUGO = 1F;

    private static final Float DEFAULT_FLOAT_MAX_HUGO = 100F;
    private static final Float UPDATED_FLOAT_MAX_HUGO = 99F;

    private static final Double DEFAULT_DOUBLE_REQUIRED_HUGO = 1D;
    private static final Double UPDATED_DOUBLE_REQUIRED_HUGO = 2D;

    private static final Double DEFAULT_DOUBLE_MIN_HUGO = 0D;
    private static final Double UPDATED_DOUBLE_MIN_HUGO = 1D;

    private static final Double DEFAULT_DOUBLE_MAX_HUGO = 100D;
    private static final Double UPDATED_DOUBLE_MAX_HUGO = 99D;

    private static final BigDecimal DEFAULT_BIG_DECIMAL_REQUIRED_HUGO = new BigDecimal(1);
    private static final BigDecimal UPDATED_BIG_DECIMAL_REQUIRED_HUGO = new BigDecimal(2);

    private static final BigDecimal DEFAULT_BIG_DECIMAL_MIN_HUGO = new BigDecimal(0);
    private static final BigDecimal UPDATED_BIG_DECIMAL_MIN_HUGO = new BigDecimal(1);

    private static final BigDecimal DEFAULT_BIG_DECIMAL_MAX_HUGO = new BigDecimal(100);
    private static final BigDecimal UPDATED_BIG_DECIMAL_MAX_HUGO = new BigDecimal(99);

    private static final LocalDate DEFAULT_LOCAL_DATE_HUGO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LOCAL_DATE_HUGO = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_LOCAL_DATE_REQUIRED_HUGO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LOCAL_DATE_REQUIRED_HUGO = LocalDate.now(ZoneId.systemDefault());

    private static final Instant DEFAULT_INSTANT_HUGO = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_INSTANT_HUGO = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_INSTANTE_REQUIRED_HUGO = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_INSTANTE_REQUIRED_HUGO = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final ZonedDateTime DEFAULT_ZONED_DATE_TIME_HUGO = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_ZONED_DATE_TIME_HUGO = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_ZONED_DATE_TIME_REQUIRED_HUGO = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_ZONED_DATE_TIME_REQUIRED_HUGO = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final Duration DEFAULT_DURATION_HUGO = Duration.ofHours(6);
    private static final Duration UPDATED_DURATION_HUGO = Duration.ofHours(12);

    private static final Duration DEFAULT_DURATION_REQUIRED_HUGO = Duration.ofHours(6);
    private static final Duration UPDATED_DURATION_REQUIRED_HUGO = Duration.ofHours(12);

    private static final Boolean DEFAULT_BOOLEAN_HUGO = false;
    private static final Boolean UPDATED_BOOLEAN_HUGO = true;

    private static final Boolean DEFAULT_BOOLEAN_REQUIRED_HUGO = false;
    private static final Boolean UPDATED_BOOLEAN_REQUIRED_HUGO = true;

    private static final EnumFieldClass DEFAULT_ENUM_HUGO = EnumFieldClass.ENUM_VALUE_1;
    private static final EnumFieldClass UPDATED_ENUM_HUGO = EnumFieldClass.ENUM_VALUE_2;

    private static final EnumRequiredFieldClass DEFAULT_ENUM_REQUIRED_HUGO = EnumRequiredFieldClass.ENUM_VALUE_1;
    private static final EnumRequiredFieldClass UPDATED_ENUM_REQUIRED_HUGO = EnumRequiredFieldClass.ENUM_VALUE_2;

    private static final UUID DEFAULT_UUID_HUGO = UUID.randomUUID();
    private static final UUID UPDATED_UUID_HUGO = UUID.randomUUID();

    private static final UUID DEFAULT_UUID_REQUIRED_HUGO = UUID.randomUUID();
    private static final UUID UPDATED_UUID_REQUIRED_HUGO = UUID.randomUUID();

    private static final byte[] DEFAULT_BYTE_IMAGE_HUGO = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_IMAGE_HUGO = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_IMAGE_HUGO_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_IMAGE_HUGO_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_IMAGE_REQUIRED_HUGO = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_IMAGE_REQUIRED_HUGO = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_IMAGE_REQUIRED_HUGO_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_IMAGE_REQUIRED_HUGO_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_IMAGE_MINBYTES_HUGO = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_IMAGE_MINBYTES_HUGO = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_IMAGE_MINBYTES_HUGO_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_IMAGE_MINBYTES_HUGO_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_IMAGE_MAXBYTES_HUGO = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_IMAGE_MAXBYTES_HUGO = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_IMAGE_MAXBYTES_HUGO_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_IMAGE_MAXBYTES_HUGO_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_ANY_HUGO = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_ANY_HUGO = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_ANY_HUGO_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_ANY_HUGO_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_ANY_REQUIRED_HUGO = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_ANY_REQUIRED_HUGO = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_ANY_REQUIRED_HUGO_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_ANY_REQUIRED_HUGO_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_ANY_MINBYTES_HUGO = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_ANY_MINBYTES_HUGO = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_ANY_MINBYTES_HUGO_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_ANY_MINBYTES_HUGO_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_ANY_MAXBYTES_HUGO = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_ANY_MAXBYTES_HUGO = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_ANY_MAXBYTES_HUGO_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_ANY_MAXBYTES_HUGO_CONTENT_TYPE = "image/png";

    private static final String DEFAULT_BYTE_TEXT_HUGO = "AAAAAAAAAA";
    private static final String UPDATED_BYTE_TEXT_HUGO = "BBBBBBBBBB";

    private static final String DEFAULT_BYTE_TEXT_REQUIRED_HUGO = "AAAAAAAAAA";
    private static final String UPDATED_BYTE_TEXT_REQUIRED_HUGO = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/field-test-infinite-scroll-entities";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private FieldTestInfiniteScrollEntityRepository fieldTestInfiniteScrollEntityRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private FieldTestInfiniteScrollEntity fieldTestInfiniteScrollEntity;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FieldTestInfiniteScrollEntity createEntity(EntityManager em) {
        FieldTestInfiniteScrollEntity fieldTestInfiniteScrollEntity = new FieldTestInfiniteScrollEntity()
            .stringHugo(DEFAULT_STRING_HUGO)
            .stringRequiredHugo(DEFAULT_STRING_REQUIRED_HUGO)
            .stringMinlengthHugo(DEFAULT_STRING_MINLENGTH_HUGO)
            .stringMaxlengthHugo(DEFAULT_STRING_MAXLENGTH_HUGO)
            .stringPatternHugo(DEFAULT_STRING_PATTERN_HUGO)
            .integerHugo(DEFAULT_INTEGER_HUGO)
            .integerRequiredHugo(DEFAULT_INTEGER_REQUIRED_HUGO)
            .integerMinHugo(DEFAULT_INTEGER_MIN_HUGO)
            .integerMaxHugo(DEFAULT_INTEGER_MAX_HUGO)
            .longHugo(DEFAULT_LONG_HUGO)
            .longRequiredHugo(DEFAULT_LONG_REQUIRED_HUGO)
            .longMinHugo(DEFAULT_LONG_MIN_HUGO)
            .longMaxHugo(DEFAULT_LONG_MAX_HUGO)
            .floatHugo(DEFAULT_FLOAT_HUGO)
            .floatRequiredHugo(DEFAULT_FLOAT_REQUIRED_HUGO)
            .floatMinHugo(DEFAULT_FLOAT_MIN_HUGO)
            .floatMaxHugo(DEFAULT_FLOAT_MAX_HUGO)
            .doubleRequiredHugo(DEFAULT_DOUBLE_REQUIRED_HUGO)
            .doubleMinHugo(DEFAULT_DOUBLE_MIN_HUGO)
            .doubleMaxHugo(DEFAULT_DOUBLE_MAX_HUGO)
            .bigDecimalRequiredHugo(DEFAULT_BIG_DECIMAL_REQUIRED_HUGO)
            .bigDecimalMinHugo(DEFAULT_BIG_DECIMAL_MIN_HUGO)
            .bigDecimalMaxHugo(DEFAULT_BIG_DECIMAL_MAX_HUGO)
            .localDateHugo(DEFAULT_LOCAL_DATE_HUGO)
            .localDateRequiredHugo(DEFAULT_LOCAL_DATE_REQUIRED_HUGO)
            .instantHugo(DEFAULT_INSTANT_HUGO)
            .instanteRequiredHugo(DEFAULT_INSTANTE_REQUIRED_HUGO)
            .zonedDateTimeHugo(DEFAULT_ZONED_DATE_TIME_HUGO)
            .zonedDateTimeRequiredHugo(DEFAULT_ZONED_DATE_TIME_REQUIRED_HUGO)
            .durationHugo(DEFAULT_DURATION_HUGO)
            .durationRequiredHugo(DEFAULT_DURATION_REQUIRED_HUGO)
            .booleanHugo(DEFAULT_BOOLEAN_HUGO)
            .booleanRequiredHugo(DEFAULT_BOOLEAN_REQUIRED_HUGO)
            .enumHugo(DEFAULT_ENUM_HUGO)
            .enumRequiredHugo(DEFAULT_ENUM_REQUIRED_HUGO)
            .uuidHugo(DEFAULT_UUID_HUGO)
            .uuidRequiredHugo(DEFAULT_UUID_REQUIRED_HUGO)
            .byteImageHugo(DEFAULT_BYTE_IMAGE_HUGO)
            .byteImageHugoContentType(DEFAULT_BYTE_IMAGE_HUGO_CONTENT_TYPE)
            .byteImageRequiredHugo(DEFAULT_BYTE_IMAGE_REQUIRED_HUGO)
            .byteImageRequiredHugoContentType(DEFAULT_BYTE_IMAGE_REQUIRED_HUGO_CONTENT_TYPE)
            .byteImageMinbytesHugo(DEFAULT_BYTE_IMAGE_MINBYTES_HUGO)
            .byteImageMinbytesHugoContentType(DEFAULT_BYTE_IMAGE_MINBYTES_HUGO_CONTENT_TYPE)
            .byteImageMaxbytesHugo(DEFAULT_BYTE_IMAGE_MAXBYTES_HUGO)
            .byteImageMaxbytesHugoContentType(DEFAULT_BYTE_IMAGE_MAXBYTES_HUGO_CONTENT_TYPE)
            .byteAnyHugo(DEFAULT_BYTE_ANY_HUGO)
            .byteAnyHugoContentType(DEFAULT_BYTE_ANY_HUGO_CONTENT_TYPE)
            .byteAnyRequiredHugo(DEFAULT_BYTE_ANY_REQUIRED_HUGO)
            .byteAnyRequiredHugoContentType(DEFAULT_BYTE_ANY_REQUIRED_HUGO_CONTENT_TYPE)
            .byteAnyMinbytesHugo(DEFAULT_BYTE_ANY_MINBYTES_HUGO)
            .byteAnyMinbytesHugoContentType(DEFAULT_BYTE_ANY_MINBYTES_HUGO_CONTENT_TYPE)
            .byteAnyMaxbytesHugo(DEFAULT_BYTE_ANY_MAXBYTES_HUGO)
            .byteAnyMaxbytesHugoContentType(DEFAULT_BYTE_ANY_MAXBYTES_HUGO_CONTENT_TYPE)
            .byteTextHugo(DEFAULT_BYTE_TEXT_HUGO)
            .byteTextRequiredHugo(DEFAULT_BYTE_TEXT_REQUIRED_HUGO);
        return fieldTestInfiniteScrollEntity;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FieldTestInfiniteScrollEntity createUpdatedEntity(EntityManager em) {
        FieldTestInfiniteScrollEntity fieldTestInfiniteScrollEntity = new FieldTestInfiniteScrollEntity()
            .stringHugo(UPDATED_STRING_HUGO)
            .stringRequiredHugo(UPDATED_STRING_REQUIRED_HUGO)
            .stringMinlengthHugo(UPDATED_STRING_MINLENGTH_HUGO)
            .stringMaxlengthHugo(UPDATED_STRING_MAXLENGTH_HUGO)
            .stringPatternHugo(UPDATED_STRING_PATTERN_HUGO)
            .integerHugo(UPDATED_INTEGER_HUGO)
            .integerRequiredHugo(UPDATED_INTEGER_REQUIRED_HUGO)
            .integerMinHugo(UPDATED_INTEGER_MIN_HUGO)
            .integerMaxHugo(UPDATED_INTEGER_MAX_HUGO)
            .longHugo(UPDATED_LONG_HUGO)
            .longRequiredHugo(UPDATED_LONG_REQUIRED_HUGO)
            .longMinHugo(UPDATED_LONG_MIN_HUGO)
            .longMaxHugo(UPDATED_LONG_MAX_HUGO)
            .floatHugo(UPDATED_FLOAT_HUGO)
            .floatRequiredHugo(UPDATED_FLOAT_REQUIRED_HUGO)
            .floatMinHugo(UPDATED_FLOAT_MIN_HUGO)
            .floatMaxHugo(UPDATED_FLOAT_MAX_HUGO)
            .doubleRequiredHugo(UPDATED_DOUBLE_REQUIRED_HUGO)
            .doubleMinHugo(UPDATED_DOUBLE_MIN_HUGO)
            .doubleMaxHugo(UPDATED_DOUBLE_MAX_HUGO)
            .bigDecimalRequiredHugo(UPDATED_BIG_DECIMAL_REQUIRED_HUGO)
            .bigDecimalMinHugo(UPDATED_BIG_DECIMAL_MIN_HUGO)
            .bigDecimalMaxHugo(UPDATED_BIG_DECIMAL_MAX_HUGO)
            .localDateHugo(UPDATED_LOCAL_DATE_HUGO)
            .localDateRequiredHugo(UPDATED_LOCAL_DATE_REQUIRED_HUGO)
            .instantHugo(UPDATED_INSTANT_HUGO)
            .instanteRequiredHugo(UPDATED_INSTANTE_REQUIRED_HUGO)
            .zonedDateTimeHugo(UPDATED_ZONED_DATE_TIME_HUGO)
            .zonedDateTimeRequiredHugo(UPDATED_ZONED_DATE_TIME_REQUIRED_HUGO)
            .durationHugo(UPDATED_DURATION_HUGO)
            .durationRequiredHugo(UPDATED_DURATION_REQUIRED_HUGO)
            .booleanHugo(UPDATED_BOOLEAN_HUGO)
            .booleanRequiredHugo(UPDATED_BOOLEAN_REQUIRED_HUGO)
            .enumHugo(UPDATED_ENUM_HUGO)
            .enumRequiredHugo(UPDATED_ENUM_REQUIRED_HUGO)
            .uuidHugo(UPDATED_UUID_HUGO)
            .uuidRequiredHugo(UPDATED_UUID_REQUIRED_HUGO)
            .byteImageHugo(UPDATED_BYTE_IMAGE_HUGO)
            .byteImageHugoContentType(UPDATED_BYTE_IMAGE_HUGO_CONTENT_TYPE)
            .byteImageRequiredHugo(UPDATED_BYTE_IMAGE_REQUIRED_HUGO)
            .byteImageRequiredHugoContentType(UPDATED_BYTE_IMAGE_REQUIRED_HUGO_CONTENT_TYPE)
            .byteImageMinbytesHugo(UPDATED_BYTE_IMAGE_MINBYTES_HUGO)
            .byteImageMinbytesHugoContentType(UPDATED_BYTE_IMAGE_MINBYTES_HUGO_CONTENT_TYPE)
            .byteImageMaxbytesHugo(UPDATED_BYTE_IMAGE_MAXBYTES_HUGO)
            .byteImageMaxbytesHugoContentType(UPDATED_BYTE_IMAGE_MAXBYTES_HUGO_CONTENT_TYPE)
            .byteAnyHugo(UPDATED_BYTE_ANY_HUGO)
            .byteAnyHugoContentType(UPDATED_BYTE_ANY_HUGO_CONTENT_TYPE)
            .byteAnyRequiredHugo(UPDATED_BYTE_ANY_REQUIRED_HUGO)
            .byteAnyRequiredHugoContentType(UPDATED_BYTE_ANY_REQUIRED_HUGO_CONTENT_TYPE)
            .byteAnyMinbytesHugo(UPDATED_BYTE_ANY_MINBYTES_HUGO)
            .byteAnyMinbytesHugoContentType(UPDATED_BYTE_ANY_MINBYTES_HUGO_CONTENT_TYPE)
            .byteAnyMaxbytesHugo(UPDATED_BYTE_ANY_MAXBYTES_HUGO)
            .byteAnyMaxbytesHugoContentType(UPDATED_BYTE_ANY_MAXBYTES_HUGO_CONTENT_TYPE)
            .byteTextHugo(UPDATED_BYTE_TEXT_HUGO)
            .byteTextRequiredHugo(UPDATED_BYTE_TEXT_REQUIRED_HUGO);
        return fieldTestInfiniteScrollEntity;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(FieldTestInfiniteScrollEntity.class).block();
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
        fieldTestInfiniteScrollEntity = createEntity(em);
    }

    @Test
    void createFieldTestInfiniteScrollEntity() throws Exception {
        int databaseSizeBeforeCreate = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();
        // Create the FieldTestInfiniteScrollEntity
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the FieldTestInfiniteScrollEntity in the database
        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeCreate + 1);
        FieldTestInfiniteScrollEntity testFieldTestInfiniteScrollEntity = fieldTestInfiniteScrollEntityList.get(
            fieldTestInfiniteScrollEntityList.size() - 1
        );
        assertThat(testFieldTestInfiniteScrollEntity.getStringHugo()).isEqualTo(DEFAULT_STRING_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getStringRequiredHugo()).isEqualTo(DEFAULT_STRING_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getStringMinlengthHugo()).isEqualTo(DEFAULT_STRING_MINLENGTH_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getStringMaxlengthHugo()).isEqualTo(DEFAULT_STRING_MAXLENGTH_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getStringPatternHugo()).isEqualTo(DEFAULT_STRING_PATTERN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getIntegerHugo()).isEqualTo(DEFAULT_INTEGER_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getIntegerRequiredHugo()).isEqualTo(DEFAULT_INTEGER_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getIntegerMinHugo()).isEqualTo(DEFAULT_INTEGER_MIN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getIntegerMaxHugo()).isEqualTo(DEFAULT_INTEGER_MAX_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLongHugo()).isEqualTo(DEFAULT_LONG_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLongRequiredHugo()).isEqualTo(DEFAULT_LONG_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLongMinHugo()).isEqualTo(DEFAULT_LONG_MIN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLongMaxHugo()).isEqualTo(DEFAULT_LONG_MAX_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getFloatHugo()).isEqualTo(DEFAULT_FLOAT_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getFloatRequiredHugo()).isEqualTo(DEFAULT_FLOAT_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getFloatMinHugo()).isEqualTo(DEFAULT_FLOAT_MIN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getFloatMaxHugo()).isEqualTo(DEFAULT_FLOAT_MAX_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getDoubleRequiredHugo()).isEqualTo(DEFAULT_DOUBLE_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getDoubleMinHugo()).isEqualTo(DEFAULT_DOUBLE_MIN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getDoubleMaxHugo()).isEqualTo(DEFAULT_DOUBLE_MAX_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getBigDecimalRequiredHugo()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getBigDecimalMinHugo()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MIN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getBigDecimalMaxHugo()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MAX_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLocalDateHugo()).isEqualTo(DEFAULT_LOCAL_DATE_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLocalDateRequiredHugo()).isEqualTo(DEFAULT_LOCAL_DATE_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getInstantHugo()).isEqualTo(DEFAULT_INSTANT_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getInstanteRequiredHugo()).isEqualTo(DEFAULT_INSTANTE_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getZonedDateTimeHugo()).isEqualTo(DEFAULT_ZONED_DATE_TIME_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getZonedDateTimeRequiredHugo()).isEqualTo(DEFAULT_ZONED_DATE_TIME_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getDurationHugo()).isEqualTo(DEFAULT_DURATION_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getDurationRequiredHugo()).isEqualTo(DEFAULT_DURATION_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getBooleanHugo()).isEqualTo(DEFAULT_BOOLEAN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getBooleanRequiredHugo()).isEqualTo(DEFAULT_BOOLEAN_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getEnumHugo()).isEqualTo(DEFAULT_ENUM_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getEnumRequiredHugo()).isEqualTo(DEFAULT_ENUM_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getUuidHugo()).isEqualTo(DEFAULT_UUID_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getUuidRequiredHugo()).isEqualTo(DEFAULT_UUID_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageHugo()).isEqualTo(DEFAULT_BYTE_IMAGE_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageHugoContentType()).isEqualTo(DEFAULT_BYTE_IMAGE_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageRequiredHugo()).isEqualTo(DEFAULT_BYTE_IMAGE_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageRequiredHugoContentType())
            .isEqualTo(DEFAULT_BYTE_IMAGE_REQUIRED_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageMinbytesHugo()).isEqualTo(DEFAULT_BYTE_IMAGE_MINBYTES_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageMinbytesHugoContentType())
            .isEqualTo(DEFAULT_BYTE_IMAGE_MINBYTES_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageMaxbytesHugo()).isEqualTo(DEFAULT_BYTE_IMAGE_MAXBYTES_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageMaxbytesHugoContentType())
            .isEqualTo(DEFAULT_BYTE_IMAGE_MAXBYTES_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyHugo()).isEqualTo(DEFAULT_BYTE_ANY_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyHugoContentType()).isEqualTo(DEFAULT_BYTE_ANY_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyRequiredHugo()).isEqualTo(DEFAULT_BYTE_ANY_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyRequiredHugoContentType())
            .isEqualTo(DEFAULT_BYTE_ANY_REQUIRED_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyMinbytesHugo()).isEqualTo(DEFAULT_BYTE_ANY_MINBYTES_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyMinbytesHugoContentType())
            .isEqualTo(DEFAULT_BYTE_ANY_MINBYTES_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyMaxbytesHugo()).isEqualTo(DEFAULT_BYTE_ANY_MAXBYTES_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyMaxbytesHugoContentType())
            .isEqualTo(DEFAULT_BYTE_ANY_MAXBYTES_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteTextHugo()).isEqualTo(DEFAULT_BYTE_TEXT_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteTextRequiredHugo()).isEqualTo(DEFAULT_BYTE_TEXT_REQUIRED_HUGO);
    }

    @Test
    void createFieldTestInfiniteScrollEntityWithExistingId() throws Exception {
        // Create the FieldTestInfiniteScrollEntity with an existing ID
        fieldTestInfiniteScrollEntity.setId(1L);

        int databaseSizeBeforeCreate = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestInfiniteScrollEntity in the database
        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void checkStringRequiredHugoIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestInfiniteScrollEntity.setStringRequiredHugo(null);

        // Create the FieldTestInfiniteScrollEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkIntegerRequiredHugoIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestInfiniteScrollEntity.setIntegerRequiredHugo(null);

        // Create the FieldTestInfiniteScrollEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkLongRequiredHugoIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestInfiniteScrollEntity.setLongRequiredHugo(null);

        // Create the FieldTestInfiniteScrollEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkFloatRequiredHugoIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestInfiniteScrollEntity.setFloatRequiredHugo(null);

        // Create the FieldTestInfiniteScrollEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkDoubleRequiredHugoIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestInfiniteScrollEntity.setDoubleRequiredHugo(null);

        // Create the FieldTestInfiniteScrollEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkBigDecimalRequiredHugoIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestInfiniteScrollEntity.setBigDecimalRequiredHugo(null);

        // Create the FieldTestInfiniteScrollEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkLocalDateRequiredHugoIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestInfiniteScrollEntity.setLocalDateRequiredHugo(null);

        // Create the FieldTestInfiniteScrollEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkInstanteRequiredHugoIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestInfiniteScrollEntity.setInstanteRequiredHugo(null);

        // Create the FieldTestInfiniteScrollEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkZonedDateTimeRequiredHugoIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestInfiniteScrollEntity.setZonedDateTimeRequiredHugo(null);

        // Create the FieldTestInfiniteScrollEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkDurationRequiredHugoIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestInfiniteScrollEntity.setDurationRequiredHugo(null);

        // Create the FieldTestInfiniteScrollEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkBooleanRequiredHugoIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestInfiniteScrollEntity.setBooleanRequiredHugo(null);

        // Create the FieldTestInfiniteScrollEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkEnumRequiredHugoIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestInfiniteScrollEntity.setEnumRequiredHugo(null);

        // Create the FieldTestInfiniteScrollEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkUuidRequiredHugoIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestInfiniteScrollEntity.setUuidRequiredHugo(null);

        // Create the FieldTestInfiniteScrollEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void getAllFieldTestInfiniteScrollEntities() {
        // Initialize the database
        fieldTestInfiniteScrollEntityRepository.save(fieldTestInfiniteScrollEntity).block();

        // Get all the fieldTestInfiniteScrollEntityList
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
            .value(hasItem(fieldTestInfiniteScrollEntity.getId().intValue()))
            .jsonPath("$.[*].stringHugo")
            .value(hasItem(DEFAULT_STRING_HUGO))
            .jsonPath("$.[*].stringRequiredHugo")
            .value(hasItem(DEFAULT_STRING_REQUIRED_HUGO))
            .jsonPath("$.[*].stringMinlengthHugo")
            .value(hasItem(DEFAULT_STRING_MINLENGTH_HUGO))
            .jsonPath("$.[*].stringMaxlengthHugo")
            .value(hasItem(DEFAULT_STRING_MAXLENGTH_HUGO))
            .jsonPath("$.[*].stringPatternHugo")
            .value(hasItem(DEFAULT_STRING_PATTERN_HUGO))
            .jsonPath("$.[*].integerHugo")
            .value(hasItem(DEFAULT_INTEGER_HUGO))
            .jsonPath("$.[*].integerRequiredHugo")
            .value(hasItem(DEFAULT_INTEGER_REQUIRED_HUGO))
            .jsonPath("$.[*].integerMinHugo")
            .value(hasItem(DEFAULT_INTEGER_MIN_HUGO))
            .jsonPath("$.[*].integerMaxHugo")
            .value(hasItem(DEFAULT_INTEGER_MAX_HUGO))
            .jsonPath("$.[*].longHugo")
            .value(hasItem(DEFAULT_LONG_HUGO.intValue()))
            .jsonPath("$.[*].longRequiredHugo")
            .value(hasItem(DEFAULT_LONG_REQUIRED_HUGO.intValue()))
            .jsonPath("$.[*].longMinHugo")
            .value(hasItem(DEFAULT_LONG_MIN_HUGO.intValue()))
            .jsonPath("$.[*].longMaxHugo")
            .value(hasItem(DEFAULT_LONG_MAX_HUGO.intValue()))
            .jsonPath("$.[*].floatHugo")
            .value(hasItem(DEFAULT_FLOAT_HUGO.doubleValue()))
            .jsonPath("$.[*].floatRequiredHugo")
            .value(hasItem(DEFAULT_FLOAT_REQUIRED_HUGO.doubleValue()))
            .jsonPath("$.[*].floatMinHugo")
            .value(hasItem(DEFAULT_FLOAT_MIN_HUGO.doubleValue()))
            .jsonPath("$.[*].floatMaxHugo")
            .value(hasItem(DEFAULT_FLOAT_MAX_HUGO.doubleValue()))
            .jsonPath("$.[*].doubleRequiredHugo")
            .value(hasItem(DEFAULT_DOUBLE_REQUIRED_HUGO.doubleValue()))
            .jsonPath("$.[*].doubleMinHugo")
            .value(hasItem(DEFAULT_DOUBLE_MIN_HUGO.doubleValue()))
            .jsonPath("$.[*].doubleMaxHugo")
            .value(hasItem(DEFAULT_DOUBLE_MAX_HUGO.doubleValue()))
            .jsonPath("$.[*].bigDecimalRequiredHugo")
            .value(hasItem(sameNumber(DEFAULT_BIG_DECIMAL_REQUIRED_HUGO)))
            .jsonPath("$.[*].bigDecimalMinHugo")
            .value(hasItem(sameNumber(DEFAULT_BIG_DECIMAL_MIN_HUGO)))
            .jsonPath("$.[*].bigDecimalMaxHugo")
            .value(hasItem(sameNumber(DEFAULT_BIG_DECIMAL_MAX_HUGO)))
            .jsonPath("$.[*].localDateHugo")
            .value(hasItem(DEFAULT_LOCAL_DATE_HUGO.toString()))
            .jsonPath("$.[*].localDateRequiredHugo")
            .value(hasItem(DEFAULT_LOCAL_DATE_REQUIRED_HUGO.toString()))
            .jsonPath("$.[*].instantHugo")
            .value(hasItem(DEFAULT_INSTANT_HUGO.toString()))
            .jsonPath("$.[*].instanteRequiredHugo")
            .value(hasItem(DEFAULT_INSTANTE_REQUIRED_HUGO.toString()))
            .jsonPath("$.[*].zonedDateTimeHugo")
            .value(hasItem(sameInstant(DEFAULT_ZONED_DATE_TIME_HUGO)))
            .jsonPath("$.[*].zonedDateTimeRequiredHugo")
            .value(hasItem(sameInstant(DEFAULT_ZONED_DATE_TIME_REQUIRED_HUGO)))
            .jsonPath("$.[*].durationHugo")
            .value(hasItem(DEFAULT_DURATION_HUGO.toString()))
            .jsonPath("$.[*].durationRequiredHugo")
            .value(hasItem(DEFAULT_DURATION_REQUIRED_HUGO.toString()))
            .jsonPath("$.[*].booleanHugo")
            .value(hasItem(DEFAULT_BOOLEAN_HUGO.booleanValue()))
            .jsonPath("$.[*].booleanRequiredHugo")
            .value(hasItem(DEFAULT_BOOLEAN_REQUIRED_HUGO.booleanValue()))
            .jsonPath("$.[*].enumHugo")
            .value(hasItem(DEFAULT_ENUM_HUGO.toString()))
            .jsonPath("$.[*].enumRequiredHugo")
            .value(hasItem(DEFAULT_ENUM_REQUIRED_HUGO.toString()))
            .jsonPath("$.[*].uuidHugo")
            .value(hasItem(DEFAULT_UUID_HUGO.toString()))
            .jsonPath("$.[*].uuidRequiredHugo")
            .value(hasItem(DEFAULT_UUID_REQUIRED_HUGO.toString()))
            .jsonPath("$.[*].byteImageHugoContentType")
            .value(hasItem(DEFAULT_BYTE_IMAGE_HUGO_CONTENT_TYPE))
            .jsonPath("$.[*].byteImageHugo")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_HUGO)))
            .jsonPath("$.[*].byteImageRequiredHugoContentType")
            .value(hasItem(DEFAULT_BYTE_IMAGE_REQUIRED_HUGO_CONTENT_TYPE))
            .jsonPath("$.[*].byteImageRequiredHugo")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_REQUIRED_HUGO)))
            .jsonPath("$.[*].byteImageMinbytesHugoContentType")
            .value(hasItem(DEFAULT_BYTE_IMAGE_MINBYTES_HUGO_CONTENT_TYPE))
            .jsonPath("$.[*].byteImageMinbytesHugo")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_MINBYTES_HUGO)))
            .jsonPath("$.[*].byteImageMaxbytesHugoContentType")
            .value(hasItem(DEFAULT_BYTE_IMAGE_MAXBYTES_HUGO_CONTENT_TYPE))
            .jsonPath("$.[*].byteImageMaxbytesHugo")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_MAXBYTES_HUGO)))
            .jsonPath("$.[*].byteAnyHugoContentType")
            .value(hasItem(DEFAULT_BYTE_ANY_HUGO_CONTENT_TYPE))
            .jsonPath("$.[*].byteAnyHugo")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_HUGO)))
            .jsonPath("$.[*].byteAnyRequiredHugoContentType")
            .value(hasItem(DEFAULT_BYTE_ANY_REQUIRED_HUGO_CONTENT_TYPE))
            .jsonPath("$.[*].byteAnyRequiredHugo")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_REQUIRED_HUGO)))
            .jsonPath("$.[*].byteAnyMinbytesHugoContentType")
            .value(hasItem(DEFAULT_BYTE_ANY_MINBYTES_HUGO_CONTENT_TYPE))
            .jsonPath("$.[*].byteAnyMinbytesHugo")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_MINBYTES_HUGO)))
            .jsonPath("$.[*].byteAnyMaxbytesHugoContentType")
            .value(hasItem(DEFAULT_BYTE_ANY_MAXBYTES_HUGO_CONTENT_TYPE))
            .jsonPath("$.[*].byteAnyMaxbytesHugo")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_MAXBYTES_HUGO)))
            .jsonPath("$.[*].byteTextHugo")
            .value(hasItem(DEFAULT_BYTE_TEXT_HUGO.toString()))
            .jsonPath("$.[*].byteTextRequiredHugo")
            .value(hasItem(DEFAULT_BYTE_TEXT_REQUIRED_HUGO.toString()));
    }

    @Test
    void getFieldTestInfiniteScrollEntity() {
        // Initialize the database
        fieldTestInfiniteScrollEntityRepository.save(fieldTestInfiniteScrollEntity).block();

        // Get the fieldTestInfiniteScrollEntity
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, fieldTestInfiniteScrollEntity.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id")
            .value(is(fieldTestInfiniteScrollEntity.getId().intValue()))
            .jsonPath("$.stringHugo")
            .value(is(DEFAULT_STRING_HUGO))
            .jsonPath("$.stringRequiredHugo")
            .value(is(DEFAULT_STRING_REQUIRED_HUGO))
            .jsonPath("$.stringMinlengthHugo")
            .value(is(DEFAULT_STRING_MINLENGTH_HUGO))
            .jsonPath("$.stringMaxlengthHugo")
            .value(is(DEFAULT_STRING_MAXLENGTH_HUGO))
            .jsonPath("$.stringPatternHugo")
            .value(is(DEFAULT_STRING_PATTERN_HUGO))
            .jsonPath("$.integerHugo")
            .value(is(DEFAULT_INTEGER_HUGO))
            .jsonPath("$.integerRequiredHugo")
            .value(is(DEFAULT_INTEGER_REQUIRED_HUGO))
            .jsonPath("$.integerMinHugo")
            .value(is(DEFAULT_INTEGER_MIN_HUGO))
            .jsonPath("$.integerMaxHugo")
            .value(is(DEFAULT_INTEGER_MAX_HUGO))
            .jsonPath("$.longHugo")
            .value(is(DEFAULT_LONG_HUGO.intValue()))
            .jsonPath("$.longRequiredHugo")
            .value(is(DEFAULT_LONG_REQUIRED_HUGO.intValue()))
            .jsonPath("$.longMinHugo")
            .value(is(DEFAULT_LONG_MIN_HUGO.intValue()))
            .jsonPath("$.longMaxHugo")
            .value(is(DEFAULT_LONG_MAX_HUGO.intValue()))
            .jsonPath("$.floatHugo")
            .value(is(DEFAULT_FLOAT_HUGO.doubleValue()))
            .jsonPath("$.floatRequiredHugo")
            .value(is(DEFAULT_FLOAT_REQUIRED_HUGO.doubleValue()))
            .jsonPath("$.floatMinHugo")
            .value(is(DEFAULT_FLOAT_MIN_HUGO.doubleValue()))
            .jsonPath("$.floatMaxHugo")
            .value(is(DEFAULT_FLOAT_MAX_HUGO.doubleValue()))
            .jsonPath("$.doubleRequiredHugo")
            .value(is(DEFAULT_DOUBLE_REQUIRED_HUGO.doubleValue()))
            .jsonPath("$.doubleMinHugo")
            .value(is(DEFAULT_DOUBLE_MIN_HUGO.doubleValue()))
            .jsonPath("$.doubleMaxHugo")
            .value(is(DEFAULT_DOUBLE_MAX_HUGO.doubleValue()))
            .jsonPath("$.bigDecimalRequiredHugo")
            .value(is(sameNumber(DEFAULT_BIG_DECIMAL_REQUIRED_HUGO)))
            .jsonPath("$.bigDecimalMinHugo")
            .value(is(sameNumber(DEFAULT_BIG_DECIMAL_MIN_HUGO)))
            .jsonPath("$.bigDecimalMaxHugo")
            .value(is(sameNumber(DEFAULT_BIG_DECIMAL_MAX_HUGO)))
            .jsonPath("$.localDateHugo")
            .value(is(DEFAULT_LOCAL_DATE_HUGO.toString()))
            .jsonPath("$.localDateRequiredHugo")
            .value(is(DEFAULT_LOCAL_DATE_REQUIRED_HUGO.toString()))
            .jsonPath("$.instantHugo")
            .value(is(DEFAULT_INSTANT_HUGO.toString()))
            .jsonPath("$.instanteRequiredHugo")
            .value(is(DEFAULT_INSTANTE_REQUIRED_HUGO.toString()))
            .jsonPath("$.zonedDateTimeHugo")
            .value(is(sameInstant(DEFAULT_ZONED_DATE_TIME_HUGO)))
            .jsonPath("$.zonedDateTimeRequiredHugo")
            .value(is(sameInstant(DEFAULT_ZONED_DATE_TIME_REQUIRED_HUGO)))
            .jsonPath("$.durationHugo")
            .value(is(DEFAULT_DURATION_HUGO.toString()))
            .jsonPath("$.durationRequiredHugo")
            .value(is(DEFAULT_DURATION_REQUIRED_HUGO.toString()))
            .jsonPath("$.booleanHugo")
            .value(is(DEFAULT_BOOLEAN_HUGO.booleanValue()))
            .jsonPath("$.booleanRequiredHugo")
            .value(is(DEFAULT_BOOLEAN_REQUIRED_HUGO.booleanValue()))
            .jsonPath("$.enumHugo")
            .value(is(DEFAULT_ENUM_HUGO.toString()))
            .jsonPath("$.enumRequiredHugo")
            .value(is(DEFAULT_ENUM_REQUIRED_HUGO.toString()))
            .jsonPath("$.uuidHugo")
            .value(is(DEFAULT_UUID_HUGO.toString()))
            .jsonPath("$.uuidRequiredHugo")
            .value(is(DEFAULT_UUID_REQUIRED_HUGO.toString()))
            .jsonPath("$.byteImageHugoContentType")
            .value(is(DEFAULT_BYTE_IMAGE_HUGO_CONTENT_TYPE))
            .jsonPath("$.byteImageHugo")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_HUGO)))
            .jsonPath("$.byteImageRequiredHugoContentType")
            .value(is(DEFAULT_BYTE_IMAGE_REQUIRED_HUGO_CONTENT_TYPE))
            .jsonPath("$.byteImageRequiredHugo")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_REQUIRED_HUGO)))
            .jsonPath("$.byteImageMinbytesHugoContentType")
            .value(is(DEFAULT_BYTE_IMAGE_MINBYTES_HUGO_CONTENT_TYPE))
            .jsonPath("$.byteImageMinbytesHugo")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_MINBYTES_HUGO)))
            .jsonPath("$.byteImageMaxbytesHugoContentType")
            .value(is(DEFAULT_BYTE_IMAGE_MAXBYTES_HUGO_CONTENT_TYPE))
            .jsonPath("$.byteImageMaxbytesHugo")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_MAXBYTES_HUGO)))
            .jsonPath("$.byteAnyHugoContentType")
            .value(is(DEFAULT_BYTE_ANY_HUGO_CONTENT_TYPE))
            .jsonPath("$.byteAnyHugo")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_HUGO)))
            .jsonPath("$.byteAnyRequiredHugoContentType")
            .value(is(DEFAULT_BYTE_ANY_REQUIRED_HUGO_CONTENT_TYPE))
            .jsonPath("$.byteAnyRequiredHugo")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_REQUIRED_HUGO)))
            .jsonPath("$.byteAnyMinbytesHugoContentType")
            .value(is(DEFAULT_BYTE_ANY_MINBYTES_HUGO_CONTENT_TYPE))
            .jsonPath("$.byteAnyMinbytesHugo")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_MINBYTES_HUGO)))
            .jsonPath("$.byteAnyMaxbytesHugoContentType")
            .value(is(DEFAULT_BYTE_ANY_MAXBYTES_HUGO_CONTENT_TYPE))
            .jsonPath("$.byteAnyMaxbytesHugo")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_MAXBYTES_HUGO)))
            .jsonPath("$.byteTextHugo")
            .value(is(DEFAULT_BYTE_TEXT_HUGO.toString()))
            .jsonPath("$.byteTextRequiredHugo")
            .value(is(DEFAULT_BYTE_TEXT_REQUIRED_HUGO.toString()));
    }

    @Test
    void getNonExistingFieldTestInfiniteScrollEntity() {
        // Get the fieldTestInfiniteScrollEntity
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putNewFieldTestInfiniteScrollEntity() throws Exception {
        // Initialize the database
        fieldTestInfiniteScrollEntityRepository.save(fieldTestInfiniteScrollEntity).block();

        int databaseSizeBeforeUpdate = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();

        // Update the fieldTestInfiniteScrollEntity
        FieldTestInfiniteScrollEntity updatedFieldTestInfiniteScrollEntity = fieldTestInfiniteScrollEntityRepository
            .findById(fieldTestInfiniteScrollEntity.getId())
            .block();
        updatedFieldTestInfiniteScrollEntity
            .stringHugo(UPDATED_STRING_HUGO)
            .stringRequiredHugo(UPDATED_STRING_REQUIRED_HUGO)
            .stringMinlengthHugo(UPDATED_STRING_MINLENGTH_HUGO)
            .stringMaxlengthHugo(UPDATED_STRING_MAXLENGTH_HUGO)
            .stringPatternHugo(UPDATED_STRING_PATTERN_HUGO)
            .integerHugo(UPDATED_INTEGER_HUGO)
            .integerRequiredHugo(UPDATED_INTEGER_REQUIRED_HUGO)
            .integerMinHugo(UPDATED_INTEGER_MIN_HUGO)
            .integerMaxHugo(UPDATED_INTEGER_MAX_HUGO)
            .longHugo(UPDATED_LONG_HUGO)
            .longRequiredHugo(UPDATED_LONG_REQUIRED_HUGO)
            .longMinHugo(UPDATED_LONG_MIN_HUGO)
            .longMaxHugo(UPDATED_LONG_MAX_HUGO)
            .floatHugo(UPDATED_FLOAT_HUGO)
            .floatRequiredHugo(UPDATED_FLOAT_REQUIRED_HUGO)
            .floatMinHugo(UPDATED_FLOAT_MIN_HUGO)
            .floatMaxHugo(UPDATED_FLOAT_MAX_HUGO)
            .doubleRequiredHugo(UPDATED_DOUBLE_REQUIRED_HUGO)
            .doubleMinHugo(UPDATED_DOUBLE_MIN_HUGO)
            .doubleMaxHugo(UPDATED_DOUBLE_MAX_HUGO)
            .bigDecimalRequiredHugo(UPDATED_BIG_DECIMAL_REQUIRED_HUGO)
            .bigDecimalMinHugo(UPDATED_BIG_DECIMAL_MIN_HUGO)
            .bigDecimalMaxHugo(UPDATED_BIG_DECIMAL_MAX_HUGO)
            .localDateHugo(UPDATED_LOCAL_DATE_HUGO)
            .localDateRequiredHugo(UPDATED_LOCAL_DATE_REQUIRED_HUGO)
            .instantHugo(UPDATED_INSTANT_HUGO)
            .instanteRequiredHugo(UPDATED_INSTANTE_REQUIRED_HUGO)
            .zonedDateTimeHugo(UPDATED_ZONED_DATE_TIME_HUGO)
            .zonedDateTimeRequiredHugo(UPDATED_ZONED_DATE_TIME_REQUIRED_HUGO)
            .durationHugo(UPDATED_DURATION_HUGO)
            .durationRequiredHugo(UPDATED_DURATION_REQUIRED_HUGO)
            .booleanHugo(UPDATED_BOOLEAN_HUGO)
            .booleanRequiredHugo(UPDATED_BOOLEAN_REQUIRED_HUGO)
            .enumHugo(UPDATED_ENUM_HUGO)
            .enumRequiredHugo(UPDATED_ENUM_REQUIRED_HUGO)
            .uuidHugo(UPDATED_UUID_HUGO)
            .uuidRequiredHugo(UPDATED_UUID_REQUIRED_HUGO)
            .byteImageHugo(UPDATED_BYTE_IMAGE_HUGO)
            .byteImageHugoContentType(UPDATED_BYTE_IMAGE_HUGO_CONTENT_TYPE)
            .byteImageRequiredHugo(UPDATED_BYTE_IMAGE_REQUIRED_HUGO)
            .byteImageRequiredHugoContentType(UPDATED_BYTE_IMAGE_REQUIRED_HUGO_CONTENT_TYPE)
            .byteImageMinbytesHugo(UPDATED_BYTE_IMAGE_MINBYTES_HUGO)
            .byteImageMinbytesHugoContentType(UPDATED_BYTE_IMAGE_MINBYTES_HUGO_CONTENT_TYPE)
            .byteImageMaxbytesHugo(UPDATED_BYTE_IMAGE_MAXBYTES_HUGO)
            .byteImageMaxbytesHugoContentType(UPDATED_BYTE_IMAGE_MAXBYTES_HUGO_CONTENT_TYPE)
            .byteAnyHugo(UPDATED_BYTE_ANY_HUGO)
            .byteAnyHugoContentType(UPDATED_BYTE_ANY_HUGO_CONTENT_TYPE)
            .byteAnyRequiredHugo(UPDATED_BYTE_ANY_REQUIRED_HUGO)
            .byteAnyRequiredHugoContentType(UPDATED_BYTE_ANY_REQUIRED_HUGO_CONTENT_TYPE)
            .byteAnyMinbytesHugo(UPDATED_BYTE_ANY_MINBYTES_HUGO)
            .byteAnyMinbytesHugoContentType(UPDATED_BYTE_ANY_MINBYTES_HUGO_CONTENT_TYPE)
            .byteAnyMaxbytesHugo(UPDATED_BYTE_ANY_MAXBYTES_HUGO)
            .byteAnyMaxbytesHugoContentType(UPDATED_BYTE_ANY_MAXBYTES_HUGO_CONTENT_TYPE)
            .byteTextHugo(UPDATED_BYTE_TEXT_HUGO)
            .byteTextRequiredHugo(UPDATED_BYTE_TEXT_REQUIRED_HUGO);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, updatedFieldTestInfiniteScrollEntity.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(updatedFieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the FieldTestInfiniteScrollEntity in the database
        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeUpdate);
        FieldTestInfiniteScrollEntity testFieldTestInfiniteScrollEntity = fieldTestInfiniteScrollEntityList.get(
            fieldTestInfiniteScrollEntityList.size() - 1
        );
        assertThat(testFieldTestInfiniteScrollEntity.getStringHugo()).isEqualTo(UPDATED_STRING_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getStringRequiredHugo()).isEqualTo(UPDATED_STRING_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getStringMinlengthHugo()).isEqualTo(UPDATED_STRING_MINLENGTH_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getStringMaxlengthHugo()).isEqualTo(UPDATED_STRING_MAXLENGTH_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getStringPatternHugo()).isEqualTo(UPDATED_STRING_PATTERN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getIntegerHugo()).isEqualTo(UPDATED_INTEGER_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getIntegerRequiredHugo()).isEqualTo(UPDATED_INTEGER_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getIntegerMinHugo()).isEqualTo(UPDATED_INTEGER_MIN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getIntegerMaxHugo()).isEqualTo(UPDATED_INTEGER_MAX_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLongHugo()).isEqualTo(UPDATED_LONG_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLongRequiredHugo()).isEqualTo(UPDATED_LONG_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLongMinHugo()).isEqualTo(UPDATED_LONG_MIN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLongMaxHugo()).isEqualTo(UPDATED_LONG_MAX_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getFloatHugo()).isEqualTo(UPDATED_FLOAT_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getFloatRequiredHugo()).isEqualTo(UPDATED_FLOAT_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getFloatMinHugo()).isEqualTo(UPDATED_FLOAT_MIN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getFloatMaxHugo()).isEqualTo(UPDATED_FLOAT_MAX_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getDoubleRequiredHugo()).isEqualTo(UPDATED_DOUBLE_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getDoubleMinHugo()).isEqualTo(UPDATED_DOUBLE_MIN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getDoubleMaxHugo()).isEqualTo(UPDATED_DOUBLE_MAX_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getBigDecimalRequiredHugo()).isEqualTo(UPDATED_BIG_DECIMAL_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getBigDecimalMinHugo()).isEqualTo(UPDATED_BIG_DECIMAL_MIN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getBigDecimalMaxHugo()).isEqualTo(UPDATED_BIG_DECIMAL_MAX_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLocalDateHugo()).isEqualTo(UPDATED_LOCAL_DATE_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLocalDateRequiredHugo()).isEqualTo(UPDATED_LOCAL_DATE_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getInstantHugo()).isEqualTo(UPDATED_INSTANT_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getInstanteRequiredHugo()).isEqualTo(UPDATED_INSTANTE_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getZonedDateTimeHugo()).isEqualTo(UPDATED_ZONED_DATE_TIME_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getZonedDateTimeRequiredHugo()).isEqualTo(UPDATED_ZONED_DATE_TIME_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getDurationHugo()).isEqualTo(UPDATED_DURATION_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getDurationRequiredHugo()).isEqualTo(UPDATED_DURATION_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getBooleanHugo()).isEqualTo(UPDATED_BOOLEAN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getBooleanRequiredHugo()).isEqualTo(UPDATED_BOOLEAN_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getEnumHugo()).isEqualTo(UPDATED_ENUM_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getEnumRequiredHugo()).isEqualTo(UPDATED_ENUM_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getUuidHugo()).isEqualTo(UPDATED_UUID_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getUuidRequiredHugo()).isEqualTo(UPDATED_UUID_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageHugo()).isEqualTo(UPDATED_BYTE_IMAGE_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageHugoContentType()).isEqualTo(UPDATED_BYTE_IMAGE_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageRequiredHugo()).isEqualTo(UPDATED_BYTE_IMAGE_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageRequiredHugoContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_REQUIRED_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageMinbytesHugo()).isEqualTo(UPDATED_BYTE_IMAGE_MINBYTES_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageMinbytesHugoContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_MINBYTES_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageMaxbytesHugo()).isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageMaxbytesHugoContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyHugo()).isEqualTo(UPDATED_BYTE_ANY_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyHugoContentType()).isEqualTo(UPDATED_BYTE_ANY_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyRequiredHugo()).isEqualTo(UPDATED_BYTE_ANY_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyRequiredHugoContentType())
            .isEqualTo(UPDATED_BYTE_ANY_REQUIRED_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyMinbytesHugo()).isEqualTo(UPDATED_BYTE_ANY_MINBYTES_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyMinbytesHugoContentType())
            .isEqualTo(UPDATED_BYTE_ANY_MINBYTES_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyMaxbytesHugo()).isEqualTo(UPDATED_BYTE_ANY_MAXBYTES_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyMaxbytesHugoContentType())
            .isEqualTo(UPDATED_BYTE_ANY_MAXBYTES_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteTextHugo()).isEqualTo(UPDATED_BYTE_TEXT_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteTextRequiredHugo()).isEqualTo(UPDATED_BYTE_TEXT_REQUIRED_HUGO);
    }

    @Test
    void putNonExistingFieldTestInfiniteScrollEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();
        fieldTestInfiniteScrollEntity.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, fieldTestInfiniteScrollEntity.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestInfiniteScrollEntity in the database
        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchFieldTestInfiniteScrollEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();
        fieldTestInfiniteScrollEntity.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestInfiniteScrollEntity in the database
        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamFieldTestInfiniteScrollEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();
        fieldTestInfiniteScrollEntity.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the FieldTestInfiniteScrollEntity in the database
        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateFieldTestInfiniteScrollEntityWithPatch() throws Exception {
        // Initialize the database
        fieldTestInfiniteScrollEntityRepository.save(fieldTestInfiniteScrollEntity).block();

        int databaseSizeBeforeUpdate = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();

        // Update the fieldTestInfiniteScrollEntity using partial update
        FieldTestInfiniteScrollEntity partialUpdatedFieldTestInfiniteScrollEntity = new FieldTestInfiniteScrollEntity();
        partialUpdatedFieldTestInfiniteScrollEntity.setId(fieldTestInfiniteScrollEntity.getId());

        partialUpdatedFieldTestInfiniteScrollEntity
            .stringHugo(UPDATED_STRING_HUGO)
            .stringRequiredHugo(UPDATED_STRING_REQUIRED_HUGO)
            .stringMaxlengthHugo(UPDATED_STRING_MAXLENGTH_HUGO)
            .integerRequiredHugo(UPDATED_INTEGER_REQUIRED_HUGO)
            .integerMinHugo(UPDATED_INTEGER_MIN_HUGO)
            .longRequiredHugo(UPDATED_LONG_REQUIRED_HUGO)
            .floatHugo(UPDATED_FLOAT_HUGO)
            .floatMinHugo(UPDATED_FLOAT_MIN_HUGO)
            .floatMaxHugo(UPDATED_FLOAT_MAX_HUGO)
            .doubleMaxHugo(UPDATED_DOUBLE_MAX_HUGO)
            .bigDecimalRequiredHugo(UPDATED_BIG_DECIMAL_REQUIRED_HUGO)
            .bigDecimalMaxHugo(UPDATED_BIG_DECIMAL_MAX_HUGO)
            .instantHugo(UPDATED_INSTANT_HUGO)
            .instanteRequiredHugo(UPDATED_INSTANTE_REQUIRED_HUGO)
            .durationHugo(UPDATED_DURATION_HUGO)
            .booleanRequiredHugo(UPDATED_BOOLEAN_REQUIRED_HUGO)
            .enumHugo(UPDATED_ENUM_HUGO)
            .enumRequiredHugo(UPDATED_ENUM_REQUIRED_HUGO)
            .uuidHugo(UPDATED_UUID_HUGO)
            .byteImageMinbytesHugo(UPDATED_BYTE_IMAGE_MINBYTES_HUGO)
            .byteImageMinbytesHugoContentType(UPDATED_BYTE_IMAGE_MINBYTES_HUGO_CONTENT_TYPE)
            .byteImageMaxbytesHugo(UPDATED_BYTE_IMAGE_MAXBYTES_HUGO)
            .byteImageMaxbytesHugoContentType(UPDATED_BYTE_IMAGE_MAXBYTES_HUGO_CONTENT_TYPE)
            .byteAnyHugo(UPDATED_BYTE_ANY_HUGO)
            .byteAnyHugoContentType(UPDATED_BYTE_ANY_HUGO_CONTENT_TYPE)
            .byteAnyRequiredHugo(UPDATED_BYTE_ANY_REQUIRED_HUGO)
            .byteAnyRequiredHugoContentType(UPDATED_BYTE_ANY_REQUIRED_HUGO_CONTENT_TYPE)
            .byteAnyMinbytesHugo(UPDATED_BYTE_ANY_MINBYTES_HUGO)
            .byteAnyMinbytesHugoContentType(UPDATED_BYTE_ANY_MINBYTES_HUGO_CONTENT_TYPE)
            .byteTextHugo(UPDATED_BYTE_TEXT_HUGO)
            .byteTextRequiredHugo(UPDATED_BYTE_TEXT_REQUIRED_HUGO);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedFieldTestInfiniteScrollEntity.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedFieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the FieldTestInfiniteScrollEntity in the database
        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeUpdate);
        FieldTestInfiniteScrollEntity testFieldTestInfiniteScrollEntity = fieldTestInfiniteScrollEntityList.get(
            fieldTestInfiniteScrollEntityList.size() - 1
        );
        assertThat(testFieldTestInfiniteScrollEntity.getStringHugo()).isEqualTo(UPDATED_STRING_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getStringRequiredHugo()).isEqualTo(UPDATED_STRING_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getStringMinlengthHugo()).isEqualTo(DEFAULT_STRING_MINLENGTH_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getStringMaxlengthHugo()).isEqualTo(UPDATED_STRING_MAXLENGTH_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getStringPatternHugo()).isEqualTo(DEFAULT_STRING_PATTERN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getIntegerHugo()).isEqualTo(DEFAULT_INTEGER_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getIntegerRequiredHugo()).isEqualTo(UPDATED_INTEGER_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getIntegerMinHugo()).isEqualTo(UPDATED_INTEGER_MIN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getIntegerMaxHugo()).isEqualTo(DEFAULT_INTEGER_MAX_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLongHugo()).isEqualTo(DEFAULT_LONG_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLongRequiredHugo()).isEqualTo(UPDATED_LONG_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLongMinHugo()).isEqualTo(DEFAULT_LONG_MIN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLongMaxHugo()).isEqualTo(DEFAULT_LONG_MAX_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getFloatHugo()).isEqualTo(UPDATED_FLOAT_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getFloatRequiredHugo()).isEqualTo(DEFAULT_FLOAT_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getFloatMinHugo()).isEqualTo(UPDATED_FLOAT_MIN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getFloatMaxHugo()).isEqualTo(UPDATED_FLOAT_MAX_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getDoubleRequiredHugo()).isEqualTo(DEFAULT_DOUBLE_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getDoubleMinHugo()).isEqualTo(DEFAULT_DOUBLE_MIN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getDoubleMaxHugo()).isEqualTo(UPDATED_DOUBLE_MAX_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getBigDecimalRequiredHugo()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getBigDecimalMinHugo()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MIN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getBigDecimalMaxHugo()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MAX_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLocalDateHugo()).isEqualTo(DEFAULT_LOCAL_DATE_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLocalDateRequiredHugo()).isEqualTo(DEFAULT_LOCAL_DATE_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getInstantHugo()).isEqualTo(UPDATED_INSTANT_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getInstanteRequiredHugo()).isEqualTo(UPDATED_INSTANTE_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getZonedDateTimeHugo()).isEqualTo(DEFAULT_ZONED_DATE_TIME_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getZonedDateTimeRequiredHugo()).isEqualTo(DEFAULT_ZONED_DATE_TIME_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getDurationHugo()).isEqualTo(UPDATED_DURATION_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getDurationRequiredHugo()).isEqualTo(DEFAULT_DURATION_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getBooleanHugo()).isEqualTo(DEFAULT_BOOLEAN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getBooleanRequiredHugo()).isEqualTo(UPDATED_BOOLEAN_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getEnumHugo()).isEqualTo(UPDATED_ENUM_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getEnumRequiredHugo()).isEqualTo(UPDATED_ENUM_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getUuidHugo()).isEqualTo(UPDATED_UUID_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getUuidRequiredHugo()).isEqualTo(DEFAULT_UUID_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageHugo()).isEqualTo(DEFAULT_BYTE_IMAGE_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageHugoContentType()).isEqualTo(DEFAULT_BYTE_IMAGE_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageRequiredHugo()).isEqualTo(DEFAULT_BYTE_IMAGE_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageRequiredHugoContentType())
            .isEqualTo(DEFAULT_BYTE_IMAGE_REQUIRED_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageMinbytesHugo()).isEqualTo(UPDATED_BYTE_IMAGE_MINBYTES_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageMinbytesHugoContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_MINBYTES_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageMaxbytesHugo()).isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageMaxbytesHugoContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyHugo()).isEqualTo(UPDATED_BYTE_ANY_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyHugoContentType()).isEqualTo(UPDATED_BYTE_ANY_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyRequiredHugo()).isEqualTo(UPDATED_BYTE_ANY_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyRequiredHugoContentType())
            .isEqualTo(UPDATED_BYTE_ANY_REQUIRED_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyMinbytesHugo()).isEqualTo(UPDATED_BYTE_ANY_MINBYTES_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyMinbytesHugoContentType())
            .isEqualTo(UPDATED_BYTE_ANY_MINBYTES_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyMaxbytesHugo()).isEqualTo(DEFAULT_BYTE_ANY_MAXBYTES_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyMaxbytesHugoContentType())
            .isEqualTo(DEFAULT_BYTE_ANY_MAXBYTES_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteTextHugo()).isEqualTo(UPDATED_BYTE_TEXT_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteTextRequiredHugo()).isEqualTo(UPDATED_BYTE_TEXT_REQUIRED_HUGO);
    }

    @Test
    void fullUpdateFieldTestInfiniteScrollEntityWithPatch() throws Exception {
        // Initialize the database
        fieldTestInfiniteScrollEntityRepository.save(fieldTestInfiniteScrollEntity).block();

        int databaseSizeBeforeUpdate = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();

        // Update the fieldTestInfiniteScrollEntity using partial update
        FieldTestInfiniteScrollEntity partialUpdatedFieldTestInfiniteScrollEntity = new FieldTestInfiniteScrollEntity();
        partialUpdatedFieldTestInfiniteScrollEntity.setId(fieldTestInfiniteScrollEntity.getId());

        partialUpdatedFieldTestInfiniteScrollEntity
            .stringHugo(UPDATED_STRING_HUGO)
            .stringRequiredHugo(UPDATED_STRING_REQUIRED_HUGO)
            .stringMinlengthHugo(UPDATED_STRING_MINLENGTH_HUGO)
            .stringMaxlengthHugo(UPDATED_STRING_MAXLENGTH_HUGO)
            .stringPatternHugo(UPDATED_STRING_PATTERN_HUGO)
            .integerHugo(UPDATED_INTEGER_HUGO)
            .integerRequiredHugo(UPDATED_INTEGER_REQUIRED_HUGO)
            .integerMinHugo(UPDATED_INTEGER_MIN_HUGO)
            .integerMaxHugo(UPDATED_INTEGER_MAX_HUGO)
            .longHugo(UPDATED_LONG_HUGO)
            .longRequiredHugo(UPDATED_LONG_REQUIRED_HUGO)
            .longMinHugo(UPDATED_LONG_MIN_HUGO)
            .longMaxHugo(UPDATED_LONG_MAX_HUGO)
            .floatHugo(UPDATED_FLOAT_HUGO)
            .floatRequiredHugo(UPDATED_FLOAT_REQUIRED_HUGO)
            .floatMinHugo(UPDATED_FLOAT_MIN_HUGO)
            .floatMaxHugo(UPDATED_FLOAT_MAX_HUGO)
            .doubleRequiredHugo(UPDATED_DOUBLE_REQUIRED_HUGO)
            .doubleMinHugo(UPDATED_DOUBLE_MIN_HUGO)
            .doubleMaxHugo(UPDATED_DOUBLE_MAX_HUGO)
            .bigDecimalRequiredHugo(UPDATED_BIG_DECIMAL_REQUIRED_HUGO)
            .bigDecimalMinHugo(UPDATED_BIG_DECIMAL_MIN_HUGO)
            .bigDecimalMaxHugo(UPDATED_BIG_DECIMAL_MAX_HUGO)
            .localDateHugo(UPDATED_LOCAL_DATE_HUGO)
            .localDateRequiredHugo(UPDATED_LOCAL_DATE_REQUIRED_HUGO)
            .instantHugo(UPDATED_INSTANT_HUGO)
            .instanteRequiredHugo(UPDATED_INSTANTE_REQUIRED_HUGO)
            .zonedDateTimeHugo(UPDATED_ZONED_DATE_TIME_HUGO)
            .zonedDateTimeRequiredHugo(UPDATED_ZONED_DATE_TIME_REQUIRED_HUGO)
            .durationHugo(UPDATED_DURATION_HUGO)
            .durationRequiredHugo(UPDATED_DURATION_REQUIRED_HUGO)
            .booleanHugo(UPDATED_BOOLEAN_HUGO)
            .booleanRequiredHugo(UPDATED_BOOLEAN_REQUIRED_HUGO)
            .enumHugo(UPDATED_ENUM_HUGO)
            .enumRequiredHugo(UPDATED_ENUM_REQUIRED_HUGO)
            .uuidHugo(UPDATED_UUID_HUGO)
            .uuidRequiredHugo(UPDATED_UUID_REQUIRED_HUGO)
            .byteImageHugo(UPDATED_BYTE_IMAGE_HUGO)
            .byteImageHugoContentType(UPDATED_BYTE_IMAGE_HUGO_CONTENT_TYPE)
            .byteImageRequiredHugo(UPDATED_BYTE_IMAGE_REQUIRED_HUGO)
            .byteImageRequiredHugoContentType(UPDATED_BYTE_IMAGE_REQUIRED_HUGO_CONTENT_TYPE)
            .byteImageMinbytesHugo(UPDATED_BYTE_IMAGE_MINBYTES_HUGO)
            .byteImageMinbytesHugoContentType(UPDATED_BYTE_IMAGE_MINBYTES_HUGO_CONTENT_TYPE)
            .byteImageMaxbytesHugo(UPDATED_BYTE_IMAGE_MAXBYTES_HUGO)
            .byteImageMaxbytesHugoContentType(UPDATED_BYTE_IMAGE_MAXBYTES_HUGO_CONTENT_TYPE)
            .byteAnyHugo(UPDATED_BYTE_ANY_HUGO)
            .byteAnyHugoContentType(UPDATED_BYTE_ANY_HUGO_CONTENT_TYPE)
            .byteAnyRequiredHugo(UPDATED_BYTE_ANY_REQUIRED_HUGO)
            .byteAnyRequiredHugoContentType(UPDATED_BYTE_ANY_REQUIRED_HUGO_CONTENT_TYPE)
            .byteAnyMinbytesHugo(UPDATED_BYTE_ANY_MINBYTES_HUGO)
            .byteAnyMinbytesHugoContentType(UPDATED_BYTE_ANY_MINBYTES_HUGO_CONTENT_TYPE)
            .byteAnyMaxbytesHugo(UPDATED_BYTE_ANY_MAXBYTES_HUGO)
            .byteAnyMaxbytesHugoContentType(UPDATED_BYTE_ANY_MAXBYTES_HUGO_CONTENT_TYPE)
            .byteTextHugo(UPDATED_BYTE_TEXT_HUGO)
            .byteTextRequiredHugo(UPDATED_BYTE_TEXT_REQUIRED_HUGO);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedFieldTestInfiniteScrollEntity.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedFieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the FieldTestInfiniteScrollEntity in the database
        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeUpdate);
        FieldTestInfiniteScrollEntity testFieldTestInfiniteScrollEntity = fieldTestInfiniteScrollEntityList.get(
            fieldTestInfiniteScrollEntityList.size() - 1
        );
        assertThat(testFieldTestInfiniteScrollEntity.getStringHugo()).isEqualTo(UPDATED_STRING_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getStringRequiredHugo()).isEqualTo(UPDATED_STRING_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getStringMinlengthHugo()).isEqualTo(UPDATED_STRING_MINLENGTH_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getStringMaxlengthHugo()).isEqualTo(UPDATED_STRING_MAXLENGTH_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getStringPatternHugo()).isEqualTo(UPDATED_STRING_PATTERN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getIntegerHugo()).isEqualTo(UPDATED_INTEGER_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getIntegerRequiredHugo()).isEqualTo(UPDATED_INTEGER_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getIntegerMinHugo()).isEqualTo(UPDATED_INTEGER_MIN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getIntegerMaxHugo()).isEqualTo(UPDATED_INTEGER_MAX_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLongHugo()).isEqualTo(UPDATED_LONG_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLongRequiredHugo()).isEqualTo(UPDATED_LONG_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLongMinHugo()).isEqualTo(UPDATED_LONG_MIN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLongMaxHugo()).isEqualTo(UPDATED_LONG_MAX_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getFloatHugo()).isEqualTo(UPDATED_FLOAT_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getFloatRequiredHugo()).isEqualTo(UPDATED_FLOAT_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getFloatMinHugo()).isEqualTo(UPDATED_FLOAT_MIN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getFloatMaxHugo()).isEqualTo(UPDATED_FLOAT_MAX_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getDoubleRequiredHugo()).isEqualTo(UPDATED_DOUBLE_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getDoubleMinHugo()).isEqualTo(UPDATED_DOUBLE_MIN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getDoubleMaxHugo()).isEqualTo(UPDATED_DOUBLE_MAX_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getBigDecimalRequiredHugo()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getBigDecimalMinHugo()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MIN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getBigDecimalMaxHugo()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MAX_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLocalDateHugo()).isEqualTo(UPDATED_LOCAL_DATE_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getLocalDateRequiredHugo()).isEqualTo(UPDATED_LOCAL_DATE_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getInstantHugo()).isEqualTo(UPDATED_INSTANT_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getInstanteRequiredHugo()).isEqualTo(UPDATED_INSTANTE_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getZonedDateTimeHugo()).isEqualTo(UPDATED_ZONED_DATE_TIME_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getZonedDateTimeRequiredHugo()).isEqualTo(UPDATED_ZONED_DATE_TIME_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getDurationHugo()).isEqualTo(UPDATED_DURATION_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getDurationRequiredHugo()).isEqualTo(UPDATED_DURATION_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getBooleanHugo()).isEqualTo(UPDATED_BOOLEAN_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getBooleanRequiredHugo()).isEqualTo(UPDATED_BOOLEAN_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getEnumHugo()).isEqualTo(UPDATED_ENUM_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getEnumRequiredHugo()).isEqualTo(UPDATED_ENUM_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getUuidHugo()).isEqualTo(UPDATED_UUID_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getUuidRequiredHugo()).isEqualTo(UPDATED_UUID_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageHugo()).isEqualTo(UPDATED_BYTE_IMAGE_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageHugoContentType()).isEqualTo(UPDATED_BYTE_IMAGE_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageRequiredHugo()).isEqualTo(UPDATED_BYTE_IMAGE_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageRequiredHugoContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_REQUIRED_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageMinbytesHugo()).isEqualTo(UPDATED_BYTE_IMAGE_MINBYTES_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageMinbytesHugoContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_MINBYTES_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageMaxbytesHugo()).isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteImageMaxbytesHugoContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyHugo()).isEqualTo(UPDATED_BYTE_ANY_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyHugoContentType()).isEqualTo(UPDATED_BYTE_ANY_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyRequiredHugo()).isEqualTo(UPDATED_BYTE_ANY_REQUIRED_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyRequiredHugoContentType())
            .isEqualTo(UPDATED_BYTE_ANY_REQUIRED_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyMinbytesHugo()).isEqualTo(UPDATED_BYTE_ANY_MINBYTES_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyMinbytesHugoContentType())
            .isEqualTo(UPDATED_BYTE_ANY_MINBYTES_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyMaxbytesHugo()).isEqualTo(UPDATED_BYTE_ANY_MAXBYTES_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteAnyMaxbytesHugoContentType())
            .isEqualTo(UPDATED_BYTE_ANY_MAXBYTES_HUGO_CONTENT_TYPE);
        assertThat(testFieldTestInfiniteScrollEntity.getByteTextHugo()).isEqualTo(UPDATED_BYTE_TEXT_HUGO);
        assertThat(testFieldTestInfiniteScrollEntity.getByteTextRequiredHugo()).isEqualTo(UPDATED_BYTE_TEXT_REQUIRED_HUGO);
    }

    @Test
    void patchNonExistingFieldTestInfiniteScrollEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();
        fieldTestInfiniteScrollEntity.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, fieldTestInfiniteScrollEntity.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestInfiniteScrollEntity in the database
        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchFieldTestInfiniteScrollEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();
        fieldTestInfiniteScrollEntity.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestInfiniteScrollEntity in the database
        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamFieldTestInfiniteScrollEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();
        fieldTestInfiniteScrollEntity.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestInfiniteScrollEntity))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the FieldTestInfiniteScrollEntity in the database
        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteFieldTestInfiniteScrollEntity() {
        // Initialize the database
        fieldTestInfiniteScrollEntityRepository.save(fieldTestInfiniteScrollEntity).block();

        int databaseSizeBeforeDelete = fieldTestInfiniteScrollEntityRepository.findAll().collectList().block().size();

        // Delete the fieldTestInfiniteScrollEntity
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, fieldTestInfiniteScrollEntity.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<FieldTestInfiniteScrollEntity> fieldTestInfiniteScrollEntityList = fieldTestInfiniteScrollEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestInfiniteScrollEntityList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
