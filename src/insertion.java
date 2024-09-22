import javax.print.DocFlavor;
import java.sql.*;
import  java.util.*;

public class insertion {
    private static final String url= "jdbc:mysql://localhost:3306/mydb";
    private static final String username="root";
    private static final String password="sandip@123";



    public static void main(String[] args) {
        try {
            // Ensure that the JDBC driver is loaded by your IDE or in your classpath
            // Class.forName("com.mysql.cj.jdbc.Driver"); // Uncomment if necessary

            // Corrected the JDBC URL and added proper string delimiters
            try
            {
                Connection obj = DriverManager.getConnection(url, username, password);
                //Statement statement =  obj.createStatement();
            //  String query = "INSERT INTO learners (name, age, marks) VALUES (?,?,?)";//Insertion query
                String query = "UPDATE learners SET marks=? WHERE id = ?";//updation query
              //  String query = "DELETE FROM  learners WHERE  id =2";//deletion query:

                PreparedStatement preparedStatement = obj.prepareStatement(query);
                //preparedStatement.setString(1,"hari");
                preparedStatement.setDouble(1,68.93);
                preparedStatement.setInt(2,3);
                int rowaffected = preparedStatement.executeUpdate();//execute update is used in insertion
                 if(rowaffected>0){
                     System.out.println("Date Inserted succesfully:");
                 }else{
                     System.out.println("Date not Inserted!");
                 }

            }catch (SQLException e){
                e.printStackTrace();
            }
            // Indicate successful connection (optional)
            //
            //  System.out.println("Database connection successful");

        } catch (Exception e) {
            // Print the exception to understand the specific error
            System.out.println("Error: " + e.getMessage());
            //   e.printStackTrace();//It is a method of Java's throwable class which prints the throwable along with other details like the line number and class name where the exception occurred.
        }
    }
}

