package tech.jhipster.sample.repository.rowmapper;

import io.r2dbc.spi.Row;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;
import tech.jhipster.sample.domain.BankAccount;
import tech.jhipster.sample.domain.enumeration.BankAccountType;
import tech.jhipster.sample.service.ColumnConverter;

/**
 * Converter between {@link Row} to {@link BankAccount}, with proper type conversions.
 */
@Service
public class BankAccountRowMapper implements BiFunction<Row, String, BankAccount> {

    private final ColumnConverter converter;

    public BankAccountRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link BankAccount} stored in the database.
     */
    @Override
    public BankAccount apply(Row row, String prefix) {
        BankAccount entity = new BankAccount();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setName(converter.fromRow(row, prefix + "_name", String.class));
        entity.setGuid(converter.fromRow(row, prefix + "_guid", UUID.class));
        entity.setBankNumber(converter.fromRow(row, prefix + "_bank_number", Integer.class));
        entity.setAgencyNumber(converter.fromRow(row, prefix + "_agency_number", Long.class));
        entity.setLastOperationDuration(converter.fromRow(row, prefix + "_last_operation_duration", Float.class));
        entity.setMeanOperationDuration(converter.fromRow(row, prefix + "_mean_operation_duration", Double.class));
        entity.setMeanQueueDuration(converter.fromRow(row, prefix + "_mean_queue_duration", Duration.class));
        entity.setBalance(converter.fromRow(row, prefix + "_balance", BigDecimal.class));
        entity.setOpeningDay(converter.fromRow(row, prefix + "_opening_day", LocalDate.class));
        entity.setLastOperationDate(converter.fromRow(row, prefix + "_last_operation_date", Instant.class));
        entity.setActive(converter.fromRow(row, prefix + "_active", Boolean.class));
        entity.setAccountType(converter.fromRow(row, prefix + "_account_type", BankAccountType.class));
        entity.setAttachmentContentType(converter.fromRow(row, prefix + "_attachment_content_type", String.class));
        entity.setAttachment(converter.fromRow(row, prefix + "_attachment", byte[].class));
        entity.setDescription(converter.fromRow(row, prefix + "_description", String.class));
        entity.setUserId(converter.fromRow(row, prefix + "_user_id", Long.class));
        return entity;
    }
}
