// Supports execution of EMAIL method deliveries
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EmailDelivery implements DeliveryMethod {

    @Override
    public void deliver(
            Recipient recipient,
            String html,
            int id
    ) throws IOException {

        // Identify path (problem with project structure not using relative path)
        Path folder = Path.of("C:\\Users\\jrose\\Desktop\\CSC272\\PersonalizedMailing\\output\\email");


        Files.createDirectories(folder); // Ensures directory exist

        // Define filename and create with content
        Path file = folder.resolve(
                "mailing_" + id + ".html"
        );

        Files.writeString(file, html);

        System.out.println(
                "Email prepared for: " + recipient.getEmail()
        );
    }
}