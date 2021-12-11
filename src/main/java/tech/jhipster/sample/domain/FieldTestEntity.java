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
 * A FieldTestEntity.
 */
@Table("field_test_entity")
public class FieldTestEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("string_tom")
    private String stringTom;

    @NotNull(message = "must not be null")
    @Column("string_required_tom")
    private String stringRequiredTom;

    @Size(min = 0)
    @Column("string_minlength_tom")
    private String stringMinlengthTom;

    @Size(max = 20)
    @Column("string_maxlength_tom")
    private String stringMaxlengthTom;

    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    @Column("string_pattern_tom")
    private String stringPatternTom;

    @Pattern(regexp = "^[0-9]+$")
    @Column("number_pattern_tom")
    private String numberPatternTom;

    @NotNull(message = "must not be null")
    @Pattern(regexp = "^[0-9]+$")
    @Column("number_pattern_required_tom")
    private String numberPatternRequiredTom;

    @Column("integer_tom")
    private Integer integerTom;

    @NotNull(message = "must not be null")
    @Column("integer_required_tom")
    private Integer integerRequiredTom;

    @Min(value = 0)
    @Column("integer_min_tom")
    private Integer integerMinTom;

    @Max(value = 100)
    @Column("integer_max_tom")
    private Integer integerMaxTom;

    @Column("long_tom")
    private Long longTom;

    @NotNull(message = "must not be null")
    @Column("long_required_tom")
    private Long longRequiredTom;

    @Min(value = 0L)
    @Column("long_min_tom")
    private Long longMinTom;

    @Max(value = 100L)
    @Column("long_max_tom")
    private Long longMaxTom;

    @Column("float_tom")
    private Float floatTom;

    @NotNull(message = "must not be null")
    @Column("float_required_tom")
    private Float floatRequiredTom;

    @DecimalMin(value = "0")
    @Column("float_min_tom")
    private Float floatMinTom;

    @DecimalMax(value = "100")
    @Column("float_max_tom")
    private Float floatMaxTom;

    @NotNull(message = "must not be null")
    @Column("double_required_tom")
    private Double doubleRequiredTom;

    @DecimalMin(value = "0")
    @Column("double_min_tom")
    private Double doubleMinTom;

    @DecimalMax(value = "100")
    @Column("double_max_tom")
    private Double doubleMaxTom;

    @NotNull(message = "must not be null")
    @Column("big_decimal_required_tom")
    private BigDecimal bigDecimalRequiredTom;

    @DecimalMin(value = "0")
    @Column("big_decimal_min_tom")
    private BigDecimal bigDecimalMinTom;

    @DecimalMax(value = "100")
    @Column("big_decimal_max_tom")
    private BigDecimal bigDecimalMaxTom;

    @Column("local_date_tom")
    private LocalDate localDateTom;

    @NotNull(message = "must not be null")
    @Column("local_date_required_tom")
    private LocalDate localDateRequiredTom;

    @Column("instant_tom")
    private Instant instantTom;

    @NotNull(message = "must not be null")
    @Column("instant_required_tom")
    private Instant instantRequiredTom;

    @Column("zoned_date_time_tom")
    private ZonedDateTime zonedDateTimeTom;

    @NotNull(message = "must not be null")
    @Column("zoned_date_time_required_tom")
    private ZonedDateTime zonedDateTimeRequiredTom;

    @Column("duration_tom")
    private Duration durationTom;

    @NotNull(message = "must not be null")
    @Column("duration_required_tom")
    private Duration durationRequiredTom;

    @Column("boolean_tom")
    private Boolean booleanTom;

    @NotNull(message = "must not be null")
    @Column("boolean_required_tom")
    private Boolean booleanRequiredTom;

    @Column("enum_tom")
    private EnumFieldClass enumTom;

    @NotNull(message = "must not be null")
    @Column("enum_required_tom")
    private EnumRequiredFieldClass enumRequiredTom;

    @Column("uuid_tom")
    private UUID uuidTom;

    @NotNull(message = "must not be null")
    @Column("uuid_required_tom")
    private UUID uuidRequiredTom;

    @Column("byte_image_tom")
    private byte[] byteImageTom;

    @Column("byte_image_tom_content_type")
    private String byteImageTomContentType;

    @Column("byte_image_required_tom")
    private byte[] byteImageRequiredTom;

    @NotNull
    @Column("byte_image_required_tom_content_type")
    private String byteImageRequiredTomContentType;

    @Column("byte_image_minbytes_tom")
    private byte[] byteImageMinbytesTom;

    @Column("byte_image_minbytes_tom_content_type")
    private String byteImageMinbytesTomContentType;

    @Column("byte_image_maxbytes_tom")
    private byte[] byteImageMaxbytesTom;

    @Column("byte_image_maxbytes_tom_content_type")
    private String byteImageMaxbytesTomContentType;

    @Column("byte_any_tom")
    private byte[] byteAnyTom;

    @Column("byte_any_tom_content_type")
    private String byteAnyTomContentType;

    @Column("byte_any_required_tom")
    private byte[] byteAnyRequiredTom;

    @NotNull
    @Column("byte_any_required_tom_content_type")
    private String byteAnyRequiredTomContentType;

    @Column("byte_any_minbytes_tom")
    private byte[] byteAnyMinbytesTom;

    @Column("byte_any_minbytes_tom_content_type")
    private String byteAnyMinbytesTomContentType;

    @Column("byte_any_maxbytes_tom")
    private byte[] byteAnyMaxbytesTom;

    @Column("byte_any_maxbytes_tom_content_type")
    private String byteAnyMaxbytesTomContentType;

    @Column("byte_text_tom")
    private String byteTextTom;

    @Column("byte_text_required_tom")
    private String byteTextRequiredTom;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public FieldTestEntity id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStringTom() {
        return this.stringTom;
    }

    public FieldTestEntity stringTom(String stringTom) {
        this.setStringTom(stringTom);
        return this;
    }

    public void setStringTom(String stringTom) {
        this.stringTom = stringTom;
    }

    public String getStringRequiredTom() {
        return this.stringRequiredTom;
    }

    public FieldTestEntity stringRequiredTom(String stringRequiredTom) {
        this.setStringRequiredTom(stringRequiredTom);
        return this;
    }

    public void setStringRequiredTom(String stringRequiredTom) {
        this.stringRequiredTom = stringRequiredTom;
    }

    public String getStringMinlengthTom() {
        return this.stringMinlengthTom;
    }

    public FieldTestEntity stringMinlengthTom(String stringMinlengthTom) {
        this.setStringMinlengthTom(stringMinlengthTom);
        return this;
    }

    public void setStringMinlengthTom(String stringMinlengthTom) {
        this.stringMinlengthTom = stringMinlengthTom;
    }

    public String getStringMaxlengthTom() {
        return this.stringMaxlengthTom;
    }

    public FieldTestEntity stringMaxlengthTom(String stringMaxlengthTom) {
        this.setStringMaxlengthTom(stringMaxlengthTom);
        return this;
    }

    public void setStringMaxlengthTom(String stringMaxlengthTom) {
        this.stringMaxlengthTom = stringMaxlengthTom;
    }

    public String getStringPatternTom() {
        return this.stringPatternTom;
    }

    public FieldTestEntity stringPatternTom(String stringPatternTom) {
        this.setStringPatternTom(stringPatternTom);
        return this;
    }

    public void setStringPatternTom(String stringPatternTom) {
        this.stringPatternTom = stringPatternTom;
    }

    public String getNumberPatternTom() {
        return this.numberPatternTom;
    }

    public FieldTestEntity numberPatternTom(String numberPatternTom) {
        this.setNumberPatternTom(numberPatternTom);
        return this;
    }

    public void setNumberPatternTom(String numberPatternTom) {
        this.numberPatternTom = numberPatternTom;
    }

    public String getNumberPatternRequiredTom() {
        return this.numberPatternRequiredTom;
    }

    public FieldTestEntity numberPatternRequiredTom(String numberPatternRequiredTom) {
        this.setNumberPatternRequiredTom(numberPatternRequiredTom);
        return this;
    }

    public void setNumberPatternRequiredTom(String numberPatternRequiredTom) {
        this.numberPatternRequiredTom = numberPatternRequiredTom;
    }

    public Integer getIntegerTom() {
        return this.integerTom;
    }

    public FieldTestEntity integerTom(Integer integerTom) {
        this.setIntegerTom(integerTom);
        return this;
    }

    public void setIntegerTom(Integer integerTom) {
        this.integerTom = integerTom;
    }

    public Integer getIntegerRequiredTom() {
        return this.integerRequiredTom;
    }

    public FieldTestEntity integerRequiredTom(Integer integerRequiredTom) {
        this.setIntegerRequiredTom(integerRequiredTom);
        return this;
    }

    public void setIntegerRequiredTom(Integer integerRequiredTom) {
        this.integerRequiredTom = integerRequiredTom;
    }

    public Integer getIntegerMinTom() {
        return this.integerMinTom;
    }

    public FieldTestEntity integerMinTom(Integer integerMinTom) {
        this.setIntegerMinTom(integerMinTom);
        return this;
    }

    public void setIntegerMinTom(Integer integerMinTom) {
        this.integerMinTom = integerMinTom;
    }

    public Integer getIntegerMaxTom() {
        return this.integerMaxTom;
    }

    public FieldTestEntity integerMaxTom(Integer integerMaxTom) {
        this.setIntegerMaxTom(integerMaxTom);
        return this;
    }

    public void setIntegerMaxTom(Integer integerMaxTom) {
        this.integerMaxTom = integerMaxTom;
    }

    public Long getLongTom() {
        return this.longTom;
    }

    public FieldTestEntity longTom(Long longTom) {
        this.setLongTom(longTom);
        return this;
    }

    public void setLongTom(Long longTom) {
        this.longTom = longTom;
    }

    public Long getLongRequiredTom() {
        return this.longRequiredTom;
    }

    public FieldTestEntity longRequiredTom(Long longRequiredTom) {
        this.setLongRequiredTom(longRequiredTom);
        return this;
    }

    public void setLongRequiredTom(Long longRequiredTom) {
        this.longRequiredTom = longRequiredTom;
    }

    public Long getLongMinTom() {
        return this.longMinTom;
    }

    public FieldTestEntity longMinTom(Long longMinTom) {
        this.setLongMinTom(longMinTom);
        return this;
    }

    public void setLongMinTom(Long longMinTom) {
        this.longMinTom = longMinTom;
    }

    public Long getLongMaxTom() {
        return this.longMaxTom;
    }

    public FieldTestEntity longMaxTom(Long longMaxTom) {
        this.setLongMaxTom(longMaxTom);
        return this;
    }

    public void setLongMaxTom(Long longMaxTom) {
        this.longMaxTom = longMaxTom;
    }

    public Float getFloatTom() {
        return this.floatTom;
    }

    public FieldTestEntity floatTom(Float floatTom) {
        this.setFloatTom(floatTom);
        return this;
    }

    public void setFloatTom(Float floatTom) {
        this.floatTom = floatTom;
    }

    public Float getFloatRequiredTom() {
        return this.floatRequiredTom;
    }

    public FieldTestEntity floatRequiredTom(Float floatRequiredTom) {
        this.setFloatRequiredTom(floatRequiredTom);
        return this;
    }

    public void setFloatRequiredTom(Float floatRequiredTom) {
        this.floatRequiredTom = floatRequiredTom;
    }

    public Float getFloatMinTom() {
        return this.floatMinTom;
    }

    public FieldTestEntity floatMinTom(Float floatMinTom) {
        this.setFloatMinTom(floatMinTom);
        return this;
    }

    public void setFloatMinTom(Float floatMinTom) {
        this.floatMinTom = floatMinTom;
    }

    public Float getFloatMaxTom() {
        return this.floatMaxTom;
    }

    public FieldTestEntity floatMaxTom(Float floatMaxTom) {
        this.setFloatMaxTom(floatMaxTom);
        return this;
    }

    public void setFloatMaxTom(Float floatMaxTom) {
        this.floatMaxTom = floatMaxTom;
    }

    public Double getDoubleRequiredTom() {
        return this.doubleRequiredTom;
    }

    public FieldTestEntity doubleRequiredTom(Double doubleRequiredTom) {
        this.setDoubleRequiredTom(doubleRequiredTom);
        return this;
    }

    public void setDoubleRequiredTom(Double doubleRequiredTom) {
        this.doubleRequiredTom = doubleRequiredTom;
    }

    public Double getDoubleMinTom() {
        return this.doubleMinTom;
    }

    public FieldTestEntity doubleMinTom(Double doubleMinTom) {
        this.setDoubleMinTom(doubleMinTom);
        return this;
    }

    public void setDoubleMinTom(Double doubleMinTom) {
        this.doubleMinTom = doubleMinTom;
    }

    public Double getDoubleMaxTom() {
        return this.doubleMaxTom;
    }

    public FieldTestEntity doubleMaxTom(Double doubleMaxTom) {
        this.setDoubleMaxTom(doubleMaxTom);
        return this;
    }

    public void setDoubleMaxTom(Double doubleMaxTom) {
        this.doubleMaxTom = doubleMaxTom;
    }

    public BigDecimal getBigDecimalRequiredTom() {
        return this.bigDecimalRequiredTom;
    }

    public FieldTestEntity bigDecimalRequiredTom(BigDecimal bigDecimalRequiredTom) {
        this.setBigDecimalRequiredTom(bigDecimalRequiredTom);
        return this;
    }

    public void setBigDecimalRequiredTom(BigDecimal bigDecimalRequiredTom) {
        this.bigDecimalRequiredTom = bigDecimalRequiredTom != null ? bigDecimalRequiredTom.stripTrailingZeros() : null;
    }

    public BigDecimal getBigDecimalMinTom() {
        return this.bigDecimalMinTom;
    }

    public FieldTestEntity bigDecimalMinTom(BigDecimal bigDecimalMinTom) {
        this.setBigDecimalMinTom(bigDecimalMinTom);
        return this;
    }

    public void setBigDecimalMinTom(BigDecimal bigDecimalMinTom) {
        this.bigDecimalMinTom = bigDecimalMinTom != null ? bigDecimalMinTom.stripTrailingZeros() : null;
    }

    public BigDecimal getBigDecimalMaxTom() {
        return this.bigDecimalMaxTom;
    }

    public FieldTestEntity bigDecimalMaxTom(BigDecimal bigDecimalMaxTom) {
        this.setBigDecimalMaxTom(bigDecimalMaxTom);
        return this;
    }

    public void setBigDecimalMaxTom(BigDecimal bigDecimalMaxTom) {
        this.bigDecimalMaxTom = bigDecimalMaxTom != null ? bigDecimalMaxTom.stripTrailingZeros() : null;
    }

    public LocalDate getLocalDateTom() {
        return this.localDateTom;
    }

    public FieldTestEntity localDateTom(LocalDate localDateTom) {
        this.setLocalDateTom(localDateTom);
        return this;
    }

    public void setLocalDateTom(LocalDate localDateTom) {
        this.localDateTom = localDateTom;
    }

    public LocalDate getLocalDateRequiredTom() {
        return this.localDateRequiredTom;
    }

    public FieldTestEntity localDateRequiredTom(LocalDate localDateRequiredTom) {
        this.setLocalDateRequiredTom(localDateRequiredTom);
        return this;
    }

    public void setLocalDateRequiredTom(LocalDate localDateRequiredTom) {
        this.localDateRequiredTom = localDateRequiredTom;
    }

    public Instant getInstantTom() {
        return this.instantTom;
    }

    public FieldTestEntity instantTom(Instant instantTom) {
        this.setInstantTom(instantTom);
        return this;
    }

    public void setInstantTom(Instant instantTom) {
        this.instantTom = instantTom;
    }

    public Instant getInstantRequiredTom() {
        return this.instantRequiredTom;
    }

    public FieldTestEntity instantRequiredTom(Instant instantRequiredTom) {
        this.setInstantRequiredTom(instantRequiredTom);
        return this;
    }

    public void setInstantRequiredTom(Instant instantRequiredTom) {
        this.instantRequiredTom = instantRequiredTom;
    }

    public ZonedDateTime getZonedDateTimeTom() {
        return this.zonedDateTimeTom;
    }

    public FieldTestEntity zonedDateTimeTom(ZonedDateTime zonedDateTimeTom) {
        this.setZonedDateTimeTom(zonedDateTimeTom);
        return this;
    }

    public void setZonedDateTimeTom(ZonedDateTime zonedDateTimeTom) {
        this.zonedDateTimeTom = zonedDateTimeTom;
    }

    public ZonedDateTime getZonedDateTimeRequiredTom() {
        return this.zonedDateTimeRequiredTom;
    }

    public FieldTestEntity zonedDateTimeRequiredTom(ZonedDateTime zonedDateTimeRequiredTom) {
        this.setZonedDateTimeRequiredTom(zonedDateTimeRequiredTom);
        return this;
    }

    public void setZonedDateTimeRequiredTom(ZonedDateTime zonedDateTimeRequiredTom) {
        this.zonedDateTimeRequiredTom = zonedDateTimeRequiredTom;
    }

    public Duration getDurationTom() {
        return this.durationTom;
    }

    public FieldTestEntity durationTom(Duration durationTom) {
        this.setDurationTom(durationTom);
        return this;
    }

    public void setDurationTom(Duration durationTom) {
        this.durationTom = durationTom;
    }

    public Duration getDurationRequiredTom() {
        return this.durationRequiredTom;
    }

    public FieldTestEntity durationRequiredTom(Duration durationRequiredTom) {
        this.setDurationRequiredTom(durationRequiredTom);
        return this;
    }

    public void setDurationRequiredTom(Duration durationRequiredTom) {
        this.durationRequiredTom = durationRequiredTom;
    }

    public Boolean getBooleanTom() {
        return this.booleanTom;
    }

    public FieldTestEntity booleanTom(Boolean booleanTom) {
        this.setBooleanTom(booleanTom);
        return this;
    }

    public void setBooleanTom(Boolean booleanTom) {
        this.booleanTom = booleanTom;
    }

    public Boolean getBooleanRequiredTom() {
        return this.booleanRequiredTom;
    }

    public FieldTestEntity booleanRequiredTom(Boolean booleanRequiredTom) {
        this.setBooleanRequiredTom(booleanRequiredTom);
        return this;
    }

    public void setBooleanRequiredTom(Boolean booleanRequiredTom) {
        this.booleanRequiredTom = booleanRequiredTom;
    }

    public EnumFieldClass getEnumTom() {
        return this.enumTom;
    }

    public FieldTestEntity enumTom(EnumFieldClass enumTom) {
        this.setEnumTom(enumTom);
        return this;
    }

    public void setEnumTom(EnumFieldClass enumTom) {
        this.enumTom = enumTom;
    }

    public EnumRequiredFieldClass getEnumRequiredTom() {
        return this.enumRequiredTom;
    }

    public FieldTestEntity enumRequiredTom(EnumRequiredFieldClass enumRequiredTom) {
        this.setEnumRequiredTom(enumRequiredTom);
        return this;
    }

    public void setEnumRequiredTom(EnumRequiredFieldClass enumRequiredTom) {
        this.enumRequiredTom = enumRequiredTom;
    }

    public UUID getUuidTom() {
        return this.uuidTom;
    }

    public FieldTestEntity uuidTom(UUID uuidTom) {
        this.setUuidTom(uuidTom);
        return this;
    }

    public void setUuidTom(UUID uuidTom) {
        this.uuidTom = uuidTom;
    }

    public UUID getUuidRequiredTom() {
        return this.uuidRequiredTom;
    }

    public FieldTestEntity uuidRequiredTom(UUID uuidRequiredTom) {
        this.setUuidRequiredTom(uuidRequiredTom);
        return this;
    }

    public void setUuidRequiredTom(UUID uuidRequiredTom) {
        this.uuidRequiredTom = uuidRequiredTom;
    }

    public byte[] getByteImageTom() {
        return this.byteImageTom;
    }

    public FieldTestEntity byteImageTom(byte[] byteImageTom) {
        this.setByteImageTom(byteImageTom);
        return this;
    }

    public void setByteImageTom(byte[] byteImageTom) {
        this.byteImageTom = byteImageTom;
    }

    public String getByteImageTomContentType() {
        return this.byteImageTomContentType;
    }

    public FieldTestEntity byteImageTomContentType(String byteImageTomContentType) {
        this.byteImageTomContentType = byteImageTomContentType;
        return this;
    }

    public void setByteImageTomContentType(String byteImageTomContentType) {
        this.byteImageTomContentType = byteImageTomContentType;
    }

    public byte[] getByteImageRequiredTom() {
        return this.byteImageRequiredTom;
    }

    public FieldTestEntity byteImageRequiredTom(byte[] byteImageRequiredTom) {
        this.setByteImageRequiredTom(byteImageRequiredTom);
        return this;
    }

    public void setByteImageRequiredTom(byte[] byteImageRequiredTom) {
        this.byteImageRequiredTom = byteImageRequiredTom;
    }

    public String getByteImageRequiredTomContentType() {
        return this.byteImageRequiredTomContentType;
    }

    public FieldTestEntity byteImageRequiredTomContentType(String byteImageRequiredTomContentType) {
        this.byteImageRequiredTomContentType = byteImageRequiredTomContentType;
        return this;
    }

    public void setByteImageRequiredTomContentType(String byteImageRequiredTomContentType) {
        this.byteImageRequiredTomContentType = byteImageRequiredTomContentType;
    }

    public byte[] getByteImageMinbytesTom() {
        return this.byteImageMinbytesTom;
    }

    public FieldTestEntity byteImageMinbytesTom(byte[] byteImageMinbytesTom) {
        this.setByteImageMinbytesTom(byteImageMinbytesTom);
        return this;
    }

    public void setByteImageMinbytesTom(byte[] byteImageMinbytesTom) {
        this.byteImageMinbytesTom = byteImageMinbytesTom;
    }

    public String getByteImageMinbytesTomContentType() {
        return this.byteImageMinbytesTomContentType;
    }

    public FieldTestEntity byteImageMinbytesTomContentType(String byteImageMinbytesTomContentType) {
        this.byteImageMinbytesTomContentType = byteImageMinbytesTomContentType;
        return this;
    }

    public void setByteImageMinbytesTomContentType(String byteImageMinbytesTomContentType) {
        this.byteImageMinbytesTomContentType = byteImageMinbytesTomContentType;
    }

    public byte[] getByteImageMaxbytesTom() {
        return this.byteImageMaxbytesTom;
    }

    public FieldTestEntity byteImageMaxbytesTom(byte[] byteImageMaxbytesTom) {
        this.setByteImageMaxbytesTom(byteImageMaxbytesTom);
        return this;
    }

    public void setByteImageMaxbytesTom(byte[] byteImageMaxbytesTom) {
        this.byteImageMaxbytesTom = byteImageMaxbytesTom;
    }

    public String getByteImageMaxbytesTomContentType() {
        return this.byteImageMaxbytesTomContentType;
    }

    public FieldTestEntity byteImageMaxbytesTomContentType(String byteImageMaxbytesTomContentType) {
        this.byteImageMaxbytesTomContentType = byteImageMaxbytesTomContentType;
        return this;
    }

    public void setByteImageMaxbytesTomContentType(String byteImageMaxbytesTomContentType) {
        this.byteImageMaxbytesTomContentType = byteImageMaxbytesTomContentType;
    }

    public byte[] getByteAnyTom() {
        return this.byteAnyTom;
    }

    public FieldTestEntity byteAnyTom(byte[] byteAnyTom) {
        this.setByteAnyTom(byteAnyTom);
        return this;
    }

    public void setByteAnyTom(byte[] byteAnyTom) {
        this.byteAnyTom = byteAnyTom;
    }

    public String getByteAnyTomContentType() {
        return this.byteAnyTomContentType;
    }

    public FieldTestEntity byteAnyTomContentType(String byteAnyTomContentType) {
        this.byteAnyTomContentType = byteAnyTomContentType;
        return this;
    }

    public void setByteAnyTomContentType(String byteAnyTomContentType) {
        this.byteAnyTomContentType = byteAnyTomContentType;
    }

    public byte[] getByteAnyRequiredTom() {
        return this.byteAnyRequiredTom;
    }

    public FieldTestEntity byteAnyRequiredTom(byte[] byteAnyRequiredTom) {
        this.setByteAnyRequiredTom(byteAnyRequiredTom);
        return this;
    }

    public void setByteAnyRequiredTom(byte[] byteAnyRequiredTom) {
        this.byteAnyRequiredTom = byteAnyRequiredTom;
    }

    public String getByteAnyRequiredTomContentType() {
        return this.byteAnyRequiredTomContentType;
    }

    public FieldTestEntity byteAnyRequiredTomContentType(String byteAnyRequiredTomContentType) {
        this.byteAnyRequiredTomContentType = byteAnyRequiredTomContentType;
        return this;
    }

    public void setByteAnyRequiredTomContentType(String byteAnyRequiredTomContentType) {
        this.byteAnyRequiredTomContentType = byteAnyRequiredTomContentType;
    }

    public byte[] getByteAnyMinbytesTom() {
        return this.byteAnyMinbytesTom;
    }

    public FieldTestEntity byteAnyMinbytesTom(byte[] byteAnyMinbytesTom) {
        this.setByteAnyMinbytesTom(byteAnyMinbytesTom);
        return this;
    }

    public void setByteAnyMinbytesTom(byte[] byteAnyMinbytesTom) {
        this.byteAnyMinbytesTom = byteAnyMinbytesTom;
    }

    public String getByteAnyMinbytesTomContentType() {
        return this.byteAnyMinbytesTomContentType;
    }

    public FieldTestEntity byteAnyMinbytesTomContentType(String byteAnyMinbytesTomContentType) {
        this.byteAnyMinbytesTomContentType = byteAnyMinbytesTomContentType;
        return this;
    }

    public void setByteAnyMinbytesTomContentType(String byteAnyMinbytesTomContentType) {
        this.byteAnyMinbytesTomContentType = byteAnyMinbytesTomContentType;
    }

    public byte[] getByteAnyMaxbytesTom() {
        return this.byteAnyMaxbytesTom;
    }

    public FieldTestEntity byteAnyMaxbytesTom(byte[] byteAnyMaxbytesTom) {
        this.setByteAnyMaxbytesTom(byteAnyMaxbytesTom);
        return this;
    }

    public void setByteAnyMaxbytesTom(byte[] byteAnyMaxbytesTom) {
        this.byteAnyMaxbytesTom = byteAnyMaxbytesTom;
    }

    public String getByteAnyMaxbytesTomContentType() {
        return this.byteAnyMaxbytesTomContentType;
    }

    public FieldTestEntity byteAnyMaxbytesTomContentType(String byteAnyMaxbytesTomContentType) {
        this.byteAnyMaxbytesTomContentType = byteAnyMaxbytesTomContentType;
        return this;
    }

    public void setByteAnyMaxbytesTomContentType(String byteAnyMaxbytesTomContentType) {
        this.byteAnyMaxbytesTomContentType = byteAnyMaxbytesTomContentType;
    }

    public String getByteTextTom() {
        return this.byteTextTom;
    }

    public FieldTestEntity byteTextTom(String byteTextTom) {
        this.setByteTextTom(byteTextTom);
        return this;
    }

    public void setByteTextTom(String byteTextTom) {
        this.byteTextTom = byteTextTom;
    }

    public String getByteTextRequiredTom() {
        return this.byteTextRequiredTom;
    }

    public FieldTestEntity byteTextRequiredTom(String byteTextRequiredTom) {
        this.setByteTextRequiredTom(byteTextRequiredTom);
        return this;
    }

    public void setByteTextRequiredTom(String byteTextRequiredTom) {
        this.byteTextRequiredTom = byteTextRequiredTom;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FieldTestEntity)) {
            return false;
        }
        return id != null && id.equals(((FieldTestEntity) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FieldTestEntity{" +
            "id=" + getId() +
            ", stringTom='" + getStringTom() + "'" +
            ", stringRequiredTom='" + getStringRequiredTom() + "'" +
            ", stringMinlengthTom='" + getStringMinlengthTom() + "'" +
            ", stringMaxlengthTom='" + getStringMaxlengthTom() + "'" +
            ", stringPatternTom='" + getStringPatternTom() + "'" +
            ", numberPatternTom='" + getNumberPatternTom() + "'" +
            ", numberPatternRequiredTom='" + getNumberPatternRequiredTom() + "'" +
            ", integerTom=" + getIntegerTom() +
            ", integerRequiredTom=" + getIntegerRequiredTom() +
            ", integerMinTom=" + getIntegerMinTom() +
            ", integerMaxTom=" + getIntegerMaxTom() +
            ", longTom=" + getLongTom() +
            ", longRequiredTom=" + getLongRequiredTom() +
            ", longMinTom=" + getLongMinTom() +
            ", longMaxTom=" + getLongMaxTom() +
            ", floatTom=" + getFloatTom() +
            ", floatRequiredTom=" + getFloatRequiredTom() +
            ", floatMinTom=" + getFloatMinTom() +
            ", floatMaxTom=" + getFloatMaxTom() +
            ", doubleRequiredTom=" + getDoubleRequiredTom() +
            ", doubleMinTom=" + getDoubleMinTom() +
            ", doubleMaxTom=" + getDoubleMaxTom() +
            ", bigDecimalRequiredTom=" + getBigDecimalRequiredTom() +
            ", bigDecimalMinTom=" + getBigDecimalMinTom() +
            ", bigDecimalMaxTom=" + getBigDecimalMaxTom() +
            ", localDateTom='" + getLocalDateTom() + "'" +
            ", localDateRequiredTom='" + getLocalDateRequiredTom() + "'" +
            ", instantTom='" + getInstantTom() + "'" +
            ", instantRequiredTom='" + getInstantRequiredTom() + "'" +
            ", zonedDateTimeTom='" + getZonedDateTimeTom() + "'" +
            ", zonedDateTimeRequiredTom='" + getZonedDateTimeRequiredTom() + "'" +
            ", durationTom='" + getDurationTom() + "'" +
            ", durationRequiredTom='" + getDurationRequiredTom() + "'" +
            ", booleanTom='" + getBooleanTom() + "'" +
            ", booleanRequiredTom='" + getBooleanRequiredTom() + "'" +
            ", enumTom='" + getEnumTom() + "'" +
            ", enumRequiredTom='" + getEnumRequiredTom() + "'" +
            ", uuidTom='" + getUuidTom() + "'" +
            ", uuidRequiredTom='" + getUuidRequiredTom() + "'" +
            ", byteImageTom='" + getByteImageTom() + "'" +
            ", byteImageTomContentType='" + getByteImageTomContentType() + "'" +
            ", byteImageRequiredTom='" + getByteImageRequiredTom() + "'" +
            ", byteImageRequiredTomContentType='" + getByteImageRequiredTomContentType() + "'" +
            ", byteImageMinbytesTom='" + getByteImageMinbytesTom() + "'" +
            ", byteImageMinbytesTomContentType='" + getByteImageMinbytesTomContentType() + "'" +
            ", byteImageMaxbytesTom='" + getByteImageMaxbytesTom() + "'" +
            ", byteImageMaxbytesTomContentType='" + getByteImageMaxbytesTomContentType() + "'" +
            ", byteAnyTom='" + getByteAnyTom() + "'" +
            ", byteAnyTomContentType='" + getByteAnyTomContentType() + "'" +
            ", byteAnyRequiredTom='" + getByteAnyRequiredTom() + "'" +
            ", byteAnyRequiredTomContentType='" + getByteAnyRequiredTomContentType() + "'" +
            ", byteAnyMinbytesTom='" + getByteAnyMinbytesTom() + "'" +
            ", byteAnyMinbytesTomContentType='" + getByteAnyMinbytesTomContentType() + "'" +
            ", byteAnyMaxbytesTom='" + getByteAnyMaxbytesTom() + "'" +
            ", byteAnyMaxbytesTomContentType='" + getByteAnyMaxbytesTomContentType() + "'" +
            ", byteTextTom='" + getByteTextTom() + "'" +
            ", byteTextRequiredTom='" + getByteTextRequiredTom() + "'" +
            "}";
    }
}
