package se.iths.maria.emailservicegroup2.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    //denna klass talar om vilken k vi använder
    public static final String QUEUE_NAME = "order-queue";

    @Bean
    public Queue orderQueue() {
        return new Queue(QUEUE_NAME, true);
    }
    //true gör så att kön är kvar efter omstart
}
