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
import tech.jhipster.sample.domain.FieldTestEntity;
import tech.jhipster.sample.domain.enumeration.EnumFieldClass;
import tech.jhipster.sample.domain.enumeration.EnumRequiredFieldClass;
import tech.jhipster.sample.service.ColumnConverter;

/**
 * Converter between {@link Row} to {@link FieldTestEntity}, with proper type conversions.
 */
@Service
public class FieldTestEntityRowMapper implements BiFunction<Row, String, FieldTestEntity> {

    private final ColumnConverter converter;

    public FieldTestEntityRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link FieldTestEntity} stored in the database.
     */
    @Override
    public FieldTestEntity apply(Row row, String prefix) {
        FieldTestEntity entity = new FieldTestEntity();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setStringTom(converter.fromRow(row, prefix + "_string_tom", String.class));
        entity.setStringRequiredTom(converter.fromRow(row, prefix + "_string_required_tom", String.class));
        entity.setStringMinlengthTom(converter.fromRow(row, prefix + "_string_minlength_tom", String.class));
        entity.setStringMaxlengthTom(converter.fromRow(row, prefix + "_string_maxlength_tom", String.class));
        entity.setStringPatternTom(converter.fromRow(row, prefix + "_string_pattern_tom", String.class));
        entity.setNumberPatternTom(converter.fromRow(row, prefix + "_number_pattern_tom", String.class));
        entity.setNumberPatternRequiredTom(converter.fromRow(row, prefix + "_number_pattern_required_tom", String.class));
        entity.setIntegerTom(converter.fromRow(row, prefix + "_integer_tom", Integer.class));
        entity.setIntegerRequiredTom(converter.fromRow(row, prefix + "_integer_required_tom", Integer.class));
        entity.setIntegerMinTom(converter.fromRow(row, prefix + "_integer_min_tom", Integer.class));
        entity.setIntegerMaxTom(converter.fromRow(row, prefix + "_integer_max_tom", Integer.class));
        entity.setLongTom(converter.fromRow(row, prefix + "_long_tom", Long.class));
        entity.setLongRequiredTom(converter.fromRow(row, prefix + "_long_required_tom", Long.class));
        entity.setLongMinTom(converter.fromRow(row, prefix + "_long_min_tom", Long.class));
        entity.setLongMaxTom(converter.fromRow(row, prefix + "_long_max_tom", Long.class));
        entity.setFloatTom(converter.fromRow(row, prefix + "_float_tom", Float.class));
        entity.setFloatRequiredTom(converter.fromRow(row, prefix + "_float_required_tom", Float.class));
        entity.setFloatMinTom(converter.fromRow(row, prefix + "_float_min_tom", Float.class));
        entity.setFloatMaxTom(converter.fromRow(row, prefix + "_float_max_tom", Float.class));
        entity.setDoubleRequiredTom(converter.fromRow(row, prefix + "_double_required_tom", Double.class));
        entity.setDoubleMinTom(converter.fromRow(row, prefix + "_double_min_tom", Double.class));
        entity.setDoubleMaxTom(converter.fromRow(row, prefix + "_double_max_tom", Double.class));
        entity.setBigDecimalRequiredTom(converter.fromRow(row, prefix + "_big_decimal_required_tom", BigDecimal.class));
        entity.setBigDecimalMinTom(converter.fromRow(row, prefix + "_big_decimal_min_tom", BigDecimal.class));
        entity.setBigDecimalMaxTom(converter.fromRow(row, prefix + "_big_decimal_max_tom", BigDecimal.class));
        entity.setLocalDateTom(converter.fromRow(row, prefix + "_local_date_tom", LocalDate.class));
        entity.setLocalDateRequiredTom(converter.fromRow(row, prefix + "_local_date_required_tom", LocalDate.class));
        entity.setInstantTom(converter.fromRow(row, prefix + "_instant_tom", Instant.class));
        entity.setInstantRequiredTom(converter.fromRow(row, prefix + "_instant_required_tom", Instant.class));
        entity.setZonedDateTimeTom(converter.fromRow(row, prefix + "_zoned_date_time_tom", ZonedDateTime.class));
        entity.setZonedDateTimeRequiredTom(converter.fromRow(row, prefix + "_zoned_date_time_required_tom", ZonedDateTime.class));
        entity.setDurationTom(converter.fromRow(row, prefix + "_duration_tom", Duration.class));
        entity.setDurationRequiredTom(converter.fromRow(row, prefix + "_duration_required_tom", Duration.class));
        entity.setBooleanTom(converter.fromRow(row, prefix + "_boolean_tom", Boolean.class));
        entity.setBooleanRequiredTom(converter.fromRow(row, prefix + "_boolean_required_tom", Boolean.class));
        entity.setEnumTom(converter.fromRow(row, prefix + "_enum_tom", EnumFieldClass.class));
        entity.setEnumRequiredTom(converter.fromRow(row, prefix + "_enum_required_tom", EnumRequiredFieldClass.class));
        entity.setUuidTom(converter.fromRow(row, prefix + "_uuid_tom", UUID.class));
        entity.setUuidRequiredTom(converter.fromRow(row, prefix + "_uuid_required_tom", UUID.class));
        entity.setByteImageTomContentType(converter.fromRow(row, prefix + "_byte_image_tom_content_type", String.class));
        entity.setByteImageTom(converter.fromRow(row, prefix + "_byte_image_tom", byte[].class));
        entity.setByteImageRequiredTomContentType(converter.fromRow(row, prefix + "_byte_image_required_tom_content_type", String.class));
        entity.setByteImageRequiredTom(converter.fromRow(row, prefix + "_byte_image_required_tom", byte[].class));
        entity.setByteImageMinbytesTomContentType(converter.fromRow(row, prefix + "_byte_image_minbytes_tom_content_type", String.class));
        entity.setByteImageMinbytesTom(converter.fromRow(row, prefix + "_byte_image_minbytes_tom", byte[].class));
        entity.setByteImageMaxbytesTomContentType(converter.fromRow(row, prefix + "_byte_image_maxbytes_tom_content_type", String.class));
        entity.setByteImageMaxbytesTom(converter.fromRow(row, prefix + "_byte_image_maxbytes_tom", byte[].class));
        entity.setByteAnyTomContentType(converter.fromRow(row, prefix + "_byte_any_tom_content_type", String.class));
        entity.setByteAnyTom(converter.fromRow(row, prefix + "_byte_any_tom", byte[].class));
        entity.setByteAnyRequiredTomContentType(converter.fromRow(row, prefix + "_byte_any_required_tom_content_type", String.class));
        entity.setByteAnyRequiredTom(converter.fromRow(row, prefix + "_byte_any_required_tom", byte[].class));
        entity.setByteAnyMinbytesTomContentType(converter.fromRow(row, prefix + "_byte_any_minbytes_tom_content_type", String.class));
        entity.setByteAnyMinbytesTom(converter.fromRow(row, prefix + "_byte_any_minbytes_tom", byte[].class));
        entity.setByteAnyMaxbytesTomContentType(converter.fromRow(row, prefix + "_byte_any_maxbytes_tom_content_type", String.class));
        entity.setByteAnyMaxbytesTom(converter.fromRow(row, prefix + "_byte_any_maxbytes_tom", byte[].class));
        entity.setByteTextTom(converter.fromRow(row, prefix + "_byte_text_tom", String.class));
        entity.setByteTextRequiredTom(converter.fromRow(row, prefix + "_byte_text_required_tom", String.class));
        return entity;
    }
}
