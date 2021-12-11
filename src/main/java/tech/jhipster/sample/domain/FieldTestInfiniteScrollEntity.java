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
 * A FieldTestInfiniteScrollEntity.
 */
@Table("field_test_infinite_scroll_entity")
public class FieldTestInfiniteScrollEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("string_hugo")
    private String stringHugo;

    @NotNull(message = "must not be null")
    @Column("string_required_hugo")
    private String stringRequiredHugo;

    @Size(min = 0)
    @Column("string_minlength_hugo")
    private String stringMinlengthHugo;

    @Size(max = 20)
    @Column("string_maxlength_hugo")
    private String stringMaxlengthHugo;

    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    @Column("string_pattern_hugo")
    private String stringPatternHugo;

    @Column("integer_hugo")
    private Integer integerHugo;

    @NotNull(message = "must not be null")
    @Column("integer_required_hugo")
    private Integer integerRequiredHugo;

    @Min(value = 0)
    @Column("integer_min_hugo")
    private Integer integerMinHugo;

    @Max(value = 100)
    @Column("integer_max_hugo")
    private Integer integerMaxHugo;

    @Column("long_hugo")
    private Long longHugo;

    @NotNull(message = "must not be null")
    @Column("long_required_hugo")
    private Long longRequiredHugo;

    @Min(value = 0L)
    @Column("long_min_hugo")
    private Long longMinHugo;

    @Max(value = 100L)
    @Column("long_max_hugo")
    private Long longMaxHugo;

    @Column("float_hugo")
    private Float floatHugo;

    @NotNull(message = "must not be null")
    @Column("float_required_hugo")
    private Float floatRequiredHugo;

    @DecimalMin(value = "0")
    @Column("float_min_hugo")
    private Float floatMinHugo;

    @DecimalMax(value = "100")
    @Column("float_max_hugo")
    private Float floatMaxHugo;

    @NotNull(message = "must not be null")
    @Column("double_required_hugo")
    private Double doubleRequiredHugo;

    @DecimalMin(value = "0")
    @Column("double_min_hugo")
    private Double doubleMinHugo;

    @DecimalMax(value = "100")
    @Column("double_max_hugo")
    private Double doubleMaxHugo;

    @NotNull(message = "must not be null")
    @Column("big_decimal_required_hugo")
    private BigDecimal bigDecimalRequiredHugo;

    @DecimalMin(value = "0")
    @Column("big_decimal_min_hugo")
    private BigDecimal bigDecimalMinHugo;

    @DecimalMax(value = "100")
    @Column("big_decimal_max_hugo")
    private BigDecimal bigDecimalMaxHugo;

    @Column("local_date_hugo")
    private LocalDate localDateHugo;

    @NotNull(message = "must not be null")
    @Column("local_date_required_hugo")
    private LocalDate localDateRequiredHugo;

    @Column("instant_hugo")
    private Instant instantHugo;

    @NotNull(message = "must not be null")
    @Column("instante_required_hugo")
    private Instant instanteRequiredHugo;

    @Column("zoned_date_time_hugo")
    private ZonedDateTime zonedDateTimeHugo;

    @NotNull(message = "must not be null")
    @Column("zoned_date_time_required_hugo")
    private ZonedDateTime zonedDateTimeRequiredHugo;

    @Column("duration_hugo")
    private Duration durationHugo;

    @NotNull(message = "must not be null")
    @Column("duration_required_hugo")
    private Duration durationRequiredHugo;

    @Column("boolean_hugo")
    private Boolean booleanHugo;

    @NotNull(message = "must not be null")
    @Column("boolean_required_hugo")
    private Boolean booleanRequiredHugo;

    @Column("enum_hugo")
    private EnumFieldClass enumHugo;

    @NotNull(message = "must not be null")
    @Column("enum_required_hugo")
    private EnumRequiredFieldClass enumRequiredHugo;

    @Column("uuid_hugo")
    private UUID uuidHugo;

    @NotNull(message = "must not be null")
    @Column("uuid_required_hugo")
    private UUID uuidRequiredHugo;

    @Column("byte_image_hugo")
    private byte[] byteImageHugo;

    @Column("byte_image_hugo_content_type")
    private String byteImageHugoContentType;

    @Column("byte_image_required_hugo")
    private byte[] byteImageRequiredHugo;

    @NotNull
    @Column("byte_image_required_hugo_content_type")
    private String byteImageRequiredHugoContentType;

    @Column("byte_image_minbytes_hugo")
    private byte[] byteImageMinbytesHugo;

    @Column("byte_image_minbytes_hugo_content_type")
    private String byteImageMinbytesHugoContentType;

    @Column("byte_image_maxbytes_hugo")
    private byte[] byteImageMaxbytesHugo;

    @Column("byte_image_maxbytes_hugo_content_type")
    private String byteImageMaxbytesHugoContentType;

    @Column("byte_any_hugo")
    private byte[] byteAnyHugo;

    @Column("byte_any_hugo_content_type")
    private String byteAnyHugoContentType;

    @Column("byte_any_required_hugo")
    private byte[] byteAnyRequiredHugo;

    @NotNull
    @Column("byte_any_required_hugo_content_type")
    private String byteAnyRequiredHugoContentType;

    @Column("byte_any_minbytes_hugo")
    private byte[] byteAnyMinbytesHugo;

    @Column("byte_any_minbytes_hugo_content_type")
    private String byteAnyMinbytesHugoContentType;

    @Column("byte_any_maxbytes_hugo")
    private byte[] byteAnyMaxbytesHugo;

    @Column("byte_any_maxbytes_hugo_content_type")
    private String byteAnyMaxbytesHugoContentType;

    @Column("byte_text_hugo")
    private String byteTextHugo;

    @Column("byte_text_required_hugo")
    private String byteTextRequiredHugo;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public FieldTestInfiniteScrollEntity id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStringHugo() {
        return this.stringHugo;
    }

    public FieldTestInfiniteScrollEntity stringHugo(String stringHugo) {
        this.setStringHugo(stringHugo);
        return this;
    }

    public void setStringHugo(String stringHugo) {
        this.stringHugo = stringHugo;
    }

    public String getStringRequiredHugo() {
        return this.stringRequiredHugo;
    }

    public FieldTestInfiniteScrollEntity stringRequiredHugo(String stringRequiredHugo) {
        this.setStringRequiredHugo(stringRequiredHugo);
        return this;
    }

    public void setStringRequiredHugo(String stringRequiredHugo) {
        this.stringRequiredHugo = stringRequiredHugo;
    }

    public String getStringMinlengthHugo() {
        return this.stringMinlengthHugo;
    }

    public FieldTestInfiniteScrollEntity stringMinlengthHugo(String stringMinlengthHugo) {
        this.setStringMinlengthHugo(stringMinlengthHugo);
        return this;
    }

    public void setStringMinlengthHugo(String stringMinlengthHugo) {
        this.stringMinlengthHugo = stringMinlengthHugo;
    }

    public String getStringMaxlengthHugo() {
        return this.stringMaxlengthHugo;
    }

    public FieldTestInfiniteScrollEntity stringMaxlengthHugo(String stringMaxlengthHugo) {
        this.setStringMaxlengthHugo(stringMaxlengthHugo);
        return this;
    }

    public void setStringMaxlengthHugo(String stringMaxlengthHugo) {
        this.stringMaxlengthHugo = stringMaxlengthHugo;
    }

    public String getStringPatternHugo() {
        return this.stringPatternHugo;
    }

    public FieldTestInfiniteScrollEntity stringPatternHugo(String stringPatternHugo) {
        this.setStringPatternHugo(stringPatternHugo);
        return this;
    }

    public void setStringPatternHugo(String stringPatternHugo) {
        this.stringPatternHugo = stringPatternHugo;
    }

    public Integer getIntegerHugo() {
        return this.integerHugo;
    }

    public FieldTestInfiniteScrollEntity integerHugo(Integer integerHugo) {
        this.setIntegerHugo(integerHugo);
        return this;
    }

    public void setIntegerHugo(Integer integerHugo) {
        this.integerHugo = integerHugo;
    }

    public Integer getIntegerRequiredHugo() {
        return this.integerRequiredHugo;
    }

    public FieldTestInfiniteScrollEntity integerRequiredHugo(Integer integerRequiredHugo) {
        this.setIntegerRequiredHugo(integerRequiredHugo);
        return this;
    }

    public void setIntegerRequiredHugo(Integer integerRequiredHugo) {
        this.integerRequiredHugo = integerRequiredHugo;
    }

    public Integer getIntegerMinHugo() {
        return this.integerMinHugo;
    }

    public FieldTestInfiniteScrollEntity integerMinHugo(Integer integerMinHugo) {
        this.setIntegerMinHugo(integerMinHugo);
        return this;
    }

    public void setIntegerMinHugo(Integer integerMinHugo) {
        this.integerMinHugo = integerMinHugo;
    }

    public Integer getIntegerMaxHugo() {
        return this.integerMaxHugo;
    }

    public FieldTestInfiniteScrollEntity integerMaxHugo(Integer integerMaxHugo) {
        this.setIntegerMaxHugo(integerMaxHugo);
        return this;
    }

    public void setIntegerMaxHugo(Integer integerMaxHugo) {
        this.integerMaxHugo = integerMaxHugo;
    }

    public Long getLongHugo() {
        return this.longHugo;
    }

    public FieldTestInfiniteScrollEntity longHugo(Long longHugo) {
        this.setLongHugo(longHugo);
        return this;
    }

    public void setLongHugo(Long longHugo) {
        this.longHugo = longHugo;
    }

    public Long getLongRequiredHugo() {
        return this.longRequiredHugo;
    }

    public FieldTestInfiniteScrollEntity longRequiredHugo(Long longRequiredHugo) {
        this.setLongRequiredHugo(longRequiredHugo);
        return this;
    }

    public void setLongRequiredHugo(Long longRequiredHugo) {
        this.longRequiredHugo = longRequiredHugo;
    }

    public Long getLongMinHugo() {
        return this.longMinHugo;
    }

    public FieldTestInfiniteScrollEntity longMinHugo(Long longMinHugo) {
        this.setLongMinHugo(longMinHugo);
        return this;
    }

    public void setLongMinHugo(Long longMinHugo) {
        this.longMinHugo = longMinHugo;
    }

    public Long getLongMaxHugo() {
        return this.longMaxHugo;
    }

    public FieldTestInfiniteScrollEntity longMaxHugo(Long longMaxHugo) {
        this.setLongMaxHugo(longMaxHugo);
        return this;
    }

    public void setLongMaxHugo(Long longMaxHugo) {
        this.longMaxHugo = longMaxHugo;
    }

    public Float getFloatHugo() {
        return this.floatHugo;
    }

    public FieldTestInfiniteScrollEntity floatHugo(Float floatHugo) {
        this.setFloatHugo(floatHugo);
        return this;
    }

    public void setFloatHugo(Float floatHugo) {
        this.floatHugo = floatHugo;
    }

    public Float getFloatRequiredHugo() {
        return this.floatRequiredHugo;
    }

    public FieldTestInfiniteScrollEntity floatRequiredHugo(Float floatRequiredHugo) {
        this.setFloatRequiredHugo(floatRequiredHugo);
        return this;
    }

    public void setFloatRequiredHugo(Float floatRequiredHugo) {
        this.floatRequiredHugo = floatRequiredHugo;
    }

    public Float getFloatMinHugo() {
        return this.floatMinHugo;
    }

    public FieldTestInfiniteScrollEntity floatMinHugo(Float floatMinHugo) {
        this.setFloatMinHugo(floatMinHugo);
        return this;
    }

    public void setFloatMinHugo(Float floatMinHugo) {
        this.floatMinHugo = floatMinHugo;
    }

    public Float getFloatMaxHugo() {
        return this.floatMaxHugo;
    }

    public FieldTestInfiniteScrollEntity floatMaxHugo(Float floatMaxHugo) {
        this.setFloatMaxHugo(floatMaxHugo);
        return this;
    }

    public void setFloatMaxHugo(Float floatMaxHugo) {
        this.floatMaxHugo = floatMaxHugo;
    }

    public Double getDoubleRequiredHugo() {
        return this.doubleRequiredHugo;
    }

    public FieldTestInfiniteScrollEntity doubleRequiredHugo(Double doubleRequiredHugo) {
        this.setDoubleRequiredHugo(doubleRequiredHugo);
        return this;
    }

    public void setDoubleRequiredHugo(Double doubleRequiredHugo) {
        this.doubleRequiredHugo = doubleRequiredHugo;
    }

    public Double getDoubleMinHugo() {
        return this.doubleMinHugo;
    }

    public FieldTestInfiniteScrollEntity doubleMinHugo(Double doubleMinHugo) {
        this.setDoubleMinHugo(doubleMinHugo);
        return this;
    }

    public void setDoubleMinHugo(Double doubleMinHugo) {
        this.doubleMinHugo = doubleMinHugo;
    }

    public Double getDoubleMaxHugo() {
        return this.doubleMaxHugo;
    }

    public FieldTestInfiniteScrollEntity doubleMaxHugo(Double doubleMaxHugo) {
        this.setDoubleMaxHugo(doubleMaxHugo);
        return this;
    }

    public void setDoubleMaxHugo(Double doubleMaxHugo) {
        this.doubleMaxHugo = doubleMaxHugo;
    }

    public BigDecimal getBigDecimalRequiredHugo() {
        return this.bigDecimalRequiredHugo;
    }

    public FieldTestInfiniteScrollEntity bigDecimalRequiredHugo(BigDecimal bigDecimalRequiredHugo) {
        this.setBigDecimalRequiredHugo(bigDecimalRequiredHugo);
        return this;
    }

    public void setBigDecimalRequiredHugo(BigDecimal bigDecimalRequiredHugo) {
        this.bigDecimalRequiredHugo = bigDecimalRequiredHugo != null ? bigDecimalRequiredHugo.stripTrailingZeros() : null;
    }

    public BigDecimal getBigDecimalMinHugo() {
        return this.bigDecimalMinHugo;
    }

    public FieldTestInfiniteScrollEntity bigDecimalMinHugo(BigDecimal bigDecimalMinHugo) {
        this.setBigDecimalMinHugo(bigDecimalMinHugo);
        return this;
    }

    public void setBigDecimalMinHugo(BigDecimal bigDecimalMinHugo) {
        this.bigDecimalMinHugo = bigDecimalMinHugo != null ? bigDecimalMinHugo.stripTrailingZeros() : null;
    }

    public BigDecimal getBigDecimalMaxHugo() {
        return this.bigDecimalMaxHugo;
    }

    public FieldTestInfiniteScrollEntity bigDecimalMaxHugo(BigDecimal bigDecimalMaxHugo) {
        this.setBigDecimalMaxHugo(bigDecimalMaxHugo);
        return this;
    }

    public void setBigDecimalMaxHugo(BigDecimal bigDecimalMaxHugo) {
        this.bigDecimalMaxHugo = bigDecimalMaxHugo != null ? bigDecimalMaxHugo.stripTrailingZeros() : null;
    }

    public LocalDate getLocalDateHugo() {
        return this.localDateHugo;
    }

    public FieldTestInfiniteScrollEntity localDateHugo(LocalDate localDateHugo) {
        this.setLocalDateHugo(localDateHugo);
        return this;
    }

    public void setLocalDateHugo(LocalDate localDateHugo) {
        this.localDateHugo = localDateHugo;
    }

    public LocalDate getLocalDateRequiredHugo() {
        return this.localDateRequiredHugo;
    }

    public FieldTestInfiniteScrollEntity localDateRequiredHugo(LocalDate localDateRequiredHugo) {
        this.setLocalDateRequiredHugo(localDateRequiredHugo);
        return this;
    }

    public void setLocalDateRequiredHugo(LocalDate localDateRequiredHugo) {
        this.localDateRequiredHugo = localDateRequiredHugo;
    }

    public Instant getInstantHugo() {
        return this.instantHugo;
    }

    public FieldTestInfiniteScrollEntity instantHugo(Instant instantHugo) {
        this.setInstantHugo(instantHugo);
        return this;
    }

    public void setInstantHugo(Instant instantHugo) {
        this.instantHugo = instantHugo;
    }

    public Instant getInstanteRequiredHugo() {
        return this.instanteRequiredHugo;
    }

    public FieldTestInfiniteScrollEntity instanteRequiredHugo(Instant instanteRequiredHugo) {
        this.setInstanteRequiredHugo(instanteRequiredHugo);
        return this;
    }

    public void setInstanteRequiredHugo(Instant instanteRequiredHugo) {
        this.instanteRequiredHugo = instanteRequiredHugo;
    }

    public ZonedDateTime getZonedDateTimeHugo() {
        return this.zonedDateTimeHugo;
    }

    public FieldTestInfiniteScrollEntity zonedDateTimeHugo(ZonedDateTime zonedDateTimeHugo) {
        this.setZonedDateTimeHugo(zonedDateTimeHugo);
        return this;
    }

    public void setZonedDateTimeHugo(ZonedDateTime zonedDateTimeHugo) {
        this.zonedDateTimeHugo = zonedDateTimeHugo;
    }

    public ZonedDateTime getZonedDateTimeRequiredHugo() {
        return this.zonedDateTimeRequiredHugo;
    }

    public FieldTestInfiniteScrollEntity zonedDateTimeRequiredHugo(ZonedDateTime zonedDateTimeRequiredHugo) {
        this.setZonedDateTimeRequiredHugo(zonedDateTimeRequiredHugo);
        return this;
    }

    public void setZonedDateTimeRequiredHugo(ZonedDateTime zonedDateTimeRequiredHugo) {
        this.zonedDateTimeRequiredHugo = zonedDateTimeRequiredHugo;
    }

    public Duration getDurationHugo() {
        return this.durationHugo;
    }

    public FieldTestInfiniteScrollEntity durationHugo(Duration durationHugo) {
        this.setDurationHugo(durationHugo);
        return this;
    }

    public void setDurationHugo(Duration durationHugo) {
        this.durationHugo = durationHugo;
    }

    public Duration getDurationRequiredHugo() {
        return this.durationRequiredHugo;
    }

    public FieldTestInfiniteScrollEntity durationRequiredHugo(Duration durationRequiredHugo) {
        this.setDurationRequiredHugo(durationRequiredHugo);
        return this;
    }

    public void setDurationRequiredHugo(Duration durationRequiredHugo) {
        this.durationRequiredHugo = durationRequiredHugo;
    }

    public Boolean getBooleanHugo() {
        return this.booleanHugo;
    }

    public FieldTestInfiniteScrollEntity booleanHugo(Boolean booleanHugo) {
        this.setBooleanHugo(booleanHugo);
        return this;
    }

    public void setBooleanHugo(Boolean booleanHugo) {
        this.booleanHugo = booleanHugo;
    }

    public Boolean getBooleanRequiredHugo() {
        return this.booleanRequiredHugo;
    }

    public FieldTestInfiniteScrollEntity booleanRequiredHugo(Boolean booleanRequiredHugo) {
        this.setBooleanRequiredHugo(booleanRequiredHugo);
        return this;
    }

    public void setBooleanRequiredHugo(Boolean booleanRequiredHugo) {
        this.booleanRequiredHugo = booleanRequiredHugo;
    }

    public EnumFieldClass getEnumHugo() {
        return this.enumHugo;
    }

    public FieldTestInfiniteScrollEntity enumHugo(EnumFieldClass enumHugo) {
        this.setEnumHugo(enumHugo);
        return this;
    }

    public void setEnumHugo(EnumFieldClass enumHugo) {
        this.enumHugo = enumHugo;
    }

    public EnumRequiredFieldClass getEnumRequiredHugo() {
        return this.enumRequiredHugo;
    }

    public FieldTestInfiniteScrollEntity enumRequiredHugo(EnumRequiredFieldClass enumRequiredHugo) {
        this.setEnumRequiredHugo(enumRequiredHugo);
        return this;
    }

    public void setEnumRequiredHugo(EnumRequiredFieldClass enumRequiredHugo) {
        this.enumRequiredHugo = enumRequiredHugo;
    }

    public UUID getUuidHugo() {
        return this.uuidHugo;
    }

    public FieldTestInfiniteScrollEntity uuidHugo(UUID uuidHugo) {
        this.setUuidHugo(uuidHugo);
        return this;
    }

    public void setUuidHugo(UUID uuidHugo) {
        this.uuidHugo = uuidHugo;
    }

    public UUID getUuidRequiredHugo() {
        return this.uuidRequiredHugo;
    }

    public FieldTestInfiniteScrollEntity uuidRequiredHugo(UUID uuidRequiredHugo) {
        this.setUuidRequiredHugo(uuidRequiredHugo);
        return this;
    }

    public void setUuidRequiredHugo(UUID uuidRequiredHugo) {
        this.uuidRequiredHugo = uuidRequiredHugo;
    }

    public byte[] getByteImageHugo() {
        return this.byteImageHugo;
    }

    public FieldTestInfiniteScrollEntity byteImageHugo(byte[] byteImageHugo) {
        this.setByteImageHugo(byteImageHugo);
        return this;
    }

    public void setByteImageHugo(byte[] byteImageHugo) {
        this.byteImageHugo = byteImageHugo;
    }

    public String getByteImageHugoContentType() {
        return this.byteImageHugoContentType;
    }

    public FieldTestInfiniteScrollEntity byteImageHugoContentType(String byteImageHugoContentType) {
        this.byteImageHugoContentType = byteImageHugoContentType;
        return this;
    }

    public void setByteImageHugoContentType(String byteImageHugoContentType) {
        this.byteImageHugoContentType = byteImageHugoContentType;
    }

    public byte[] getByteImageRequiredHugo() {
        return this.byteImageRequiredHugo;
    }

    public FieldTestInfiniteScrollEntity byteImageRequiredHugo(byte[] byteImageRequiredHugo) {
        this.setByteImageRequiredHugo(byteImageRequiredHugo);
        return this;
    }

    public void setByteImageRequiredHugo(byte[] byteImageRequiredHugo) {
        this.byteImageRequiredHugo = byteImageRequiredHugo;
    }

    public String getByteImageRequiredHugoContentType() {
        return this.byteImageRequiredHugoContentType;
    }

    public FieldTestInfiniteScrollEntity byteImageRequiredHugoContentType(String byteImageRequiredHugoContentType) {
        this.byteImageRequiredHugoContentType = byteImageRequiredHugoContentType;
        return this;
    }

    public void setByteImageRequiredHugoContentType(String byteImageRequiredHugoContentType) {
        this.byteImageRequiredHugoContentType = byteImageRequiredHugoContentType;
    }

    public byte[] getByteImageMinbytesHugo() {
        return this.byteImageMinbytesHugo;
    }

    public FieldTestInfiniteScrollEntity byteImageMinbytesHugo(byte[] byteImageMinbytesHugo) {
        this.setByteImageMinbytesHugo(byteImageMinbytesHugo);
        return this;
    }

    public void setByteImageMinbytesHugo(byte[] byteImageMinbytesHugo) {
        this.byteImageMinbytesHugo = byteImageMinbytesHugo;
    }

    public String getByteImageMinbytesHugoContentType() {
        return this.byteImageMinbytesHugoContentType;
    }

    public FieldTestInfiniteScrollEntity byteImageMinbytesHugoContentType(String byteImageMinbytesHugoContentType) {
        this.byteImageMinbytesHugoContentType = byteImageMinbytesHugoContentType;
        return this;
    }

    public void setByteImageMinbytesHugoContentType(String byteImageMinbytesHugoContentType) {
        this.byteImageMinbytesHugoContentType = byteImageMinbytesHugoContentType;
    }

    public byte[] getByteImageMaxbytesHugo() {
        return this.byteImageMaxbytesHugo;
    }

    public FieldTestInfiniteScrollEntity byteImageMaxbytesHugo(byte[] byteImageMaxbytesHugo) {
        this.setByteImageMaxbytesHugo(byteImageMaxbytesHugo);
        return this;
    }

    public void setByteImageMaxbytesHugo(byte[] byteImageMaxbytesHugo) {
        this.byteImageMaxbytesHugo = byteImageMaxbytesHugo;
    }

    public String getByteImageMaxbytesHugoContentType() {
        return this.byteImageMaxbytesHugoContentType;
    }

    public FieldTestInfiniteScrollEntity byteImageMaxbytesHugoContentType(String byteImageMaxbytesHugoContentType) {
        this.byteImageMaxbytesHugoContentType = byteImageMaxbytesHugoContentType;
        return this;
    }

    public void setByteImageMaxbytesHugoContentType(String byteImageMaxbytesHugoContentType) {
        this.byteImageMaxbytesHugoContentType = byteImageMaxbytesHugoContentType;
    }

    public byte[] getByteAnyHugo() {
        return this.byteAnyHugo;
    }

    public FieldTestInfiniteScrollEntity byteAnyHugo(byte[] byteAnyHugo) {
        this.setByteAnyHugo(byteAnyHugo);
        return this;
    }

    public void setByteAnyHugo(byte[] byteAnyHugo) {
        this.byteAnyHugo = byteAnyHugo;
    }

    public String getByteAnyHugoContentType() {
        return this.byteAnyHugoContentType;
    }

    public FieldTestInfiniteScrollEntity byteAnyHugoContentType(String byteAnyHugoContentType) {
        this.byteAnyHugoContentType = byteAnyHugoContentType;
        return this;
    }

    public void setByteAnyHugoContentType(String byteAnyHugoContentType) {
        this.byteAnyHugoContentType = byteAnyHugoContentType;
    }

    public byte[] getByteAnyRequiredHugo() {
        return this.byteAnyRequiredHugo;
    }

    public FieldTestInfiniteScrollEntity byteAnyRequiredHugo(byte[] byteAnyRequiredHugo) {
        this.setByteAnyRequiredHugo(byteAnyRequiredHugo);
        return this;
    }

    public void setByteAnyRequiredHugo(byte[] byteAnyRequiredHugo) {
        this.byteAnyRequiredHugo = byteAnyRequiredHugo;
    }

    public String getByteAnyRequiredHugoContentType() {
        return this.byteAnyRequiredHugoContentType;
    }

    public FieldTestInfiniteScrollEntity byteAnyRequiredHugoContentType(String byteAnyRequiredHugoContentType) {
        this.byteAnyRequiredHugoContentType = byteAnyRequiredHugoContentType;
        return this;
    }

    public void setByteAnyRequiredHugoContentType(String byteAnyRequiredHugoContentType) {
        this.byteAnyRequiredHugoContentType = byteAnyRequiredHugoContentType;
    }

    public byte[] getByteAnyMinbytesHugo() {
        return this.byteAnyMinbytesHugo;
    }

    public FieldTestInfiniteScrollEntity byteAnyMinbytesHugo(byte[] byteAnyMinbytesHugo) {
        this.setByteAnyMinbytesHugo(byteAnyMinbytesHugo);
        return this;
    }

    public void setByteAnyMinbytesHugo(byte[] byteAnyMinbytesHugo) {
        this.byteAnyMinbytesHugo = byteAnyMinbytesHugo;
    }

    public String getByteAnyMinbytesHugoContentType() {
        return this.byteAnyMinbytesHugoContentType;
    }

    public FieldTestInfiniteScrollEntity byteAnyMinbytesHugoContentType(String byteAnyMinbytesHugoContentType) {
        this.byteAnyMinbytesHugoContentType = byteAnyMinbytesHugoContentType;
        return this;
    }

    public void setByteAnyMinbytesHugoContentType(String byteAnyMinbytesHugoContentType) {
        this.byteAnyMinbytesHugoContentType = byteAnyMinbytesHugoContentType;
    }

    public byte[] getByteAnyMaxbytesHugo() {
        return this.byteAnyMaxbytesHugo;
    }

    public FieldTestInfiniteScrollEntity byteAnyMaxbytesHugo(byte[] byteAnyMaxbytesHugo) {
        this.setByteAnyMaxbytesHugo(byteAnyMaxbytesHugo);
        return this;
    }

    public void setByteAnyMaxbytesHugo(byte[] byteAnyMaxbytesHugo) {
        this.byteAnyMaxbytesHugo = byteAnyMaxbytesHugo;
    }

    public String getByteAnyMaxbytesHugoContentType() {
        return this.byteAnyMaxbytesHugoContentType;
    }

    public FieldTestInfiniteScrollEntity byteAnyMaxbytesHugoContentType(String byteAnyMaxbytesHugoContentType) {
        this.byteAnyMaxbytesHugoContentType = byteAnyMaxbytesHugoContentType;
        return this;
    }

    public void setByteAnyMaxbytesHugoContentType(String byteAnyMaxbytesHugoContentType) {
        this.byteAnyMaxbytesHugoContentType = byteAnyMaxbytesHugoContentType;
    }

    public String getByteTextHugo() {
        return this.byteTextHugo;
    }

    public FieldTestInfiniteScrollEntity byteTextHugo(String byteTextHugo) {
        this.setByteTextHugo(byteTextHugo);
        return this;
    }

    public void setByteTextHugo(String byteTextHugo) {
        this.byteTextHugo = byteTextHugo;
    }

    public String getByteTextRequiredHugo() {
        return this.byteTextRequiredHugo;
    }

    public FieldTestInfiniteScrollEntity byteTextRequiredHugo(String byteTextRequiredHugo) {
        this.setByteTextRequiredHugo(byteTextRequiredHugo);
        return this;
    }

    public void setByteTextRequiredHugo(String byteTextRequiredHugo) {
        this.byteTextRequiredHugo = byteTextRequiredHugo;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FieldTestInfiniteScrollEntity)) {
            return false;
        }
        return id != null && id.equals(((FieldTestInfiniteScrollEntity) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FieldTestInfiniteScrollEntity{" +
            "id=" + getId() +
            ", stringHugo='" + getStringHugo() + "'" +
            ", stringRequiredHugo='" + getStringRequiredHugo() + "'" +
            ", stringMinlengthHugo='" + getStringMinlengthHugo() + "'" +
            ", stringMaxlengthHugo='" + getStringMaxlengthHugo() + "'" +
            ", stringPatternHugo='" + getStringPatternHugo() + "'" +
            ", integerHugo=" + getIntegerHugo() +
            ", integerRequiredHugo=" + getIntegerRequiredHugo() +
            ", integerMinHugo=" + getIntegerMinHugo() +
            ", integerMaxHugo=" + getIntegerMaxHugo() +
            ", longHugo=" + getLongHugo() +
            ", longRequiredHugo=" + getLongRequiredHugo() +
            ", longMinHugo=" + getLongMinHugo() +
            ", longMaxHugo=" + getLongMaxHugo() +
            ", floatHugo=" + getFloatHugo() +
            ", floatRequiredHugo=" + getFloatRequiredHugo() +
            ", floatMinHugo=" + getFloatMinHugo() +
            ", floatMaxHugo=" + getFloatMaxHugo() +
            ", doubleRequiredHugo=" + getDoubleRequiredHugo() +
            ", doubleMinHugo=" + getDoubleMinHugo() +
            ", doubleMaxHugo=" + getDoubleMaxHugo() +
            ", bigDecimalRequiredHugo=" + getBigDecimalRequiredHugo() +
            ", bigDecimalMinHugo=" + getBigDecimalMinHugo() +
            ", bigDecimalMaxHugo=" + getBigDecimalMaxHugo() +
            ", localDateHugo='" + getLocalDateHugo() + "'" +
            ", localDateRequiredHugo='" + getLocalDateRequiredHugo() + "'" +
            ", instantHugo='" + getInstantHugo() + "'" +
            ", instanteRequiredHugo='" + getInstanteRequiredHugo() + "'" +
            ", zonedDateTimeHugo='" + getZonedDateTimeHugo() + "'" +
            ", zonedDateTimeRequiredHugo='" + getZonedDateTimeRequiredHugo() + "'" +
            ", durationHugo='" + getDurationHugo() + "'" +
            ", durationRequiredHugo='" + getDurationRequiredHugo() + "'" +
            ", booleanHugo='" + getBooleanHugo() + "'" +
            ", booleanRequiredHugo='" + getBooleanRequiredHugo() + "'" +
            ", enumHugo='" + getEnumHugo() + "'" +
            ", enumRequiredHugo='" + getEnumRequiredHugo() + "'" +
            ", uuidHugo='" + getUuidHugo() + "'" +
            ", uuidRequiredHugo='" + getUuidRequiredHugo() + "'" +
            ", byteImageHugo='" + getByteImageHugo() + "'" +
            ", byteImageHugoContentType='" + getByteImageHugoContentType() + "'" +
            ", byteImageRequiredHugo='" + getByteImageRequiredHugo() + "'" +
            ", byteImageRequiredHugoContentType='" + getByteImageRequiredHugoContentType() + "'" +
            ", byteImageMinbytesHugo='" + getByteImageMinbytesHugo() + "'" +
            ", byteImageMinbytesHugoContentType='" + getByteImageMinbytesHugoContentType() + "'" +
            ", byteImageMaxbytesHugo='" + getByteImageMaxbytesHugo() + "'" +
            ", byteImageMaxbytesHugoContentType='" + getByteImageMaxbytesHugoContentType() + "'" +
            ", byteAnyHugo='" + getByteAnyHugo() + "'" +
            ", byteAnyHugoContentType='" + getByteAnyHugoContentType() + "'" +
            ", byteAnyRequiredHugo='" + getByteAnyRequiredHugo() + "'" +
            ", byteAnyRequiredHugoContentType='" + getByteAnyRequiredHugoContentType() + "'" +
            ", byteAnyMinbytesHugo='" + getByteAnyMinbytesHugo() + "'" +
            ", byteAnyMinbytesHugoContentType='" + getByteAnyMinbytesHugoContentType() + "'" +
            ", byteAnyMaxbytesHugo='" + getByteAnyMaxbytesHugo() + "'" +
            ", byteAnyMaxbytesHugoContentType='" + getByteAnyMaxbytesHugoContentType() + "'" +
            ", byteTextHugo='" + getByteTextHugo() + "'" +
            ", byteTextRequiredHugo='" + getByteTextRequiredHugo() + "'" +
            "}";
    }
}
