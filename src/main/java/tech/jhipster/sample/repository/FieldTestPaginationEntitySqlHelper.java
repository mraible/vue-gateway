package tech.jhipster.sample.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class FieldTestPaginationEntitySqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("id", table, columnPrefix + "_id"));
        columns.add(Column.aliased("string_alice", table, columnPrefix + "_string_alice"));
        columns.add(Column.aliased("string_required_alice", table, columnPrefix + "_string_required_alice"));
        columns.add(Column.aliased("string_minlength_alice", table, columnPrefix + "_string_minlength_alice"));
        columns.add(Column.aliased("string_maxlength_alice", table, columnPrefix + "_string_maxlength_alice"));
        columns.add(Column.aliased("string_pattern_alice", table, columnPrefix + "_string_pattern_alice"));
        columns.add(Column.aliased("integer_alice", table, columnPrefix + "_integer_alice"));
        columns.add(Column.aliased("integer_required_alice", table, columnPrefix + "_integer_required_alice"));
        columns.add(Column.aliased("integer_min_alice", table, columnPrefix + "_integer_min_alice"));
        columns.add(Column.aliased("integer_max_alice", table, columnPrefix + "_integer_max_alice"));
        columns.add(Column.aliased("long_alice", table, columnPrefix + "_long_alice"));
        columns.add(Column.aliased("long_required_alice", table, columnPrefix + "_long_required_alice"));
        columns.add(Column.aliased("long_min_alice", table, columnPrefix + "_long_min_alice"));
        columns.add(Column.aliased("long_max_alice", table, columnPrefix + "_long_max_alice"));
        columns.add(Column.aliased("float_alice", table, columnPrefix + "_float_alice"));
        columns.add(Column.aliased("float_required_alice", table, columnPrefix + "_float_required_alice"));
        columns.add(Column.aliased("float_min_alice", table, columnPrefix + "_float_min_alice"));
        columns.add(Column.aliased("float_max_alice", table, columnPrefix + "_float_max_alice"));
        columns.add(Column.aliased("double_required_alice", table, columnPrefix + "_double_required_alice"));
        columns.add(Column.aliased("double_min_alice", table, columnPrefix + "_double_min_alice"));
        columns.add(Column.aliased("double_max_alice", table, columnPrefix + "_double_max_alice"));
        columns.add(Column.aliased("big_decimal_required_alice", table, columnPrefix + "_big_decimal_required_alice"));
        columns.add(Column.aliased("big_decimal_min_alice", table, columnPrefix + "_big_decimal_min_alice"));
        columns.add(Column.aliased("big_decimal_max_alice", table, columnPrefix + "_big_decimal_max_alice"));
        columns.add(Column.aliased("local_date_alice", table, columnPrefix + "_local_date_alice"));
        columns.add(Column.aliased("local_date_required_alice", table, columnPrefix + "_local_date_required_alice"));
        columns.add(Column.aliased("instant_alice", table, columnPrefix + "_instant_alice"));
        columns.add(Column.aliased("instante_required_alice", table, columnPrefix + "_instante_required_alice"));
        columns.add(Column.aliased("zoned_date_time_alice", table, columnPrefix + "_zoned_date_time_alice"));
        columns.add(Column.aliased("zoned_date_time_required_alice", table, columnPrefix + "_zoned_date_time_required_alice"));
        columns.add(Column.aliased("duration_alice", table, columnPrefix + "_duration_alice"));
        columns.add(Column.aliased("duration_required_alice", table, columnPrefix + "_duration_required_alice"));
        columns.add(Column.aliased("boolean_alice", table, columnPrefix + "_boolean_alice"));
        columns.add(Column.aliased("boolean_required_alice", table, columnPrefix + "_boolean_required_alice"));
        columns.add(Column.aliased("enum_alice", table, columnPrefix + "_enum_alice"));
        columns.add(Column.aliased("enum_required_alice", table, columnPrefix + "_enum_required_alice"));
        columns.add(Column.aliased("uuid_alice", table, columnPrefix + "_uuid_alice"));
        columns.add(Column.aliased("uuid_required_alice", table, columnPrefix + "_uuid_required_alice"));
        columns.add(Column.aliased("byte_image_alice", table, columnPrefix + "_byte_image_alice"));
        columns.add(Column.aliased("byte_image_alice_content_type", table, columnPrefix + "_byte_image_alice_content_type"));
        columns.add(Column.aliased("byte_image_required_alice", table, columnPrefix + "_byte_image_required_alice"));
        columns.add(
            Column.aliased("byte_image_required_alice_content_type", table, columnPrefix + "_byte_image_required_alice_content_type")
        );
        columns.add(Column.aliased("byte_image_minbytes_alice", table, columnPrefix + "_byte_image_minbytes_alice"));
        columns.add(
            Column.aliased("byte_image_minbytes_alice_content_type", table, columnPrefix + "_byte_image_minbytes_alice_content_type")
        );
        columns.add(Column.aliased("byte_image_maxbytes_alice", table, columnPrefix + "_byte_image_maxbytes_alice"));
        columns.add(
            Column.aliased("byte_image_maxbytes_alice_content_type", table, columnPrefix + "_byte_image_maxbytes_alice_content_type")
        );
        columns.add(Column.aliased("byte_any_alice", table, columnPrefix + "_byte_any_alice"));
        columns.add(Column.aliased("byte_any_alice_content_type", table, columnPrefix + "_byte_any_alice_content_type"));
        columns.add(Column.aliased("byte_any_required_alice", table, columnPrefix + "_byte_any_required_alice"));
        columns.add(Column.aliased("byte_any_required_alice_content_type", table, columnPrefix + "_byte_any_required_alice_content_type"));
        columns.add(Column.aliased("byte_any_minbytes_alice", table, columnPrefix + "_byte_any_minbytes_alice"));
        columns.add(Column.aliased("byte_any_minbytes_alice_content_type", table, columnPrefix + "_byte_any_minbytes_alice_content_type"));
        columns.add(Column.aliased("byte_any_maxbytes_alice", table, columnPrefix + "_byte_any_maxbytes_alice"));
        columns.add(Column.aliased("byte_any_maxbytes_alice_content_type", table, columnPrefix + "_byte_any_maxbytes_alice_content_type"));
        columns.add(Column.aliased("byte_text_alice", table, columnPrefix + "_byte_text_alice"));
        columns.add(Column.aliased("byte_text_required_alice", table, columnPrefix + "_byte_text_required_alice"));

        return columns;
    }
}
