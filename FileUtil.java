package Metro;

import java.io.*;
import java.util.List;

public class FileUtil {

    public static void saveTickets(List<Ticket> tickets) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("tickets.dat"))) {
            oos.writeObject(tickets);
        } catch (IOException e) {
            System.out.println("Error saving tickets.");
        }
    }

    public static List<Ticket> loadTickets() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("tickets.dat"))) {
            return (List<Ticket>) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }
}
