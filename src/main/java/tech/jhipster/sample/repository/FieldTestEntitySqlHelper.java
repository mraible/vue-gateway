package tech.jhipster.sample.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class FieldTestEntitySqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("id", table, columnPrefix + "_id"));
        columns.add(Column.aliased("string_tom", table, columnPrefix + "_string_tom"));
        columns.add(Column.aliased("string_required_tom", table, columnPrefix + "_string_required_tom"));
        columns.add(Column.aliased("string_minlength_tom", table, columnPrefix + "_string_minlength_tom"));
        columns.add(Column.aliased("string_maxlength_tom", table, columnPrefix + "_string_maxlength_tom"));
        columns.add(Column.aliased("string_pattern_tom", table, columnPrefix + "_string_pattern_tom"));
        columns.add(Column.aliased("number_pattern_tom", table, columnPrefix + "_number_pattern_tom"));
        columns.add(Column.aliased("number_pattern_required_tom", table, columnPrefix + "_number_pattern_required_tom"));
        columns.add(Column.aliased("integer_tom", table, columnPrefix + "_integer_tom"));
        columns.add(Column.aliased("integer_required_tom", table, columnPrefix + "_integer_required_tom"));
        columns.add(Column.aliased("integer_min_tom", table, columnPrefix + "_integer_min_tom"));
        columns.add(Column.aliased("integer_max_tom", table, columnPrefix + "_integer_max_tom"));
        columns.add(Column.aliased("long_tom", table, columnPrefix + "_long_tom"));
        columns.add(Column.aliased("long_required_tom", table, columnPrefix + "_long_required_tom"));
        columns.add(Column.aliased("long_min_tom", table, columnPrefix + "_long_min_tom"));
        columns.add(Column.aliased("long_max_tom", table, columnPrefix + "_long_max_tom"));
        columns.add(Column.aliased("float_tom", table, columnPrefix + "_float_tom"));
        columns.add(Column.aliased("float_required_tom", table, columnPrefix + "_float_required_tom"));
        columns.add(Column.aliased("float_min_tom", table, columnPrefix + "_float_min_tom"));
        columns.add(Column.aliased("float_max_tom", table, columnPrefix + "_float_max_tom"));
        columns.add(Column.aliased("double_required_tom", table, columnPrefix + "_double_required_tom"));
        columns.add(Column.aliased("double_min_tom", table, columnPrefix + "_double_min_tom"));
        columns.add(Column.aliased("double_max_tom", table, columnPrefix + "_double_max_tom"));
        columns.add(Column.aliased("big_decimal_required_tom", table, columnPrefix + "_big_decimal_required_tom"));
        columns.add(Column.aliased("big_decimal_min_tom", table, columnPrefix + "_big_decimal_min_tom"));
        columns.add(Column.aliased("big_decimal_max_tom", table, columnPrefix + "_big_decimal_max_tom"));
        columns.add(Column.aliased("local_date_tom", table, columnPrefix + "_local_date_tom"));
        columns.add(Column.aliased("local_date_required_tom", table, columnPrefix + "_local_date_required_tom"));
        columns.add(Column.aliased("instant_tom", table, columnPrefix + "_instant_tom"));
        columns.add(Column.aliased("instant_required_tom", table, columnPrefix + "_instant_required_tom"));
        columns.add(Column.aliased("zoned_date_time_tom", table, columnPrefix + "_zoned_date_time_tom"));
        columns.add(Column.aliased("zoned_date_time_required_tom", table, columnPrefix + "_zoned_date_time_required_tom"));
        columns.add(Column.aliased("duration_tom", table, columnPrefix + "_duration_tom"));
        columns.add(Column.aliased("duration_required_tom", table, columnPrefix + "_duration_required_tom"));
        columns.add(Column.aliased("boolean_tom", table, columnPrefix + "_boolean_tom"));
        columns.add(Column.aliased("boolean_required_tom", table, columnPrefix + "_boolean_required_tom"));
        columns.add(Column.aliased("enum_tom", table, columnPrefix + "_enum_tom"));
        columns.add(Column.aliased("enum_required_tom", table, columnPrefix + "_enum_required_tom"));
        columns.add(Column.aliased("uuid_tom", table, columnPrefix + "_uuid_tom"));
        columns.add(Column.aliased("uuid_required_tom", table, columnPrefix + "_uuid_required_tom"));
        columns.add(Column.aliased("byte_image_tom", table, columnPrefix + "_byte_image_tom"));
        columns.add(Column.aliased("byte_image_tom_content_type", table, columnPrefix + "_byte_image_tom_content_type"));
        columns.add(Column.aliased("byte_image_required_tom", table, columnPrefix + "_byte_image_required_tom"));
        columns.add(Column.aliased("byte_image_required_tom_content_type", table, columnPrefix + "_byte_image_required_tom_content_type"));
        columns.add(Column.aliased("byte_image_minbytes_tom", table, columnPrefix + "_byte_image_minbytes_tom"));
        columns.add(Column.aliased("byte_image_minbytes_tom_content_type", table, columnPrefix + "_byte_image_minbytes_tom_content_type"));
        columns.add(Column.aliased("byte_image_maxbytes_tom", table, columnPrefix + "_byte_image_maxbytes_tom"));
        columns.add(Column.aliased("byte_image_maxbytes_tom_content_type", table, columnPrefix + "_byte_image_maxbytes_tom_content_type"));
        columns.add(Column.aliased("byte_any_tom", table, columnPrefix + "_byte_any_tom"));
        columns.add(Column.aliased("byte_any_tom_content_type", table, columnPrefix + "_byte_any_tom_content_type"));
        columns.add(Column.aliased("byte_any_required_tom", table, columnPrefix + "_byte_any_required_tom"));
        columns.add(Column.aliased("byte_any_required_tom_content_type", table, columnPrefix + "_byte_any_required_tom_content_type"));
        columns.add(Column.aliased("byte_any_minbytes_tom", table, columnPrefix + "_byte_any_minbytes_tom"));
        columns.add(Column.aliased("byte_any_minbytes_tom_content_type", table, columnPrefix + "_byte_any_minbytes_tom_content_type"));
        columns.add(Column.aliased("byte_any_maxbytes_tom", table, columnPrefix + "_byte_any_maxbytes_tom"));
        columns.add(Column.aliased("byte_any_maxbytes_tom_content_type", table, columnPrefix + "_byte_any_maxbytes_tom_content_type"));
        columns.add(Column.aliased("byte_text_tom", table, columnPrefix + "_byte_text_tom"));
        columns.add(Column.aliased("byte_text_required_tom", table, columnPrefix + "_byte_text_required_tom"));

        return columns;
    }
}
