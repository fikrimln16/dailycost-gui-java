package daily.cost;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    public static Connection conn;

    public static Connection getConnect(){
        try {
            String url ="jdbc:mysql://34.128.80.35/dailycost";
            String user="root";
            String pass="9RKksx6jxJ[E/EDH";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pass);
            return conn;
        } catch (Exception e) {
            System.err.println("koneksi gagal" +e.getMessage());
        }
        return null;
    } 
}
