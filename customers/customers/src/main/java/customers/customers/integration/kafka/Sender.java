package customers.customers.integration.kafka;

import customers.customers.service.DTOs.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, CustomerDTO> kafkaTemplate;

    @Value("${app.topic}")
    String topic;

    public void send(CustomerDTO customerDTO){
        kafkaTemplate.send(topic, customerDTO);
    }
}
