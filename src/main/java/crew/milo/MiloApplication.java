package crew.milo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(dateTimeProviderRef = "offSetDateTimeProvider")
@SpringBootApplication
public class MiloApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiloApplication.class, args);
    }

}
