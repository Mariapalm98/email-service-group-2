package se.iths.maria.emailservicegroup2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "se.iths.maria.emailservicegroup2",
        "se.iths.maria.springmessengers"
})
public class EmailServiceGroup2Application {

    public static void main(String[] args) {
        SpringApplication.run(EmailServiceGroup2Application.class, args);
    }

}
