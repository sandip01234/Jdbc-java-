import javax.print.DocFlavor;
import java.sql.*;
import  java.util.*;

public class databasecon {
    private static final String url= "jdbc:mysql://localhost:3306/{your database name}";
    private static final String username="{Your username}";
    private static final String password="{your password}";



    public static void main(String[] args)  {
        try {
            // Ensure that the JDBC driver is loaded by your IDE or in your classpath
            // Class.forName("com.mysql.cj.jdbc.Driver"); // Uncomment if necessary

            // Corrected the JDBC URL and added proper string delimiters
           try
           {
               Connection obj = DriverManager.getConnection(url, username, password);
               String query = " select * from learners";
               PreparedStatement preparedStatement =  obj.prepareStatement(query);
             //  preparedStatement.setInt(1,1);
              ResultSet resultSet = preparedStatement.executeQuery();//executeQuery is used in getting all the data:
               while (resultSet.next()){
                   int id= resultSet.getInt("id");
                   String name = resultSet.getString("name");
                   int age= resultSet.getInt("age");
                   double marks= resultSet.getDouble("marks");
                   System.out.println("ID :"+ id);
                   System.out.println("Name :"+ name);
                   System.out.println("Age :"+ age);
                   System.out.println("Marks :"+ marks);
                   System.out.println("-------------------------------------------");
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
}//show databases;
// use database_name;
// describe learners(table_name);


