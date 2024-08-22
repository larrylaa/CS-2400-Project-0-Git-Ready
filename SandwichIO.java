import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SandwichIO {
    public static void writeOrderToFile(Order order) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("orderline.txt", true));
            writer.write(order.printOrder());
            writer.newLine(); 
            writer.close(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// LARRY LA - CS 1400 - FINAL PROJECT