// Safely compiles the mailing template from the template.html as string
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MailTemplate {

    public String generate(Recipient recipient)
            throws FileNotFoundException {

        // Identify path (problem with project structure not using relative path)
        File file = new File("C:\\Users\\jrose\\Desktop\\CSC272\\PersonalizedMailing\\data\\template.html");

        // Initialize scanner to read file for string extraction and manipulation
        Scanner scanner = new Scanner(file);

        String html = "";

        // Compile string from html
        while (scanner.hasNextLine()) {
            html += scanner.nextLine() + "\n";
        }

        scanner.close();

        // Perform replacements of templated elements
        html = html.replace("[Title]",
                escapeHtml(recipient.getTitle())
        );

        html = html.replace("[LastName]",
                escapeHtml(recipient.getLastName())
        );

        html = html.replace("[FirstName]",
                escapeHtml(recipient.getFirstName())
        );

        return html;
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