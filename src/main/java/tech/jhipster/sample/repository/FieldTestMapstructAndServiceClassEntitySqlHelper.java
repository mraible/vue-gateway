package tech.jhipster.sample.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class FieldTestMapstructAndServiceClassEntitySqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("id", table, columnPrefix + "_id"));
        columns.add(Column.aliased("string_eva", table, columnPrefix + "_string_eva"));
        columns.add(Column.aliased("string_required_eva", table, columnPrefix + "_string_required_eva"));
        columns.add(Column.aliased("string_minlength_eva", table, columnPrefix + "_string_minlength_eva"));
        columns.add(Column.aliased("string_maxlength_eva", table, columnPrefix + "_string_maxlength_eva"));
        columns.add(Column.aliased("string_pattern_eva", table, columnPrefix + "_string_pattern_eva"));
        columns.add(Column.aliased("integer_eva", table, columnPrefix + "_integer_eva"));
        columns.add(Column.aliased("integer_required_eva", table, columnPrefix + "_integer_required_eva"));
        columns.add(Column.aliased("integer_min_eva", table, columnPrefix + "_integer_min_eva"));
        columns.add(Column.aliased("integer_max_eva", table, columnPrefix + "_integer_max_eva"));
        columns.add(Column.aliased("long_eva", table, columnPrefix + "_long_eva"));
        columns.add(Column.aliased("long_required_eva", table, columnPrefix + "_long_required_eva"));
        columns.add(Column.aliased("long_min_eva", table, columnPrefix + "_long_min_eva"));
        columns.add(Column.aliased("long_max_eva", table, columnPrefix + "_long_max_eva"));
        columns.add(Column.aliased("float_eva", table, columnPrefix + "_float_eva"));
        columns.add(Column.aliased("float_required_eva", table, columnPrefix + "_float_required_eva"));
        columns.add(Column.aliased("float_min_eva", table, columnPrefix + "_float_min_eva"));
        columns.add(Column.aliased("float_max_eva", table, columnPrefix + "_float_max_eva"));
        columns.add(Column.aliased("double_required_eva", table, columnPrefix + "_double_required_eva"));
        columns.add(Column.aliased("double_min_eva", table, columnPrefix + "_double_min_eva"));
        columns.add(Column.aliased("double_max_eva", table, columnPrefix + "_double_max_eva"));
        columns.add(Column.aliased("big_decimal_required_eva", table, columnPrefix + "_big_decimal_required_eva"));
        columns.add(Column.aliased("big_decimal_min_eva", table, columnPrefix + "_big_decimal_min_eva"));
        columns.add(Column.aliased("big_decimal_max_eva", table, columnPrefix + "_big_decimal_max_eva"));
        columns.add(Column.aliased("local_date_eva", table, columnPrefix + "_local_date_eva"));
        columns.add(Column.aliased("local_date_required_eva", table, columnPrefix + "_local_date_required_eva"));
        columns.add(Column.aliased("instant_eva", table, columnPrefix + "_instant_eva"));
        columns.add(Column.aliased("instante_required_eva", table, columnPrefix + "_instante_required_eva"));
        columns.add(Column.aliased("zoned_date_time_eva", table, columnPrefix + "_zoned_date_time_eva"));
        columns.add(Column.aliased("zoned_date_time_required_eva", table, columnPrefix + "_zoned_date_time_required_eva"));
        columns.add(Column.aliased("duration_eva", table, columnPrefix + "_duration_eva"));
        columns.add(Column.aliased("duration_required_eva", table, columnPrefix + "_duration_required_eva"));
        columns.add(Column.aliased("boolean_eva", table, columnPrefix + "_boolean_eva"));
        columns.add(Column.aliased("boolean_required_eva", table, columnPrefix + "_boolean_required_eva"));
        columns.add(Column.aliased("enum_eva", table, columnPrefix + "_enum_eva"));
        columns.add(Column.aliased("enum_required_eva", table, columnPrefix + "_enum_required_eva"));
        columns.add(Column.aliased("uuid_eva", table, columnPrefix + "_uuid_eva"));
        columns.add(Column.aliased("uuid_required_eva", table, columnPrefix + "_uuid_required_eva"));
        columns.add(Column.aliased("byte_image_eva", table, columnPrefix + "_byte_image_eva"));
        columns.add(Column.aliased("byte_image_eva_content_type", table, columnPrefix + "_byte_image_eva_content_type"));
        columns.add(Column.aliased("byte_image_required_eva", table, columnPrefix + "_byte_image_required_eva"));
        columns.add(Column.aliased("byte_image_required_eva_content_type", table, columnPrefix + "_byte_image_required_eva_content_type"));
        columns.add(Column.aliased("byte_image_minbytes_eva", table, columnPrefix + "_byte_image_minbytes_eva"));
        columns.add(Column.aliased("byte_image_minbytes_eva_content_type", table, columnPrefix + "_byte_image_minbytes_eva_content_type"));
        columns.add(Column.aliased("byte_image_maxbytes_eva", table, columnPrefix + "_byte_image_maxbytes_eva"));
        columns.add(Column.aliased("byte_image_maxbytes_eva_content_type", table, columnPrefix + "_byte_image_maxbytes_eva_content_type"));
        columns.add(Column.aliased("byte_any_eva", table, columnPrefix + "_byte_any_eva"));
        columns.add(Column.aliased("byte_any_eva_content_type", table, columnPrefix + "_byte_any_eva_content_type"));
        columns.add(Column.aliased("byte_any_required_eva", table, columnPrefix + "_byte_any_required_eva"));
        columns.add(Column.aliased("byte_any_required_eva_content_type", table, columnPrefix + "_byte_any_required_eva_content_type"));
        columns.add(Column.aliased("byte_any_minbytes_eva", table, columnPrefix + "_byte_any_minbytes_eva"));
        columns.add(Column.aliased("byte_any_minbytes_eva_content_type", table, columnPrefix + "_byte_any_minbytes_eva_content_type"));
        columns.add(Column.aliased("byte_any_maxbytes_eva", table, columnPrefix + "_byte_any_maxbytes_eva"));
        columns.add(Column.aliased("byte_any_maxbytes_eva_content_type", table, columnPrefix + "_byte_any_maxbytes_eva_content_type"));
        columns.add(Column.aliased("byte_text_eva", table, columnPrefix + "_byte_text_eva"));
        columns.add(Column.aliased("byte_text_required_eva", table, columnPrefix + "_byte_text_required_eva"));

        return columns;
    }
}
