package learn.RabbitMq;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import learn.configurations.commonBeans.RabbitMqConfig;

@Service
public class RabbitMqConsumer {

    private final Log log = LogFactory.getLog(RabbitMqConsumer.class);

    @RabbitListener(queues = RabbitMqConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        log.info("Received Message: " + message);
    }
}
