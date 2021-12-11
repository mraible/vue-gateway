package tech.jhipster.sample.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.relational.core.sql.Column;
import org.springframework.data.relational.core.sql.Expression;
import org.springframework.data.relational.core.sql.Table;

public class BankAccountSqlHelper {

    public static List<Expression> getColumns(Table table, String columnPrefix) {
        List<Expression> columns = new ArrayList<>();
        columns.add(Column.aliased("id", table, columnPrefix + "_id"));
        columns.add(Column.aliased("name", table, columnPrefix + "_name"));
        columns.add(Column.aliased("guid", table, columnPrefix + "_guid"));
        columns.add(Column.aliased("bank_number", table, columnPrefix + "_bank_number"));
        columns.add(Column.aliased("agency_number", table, columnPrefix + "_agency_number"));
        columns.add(Column.aliased("last_operation_duration", table, columnPrefix + "_last_operation_duration"));
        columns.add(Column.aliased("mean_operation_duration", table, columnPrefix + "_mean_operation_duration"));
        columns.add(Column.aliased("mean_queue_duration", table, columnPrefix + "_mean_queue_duration"));
        columns.add(Column.aliased("balance", table, columnPrefix + "_balance"));
        columns.add(Column.aliased("opening_day", table, columnPrefix + "_opening_day"));
        columns.add(Column.aliased("last_operation_date", table, columnPrefix + "_last_operation_date"));
        columns.add(Column.aliased("active", table, columnPrefix + "_active"));
        columns.add(Column.aliased("account_type", table, columnPrefix + "_account_type"));
        columns.add(Column.aliased("attachment", table, columnPrefix + "_attachment"));
        columns.add(Column.aliased("attachment_content_type", table, columnPrefix + "_attachment_content_type"));
        columns.add(Column.aliased("description", table, columnPrefix + "_description"));

        columns.add(Column.aliased("user_id", table, columnPrefix + "_user_id"));
        return columns;
    }
}
