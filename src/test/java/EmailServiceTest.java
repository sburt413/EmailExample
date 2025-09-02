import com.bsc.email.EmailService;
import com.bsc.email.client.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EmailServiceTest {
    static EmailService emailService;

    @BeforeAll
    public static void setup() {
        Client acme = new Client(1l, "ACME", "benefits@acme.com");
        emailService = new EmailService(acme);
    }

    @Test
    public void sendEmail_shouldSendEmail_whenGivenData() {
        emailService.send("1", "info@businessolver.com", "info@example.com", "<html>Email Body</html>");

        Assertions.assertFalse(emailService.getReport().emails.isEmpty());
    }
}
