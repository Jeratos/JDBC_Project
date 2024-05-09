package MyPackeg;

import java.sql.*;


public class DataBaseCreateDelete {
    public static void main(String[] args) throws Exception {
        String URL = "JDBC:mysql://localhost:3306/";
        String userName= "root";
        String Pass = "";
        Connection con = DriverManager.getConnection(URL,userName,Pass);
        Statement stm = con.createStatement();

        String CreateDatabaseQuery= "CREATE DATABASE sells";
        String DeleteDatabaseQuery= "DROP DATABASE sells";

        stm.execute(CreateDatabaseQuery);
        stm.close();
    }
}
