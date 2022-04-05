package via.sdj3.rabbitmqinspringboot.config;


import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    @Bean
    public Exchange productExchange(){
        return new DirectExchange("x.sdj3.product");
    }
    @Bean
    public Queue productQueue(){
        return new Queue("q.sdj3.product");
    }
    @Bean
    public Binding binding(){
        return BindingBuilder.
                bind(productQueue()).
                to(productExchange()).
                with("product.routingKey").noargs();
    }
    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
