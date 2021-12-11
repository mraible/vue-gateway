package tech.jhipster.sample.repository.rowmapper;

import io.r2dbc.spi.Row;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;
import tech.jhipster.sample.domain.FieldTestServiceClassAndJpaFilteringEntity;
import tech.jhipster.sample.domain.enumeration.EnumFieldClass;
import tech.jhipster.sample.domain.enumeration.EnumRequiredFieldClass;
import tech.jhipster.sample.service.ColumnConverter;

/**
 * Converter between {@link Row} to {@link FieldTestServiceClassAndJpaFilteringEntity}, with proper type conversions.
 */
@Service
public class FieldTestServiceClassAndJpaFilteringEntityRowMapper
    implements BiFunction<Row, String, FieldTestServiceClassAndJpaFilteringEntity> {

    private final ColumnConverter converter;

    public FieldTestServiceClassAndJpaFilteringEntityRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link FieldTestServiceClassAndJpaFilteringEntity} stored in the database.
     */
    @Override
    public FieldTestServiceClassAndJpaFilteringEntity apply(Row row, String prefix) {
        FieldTestServiceClassAndJpaFilteringEntity entity = new FieldTestServiceClassAndJpaFilteringEntity();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setStringBob(converter.fromRow(row, prefix + "_string_bob", String.class));
        entity.setStringRequiredBob(converter.fromRow(row, prefix + "_string_required_bob", String.class));
        entity.setStringMinlengthBob(converter.fromRow(row, prefix + "_string_minlength_bob", String.class));
        entity.setStringMaxlengthBob(converter.fromRow(row, prefix + "_string_maxlength_bob", String.class));
        entity.setStringPatternBob(converter.fromRow(row, prefix + "_string_pattern_bob", String.class));
        entity.setIntegerBob(converter.fromRow(row, prefix + "_integer_bob", Integer.class));
        entity.setIntegerRequiredBob(converter.fromRow(row, prefix + "_integer_required_bob", Integer.class));
        entity.setIntegerMinBob(converter.fromRow(row, prefix + "_integer_min_bob", Integer.class));
        entity.setIntegerMaxBob(converter.fromRow(row, prefix + "_integer_max_bob", Integer.class));
        entity.setLongBob(converter.fromRow(row, prefix + "_long_bob", Long.class));
        entity.setLongRequiredBob(converter.fromRow(row, prefix + "_long_required_bob", Long.class));
        entity.setLongMinBob(converter.fromRow(row, prefix + "_long_min_bob", Long.class));
        entity.setLongMaxBob(converter.fromRow(row, prefix + "_long_max_bob", Long.class));
        entity.setFloatBob(converter.fromRow(row, prefix + "_float_bob", Float.class));
        entity.setFloatRequiredBob(converter.fromRow(row, prefix + "_float_required_bob", Float.class));
        entity.setFloatMinBob(converter.fromRow(row, prefix + "_float_min_bob", Float.class));
        entity.setFloatMaxBob(converter.fromRow(row, prefix + "_float_max_bob", Float.class));
        entity.setDoubleRequiredBob(converter.fromRow(row, prefix + "_double_required_bob", Double.class));
        entity.setDoubleMinBob(converter.fromRow(row, prefix + "_double_min_bob", Double.class));
        entity.setDoubleMaxBob(converter.fromRow(row, prefix + "_double_max_bob", Double.class));
        entity.setBigDecimalRequiredBob(converter.fromRow(row, prefix + "_big_decimal_required_bob", BigDecimal.class));
        entity.setBigDecimalMinBob(converter.fromRow(row, prefix + "_big_decimal_min_bob", BigDecimal.class));
        entity.setBigDecimalMaxBob(converter.fromRow(row, prefix + "_big_decimal_max_bob", BigDecimal.class));
        entity.setLocalDateBob(converter.fromRow(row, prefix + "_local_date_bob", LocalDate.class));
        entity.setLocalDateRequiredBob(converter.fromRow(row, prefix + "_local_date_required_bob", LocalDate.class));
        entity.setInstantBob(converter.fromRow(row, prefix + "_instant_bob", Instant.class));
        entity.setInstanteRequiredBob(converter.fromRow(row, prefix + "_instante_required_bob", Instant.class));
        entity.setZonedDateTimeBob(converter.fromRow(row, prefix + "_zoned_date_time_bob", ZonedDateTime.class));
        entity.setZonedDateTimeRequiredBob(converter.fromRow(row, prefix + "_zoned_date_time_required_bob", ZonedDateTime.class));
        entity.setDurationBob(converter.fromRow(row, prefix + "_duration_bob", Duration.class));
        entity.setDurationRequiredBob(converter.fromRow(row, prefix + "_duration_required_bob", Duration.class));
        entity.setBooleanBob(converter.fromRow(row, prefix + "_boolean_bob", Boolean.class));
        entity.setBooleanRequiredBob(converter.fromRow(row, prefix + "_boolean_required_bob", Boolean.class));
        entity.setEnumBob(converter.fromRow(row, prefix + "_enum_bob", EnumFieldClass.class));
        entity.setEnumRequiredBob(converter.fromRow(row, prefix + "_enum_required_bob", EnumRequiredFieldClass.class));
        entity.setUuidBob(converter.fromRow(row, prefix + "_uuid_bob", UUID.class));
        entity.setUuidRequiredBob(converter.fromRow(row, prefix + "_uuid_required_bob", UUID.class));
        entity.setByteImageBobContentType(converter.fromRow(row, prefix + "_byte_image_bob_content_type", String.class));
        entity.setByteImageBob(converter.fromRow(row, prefix + "_byte_image_bob", byte[].class));
        entity.setByteImageRequiredBobContentType(converter.fromRow(row, prefix + "_byte_image_required_bob_content_type", String.class));
        entity.setByteImageRequiredBob(converter.fromRow(row, prefix + "_byte_image_required_bob", byte[].class));
        entity.setByteImageMinbytesBobContentType(converter.fromRow(row, prefix + "_byte_image_minbytes_bob_content_type", String.class));
        entity.setByteImageMinbytesBob(converter.fromRow(row, prefix + "_byte_image_minbytes_bob", byte[].class));
        entity.setByteImageMaxbytesBobContentType(converter.fromRow(row, prefix + "_byte_image_maxbytes_bob_content_type", String.class));
        entity.setByteImageMaxbytesBob(converter.fromRow(row, prefix + "_byte_image_maxbytes_bob", byte[].class));
        entity.setByteAnyBobContentType(converter.fromRow(row, prefix + "_byte_any_bob_content_type", String.class));
        entity.setByteAnyBob(converter.fromRow(row, prefix + "_byte_any_bob", byte[].class));
        entity.setByteAnyRequiredBobContentType(converter.fromRow(row, prefix + "_byte_any_required_bob_content_type", String.class));
        entity.setByteAnyRequiredBob(converter.fromRow(row, prefix + "_byte_any_required_bob", byte[].class));
        entity.setByteAnyMinbytesBobContentType(converter.fromRow(row, prefix + "_byte_any_minbytes_bob_content_type", String.class));
        entity.setByteAnyMinbytesBob(converter.fromRow(row, prefix + "_byte_any_minbytes_bob", byte[].class));
        entity.setByteAnyMaxbytesBobContentType(converter.fromRow(row, prefix + "_byte_any_maxbytes_bob_content_type", String.class));
        entity.setByteAnyMaxbytesBob(converter.fromRow(row, prefix + "_byte_any_maxbytes_bob", byte[].class));
        entity.setByteTextBob(converter.fromRow(row, prefix + "_byte_text_bob", String.class));
        entity.setByteTextRequiredBob(converter.fromRow(row, prefix + "_byte_text_required_bob", String.class));
        return entity;
    }
}
