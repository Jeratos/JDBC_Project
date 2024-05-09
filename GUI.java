package MyPackeg;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GUI extends JFrame implements ActionListener {
   String url ="JDBC:mysql://localhost:3306/collage";
   String name="root";
   String pas= "";

   int id;
   String SName;
   boolean p;

   JTextField t1 = new JTextField(20);
    JLabel l = new JLabel("enter Student id   ");
    JTextField t = new JTextField();

    JLabel l2 = new JLabel("  enter Student name  ");
    JTextField t2 = new JTextField();

    JLabel l3 = new JLabel("   enter Student present true/false ");
    JTextField t3 = new JTextField();

    JButton sub = new JButton("submit");

    JButton show=new JButton("Show data");
    JTextArea txt= new JTextArea();

    GUI(){

        JPanel pan = new JPanel();
//        pan.setLayout(new FlowLayout(FlowLayout.CENTER));


         pan.add(l);
//         l.setBounds(20,5,20,10);
         add(t);
        t.setBounds(130,50,80,30);

        pan.add(l2);
//        l2.setBounds(60,5,20,10);

        add(t2);
        t2.setBounds(250,50,80,30);

        pan.add(l3);
//        l3.setBounds(100,5,20,10);

        add(t3);
        t3.setBounds(399,50,80,30);
        pan.add(t1);

          add(sub);
        sub.setBounds(530,50,80,30);

        add(show);
        show.setBounds(650,50,110,30);
        add(txt);
        txt.setBounds(50,100,800,400);

        sub.addActionListener(this);
        show.addActionListener(this);
        add(pan,BorderLayout.CENTER);


        setSize(900,900);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == sub) {
            id = Integer.parseInt(t.getText());
            SName = t2.getText();
            p = Boolean.parseBoolean(t3.getText());

            try {
                Connection con = DriverManager.getConnection(url, name, pas);
                Statement st = con.createStatement();
                System.out.println("connection created successfully...");

                String query = "INSERT INTO attendance (id, name, present) VALUE (" + id + ",'" + SName + "', " + p + ")";
                int r = st.executeUpdate(query);

                if (r > 0) {
                    System.out.println("data is inserted successfully...");
                    t1.setText("data is inserted successfully...");
                    t.setText(null);
                    t2.setText(null);
                    t3.setText(null);
                } else {
                    System.out.println("data is not inserted...");
                    t1.setText("data is not inserted...");

                }
                st.close();
            } catch (Exception E) {
                E.printStackTrace();
            }

        }
        if (e.getSource()== show) {
            try {
                Connection con = DriverManager.getConnection(url, name, pas);
                Statement st = con.createStatement();
                System.out.println("connection created successfully...");

                    String  query= "SELECT * FROM attendance";
                    ResultSet rst=st.executeQuery(query);

                StringBuilder result = new StringBuilder();
                while (rst.next()) {
                    int id = rst.getInt("id");
                    String name = rst.getString("name");
                    boolean at = rst.getBoolean("present");
                    String presents = at ? "present" : "absent";
                    String date = rst.getString("date");

                    result.append("Student ID: ").append(id).append(", Name: ").append(name).append(", Present: ").append(presents).append(", Date: ").append(date).append("\n");
                }

                txt.setText(result.toString());
                      st.close();
                      con.close();
            } catch (Exception E) {
                  E.printStackTrace();

            }

        }
    }
    public static void main(String[] args) {
         new GUI();
    }
}
