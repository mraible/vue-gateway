package tech.jhipster.sample.repository.rowmapper;

import io.r2dbc.spi.Row;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;
import tech.jhipster.sample.domain.EntityWithDTO;
import tech.jhipster.sample.service.ColumnConverter;

/**
 * Converter between {@link Row} to {@link EntityWithDTO}, with proper type conversions.
 */
@Service
public class EntityWithDTORowMapper implements BiFunction<Row, String, EntityWithDTO> {

    private final ColumnConverter converter;

    public EntityWithDTORowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link EntityWithDTO} stored in the database.
     */
    @Override
    public EntityWithDTO apply(Row row, String prefix) {
        EntityWithDTO entity = new EntityWithDTO();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setEmma(converter.fromRow(row, prefix + "_emma", String.class));
        return entity;
    }
}
