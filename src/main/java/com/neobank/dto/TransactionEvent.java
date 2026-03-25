package com.neobank.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEvent {
    private Long fromAccount;
    private Long toAccount;
    private double amount;
}
