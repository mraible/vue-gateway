package tech.jhipster.sample.repository.rowmapper;

import io.r2dbc.spi.Row;
import java.util.function.BiFunction;
import org.springframework.stereotype.Service;
import tech.jhipster.sample.domain.FieldTestEnumWithValue;
import tech.jhipster.sample.domain.enumeration.MyEnumA;
import tech.jhipster.sample.domain.enumeration.MyEnumB;
import tech.jhipster.sample.domain.enumeration.MyEnumC;
import tech.jhipster.sample.service.ColumnConverter;

/**
 * Converter between {@link Row} to {@link FieldTestEnumWithValue}, with proper type conversions.
 */
@Service
public class FieldTestEnumWithValueRowMapper implements BiFunction<Row, String, FieldTestEnumWithValue> {

    private final ColumnConverter converter;

    public FieldTestEnumWithValueRowMapper(ColumnConverter converter) {
        this.converter = converter;
    }

    /**
     * Take a {@link Row} and a column prefix, and extract all the fields.
     * @return the {@link FieldTestEnumWithValue} stored in the database.
     */
    @Override
    public FieldTestEnumWithValue apply(Row row, String prefix) {
        FieldTestEnumWithValue entity = new FieldTestEnumWithValue();
        entity.setId(converter.fromRow(row, prefix + "_id", Long.class));
        entity.setMyFieldA(converter.fromRow(row, prefix + "_my_field_a", MyEnumA.class));
        entity.setMyFieldB(converter.fromRow(row, prefix + "_my_field_b", MyEnumB.class));
        entity.setMyFieldC(converter.fromRow(row, prefix + "_my_field_c", MyEnumC.class));
        return entity;
    }
}
