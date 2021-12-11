package tech.jhipster.sample.repository.rowmapper;

import io.r2dbc.spi.Row;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;
import tech.jhipster.sample.domain.EntityWithServiceImplAndDTO;
import tech.jhipster.sample.service.ColumnConverter;

/**
 * Converter between {@link Row} to {@link EntityWithServiceImplAndDTO}, with proper type conversions.
 */
@Service
public class EntityWithServiceImplAndDTORowMapper implements BiFunction<Row, String, EntityWithServiceImplAndDTO> {

    private final ColumnConverter converter;

    public EntityWithServiceImplAndDTORowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link EntityWithServiceImplAndDTO} stored in the database.
     */
    @Override
    public EntityWithServiceImplAndDTO apply(Row row, String prefix) {
        EntityWithServiceImplAndDTO entity = new EntityWithServiceImplAndDTO();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setLouis(converter.fromRow(row, prefix + "_louis", String.class));
        return entity;
    }
}
