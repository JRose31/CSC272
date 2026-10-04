// Converts text file into array of structured recipient data
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipientDatabase {

    public ArrayList<Recipient> loadRecipients()
            throws FileNotFoundException {

        ArrayList<Recipient> recipients = new ArrayList<>();

        // Identify path (problem with project structure not using relative path)
        File file = new File("C:\\Users\\jrose\\Desktop\\CSC272\\PersonalizedMailing\\data\\recipients.txt");
        Scanner scanner = new Scanner(file);

        // Skip header
        scanner.nextLine();

        // Read each recipient
        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            String[] fields = line.split("\\|");

            // Index known fields
            Recipient recipient = new Recipient(
                    fields[0],
                    fields[1],
                    fields[2],
                    fields[3],
                    fields[4],
                    fields[5]
            );

            recipients.add(recipient);
        }

        scanner.close();

        return recipients;
    }
}