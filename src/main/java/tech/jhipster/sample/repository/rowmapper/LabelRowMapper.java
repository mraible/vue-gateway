package tech.jhipster.sample.repository.rowmapper;

import io.r2dbc.spi.Row;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;
import tech.jhipster.sample.domain.Label;
import tech.jhipster.sample.service.ColumnConverter;

/**
 * Converter between {@link Row} to {@link Label}, with proper type conversions.
 */
@Service
public class LabelRowMapper implements BiFunction<Row, String, Label> {

    private final ColumnConverter converter;

    public LabelRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link Label} stored in the database.
     */
    @Override
    public Label apply(Row row, String prefix) {
        Label entity = new Label();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setLabelName(converter.fromRow(row, prefix + "_label_name", String.class));
        return entity;
    }
}
