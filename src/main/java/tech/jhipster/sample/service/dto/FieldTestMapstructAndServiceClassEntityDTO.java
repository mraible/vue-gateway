package tech.jhipster.sample.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Lob;
import javax.validation.constraints.*;
import tech.jhipster.sample.domain.enumeration.EnumFieldClass;
import tech.jhipster.sample.domain.enumeration.EnumRequiredFieldClass;

/**
 * A DTO for the {@link tech.jhipster.sample.domain.FieldTestMapstructAndServiceClassEntity} entity.
 */
public class FieldTestMapstructAndServiceClassEntityDTO implements Serializable {

    private Long id;

    private String stringEva;

    @NotNull(message = "must not be null")
    private String stringRequiredEva;

    @Size(min = 0)
    private String stringMinlengthEva;

    @Size(max = 20)
    private String stringMaxlengthEva;

    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String stringPatternEva;

    private Integer integerEva;

    @NotNull(message = "must not be null")
    private Integer integerRequiredEva;

    @Min(value = 0)
    private Integer integerMinEva;

    @Max(value = 100)
    private Integer integerMaxEva;

    private Long longEva;

    @NotNull(message = "must not be null")
    private Long longRequiredEva;

    @Min(value = 0L)
    private Long longMinEva;

    @Max(value = 100L)
    private Long longMaxEva;

    private Float floatEva;

    @NotNull(message = "must not be null")
    private Float floatRequiredEva;

    @DecimalMin(value = "0")
    private Float floatMinEva;

    @DecimalMax(value = "100")
    private Float floatMaxEva;

    @NotNull(message = "must not be null")
    private Double doubleRequiredEva;

    @DecimalMin(value = "0")
    private Double doubleMinEva;

    @DecimalMax(value = "100")
    private Double doubleMaxEva;

    @NotNull(message = "must not be null")
    private BigDecimal bigDecimalRequiredEva;

    @DecimalMin(value = "0")
    private BigDecimal bigDecimalMinEva;

    @DecimalMax(value = "100")
    private BigDecimal bigDecimalMaxEva;

    private LocalDate localDateEva;

    @NotNull(message = "must not be null")
    private LocalDate localDateRequiredEva;

    private Instant instantEva;

    @NotNull(message = "must not be null")
    private Instant instanteRequiredEva;

    private ZonedDateTime zonedDateTimeEva;

    @NotNull(message = "must not be null")
    private ZonedDateTime zonedDateTimeRequiredEva;

    private Duration durationEva;

    @NotNull(message = "must not be null")
    private Duration durationRequiredEva;

    private Boolean booleanEva;

    @NotNull(message = "must not be null")
    private Boolean booleanRequiredEva;

    private EnumFieldClass enumEva;

    @NotNull(message = "must not be null")
    private EnumRequiredFieldClass enumRequiredEva;

    private UUID uuidEva;

    @NotNull(message = "must not be null")
    private UUID uuidRequiredEva;

    @Lob
    private byte[] byteImageEva;

    private String byteImageEvaContentType;

    @Lob
    private byte[] byteImageRequiredEva;

    private String byteImageRequiredEvaContentType;

    @Lob
    private byte[] byteImageMinbytesEva;

    private String byteImageMinbytesEvaContentType;

    @Lob
    private byte[] byteImageMaxbytesEva;

    private String byteImageMaxbytesEvaContentType;

    @Lob
    private byte[] byteAnyEva;

    private String byteAnyEvaContentType;

    @Lob
    private byte[] byteAnyRequiredEva;

    private String byteAnyRequiredEvaContentType;

    @Lob
    private byte[] byteAnyMinbytesEva;

    private String byteAnyMinbytesEvaContentType;

    @Lob
    private byte[] byteAnyMaxbytesEva;

    private String byteAnyMaxbytesEvaContentType;

    @Lob
    private String byteTextEva;

    @Lob
    private String byteTextRequiredEva;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStringEva() {
        return stringEva;
    }

    public void setStringEva(String stringEva) {
        this.stringEva = stringEva;
    }

    public String getStringRequiredEva() {
        return stringRequiredEva;
    }

    public void setStringRequiredEva(String stringRequiredEva) {
        this.stringRequiredEva = stringRequiredEva;
    }

    public String getStringMinlengthEva() {
        return stringMinlengthEva;
    }

    public void setStringMinlengthEva(String stringMinlengthEva) {
        this.stringMinlengthEva = stringMinlengthEva;
    }

    public String getStringMaxlengthEva() {
        return stringMaxlengthEva;
    }

    public void setStringMaxlengthEva(String stringMaxlengthEva) {
        this.stringMaxlengthEva = stringMaxlengthEva;
    }

    public String getStringPatternEva() {
        return stringPatternEva;
    }

    public void setStringPatternEva(String stringPatternEva) {
        this.stringPatternEva = stringPatternEva;
    }

    public Integer getIntegerEva() {
        return integerEva;
    }

    public void setIntegerEva(Integer integerEva) {
        this.integerEva = integerEva;
    }

    public Integer getIntegerRequiredEva() {
        return integerRequiredEva;
    }

    public void setIntegerRequiredEva(Integer integerRequiredEva) {
        this.integerRequiredEva = integerRequiredEva;
    }

    public Integer getIntegerMinEva() {
        return integerMinEva;
    }

    public void setIntegerMinEva(Integer integerMinEva) {
        this.integerMinEva = integerMinEva;
    }

    public Integer getIntegerMaxEva() {
        return integerMaxEva;
    }

    public void setIntegerMaxEva(Integer integerMaxEva) {
        this.integerMaxEva = integerMaxEva;
    }

    public Long getLongEva() {
        return longEva;
    }

    public void setLongEva(Long longEva) {
        this.longEva = longEva;
    }

    public Long getLongRequiredEva() {
        return longRequiredEva;
    }

    public void setLongRequiredEva(Long longRequiredEva) {
        this.longRequiredEva = longRequiredEva;
    }

    public Long getLongMinEva() {
        return longMinEva;
    }

    public void setLongMinEva(Long longMinEva) {
        this.longMinEva = longMinEva;
    }

    public Long getLongMaxEva() {
        return longMaxEva;
    }

    public void setLongMaxEva(Long longMaxEva) {
        this.longMaxEva = longMaxEva;
    }

    public Float getFloatEva() {
        return floatEva;
    }

    public void setFloatEva(Float floatEva) {
        this.floatEva = floatEva;
    }

    public Float getFloatRequiredEva() {
        return floatRequiredEva;
    }

    public void setFloatRequiredEva(Float floatRequiredEva) {
        this.floatRequiredEva = floatRequiredEva;
    }

    public Float getFloatMinEva() {
        return floatMinEva;
    }

    public void setFloatMinEva(Float floatMinEva) {
        this.floatMinEva = floatMinEva;
    }

    public Float getFloatMaxEva() {
        return floatMaxEva;
    }

    public void setFloatMaxEva(Float floatMaxEva) {
        this.floatMaxEva = floatMaxEva;
    }

    public Double getDoubleRequiredEva() {
        return doubleRequiredEva;
    }

    public void setDoubleRequiredEva(Double doubleRequiredEva) {
        this.doubleRequiredEva = doubleRequiredEva;
    }

    public Double getDoubleMinEva() {
        return doubleMinEva;
    }

    public void setDoubleMinEva(Double doubleMinEva) {
        this.doubleMinEva = doubleMinEva;
    }

    public Double getDoubleMaxEva() {
        return doubleMaxEva;
    }

    public void setDoubleMaxEva(Double doubleMaxEva) {
        this.doubleMaxEva = doubleMaxEva;
    }

    public BigDecimal getBigDecimalRequiredEva() {
        return bigDecimalRequiredEva;
    }

    public void setBigDecimalRequiredEva(BigDecimal bigDecimalRequiredEva) {
        this.bigDecimalRequiredEva = bigDecimalRequiredEva;
    }

    public BigDecimal getBigDecimalMinEva() {
        return bigDecimalMinEva;
    }

    public void setBigDecimalMinEva(BigDecimal bigDecimalMinEva) {
        this.bigDecimalMinEva = bigDecimalMinEva;
    }

    public BigDecimal getBigDecimalMaxEva() {
        return bigDecimalMaxEva;
    }

    public void setBigDecimalMaxEva(BigDecimal bigDecimalMaxEva) {
        this.bigDecimalMaxEva = bigDecimalMaxEva;
    }

    public LocalDate getLocalDateEva() {
        return localDateEva;
    }

    public void setLocalDateEva(LocalDate localDateEva) {
        this.localDateEva = localDateEva;
    }

    public LocalDate getLocalDateRequiredEva() {
        return localDateRequiredEva;
    }

    public void setLocalDateRequiredEva(LocalDate localDateRequiredEva) {
        this.localDateRequiredEva = localDateRequiredEva;
    }

    public Instant getInstantEva() {
        return instantEva;
    }

    public void setInstantEva(Instant instantEva) {
        this.instantEva = instantEva;
    }

    public Instant getInstanteRequiredEva() {
        return instanteRequiredEva;
    }

    public void setInstanteRequiredEva(Instant instanteRequiredEva) {
        this.instanteRequiredEva = instanteRequiredEva;
    }

    public ZonedDateTime getZonedDateTimeEva() {
        return zonedDateTimeEva;
    }

    public void setZonedDateTimeEva(ZonedDateTime zonedDateTimeEva) {
        this.zonedDateTimeEva = zonedDateTimeEva;
    }

    public ZonedDateTime getZonedDateTimeRequiredEva() {
        return zonedDateTimeRequiredEva;
    }

    public void setZonedDateTimeRequiredEva(ZonedDateTime zonedDateTimeRequiredEva) {
        this.zonedDateTimeRequiredEva = zonedDateTimeRequiredEva;
    }

    public Duration getDurationEva() {
        return durationEva;
    }

    public void setDurationEva(Duration durationEva) {
        this.durationEva = durationEva;
    }

    public Duration getDurationRequiredEva() {
        return durationRequiredEva;
    }

    public void setDurationRequiredEva(Duration durationRequiredEva) {
        this.durationRequiredEva = durationRequiredEva;
    }

    public Boolean getBooleanEva() {
        return booleanEva;
    }

    public void setBooleanEva(Boolean booleanEva) {
        this.booleanEva = booleanEva;
    }

    public Boolean getBooleanRequiredEva() {
        return booleanRequiredEva;
    }

    public void setBooleanRequiredEva(Boolean booleanRequiredEva) {
        this.booleanRequiredEva = booleanRequiredEva;
    }

    public EnumFieldClass getEnumEva() {
        return enumEva;
    }

    public void setEnumEva(EnumFieldClass enumEva) {
        this.enumEva = enumEva;
    }

    public EnumRequiredFieldClass getEnumRequiredEva() {
        return enumRequiredEva;
    }

    public void setEnumRequiredEva(EnumRequiredFieldClass enumRequiredEva) {
        this.enumRequiredEva = enumRequiredEva;
    }

    public UUID getUuidEva() {
        return uuidEva;
    }

    public void setUuidEva(UUID uuidEva) {
        this.uuidEva = uuidEva;
    }

    public UUID getUuidRequiredEva() {
        return uuidRequiredEva;
    }

    public void setUuidRequiredEva(UUID uuidRequiredEva) {
        this.uuidRequiredEva = uuidRequiredEva;
    }

    public byte[] getByteImageEva() {
        return byteImageEva;
    }

    public void setByteImageEva(byte[] byteImageEva) {
        this.byteImageEva = byteImageEva;
    }

    public String getByteImageEvaContentType() {
        return byteImageEvaContentType;
    }

    public void setByteImageEvaContentType(String byteImageEvaContentType) {
        this.byteImageEvaContentType = byteImageEvaContentType;
    }

    public byte[] getByteImageRequiredEva() {
        return byteImageRequiredEva;
    }

    public void setByteImageRequiredEva(byte[] byteImageRequiredEva) {
        this.byteImageRequiredEva = byteImageRequiredEva;
    }

    public String getByteImageRequiredEvaContentType() {
        return byteImageRequiredEvaContentType;
    }

    public void setByteImageRequiredEvaContentType(String byteImageRequiredEvaContentType) {
        this.byteImageRequiredEvaContentType = byteImageRequiredEvaContentType;
    }

    public byte[] getByteImageMinbytesEva() {
        return byteImageMinbytesEva;
    }

    public void setByteImageMinbytesEva(byte[] byteImageMinbytesEva) {
        this.byteImageMinbytesEva = byteImageMinbytesEva;
    }

    public String getByteImageMinbytesEvaContentType() {
        return byteImageMinbytesEvaContentType;
    }

    public void setByteImageMinbytesEvaContentType(String byteImageMinbytesEvaContentType) {
        this.byteImageMinbytesEvaContentType = byteImageMinbytesEvaContentType;
    }

    public byte[] getByteImageMaxbytesEva() {
        return byteImageMaxbytesEva;
    }

    public void setByteImageMaxbytesEva(byte[] byteImageMaxbytesEva) {
        this.byteImageMaxbytesEva = byteImageMaxbytesEva;
    }

    public String getByteImageMaxbytesEvaContentType() {
        return byteImageMaxbytesEvaContentType;
    }

    public void setByteImageMaxbytesEvaContentType(String byteImageMaxbytesEvaContentType) {
        this.byteImageMaxbytesEvaContentType = byteImageMaxbytesEvaContentType;
    }

    public byte[] getByteAnyEva() {
        return byteAnyEva;
    }

    public void setByteAnyEva(byte[] byteAnyEva) {
        this.byteAnyEva = byteAnyEva;
    }

    public String getByteAnyEvaContentType() {
        return byteAnyEvaContentType;
    }

    public void setByteAnyEvaContentType(String byteAnyEvaContentType) {
        this.byteAnyEvaContentType = byteAnyEvaContentType;
    }

    public byte[] getByteAnyRequiredEva() {
        return byteAnyRequiredEva;
    }

    public void setByteAnyRequiredEva(byte[] byteAnyRequiredEva) {
        this.byteAnyRequiredEva = byteAnyRequiredEva;
    }

    public String getByteAnyRequiredEvaContentType() {
        return byteAnyRequiredEvaContentType;
    }

    public void setByteAnyRequiredEvaContentType(String byteAnyRequiredEvaContentType) {
        this.byteAnyRequiredEvaContentType = byteAnyRequiredEvaContentType;
    }

    public byte[] getByteAnyMinbytesEva() {
        return byteAnyMinbytesEva;
    }

    public void setByteAnyMinbytesEva(byte[] byteAnyMinbytesEva) {
        this.byteAnyMinbytesEva = byteAnyMinbytesEva;
    }

    public String getByteAnyMinbytesEvaContentType() {
        return byteAnyMinbytesEvaContentType;
    }

    public void setByteAnyMinbytesEvaContentType(String byteAnyMinbytesEvaContentType) {
        this.byteAnyMinbytesEvaContentType = byteAnyMinbytesEvaContentType;
    }

    public byte[] getByteAnyMaxbytesEva() {
        return byteAnyMaxbytesEva;
    }

    public void setByteAnyMaxbytesEva(byte[] byteAnyMaxbytesEva) {
        this.byteAnyMaxbytesEva = byteAnyMaxbytesEva;
    }

    public String getByteAnyMaxbytesEvaContentType() {
        return byteAnyMaxbytesEvaContentType;
    }

    public void setByteAnyMaxbytesEvaContentType(String byteAnyMaxbytesEvaContentType) {
        this.byteAnyMaxbytesEvaContentType = byteAnyMaxbytesEvaContentType;
    }

    public String getByteTextEva() {
        return byteTextEva;
    }

    public void setByteTextEva(String byteTextEva) {
        this.byteTextEva = byteTextEva;
    }

    public String getByteTextRequiredEva() {
        return byteTextRequiredEva;
    }

    public void setByteTextRequiredEva(String byteTextRequiredEva) {
        this.byteTextRequiredEva = byteTextRequiredEva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FieldTestMapstructAndServiceClassEntityDTO)) {
            return false;
        }

        FieldTestMapstructAndServiceClassEntityDTO fieldTestMapstructAndServiceClassEntityDTO = (FieldTestMapstructAndServiceClassEntityDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, fieldTestMapstructAndServiceClassEntityDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FieldTestMapstructAndServiceClassEntityDTO{" +
            "id=" + getId() +
            ", stringEva='" + getStringEva() + "'" +
            ", stringRequiredEva='" + getStringRequiredEva() + "'" +
            ", stringMinlengthEva='" + getStringMinlengthEva() + "'" +
            ", stringMaxlengthEva='" + getStringMaxlengthEva() + "'" +
            ", stringPatternEva='" + getStringPatternEva() + "'" +
            ", integerEva=" + getIntegerEva() +
            ", integerRequiredEva=" + getIntegerRequiredEva() +
            ", integerMinEva=" + getIntegerMinEva() +
            ", integerMaxEva=" + getIntegerMaxEva() +
            ", longEva=" + getLongEva() +
            ", longRequiredEva=" + getLongRequiredEva() +
            ", longMinEva=" + getLongMinEva() +
            ", longMaxEva=" + getLongMaxEva() +
            ", floatEva=" + getFloatEva() +
            ", floatRequiredEva=" + getFloatRequiredEva() +
            ", floatMinEva=" + getFloatMinEva() +
            ", floatMaxEva=" + getFloatMaxEva() +
            ", doubleRequiredEva=" + getDoubleRequiredEva() +
            ", doubleMinEva=" + getDoubleMinEva() +
            ", doubleMaxEva=" + getDoubleMaxEva() +
            ", bigDecimalRequiredEva=" + getBigDecimalRequiredEva() +
            ", bigDecimalMinEva=" + getBigDecimalMinEva() +
            ", bigDecimalMaxEva=" + getBigDecimalMaxEva() +
            ", localDateEva='" + getLocalDateEva() + "'" +
            ", localDateRequiredEva='" + getLocalDateRequiredEva() + "'" +
            ", instantEva='" + getInstantEva() + "'" +
            ", instanteRequiredEva='" + getInstanteRequiredEva() + "'" +
            ", zonedDateTimeEva='" + getZonedDateTimeEva() + "'" +
            ", zonedDateTimeRequiredEva='" + getZonedDateTimeRequiredEva() + "'" +
            ", durationEva='" + getDurationEva() + "'" +
            ", durationRequiredEva='" + getDurationRequiredEva() + "'" +
            ", booleanEva='" + getBooleanEva() + "'" +
            ", booleanRequiredEva='" + getBooleanRequiredEva() + "'" +
            ", enumEva='" + getEnumEva() + "'" +
            ", enumRequiredEva='" + getEnumRequiredEva() + "'" +
            ", uuidEva='" + getUuidEva() + "'" +
            ", uuidRequiredEva='" + getUuidRequiredEva() + "'" +
            ", byteImageEva='" + getByteImageEva() + "'" +
            ", byteImageRequiredEva='" + getByteImageRequiredEva() + "'" +
            ", byteImageMinbytesEva='" + getByteImageMinbytesEva() + "'" +
            ", byteImageMaxbytesEva='" + getByteImageMaxbytesEva() + "'" +
            ", byteAnyEva='" + getByteAnyEva() + "'" +
            ", byteAnyRequiredEva='" + getByteAnyRequiredEva() + "'" +
            ", byteAnyMinbytesEva='" + getByteAnyMinbytesEva() + "'" +
            ", byteAnyMaxbytesEva='" + getByteAnyMaxbytesEva() + "'" +
            ", byteTextEva='" + getByteTextEva() + "'" +
            ", byteTextRequiredEva='" + getByteTextRequiredEva() + "'" +
            "}";
    }
}
