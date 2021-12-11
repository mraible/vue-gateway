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
import tech.jhipster.sample.domain.FieldTestMapstructAndServiceClassEntity;
import tech.jhipster.sample.domain.enumeration.EnumFieldClass;
import tech.jhipster.sample.domain.enumeration.EnumRequiredFieldClass;
import tech.jhipster.sample.service.ColumnConverter;

/**
 * Converter between {@link Row} to {@link FieldTestMapstructAndServiceClassEntity}, with proper type conversions.
 */
@Service
public class FieldTestMapstructAndServiceClassEntityRowMapper implements BiFunction<Row, String, FieldTestMapstructAndServiceClassEntity> {

    private final ColumnConverter converter;

    public FieldTestMapstructAndServiceClassEntityRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link FieldTestMapstructAndServiceClassEntity} stored in the database.
     */
    @Override
    public FieldTestMapstructAndServiceClassEntity apply(Row row, String prefix) {
        FieldTestMapstructAndServiceClassEntity entity = new FieldTestMapstructAndServiceClassEntity();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setStringEva(converter.fromRow(row, prefix + "_string_eva", String.class));
        entity.setStringRequiredEva(converter.fromRow(row, prefix + "_string_required_eva", String.class));
        entity.setStringMinlengthEva(converter.fromRow(row, prefix + "_string_minlength_eva", String.class));
        entity.setStringMaxlengthEva(converter.fromRow(row, prefix + "_string_maxlength_eva", String.class));
        entity.setStringPatternEva(converter.fromRow(row, prefix + "_string_pattern_eva", String.class));
        entity.setIntegerEva(converter.fromRow(row, prefix + "_integer_eva", Integer.class));
        entity.setIntegerRequiredEva(converter.fromRow(row, prefix + "_integer_required_eva", Integer.class));
        entity.setIntegerMinEva(converter.fromRow(row, prefix + "_integer_min_eva", Integer.class));
        entity.setIntegerMaxEva(converter.fromRow(row, prefix + "_integer_max_eva", Integer.class));
        entity.setLongEva(converter.fromRow(row, prefix + "_long_eva", Long.class));
        entity.setLongRequiredEva(converter.fromRow(row, prefix + "_long_required_eva", Long.class));
        entity.setLongMinEva(converter.fromRow(row, prefix + "_long_min_eva", Long.class));
        entity.setLongMaxEva(converter.fromRow(row, prefix + "_long_max_eva", Long.class));
        entity.setFloatEva(converter.fromRow(row, prefix + "_float_eva", Float.class));
        entity.setFloatRequiredEva(converter.fromRow(row, prefix + "_float_required_eva", Float.class));
        entity.setFloatMinEva(converter.fromRow(row, prefix + "_float_min_eva", Float.class));
        entity.setFloatMaxEva(converter.fromRow(row, prefix + "_float_max_eva", Float.class));
        entity.setDoubleRequiredEva(converter.fromRow(row, prefix + "_double_required_eva", Double.class));
        entity.setDoubleMinEva(converter.fromRow(row, prefix + "_double_min_eva", Double.class));
        entity.setDoubleMaxEva(converter.fromRow(row, prefix + "_double_max_eva", Double.class));
        entity.setBigDecimalRequiredEva(converter.fromRow(row, prefix + "_big_decimal_required_eva", BigDecimal.class));
        entity.setBigDecimalMinEva(converter.fromRow(row, prefix + "_big_decimal_min_eva", BigDecimal.class));
        entity.setBigDecimalMaxEva(converter.fromRow(row, prefix + "_big_decimal_max_eva", BigDecimal.class));
        entity.setLocalDateEva(converter.fromRow(row, prefix + "_local_date_eva", LocalDate.class));
        entity.setLocalDateRequiredEva(converter.fromRow(row, prefix + "_local_date_required_eva", LocalDate.class));
        entity.setInstantEva(converter.fromRow(row, prefix + "_instant_eva", Instant.class));
        entity.setInstanteRequiredEva(converter.fromRow(row, prefix + "_instante_required_eva", Instant.class));
        entity.setZonedDateTimeEva(converter.fromRow(row, prefix + "_zoned_date_time_eva", ZonedDateTime.class));
        entity.setZonedDateTimeRequiredEva(converter.fromRow(row, prefix + "_zoned_date_time_required_eva", ZonedDateTime.class));
        entity.setDurationEva(converter.fromRow(row, prefix + "_duration_eva", Duration.class));
        entity.setDurationRequiredEva(converter.fromRow(row, prefix + "_duration_required_eva", Duration.class));
        entity.setBooleanEva(converter.fromRow(row, prefix + "_boolean_eva", Boolean.class));
        entity.setBooleanRequiredEva(converter.fromRow(row, prefix + "_boolean_required_eva", Boolean.class));
        entity.setEnumEva(converter.fromRow(row, prefix + "_enum_eva", EnumFieldClass.class));
        entity.setEnumRequiredEva(converter.fromRow(row, prefix + "_enum_required_eva", EnumRequiredFieldClass.class));
        entity.setUuidEva(converter.fromRow(row, prefix + "_uuid_eva", UUID.class));
        entity.setUuidRequiredEva(converter.fromRow(row, prefix + "_uuid_required_eva", UUID.class));
        entity.setByteImageEvaContentType(converter.fromRow(row, prefix + "_byte_image_eva_content_type", String.class));
        entity.setByteImageEva(converter.fromRow(row, prefix + "_byte_image_eva", byte[].class));
        entity.setByteImageRequiredEvaContentType(converter.fromRow(row, prefix + "_byte_image_required_eva_content_type", String.class));
        entity.setByteImageRequiredEva(converter.fromRow(row, prefix + "_byte_image_required_eva", byte[].class));
        entity.setByteImageMinbytesEvaContentType(converter.fromRow(row, prefix + "_byte_image_minbytes_eva_content_type", String.class));
        entity.setByteImageMinbytesEva(converter.fromRow(row, prefix + "_byte_image_minbytes_eva", byte[].class));
        entity.setByteImageMaxbytesEvaContentType(converter.fromRow(row, prefix + "_byte_image_maxbytes_eva_content_type", String.class));
        entity.setByteImageMaxbytesEva(converter.fromRow(row, prefix + "_byte_image_maxbytes_eva", byte[].class));
        entity.setByteAnyEvaContentType(converter.fromRow(row, prefix + "_byte_any_eva_content_type", String.class));
        entity.setByteAnyEva(converter.fromRow(row, prefix + "_byte_any_eva", byte[].class));
        entity.setByteAnyRequiredEvaContentType(converter.fromRow(row, prefix + "_byte_any_required_eva_content_type", String.class));
        entity.setByteAnyRequiredEva(converter.fromRow(row, prefix + "_byte_any_required_eva", byte[].class));
        entity.setByteAnyMinbytesEvaContentType(converter.fromRow(row, prefix + "_byte_any_minbytes_eva_content_type", String.class));
        entity.setByteAnyMinbytesEva(converter.fromRow(row, prefix + "_byte_any_minbytes_eva", byte[].class));
        entity.setByteAnyMaxbytesEvaContentType(converter.fromRow(row, prefix + "_byte_any_maxbytes_eva_content_type", String.class));
        entity.setByteAnyMaxbytesEva(converter.fromRow(row, prefix + "_byte_any_maxbytes_eva", byte[].class));
        entity.setByteTextEva(converter.fromRow(row, prefix + "_byte_text_eva", String.class));
        entity.setByteTextRequiredEva(converter.fromRow(row, prefix + "_byte_text_required_eva", String.class));
        return entity;
    }
}
