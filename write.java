package MyPackeg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class write {
    String url = "JDBC:mysql://localhost:3306/sells";
    String Name="root";
    String pass="";
    public void Write(String name,int price){
 try {
     Connection con = DriverManager.getConnection(url,Name,pass);

     String query ="INSERT INTO info (Pname, Price) VALUE('"+name+"',"+price+")";
     Statement st = con.createStatement();
     st.execute(query);
     st.close();
     System.out.printf("Value inserted successfully...");
 }
 catch (Exception e){
     e.printStackTrace();
 }
    }

    public static void main(String[] args) {

    }
}
