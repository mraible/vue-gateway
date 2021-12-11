package tech.jhipster.sample.repository.rowmapper;

import io.r2dbc.spi.Row;
import java.time.Instant;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;
import tech.jhipster.sample.domain.MapsIdUserProfileWithDTO;
import tech.jhipster.sample.service.ColumnConverter;

/**
 * Converter between {@link Row} to {@link MapsIdUserProfileWithDTO}, with proper type conversions.
 */
@Service
public class MapsIdUserProfileWithDTORowMapper implements BiFunction<Row, String, MapsIdUserProfileWithDTO> {

    private final ColumnConverter converter;

    public MapsIdUserProfileWithDTORowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link MapsIdUserProfileWithDTO} stored in the database.
     */
    @Override
    public MapsIdUserProfileWithDTO apply(Row row, String prefix) {
        MapsIdUserProfileWithDTO entity = new MapsIdUserProfileWithDTO();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setDateOfBirth(converter.fromRow(row, prefix + "_date_of_birth", Instant.class));
        return entity;
    }
}
