package MyPackeg;

import java.sql.*;

class  collage{
  private String url = "JDBC:mysql://localhost:3306/";
  private String name= "root";
  private String pass= "";

    public void createDatabase () {
        try {
        Connection con = DriverManager.getConnection(url,name,pass);
            Statement st = con.createStatement();
            String  query= "CREATE DATABASE collage";
            st.execute(query);
        st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
}
public void CreateTable(){
        String URL ="JDBC:mysql://localhost:3306/collage";
    try {
        Connection con = DriverManager.getConnection(URL,name,pass);
        Statement st = con.createStatement();
    String  query= "CREATE TABLE attendance (`id` INT NOT NULL PRIMARY KEY,`name` varchar(50) NOT NULL,`date` DATE NOT NULL DEFAULT CURRENT_TIMESTAMP,`present` BOOLEAN NOT NULL )";
        st.execute(query);
        System.out.printf("query executed successfully...");
        st.close();
    }
    catch(Exception e){
        e.printStackTrace();
    }
}

public void insertIntoTable(int id , String Sname, boolean present){
    String URL ="JDBC:mysql://localhost:3306/collage";
    try {
        Connection con = DriverManager.getConnection(URL,name,pass);
        Statement st = con.createStatement();
        String  query= "INSERT INTO attendance (id, name, present) VALUE ("+id+",'"+Sname+"', "+present+")";
        int insert= st.executeUpdate(query);
        if(insert>0) {
            System.out.println("attendance insert successfully...");
        }else {
            System.out.println("attendance is not inserted...");
        }
        st.close();
    }
    catch(Exception e){
        e.printStackTrace();
    }
}

public  void  updateIntoTable(int id, String date, boolean bool){
    String URL ="JDBC:mysql://localhost:3306/collage";
    try {
        Connection con = DriverManager.getConnection(URL,name,pass);
        Statement st = con.createStatement();
        String  query= "UPDATE attendance SET present="+bool+" WHERE id="+id+" AND date='"+date+"' ";
        int insert= st.executeUpdate(query);
        if(insert>0) {
            System.out.println("attendance updated successfully...");
        }else {
            System.out.println("attendance is not updated...");
        }
        st.close();
    }
    catch(Exception e){
        e.printStackTrace();
    }

}
public  void  ReadTable(){
    String URL ="JDBC:mysql://localhost:3306/collage";
    try {
        Connection con = DriverManager.getConnection(URL,name,pass);
        Statement st = con.createStatement();
        String  query= "SELECT * FROM attendance";
       ResultSet rst=st.executeQuery(query);
while (rst.next()){
    int id = rst.getInt("id");
    String name= rst.getString("name");
    String date = rst.getString("date");
    boolean at= rst.getBoolean("present");
    String presents;
    if(at==true){
      presents="present";
  }else {
        presents="absent";
    }
    System.out.println("student ID= " +id+", Student name= "+name+", present= "+presents+", Date= "+date);
}

        st.close();
    }
    catch(Exception e){
        e.printStackTrace();
    }
}
}

public class collageAttendance {
    public static void main(String[] args) {
        collage cl =new collage();
//        cl.createDatabase(); use only once
//        cl.CreateTable(); use only once
          cl.insertIntoTable(13,"mita",true);
//         cl.updateIntoTable(1,"2024-5-3",true);
        cl.ReadTable();
    }
}
