package w32.sqlite;

import java.sql.Connection;
import java.sql.Statement;

public class BCreateTable {
    public void createTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            //Class.forName("org.w32.sqlite.JDBC");
            //c = DriverManager.getConnection("jdbc:w32.sqlite:SqliteJavaDB.db");
            c = AMainDBConn.connect();
            System.out.println("Database Opened...\n");
            stmt = c.createStatement();
            String sql = "CREATE TABLE warehouse " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " name TEXT NOT NULL, " +
                    " capacity INT NOT NULL) ";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table Product Created Successfully!!!");
    }
    public static void main(String[] args) {
        BCreateTable cr = new BCreateTable();
        cr.createTable();
    }
}
