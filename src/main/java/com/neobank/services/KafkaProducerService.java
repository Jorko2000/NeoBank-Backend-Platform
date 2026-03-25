package com.neobank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.neobank.dto.TransactionEvent;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, TransactionEvent> kafkaTemplate;

    public void sendTransaction(TransactionEvent event) {
        kafkaTemplate.send("transactions", event);
    }
}
