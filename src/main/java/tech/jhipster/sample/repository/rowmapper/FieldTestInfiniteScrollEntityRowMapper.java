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
import tech.jhipster.sample.domain.FieldTestInfiniteScrollEntity;
import tech.jhipster.sample.domain.enumeration.EnumFieldClass;
import tech.jhipster.sample.domain.enumeration.EnumRequiredFieldClass;
import tech.jhipster.sample.service.ColumnConverter;

/**
 * Converter between {@link Row} to {@link FieldTestInfiniteScrollEntity}, with proper type conversions.
 */
@Service
public class FieldTestInfiniteScrollEntityRowMapper implements BiFunction<Row, String, FieldTestInfiniteScrollEntity> {

    private final ColumnConverter converter;

    public FieldTestInfiniteScrollEntityRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link FieldTestInfiniteScrollEntity} stored in the database.
     */
    @Override
    public FieldTestInfiniteScrollEntity apply(Row row, String prefix) {
        FieldTestInfiniteScrollEntity entity = new FieldTestInfiniteScrollEntity();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setStringHugo(converter.fromRow(row, prefix + "_string_hugo", String.class));
        entity.setStringRequiredHugo(converter.fromRow(row, prefix + "_string_required_hugo", String.class));
        entity.setStringMinlengthHugo(converter.fromRow(row, prefix + "_string_minlength_hugo", String.class));
        entity.setStringMaxlengthHugo(converter.fromRow(row, prefix + "_string_maxlength_hugo", String.class));
        entity.setStringPatternHugo(converter.fromRow(row, prefix + "_string_pattern_hugo", String.class));
        entity.setIntegerHugo(converter.fromRow(row, prefix + "_integer_hugo", Integer.class));
        entity.setIntegerRequiredHugo(converter.fromRow(row, prefix + "_integer_required_hugo", Integer.class));
        entity.setIntegerMinHugo(converter.fromRow(row, prefix + "_integer_min_hugo", Integer.class));
        entity.setIntegerMaxHugo(converter.fromRow(row, prefix + "_integer_max_hugo", Integer.class));
        entity.setLongHugo(converter.fromRow(row, prefix + "_long_hugo", Long.class));
        entity.setLongRequiredHugo(converter.fromRow(row, prefix + "_long_required_hugo", Long.class));
        entity.setLongMinHugo(converter.fromRow(row, prefix + "_long_min_hugo", Long.class));
        entity.setLongMaxHugo(converter.fromRow(row, prefix + "_long_max_hugo", Long.class));
        entity.setFloatHugo(converter.fromRow(row, prefix + "_float_hugo", Float.class));
        entity.setFloatRequiredHugo(converter.fromRow(row, prefix + "_float_required_hugo", Float.class));
        entity.setFloatMinHugo(converter.fromRow(row, prefix + "_float_min_hugo", Float.class));
        entity.setFloatMaxHugo(converter.fromRow(row, prefix + "_float_max_hugo", Float.class));
        entity.setDoubleRequiredHugo(converter.fromRow(row, prefix + "_double_required_hugo", Double.class));
        entity.setDoubleMinHugo(converter.fromRow(row, prefix + "_double_min_hugo", Double.class));
        entity.setDoubleMaxHugo(converter.fromRow(row, prefix + "_double_max_hugo", Double.class));
        entity.setBigDecimalRequiredHugo(converter.fromRow(row, prefix + "_big_decimal_required_hugo", BigDecimal.class));
        entity.setBigDecimalMinHugo(converter.fromRow(row, prefix + "_big_decimal_min_hugo", BigDecimal.class));
        entity.setBigDecimalMaxHugo(converter.fromRow(row, prefix + "_big_decimal_max_hugo", BigDecimal.class));
        entity.setLocalDateHugo(converter.fromRow(row, prefix + "_local_date_hugo", LocalDate.class));
        entity.setLocalDateRequiredHugo(converter.fromRow(row, prefix + "_local_date_required_hugo", LocalDate.class));
        entity.setInstantHugo(converter.fromRow(row, prefix + "_instant_hugo", Instant.class));
        entity.setInstanteRequiredHugo(converter.fromRow(row, prefix + "_instante_required_hugo", Instant.class));
        entity.setZonedDateTimeHugo(converter.fromRow(row, prefix + "_zoned_date_time_hugo", ZonedDateTime.class));
        entity.setZonedDateTimeRequiredHugo(converter.fromRow(row, prefix + "_zoned_date_time_required_hugo", ZonedDateTime.class));
        entity.setDurationHugo(converter.fromRow(row, prefix + "_duration_hugo", Duration.class));
        entity.setDurationRequiredHugo(converter.fromRow(row, prefix + "_duration_required_hugo", Duration.class));
        entity.setBooleanHugo(converter.fromRow(row, prefix + "_boolean_hugo", Boolean.class));
        entity.setBooleanRequiredHugo(converter.fromRow(row, prefix + "_boolean_required_hugo", Boolean.class));
        entity.setEnumHugo(converter.fromRow(row, prefix + "_enum_hugo", EnumFieldClass.class));
        entity.setEnumRequiredHugo(converter.fromRow(row, prefix + "_enum_required_hugo", EnumRequiredFieldClass.class));
        entity.setUuidHugo(converter.fromRow(row, prefix + "_uuid_hugo", UUID.class));
        entity.setUuidRequiredHugo(converter.fromRow(row, prefix + "_uuid_required_hugo", UUID.class));
        entity.setByteImageHugoContentType(converter.fromRow(row, prefix + "_byte_image_hugo_content_type", String.class));
        entity.setByteImageHugo(converter.fromRow(row, prefix + "_byte_image_hugo", byte[].class));
        entity.setByteImageRequiredHugoContentType(converter.fromRow(row, prefix + "_byte_image_required_hugo_content_type", String.class));
        entity.setByteImageRequiredHugo(converter.fromRow(row, prefix + "_byte_image_required_hugo", byte[].class));
        entity.setByteImageMinbytesHugoContentType(converter.fromRow(row, prefix + "_byte_image_minbytes_hugo_content_type", String.class));
        entity.setByteImageMinbytesHugo(converter.fromRow(row, prefix + "_byte_image_minbytes_hugo", byte[].class));
        entity.setByteImageMaxbytesHugoContentType(converter.fromRow(row, prefix + "_byte_image_maxbytes_hugo_content_type", String.class));
        entity.setByteImageMaxbytesHugo(converter.fromRow(row, prefix + "_byte_image_maxbytes_hugo", byte[].class));
        entity.setByteAnyHugoContentType(converter.fromRow(row, prefix + "_byte_any_hugo_content_type", String.class));
        entity.setByteAnyHugo(converter.fromRow(row, prefix + "_byte_any_hugo", byte[].class));
        entity.setByteAnyRequiredHugoContentType(converter.fromRow(row, prefix + "_byte_any_required_hugo_content_type", String.class));
        entity.setByteAnyRequiredHugo(converter.fromRow(row, prefix + "_byte_any_required_hugo", byte[].class));
        entity.setByteAnyMinbytesHugoContentType(converter.fromRow(row, prefix + "_byte_any_minbytes_hugo_content_type", String.class));
        entity.setByteAnyMinbytesHugo(converter.fromRow(row, prefix + "_byte_any_minbytes_hugo", byte[].class));
        entity.setByteAnyMaxbytesHugoContentType(converter.fromRow(row, prefix + "_byte_any_maxbytes_hugo_content_type", String.class));
        entity.setByteAnyMaxbytesHugo(converter.fromRow(row, prefix + "_byte_any_maxbytes_hugo", byte[].class));
        entity.setByteTextHugo(converter.fromRow(row, prefix + "_byte_text_hugo", String.class));
        entity.setByteTextRequiredHugo(converter.fromRow(row, prefix + "_byte_text_required_hugo", String.class));
        return entity;
    }
}
