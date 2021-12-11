package tech.jhipster.sample.repository.rowmapper;

import io.r2dbc.spi.Row;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;
import tech.jhipster.sample.domain.EntityWithPaginationAndDTO;
import tech.jhipster.sample.service.ColumnConverter;

/**
 * Converter between {@link Row} to {@link EntityWithPaginationAndDTO}, with proper type conversions.
 */
@Service
public class EntityWithPaginationAndDTORowMapper implements BiFunction<Row, String, EntityWithPaginationAndDTO> {

    private final ColumnConverter converter;

    public EntityWithPaginationAndDTORowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link EntityWithPaginationAndDTO} stored in the database.
     */
    @Override
    public EntityWithPaginationAndDTO apply(Row row, String prefix) {
        EntityWithPaginationAndDTO entity = new EntityWithPaginationAndDTO();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setLea(converter.fromRow(row, prefix + "_lea", String.class));
        return entity;
    }
}
