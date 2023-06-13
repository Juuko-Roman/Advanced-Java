import java.sql.*;
public class Jdbc {
   static final String DB_NAME = "mydb";
   static final String DB_URL = "jdbc:mysql://localhost/"+DB_NAME;
   static final String USER = "root";
   static final String PASS = "";
   static final String QUERY = "SELECT id, first, last, age FROM Employees";

   public static void main(String[] args)throws ClassNotFoundException {
      // Open a connection

      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);) {
         Class.forName("com.mysql.cj.jdbc.Driver");

         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            System.out.println("\nID: " + rs.getInt("id"));
            System.out.println("Age: " + rs.getInt("age"));
            System.out.println("First: " + rs.getString("first"));
            System.out.println("Last: " + rs.getString("last")+"\n");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}