import java.sql.*;

public class JDBCExample {

      //use the two lines below in the getConnection method to create a connection to mydb database when its already created before
      // static final String DB_NAME = "mydb";
      // static final String DB_URL = "jdbc:mysql://localhost/"+DB_NAME;

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

            // Insert data into the table
            statement.executeUpdate("INSERT INTO employees (id, name, age) VALUES (1, 'John Doe', 30)");
            statement.executeUpdate("INSERT INTO employees (id, name, age) VALUES (2, 'Jane Smith', 25)");
            System.out.println("Data inserted successfully");

            // Execute a SELECT query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
            System.out.println("Employee Data:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            // Close the resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
