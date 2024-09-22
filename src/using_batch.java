import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class using_batch {
    private static final String url= "jdbc:mysql://localhost:3306/mydb";
    private static final String username="root";
    private static final String password="sandip@123";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Scanner scanner= new Scanner(System.in);
            String  query= "INSERT INTO  learners (name, age, marks) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            while(true) {
                System.out.print("Enter Name:");
                String name= scanner.next();
                System.out.print("Enter age:");
                int age= scanner.nextInt();
                System.out.print("Enter marks:");
                double marks= scanner.nextDouble();
                System.out.println("Enter more data(Y/N): ");
                String  choice= scanner.next();
                preparedStatement.setString(1,name);
                preparedStatement.setInt(2,age);
                preparedStatement.setDouble(3,marks);
                preparedStatement.addBatch();
                if(choice.toUpperCase().equals("N")){
                    break;
                }
            }
            int[] arr= preparedStatement.executeBatch();
            for(int i=0;i<arr.length;i++){
                if(arr[i]==0){
                    System.out.println("Query " + i + " is not excuted successfully");
                }
            }


//connection.autocommit(false) : to disable autocommit the transaction
// connection.rollback(): if any error occurs in transaction then it will maintain the exact same situation as  before


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
