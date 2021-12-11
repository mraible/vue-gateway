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
import tech.jhipster.sample.domain.FieldTestServiceImplEntity;
import tech.jhipster.sample.domain.enumeration.EnumFieldClass;
import tech.jhipster.sample.domain.enumeration.EnumRequiredFieldClass;
import tech.jhipster.sample.repository.FieldTestServiceImplEntityRepository;
import tech.jhipster.sample.service.EntityManager;

/**
 * Integration tests for the {@link FieldTestServiceImplEntityResource} REST controller.
 */
@IntegrationTest
@AutoConfigureWebTestClient
@WithMockUser
class FieldTestServiceImplEntityResourceIT {

    private static final String DEFAULT_STRING_MIKA = "AAAAAAAAAA";
    private static final String UPDATED_STRING_MIKA = "BBBBBBBBBB";

    private static final String DEFAULT_STRING_REQUIRED_MIKA = "AAAAAAAAAA";
    private static final String UPDATED_STRING_REQUIRED_MIKA = "BBBBBBBBBB";

    private static final String DEFAULT_STRING_MINLENGTH_MIKA = "AAAAAAAAAA";
    private static final String UPDATED_STRING_MINLENGTH_MIKA = "BBBBBBBBBB";

    private static final String DEFAULT_STRING_MAXLENGTH_MIKA = "AAAAAAAAAA";
    private static final String UPDATED_STRING_MAXLENGTH_MIKA = "BBBBBBBBBB";

    private static final String DEFAULT_STRING_PATTERN_MIKA = "AAAAAAAAAA";
    private static final String UPDATED_STRING_PATTERN_MIKA = "BBBBBBBBBB";

    private static final Integer DEFAULT_INTEGER_MIKA = 1;
    private static final Integer UPDATED_INTEGER_MIKA = 2;

    private static final Integer DEFAULT_INTEGER_REQUIRED_MIKA = 1;
    private static final Integer UPDATED_INTEGER_REQUIRED_MIKA = 2;

    private static final Integer DEFAULT_INTEGER_MIN_MIKA = 0;
    private static final Integer UPDATED_INTEGER_MIN_MIKA = 1;

    private static final Integer DEFAULT_INTEGER_MAX_MIKA = 100;
    private static final Integer UPDATED_INTEGER_MAX_MIKA = 99;

    private static final Long DEFAULT_LONG_MIKA = 1L;
    private static final Long UPDATED_LONG_MIKA = 2L;

    private static final Long DEFAULT_LONG_REQUIRED_MIKA = 1L;
    private static final Long UPDATED_LONG_REQUIRED_MIKA = 2L;

    private static final Long DEFAULT_LONG_MIN_MIKA = 0L;
    private static final Long UPDATED_LONG_MIN_MIKA = 1L;

    private static final Long DEFAULT_LONG_MAX_MIKA = 100L;
    private static final Long UPDATED_LONG_MAX_MIKA = 99L;

    private static final Float DEFAULT_FLOAT_MIKA = 1F;
    private static final Float UPDATED_FLOAT_MIKA = 2F;

    private static final Float DEFAULT_FLOAT_REQUIRED_MIKA = 1F;
    private static final Float UPDATED_FLOAT_REQUIRED_MIKA = 2F;

    private static final Float DEFAULT_FLOAT_MIN_MIKA = 0F;
    private static final Float UPDATED_FLOAT_MIN_MIKA = 1F;

    private static final Float DEFAULT_FLOAT_MAX_MIKA = 100F;
    private static final Float UPDATED_FLOAT_MAX_MIKA = 99F;

    private static final Double DEFAULT_DOUBLE_REQUIRED_MIKA = 1D;
    private static final Double UPDATED_DOUBLE_REQUIRED_MIKA = 2D;

    private static final Double DEFAULT_DOUBLE_MIN_MIKA = 0D;
    private static final Double UPDATED_DOUBLE_MIN_MIKA = 1D;

    private static final Double DEFAULT_DOUBLE_MAX_MIKA = 100D;
    private static final Double UPDATED_DOUBLE_MAX_MIKA = 99D;

    private static final BigDecimal DEFAULT_BIG_DECIMAL_REQUIRED_MIKA = new BigDecimal(1);
    private static final BigDecimal UPDATED_BIG_DECIMAL_REQUIRED_MIKA = new BigDecimal(2);

    private static final BigDecimal DEFAULT_BIG_DECIMAL_MIN_MIKA = new BigDecimal(0);
    private static final BigDecimal UPDATED_BIG_DECIMAL_MIN_MIKA = new BigDecimal(1);

    private static final BigDecimal DEFAULT_BIG_DECIMAL_MAX_MIKA = new BigDecimal(100);
    private static final BigDecimal UPDATED_BIG_DECIMAL_MAX_MIKA = new BigDecimal(99);

    private static final LocalDate DEFAULT_LOCAL_DATE_MIKA = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LOCAL_DATE_MIKA = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_LOCAL_DATE_REQUIRED_MIKA = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LOCAL_DATE_REQUIRED_MIKA = LocalDate.now(ZoneId.systemDefault());

    private static final Instant DEFAULT_INSTANT_MIKA = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_INSTANT_MIKA = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_INSTANTE_REQUIRED_MIKA = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_INSTANTE_REQUIRED_MIKA = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final ZonedDateTime DEFAULT_ZONED_DATE_TIME_MIKA = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_ZONED_DATE_TIME_MIKA = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_ZONED_DATE_TIME_REQUIRED_MIKA = ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(0L),
        ZoneOffset.UTC
    );
    private static final ZonedDateTime UPDATED_ZONED_DATE_TIME_REQUIRED_MIKA = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final Duration DEFAULT_DURATION_MIKA = Duration.ofHours(6);
    private static final Duration UPDATED_DURATION_MIKA = Duration.ofHours(12);

    private static final Duration DEFAULT_DURATION_REQUIRED_MIKA = Duration.ofHours(6);
    private static final Duration UPDATED_DURATION_REQUIRED_MIKA = Duration.ofHours(12);

    private static final Boolean DEFAULT_BOOLEAN_MIKA = false;
    private static final Boolean UPDATED_BOOLEAN_MIKA = true;

    private static final Boolean DEFAULT_BOOLEAN_REQUIRED_MIKA = false;
    private static final Boolean UPDATED_BOOLEAN_REQUIRED_MIKA = true;

    private static final EnumFieldClass DEFAULT_ENUM_MIKA = EnumFieldClass.ENUM_VALUE_1;
    private static final EnumFieldClass UPDATED_ENUM_MIKA = EnumFieldClass.ENUM_VALUE_2;

    private static final EnumRequiredFieldClass DEFAULT_ENUM_REQUIRED_MIKA = EnumRequiredFieldClass.ENUM_VALUE_1;
    private static final EnumRequiredFieldClass UPDATED_ENUM_REQUIRED_MIKA = EnumRequiredFieldClass.ENUM_VALUE_2;

    private static final UUID DEFAULT_UUID_MIKA = UUID.randomUUID();
    private static final UUID UPDATED_UUID_MIKA = UUID.randomUUID();

    private static final UUID DEFAULT_UUID_REQUIRED_MIKA = UUID.randomUUID();
    private static final UUID UPDATED_UUID_REQUIRED_MIKA = UUID.randomUUID();

    private static final byte[] DEFAULT_BYTE_IMAGE_MIKA = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_IMAGE_MIKA = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_IMAGE_MIKA_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_IMAGE_MIKA_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_IMAGE_REQUIRED_MIKA = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_IMAGE_REQUIRED_MIKA = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_IMAGE_REQUIRED_MIKA_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_IMAGE_REQUIRED_MIKA_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_IMAGE_MINBYTES_MIKA = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_IMAGE_MINBYTES_MIKA = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_IMAGE_MINBYTES_MIKA_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_IMAGE_MINBYTES_MIKA_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_IMAGE_MAXBYTES_MIKA = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_IMAGE_MAXBYTES_MIKA = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_IMAGE_MAXBYTES_MIKA_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_IMAGE_MAXBYTES_MIKA_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_ANY_MIKA = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_ANY_MIKA = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_ANY_MIKA_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_ANY_MIKA_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_ANY_REQUIRED_MIKA = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_ANY_REQUIRED_MIKA = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_ANY_REQUIRED_MIKA_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_ANY_REQUIRED_MIKA_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_ANY_MINBYTES_MIKA = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_ANY_MINBYTES_MIKA = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_ANY_MINBYTES_MIKA_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_ANY_MINBYTES_MIKA_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BYTE_ANY_MAXBYTES_MIKA = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BYTE_ANY_MAXBYTES_MIKA = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BYTE_ANY_MAXBYTES_MIKA_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BYTE_ANY_MAXBYTES_MIKA_CONTENT_TYPE = "image/png";

    private static final String DEFAULT_BYTE_TEXT_MIKA = "AAAAAAAAAA";
    private static final String UPDATED_BYTE_TEXT_MIKA = "BBBBBBBBBB";

    private static final String DEFAULT_BYTE_TEXT_REQUIRED_MIKA = "AAAAAAAAAA";
    private static final String UPDATED_BYTE_TEXT_REQUIRED_MIKA = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/field-test-service-impl-entities";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private FieldTestServiceImplEntityRepository fieldTestServiceImplEntityRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private WebTestClient webTestClient;

    private FieldTestServiceImplEntity fieldTestServiceImplEntity;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FieldTestServiceImplEntity createEntity(EntityManager em) {
        FieldTestServiceImplEntity fieldTestServiceImplEntity = new FieldTestServiceImplEntity()
            .stringMika(DEFAULT_STRING_MIKA)
            .stringRequiredMika(DEFAULT_STRING_REQUIRED_MIKA)
            .stringMinlengthMika(DEFAULT_STRING_MINLENGTH_MIKA)
            .stringMaxlengthMika(DEFAULT_STRING_MAXLENGTH_MIKA)
            .stringPatternMika(DEFAULT_STRING_PATTERN_MIKA)
            .integerMika(DEFAULT_INTEGER_MIKA)
            .integerRequiredMika(DEFAULT_INTEGER_REQUIRED_MIKA)
            .integerMinMika(DEFAULT_INTEGER_MIN_MIKA)
            .integerMaxMika(DEFAULT_INTEGER_MAX_MIKA)
            .longMika(DEFAULT_LONG_MIKA)
            .longRequiredMika(DEFAULT_LONG_REQUIRED_MIKA)
            .longMinMika(DEFAULT_LONG_MIN_MIKA)
            .longMaxMika(DEFAULT_LONG_MAX_MIKA)
            .floatMika(DEFAULT_FLOAT_MIKA)
            .floatRequiredMika(DEFAULT_FLOAT_REQUIRED_MIKA)
            .floatMinMika(DEFAULT_FLOAT_MIN_MIKA)
            .floatMaxMika(DEFAULT_FLOAT_MAX_MIKA)
            .doubleRequiredMika(DEFAULT_DOUBLE_REQUIRED_MIKA)
            .doubleMinMika(DEFAULT_DOUBLE_MIN_MIKA)
            .doubleMaxMika(DEFAULT_DOUBLE_MAX_MIKA)
            .bigDecimalRequiredMika(DEFAULT_BIG_DECIMAL_REQUIRED_MIKA)
            .bigDecimalMinMika(DEFAULT_BIG_DECIMAL_MIN_MIKA)
            .bigDecimalMaxMika(DEFAULT_BIG_DECIMAL_MAX_MIKA)
            .localDateMika(DEFAULT_LOCAL_DATE_MIKA)
            .localDateRequiredMika(DEFAULT_LOCAL_DATE_REQUIRED_MIKA)
            .instantMika(DEFAULT_INSTANT_MIKA)
            .instanteRequiredMika(DEFAULT_INSTANTE_REQUIRED_MIKA)
            .zonedDateTimeMika(DEFAULT_ZONED_DATE_TIME_MIKA)
            .zonedDateTimeRequiredMika(DEFAULT_ZONED_DATE_TIME_REQUIRED_MIKA)
            .durationMika(DEFAULT_DURATION_MIKA)
            .durationRequiredMika(DEFAULT_DURATION_REQUIRED_MIKA)
            .booleanMika(DEFAULT_BOOLEAN_MIKA)
            .booleanRequiredMika(DEFAULT_BOOLEAN_REQUIRED_MIKA)
            .enumMika(DEFAULT_ENUM_MIKA)
            .enumRequiredMika(DEFAULT_ENUM_REQUIRED_MIKA)
            .uuidMika(DEFAULT_UUID_MIKA)
            .uuidRequiredMika(DEFAULT_UUID_REQUIRED_MIKA)
            .byteImageMika(DEFAULT_BYTE_IMAGE_MIKA)
            .byteImageMikaContentType(DEFAULT_BYTE_IMAGE_MIKA_CONTENT_TYPE)
            .byteImageRequiredMika(DEFAULT_BYTE_IMAGE_REQUIRED_MIKA)
            .byteImageRequiredMikaContentType(DEFAULT_BYTE_IMAGE_REQUIRED_MIKA_CONTENT_TYPE)
            .byteImageMinbytesMika(DEFAULT_BYTE_IMAGE_MINBYTES_MIKA)
            .byteImageMinbytesMikaContentType(DEFAULT_BYTE_IMAGE_MINBYTES_MIKA_CONTENT_TYPE)
            .byteImageMaxbytesMika(DEFAULT_BYTE_IMAGE_MAXBYTES_MIKA)
            .byteImageMaxbytesMikaContentType(DEFAULT_BYTE_IMAGE_MAXBYTES_MIKA_CONTENT_TYPE)
            .byteAnyMika(DEFAULT_BYTE_ANY_MIKA)
            .byteAnyMikaContentType(DEFAULT_BYTE_ANY_MIKA_CONTENT_TYPE)
            .byteAnyRequiredMika(DEFAULT_BYTE_ANY_REQUIRED_MIKA)
            .byteAnyRequiredMikaContentType(DEFAULT_BYTE_ANY_REQUIRED_MIKA_CONTENT_TYPE)
            .byteAnyMinbytesMika(DEFAULT_BYTE_ANY_MINBYTES_MIKA)
            .byteAnyMinbytesMikaContentType(DEFAULT_BYTE_ANY_MINBYTES_MIKA_CONTENT_TYPE)
            .byteAnyMaxbytesMika(DEFAULT_BYTE_ANY_MAXBYTES_MIKA)
            .byteAnyMaxbytesMikaContentType(DEFAULT_BYTE_ANY_MAXBYTES_MIKA_CONTENT_TYPE)
            .byteTextMika(DEFAULT_BYTE_TEXT_MIKA)
            .byteTextRequiredMika(DEFAULT_BYTE_TEXT_REQUIRED_MIKA);
        return fieldTestServiceImplEntity;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FieldTestServiceImplEntity createUpdatedEntity(EntityManager em) {
        FieldTestServiceImplEntity fieldTestServiceImplEntity = new FieldTestServiceImplEntity()
            .stringMika(UPDATED_STRING_MIKA)
            .stringRequiredMika(UPDATED_STRING_REQUIRED_MIKA)
            .stringMinlengthMika(UPDATED_STRING_MINLENGTH_MIKA)
            .stringMaxlengthMika(UPDATED_STRING_MAXLENGTH_MIKA)
            .stringPatternMika(UPDATED_STRING_PATTERN_MIKA)
            .integerMika(UPDATED_INTEGER_MIKA)
            .integerRequiredMika(UPDATED_INTEGER_REQUIRED_MIKA)
            .integerMinMika(UPDATED_INTEGER_MIN_MIKA)
            .integerMaxMika(UPDATED_INTEGER_MAX_MIKA)
            .longMika(UPDATED_LONG_MIKA)
            .longRequiredMika(UPDATED_LONG_REQUIRED_MIKA)
            .longMinMika(UPDATED_LONG_MIN_MIKA)
            .longMaxMika(UPDATED_LONG_MAX_MIKA)
            .floatMika(UPDATED_FLOAT_MIKA)
            .floatRequiredMika(UPDATED_FLOAT_REQUIRED_MIKA)
            .floatMinMika(UPDATED_FLOAT_MIN_MIKA)
            .floatMaxMika(UPDATED_FLOAT_MAX_MIKA)
            .doubleRequiredMika(UPDATED_DOUBLE_REQUIRED_MIKA)
            .doubleMinMika(UPDATED_DOUBLE_MIN_MIKA)
            .doubleMaxMika(UPDATED_DOUBLE_MAX_MIKA)
            .bigDecimalRequiredMika(UPDATED_BIG_DECIMAL_REQUIRED_MIKA)
            .bigDecimalMinMika(UPDATED_BIG_DECIMAL_MIN_MIKA)
            .bigDecimalMaxMika(UPDATED_BIG_DECIMAL_MAX_MIKA)
            .localDateMika(UPDATED_LOCAL_DATE_MIKA)
            .localDateRequiredMika(UPDATED_LOCAL_DATE_REQUIRED_MIKA)
            .instantMika(UPDATED_INSTANT_MIKA)
            .instanteRequiredMika(UPDATED_INSTANTE_REQUIRED_MIKA)
            .zonedDateTimeMika(UPDATED_ZONED_DATE_TIME_MIKA)
            .zonedDateTimeRequiredMika(UPDATED_ZONED_DATE_TIME_REQUIRED_MIKA)
            .durationMika(UPDATED_DURATION_MIKA)
            .durationRequiredMika(UPDATED_DURATION_REQUIRED_MIKA)
            .booleanMika(UPDATED_BOOLEAN_MIKA)
            .booleanRequiredMika(UPDATED_BOOLEAN_REQUIRED_MIKA)
            .enumMika(UPDATED_ENUM_MIKA)
            .enumRequiredMika(UPDATED_ENUM_REQUIRED_MIKA)
            .uuidMika(UPDATED_UUID_MIKA)
            .uuidRequiredMika(UPDATED_UUID_REQUIRED_MIKA)
            .byteImageMika(UPDATED_BYTE_IMAGE_MIKA)
            .byteImageMikaContentType(UPDATED_BYTE_IMAGE_MIKA_CONTENT_TYPE)
            .byteImageRequiredMika(UPDATED_BYTE_IMAGE_REQUIRED_MIKA)
            .byteImageRequiredMikaContentType(UPDATED_BYTE_IMAGE_REQUIRED_MIKA_CONTENT_TYPE)
            .byteImageMinbytesMika(UPDATED_BYTE_IMAGE_MINBYTES_MIKA)
            .byteImageMinbytesMikaContentType(UPDATED_BYTE_IMAGE_MINBYTES_MIKA_CONTENT_TYPE)
            .byteImageMaxbytesMika(UPDATED_BYTE_IMAGE_MAXBYTES_MIKA)
            .byteImageMaxbytesMikaContentType(UPDATED_BYTE_IMAGE_MAXBYTES_MIKA_CONTENT_TYPE)
            .byteAnyMika(UPDATED_BYTE_ANY_MIKA)
            .byteAnyMikaContentType(UPDATED_BYTE_ANY_MIKA_CONTENT_TYPE)
            .byteAnyRequiredMika(UPDATED_BYTE_ANY_REQUIRED_MIKA)
            .byteAnyRequiredMikaContentType(UPDATED_BYTE_ANY_REQUIRED_MIKA_CONTENT_TYPE)
            .byteAnyMinbytesMika(UPDATED_BYTE_ANY_MINBYTES_MIKA)
            .byteAnyMinbytesMikaContentType(UPDATED_BYTE_ANY_MINBYTES_MIKA_CONTENT_TYPE)
            .byteAnyMaxbytesMika(UPDATED_BYTE_ANY_MAXBYTES_MIKA)
            .byteAnyMaxbytesMikaContentType(UPDATED_BYTE_ANY_MAXBYTES_MIKA_CONTENT_TYPE)
            .byteTextMika(UPDATED_BYTE_TEXT_MIKA)
            .byteTextRequiredMika(UPDATED_BYTE_TEXT_REQUIRED_MIKA);
        return fieldTestServiceImplEntity;
    }

    public static void deleteEntities(EntityManager em) {
        try {
            em.deleteAll(FieldTestServiceImplEntity.class).block();
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
        fieldTestServiceImplEntity = createEntity(em);
    }

    @Test
    void createFieldTestServiceImplEntity() throws Exception {
        int databaseSizeBeforeCreate = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();
        // Create the FieldTestServiceImplEntity
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isCreated();

        // Validate the FieldTestServiceImplEntity in the database
        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeCreate + 1);
        FieldTestServiceImplEntity testFieldTestServiceImplEntity = fieldTestServiceImplEntityList.get(
            fieldTestServiceImplEntityList.size() - 1
        );
        assertThat(testFieldTestServiceImplEntity.getStringMika()).isEqualTo(DEFAULT_STRING_MIKA);
        assertThat(testFieldTestServiceImplEntity.getStringRequiredMika()).isEqualTo(DEFAULT_STRING_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getStringMinlengthMika()).isEqualTo(DEFAULT_STRING_MINLENGTH_MIKA);
        assertThat(testFieldTestServiceImplEntity.getStringMaxlengthMika()).isEqualTo(DEFAULT_STRING_MAXLENGTH_MIKA);
        assertThat(testFieldTestServiceImplEntity.getStringPatternMika()).isEqualTo(DEFAULT_STRING_PATTERN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getIntegerMika()).isEqualTo(DEFAULT_INTEGER_MIKA);
        assertThat(testFieldTestServiceImplEntity.getIntegerRequiredMika()).isEqualTo(DEFAULT_INTEGER_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getIntegerMinMika()).isEqualTo(DEFAULT_INTEGER_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getIntegerMaxMika()).isEqualTo(DEFAULT_INTEGER_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLongMika()).isEqualTo(DEFAULT_LONG_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLongRequiredMika()).isEqualTo(DEFAULT_LONG_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLongMinMika()).isEqualTo(DEFAULT_LONG_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLongMaxMika()).isEqualTo(DEFAULT_LONG_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getFloatMika()).isEqualTo(DEFAULT_FLOAT_MIKA);
        assertThat(testFieldTestServiceImplEntity.getFloatRequiredMika()).isEqualTo(DEFAULT_FLOAT_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getFloatMinMika()).isEqualTo(DEFAULT_FLOAT_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getFloatMaxMika()).isEqualTo(DEFAULT_FLOAT_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDoubleRequiredMika()).isEqualTo(DEFAULT_DOUBLE_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDoubleMinMika()).isEqualTo(DEFAULT_DOUBLE_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDoubleMaxMika()).isEqualTo(DEFAULT_DOUBLE_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBigDecimalRequiredMika()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBigDecimalMinMika()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBigDecimalMaxMika()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLocalDateMika()).isEqualTo(DEFAULT_LOCAL_DATE_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLocalDateRequiredMika()).isEqualTo(DEFAULT_LOCAL_DATE_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getInstantMika()).isEqualTo(DEFAULT_INSTANT_MIKA);
        assertThat(testFieldTestServiceImplEntity.getInstanteRequiredMika()).isEqualTo(DEFAULT_INSTANTE_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getZonedDateTimeMika()).isEqualTo(DEFAULT_ZONED_DATE_TIME_MIKA);
        assertThat(testFieldTestServiceImplEntity.getZonedDateTimeRequiredMika()).isEqualTo(DEFAULT_ZONED_DATE_TIME_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDurationMika()).isEqualTo(DEFAULT_DURATION_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDurationRequiredMika()).isEqualTo(DEFAULT_DURATION_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBooleanMika()).isEqualTo(DEFAULT_BOOLEAN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBooleanRequiredMika()).isEqualTo(DEFAULT_BOOLEAN_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getEnumMika()).isEqualTo(DEFAULT_ENUM_MIKA);
        assertThat(testFieldTestServiceImplEntity.getEnumRequiredMika()).isEqualTo(DEFAULT_ENUM_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getUuidMika()).isEqualTo(DEFAULT_UUID_MIKA);
        assertThat(testFieldTestServiceImplEntity.getUuidRequiredMika()).isEqualTo(DEFAULT_UUID_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageMika()).isEqualTo(DEFAULT_BYTE_IMAGE_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageMikaContentType()).isEqualTo(DEFAULT_BYTE_IMAGE_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteImageRequiredMika()).isEqualTo(DEFAULT_BYTE_IMAGE_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageRequiredMikaContentType())
            .isEqualTo(DEFAULT_BYTE_IMAGE_REQUIRED_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteImageMinbytesMika()).isEqualTo(DEFAULT_BYTE_IMAGE_MINBYTES_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageMinbytesMikaContentType())
            .isEqualTo(DEFAULT_BYTE_IMAGE_MINBYTES_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteImageMaxbytesMika()).isEqualTo(DEFAULT_BYTE_IMAGE_MAXBYTES_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageMaxbytesMikaContentType())
            .isEqualTo(DEFAULT_BYTE_IMAGE_MAXBYTES_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMika()).isEqualTo(DEFAULT_BYTE_ANY_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMikaContentType()).isEqualTo(DEFAULT_BYTE_ANY_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteAnyRequiredMika()).isEqualTo(DEFAULT_BYTE_ANY_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteAnyRequiredMikaContentType())
            .isEqualTo(DEFAULT_BYTE_ANY_REQUIRED_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMinbytesMika()).isEqualTo(DEFAULT_BYTE_ANY_MINBYTES_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMinbytesMikaContentType())
            .isEqualTo(DEFAULT_BYTE_ANY_MINBYTES_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMaxbytesMika()).isEqualTo(DEFAULT_BYTE_ANY_MAXBYTES_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMaxbytesMikaContentType())
            .isEqualTo(DEFAULT_BYTE_ANY_MAXBYTES_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteTextMika()).isEqualTo(DEFAULT_BYTE_TEXT_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteTextRequiredMika()).isEqualTo(DEFAULT_BYTE_TEXT_REQUIRED_MIKA);
    }

    @Test
    void createFieldTestServiceImplEntityWithExistingId() throws Exception {
        // Create the FieldTestServiceImplEntity with an existing ID
        fieldTestServiceImplEntity.setId(1L);

        int databaseSizeBeforeCreate = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestServiceImplEntity in the database
        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void checkStringRequiredMikaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestServiceImplEntity.setStringRequiredMika(null);

        // Create the FieldTestServiceImplEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkIntegerRequiredMikaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestServiceImplEntity.setIntegerRequiredMika(null);

        // Create the FieldTestServiceImplEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkLongRequiredMikaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestServiceImplEntity.setLongRequiredMika(null);

        // Create the FieldTestServiceImplEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkFloatRequiredMikaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestServiceImplEntity.setFloatRequiredMika(null);

        // Create the FieldTestServiceImplEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkDoubleRequiredMikaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestServiceImplEntity.setDoubleRequiredMika(null);

        // Create the FieldTestServiceImplEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkBigDecimalRequiredMikaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestServiceImplEntity.setBigDecimalRequiredMika(null);

        // Create the FieldTestServiceImplEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkLocalDateRequiredMikaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestServiceImplEntity.setLocalDateRequiredMika(null);

        // Create the FieldTestServiceImplEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkInstanteRequiredMikaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestServiceImplEntity.setInstanteRequiredMika(null);

        // Create the FieldTestServiceImplEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkZonedDateTimeRequiredMikaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestServiceImplEntity.setZonedDateTimeRequiredMika(null);

        // Create the FieldTestServiceImplEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkDurationRequiredMikaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestServiceImplEntity.setDurationRequiredMika(null);

        // Create the FieldTestServiceImplEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkBooleanRequiredMikaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestServiceImplEntity.setBooleanRequiredMika(null);

        // Create the FieldTestServiceImplEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkEnumRequiredMikaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestServiceImplEntity.setEnumRequiredMika(null);

        // Create the FieldTestServiceImplEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void checkUuidRequiredMikaIsRequired() throws Exception {
        int databaseSizeBeforeTest = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();
        // set the field null
        fieldTestServiceImplEntity.setUuidRequiredMika(null);

        // Create the FieldTestServiceImplEntity, which fails.

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    void getAllFieldTestServiceImplEntitiesAsStream() {
        // Initialize the database
        fieldTestServiceImplEntityRepository.save(fieldTestServiceImplEntity).block();

        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = webTestClient
            .get()
            .uri(ENTITY_API_URL)
            .accept(MediaType.APPLICATION_NDJSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentTypeCompatibleWith(MediaType.APPLICATION_NDJSON)
            .returnResult(FieldTestServiceImplEntity.class)
            .getResponseBody()
            .filter(fieldTestServiceImplEntity::equals)
            .collectList()
            .block(Duration.ofSeconds(5));

        assertThat(fieldTestServiceImplEntityList).isNotNull();
        assertThat(fieldTestServiceImplEntityList).hasSize(1);
        FieldTestServiceImplEntity testFieldTestServiceImplEntity = fieldTestServiceImplEntityList.get(0);
        assertThat(testFieldTestServiceImplEntity.getStringMika()).isEqualTo(DEFAULT_STRING_MIKA);
        assertThat(testFieldTestServiceImplEntity.getStringRequiredMika()).isEqualTo(DEFAULT_STRING_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getStringMinlengthMika()).isEqualTo(DEFAULT_STRING_MINLENGTH_MIKA);
        assertThat(testFieldTestServiceImplEntity.getStringMaxlengthMika()).isEqualTo(DEFAULT_STRING_MAXLENGTH_MIKA);
        assertThat(testFieldTestServiceImplEntity.getStringPatternMika()).isEqualTo(DEFAULT_STRING_PATTERN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getIntegerMika()).isEqualTo(DEFAULT_INTEGER_MIKA);
        assertThat(testFieldTestServiceImplEntity.getIntegerRequiredMika()).isEqualTo(DEFAULT_INTEGER_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getIntegerMinMika()).isEqualTo(DEFAULT_INTEGER_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getIntegerMaxMika()).isEqualTo(DEFAULT_INTEGER_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLongMika()).isEqualTo(DEFAULT_LONG_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLongRequiredMika()).isEqualTo(DEFAULT_LONG_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLongMinMika()).isEqualTo(DEFAULT_LONG_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLongMaxMika()).isEqualTo(DEFAULT_LONG_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getFloatMika()).isEqualTo(DEFAULT_FLOAT_MIKA);
        assertThat(testFieldTestServiceImplEntity.getFloatRequiredMika()).isEqualTo(DEFAULT_FLOAT_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getFloatMinMika()).isEqualTo(DEFAULT_FLOAT_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getFloatMaxMika()).isEqualTo(DEFAULT_FLOAT_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDoubleRequiredMika()).isEqualTo(DEFAULT_DOUBLE_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDoubleMinMika()).isEqualTo(DEFAULT_DOUBLE_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDoubleMaxMika()).isEqualTo(DEFAULT_DOUBLE_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBigDecimalRequiredMika()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBigDecimalMinMika()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBigDecimalMaxMika()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLocalDateMika()).isEqualTo(DEFAULT_LOCAL_DATE_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLocalDateRequiredMika()).isEqualTo(DEFAULT_LOCAL_DATE_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getInstantMika()).isEqualTo(DEFAULT_INSTANT_MIKA);
        assertThat(testFieldTestServiceImplEntity.getInstanteRequiredMika()).isEqualTo(DEFAULT_INSTANTE_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getZonedDateTimeMika()).isEqualTo(DEFAULT_ZONED_DATE_TIME_MIKA);
        assertThat(testFieldTestServiceImplEntity.getZonedDateTimeRequiredMika()).isEqualTo(DEFAULT_ZONED_DATE_TIME_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDurationMika()).isEqualTo(DEFAULT_DURATION_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDurationRequiredMika()).isEqualTo(DEFAULT_DURATION_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBooleanMika()).isEqualTo(DEFAULT_BOOLEAN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBooleanRequiredMika()).isEqualTo(DEFAULT_BOOLEAN_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getEnumMika()).isEqualTo(DEFAULT_ENUM_MIKA);
        assertThat(testFieldTestServiceImplEntity.getEnumRequiredMika()).isEqualTo(DEFAULT_ENUM_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getUuidMika()).isEqualTo(DEFAULT_UUID_MIKA);
        assertThat(testFieldTestServiceImplEntity.getUuidRequiredMika()).isEqualTo(DEFAULT_UUID_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageMika()).isEqualTo(DEFAULT_BYTE_IMAGE_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageMikaContentType()).isEqualTo(DEFAULT_BYTE_IMAGE_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteImageRequiredMika()).isEqualTo(DEFAULT_BYTE_IMAGE_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageRequiredMikaContentType())
            .isEqualTo(DEFAULT_BYTE_IMAGE_REQUIRED_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteImageMinbytesMika()).isEqualTo(DEFAULT_BYTE_IMAGE_MINBYTES_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageMinbytesMikaContentType())
            .isEqualTo(DEFAULT_BYTE_IMAGE_MINBYTES_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteImageMaxbytesMika()).isEqualTo(DEFAULT_BYTE_IMAGE_MAXBYTES_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageMaxbytesMikaContentType())
            .isEqualTo(DEFAULT_BYTE_IMAGE_MAXBYTES_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMika()).isEqualTo(DEFAULT_BYTE_ANY_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMikaContentType()).isEqualTo(DEFAULT_BYTE_ANY_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteAnyRequiredMika()).isEqualTo(DEFAULT_BYTE_ANY_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteAnyRequiredMikaContentType())
            .isEqualTo(DEFAULT_BYTE_ANY_REQUIRED_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMinbytesMika()).isEqualTo(DEFAULT_BYTE_ANY_MINBYTES_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMinbytesMikaContentType())
            .isEqualTo(DEFAULT_BYTE_ANY_MINBYTES_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMaxbytesMika()).isEqualTo(DEFAULT_BYTE_ANY_MAXBYTES_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMaxbytesMikaContentType())
            .isEqualTo(DEFAULT_BYTE_ANY_MAXBYTES_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteTextMika()).isEqualTo(DEFAULT_BYTE_TEXT_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteTextRequiredMika()).isEqualTo(DEFAULT_BYTE_TEXT_REQUIRED_MIKA);
    }

    @Test
    void getAllFieldTestServiceImplEntities() {
        // Initialize the database
        fieldTestServiceImplEntityRepository.save(fieldTestServiceImplEntity).block();

        // Get all the fieldTestServiceImplEntityList
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
            .value(hasItem(fieldTestServiceImplEntity.getId().intValue()))
            .jsonPath("$.[*].stringMika")
            .value(hasItem(DEFAULT_STRING_MIKA))
            .jsonPath("$.[*].stringRequiredMika")
            .value(hasItem(DEFAULT_STRING_REQUIRED_MIKA))
            .jsonPath("$.[*].stringMinlengthMika")
            .value(hasItem(DEFAULT_STRING_MINLENGTH_MIKA))
            .jsonPath("$.[*].stringMaxlengthMika")
            .value(hasItem(DEFAULT_STRING_MAXLENGTH_MIKA))
            .jsonPath("$.[*].stringPatternMika")
            .value(hasItem(DEFAULT_STRING_PATTERN_MIKA))
            .jsonPath("$.[*].integerMika")
            .value(hasItem(DEFAULT_INTEGER_MIKA))
            .jsonPath("$.[*].integerRequiredMika")
            .value(hasItem(DEFAULT_INTEGER_REQUIRED_MIKA))
            .jsonPath("$.[*].integerMinMika")
            .value(hasItem(DEFAULT_INTEGER_MIN_MIKA))
            .jsonPath("$.[*].integerMaxMika")
            .value(hasItem(DEFAULT_INTEGER_MAX_MIKA))
            .jsonPath("$.[*].longMika")
            .value(hasItem(DEFAULT_LONG_MIKA.intValue()))
            .jsonPath("$.[*].longRequiredMika")
            .value(hasItem(DEFAULT_LONG_REQUIRED_MIKA.intValue()))
            .jsonPath("$.[*].longMinMika")
            .value(hasItem(DEFAULT_LONG_MIN_MIKA.intValue()))
            .jsonPath("$.[*].longMaxMika")
            .value(hasItem(DEFAULT_LONG_MAX_MIKA.intValue()))
            .jsonPath("$.[*].floatMika")
            .value(hasItem(DEFAULT_FLOAT_MIKA.doubleValue()))
            .jsonPath("$.[*].floatRequiredMika")
            .value(hasItem(DEFAULT_FLOAT_REQUIRED_MIKA.doubleValue()))
            .jsonPath("$.[*].floatMinMika")
            .value(hasItem(DEFAULT_FLOAT_MIN_MIKA.doubleValue()))
            .jsonPath("$.[*].floatMaxMika")
            .value(hasItem(DEFAULT_FLOAT_MAX_MIKA.doubleValue()))
            .jsonPath("$.[*].doubleRequiredMika")
            .value(hasItem(DEFAULT_DOUBLE_REQUIRED_MIKA.doubleValue()))
            .jsonPath("$.[*].doubleMinMika")
            .value(hasItem(DEFAULT_DOUBLE_MIN_MIKA.doubleValue()))
            .jsonPath("$.[*].doubleMaxMika")
            .value(hasItem(DEFAULT_DOUBLE_MAX_MIKA.doubleValue()))
            .jsonPath("$.[*].bigDecimalRequiredMika")
            .value(hasItem(sameNumber(DEFAULT_BIG_DECIMAL_REQUIRED_MIKA)))
            .jsonPath("$.[*].bigDecimalMinMika")
            .value(hasItem(sameNumber(DEFAULT_BIG_DECIMAL_MIN_MIKA)))
            .jsonPath("$.[*].bigDecimalMaxMika")
            .value(hasItem(sameNumber(DEFAULT_BIG_DECIMAL_MAX_MIKA)))
            .jsonPath("$.[*].localDateMika")
            .value(hasItem(DEFAULT_LOCAL_DATE_MIKA.toString()))
            .jsonPath("$.[*].localDateRequiredMika")
            .value(hasItem(DEFAULT_LOCAL_DATE_REQUIRED_MIKA.toString()))
            .jsonPath("$.[*].instantMika")
            .value(hasItem(DEFAULT_INSTANT_MIKA.toString()))
            .jsonPath("$.[*].instanteRequiredMika")
            .value(hasItem(DEFAULT_INSTANTE_REQUIRED_MIKA.toString()))
            .jsonPath("$.[*].zonedDateTimeMika")
            .value(hasItem(sameInstant(DEFAULT_ZONED_DATE_TIME_MIKA)))
            .jsonPath("$.[*].zonedDateTimeRequiredMika")
            .value(hasItem(sameInstant(DEFAULT_ZONED_DATE_TIME_REQUIRED_MIKA)))
            .jsonPath("$.[*].durationMika")
            .value(hasItem(DEFAULT_DURATION_MIKA.toString()))
            .jsonPath("$.[*].durationRequiredMika")
            .value(hasItem(DEFAULT_DURATION_REQUIRED_MIKA.toString()))
            .jsonPath("$.[*].booleanMika")
            .value(hasItem(DEFAULT_BOOLEAN_MIKA.booleanValue()))
            .jsonPath("$.[*].booleanRequiredMika")
            .value(hasItem(DEFAULT_BOOLEAN_REQUIRED_MIKA.booleanValue()))
            .jsonPath("$.[*].enumMika")
            .value(hasItem(DEFAULT_ENUM_MIKA.toString()))
            .jsonPath("$.[*].enumRequiredMika")
            .value(hasItem(DEFAULT_ENUM_REQUIRED_MIKA.toString()))
            .jsonPath("$.[*].uuidMika")
            .value(hasItem(DEFAULT_UUID_MIKA.toString()))
            .jsonPath("$.[*].uuidRequiredMika")
            .value(hasItem(DEFAULT_UUID_REQUIRED_MIKA.toString()))
            .jsonPath("$.[*].byteImageMikaContentType")
            .value(hasItem(DEFAULT_BYTE_IMAGE_MIKA_CONTENT_TYPE))
            .jsonPath("$.[*].byteImageMika")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_MIKA)))
            .jsonPath("$.[*].byteImageRequiredMikaContentType")
            .value(hasItem(DEFAULT_BYTE_IMAGE_REQUIRED_MIKA_CONTENT_TYPE))
            .jsonPath("$.[*].byteImageRequiredMika")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_REQUIRED_MIKA)))
            .jsonPath("$.[*].byteImageMinbytesMikaContentType")
            .value(hasItem(DEFAULT_BYTE_IMAGE_MINBYTES_MIKA_CONTENT_TYPE))
            .jsonPath("$.[*].byteImageMinbytesMika")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_MINBYTES_MIKA)))
            .jsonPath("$.[*].byteImageMaxbytesMikaContentType")
            .value(hasItem(DEFAULT_BYTE_IMAGE_MAXBYTES_MIKA_CONTENT_TYPE))
            .jsonPath("$.[*].byteImageMaxbytesMika")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_MAXBYTES_MIKA)))
            .jsonPath("$.[*].byteAnyMikaContentType")
            .value(hasItem(DEFAULT_BYTE_ANY_MIKA_CONTENT_TYPE))
            .jsonPath("$.[*].byteAnyMika")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_MIKA)))
            .jsonPath("$.[*].byteAnyRequiredMikaContentType")
            .value(hasItem(DEFAULT_BYTE_ANY_REQUIRED_MIKA_CONTENT_TYPE))
            .jsonPath("$.[*].byteAnyRequiredMika")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_REQUIRED_MIKA)))
            .jsonPath("$.[*].byteAnyMinbytesMikaContentType")
            .value(hasItem(DEFAULT_BYTE_ANY_MINBYTES_MIKA_CONTENT_TYPE))
            .jsonPath("$.[*].byteAnyMinbytesMika")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_MINBYTES_MIKA)))
            .jsonPath("$.[*].byteAnyMaxbytesMikaContentType")
            .value(hasItem(DEFAULT_BYTE_ANY_MAXBYTES_MIKA_CONTENT_TYPE))
            .jsonPath("$.[*].byteAnyMaxbytesMika")
            .value(hasItem(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_MAXBYTES_MIKA)))
            .jsonPath("$.[*].byteTextMika")
            .value(hasItem(DEFAULT_BYTE_TEXT_MIKA.toString()))
            .jsonPath("$.[*].byteTextRequiredMika")
            .value(hasItem(DEFAULT_BYTE_TEXT_REQUIRED_MIKA.toString()));
    }

    @Test
    void getFieldTestServiceImplEntity() {
        // Initialize the database
        fieldTestServiceImplEntityRepository.save(fieldTestServiceImplEntity).block();

        // Get the fieldTestServiceImplEntity
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, fieldTestServiceImplEntity.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id")
            .value(is(fieldTestServiceImplEntity.getId().intValue()))
            .jsonPath("$.stringMika")
            .value(is(DEFAULT_STRING_MIKA))
            .jsonPath("$.stringRequiredMika")
            .value(is(DEFAULT_STRING_REQUIRED_MIKA))
            .jsonPath("$.stringMinlengthMika")
            .value(is(DEFAULT_STRING_MINLENGTH_MIKA))
            .jsonPath("$.stringMaxlengthMika")
            .value(is(DEFAULT_STRING_MAXLENGTH_MIKA))
            .jsonPath("$.stringPatternMika")
            .value(is(DEFAULT_STRING_PATTERN_MIKA))
            .jsonPath("$.integerMika")
            .value(is(DEFAULT_INTEGER_MIKA))
            .jsonPath("$.integerRequiredMika")
            .value(is(DEFAULT_INTEGER_REQUIRED_MIKA))
            .jsonPath("$.integerMinMika")
            .value(is(DEFAULT_INTEGER_MIN_MIKA))
            .jsonPath("$.integerMaxMika")
            .value(is(DEFAULT_INTEGER_MAX_MIKA))
            .jsonPath("$.longMika")
            .value(is(DEFAULT_LONG_MIKA.intValue()))
            .jsonPath("$.longRequiredMika")
            .value(is(DEFAULT_LONG_REQUIRED_MIKA.intValue()))
            .jsonPath("$.longMinMika")
            .value(is(DEFAULT_LONG_MIN_MIKA.intValue()))
            .jsonPath("$.longMaxMika")
            .value(is(DEFAULT_LONG_MAX_MIKA.intValue()))
            .jsonPath("$.floatMika")
            .value(is(DEFAULT_FLOAT_MIKA.doubleValue()))
            .jsonPath("$.floatRequiredMika")
            .value(is(DEFAULT_FLOAT_REQUIRED_MIKA.doubleValue()))
            .jsonPath("$.floatMinMika")
            .value(is(DEFAULT_FLOAT_MIN_MIKA.doubleValue()))
            .jsonPath("$.floatMaxMika")
            .value(is(DEFAULT_FLOAT_MAX_MIKA.doubleValue()))
            .jsonPath("$.doubleRequiredMika")
            .value(is(DEFAULT_DOUBLE_REQUIRED_MIKA.doubleValue()))
            .jsonPath("$.doubleMinMika")
            .value(is(DEFAULT_DOUBLE_MIN_MIKA.doubleValue()))
            .jsonPath("$.doubleMaxMika")
            .value(is(DEFAULT_DOUBLE_MAX_MIKA.doubleValue()))
            .jsonPath("$.bigDecimalRequiredMika")
            .value(is(sameNumber(DEFAULT_BIG_DECIMAL_REQUIRED_MIKA)))
            .jsonPath("$.bigDecimalMinMika")
            .value(is(sameNumber(DEFAULT_BIG_DECIMAL_MIN_MIKA)))
            .jsonPath("$.bigDecimalMaxMika")
            .value(is(sameNumber(DEFAULT_BIG_DECIMAL_MAX_MIKA)))
            .jsonPath("$.localDateMika")
            .value(is(DEFAULT_LOCAL_DATE_MIKA.toString()))
            .jsonPath("$.localDateRequiredMika")
            .value(is(DEFAULT_LOCAL_DATE_REQUIRED_MIKA.toString()))
            .jsonPath("$.instantMika")
            .value(is(DEFAULT_INSTANT_MIKA.toString()))
            .jsonPath("$.instanteRequiredMika")
            .value(is(DEFAULT_INSTANTE_REQUIRED_MIKA.toString()))
            .jsonPath("$.zonedDateTimeMika")
            .value(is(sameInstant(DEFAULT_ZONED_DATE_TIME_MIKA)))
            .jsonPath("$.zonedDateTimeRequiredMika")
            .value(is(sameInstant(DEFAULT_ZONED_DATE_TIME_REQUIRED_MIKA)))
            .jsonPath("$.durationMika")
            .value(is(DEFAULT_DURATION_MIKA.toString()))
            .jsonPath("$.durationRequiredMika")
            .value(is(DEFAULT_DURATION_REQUIRED_MIKA.toString()))
            .jsonPath("$.booleanMika")
            .value(is(DEFAULT_BOOLEAN_MIKA.booleanValue()))
            .jsonPath("$.booleanRequiredMika")
            .value(is(DEFAULT_BOOLEAN_REQUIRED_MIKA.booleanValue()))
            .jsonPath("$.enumMika")
            .value(is(DEFAULT_ENUM_MIKA.toString()))
            .jsonPath("$.enumRequiredMika")
            .value(is(DEFAULT_ENUM_REQUIRED_MIKA.toString()))
            .jsonPath("$.uuidMika")
            .value(is(DEFAULT_UUID_MIKA.toString()))
            .jsonPath("$.uuidRequiredMika")
            .value(is(DEFAULT_UUID_REQUIRED_MIKA.toString()))
            .jsonPath("$.byteImageMikaContentType")
            .value(is(DEFAULT_BYTE_IMAGE_MIKA_CONTENT_TYPE))
            .jsonPath("$.byteImageMika")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_MIKA)))
            .jsonPath("$.byteImageRequiredMikaContentType")
            .value(is(DEFAULT_BYTE_IMAGE_REQUIRED_MIKA_CONTENT_TYPE))
            .jsonPath("$.byteImageRequiredMika")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_REQUIRED_MIKA)))
            .jsonPath("$.byteImageMinbytesMikaContentType")
            .value(is(DEFAULT_BYTE_IMAGE_MINBYTES_MIKA_CONTENT_TYPE))
            .jsonPath("$.byteImageMinbytesMika")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_MINBYTES_MIKA)))
            .jsonPath("$.byteImageMaxbytesMikaContentType")
            .value(is(DEFAULT_BYTE_IMAGE_MAXBYTES_MIKA_CONTENT_TYPE))
            .jsonPath("$.byteImageMaxbytesMika")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_IMAGE_MAXBYTES_MIKA)))
            .jsonPath("$.byteAnyMikaContentType")
            .value(is(DEFAULT_BYTE_ANY_MIKA_CONTENT_TYPE))
            .jsonPath("$.byteAnyMika")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_MIKA)))
            .jsonPath("$.byteAnyRequiredMikaContentType")
            .value(is(DEFAULT_BYTE_ANY_REQUIRED_MIKA_CONTENT_TYPE))
            .jsonPath("$.byteAnyRequiredMika")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_REQUIRED_MIKA)))
            .jsonPath("$.byteAnyMinbytesMikaContentType")
            .value(is(DEFAULT_BYTE_ANY_MINBYTES_MIKA_CONTENT_TYPE))
            .jsonPath("$.byteAnyMinbytesMika")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_MINBYTES_MIKA)))
            .jsonPath("$.byteAnyMaxbytesMikaContentType")
            .value(is(DEFAULT_BYTE_ANY_MAXBYTES_MIKA_CONTENT_TYPE))
            .jsonPath("$.byteAnyMaxbytesMika")
            .value(is(Base64Utils.encodeToString(DEFAULT_BYTE_ANY_MAXBYTES_MIKA)))
            .jsonPath("$.byteTextMika")
            .value(is(DEFAULT_BYTE_TEXT_MIKA.toString()))
            .jsonPath("$.byteTextRequiredMika")
            .value(is(DEFAULT_BYTE_TEXT_REQUIRED_MIKA.toString()));
    }

    @Test
    void getNonExistingFieldTestServiceImplEntity() {
        // Get the fieldTestServiceImplEntity
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putNewFieldTestServiceImplEntity() throws Exception {
        // Initialize the database
        fieldTestServiceImplEntityRepository.save(fieldTestServiceImplEntity).block();

        int databaseSizeBeforeUpdate = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();

        // Update the fieldTestServiceImplEntity
        FieldTestServiceImplEntity updatedFieldTestServiceImplEntity = fieldTestServiceImplEntityRepository
            .findById(fieldTestServiceImplEntity.getId())
            .block();
        updatedFieldTestServiceImplEntity
            .stringMika(UPDATED_STRING_MIKA)
            .stringRequiredMika(UPDATED_STRING_REQUIRED_MIKA)
            .stringMinlengthMika(UPDATED_STRING_MINLENGTH_MIKA)
            .stringMaxlengthMika(UPDATED_STRING_MAXLENGTH_MIKA)
            .stringPatternMika(UPDATED_STRING_PATTERN_MIKA)
            .integerMika(UPDATED_INTEGER_MIKA)
            .integerRequiredMika(UPDATED_INTEGER_REQUIRED_MIKA)
            .integerMinMika(UPDATED_INTEGER_MIN_MIKA)
            .integerMaxMika(UPDATED_INTEGER_MAX_MIKA)
            .longMika(UPDATED_LONG_MIKA)
            .longRequiredMika(UPDATED_LONG_REQUIRED_MIKA)
            .longMinMika(UPDATED_LONG_MIN_MIKA)
            .longMaxMika(UPDATED_LONG_MAX_MIKA)
            .floatMika(UPDATED_FLOAT_MIKA)
            .floatRequiredMika(UPDATED_FLOAT_REQUIRED_MIKA)
            .floatMinMika(UPDATED_FLOAT_MIN_MIKA)
            .floatMaxMika(UPDATED_FLOAT_MAX_MIKA)
            .doubleRequiredMika(UPDATED_DOUBLE_REQUIRED_MIKA)
            .doubleMinMika(UPDATED_DOUBLE_MIN_MIKA)
            .doubleMaxMika(UPDATED_DOUBLE_MAX_MIKA)
            .bigDecimalRequiredMika(UPDATED_BIG_DECIMAL_REQUIRED_MIKA)
            .bigDecimalMinMika(UPDATED_BIG_DECIMAL_MIN_MIKA)
            .bigDecimalMaxMika(UPDATED_BIG_DECIMAL_MAX_MIKA)
            .localDateMika(UPDATED_LOCAL_DATE_MIKA)
            .localDateRequiredMika(UPDATED_LOCAL_DATE_REQUIRED_MIKA)
            .instantMika(UPDATED_INSTANT_MIKA)
            .instanteRequiredMika(UPDATED_INSTANTE_REQUIRED_MIKA)
            .zonedDateTimeMika(UPDATED_ZONED_DATE_TIME_MIKA)
            .zonedDateTimeRequiredMika(UPDATED_ZONED_DATE_TIME_REQUIRED_MIKA)
            .durationMika(UPDATED_DURATION_MIKA)
            .durationRequiredMika(UPDATED_DURATION_REQUIRED_MIKA)
            .booleanMika(UPDATED_BOOLEAN_MIKA)
            .booleanRequiredMika(UPDATED_BOOLEAN_REQUIRED_MIKA)
            .enumMika(UPDATED_ENUM_MIKA)
            .enumRequiredMika(UPDATED_ENUM_REQUIRED_MIKA)
            .uuidMika(UPDATED_UUID_MIKA)
            .uuidRequiredMika(UPDATED_UUID_REQUIRED_MIKA)
            .byteImageMika(UPDATED_BYTE_IMAGE_MIKA)
            .byteImageMikaContentType(UPDATED_BYTE_IMAGE_MIKA_CONTENT_TYPE)
            .byteImageRequiredMika(UPDATED_BYTE_IMAGE_REQUIRED_MIKA)
            .byteImageRequiredMikaContentType(UPDATED_BYTE_IMAGE_REQUIRED_MIKA_CONTENT_TYPE)
            .byteImageMinbytesMika(UPDATED_BYTE_IMAGE_MINBYTES_MIKA)
            .byteImageMinbytesMikaContentType(UPDATED_BYTE_IMAGE_MINBYTES_MIKA_CONTENT_TYPE)
            .byteImageMaxbytesMika(UPDATED_BYTE_IMAGE_MAXBYTES_MIKA)
            .byteImageMaxbytesMikaContentType(UPDATED_BYTE_IMAGE_MAXBYTES_MIKA_CONTENT_TYPE)
            .byteAnyMika(UPDATED_BYTE_ANY_MIKA)
            .byteAnyMikaContentType(UPDATED_BYTE_ANY_MIKA_CONTENT_TYPE)
            .byteAnyRequiredMika(UPDATED_BYTE_ANY_REQUIRED_MIKA)
            .byteAnyRequiredMikaContentType(UPDATED_BYTE_ANY_REQUIRED_MIKA_CONTENT_TYPE)
            .byteAnyMinbytesMika(UPDATED_BYTE_ANY_MINBYTES_MIKA)
            .byteAnyMinbytesMikaContentType(UPDATED_BYTE_ANY_MINBYTES_MIKA_CONTENT_TYPE)
            .byteAnyMaxbytesMika(UPDATED_BYTE_ANY_MAXBYTES_MIKA)
            .byteAnyMaxbytesMikaContentType(UPDATED_BYTE_ANY_MAXBYTES_MIKA_CONTENT_TYPE)
            .byteTextMika(UPDATED_BYTE_TEXT_MIKA)
            .byteTextRequiredMika(UPDATED_BYTE_TEXT_REQUIRED_MIKA);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, updatedFieldTestServiceImplEntity.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(updatedFieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the FieldTestServiceImplEntity in the database
        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeUpdate);
        FieldTestServiceImplEntity testFieldTestServiceImplEntity = fieldTestServiceImplEntityList.get(
            fieldTestServiceImplEntityList.size() - 1
        );
        assertThat(testFieldTestServiceImplEntity.getStringMika()).isEqualTo(UPDATED_STRING_MIKA);
        assertThat(testFieldTestServiceImplEntity.getStringRequiredMika()).isEqualTo(UPDATED_STRING_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getStringMinlengthMika()).isEqualTo(UPDATED_STRING_MINLENGTH_MIKA);
        assertThat(testFieldTestServiceImplEntity.getStringMaxlengthMika()).isEqualTo(UPDATED_STRING_MAXLENGTH_MIKA);
        assertThat(testFieldTestServiceImplEntity.getStringPatternMika()).isEqualTo(UPDATED_STRING_PATTERN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getIntegerMika()).isEqualTo(UPDATED_INTEGER_MIKA);
        assertThat(testFieldTestServiceImplEntity.getIntegerRequiredMika()).isEqualTo(UPDATED_INTEGER_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getIntegerMinMika()).isEqualTo(UPDATED_INTEGER_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getIntegerMaxMika()).isEqualTo(UPDATED_INTEGER_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLongMika()).isEqualTo(UPDATED_LONG_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLongRequiredMika()).isEqualTo(UPDATED_LONG_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLongMinMika()).isEqualTo(UPDATED_LONG_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLongMaxMika()).isEqualTo(UPDATED_LONG_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getFloatMika()).isEqualTo(UPDATED_FLOAT_MIKA);
        assertThat(testFieldTestServiceImplEntity.getFloatRequiredMika()).isEqualTo(UPDATED_FLOAT_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getFloatMinMika()).isEqualTo(UPDATED_FLOAT_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getFloatMaxMika()).isEqualTo(UPDATED_FLOAT_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDoubleRequiredMika()).isEqualTo(UPDATED_DOUBLE_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDoubleMinMika()).isEqualTo(UPDATED_DOUBLE_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDoubleMaxMika()).isEqualTo(UPDATED_DOUBLE_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBigDecimalRequiredMika()).isEqualTo(UPDATED_BIG_DECIMAL_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBigDecimalMinMika()).isEqualTo(UPDATED_BIG_DECIMAL_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBigDecimalMaxMika()).isEqualTo(UPDATED_BIG_DECIMAL_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLocalDateMika()).isEqualTo(UPDATED_LOCAL_DATE_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLocalDateRequiredMika()).isEqualTo(UPDATED_LOCAL_DATE_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getInstantMika()).isEqualTo(UPDATED_INSTANT_MIKA);
        assertThat(testFieldTestServiceImplEntity.getInstanteRequiredMika()).isEqualTo(UPDATED_INSTANTE_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getZonedDateTimeMika()).isEqualTo(UPDATED_ZONED_DATE_TIME_MIKA);
        assertThat(testFieldTestServiceImplEntity.getZonedDateTimeRequiredMika()).isEqualTo(UPDATED_ZONED_DATE_TIME_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDurationMika()).isEqualTo(UPDATED_DURATION_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDurationRequiredMika()).isEqualTo(UPDATED_DURATION_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBooleanMika()).isEqualTo(UPDATED_BOOLEAN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBooleanRequiredMika()).isEqualTo(UPDATED_BOOLEAN_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getEnumMika()).isEqualTo(UPDATED_ENUM_MIKA);
        assertThat(testFieldTestServiceImplEntity.getEnumRequiredMika()).isEqualTo(UPDATED_ENUM_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getUuidMika()).isEqualTo(UPDATED_UUID_MIKA);
        assertThat(testFieldTestServiceImplEntity.getUuidRequiredMika()).isEqualTo(UPDATED_UUID_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageMika()).isEqualTo(UPDATED_BYTE_IMAGE_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageMikaContentType()).isEqualTo(UPDATED_BYTE_IMAGE_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteImageRequiredMika()).isEqualTo(UPDATED_BYTE_IMAGE_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageRequiredMikaContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_REQUIRED_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteImageMinbytesMika()).isEqualTo(UPDATED_BYTE_IMAGE_MINBYTES_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageMinbytesMikaContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_MINBYTES_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteImageMaxbytesMika()).isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageMaxbytesMikaContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMika()).isEqualTo(UPDATED_BYTE_ANY_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMikaContentType()).isEqualTo(UPDATED_BYTE_ANY_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteAnyRequiredMika()).isEqualTo(UPDATED_BYTE_ANY_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteAnyRequiredMikaContentType())
            .isEqualTo(UPDATED_BYTE_ANY_REQUIRED_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMinbytesMika()).isEqualTo(UPDATED_BYTE_ANY_MINBYTES_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMinbytesMikaContentType())
            .isEqualTo(UPDATED_BYTE_ANY_MINBYTES_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMaxbytesMika()).isEqualTo(UPDATED_BYTE_ANY_MAXBYTES_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMaxbytesMikaContentType())
            .isEqualTo(UPDATED_BYTE_ANY_MAXBYTES_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteTextMika()).isEqualTo(UPDATED_BYTE_TEXT_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteTextRequiredMika()).isEqualTo(UPDATED_BYTE_TEXT_REQUIRED_MIKA);
    }

    @Test
    void putNonExistingFieldTestServiceImplEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();
        fieldTestServiceImplEntity.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, fieldTestServiceImplEntity.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestServiceImplEntity in the database
        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchFieldTestServiceImplEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();
        fieldTestServiceImplEntity.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestServiceImplEntity in the database
        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamFieldTestServiceImplEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();
        fieldTestServiceImplEntity.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the FieldTestServiceImplEntity in the database
        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateFieldTestServiceImplEntityWithPatch() throws Exception {
        // Initialize the database
        fieldTestServiceImplEntityRepository.save(fieldTestServiceImplEntity).block();

        int databaseSizeBeforeUpdate = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();

        // Update the fieldTestServiceImplEntity using partial update
        FieldTestServiceImplEntity partialUpdatedFieldTestServiceImplEntity = new FieldTestServiceImplEntity();
        partialUpdatedFieldTestServiceImplEntity.setId(fieldTestServiceImplEntity.getId());

        partialUpdatedFieldTestServiceImplEntity
            .stringRequiredMika(UPDATED_STRING_REQUIRED_MIKA)
            .stringMaxlengthMika(UPDATED_STRING_MAXLENGTH_MIKA)
            .integerMika(UPDATED_INTEGER_MIKA)
            .integerMinMika(UPDATED_INTEGER_MIN_MIKA)
            .longRequiredMika(UPDATED_LONG_REQUIRED_MIKA)
            .longMinMika(UPDATED_LONG_MIN_MIKA)
            .longMaxMika(UPDATED_LONG_MAX_MIKA)
            .floatMika(UPDATED_FLOAT_MIKA)
            .floatRequiredMika(UPDATED_FLOAT_REQUIRED_MIKA)
            .doubleMinMika(UPDATED_DOUBLE_MIN_MIKA)
            .doubleMaxMika(UPDATED_DOUBLE_MAX_MIKA)
            .bigDecimalMinMika(UPDATED_BIG_DECIMAL_MIN_MIKA)
            .bigDecimalMaxMika(UPDATED_BIG_DECIMAL_MAX_MIKA)
            .zonedDateTimeRequiredMika(UPDATED_ZONED_DATE_TIME_REQUIRED_MIKA)
            .durationRequiredMika(UPDATED_DURATION_REQUIRED_MIKA)
            .booleanMika(UPDATED_BOOLEAN_MIKA)
            .booleanRequiredMika(UPDATED_BOOLEAN_REQUIRED_MIKA)
            .enumMika(UPDATED_ENUM_MIKA)
            .byteImageMaxbytesMika(UPDATED_BYTE_IMAGE_MAXBYTES_MIKA)
            .byteImageMaxbytesMikaContentType(UPDATED_BYTE_IMAGE_MAXBYTES_MIKA_CONTENT_TYPE)
            .byteAnyMaxbytesMika(UPDATED_BYTE_ANY_MAXBYTES_MIKA)
            .byteAnyMaxbytesMikaContentType(UPDATED_BYTE_ANY_MAXBYTES_MIKA_CONTENT_TYPE);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedFieldTestServiceImplEntity.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedFieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the FieldTestServiceImplEntity in the database
        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeUpdate);
        FieldTestServiceImplEntity testFieldTestServiceImplEntity = fieldTestServiceImplEntityList.get(
            fieldTestServiceImplEntityList.size() - 1
        );
        assertThat(testFieldTestServiceImplEntity.getStringMika()).isEqualTo(DEFAULT_STRING_MIKA);
        assertThat(testFieldTestServiceImplEntity.getStringRequiredMika()).isEqualTo(UPDATED_STRING_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getStringMinlengthMika()).isEqualTo(DEFAULT_STRING_MINLENGTH_MIKA);
        assertThat(testFieldTestServiceImplEntity.getStringMaxlengthMika()).isEqualTo(UPDATED_STRING_MAXLENGTH_MIKA);
        assertThat(testFieldTestServiceImplEntity.getStringPatternMika()).isEqualTo(DEFAULT_STRING_PATTERN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getIntegerMika()).isEqualTo(UPDATED_INTEGER_MIKA);
        assertThat(testFieldTestServiceImplEntity.getIntegerRequiredMika()).isEqualTo(DEFAULT_INTEGER_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getIntegerMinMika()).isEqualTo(UPDATED_INTEGER_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getIntegerMaxMika()).isEqualTo(DEFAULT_INTEGER_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLongMika()).isEqualTo(DEFAULT_LONG_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLongRequiredMika()).isEqualTo(UPDATED_LONG_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLongMinMika()).isEqualTo(UPDATED_LONG_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLongMaxMika()).isEqualTo(UPDATED_LONG_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getFloatMika()).isEqualTo(UPDATED_FLOAT_MIKA);
        assertThat(testFieldTestServiceImplEntity.getFloatRequiredMika()).isEqualTo(UPDATED_FLOAT_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getFloatMinMika()).isEqualTo(DEFAULT_FLOAT_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getFloatMaxMika()).isEqualTo(DEFAULT_FLOAT_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDoubleRequiredMika()).isEqualTo(DEFAULT_DOUBLE_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDoubleMinMika()).isEqualTo(UPDATED_DOUBLE_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDoubleMaxMika()).isEqualTo(UPDATED_DOUBLE_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBigDecimalRequiredMika()).isEqualByComparingTo(DEFAULT_BIG_DECIMAL_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBigDecimalMinMika()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBigDecimalMaxMika()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLocalDateMika()).isEqualTo(DEFAULT_LOCAL_DATE_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLocalDateRequiredMika()).isEqualTo(DEFAULT_LOCAL_DATE_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getInstantMika()).isEqualTo(DEFAULT_INSTANT_MIKA);
        assertThat(testFieldTestServiceImplEntity.getInstanteRequiredMika()).isEqualTo(DEFAULT_INSTANTE_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getZonedDateTimeMika()).isEqualTo(DEFAULT_ZONED_DATE_TIME_MIKA);
        assertThat(testFieldTestServiceImplEntity.getZonedDateTimeRequiredMika()).isEqualTo(UPDATED_ZONED_DATE_TIME_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDurationMika()).isEqualTo(DEFAULT_DURATION_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDurationRequiredMika()).isEqualTo(UPDATED_DURATION_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBooleanMika()).isEqualTo(UPDATED_BOOLEAN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBooleanRequiredMika()).isEqualTo(UPDATED_BOOLEAN_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getEnumMika()).isEqualTo(UPDATED_ENUM_MIKA);
        assertThat(testFieldTestServiceImplEntity.getEnumRequiredMika()).isEqualTo(DEFAULT_ENUM_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getUuidMika()).isEqualTo(DEFAULT_UUID_MIKA);
        assertThat(testFieldTestServiceImplEntity.getUuidRequiredMika()).isEqualTo(DEFAULT_UUID_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageMika()).isEqualTo(DEFAULT_BYTE_IMAGE_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageMikaContentType()).isEqualTo(DEFAULT_BYTE_IMAGE_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteImageRequiredMika()).isEqualTo(DEFAULT_BYTE_IMAGE_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageRequiredMikaContentType())
            .isEqualTo(DEFAULT_BYTE_IMAGE_REQUIRED_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteImageMinbytesMika()).isEqualTo(DEFAULT_BYTE_IMAGE_MINBYTES_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageMinbytesMikaContentType())
            .isEqualTo(DEFAULT_BYTE_IMAGE_MINBYTES_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteImageMaxbytesMika()).isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageMaxbytesMikaContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMika()).isEqualTo(DEFAULT_BYTE_ANY_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMikaContentType()).isEqualTo(DEFAULT_BYTE_ANY_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteAnyRequiredMika()).isEqualTo(DEFAULT_BYTE_ANY_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteAnyRequiredMikaContentType())
            .isEqualTo(DEFAULT_BYTE_ANY_REQUIRED_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMinbytesMika()).isEqualTo(DEFAULT_BYTE_ANY_MINBYTES_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMinbytesMikaContentType())
            .isEqualTo(DEFAULT_BYTE_ANY_MINBYTES_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMaxbytesMika()).isEqualTo(UPDATED_BYTE_ANY_MAXBYTES_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMaxbytesMikaContentType())
            .isEqualTo(UPDATED_BYTE_ANY_MAXBYTES_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteTextMika()).isEqualTo(DEFAULT_BYTE_TEXT_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteTextRequiredMika()).isEqualTo(DEFAULT_BYTE_TEXT_REQUIRED_MIKA);
    }

    @Test
    void fullUpdateFieldTestServiceImplEntityWithPatch() throws Exception {
        // Initialize the database
        fieldTestServiceImplEntityRepository.save(fieldTestServiceImplEntity).block();

        int databaseSizeBeforeUpdate = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();

        // Update the fieldTestServiceImplEntity using partial update
        FieldTestServiceImplEntity partialUpdatedFieldTestServiceImplEntity = new FieldTestServiceImplEntity();
        partialUpdatedFieldTestServiceImplEntity.setId(fieldTestServiceImplEntity.getId());

        partialUpdatedFieldTestServiceImplEntity
            .stringMika(UPDATED_STRING_MIKA)
            .stringRequiredMika(UPDATED_STRING_REQUIRED_MIKA)
            .stringMinlengthMika(UPDATED_STRING_MINLENGTH_MIKA)
            .stringMaxlengthMika(UPDATED_STRING_MAXLENGTH_MIKA)
            .stringPatternMika(UPDATED_STRING_PATTERN_MIKA)
            .integerMika(UPDATED_INTEGER_MIKA)
            .integerRequiredMika(UPDATED_INTEGER_REQUIRED_MIKA)
            .integerMinMika(UPDATED_INTEGER_MIN_MIKA)
            .integerMaxMika(UPDATED_INTEGER_MAX_MIKA)
            .longMika(UPDATED_LONG_MIKA)
            .longRequiredMika(UPDATED_LONG_REQUIRED_MIKA)
            .longMinMika(UPDATED_LONG_MIN_MIKA)
            .longMaxMika(UPDATED_LONG_MAX_MIKA)
            .floatMika(UPDATED_FLOAT_MIKA)
            .floatRequiredMika(UPDATED_FLOAT_REQUIRED_MIKA)
            .floatMinMika(UPDATED_FLOAT_MIN_MIKA)
            .floatMaxMika(UPDATED_FLOAT_MAX_MIKA)
            .doubleRequiredMika(UPDATED_DOUBLE_REQUIRED_MIKA)
            .doubleMinMika(UPDATED_DOUBLE_MIN_MIKA)
            .doubleMaxMika(UPDATED_DOUBLE_MAX_MIKA)
            .bigDecimalRequiredMika(UPDATED_BIG_DECIMAL_REQUIRED_MIKA)
            .bigDecimalMinMika(UPDATED_BIG_DECIMAL_MIN_MIKA)
            .bigDecimalMaxMika(UPDATED_BIG_DECIMAL_MAX_MIKA)
            .localDateMika(UPDATED_LOCAL_DATE_MIKA)
            .localDateRequiredMika(UPDATED_LOCAL_DATE_REQUIRED_MIKA)
            .instantMika(UPDATED_INSTANT_MIKA)
            .instanteRequiredMika(UPDATED_INSTANTE_REQUIRED_MIKA)
            .zonedDateTimeMika(UPDATED_ZONED_DATE_TIME_MIKA)
            .zonedDateTimeRequiredMika(UPDATED_ZONED_DATE_TIME_REQUIRED_MIKA)
            .durationMika(UPDATED_DURATION_MIKA)
            .durationRequiredMika(UPDATED_DURATION_REQUIRED_MIKA)
            .booleanMika(UPDATED_BOOLEAN_MIKA)
            .booleanRequiredMika(UPDATED_BOOLEAN_REQUIRED_MIKA)
            .enumMika(UPDATED_ENUM_MIKA)
            .enumRequiredMika(UPDATED_ENUM_REQUIRED_MIKA)
            .uuidMika(UPDATED_UUID_MIKA)
            .uuidRequiredMika(UPDATED_UUID_REQUIRED_MIKA)
            .byteImageMika(UPDATED_BYTE_IMAGE_MIKA)
            .byteImageMikaContentType(UPDATED_BYTE_IMAGE_MIKA_CONTENT_TYPE)
            .byteImageRequiredMika(UPDATED_BYTE_IMAGE_REQUIRED_MIKA)
            .byteImageRequiredMikaContentType(UPDATED_BYTE_IMAGE_REQUIRED_MIKA_CONTENT_TYPE)
            .byteImageMinbytesMika(UPDATED_BYTE_IMAGE_MINBYTES_MIKA)
            .byteImageMinbytesMikaContentType(UPDATED_BYTE_IMAGE_MINBYTES_MIKA_CONTENT_TYPE)
            .byteImageMaxbytesMika(UPDATED_BYTE_IMAGE_MAXBYTES_MIKA)
            .byteImageMaxbytesMikaContentType(UPDATED_BYTE_IMAGE_MAXBYTES_MIKA_CONTENT_TYPE)
            .byteAnyMika(UPDATED_BYTE_ANY_MIKA)
            .byteAnyMikaContentType(UPDATED_BYTE_ANY_MIKA_CONTENT_TYPE)
            .byteAnyRequiredMika(UPDATED_BYTE_ANY_REQUIRED_MIKA)
            .byteAnyRequiredMikaContentType(UPDATED_BYTE_ANY_REQUIRED_MIKA_CONTENT_TYPE)
            .byteAnyMinbytesMika(UPDATED_BYTE_ANY_MINBYTES_MIKA)
            .byteAnyMinbytesMikaContentType(UPDATED_BYTE_ANY_MINBYTES_MIKA_CONTENT_TYPE)
            .byteAnyMaxbytesMika(UPDATED_BYTE_ANY_MAXBYTES_MIKA)
            .byteAnyMaxbytesMikaContentType(UPDATED_BYTE_ANY_MAXBYTES_MIKA_CONTENT_TYPE)
            .byteTextMika(UPDATED_BYTE_TEXT_MIKA)
            .byteTextRequiredMika(UPDATED_BYTE_TEXT_REQUIRED_MIKA);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedFieldTestServiceImplEntity.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(partialUpdatedFieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the FieldTestServiceImplEntity in the database
        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeUpdate);
        FieldTestServiceImplEntity testFieldTestServiceImplEntity = fieldTestServiceImplEntityList.get(
            fieldTestServiceImplEntityList.size() - 1
        );
        assertThat(testFieldTestServiceImplEntity.getStringMika()).isEqualTo(UPDATED_STRING_MIKA);
        assertThat(testFieldTestServiceImplEntity.getStringRequiredMika()).isEqualTo(UPDATED_STRING_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getStringMinlengthMika()).isEqualTo(UPDATED_STRING_MINLENGTH_MIKA);
        assertThat(testFieldTestServiceImplEntity.getStringMaxlengthMika()).isEqualTo(UPDATED_STRING_MAXLENGTH_MIKA);
        assertThat(testFieldTestServiceImplEntity.getStringPatternMika()).isEqualTo(UPDATED_STRING_PATTERN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getIntegerMika()).isEqualTo(UPDATED_INTEGER_MIKA);
        assertThat(testFieldTestServiceImplEntity.getIntegerRequiredMika()).isEqualTo(UPDATED_INTEGER_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getIntegerMinMika()).isEqualTo(UPDATED_INTEGER_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getIntegerMaxMika()).isEqualTo(UPDATED_INTEGER_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLongMika()).isEqualTo(UPDATED_LONG_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLongRequiredMika()).isEqualTo(UPDATED_LONG_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLongMinMika()).isEqualTo(UPDATED_LONG_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLongMaxMika()).isEqualTo(UPDATED_LONG_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getFloatMika()).isEqualTo(UPDATED_FLOAT_MIKA);
        assertThat(testFieldTestServiceImplEntity.getFloatRequiredMika()).isEqualTo(UPDATED_FLOAT_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getFloatMinMika()).isEqualTo(UPDATED_FLOAT_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getFloatMaxMika()).isEqualTo(UPDATED_FLOAT_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDoubleRequiredMika()).isEqualTo(UPDATED_DOUBLE_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDoubleMinMika()).isEqualTo(UPDATED_DOUBLE_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDoubleMaxMika()).isEqualTo(UPDATED_DOUBLE_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBigDecimalRequiredMika()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBigDecimalMinMika()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MIN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBigDecimalMaxMika()).isEqualByComparingTo(UPDATED_BIG_DECIMAL_MAX_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLocalDateMika()).isEqualTo(UPDATED_LOCAL_DATE_MIKA);
        assertThat(testFieldTestServiceImplEntity.getLocalDateRequiredMika()).isEqualTo(UPDATED_LOCAL_DATE_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getInstantMika()).isEqualTo(UPDATED_INSTANT_MIKA);
        assertThat(testFieldTestServiceImplEntity.getInstanteRequiredMika()).isEqualTo(UPDATED_INSTANTE_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getZonedDateTimeMika()).isEqualTo(UPDATED_ZONED_DATE_TIME_MIKA);
        assertThat(testFieldTestServiceImplEntity.getZonedDateTimeRequiredMika()).isEqualTo(UPDATED_ZONED_DATE_TIME_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDurationMika()).isEqualTo(UPDATED_DURATION_MIKA);
        assertThat(testFieldTestServiceImplEntity.getDurationRequiredMika()).isEqualTo(UPDATED_DURATION_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBooleanMika()).isEqualTo(UPDATED_BOOLEAN_MIKA);
        assertThat(testFieldTestServiceImplEntity.getBooleanRequiredMika()).isEqualTo(UPDATED_BOOLEAN_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getEnumMika()).isEqualTo(UPDATED_ENUM_MIKA);
        assertThat(testFieldTestServiceImplEntity.getEnumRequiredMika()).isEqualTo(UPDATED_ENUM_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getUuidMika()).isEqualTo(UPDATED_UUID_MIKA);
        assertThat(testFieldTestServiceImplEntity.getUuidRequiredMika()).isEqualTo(UPDATED_UUID_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageMika()).isEqualTo(UPDATED_BYTE_IMAGE_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageMikaContentType()).isEqualTo(UPDATED_BYTE_IMAGE_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteImageRequiredMika()).isEqualTo(UPDATED_BYTE_IMAGE_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageRequiredMikaContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_REQUIRED_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteImageMinbytesMika()).isEqualTo(UPDATED_BYTE_IMAGE_MINBYTES_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageMinbytesMikaContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_MINBYTES_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteImageMaxbytesMika()).isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteImageMaxbytesMikaContentType())
            .isEqualTo(UPDATED_BYTE_IMAGE_MAXBYTES_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMika()).isEqualTo(UPDATED_BYTE_ANY_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMikaContentType()).isEqualTo(UPDATED_BYTE_ANY_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteAnyRequiredMika()).isEqualTo(UPDATED_BYTE_ANY_REQUIRED_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteAnyRequiredMikaContentType())
            .isEqualTo(UPDATED_BYTE_ANY_REQUIRED_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMinbytesMika()).isEqualTo(UPDATED_BYTE_ANY_MINBYTES_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMinbytesMikaContentType())
            .isEqualTo(UPDATED_BYTE_ANY_MINBYTES_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMaxbytesMika()).isEqualTo(UPDATED_BYTE_ANY_MAXBYTES_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteAnyMaxbytesMikaContentType())
            .isEqualTo(UPDATED_BYTE_ANY_MAXBYTES_MIKA_CONTENT_TYPE);
        assertThat(testFieldTestServiceImplEntity.getByteTextMika()).isEqualTo(UPDATED_BYTE_TEXT_MIKA);
        assertThat(testFieldTestServiceImplEntity.getByteTextRequiredMika()).isEqualTo(UPDATED_BYTE_TEXT_REQUIRED_MIKA);
    }

    @Test
    void patchNonExistingFieldTestServiceImplEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();
        fieldTestServiceImplEntity.setId(count.incrementAndGet());

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, fieldTestServiceImplEntity.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestServiceImplEntity in the database
        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchFieldTestServiceImplEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();
        fieldTestServiceImplEntity.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, count.incrementAndGet())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the FieldTestServiceImplEntity in the database
        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamFieldTestServiceImplEntity() throws Exception {
        int databaseSizeBeforeUpdate = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();
        fieldTestServiceImplEntity.setId(count.incrementAndGet());

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(TestUtil.convertObjectToJsonBytes(fieldTestServiceImplEntity))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the FieldTestServiceImplEntity in the database
        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteFieldTestServiceImplEntity() {
        // Initialize the database
        fieldTestServiceImplEntityRepository.save(fieldTestServiceImplEntity).block();

        int databaseSizeBeforeDelete = fieldTestServiceImplEntityRepository.findAll().collectList().block().size();

        // Delete the fieldTestServiceImplEntity
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, fieldTestServiceImplEntity.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        List<FieldTestServiceImplEntity> fieldTestServiceImplEntityList = fieldTestServiceImplEntityRepository
            .findAll()
            .collectList()
            .block();
        assertThat(fieldTestServiceImplEntityList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
