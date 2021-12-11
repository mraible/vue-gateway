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
 * A FieldTestServiceImplEntity.
 */
@Table("field_test_service_impl_entity")
public class FieldTestServiceImplEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("string_mika")
    private String stringMika;

    @NotNull(message = "must not be null")
    @Column("string_required_mika")
    private String stringRequiredMika;

    @Size(min = 0)
    @Column("string_minlength_mika")
    private String stringMinlengthMika;

    @Size(max = 20)
    @Column("string_maxlength_mika")
    private String stringMaxlengthMika;

    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    @Column("string_pattern_mika")
    private String stringPatternMika;

    @Column("integer_mika")
    private Integer integerMika;

    @NotNull(message = "must not be null")
    @Column("integer_required_mika")
    private Integer integerRequiredMika;

    @Min(value = 0)
    @Column("integer_min_mika")
    private Integer integerMinMika;

    @Max(value = 100)
    @Column("integer_max_mika")
    private Integer integerMaxMika;

    @Column("long_mika")
    private Long longMika;

    @NotNull(message = "must not be null")
    @Column("long_required_mika")
    private Long longRequiredMika;

    @Min(value = 0L)
    @Column("long_min_mika")
    private Long longMinMika;

    @Max(value = 100L)
    @Column("long_max_mika")
    private Long longMaxMika;

    @Column("float_mika")
    private Float floatMika;

    @NotNull(message = "must not be null")
    @Column("float_required_mika")
    private Float floatRequiredMika;

    @DecimalMin(value = "0")
    @Column("float_min_mika")
    private Float floatMinMika;

    @DecimalMax(value = "100")
    @Column("float_max_mika")
    private Float floatMaxMika;

    @NotNull(message = "must not be null")
    @Column("double_required_mika")
    private Double doubleRequiredMika;

    @DecimalMin(value = "0")
    @Column("double_min_mika")
    private Double doubleMinMika;

    @DecimalMax(value = "100")
    @Column("double_max_mika")
    private Double doubleMaxMika;

    @NotNull(message = "must not be null")
    @Column("big_decimal_required_mika")
    private BigDecimal bigDecimalRequiredMika;

    @DecimalMin(value = "0")
    @Column("big_decimal_min_mika")
    private BigDecimal bigDecimalMinMika;

    @DecimalMax(value = "100")
    @Column("big_decimal_max_mika")
    private BigDecimal bigDecimalMaxMika;

    @Column("local_date_mika")
    private LocalDate localDateMika;

    @NotNull(message = "must not be null")
    @Column("local_date_required_mika")
    private LocalDate localDateRequiredMika;

    @Column("instant_mika")
    private Instant instantMika;

    @NotNull(message = "must not be null")
    @Column("instante_required_mika")
    private Instant instanteRequiredMika;

    @Column("zoned_date_time_mika")
    private ZonedDateTime zonedDateTimeMika;

    @NotNull(message = "must not be null")
    @Column("zoned_date_time_required_mika")
    private ZonedDateTime zonedDateTimeRequiredMika;

    @Column("duration_mika")
    private Duration durationMika;

    @NotNull(message = "must not be null")
    @Column("duration_required_mika")
    private Duration durationRequiredMika;

    @Column("boolean_mika")
    private Boolean booleanMika;

    @NotNull(message = "must not be null")
    @Column("boolean_required_mika")
    private Boolean booleanRequiredMika;

    @Column("enum_mika")
    private EnumFieldClass enumMika;

    @NotNull(message = "must not be null")
    @Column("enum_required_mika")
    private EnumRequiredFieldClass enumRequiredMika;

    @Column("uuid_mika")
    private UUID uuidMika;

    @NotNull(message = "must not be null")
    @Column("uuid_required_mika")
    private UUID uuidRequiredMika;

    @Column("byte_image_mika")
    private byte[] byteImageMika;

    @Column("byte_image_mika_content_type")
    private String byteImageMikaContentType;

    @Column("byte_image_required_mika")
    private byte[] byteImageRequiredMika;

    @NotNull
    @Column("byte_image_required_mika_content_type")
    private String byteImageRequiredMikaContentType;

    @Column("byte_image_minbytes_mika")
    private byte[] byteImageMinbytesMika;

    @Column("byte_image_minbytes_mika_content_type")
    private String byteImageMinbytesMikaContentType;

    @Column("byte_image_maxbytes_mika")
    private byte[] byteImageMaxbytesMika;

    @Column("byte_image_maxbytes_mika_content_type")
    private String byteImageMaxbytesMikaContentType;

    @Column("byte_any_mika")
    private byte[] byteAnyMika;

    @Column("byte_any_mika_content_type")
    private String byteAnyMikaContentType;

    @Column("byte_any_required_mika")
    private byte[] byteAnyRequiredMika;

    @NotNull
    @Column("byte_any_required_mika_content_type")
    private String byteAnyRequiredMikaContentType;

    @Column("byte_any_minbytes_mika")
    private byte[] byteAnyMinbytesMika;

    @Column("byte_any_minbytes_mika_content_type")
    private String byteAnyMinbytesMikaContentType;

    @Column("byte_any_maxbytes_mika")
    private byte[] byteAnyMaxbytesMika;

    @Column("byte_any_maxbytes_mika_content_type")
    private String byteAnyMaxbytesMikaContentType;

    @Column("byte_text_mika")
    private String byteTextMika;

    @Column("byte_text_required_mika")
    private String byteTextRequiredMika;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public FieldTestServiceImplEntity id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStringMika() {
        return this.stringMika;
    }

    public FieldTestServiceImplEntity stringMika(String stringMika) {
        this.setStringMika(stringMika);
        return this;
    }

    public void setStringMika(String stringMika) {
        this.stringMika = stringMika;
    }

    public String getStringRequiredMika() {
        return this.stringRequiredMika;
    }

    public FieldTestServiceImplEntity stringRequiredMika(String stringRequiredMika) {
        this.setStringRequiredMika(stringRequiredMika);
        return this;
    }

    public void setStringRequiredMika(String stringRequiredMika) {
        this.stringRequiredMika = stringRequiredMika;
    }

    public String getStringMinlengthMika() {
        return this.stringMinlengthMika;
    }

    public FieldTestServiceImplEntity stringMinlengthMika(String stringMinlengthMika) {
        this.setStringMinlengthMika(stringMinlengthMika);
        return this;
    }

    public void setStringMinlengthMika(String stringMinlengthMika) {
        this.stringMinlengthMika = stringMinlengthMika;
    }

    public String getStringMaxlengthMika() {
        return this.stringMaxlengthMika;
    }

    public FieldTestServiceImplEntity stringMaxlengthMika(String stringMaxlengthMika) {
        this.setStringMaxlengthMika(stringMaxlengthMika);
        return this;
    }

    public void setStringMaxlengthMika(String stringMaxlengthMika) {
        this.stringMaxlengthMika = stringMaxlengthMika;
    }

    public String getStringPatternMika() {
        return this.stringPatternMika;
    }

    public FieldTestServiceImplEntity stringPatternMika(String stringPatternMika) {
        this.setStringPatternMika(stringPatternMika);
        return this;
    }

    public void setStringPatternMika(String stringPatternMika) {
        this.stringPatternMika = stringPatternMika;
    }

    public Integer getIntegerMika() {
        return this.integerMika;
    }

    public FieldTestServiceImplEntity integerMika(Integer integerMika) {
        this.setIntegerMika(integerMika);
        return this;
    }

    public void setIntegerMika(Integer integerMika) {
        this.integerMika = integerMika;
    }

    public Integer getIntegerRequiredMika() {
        return this.integerRequiredMika;
    }

    public FieldTestServiceImplEntity integerRequiredMika(Integer integerRequiredMika) {
        this.setIntegerRequiredMika(integerRequiredMika);
        return this;
    }

    public void setIntegerRequiredMika(Integer integerRequiredMika) {
        this.integerRequiredMika = integerRequiredMika;
    }

    public Integer getIntegerMinMika() {
        return this.integerMinMika;
    }

    public FieldTestServiceImplEntity integerMinMika(Integer integerMinMika) {
        this.setIntegerMinMika(integerMinMika);
        return this;
    }

    public void setIntegerMinMika(Integer integerMinMika) {
        this.integerMinMika = integerMinMika;
    }

    public Integer getIntegerMaxMika() {
        return this.integerMaxMika;
    }

    public FieldTestServiceImplEntity integerMaxMika(Integer integerMaxMika) {
        this.setIntegerMaxMika(integerMaxMika);
        return this;
    }

    public void setIntegerMaxMika(Integer integerMaxMika) {
        this.integerMaxMika = integerMaxMika;
    }

    public Long getLongMika() {
        return this.longMika;
    }

    public FieldTestServiceImplEntity longMika(Long longMika) {
        this.setLongMika(longMika);
        return this;
    }

    public void setLongMika(Long longMika) {
        this.longMika = longMika;
    }

    public Long getLongRequiredMika() {
        return this.longRequiredMika;
    }

    public FieldTestServiceImplEntity longRequiredMika(Long longRequiredMika) {
        this.setLongRequiredMika(longRequiredMika);
        return this;
    }

    public void setLongRequiredMika(Long longRequiredMika) {
        this.longRequiredMika = longRequiredMika;
    }

    public Long getLongMinMika() {
        return this.longMinMika;
    }

    public FieldTestServiceImplEntity longMinMika(Long longMinMika) {
        this.setLongMinMika(longMinMika);
        return this;
    }

    public void setLongMinMika(Long longMinMika) {
        this.longMinMika = longMinMika;
    }

    public Long getLongMaxMika() {
        return this.longMaxMika;
    }

    public FieldTestServiceImplEntity longMaxMika(Long longMaxMika) {
        this.setLongMaxMika(longMaxMika);
        return this;
    }

    public void setLongMaxMika(Long longMaxMika) {
        this.longMaxMika = longMaxMika;
    }

    public Float getFloatMika() {
        return this.floatMika;
    }

    public FieldTestServiceImplEntity floatMika(Float floatMika) {
        this.setFloatMika(floatMika);
        return this;
    }

    public void setFloatMika(Float floatMika) {
        this.floatMika = floatMika;
    }

    public Float getFloatRequiredMika() {
        return this.floatRequiredMika;
    }

    public FieldTestServiceImplEntity floatRequiredMika(Float floatRequiredMika) {
        this.setFloatRequiredMika(floatRequiredMika);
        return this;
    }

    public void setFloatRequiredMika(Float floatRequiredMika) {
        this.floatRequiredMika = floatRequiredMika;
    }

    public Float getFloatMinMika() {
        return this.floatMinMika;
    }

    public FieldTestServiceImplEntity floatMinMika(Float floatMinMika) {
        this.setFloatMinMika(floatMinMika);
        return this;
    }

    public void setFloatMinMika(Float floatMinMika) {
        this.floatMinMika = floatMinMika;
    }

    public Float getFloatMaxMika() {
        return this.floatMaxMika;
    }

    public FieldTestServiceImplEntity floatMaxMika(Float floatMaxMika) {
        this.setFloatMaxMika(floatMaxMika);
        return this;
    }

    public void setFloatMaxMika(Float floatMaxMika) {
        this.floatMaxMika = floatMaxMika;
    }

    public Double getDoubleRequiredMika() {
        return this.doubleRequiredMika;
    }

    public FieldTestServiceImplEntity doubleRequiredMika(Double doubleRequiredMika) {
        this.setDoubleRequiredMika(doubleRequiredMika);
        return this;
    }

    public void setDoubleRequiredMika(Double doubleRequiredMika) {
        this.doubleRequiredMika = doubleRequiredMika;
    }

    public Double getDoubleMinMika() {
        return this.doubleMinMika;
    }

    public FieldTestServiceImplEntity doubleMinMika(Double doubleMinMika) {
        this.setDoubleMinMika(doubleMinMika);
        return this;
    }

    public void setDoubleMinMika(Double doubleMinMika) {
        this.doubleMinMika = doubleMinMika;
    }

    public Double getDoubleMaxMika() {
        return this.doubleMaxMika;
    }

    public FieldTestServiceImplEntity doubleMaxMika(Double doubleMaxMika) {
        this.setDoubleMaxMika(doubleMaxMika);
        return this;
    }

    public void setDoubleMaxMika(Double doubleMaxMika) {
        this.doubleMaxMika = doubleMaxMika;
    }

    public BigDecimal getBigDecimalRequiredMika() {
        return this.bigDecimalRequiredMika;
    }

    public FieldTestServiceImplEntity bigDecimalRequiredMika(BigDecimal bigDecimalRequiredMika) {
        this.setBigDecimalRequiredMika(bigDecimalRequiredMika);
        return this;
    }

    public void setBigDecimalRequiredMika(BigDecimal bigDecimalRequiredMika) {
        this.bigDecimalRequiredMika = bigDecimalRequiredMika != null ? bigDecimalRequiredMika.stripTrailingZeros() : null;
    }

    public BigDecimal getBigDecimalMinMika() {
        return this.bigDecimalMinMika;
    }

    public FieldTestServiceImplEntity bigDecimalMinMika(BigDecimal bigDecimalMinMika) {
        this.setBigDecimalMinMika(bigDecimalMinMika);
        return this;
    }

    public void setBigDecimalMinMika(BigDecimal bigDecimalMinMika) {
        this.bigDecimalMinMika = bigDecimalMinMika != null ? bigDecimalMinMika.stripTrailingZeros() : null;
    }

    public BigDecimal getBigDecimalMaxMika() {
        return this.bigDecimalMaxMika;
    }

    public FieldTestServiceImplEntity bigDecimalMaxMika(BigDecimal bigDecimalMaxMika) {
        this.setBigDecimalMaxMika(bigDecimalMaxMika);
        return this;
    }

    public void setBigDecimalMaxMika(BigDecimal bigDecimalMaxMika) {
        this.bigDecimalMaxMika = bigDecimalMaxMika != null ? bigDecimalMaxMika.stripTrailingZeros() : null;
    }

    public LocalDate getLocalDateMika() {
        return this.localDateMika;
    }

    public FieldTestServiceImplEntity localDateMika(LocalDate localDateMika) {
        this.setLocalDateMika(localDateMika);
        return this;
    }

    public void setLocalDateMika(LocalDate localDateMika) {
        this.localDateMika = localDateMika;
    }

    public LocalDate getLocalDateRequiredMika() {
        return this.localDateRequiredMika;
    }

    public FieldTestServiceImplEntity localDateRequiredMika(LocalDate localDateRequiredMika) {
        this.setLocalDateRequiredMika(localDateRequiredMika);
        return this;
    }

    public void setLocalDateRequiredMika(LocalDate localDateRequiredMika) {
        this.localDateRequiredMika = localDateRequiredMika;
    }

    public Instant getInstantMika() {
        return this.instantMika;
    }

    public FieldTestServiceImplEntity instantMika(Instant instantMika) {
        this.setInstantMika(instantMika);
        return this;
    }

    public void setInstantMika(Instant instantMika) {
        this.instantMika = instantMika;
    }

    public Instant getInstanteRequiredMika() {
        return this.instanteRequiredMika;
    }

    public FieldTestServiceImplEntity instanteRequiredMika(Instant instanteRequiredMika) {
        this.setInstanteRequiredMika(instanteRequiredMika);
        return this;
    }

    public void setInstanteRequiredMika(Instant instanteRequiredMika) {
        this.instanteRequiredMika = instanteRequiredMika;
    }

    public ZonedDateTime getZonedDateTimeMika() {
        return this.zonedDateTimeMika;
    }

    public FieldTestServiceImplEntity zonedDateTimeMika(ZonedDateTime zonedDateTimeMika) {
        this.setZonedDateTimeMika(zonedDateTimeMika);
        return this;
    }

    public void setZonedDateTimeMika(ZonedDateTime zonedDateTimeMika) {
        this.zonedDateTimeMika = zonedDateTimeMika;
    }

    public ZonedDateTime getZonedDateTimeRequiredMika() {
        return this.zonedDateTimeRequiredMika;
    }

    public FieldTestServiceImplEntity zonedDateTimeRequiredMika(ZonedDateTime zonedDateTimeRequiredMika) {
        this.setZonedDateTimeRequiredMika(zonedDateTimeRequiredMika);
        return this;
    }

    public void setZonedDateTimeRequiredMika(ZonedDateTime zonedDateTimeRequiredMika) {
        this.zonedDateTimeRequiredMika = zonedDateTimeRequiredMika;
    }

    public Duration getDurationMika() {
        return this.durationMika;
    }

    public FieldTestServiceImplEntity durationMika(Duration durationMika) {
        this.setDurationMika(durationMika);
        return this;
    }

    public void setDurationMika(Duration durationMika) {
        this.durationMika = durationMika;
    }

    public Duration getDurationRequiredMika() {
        return this.durationRequiredMika;
    }

    public FieldTestServiceImplEntity durationRequiredMika(Duration durationRequiredMika) {
        this.setDurationRequiredMika(durationRequiredMika);
        return this;
    }

    public void setDurationRequiredMika(Duration durationRequiredMika) {
        this.durationRequiredMika = durationRequiredMika;
    }

    public Boolean getBooleanMika() {
        return this.booleanMika;
    }

    public FieldTestServiceImplEntity booleanMika(Boolean booleanMika) {
        this.setBooleanMika(booleanMika);
        return this;
    }

    public void setBooleanMika(Boolean booleanMika) {
        this.booleanMika = booleanMika;
    }

    public Boolean getBooleanRequiredMika() {
        return this.booleanRequiredMika;
    }

    public FieldTestServiceImplEntity booleanRequiredMika(Boolean booleanRequiredMika) {
        this.setBooleanRequiredMika(booleanRequiredMika);
        return this;
    }

    public void setBooleanRequiredMika(Boolean booleanRequiredMika) {
        this.booleanRequiredMika = booleanRequiredMika;
    }

    public EnumFieldClass getEnumMika() {
        return this.enumMika;
    }

    public FieldTestServiceImplEntity enumMika(EnumFieldClass enumMika) {
        this.setEnumMika(enumMika);
        return this;
    }

    public void setEnumMika(EnumFieldClass enumMika) {
        this.enumMika = enumMika;
    }

    public EnumRequiredFieldClass getEnumRequiredMika() {
        return this.enumRequiredMika;
    }

    public FieldTestServiceImplEntity enumRequiredMika(EnumRequiredFieldClass enumRequiredMika) {
        this.setEnumRequiredMika(enumRequiredMika);
        return this;
    }

    public void setEnumRequiredMika(EnumRequiredFieldClass enumRequiredMika) {
        this.enumRequiredMika = enumRequiredMika;
    }

    public UUID getUuidMika() {
        return this.uuidMika;
    }

    public FieldTestServiceImplEntity uuidMika(UUID uuidMika) {
        this.setUuidMika(uuidMika);
        return this;
    }

    public void setUuidMika(UUID uuidMika) {
        this.uuidMika = uuidMika;
    }

    public UUID getUuidRequiredMika() {
        return this.uuidRequiredMika;
    }

    public FieldTestServiceImplEntity uuidRequiredMika(UUID uuidRequiredMika) {
        this.setUuidRequiredMika(uuidRequiredMika);
        return this;
    }

    public void setUuidRequiredMika(UUID uuidRequiredMika) {
        this.uuidRequiredMika = uuidRequiredMika;
    }

    public byte[] getByteImageMika() {
        return this.byteImageMika;
    }

    public FieldTestServiceImplEntity byteImageMika(byte[] byteImageMika) {
        this.setByteImageMika(byteImageMika);
        return this;
    }

    public void setByteImageMika(byte[] byteImageMika) {
        this.byteImageMika = byteImageMika;
    }

    public String getByteImageMikaContentType() {
        return this.byteImageMikaContentType;
    }

    public FieldTestServiceImplEntity byteImageMikaContentType(String byteImageMikaContentType) {
        this.byteImageMikaContentType = byteImageMikaContentType;
        return this;
    }

    public void setByteImageMikaContentType(String byteImageMikaContentType) {
        this.byteImageMikaContentType = byteImageMikaContentType;
    }

    public byte[] getByteImageRequiredMika() {
        return this.byteImageRequiredMika;
    }

    public FieldTestServiceImplEntity byteImageRequiredMika(byte[] byteImageRequiredMika) {
        this.setByteImageRequiredMika(byteImageRequiredMika);
        return this;
    }

    public void setByteImageRequiredMika(byte[] byteImageRequiredMika) {
        this.byteImageRequiredMika = byteImageRequiredMika;
    }

    public String getByteImageRequiredMikaContentType() {
        return this.byteImageRequiredMikaContentType;
    }

    public FieldTestServiceImplEntity byteImageRequiredMikaContentType(String byteImageRequiredMikaContentType) {
        this.byteImageRequiredMikaContentType = byteImageRequiredMikaContentType;
        return this;
    }

    public void setByteImageRequiredMikaContentType(String byteImageRequiredMikaContentType) {
        this.byteImageRequiredMikaContentType = byteImageRequiredMikaContentType;
    }

    public byte[] getByteImageMinbytesMika() {
        return this.byteImageMinbytesMika;
    }

    public FieldTestServiceImplEntity byteImageMinbytesMika(byte[] byteImageMinbytesMika) {
        this.setByteImageMinbytesMika(byteImageMinbytesMika);
        return this;
    }

    public void setByteImageMinbytesMika(byte[] byteImageMinbytesMika) {
        this.byteImageMinbytesMika = byteImageMinbytesMika;
    }

    public String getByteImageMinbytesMikaContentType() {
        return this.byteImageMinbytesMikaContentType;
    }

    public FieldTestServiceImplEntity byteImageMinbytesMikaContentType(String byteImageMinbytesMikaContentType) {
        this.byteImageMinbytesMikaContentType = byteImageMinbytesMikaContentType;
        return this;
    }

    public void setByteImageMinbytesMikaContentType(String byteImageMinbytesMikaContentType) {
        this.byteImageMinbytesMikaContentType = byteImageMinbytesMikaContentType;
    }

    public byte[] getByteImageMaxbytesMika() {
        return this.byteImageMaxbytesMika;
    }

    public FieldTestServiceImplEntity byteImageMaxbytesMika(byte[] byteImageMaxbytesMika) {
        this.setByteImageMaxbytesMika(byteImageMaxbytesMika);
        return this;
    }

    public void setByteImageMaxbytesMika(byte[] byteImageMaxbytesMika) {
        this.byteImageMaxbytesMika = byteImageMaxbytesMika;
    }

    public String getByteImageMaxbytesMikaContentType() {
        return this.byteImageMaxbytesMikaContentType;
    }

    public FieldTestServiceImplEntity byteImageMaxbytesMikaContentType(String byteImageMaxbytesMikaContentType) {
        this.byteImageMaxbytesMikaContentType = byteImageMaxbytesMikaContentType;
        return this;
    }

    public void setByteImageMaxbytesMikaContentType(String byteImageMaxbytesMikaContentType) {
        this.byteImageMaxbytesMikaContentType = byteImageMaxbytesMikaContentType;
    }

    public byte[] getByteAnyMika() {
        return this.byteAnyMika;
    }

    public FieldTestServiceImplEntity byteAnyMika(byte[] byteAnyMika) {
        this.setByteAnyMika(byteAnyMika);
        return this;
    }

    public void setByteAnyMika(byte[] byteAnyMika) {
        this.byteAnyMika = byteAnyMika;
    }

    public String getByteAnyMikaContentType() {
        return this.byteAnyMikaContentType;
    }

    public FieldTestServiceImplEntity byteAnyMikaContentType(String byteAnyMikaContentType) {
        this.byteAnyMikaContentType = byteAnyMikaContentType;
        return this;
    }

    public void setByteAnyMikaContentType(String byteAnyMikaContentType) {
        this.byteAnyMikaContentType = byteAnyMikaContentType;
    }

    public byte[] getByteAnyRequiredMika() {
        return this.byteAnyRequiredMika;
    }

    public FieldTestServiceImplEntity byteAnyRequiredMika(byte[] byteAnyRequiredMika) {
        this.setByteAnyRequiredMika(byteAnyRequiredMika);
        return this;
    }

    public void setByteAnyRequiredMika(byte[] byteAnyRequiredMika) {
        this.byteAnyRequiredMika = byteAnyRequiredMika;
    }

    public String getByteAnyRequiredMikaContentType() {
        return this.byteAnyRequiredMikaContentType;
    }

    public FieldTestServiceImplEntity byteAnyRequiredMikaContentType(String byteAnyRequiredMikaContentType) {
        this.byteAnyRequiredMikaContentType = byteAnyRequiredMikaContentType;
        return this;
    }

    public void setByteAnyRequiredMikaContentType(String byteAnyRequiredMikaContentType) {
        this.byteAnyRequiredMikaContentType = byteAnyRequiredMikaContentType;
    }

    public byte[] getByteAnyMinbytesMika() {
        return this.byteAnyMinbytesMika;
    }

    public FieldTestServiceImplEntity byteAnyMinbytesMika(byte[] byteAnyMinbytesMika) {
        this.setByteAnyMinbytesMika(byteAnyMinbytesMika);
        return this;
    }

    public void setByteAnyMinbytesMika(byte[] byteAnyMinbytesMika) {
        this.byteAnyMinbytesMika = byteAnyMinbytesMika;
    }

    public String getByteAnyMinbytesMikaContentType() {
        return this.byteAnyMinbytesMikaContentType;
    }

    public FieldTestServiceImplEntity byteAnyMinbytesMikaContentType(String byteAnyMinbytesMikaContentType) {
        this.byteAnyMinbytesMikaContentType = byteAnyMinbytesMikaContentType;
        return this;
    }

    public void setByteAnyMinbytesMikaContentType(String byteAnyMinbytesMikaContentType) {
        this.byteAnyMinbytesMikaContentType = byteAnyMinbytesMikaContentType;
    }

    public byte[] getByteAnyMaxbytesMika() {
        return this.byteAnyMaxbytesMika;
    }

    public FieldTestServiceImplEntity byteAnyMaxbytesMika(byte[] byteAnyMaxbytesMika) {
        this.setByteAnyMaxbytesMika(byteAnyMaxbytesMika);
        return this;
    }

    public void setByteAnyMaxbytesMika(byte[] byteAnyMaxbytesMika) {
        this.byteAnyMaxbytesMika = byteAnyMaxbytesMika;
    }

    public String getByteAnyMaxbytesMikaContentType() {
        return this.byteAnyMaxbytesMikaContentType;
    }

    public FieldTestServiceImplEntity byteAnyMaxbytesMikaContentType(String byteAnyMaxbytesMikaContentType) {
        this.byteAnyMaxbytesMikaContentType = byteAnyMaxbytesMikaContentType;
        return this;
    }

    public void setByteAnyMaxbytesMikaContentType(String byteAnyMaxbytesMikaContentType) {
        this.byteAnyMaxbytesMikaContentType = byteAnyMaxbytesMikaContentType;
    }

    public String getByteTextMika() {
        return this.byteTextMika;
    }

    public FieldTestServiceImplEntity byteTextMika(String byteTextMika) {
        this.setByteTextMika(byteTextMika);
        return this;
    }

    public void setByteTextMika(String byteTextMika) {
        this.byteTextMika = byteTextMika;
    }

    public String getByteTextRequiredMika() {
        return this.byteTextRequiredMika;
    }

    public FieldTestServiceImplEntity byteTextRequiredMika(String byteTextRequiredMika) {
        this.setByteTextRequiredMika(byteTextRequiredMika);
        return this;
    }

    public void setByteTextRequiredMika(String byteTextRequiredMika) {
        this.byteTextRequiredMika = byteTextRequiredMika;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FieldTestServiceImplEntity)) {
            return false;
        }
        return id != null && id.equals(((FieldTestServiceImplEntity) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FieldTestServiceImplEntity{" +
            "id=" + getId() +
            ", stringMika='" + getStringMika() + "'" +
            ", stringRequiredMika='" + getStringRequiredMika() + "'" +
            ", stringMinlengthMika='" + getStringMinlengthMika() + "'" +
            ", stringMaxlengthMika='" + getStringMaxlengthMika() + "'" +
            ", stringPatternMika='" + getStringPatternMika() + "'" +
            ", integerMika=" + getIntegerMika() +
            ", integerRequiredMika=" + getIntegerRequiredMika() +
            ", integerMinMika=" + getIntegerMinMika() +
            ", integerMaxMika=" + getIntegerMaxMika() +
            ", longMika=" + getLongMika() +
            ", longRequiredMika=" + getLongRequiredMika() +
            ", longMinMika=" + getLongMinMika() +
            ", longMaxMika=" + getLongMaxMika() +
            ", floatMika=" + getFloatMika() +
            ", floatRequiredMika=" + getFloatRequiredMika() +
            ", floatMinMika=" + getFloatMinMika() +
            ", floatMaxMika=" + getFloatMaxMika() +
            ", doubleRequiredMika=" + getDoubleRequiredMika() +
            ", doubleMinMika=" + getDoubleMinMika() +
            ", doubleMaxMika=" + getDoubleMaxMika() +
            ", bigDecimalRequiredMika=" + getBigDecimalRequiredMika() +
            ", bigDecimalMinMika=" + getBigDecimalMinMika() +
            ", bigDecimalMaxMika=" + getBigDecimalMaxMika() +
            ", localDateMika='" + getLocalDateMika() + "'" +
            ", localDateRequiredMika='" + getLocalDateRequiredMika() + "'" +
            ", instantMika='" + getInstantMika() + "'" +
            ", instanteRequiredMika='" + getInstanteRequiredMika() + "'" +
            ", zonedDateTimeMika='" + getZonedDateTimeMika() + "'" +
            ", zonedDateTimeRequiredMika='" + getZonedDateTimeRequiredMika() + "'" +
            ", durationMika='" + getDurationMika() + "'" +
            ", durationRequiredMika='" + getDurationRequiredMika() + "'" +
            ", booleanMika='" + getBooleanMika() + "'" +
            ", booleanRequiredMika='" + getBooleanRequiredMika() + "'" +
            ", enumMika='" + getEnumMika() + "'" +
            ", enumRequiredMika='" + getEnumRequiredMika() + "'" +
            ", uuidMika='" + getUuidMika() + "'" +
            ", uuidRequiredMika='" + getUuidRequiredMika() + "'" +
            ", byteImageMika='" + getByteImageMika() + "'" +
            ", byteImageMikaContentType='" + getByteImageMikaContentType() + "'" +
            ", byteImageRequiredMika='" + getByteImageRequiredMika() + "'" +
            ", byteImageRequiredMikaContentType='" + getByteImageRequiredMikaContentType() + "'" +
            ", byteImageMinbytesMika='" + getByteImageMinbytesMika() + "'" +
            ", byteImageMinbytesMikaContentType='" + getByteImageMinbytesMikaContentType() + "'" +
            ", byteImageMaxbytesMika='" + getByteImageMaxbytesMika() + "'" +
            ", byteImageMaxbytesMikaContentType='" + getByteImageMaxbytesMikaContentType() + "'" +
            ", byteAnyMika='" + getByteAnyMika() + "'" +
            ", byteAnyMikaContentType='" + getByteAnyMikaContentType() + "'" +
            ", byteAnyRequiredMika='" + getByteAnyRequiredMika() + "'" +
            ", byteAnyRequiredMikaContentType='" + getByteAnyRequiredMikaContentType() + "'" +
            ", byteAnyMinbytesMika='" + getByteAnyMinbytesMika() + "'" +
            ", byteAnyMinbytesMikaContentType='" + getByteAnyMinbytesMikaContentType() + "'" +
            ", byteAnyMaxbytesMika='" + getByteAnyMaxbytesMika() + "'" +
            ", byteAnyMaxbytesMikaContentType='" + getByteAnyMaxbytesMikaContentType() + "'" +
            ", byteTextMika='" + getByteTextMika() + "'" +
            ", byteTextRequiredMika='" + getByteTextRequiredMika() + "'" +
            "}";
    }
}
