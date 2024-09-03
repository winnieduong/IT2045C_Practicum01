import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        int choice = chooser.showOpenDialog(null);

        if (choice == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile()))) {
                String line;

                System.out.printf("%-10s %-20s %-30s %-10s%n", "ID", "Name", "Description", "Cost");
                System.out.println("===============================================================");

                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(", ");
                    System.out.printf("%-10s %-20s %-30s %-10.2f%n", data[0], data[1], data[2], Double.parseDouble(data[3]));
                }
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        }
    }
}
