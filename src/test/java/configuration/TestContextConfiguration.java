package configuration;
import com.visual.nuts.challenge.service.PrinterService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestContextConfiguration {
    @Bean
    public PrinterService printerService() {
        return new PrinterService();
    }
}
