package se.iths.maria.emailservicegroup2.publisher;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import se.iths.maria.emailservicegroup2.config.RabbitMQConfig;
import se.iths.maria.emailservicegroup2.model.OrderItem;
import se.iths.maria.emailservicegroup2.model.OrderMail;
import se.iths.maria.springmessengers.EmailService;

@Component
public class OrderSubscriber {

    private final EmailService emailService;

    public OrderSubscriber(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void handleOrder(OrderMail orderMail) {
        String subject = "Orderbekräftelse";
        String body = buildEmail(orderMail);
        emailService.sendEmail(orderMail.getCustomerEmail(), subject, body);
    }

    private String buildEmail(OrderMail orderMail) {
        String body = "Hej " + orderMail.getCustomerName() + "\n\n";
        body += "Din order:\n";
        for (OrderItem item : orderMail.getItems()) {
            body += item.getName() + " antal: " + item.getQuantity() + " Pris: " + item.getPrice() + "kr\n";
        }
        body += "\nTotalpris: " + orderMail.getTotalPrice() + "kr";
        return body;
    }
}
