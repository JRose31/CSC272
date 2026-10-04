// Supports execution of POSTAL method deliveries
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PostalDelivery implements DeliveryMethod {

    @Override
    public void deliver(
            Recipient recipient,
            String html,
            int id
    ) throws IOException {

        // Identify path (problem with project structure not using relative path)
        Path folder = Path.of("C:\\Users\\jrose\\Desktop\\CSC272\\PersonalizedMailing\\output\\postal");

        Files.createDirectories(folder); // Ensures directory exist

        Path file = folder.resolve(
                "mailing_" + id + ".html"
        );

        // Compile details
        String name = recipient.getTitle() + " " +
                recipient.getFirstName() + " " +
                recipient.getLastName();

        String address = recipient.getAddress();

        name = escapeHtml(name);
        address = escapeHtml(address);

        // Insert recipient details (insert proper header for postal)
        String postalHtml = html.replace(
                "<body>",
                "<body>\n<address>" +
                        name + "<br>" +
                        address +
                        "</address><hr>"
        );

        // Create file with content
        Files.writeString(file, postalHtml);

        System.out.println(
                "Postal letter prepared for: " +
                        recipient.getLastName()
        );
    }

    // Ensure valid HTML
    private String escapeHtml(String value) {
        return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}