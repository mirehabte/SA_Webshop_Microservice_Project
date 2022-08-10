package products.products.integration.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import products.products.service.DTOs.ProductDTO;

@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, ProductDTO> kafkaTemplate;

    @Value("${app.topic}")
    String topic;

    public void send(ProductDTO productDTO){
        kafkaTemplate.send(topic, productDTO);
    }
}
