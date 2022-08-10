package payments.payments.integration.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import payments.payments.service.DTOs.PaymentDTO;


@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, PaymentDTO> kafkaTemplate;

    @Value("${app.topic}")
    String topic;

    public void send(PaymentDTO paymentDTO){
        kafkaTemplate.send(topic, paymentDTO);
    }
}
