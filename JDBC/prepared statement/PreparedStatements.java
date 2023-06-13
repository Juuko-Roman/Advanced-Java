import java.sql.*;

public class PreparedStatements {
    public static void main(String[] args) throws ClassNotFoundException{
        String jdbcUrl = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "";
        
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Prepare the SQL statement with parameters
            String sql = "SELECT * FROM customers WHERE age > ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            // Set the parameter value
            int ageLimit = 30;
            statement.setInt(1, ageLimit);
            
            // Execute the query
            ResultSet resultSet = statement.executeQuery();
            
            // Process the query results
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }
            
            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
