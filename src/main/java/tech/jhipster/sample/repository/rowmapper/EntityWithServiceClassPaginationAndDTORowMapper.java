package tech.jhipster.sample.repository.rowmapper;

import io.r2dbc.spi.Row;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;
import tech.jhipster.sample.domain.EntityWithServiceClassPaginationAndDTO;
import tech.jhipster.sample.service.ColumnConverter;

/**
 * Converter between {@link Row} to {@link EntityWithServiceClassPaginationAndDTO}, with proper type conversions.
 */
@Service
public class EntityWithServiceClassPaginationAndDTORowMapper implements BiFunction<Row, String, EntityWithServiceClassPaginationAndDTO> {

    private final ColumnConverter converter;

    public EntityWithServiceClassPaginationAndDTORowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link EntityWithServiceClassPaginationAndDTO} stored in the database.
     */
    @Override
    public EntityWithServiceClassPaginationAndDTO apply(Row row, String prefix) {
        EntityWithServiceClassPaginationAndDTO entity = new EntityWithServiceClassPaginationAndDTO();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setLena(converter.fromRow(row, prefix + "_lena", String.class));
        return entity;
    }
}
