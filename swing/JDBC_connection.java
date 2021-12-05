package swing;

import java.sql.*;
import java.util.*;

// Main class
class Main {

    public static void main(String[] a) throws SQLException {

        // Creating the connection using MySQL
        // Note: url syntax is standard, so do grasp
        String url = "jdbc:mysql://localhost:3306/me";

        // Username and password to access DB Custom initialization
        String user = "root";
        String pass = "aman4Git";

        // Entering the data
        Scanner k = new Scanner(System.in);

        System.out.println("enter roll no");
        int roll = k.nextInt();

        System.out.println("enter name");
        String name = k.next();

        System.out.println("enter class");
        int cls = k.nextInt();

        // Inserting data using SQL query
        String sql = "insert into student1 values('" + roll + "','" +  name +  "','"  + cls + "')";

        // Connection class object
        Connection con = DriverManager.getConnection(url,user,pass);

        // Try block to check for exceptions
        try {

            Driver d = new com.mysql.cj.jdbc.Driver();
            // Registering drivers
            DriverManager.registerDriver(d);

            // Reference to connection interface
            con = DriverManager.getConnection(url, user, pass);

            // Creating a statement
            Statement st = con.createStatement();
            int m = st.executeUpdate(sql);
            ResultSet rs = st.executeQuery("select * from student1");

            while(rs.next()){
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
            }

             // Executing query
            if (m == 1)
                System.out.println("inserted successfully : " + sql);
            else
                System.out.println("insertion failed");

            // Closing the connections
            con.close();
        }

        // Catch block to handle exceptions
        catch (Exception ex) {
            // Display message when exceptions occur
            System.err.println(ex);
        }
    }
}
