import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class imagedb {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "sandip@123";

    public static void main(String[] args) throws IOException {
        try {
            String image_path = "C:\\Users\\HP VICTUS\\Downloads\\hehe.jpg";
            Connection connection = DriverManager.getConnection(url, username, password);
            FileInputStream fileInputStream = new FileInputStream(image_path);
            byte[] imagedata = new byte[fileInputStream.available()];
            fileInputStream.read(imagedata);
            String query = "INSERT INTO image_table(image_data) VALUES(?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBytes(1, imagedata);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Data is inserted!");
            } else {
                System.out.println("Data isn't inserted!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
