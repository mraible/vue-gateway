package tech.jhipster.sample.repository.rowmapper;

import io.r2dbc.spi.Row;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;
import tech.jhipster.sample.domain.Operation;
import tech.jhipster.sample.service.ColumnConverter;

/**
 * Converter between {@link Row} to {@link Operation}, with proper type conversions.
 */
@Service
public class OperationRowMapper implements BiFunction<Row, String, Operation> {

    private final ColumnConverter converter;

    public OperationRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link Operation} stored in the database.
     */
    @Override
    public Operation apply(Row row, String prefix) {
        Operation entity = new Operation();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setDate(converter.fromRow(row, prefix + "_date", Instant.class));
        entity.setDescription(converter.fromRow(row, prefix + "_description", String.class));
        entity.setAmount(converter.fromRow(row, prefix + "_amount", BigDecimal.class));
        entity.setBankAccountId(converter.fromRow(row, prefix + "_bank_account_id", Long.class));
        return entity;
    }
}
