package tech.jhipster.sample.repository.rowmapper;

import io.r2dbc.spi.Row;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;
import tech.jhipster.sample.domain.EntityWithServiceImplAndPagination;
import tech.jhipster.sample.service.ColumnConverter;

/**
 * Converter between {@link Row} to {@link EntityWithServiceImplAndPagination}, with proper type conversions.
 */
@Service
public class EntityWithServiceImplAndPaginationRowMapper implements BiFunction<Row, String, EntityWithServiceImplAndPagination> {

    private final ColumnConverter converter;

    public EntityWithServiceImplAndPaginationRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link EntityWithServiceImplAndPagination} stored in the database.
     */
    @Override
    public EntityWithServiceImplAndPagination apply(Row row, String prefix) {
        EntityWithServiceImplAndPagination entity = new EntityWithServiceImplAndPagination();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setHugo(converter.fromRow(row, prefix + "_hugo", String.class));
        return entity;
    }
}
