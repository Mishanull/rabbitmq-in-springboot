package via.sdj3.rabbitmqinspringboot.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import via.sdj3.rabbitmqinspringboot.model.Product;

@Service
public class RabbitMQProducer {
    private RabbitTemplate rabbitTemplate;
    private final String EXCHANGE="x.sdj3.product";
    private final String ROUTINGKEY="product.routingKey";

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public boolean produce(Product p){
        try{
            rabbitTemplate.convertAndSend(EXCHANGE,ROUTINGKEY,p);
            //logging
            System.out.println("Sent message ===> "+p);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
