// Manages execution of delivery per method for all recipients
import java.io.IOException;
import java.util.ArrayList;

public class MailingService {

    public void processMailings()
            throws IOException {

        // Initialize database and load recipient details
        RecipientDatabase database = new RecipientDatabase();

        ArrayList<Recipient> recipients = database.loadRecipients();

        // Initialize template
        MailTemplate template = new MailTemplate();

        int id = 1;

        // Iterate through loaded recipients
        for (Recipient recipient : recipients) {

            // Generate formatted html for specific recipient
            String html = template.generate(recipient);

            // Define delivery method
            DeliveryMethod delivery;

            // Initialize corresponding delivery method
            if (recipient.getMethod()
                    .equalsIgnoreCase("EMAIL")) {

                delivery = new EmailDelivery();

            } else if (recipient.getMethod()
                    .equalsIgnoreCase("POSTAL")) {

                delivery = new PostalDelivery();

            } else {

                System.out.println(
                        "Unknown delivery method."
                );

                id++; // Increment ID
                continue;
            }

            // Perform delivery
            delivery.deliver(recipient, html, id);

            id++; // Increment ID
        }
    }
}