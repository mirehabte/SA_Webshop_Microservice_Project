package ordersCommand.ordersCommand.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, OrderDTO> kafkaTemplate;

    @Value("${app.topic}")
    String topic;
    @Value("${app.deleteTopic}")
    String deleteTopic;

    public void send(OrderDTO orderDTO){
        kafkaTemplate.send(topic, orderDTO);
    }
    public void sendDeleteOrder(OrderDTO orderDTO) {
        kafkaTemplate.send(deleteTopic, orderDTO);
    }
}
