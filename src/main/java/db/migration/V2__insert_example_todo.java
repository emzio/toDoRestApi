package db.migration;//package db.migration;
//
//import org.flywaydb.core.api.migration.BaseJavaMigration;
//import org.flywaydb.core.api.migration.Context;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.SingleConnectionDataSource;
//
//public class V2__insert_example_todo extends BaseJavaMigration {
//
//    @Override
//    public void migrate(final Context context) {
//        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
//                .execute("INSERT INTO TASKS ( DESCRIPTION, DONE ) VALUES ('learn Java Migrations', true)");
////        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
////                .execute("delete from TASKS WHERE id = 0");
//    }
//}
