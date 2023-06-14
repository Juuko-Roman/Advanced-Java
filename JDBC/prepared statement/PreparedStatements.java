import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "mydb";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Create a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create the database
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
            System.out.println("Database created successfully");

            // Connect to the created database
            connection = DriverManager.getConnection(url + dbName, username, password);

            // Create a table
            statement = connection.createStatement();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS employees (id INT PRIMARY KEY, name VARCHAR(50), age INT)";
            statement.executeUpdate(createTableQuery);
            System.out.println("Table created successfully");

            // Prepare the INSERT statement
            String insertQuery = "INSERT INTO employees (id, name, age) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Insert data into the table using prepared statement
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "John Doe");
            preparedStatement.setInt(3, 30);
            preparedStatement.executeUpdate();

            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "Jane Smith");
            preparedStatement.setInt(3, 25);
            preparedStatement.executeUpdate();

            System.out.println("Data inserted successfully");

            // Prepare the SELECT statement
            String selectQuery = "SELECT * FROM employees";
            preparedStatement = connection.prepareStatement(selectQuery);

            // Execute the SELECT query
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Employee Data:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            // Close the resources
            resultSet.close();
            preparedStatement.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
