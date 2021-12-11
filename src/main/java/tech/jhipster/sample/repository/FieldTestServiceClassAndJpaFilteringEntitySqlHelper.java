package tech.jhipster.sample.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class FieldTestServiceClassAndJpaFilteringEntitySqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("id", table, columnPrefix + "_id"));
        columns.add(Column.aliased("string_bob", table, columnPrefix + "_string_bob"));
        columns.add(Column.aliased("string_required_bob", table, columnPrefix + "_string_required_bob"));
        columns.add(Column.aliased("string_minlength_bob", table, columnPrefix + "_string_minlength_bob"));
        columns.add(Column.aliased("string_maxlength_bob", table, columnPrefix + "_string_maxlength_bob"));
        columns.add(Column.aliased("string_pattern_bob", table, columnPrefix + "_string_pattern_bob"));
        columns.add(Column.aliased("integer_bob", table, columnPrefix + "_integer_bob"));
        columns.add(Column.aliased("integer_required_bob", table, columnPrefix + "_integer_required_bob"));
        columns.add(Column.aliased("integer_min_bob", table, columnPrefix + "_integer_min_bob"));
        columns.add(Column.aliased("integer_max_bob", table, columnPrefix + "_integer_max_bob"));
        columns.add(Column.aliased("long_bob", table, columnPrefix + "_long_bob"));
        columns.add(Column.aliased("long_required_bob", table, columnPrefix + "_long_required_bob"));
        columns.add(Column.aliased("long_min_bob", table, columnPrefix + "_long_min_bob"));
        columns.add(Column.aliased("long_max_bob", table, columnPrefix + "_long_max_bob"));
        columns.add(Column.aliased("float_bob", table, columnPrefix + "_float_bob"));
        columns.add(Column.aliased("float_required_bob", table, columnPrefix + "_float_required_bob"));
        columns.add(Column.aliased("float_min_bob", table, columnPrefix + "_float_min_bob"));
        columns.add(Column.aliased("float_max_bob", table, columnPrefix + "_float_max_bob"));
        columns.add(Column.aliased("double_required_bob", table, columnPrefix + "_double_required_bob"));
        columns.add(Column.aliased("double_min_bob", table, columnPrefix + "_double_min_bob"));
        columns.add(Column.aliased("double_max_bob", table, columnPrefix + "_double_max_bob"));
        columns.add(Column.aliased("big_decimal_required_bob", table, columnPrefix + "_big_decimal_required_bob"));
        columns.add(Column.aliased("big_decimal_min_bob", table, columnPrefix + "_big_decimal_min_bob"));
        columns.add(Column.aliased("big_decimal_max_bob", table, columnPrefix + "_big_decimal_max_bob"));
        columns.add(Column.aliased("local_date_bob", table, columnPrefix + "_local_date_bob"));
        columns.add(Column.aliased("local_date_required_bob", table, columnPrefix + "_local_date_required_bob"));
        columns.add(Column.aliased("instant_bob", table, columnPrefix + "_instant_bob"));
        columns.add(Column.aliased("instante_required_bob", table, columnPrefix + "_instante_required_bob"));
        columns.add(Column.aliased("zoned_date_time_bob", table, columnPrefix + "_zoned_date_time_bob"));
        columns.add(Column.aliased("zoned_date_time_required_bob", table, columnPrefix + "_zoned_date_time_required_bob"));
        columns.add(Column.aliased("duration_bob", table, columnPrefix + "_duration_bob"));
        columns.add(Column.aliased("duration_required_bob", table, columnPrefix + "_duration_required_bob"));
        columns.add(Column.aliased("boolean_bob", table, columnPrefix + "_boolean_bob"));
        columns.add(Column.aliased("boolean_required_bob", table, columnPrefix + "_boolean_required_bob"));
        columns.add(Column.aliased("enum_bob", table, columnPrefix + "_enum_bob"));
        columns.add(Column.aliased("enum_required_bob", table, columnPrefix + "_enum_required_bob"));
        columns.add(Column.aliased("uuid_bob", table, columnPrefix + "_uuid_bob"));
        columns.add(Column.aliased("uuid_required_bob", table, columnPrefix + "_uuid_required_bob"));
        columns.add(Column.aliased("byte_image_bob", table, columnPrefix + "_byte_image_bob"));
        columns.add(Column.aliased("byte_image_bob_content_type", table, columnPrefix + "_byte_image_bob_content_type"));
        columns.add(Column.aliased("byte_image_required_bob", table, columnPrefix + "_byte_image_required_bob"));
        columns.add(Column.aliased("byte_image_required_bob_content_type", table, columnPrefix + "_byte_image_required_bob_content_type"));
        columns.add(Column.aliased("byte_image_minbytes_bob", table, columnPrefix + "_byte_image_minbytes_bob"));
        columns.add(Column.aliased("byte_image_minbytes_bob_content_type", table, columnPrefix + "_byte_image_minbytes_bob_content_type"));
        columns.add(Column.aliased("byte_image_maxbytes_bob", table, columnPrefix + "_byte_image_maxbytes_bob"));
        columns.add(Column.aliased("byte_image_maxbytes_bob_content_type", table, columnPrefix + "_byte_image_maxbytes_bob_content_type"));
        columns.add(Column.aliased("byte_any_bob", table, columnPrefix + "_byte_any_bob"));
        columns.add(Column.aliased("byte_any_bob_content_type", table, columnPrefix + "_byte_any_bob_content_type"));
        columns.add(Column.aliased("byte_any_required_bob", table, columnPrefix + "_byte_any_required_bob"));
        columns.add(Column.aliased("byte_any_required_bob_content_type", table, columnPrefix + "_byte_any_required_bob_content_type"));
        columns.add(Column.aliased("byte_any_minbytes_bob", table, columnPrefix + "_byte_any_minbytes_bob"));
        columns.add(Column.aliased("byte_any_minbytes_bob_content_type", table, columnPrefix + "_byte_any_minbytes_bob_content_type"));
        columns.add(Column.aliased("byte_any_maxbytes_bob", table, columnPrefix + "_byte_any_maxbytes_bob"));
        columns.add(Column.aliased("byte_any_maxbytes_bob_content_type", table, columnPrefix + "_byte_any_maxbytes_bob_content_type"));
        columns.add(Column.aliased("byte_text_bob", table, columnPrefix + "_byte_text_bob"));
        columns.add(Column.aliased("byte_text_required_bob", table, columnPrefix + "_byte_text_required_bob"));

        return columns;
    }
}
