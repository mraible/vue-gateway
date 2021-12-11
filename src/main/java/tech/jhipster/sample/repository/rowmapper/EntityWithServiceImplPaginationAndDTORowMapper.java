package tech.jhipster.sample.repository.rowmapper;

import io.r2dbc.spi.Row;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;
import tech.jhipster.sample.domain.EntityWithServiceImplPaginationAndDTO;
import tech.jhipster.sample.service.ColumnConverter;

/**
 * Converter between {@link Row} to {@link EntityWithServiceImplPaginationAndDTO}, with proper type conversions.
 */
@Service
public class EntityWithServiceImplPaginationAndDTORowMapper implements BiFunction<Row, String, EntityWithServiceImplPaginationAndDTO> {

    private final ColumnConverter converter;

    public EntityWithServiceImplPaginationAndDTORowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link EntityWithServiceImplPaginationAndDTO} stored in the database.
     */
    @Override
    public EntityWithServiceImplPaginationAndDTO apply(Row row, String prefix) {
        EntityWithServiceImplPaginationAndDTO entity = new EntityWithServiceImplPaginationAndDTO();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setTheo(converter.fromRow(row, prefix + "_theo", String.class));
        return entity;
    }
}
