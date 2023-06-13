import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class Main {
    public static void main(String[] args) {
        FileInputStream file = null;
        try {
            file = new FileInputStream("file.txt");
            int data = file.read();
            // Perform some operations
            System.out.println("Data: " + data);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error occurred: " + e.getMessage());
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
            System.out.println("Finally block executed");
        }
    }
}
