package tech.jhipster.sample.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class FieldTestServiceImplEntitySqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("id", table, columnPrefix + "_id"));
        columns.add(Column.aliased("string_mika", table, columnPrefix + "_string_mika"));
        columns.add(Column.aliased("string_required_mika", table, columnPrefix + "_string_required_mika"));
        columns.add(Column.aliased("string_minlength_mika", table, columnPrefix + "_string_minlength_mika"));
        columns.add(Column.aliased("string_maxlength_mika", table, columnPrefix + "_string_maxlength_mika"));
        columns.add(Column.aliased("string_pattern_mika", table, columnPrefix + "_string_pattern_mika"));
        columns.add(Column.aliased("integer_mika", table, columnPrefix + "_integer_mika"));
        columns.add(Column.aliased("integer_required_mika", table, columnPrefix + "_integer_required_mika"));
        columns.add(Column.aliased("integer_min_mika", table, columnPrefix + "_integer_min_mika"));
        columns.add(Column.aliased("integer_max_mika", table, columnPrefix + "_integer_max_mika"));
        columns.add(Column.aliased("long_mika", table, columnPrefix + "_long_mika"));
        columns.add(Column.aliased("long_required_mika", table, columnPrefix + "_long_required_mika"));
        columns.add(Column.aliased("long_min_mika", table, columnPrefix + "_long_min_mika"));
        columns.add(Column.aliased("long_max_mika", table, columnPrefix + "_long_max_mika"));
        columns.add(Column.aliased("float_mika", table, columnPrefix + "_float_mika"));
        columns.add(Column.aliased("float_required_mika", table, columnPrefix + "_float_required_mika"));
        columns.add(Column.aliased("float_min_mika", table, columnPrefix + "_float_min_mika"));
        columns.add(Column.aliased("float_max_mika", table, columnPrefix + "_float_max_mika"));
        columns.add(Column.aliased("double_required_mika", table, columnPrefix + "_double_required_mika"));
        columns.add(Column.aliased("double_min_mika", table, columnPrefix + "_double_min_mika"));
        columns.add(Column.aliased("double_max_mika", table, columnPrefix + "_double_max_mika"));
        columns.add(Column.aliased("big_decimal_required_mika", table, columnPrefix + "_big_decimal_required_mika"));
        columns.add(Column.aliased("big_decimal_min_mika", table, columnPrefix + "_big_decimal_min_mika"));
        columns.add(Column.aliased("big_decimal_max_mika", table, columnPrefix + "_big_decimal_max_mika"));
        columns.add(Column.aliased("local_date_mika", table, columnPrefix + "_local_date_mika"));
        columns.add(Column.aliased("local_date_required_mika", table, columnPrefix + "_local_date_required_mika"));
        columns.add(Column.aliased("instant_mika", table, columnPrefix + "_instant_mika"));
        columns.add(Column.aliased("instante_required_mika", table, columnPrefix + "_instante_required_mika"));
        columns.add(Column.aliased("zoned_date_time_mika", table, columnPrefix + "_zoned_date_time_mika"));
        columns.add(Column.aliased("zoned_date_time_required_mika", table, columnPrefix + "_zoned_date_time_required_mika"));
        columns.add(Column.aliased("duration_mika", table, columnPrefix + "_duration_mika"));
        columns.add(Column.aliased("duration_required_mika", table, columnPrefix + "_duration_required_mika"));
        columns.add(Column.aliased("boolean_mika", table, columnPrefix + "_boolean_mika"));
        columns.add(Column.aliased("boolean_required_mika", table, columnPrefix + "_boolean_required_mika"));
        columns.add(Column.aliased("enum_mika", table, columnPrefix + "_enum_mika"));
        columns.add(Column.aliased("enum_required_mika", table, columnPrefix + "_enum_required_mika"));
        columns.add(Column.aliased("uuid_mika", table, columnPrefix + "_uuid_mika"));
        columns.add(Column.aliased("uuid_required_mika", table, columnPrefix + "_uuid_required_mika"));
        columns.add(Column.aliased("byte_image_mika", table, columnPrefix + "_byte_image_mika"));
        columns.add(Column.aliased("byte_image_mika_content_type", table, columnPrefix + "_byte_image_mika_content_type"));
        columns.add(Column.aliased("byte_image_required_mika", table, columnPrefix + "_byte_image_required_mika"));
        columns.add(
            Column.aliased("byte_image_required_mika_content_type", table, columnPrefix + "_byte_image_required_mika_content_type")
        );
        columns.add(Column.aliased("byte_image_minbytes_mika", table, columnPrefix + "_byte_image_minbytes_mika"));
        columns.add(
            Column.aliased("byte_image_minbytes_mika_content_type", table, columnPrefix + "_byte_image_minbytes_mika_content_type")
        );
        columns.add(Column.aliased("byte_image_maxbytes_mika", table, columnPrefix + "_byte_image_maxbytes_mika"));
        columns.add(
            Column.aliased("byte_image_maxbytes_mika_content_type", table, columnPrefix + "_byte_image_maxbytes_mika_content_type")
        );
        columns.add(Column.aliased("byte_any_mika", table, columnPrefix + "_byte_any_mika"));
        columns.add(Column.aliased("byte_any_mika_content_type", table, columnPrefix + "_byte_any_mika_content_type"));
        columns.add(Column.aliased("byte_any_required_mika", table, columnPrefix + "_byte_any_required_mika"));
        columns.add(Column.aliased("byte_any_required_mika_content_type", table, columnPrefix + "_byte_any_required_mika_content_type"));
        columns.add(Column.aliased("byte_any_minbytes_mika", table, columnPrefix + "_byte_any_minbytes_mika"));
        columns.add(Column.aliased("byte_any_minbytes_mika_content_type", table, columnPrefix + "_byte_any_minbytes_mika_content_type"));
        columns.add(Column.aliased("byte_any_maxbytes_mika", table, columnPrefix + "_byte_any_maxbytes_mika"));
        columns.add(Column.aliased("byte_any_maxbytes_mika_content_type", table, columnPrefix + "_byte_any_maxbytes_mika_content_type"));
        columns.add(Column.aliased("byte_text_mika", table, columnPrefix + "_byte_text_mika"));
        columns.add(Column.aliased("byte_text_required_mika", table, columnPrefix + "_byte_text_required_mika"));

        return columns;
    }
}
