package com.location.tracker.gps_injestion_service.Service;

import org.live.location.tracker.DTO.LocationSnapshot;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private final KafkaTemplate<Long, LocationSnapshot> kafkaTemplate;

    KafkaService(KafkaTemplate<Long, LocationSnapshot> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, Long key, LocationSnapshot message) {
        kafkaTemplate.send(topic, key, message);
    }
}
