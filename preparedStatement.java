package MyPackeg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class preparedStatement {
    String url = "JDBC:mysql://localhost:3306/sells";
    String name = "root";
    String pass = "";

    public Void write(String Pname, int Price) {
         try {
             Connection con = DriverManager.getConnection(url, name, pass);

             String query ="INSERT INTO info (Pname,Price) VALUE(?,?)";
             PreparedStatement pst = con.prepareStatement(query);

             pst.setString(1,Pname);
             pst.setInt(2,Price);

             pst.executeUpdate();
             System.out.printf("success...");

         }
         catch (Exception e) {
             e.printStackTrace();

         }

        return null;
    }

    public static void main(String[] args) {

    }
}
