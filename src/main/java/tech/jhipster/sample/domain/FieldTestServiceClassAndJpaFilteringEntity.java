package tech.jhipster.sample.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;
import javax.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import tech.jhipster.sample.domain.enumeration.EnumFieldClass;
import tech.jhipster.sample.domain.enumeration.EnumRequiredFieldClass;

/**
 * A FieldTestServiceClassAndJpaFilteringEntity.
 */
@Table("field_test_service_class_and_jpa_filtering_entity")
public class FieldTestServiceClassAndJpaFilteringEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("string_bob")
    private String stringBob;

    @NotNull(message = "must not be null")
    @Column("string_required_bob")
    private String stringRequiredBob;

    @Size(min = 0)
    @Column("string_minlength_bob")
    private String stringMinlengthBob;

    @Size(max = 20)
    @Column("string_maxlength_bob")
    private String stringMaxlengthBob;

    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    @Column("string_pattern_bob")
    private String stringPatternBob;

    @Column("integer_bob")
    private Integer integerBob;

    @NotNull(message = "must not be null")
    @Column("integer_required_bob")
    private Integer integerRequiredBob;

    @Min(value = 0)
    @Column("integer_min_bob")
    private Integer integerMinBob;

    @Max(value = 100)
    @Column("integer_max_bob")
    private Integer integerMaxBob;

    @Column("long_bob")
    private Long longBob;

    @NotNull(message = "must not be null")
    @Column("long_required_bob")
    private Long longRequiredBob;

    @Min(value = 0L)
    @Column("long_min_bob")
    private Long longMinBob;

    @Max(value = 100L)
    @Column("long_max_bob")
    private Long longMaxBob;

    @Column("float_bob")
    private Float floatBob;

    @NotNull(message = "must not be null")
    @Column("float_required_bob")
    private Float floatRequiredBob;

    @DecimalMin(value = "0")
    @Column("float_min_bob")
    private Float floatMinBob;

    @DecimalMax(value = "100")
    @Column("float_max_bob")
    private Float floatMaxBob;

    @NotNull(message = "must not be null")
    @Column("double_required_bob")
    private Double doubleRequiredBob;

    @DecimalMin(value = "0")
    @Column("double_min_bob")
    private Double doubleMinBob;

    @DecimalMax(value = "100")
    @Column("double_max_bob")
    private Double doubleMaxBob;

    @NotNull(message = "must not be null")
    @Column("big_decimal_required_bob")
    private BigDecimal bigDecimalRequiredBob;

    @DecimalMin(value = "0")
    @Column("big_decimal_min_bob")
    private BigDecimal bigDecimalMinBob;

    @DecimalMax(value = "100")
    @Column("big_decimal_max_bob")
    private BigDecimal bigDecimalMaxBob;

    @Column("local_date_bob")
    private LocalDate localDateBob;

    @NotNull(message = "must not be null")
    @Column("local_date_required_bob")
    private LocalDate localDateRequiredBob;

    @Column("instant_bob")
    private Instant instantBob;

    @NotNull(message = "must not be null")
    @Column("instante_required_bob")
    private Instant instanteRequiredBob;

    @Column("zoned_date_time_bob")
    private ZonedDateTime zonedDateTimeBob;

    @NotNull(message = "must not be null")
    @Column("zoned_date_time_required_bob")
    private ZonedDateTime zonedDateTimeRequiredBob;

    @Column("duration_bob")
    private Duration durationBob;

    @NotNull(message = "must not be null")
    @Column("duration_required_bob")
    private Duration durationRequiredBob;

    @Column("boolean_bob")
    private Boolean booleanBob;

    @NotNull(message = "must not be null")
    @Column("boolean_required_bob")
    private Boolean booleanRequiredBob;

    @Column("enum_bob")
    private EnumFieldClass enumBob;

    @NotNull(message = "must not be null")
    @Column("enum_required_bob")
    private EnumRequiredFieldClass enumRequiredBob;

    @Column("uuid_bob")
    private UUID uuidBob;

    @NotNull(message = "must not be null")
    @Column("uuid_required_bob")
    private UUID uuidRequiredBob;

    @Column("byte_image_bob")
    private byte[] byteImageBob;

    @Column("byte_image_bob_content_type")
    private String byteImageBobContentType;

    @Column("byte_image_required_bob")
    private byte[] byteImageRequiredBob;

    @NotNull
    @Column("byte_image_required_bob_content_type")
    private String byteImageRequiredBobContentType;

    @Column("byte_image_minbytes_bob")
    private byte[] byteImageMinbytesBob;

    @Column("byte_image_minbytes_bob_content_type")
    private String byteImageMinbytesBobContentType;

    @Column("byte_image_maxbytes_bob")
    private byte[] byteImageMaxbytesBob;

    @Column("byte_image_maxbytes_bob_content_type")
    private String byteImageMaxbytesBobContentType;

    @Column("byte_any_bob")
    private byte[] byteAnyBob;

    @Column("byte_any_bob_content_type")
    private String byteAnyBobContentType;

    @Column("byte_any_required_bob")
    private byte[] byteAnyRequiredBob;

    @NotNull
    @Column("byte_any_required_bob_content_type")
    private String byteAnyRequiredBobContentType;

    @Column("byte_any_minbytes_bob")
    private byte[] byteAnyMinbytesBob;

    @Column("byte_any_minbytes_bob_content_type")
    private String byteAnyMinbytesBobContentType;

    @Column("byte_any_maxbytes_bob")
    private byte[] byteAnyMaxbytesBob;

    @Column("byte_any_maxbytes_bob_content_type")
    private String byteAnyMaxbytesBobContentType;

    @Column("byte_text_bob")
    private String byteTextBob;

    @Column("byte_text_required_bob")
    private String byteTextRequiredBob;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public FieldTestServiceClassAndJpaFilteringEntity id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStringBob() {
        return this.stringBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity stringBob(String stringBob) {
        this.setStringBob(stringBob);
        return this;
    }

    public void setStringBob(String stringBob) {
        this.stringBob = stringBob;
    }

    public String getStringRequiredBob() {
        return this.stringRequiredBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity stringRequiredBob(String stringRequiredBob) {
        this.setStringRequiredBob(stringRequiredBob);
        return this;
    }

    public void setStringRequiredBob(String stringRequiredBob) {
        this.stringRequiredBob = stringRequiredBob;
    }

    public String getStringMinlengthBob() {
        return this.stringMinlengthBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity stringMinlengthBob(String stringMinlengthBob) {
        this.setStringMinlengthBob(stringMinlengthBob);
        return this;
    }

    public void setStringMinlengthBob(String stringMinlengthBob) {
        this.stringMinlengthBob = stringMinlengthBob;
    }

    public String getStringMaxlengthBob() {
        return this.stringMaxlengthBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity stringMaxlengthBob(String stringMaxlengthBob) {
        this.setStringMaxlengthBob(stringMaxlengthBob);
        return this;
    }

    public void setStringMaxlengthBob(String stringMaxlengthBob) {
        this.stringMaxlengthBob = stringMaxlengthBob;
    }

    public String getStringPatternBob() {
        return this.stringPatternBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity stringPatternBob(String stringPatternBob) {
        this.setStringPatternBob(stringPatternBob);
        return this;
    }

    public void setStringPatternBob(String stringPatternBob) {
        this.stringPatternBob = stringPatternBob;
    }

    public Integer getIntegerBob() {
        return this.integerBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity integerBob(Integer integerBob) {
        this.setIntegerBob(integerBob);
        return this;
    }

    public void setIntegerBob(Integer integerBob) {
        this.integerBob = integerBob;
    }

    public Integer getIntegerRequiredBob() {
        return this.integerRequiredBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity integerRequiredBob(Integer integerRequiredBob) {
        this.setIntegerRequiredBob(integerRequiredBob);
        return this;
    }

    public void setIntegerRequiredBob(Integer integerRequiredBob) {
        this.integerRequiredBob = integerRequiredBob;
    }

    public Integer getIntegerMinBob() {
        return this.integerMinBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity integerMinBob(Integer integerMinBob) {
        this.setIntegerMinBob(integerMinBob);
        return this;
    }

    public void setIntegerMinBob(Integer integerMinBob) {
        this.integerMinBob = integerMinBob;
    }

    public Integer getIntegerMaxBob() {
        return this.integerMaxBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity integerMaxBob(Integer integerMaxBob) {
        this.setIntegerMaxBob(integerMaxBob);
        return this;
    }

    public void setIntegerMaxBob(Integer integerMaxBob) {
        this.integerMaxBob = integerMaxBob;
    }

    public Long getLongBob() {
        return this.longBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity longBob(Long longBob) {
        this.setLongBob(longBob);
        return this;
    }

    public void setLongBob(Long longBob) {
        this.longBob = longBob;
    }

    public Long getLongRequiredBob() {
        return this.longRequiredBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity longRequiredBob(Long longRequiredBob) {
        this.setLongRequiredBob(longRequiredBob);
        return this;
    }

    public void setLongRequiredBob(Long longRequiredBob) {
        this.longRequiredBob = longRequiredBob;
    }

    public Long getLongMinBob() {
        return this.longMinBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity longMinBob(Long longMinBob) {
        this.setLongMinBob(longMinBob);
        return this;
    }

    public void setLongMinBob(Long longMinBob) {
        this.longMinBob = longMinBob;
    }

    public Long getLongMaxBob() {
        return this.longMaxBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity longMaxBob(Long longMaxBob) {
        this.setLongMaxBob(longMaxBob);
        return this;
    }

    public void setLongMaxBob(Long longMaxBob) {
        this.longMaxBob = longMaxBob;
    }

    public Float getFloatBob() {
        return this.floatBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity floatBob(Float floatBob) {
        this.setFloatBob(floatBob);
        return this;
    }

    public void setFloatBob(Float floatBob) {
        this.floatBob = floatBob;
    }

    public Float getFloatRequiredBob() {
        return this.floatRequiredBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity floatRequiredBob(Float floatRequiredBob) {
        this.setFloatRequiredBob(floatRequiredBob);
        return this;
    }

    public void setFloatRequiredBob(Float floatRequiredBob) {
        this.floatRequiredBob = floatRequiredBob;
    }

    public Float getFloatMinBob() {
        return this.floatMinBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity floatMinBob(Float floatMinBob) {
        this.setFloatMinBob(floatMinBob);
        return this;
    }

    public void setFloatMinBob(Float floatMinBob) {
        this.floatMinBob = floatMinBob;
    }

    public Float getFloatMaxBob() {
        return this.floatMaxBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity floatMaxBob(Float floatMaxBob) {
        this.setFloatMaxBob(floatMaxBob);
        return this;
    }

    public void setFloatMaxBob(Float floatMaxBob) {
        this.floatMaxBob = floatMaxBob;
    }

    public Double getDoubleRequiredBob() {
        return this.doubleRequiredBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity doubleRequiredBob(Double doubleRequiredBob) {
        this.setDoubleRequiredBob(doubleRequiredBob);
        return this;
    }

    public void setDoubleRequiredBob(Double doubleRequiredBob) {
        this.doubleRequiredBob = doubleRequiredBob;
    }

    public Double getDoubleMinBob() {
        return this.doubleMinBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity doubleMinBob(Double doubleMinBob) {
        this.setDoubleMinBob(doubleMinBob);
        return this;
    }

    public void setDoubleMinBob(Double doubleMinBob) {
        this.doubleMinBob = doubleMinBob;
    }

    public Double getDoubleMaxBob() {
        return this.doubleMaxBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity doubleMaxBob(Double doubleMaxBob) {
        this.setDoubleMaxBob(doubleMaxBob);
        return this;
    }

    public void setDoubleMaxBob(Double doubleMaxBob) {
        this.doubleMaxBob = doubleMaxBob;
    }

    public BigDecimal getBigDecimalRequiredBob() {
        return this.bigDecimalRequiredBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity bigDecimalRequiredBob(BigDecimal bigDecimalRequiredBob) {
        this.setBigDecimalRequiredBob(bigDecimalRequiredBob);
        return this;
    }

    public void setBigDecimalRequiredBob(BigDecimal bigDecimalRequiredBob) {
        this.bigDecimalRequiredBob = bigDecimalRequiredBob != null ? bigDecimalRequiredBob.stripTrailingZeros() : null;
    }

    public BigDecimal getBigDecimalMinBob() {
        return this.bigDecimalMinBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity bigDecimalMinBob(BigDecimal bigDecimalMinBob) {
        this.setBigDecimalMinBob(bigDecimalMinBob);
        return this;
    }

    public void setBigDecimalMinBob(BigDecimal bigDecimalMinBob) {
        this.bigDecimalMinBob = bigDecimalMinBob != null ? bigDecimalMinBob.stripTrailingZeros() : null;
    }

    public BigDecimal getBigDecimalMaxBob() {
        return this.bigDecimalMaxBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity bigDecimalMaxBob(BigDecimal bigDecimalMaxBob) {
        this.setBigDecimalMaxBob(bigDecimalMaxBob);
        return this;
    }

    public void setBigDecimalMaxBob(BigDecimal bigDecimalMaxBob) {
        this.bigDecimalMaxBob = bigDecimalMaxBob != null ? bigDecimalMaxBob.stripTrailingZeros() : null;
    }

    public LocalDate getLocalDateBob() {
        return this.localDateBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity localDateBob(LocalDate localDateBob) {
        this.setLocalDateBob(localDateBob);
        return this;
    }

    public void setLocalDateBob(LocalDate localDateBob) {
        this.localDateBob = localDateBob;
    }

    public LocalDate getLocalDateRequiredBob() {
        return this.localDateRequiredBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity localDateRequiredBob(LocalDate localDateRequiredBob) {
        this.setLocalDateRequiredBob(localDateRequiredBob);
        return this;
    }

    public void setLocalDateRequiredBob(LocalDate localDateRequiredBob) {
        this.localDateRequiredBob = localDateRequiredBob;
    }

    public Instant getInstantBob() {
        return this.instantBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity instantBob(Instant instantBob) {
        this.setInstantBob(instantBob);
        return this;
    }

    public void setInstantBob(Instant instantBob) {
        this.instantBob = instantBob;
    }

    public Instant getInstanteRequiredBob() {
        return this.instanteRequiredBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity instanteRequiredBob(Instant instanteRequiredBob) {
        this.setInstanteRequiredBob(instanteRequiredBob);
        return this;
    }

    public void setInstanteRequiredBob(Instant instanteRequiredBob) {
        this.instanteRequiredBob = instanteRequiredBob;
    }

    public ZonedDateTime getZonedDateTimeBob() {
        return this.zonedDateTimeBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity zonedDateTimeBob(ZonedDateTime zonedDateTimeBob) {
        this.setZonedDateTimeBob(zonedDateTimeBob);
        return this;
    }

    public void setZonedDateTimeBob(ZonedDateTime zonedDateTimeBob) {
        this.zonedDateTimeBob = zonedDateTimeBob;
    }

    public ZonedDateTime getZonedDateTimeRequiredBob() {
        return this.zonedDateTimeRequiredBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity zonedDateTimeRequiredBob(ZonedDateTime zonedDateTimeRequiredBob) {
        this.setZonedDateTimeRequiredBob(zonedDateTimeRequiredBob);
        return this;
    }

    public void setZonedDateTimeRequiredBob(ZonedDateTime zonedDateTimeRequiredBob) {
        this.zonedDateTimeRequiredBob = zonedDateTimeRequiredBob;
    }

    public Duration getDurationBob() {
        return this.durationBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity durationBob(Duration durationBob) {
        this.setDurationBob(durationBob);
        return this;
    }

    public void setDurationBob(Duration durationBob) {
        this.durationBob = durationBob;
    }

    public Duration getDurationRequiredBob() {
        return this.durationRequiredBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity durationRequiredBob(Duration durationRequiredBob) {
        this.setDurationRequiredBob(durationRequiredBob);
        return this;
    }

    public void setDurationRequiredBob(Duration durationRequiredBob) {
        this.durationRequiredBob = durationRequiredBob;
    }

    public Boolean getBooleanBob() {
        return this.booleanBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity booleanBob(Boolean booleanBob) {
        this.setBooleanBob(booleanBob);
        return this;
    }

    public void setBooleanBob(Boolean booleanBob) {
        this.booleanBob = booleanBob;
    }

    public Boolean getBooleanRequiredBob() {
        return this.booleanRequiredBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity booleanRequiredBob(Boolean booleanRequiredBob) {
        this.setBooleanRequiredBob(booleanRequiredBob);
        return this;
    }

    public void setBooleanRequiredBob(Boolean booleanRequiredBob) {
        this.booleanRequiredBob = booleanRequiredBob;
    }

    public EnumFieldClass getEnumBob() {
        return this.enumBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity enumBob(EnumFieldClass enumBob) {
        this.setEnumBob(enumBob);
        return this;
    }

    public void setEnumBob(EnumFieldClass enumBob) {
        this.enumBob = enumBob;
    }

    public EnumRequiredFieldClass getEnumRequiredBob() {
        return this.enumRequiredBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity enumRequiredBob(EnumRequiredFieldClass enumRequiredBob) {
        this.setEnumRequiredBob(enumRequiredBob);
        return this;
    }

    public void setEnumRequiredBob(EnumRequiredFieldClass enumRequiredBob) {
        this.enumRequiredBob = enumRequiredBob;
    }

    public UUID getUuidBob() {
        return this.uuidBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity uuidBob(UUID uuidBob) {
        this.setUuidBob(uuidBob);
        return this;
    }

    public void setUuidBob(UUID uuidBob) {
        this.uuidBob = uuidBob;
    }

    public UUID getUuidRequiredBob() {
        return this.uuidRequiredBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity uuidRequiredBob(UUID uuidRequiredBob) {
        this.setUuidRequiredBob(uuidRequiredBob);
        return this;
    }

    public void setUuidRequiredBob(UUID uuidRequiredBob) {
        this.uuidRequiredBob = uuidRequiredBob;
    }

    public byte[] getByteImageBob() {
        return this.byteImageBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity byteImageBob(byte[] byteImageBob) {
        this.setByteImageBob(byteImageBob);
        return this;
    }

    public void setByteImageBob(byte[] byteImageBob) {
        this.byteImageBob = byteImageBob;
    }

    public String getByteImageBobContentType() {
        return this.byteImageBobContentType;
    }

    public FieldTestServiceClassAndJpaFilteringEntity byteImageBobContentType(String byteImageBobContentType) {
        this.byteImageBobContentType = byteImageBobContentType;
        return this;
    }

    public void setByteImageBobContentType(String byteImageBobContentType) {
        this.byteImageBobContentType = byteImageBobContentType;
    }

    public byte[] getByteImageRequiredBob() {
        return this.byteImageRequiredBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity byteImageRequiredBob(byte[] byteImageRequiredBob) {
        this.setByteImageRequiredBob(byteImageRequiredBob);
        return this;
    }

    public void setByteImageRequiredBob(byte[] byteImageRequiredBob) {
        this.byteImageRequiredBob = byteImageRequiredBob;
    }

    public String getByteImageRequiredBobContentType() {
        return this.byteImageRequiredBobContentType;
    }

    public FieldTestServiceClassAndJpaFilteringEntity byteImageRequiredBobContentType(String byteImageRequiredBobContentType) {
        this.byteImageRequiredBobContentType = byteImageRequiredBobContentType;
        return this;
    }

    public void setByteImageRequiredBobContentType(String byteImageRequiredBobContentType) {
        this.byteImageRequiredBobContentType = byteImageRequiredBobContentType;
    }

    public byte[] getByteImageMinbytesBob() {
        return this.byteImageMinbytesBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity byteImageMinbytesBob(byte[] byteImageMinbytesBob) {
        this.setByteImageMinbytesBob(byteImageMinbytesBob);
        return this;
    }

    public void setByteImageMinbytesBob(byte[] byteImageMinbytesBob) {
        this.byteImageMinbytesBob = byteImageMinbytesBob;
    }

    public String getByteImageMinbytesBobContentType() {
        return this.byteImageMinbytesBobContentType;
    }

    public FieldTestServiceClassAndJpaFilteringEntity byteImageMinbytesBobContentType(String byteImageMinbytesBobContentType) {
        this.byteImageMinbytesBobContentType = byteImageMinbytesBobContentType;
        return this;
    }

    public void setByteImageMinbytesBobContentType(String byteImageMinbytesBobContentType) {
        this.byteImageMinbytesBobContentType = byteImageMinbytesBobContentType;
    }

    public byte[] getByteImageMaxbytesBob() {
        return this.byteImageMaxbytesBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity byteImageMaxbytesBob(byte[] byteImageMaxbytesBob) {
        this.setByteImageMaxbytesBob(byteImageMaxbytesBob);
        return this;
    }

    public void setByteImageMaxbytesBob(byte[] byteImageMaxbytesBob) {
        this.byteImageMaxbytesBob = byteImageMaxbytesBob;
    }

    public String getByteImageMaxbytesBobContentType() {
        return this.byteImageMaxbytesBobContentType;
    }

    public FieldTestServiceClassAndJpaFilteringEntity byteImageMaxbytesBobContentType(String byteImageMaxbytesBobContentType) {
        this.byteImageMaxbytesBobContentType = byteImageMaxbytesBobContentType;
        return this;
    }

    public void setByteImageMaxbytesBobContentType(String byteImageMaxbytesBobContentType) {
        this.byteImageMaxbytesBobContentType = byteImageMaxbytesBobContentType;
    }

    public byte[] getByteAnyBob() {
        return this.byteAnyBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity byteAnyBob(byte[] byteAnyBob) {
        this.setByteAnyBob(byteAnyBob);
        return this;
    }

    public void setByteAnyBob(byte[] byteAnyBob) {
        this.byteAnyBob = byteAnyBob;
    }

    public String getByteAnyBobContentType() {
        return this.byteAnyBobContentType;
    }

    public FieldTestServiceClassAndJpaFilteringEntity byteAnyBobContentType(String byteAnyBobContentType) {
        this.byteAnyBobContentType = byteAnyBobContentType;
        return this;
    }

    public void setByteAnyBobContentType(String byteAnyBobContentType) {
        this.byteAnyBobContentType = byteAnyBobContentType;
    }

    public byte[] getByteAnyRequiredBob() {
        return this.byteAnyRequiredBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity byteAnyRequiredBob(byte[] byteAnyRequiredBob) {
        this.setByteAnyRequiredBob(byteAnyRequiredBob);
        return this;
    }

    public void setByteAnyRequiredBob(byte[] byteAnyRequiredBob) {
        this.byteAnyRequiredBob = byteAnyRequiredBob;
    }

    public String getByteAnyRequiredBobContentType() {
        return this.byteAnyRequiredBobContentType;
    }

    public FieldTestServiceClassAndJpaFilteringEntity byteAnyRequiredBobContentType(String byteAnyRequiredBobContentType) {
        this.byteAnyRequiredBobContentType = byteAnyRequiredBobContentType;
        return this;
    }

    public void setByteAnyRequiredBobContentType(String byteAnyRequiredBobContentType) {
        this.byteAnyRequiredBobContentType = byteAnyRequiredBobContentType;
    }

    public byte[] getByteAnyMinbytesBob() {
        return this.byteAnyMinbytesBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity byteAnyMinbytesBob(byte[] byteAnyMinbytesBob) {
        this.setByteAnyMinbytesBob(byteAnyMinbytesBob);
        return this;
    }

    public void setByteAnyMinbytesBob(byte[] byteAnyMinbytesBob) {
        this.byteAnyMinbytesBob = byteAnyMinbytesBob;
    }

    public String getByteAnyMinbytesBobContentType() {
        return this.byteAnyMinbytesBobContentType;
    }

    public FieldTestServiceClassAndJpaFilteringEntity byteAnyMinbytesBobContentType(String byteAnyMinbytesBobContentType) {
        this.byteAnyMinbytesBobContentType = byteAnyMinbytesBobContentType;
        return this;
    }

    public void setByteAnyMinbytesBobContentType(String byteAnyMinbytesBobContentType) {
        this.byteAnyMinbytesBobContentType = byteAnyMinbytesBobContentType;
    }

    public byte[] getByteAnyMaxbytesBob() {
        return this.byteAnyMaxbytesBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity byteAnyMaxbytesBob(byte[] byteAnyMaxbytesBob) {
        this.setByteAnyMaxbytesBob(byteAnyMaxbytesBob);
        return this;
    }

    public void setByteAnyMaxbytesBob(byte[] byteAnyMaxbytesBob) {
        this.byteAnyMaxbytesBob = byteAnyMaxbytesBob;
    }

    public String getByteAnyMaxbytesBobContentType() {
        return this.byteAnyMaxbytesBobContentType;
    }

    public FieldTestServiceClassAndJpaFilteringEntity byteAnyMaxbytesBobContentType(String byteAnyMaxbytesBobContentType) {
        this.byteAnyMaxbytesBobContentType = byteAnyMaxbytesBobContentType;
        return this;
    }

    public void setByteAnyMaxbytesBobContentType(String byteAnyMaxbytesBobContentType) {
        this.byteAnyMaxbytesBobContentType = byteAnyMaxbytesBobContentType;
    }

    public String getByteTextBob() {
        return this.byteTextBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity byteTextBob(String byteTextBob) {
        this.setByteTextBob(byteTextBob);
        return this;
    }

    public void setByteTextBob(String byteTextBob) {
        this.byteTextBob = byteTextBob;
    }

    public String getByteTextRequiredBob() {
        return this.byteTextRequiredBob;
    }

    public FieldTestServiceClassAndJpaFilteringEntity byteTextRequiredBob(String byteTextRequiredBob) {
        this.setByteTextRequiredBob(byteTextRequiredBob);
        return this;
    }

    public void setByteTextRequiredBob(String byteTextRequiredBob) {
        this.byteTextRequiredBob = byteTextRequiredBob;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FieldTestServiceClassAndJpaFilteringEntity)) {
            return false;
        }
        return id != null && id.equals(((FieldTestServiceClassAndJpaFilteringEntity) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FieldTestServiceClassAndJpaFilteringEntity{" +
            "id=" + getId() +
            ", stringBob='" + getStringBob() + "'" +
            ", stringRequiredBob='" + getStringRequiredBob() + "'" +
            ", stringMinlengthBob='" + getStringMinlengthBob() + "'" +
            ", stringMaxlengthBob='" + getStringMaxlengthBob() + "'" +
            ", stringPatternBob='" + getStringPatternBob() + "'" +
            ", integerBob=" + getIntegerBob() +
            ", integerRequiredBob=" + getIntegerRequiredBob() +
            ", integerMinBob=" + getIntegerMinBob() +
            ", integerMaxBob=" + getIntegerMaxBob() +
            ", longBob=" + getLongBob() +
            ", longRequiredBob=" + getLongRequiredBob() +
            ", longMinBob=" + getLongMinBob() +
            ", longMaxBob=" + getLongMaxBob() +
            ", floatBob=" + getFloatBob() +
            ", floatRequiredBob=" + getFloatRequiredBob() +
            ", floatMinBob=" + getFloatMinBob() +
            ", floatMaxBob=" + getFloatMaxBob() +
            ", doubleRequiredBob=" + getDoubleRequiredBob() +
            ", doubleMinBob=" + getDoubleMinBob() +
            ", doubleMaxBob=" + getDoubleMaxBob() +
            ", bigDecimalRequiredBob=" + getBigDecimalRequiredBob() +
            ", bigDecimalMinBob=" + getBigDecimalMinBob() +
            ", bigDecimalMaxBob=" + getBigDecimalMaxBob() +
            ", localDateBob='" + getLocalDateBob() + "'" +
            ", localDateRequiredBob='" + getLocalDateRequiredBob() + "'" +
            ", instantBob='" + getInstantBob() + "'" +
            ", instanteRequiredBob='" + getInstanteRequiredBob() + "'" +
            ", zonedDateTimeBob='" + getZonedDateTimeBob() + "'" +
            ", zonedDateTimeRequiredBob='" + getZonedDateTimeRequiredBob() + "'" +
            ", durationBob='" + getDurationBob() + "'" +
            ", durationRequiredBob='" + getDurationRequiredBob() + "'" +
            ", booleanBob='" + getBooleanBob() + "'" +
            ", booleanRequiredBob='" + getBooleanRequiredBob() + "'" +
            ", enumBob='" + getEnumBob() + "'" +
            ", enumRequiredBob='" + getEnumRequiredBob() + "'" +
            ", uuidBob='" + getUuidBob() + "'" +
            ", uuidRequiredBob='" + getUuidRequiredBob() + "'" +
            ", byteImageBob='" + getByteImageBob() + "'" +
            ", byteImageBobContentType='" + getByteImageBobContentType() + "'" +
            ", byteImageRequiredBob='" + getByteImageRequiredBob() + "'" +
            ", byteImageRequiredBobContentType='" + getByteImageRequiredBobContentType() + "'" +
            ", byteImageMinbytesBob='" + getByteImageMinbytesBob() + "'" +
            ", byteImageMinbytesBobContentType='" + getByteImageMinbytesBobContentType() + "'" +
            ", byteImageMaxbytesBob='" + getByteImageMaxbytesBob() + "'" +
            ", byteImageMaxbytesBobContentType='" + getByteImageMaxbytesBobContentType() + "'" +
            ", byteAnyBob='" + getByteAnyBob() + "'" +
            ", byteAnyBobContentType='" + getByteAnyBobContentType() + "'" +
            ", byteAnyRequiredBob='" + getByteAnyRequiredBob() + "'" +
            ", byteAnyRequiredBobContentType='" + getByteAnyRequiredBobContentType() + "'" +
            ", byteAnyMinbytesBob='" + getByteAnyMinbytesBob() + "'" +
            ", byteAnyMinbytesBobContentType='" + getByteAnyMinbytesBobContentType() + "'" +
            ", byteAnyMaxbytesBob='" + getByteAnyMaxbytesBob() + "'" +
            ", byteAnyMaxbytesBobContentType='" + getByteAnyMaxbytesBobContentType() + "'" +
            ", byteTextBob='" + getByteTextBob() + "'" +
            ", byteTextRequiredBob='" + getByteTextRequiredBob() + "'" +
            "}";
    }
}
