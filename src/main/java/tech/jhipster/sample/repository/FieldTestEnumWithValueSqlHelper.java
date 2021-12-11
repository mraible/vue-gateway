package tech.jhipster.sample.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class FieldTestEnumWithValueSqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("id", table, columnPrefix + "_id"));
        columns.add(Column.aliased("my_field_a", table, columnPrefix + "_my_field_a"));
        columns.add(Column.aliased("my_field_b", table, columnPrefix + "_my_field_b"));
        columns.add(Column.aliased("my_field_c", table, columnPrefix + "_my_field_c"));

        return columns;
    }
}
