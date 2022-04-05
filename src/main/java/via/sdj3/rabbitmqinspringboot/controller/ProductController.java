package via.sdj3.rabbitmqinspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import via.sdj3.rabbitmqinspringboot.model.Product;
import via.sdj3.rabbitmqinspringboot.service.RabbitMQProducer;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private RabbitMQProducer producer;
    @PostMapping(value = "/add")
    public @ResponseBody String sendProduct(@RequestBody Product p){
        producer.produce(p);
        return p.toString();
    }
}
