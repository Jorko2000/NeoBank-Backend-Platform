package com.neobank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.neobank.repository.*;
import com.neobank.model.*;

@Service
@RequiredArgsConstructor
public class BankingService {

    private final AccountRepository accountRepo;
    private final TransactionRepository transactionRepo;
    private final KafkaProducerService kafkaProducer;

    public String transfer(Long fromId, Long toId, double amount) {

        Account from = accountRepo.findById(fromId).orElseThrow();
        Account to = accountRepo.findById(toId).orElseThrow();

        if (from.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        accountRepo.save(from);
        accountRepo.save(to);

        Transaction tx = new Transaction();
        tx.setAmount(amount);
        tx.setFromAccount(from);
        tx.setToAccount(to);

        transactionRepo.save(tx);

        kafkaProducer.sendTransaction(
            new TransactionEvent(fromId, toId, amount)
        );

        return "Transfer successful";
    }
}
