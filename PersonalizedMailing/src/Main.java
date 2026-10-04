// Run the application/program
import java.io.IOException;  // catch errors (error handling)

public class Main {

    public static void main(String[] args)
            throws IOException {

        // Initialize the mailing service
        MailingService service =
                new MailingService();

        // Process mail
        service.processMailings();
    }
}