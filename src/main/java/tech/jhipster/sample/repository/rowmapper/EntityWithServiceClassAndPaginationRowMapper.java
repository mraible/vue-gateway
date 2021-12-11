package tech.jhipster.sample.repository.rowmapper;

import io.r2dbc.spi.Row;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;
import tech.jhipster.sample.domain.EntityWithServiceClassAndPagination;
import tech.jhipster.sample.service.ColumnConverter;

/**
 * Converter between {@link Row} to {@link EntityWithServiceClassAndPagination}, with proper type conversions.
 */
@Service
public class EntityWithServiceClassAndPaginationRowMapper implements BiFunction<Row, String, EntityWithServiceClassAndPagination> {

    private final ColumnConverter converter;

    public EntityWithServiceClassAndPaginationRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link EntityWithServiceClassAndPagination} stored in the database.
     */
    @Override
    public EntityWithServiceClassAndPagination apply(Row row, String prefix) {
        EntityWithServiceClassAndPagination entity = new EntityWithServiceClassAndPagination();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setEnzo(converter.fromRow(row, prefix + "_enzo", String.class));
        return entity;
    }
}
