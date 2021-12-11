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
import tech.jhipster.sample.domain.FieldTestPaginationEntity;
import tech.jhipster.sample.domain.enumeration.EnumFieldClass;
import tech.jhipster.sample.domain.enumeration.EnumRequiredFieldClass;
import tech.jhipster.sample.service.ColumnConverter;

/**
 * Converter between {@link Row} to {@link FieldTestPaginationEntity}, with proper type conversions.
 */
@Service
public class FieldTestPaginationEntityRowMapper implements BiFunction<Row, String, FieldTestPaginationEntity> {

    private final ColumnConverter converter;

    public FieldTestPaginationEntityRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link FieldTestPaginationEntity} stored in the database.
     */
    @Override
    public FieldTestPaginationEntity apply(Row row, String prefix) {
        FieldTestPaginationEntity entity = new FieldTestPaginationEntity();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setStringAlice(converter.fromRow(row, prefix + "_string_alice", String.class));
        entity.setStringRequiredAlice(converter.fromRow(row, prefix + "_string_required_alice", String.class));
        entity.setStringMinlengthAlice(converter.fromRow(row, prefix + "_string_minlength_alice", String.class));
        entity.setStringMaxlengthAlice(converter.fromRow(row, prefix + "_string_maxlength_alice", String.class));
        entity.setStringPatternAlice(converter.fromRow(row, prefix + "_string_pattern_alice", String.class));
        entity.setIntegerAlice(converter.fromRow(row, prefix + "_integer_alice", Integer.class));
        entity.setIntegerRequiredAlice(converter.fromRow(row, prefix + "_integer_required_alice", Integer.class));
        entity.setIntegerMinAlice(converter.fromRow(row, prefix + "_integer_min_alice", Integer.class));
        entity.setIntegerMaxAlice(converter.fromRow(row, prefix + "_integer_max_alice", Integer.class));
        entity.setLongAlice(converter.fromRow(row, prefix + "_long_alice", Long.class));
        entity.setLongRequiredAlice(converter.fromRow(row, prefix + "_long_required_alice", Long.class));
        entity.setLongMinAlice(converter.fromRow(row, prefix + "_long_min_alice", Long.class));
        entity.setLongMaxAlice(converter.fromRow(row, prefix + "_long_max_alice", Long.class));
        entity.setFloatAlice(converter.fromRow(row, prefix + "_float_alice", Float.class));
        entity.setFloatRequiredAlice(converter.fromRow(row, prefix + "_float_required_alice", Float.class));
        entity.setFloatMinAlice(converter.fromRow(row, prefix + "_float_min_alice", Float.class));
        entity.setFloatMaxAlice(converter.fromRow(row, prefix + "_float_max_alice", Float.class));
        entity.setDoubleRequiredAlice(converter.fromRow(row, prefix + "_double_required_alice", Double.class));
        entity.setDoubleMinAlice(converter.fromRow(row, prefix + "_double_min_alice", Double.class));
        entity.setDoubleMaxAlice(converter.fromRow(row, prefix + "_double_max_alice", Double.class));
        entity.setBigDecimalRequiredAlice(converter.fromRow(row, prefix + "_big_decimal_required_alice", BigDecimal.class));
        entity.setBigDecimalMinAlice(converter.fromRow(row, prefix + "_big_decimal_min_alice", BigDecimal.class));
        entity.setBigDecimalMaxAlice(converter.fromRow(row, prefix + "_big_decimal_max_alice", BigDecimal.class));
        entity.setLocalDateAlice(converter.fromRow(row, prefix + "_local_date_alice", LocalDate.class));
        entity.setLocalDateRequiredAlice(converter.fromRow(row, prefix + "_local_date_required_alice", LocalDate.class));
        entity.setInstantAlice(converter.fromRow(row, prefix + "_instant_alice", Instant.class));
        entity.setInstanteRequiredAlice(converter.fromRow(row, prefix + "_instante_required_alice", Instant.class));
        entity.setZonedDateTimeAlice(converter.fromRow(row, prefix + "_zoned_date_time_alice", ZonedDateTime.class));
        entity.setZonedDateTimeRequiredAlice(converter.fromRow(row, prefix + "_zoned_date_time_required_alice", ZonedDateTime.class));
        entity.setDurationAlice(converter.fromRow(row, prefix + "_duration_alice", Duration.class));
        entity.setDurationRequiredAlice(converter.fromRow(row, prefix + "_duration_required_alice", Duration.class));
        entity.setBooleanAlice(converter.fromRow(row, prefix + "_boolean_alice", Boolean.class));
        entity.setBooleanRequiredAlice(converter.fromRow(row, prefix + "_boolean_required_alice", Boolean.class));
        entity.setEnumAlice(converter.fromRow(row, prefix + "_enum_alice", EnumFieldClass.class));
        entity.setEnumRequiredAlice(converter.fromRow(row, prefix + "_enum_required_alice", EnumRequiredFieldClass.class));
        entity.setUuidAlice(converter.fromRow(row, prefix + "_uuid_alice", UUID.class));
        entity.setUuidRequiredAlice(converter.fromRow(row, prefix + "_uuid_required_alice", UUID.class));
        entity.setByteImageAliceContentType(converter.fromRow(row, prefix + "_byte_image_alice_content_type", String.class));
        entity.setByteImageAlice(converter.fromRow(row, prefix + "_byte_image_alice", byte[].class));
        entity.setByteImageRequiredAliceContentType(
            converter.fromRow(row, prefix + "_byte_image_required_alice_content_type", String.class)
        );
        entity.setByteImageRequiredAlice(converter.fromRow(row, prefix + "_byte_image_required_alice", byte[].class));
        entity.setByteImageMinbytesAliceContentType(
            converter.fromRow(row, prefix + "_byte_image_minbytes_alice_content_type", String.class)
        );
        entity.setByteImageMinbytesAlice(converter.fromRow(row, prefix + "_byte_image_minbytes_alice", byte[].class));
        entity.setByteImageMaxbytesAliceContentType(
            converter.fromRow(row, prefix + "_byte_image_maxbytes_alice_content_type", String.class)
        );
        entity.setByteImageMaxbytesAlice(converter.fromRow(row, prefix + "_byte_image_maxbytes_alice", byte[].class));
        entity.setByteAnyAliceContentType(converter.fromRow(row, prefix + "_byte_any_alice_content_type", String.class));
        entity.setByteAnyAlice(converter.fromRow(row, prefix + "_byte_any_alice", byte[].class));
        entity.setByteAnyRequiredAliceContentType(converter.fromRow(row, prefix + "_byte_any_required_alice_content_type", String.class));
        entity.setByteAnyRequiredAlice(converter.fromRow(row, prefix + "_byte_any_required_alice", byte[].class));
        entity.setByteAnyMinbytesAliceContentType(converter.fromRow(row, prefix + "_byte_any_minbytes_alice_content_type", String.class));
        entity.setByteAnyMinbytesAlice(converter.fromRow(row, prefix + "_byte_any_minbytes_alice", byte[].class));
        entity.setByteAnyMaxbytesAliceContentType(converter.fromRow(row, prefix + "_byte_any_maxbytes_alice_content_type", String.class));
        entity.setByteAnyMaxbytesAlice(converter.fromRow(row, prefix + "_byte_any_maxbytes_alice", byte[].class));
        entity.setByteTextAlice(converter.fromRow(row, prefix + "_byte_text_alice", String.class));
        entity.setByteTextRequiredAlice(converter.fromRow(row, prefix + "_byte_text_required_alice", String.class));
        return entity;
    }
}
