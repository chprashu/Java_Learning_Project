package learn.RabbitMq;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import learn.configurations.commonBeans.RabbitMqConfig;

@Service
public class RabbitMqProducer {

    private final RabbitTemplate rabbitTemplate;

    private final Log log = LogFactory.getLog(RabbitMqProducer.class);

    public RabbitMqProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, RabbitMqConfig.ROUTING_KEY, message);
        log.info("Sent Message: " + message);
    }
}