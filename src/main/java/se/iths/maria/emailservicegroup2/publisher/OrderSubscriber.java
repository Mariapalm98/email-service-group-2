package se.iths.maria.emailservicegroup2.publisher;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import se.iths.maria.emailservicegroup2.config.RabbitMQConfig;
import se.iths.maria.emailservicegroup2.model.OrderItem;
import se.iths.maria.emailservicegroup2.model.OrderResponse;
import se.iths.maria.springmessengers.EmailService;

@Component
public class OrderSubscriber {

    private final EmailService emailService;

    public OrderSubscriber(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void handleOrderItem(OrderResponse orderResponse) {
        String subject = "Orderbekräftelse";
        String body = buildEmail(orderResponse);
        System.out.println(subject);
        System.out.println("Mejl skickat till " + orderResponse.getCustomerName());
        System.out.println(body);
        //emailService.sendEmail(orderMail.getCustomerName(), subject, body);
    }

    private String buildEmail(OrderResponse orderResponse) {
        String body = "Hej " + orderResponse.getCustomerName() + "\n\n";
        body += "Din order:\n";
        for (OrderItem item : orderResponse.getItems()) {
            body += item.getName() + " antal: " + item.getQuantity() + " Pris: " + item.getPrice() + "kr\n";
        }
        body += "\nTotalpris: " + orderResponse.getTotalPrice() + "kr";
        return body;
    }
}
