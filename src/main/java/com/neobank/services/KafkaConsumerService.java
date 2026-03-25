package com.neobank.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.neobank.dto.TransactionEvent;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "transactions", groupId = "bank-group")
    public void consume(TransactionEvent event) {
        System.out.println("Processed: " + event);
    }
}
