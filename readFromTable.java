package MyPackeg;

import java.sql.*;


public class readFromTable{
    public void read() {
      try {
          String URL = "JDBC:mysql://localhost:3306/sells";
          String UserName = "root";
          String Pass = "";
          Connection con = DriverManager.getConnection(URL, UserName, Pass);
          Statement st = con.createStatement();

          System.out.println("connection is successfully established... ");
          int id;
          String Product;
          int Price;
          String query= "SELECT * FROM info";
          ResultSet set = st.executeQuery(query);
    while (set.next()){
             id= set.getInt("id");
             Product=set.getString("Pname");
             Price=set.getInt("Price");
        System.out.println("id= "+id+", Product name= "+Product+", Product price= "+Price);
    }

      }catch (Exception e){
          e.printStackTrace();
      }

    }
}
