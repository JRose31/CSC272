// Defines DeliveryMethod requirements (args) to be used for both EMAIL and POSTAL
import java.io.IOException;

public interface DeliveryMethod {

    void deliver(
            Recipient recipient,
            String html,
            int id
    ) throws IOException;
}