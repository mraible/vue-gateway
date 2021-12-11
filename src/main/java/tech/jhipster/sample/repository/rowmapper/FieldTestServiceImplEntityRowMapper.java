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
import tech.jhipster.sample.domain.FieldTestServiceImplEntity;
import tech.jhipster.sample.domain.enumeration.EnumFieldClass;
import tech.jhipster.sample.domain.enumeration.EnumRequiredFieldClass;
import tech.jhipster.sample.service.ColumnConverter;

/**
 * Converter between {@link Row} to {@link FieldTestServiceImplEntity}, with proper type conversions.
 */
@Service
public class FieldTestServiceImplEntityRowMapper implements BiFunction<Row, String, FieldTestServiceImplEntity> {

    private final ColumnConverter converter;

    public FieldTestServiceImplEntityRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link FieldTestServiceImplEntity} stored in the database.
     */
    @Override
    public FieldTestServiceImplEntity apply(Row row, String prefix) {
        FieldTestServiceImplEntity entity = new FieldTestServiceImplEntity();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setStringMika(converter.fromRow(row, prefix + "_string_mika", String.class));
        entity.setStringRequiredMika(converter.fromRow(row, prefix + "_string_required_mika", String.class));
        entity.setStringMinlengthMika(converter.fromRow(row, prefix + "_string_minlength_mika", String.class));
        entity.setStringMaxlengthMika(converter.fromRow(row, prefix + "_string_maxlength_mika", String.class));
        entity.setStringPatternMika(converter.fromRow(row, prefix + "_string_pattern_mika", String.class));
        entity.setIntegerMika(converter.fromRow(row, prefix + "_integer_mika", Integer.class));
        entity.setIntegerRequiredMika(converter.fromRow(row, prefix + "_integer_required_mika", Integer.class));
        entity.setIntegerMinMika(converter.fromRow(row, prefix + "_integer_min_mika", Integer.class));
        entity.setIntegerMaxMika(converter.fromRow(row, prefix + "_integer_max_mika", Integer.class));
        entity.setLongMika(converter.fromRow(row, prefix + "_long_mika", Long.class));
        entity.setLongRequiredMika(converter.fromRow(row, prefix + "_long_required_mika", Long.class));
        entity.setLongMinMika(converter.fromRow(row, prefix + "_long_min_mika", Long.class));
        entity.setLongMaxMika(converter.fromRow(row, prefix + "_long_max_mika", Long.class));
        entity.setFloatMika(converter.fromRow(row, prefix + "_float_mika", Float.class));
        entity.setFloatRequiredMika(converter.fromRow(row, prefix + "_float_required_mika", Float.class));
        entity.setFloatMinMika(converter.fromRow(row, prefix + "_float_min_mika", Float.class));
        entity.setFloatMaxMika(converter.fromRow(row, prefix + "_float_max_mika", Float.class));
        entity.setDoubleRequiredMika(converter.fromRow(row, prefix + "_double_required_mika", Double.class));
        entity.setDoubleMinMika(converter.fromRow(row, prefix + "_double_min_mika", Double.class));
        entity.setDoubleMaxMika(converter.fromRow(row, prefix + "_double_max_mika", Double.class));
        entity.setBigDecimalRequiredMika(converter.fromRow(row, prefix + "_big_decimal_required_mika", BigDecimal.class));
        entity.setBigDecimalMinMika(converter.fromRow(row, prefix + "_big_decimal_min_mika", BigDecimal.class));
        entity.setBigDecimalMaxMika(converter.fromRow(row, prefix + "_big_decimal_max_mika", BigDecimal.class));
        entity.setLocalDateMika(converter.fromRow(row, prefix + "_local_date_mika", LocalDate.class));
        entity.setLocalDateRequiredMika(converter.fromRow(row, prefix + "_local_date_required_mika", LocalDate.class));
        entity.setInstantMika(converter.fromRow(row, prefix + "_instant_mika", Instant.class));
        entity.setInstanteRequiredMika(converter.fromRow(row, prefix + "_instante_required_mika", Instant.class));
        entity.setZonedDateTimeMika(converter.fromRow(row, prefix + "_zoned_date_time_mika", ZonedDateTime.class));
        entity.setZonedDateTimeRequiredMika(converter.fromRow(row, prefix + "_zoned_date_time_required_mika", ZonedDateTime.class));
        entity.setDurationMika(converter.fromRow(row, prefix + "_duration_mika", Duration.class));
        entity.setDurationRequiredMika(converter.fromRow(row, prefix + "_duration_required_mika", Duration.class));
        entity.setBooleanMika(converter.fromRow(row, prefix + "_boolean_mika", Boolean.class));
        entity.setBooleanRequiredMika(converter.fromRow(row, prefix + "_boolean_required_mika", Boolean.class));
        entity.setEnumMika(converter.fromRow(row, prefix + "_enum_mika", EnumFieldClass.class));
        entity.setEnumRequiredMika(converter.fromRow(row, prefix + "_enum_required_mika", EnumRequiredFieldClass.class));
        entity.setUuidMika(converter.fromRow(row, prefix + "_uuid_mika", UUID.class));
        entity.setUuidRequiredMika(converter.fromRow(row, prefix + "_uuid_required_mika", UUID.class));
        entity.setByteImageMikaContentType(converter.fromRow(row, prefix + "_byte_image_mika_content_type", String.class));
        entity.setByteImageMika(converter.fromRow(row, prefix + "_byte_image_mika", byte[].class));
        entity.setByteImageRequiredMikaContentType(converter.fromRow(row, prefix + "_byte_image_required_mika_content_type", String.class));
        entity.setByteImageRequiredMika(converter.fromRow(row, prefix + "_byte_image_required_mika", byte[].class));
        entity.setByteImageMinbytesMikaContentType(converter.fromRow(row, prefix + "_byte_image_minbytes_mika_content_type", String.class));
        entity.setByteImageMinbytesMika(converter.fromRow(row, prefix + "_byte_image_minbytes_mika", byte[].class));
        entity.setByteImageMaxbytesMikaContentType(converter.fromRow(row, prefix + "_byte_image_maxbytes_mika_content_type", String.class));
        entity.setByteImageMaxbytesMika(converter.fromRow(row, prefix + "_byte_image_maxbytes_mika", byte[].class));
        entity.setByteAnyMikaContentType(converter.fromRow(row, prefix + "_byte_any_mika_content_type", String.class));
        entity.setByteAnyMika(converter.fromRow(row, prefix + "_byte_any_mika", byte[].class));
        entity.setByteAnyRequiredMikaContentType(converter.fromRow(row, prefix + "_byte_any_required_mika_content_type", String.class));
        entity.setByteAnyRequiredMika(converter.fromRow(row, prefix + "_byte_any_required_mika", byte[].class));
        entity.setByteAnyMinbytesMikaContentType(converter.fromRow(row, prefix + "_byte_any_minbytes_mika_content_type", String.class));
        entity.setByteAnyMinbytesMika(converter.fromRow(row, prefix + "_byte_any_minbytes_mika", byte[].class));
        entity.setByteAnyMaxbytesMikaContentType(converter.fromRow(row, prefix + "_byte_any_maxbytes_mika_content_type", String.class));
        entity.setByteAnyMaxbytesMika(converter.fromRow(row, prefix + "_byte_any_maxbytes_mika", byte[].class));
        entity.setByteTextMika(converter.fromRow(row, prefix + "_byte_text_mika", String.class));
        entity.setByteTextRequiredMika(converter.fromRow(row, prefix + "_byte_text_required_mika", String.class));
        return entity;
    }
}
