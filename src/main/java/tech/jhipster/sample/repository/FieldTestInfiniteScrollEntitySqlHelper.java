package tech.jhipster.sample.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class FieldTestInfiniteScrollEntitySqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("id", table, columnPrefix + "_id"));
        columns.add(Column.aliased("string_hugo", table, columnPrefix + "_string_hugo"));
        columns.add(Column.aliased("string_required_hugo", table, columnPrefix + "_string_required_hugo"));
        columns.add(Column.aliased("string_minlength_hugo", table, columnPrefix + "_string_minlength_hugo"));
        columns.add(Column.aliased("string_maxlength_hugo", table, columnPrefix + "_string_maxlength_hugo"));
        columns.add(Column.aliased("string_pattern_hugo", table, columnPrefix + "_string_pattern_hugo"));
        columns.add(Column.aliased("integer_hugo", table, columnPrefix + "_integer_hugo"));
        columns.add(Column.aliased("integer_required_hugo", table, columnPrefix + "_integer_required_hugo"));
        columns.add(Column.aliased("integer_min_hugo", table, columnPrefix + "_integer_min_hugo"));
        columns.add(Column.aliased("integer_max_hugo", table, columnPrefix + "_integer_max_hugo"));
        columns.add(Column.aliased("long_hugo", table, columnPrefix + "_long_hugo"));
        columns.add(Column.aliased("long_required_hugo", table, columnPrefix + "_long_required_hugo"));
        columns.add(Column.aliased("long_min_hugo", table, columnPrefix + "_long_min_hugo"));
        columns.add(Column.aliased("long_max_hugo", table, columnPrefix + "_long_max_hugo"));
        columns.add(Column.aliased("float_hugo", table, columnPrefix + "_float_hugo"));
        columns.add(Column.aliased("float_required_hugo", table, columnPrefix + "_float_required_hugo"));
        columns.add(Column.aliased("float_min_hugo", table, columnPrefix + "_float_min_hugo"));
        columns.add(Column.aliased("float_max_hugo", table, columnPrefix + "_float_max_hugo"));
        columns.add(Column.aliased("double_required_hugo", table, columnPrefix + "_double_required_hugo"));
        columns.add(Column.aliased("double_min_hugo", table, columnPrefix + "_double_min_hugo"));
        columns.add(Column.aliased("double_max_hugo", table, columnPrefix + "_double_max_hugo"));
        columns.add(Column.aliased("big_decimal_required_hugo", table, columnPrefix + "_big_decimal_required_hugo"));
        columns.add(Column.aliased("big_decimal_min_hugo", table, columnPrefix + "_big_decimal_min_hugo"));
        columns.add(Column.aliased("big_decimal_max_hugo", table, columnPrefix + "_big_decimal_max_hugo"));
        columns.add(Column.aliased("local_date_hugo", table, columnPrefix + "_local_date_hugo"));
        columns.add(Column.aliased("local_date_required_hugo", table, columnPrefix + "_local_date_required_hugo"));
        columns.add(Column.aliased("instant_hugo", table, columnPrefix + "_instant_hugo"));
        columns.add(Column.aliased("instante_required_hugo", table, columnPrefix + "_instante_required_hugo"));
        columns.add(Column.aliased("zoned_date_time_hugo", table, columnPrefix + "_zoned_date_time_hugo"));
        columns.add(Column.aliased("zoned_date_time_required_hugo", table, columnPrefix + "_zoned_date_time_required_hugo"));
        columns.add(Column.aliased("duration_hugo", table, columnPrefix + "_duration_hugo"));
        columns.add(Column.aliased("duration_required_hugo", table, columnPrefix + "_duration_required_hugo"));
        columns.add(Column.aliased("boolean_hugo", table, columnPrefix + "_boolean_hugo"));
        columns.add(Column.aliased("boolean_required_hugo", table, columnPrefix + "_boolean_required_hugo"));
        columns.add(Column.aliased("enum_hugo", table, columnPrefix + "_enum_hugo"));
        columns.add(Column.aliased("enum_required_hugo", table, columnPrefix + "_enum_required_hugo"));
        columns.add(Column.aliased("uuid_hugo", table, columnPrefix + "_uuid_hugo"));
        columns.add(Column.aliased("uuid_required_hugo", table, columnPrefix + "_uuid_required_hugo"));
        columns.add(Column.aliased("byte_image_hugo", table, columnPrefix + "_byte_image_hugo"));
        columns.add(Column.aliased("byte_image_hugo_content_type", table, columnPrefix + "_byte_image_hugo_content_type"));
        columns.add(Column.aliased("byte_image_required_hugo", table, columnPrefix + "_byte_image_required_hugo"));
        columns.add(
            Column.aliased("byte_image_required_hugo_content_type", table, columnPrefix + "_byte_image_required_hugo_content_type")
        );
        columns.add(Column.aliased("byte_image_minbytes_hugo", table, columnPrefix + "_byte_image_minbytes_hugo"));
        columns.add(
            Column.aliased("byte_image_minbytes_hugo_content_type", table, columnPrefix + "_byte_image_minbytes_hugo_content_type")
        );
        columns.add(Column.aliased("byte_image_maxbytes_hugo", table, columnPrefix + "_byte_image_maxbytes_hugo"));
        columns.add(
            Column.aliased("byte_image_maxbytes_hugo_content_type", table, columnPrefix + "_byte_image_maxbytes_hugo_content_type")
        );
        columns.add(Column.aliased("byte_any_hugo", table, columnPrefix + "_byte_any_hugo"));
        columns.add(Column.aliased("byte_any_hugo_content_type", table, columnPrefix + "_byte_any_hugo_content_type"));
        columns.add(Column.aliased("byte_any_required_hugo", table, columnPrefix + "_byte_any_required_hugo"));
        columns.add(Column.aliased("byte_any_required_hugo_content_type", table, columnPrefix + "_byte_any_required_hugo_content_type"));
        columns.add(Column.aliased("byte_any_minbytes_hugo", table, columnPrefix + "_byte_any_minbytes_hugo"));
        columns.add(Column.aliased("byte_any_minbytes_hugo_content_type", table, columnPrefix + "_byte_any_minbytes_hugo_content_type"));
        columns.add(Column.aliased("byte_any_maxbytes_hugo", table, columnPrefix + "_byte_any_maxbytes_hugo"));
        columns.add(Column.aliased("byte_any_maxbytes_hugo_content_type", table, columnPrefix + "_byte_any_maxbytes_hugo_content_type"));
        columns.add(Column.aliased("byte_text_hugo", table, columnPrefix + "_byte_text_hugo"));
        columns.add(Column.aliased("byte_text_required_hugo", table, columnPrefix + "_byte_text_required_hugo"));

        return columns;
    }
}
