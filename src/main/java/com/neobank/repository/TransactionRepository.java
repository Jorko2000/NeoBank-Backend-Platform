package com.neobank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.neobank.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {}
