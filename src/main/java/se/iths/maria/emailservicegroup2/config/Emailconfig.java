package se.iths.maria.emailservicegroup2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import se.iths.maria.springmessengers.EmailService;

@Configuration
public class Emailconfig {
    //en bean för emailService då emailService inte är anoterad med service
    //för använder mig av bibloteket spring-messengers så med bean vet spring att den ska använda EmailService
    @Bean
    public EmailService emailservice(JavaMailSender mailSender) {
        return new EmailService(mailSender);
    }
}
