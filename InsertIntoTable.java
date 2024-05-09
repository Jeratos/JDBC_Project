package MyPackeg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertIntoTable {


    public static void main(String[] args) {

        try {
            String URL = "JDBC:mysql://localhost:3306/sells";
            String UserName = "root";
            String Pass = "";
            Connection con = DriverManager.getConnection(URL, UserName, Pass);
            Statement st = con.createStatement();

            System.out.println("connection is successfully established... ");


            String query = "INSERT INTO info (Pname, Price) VALUE ('water bottle', '20') ";

            String DeleteQuery = "DELETE FROM info WHERE `id`=10";
            st.execute(DeleteQuery);

            st.close();
        }
    catch (Exception e){
            e.printStackTrace();
        }
    }

}
