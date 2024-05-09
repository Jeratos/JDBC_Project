package MyPackeg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {

        try{
        Connection con = DriverManager.getConnection("JDBC:mysql://localhost:3306/sells","root","");

            Statement st = con.createStatement();
            System.out.println("successfully connected");
            String CreateQuery="CREATE TABLE info (`id` INT NOT NULL AUTO_INCREMENT, `Pname` VARCHAR(50), `Price` INT(10), PRIMARY KEY (`id`))";
            String DeleteQuery="DROP TABLE `sells`.`info`";
            st.execute(CreateQuery);
          st.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
