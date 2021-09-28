package ir.maktab.bankapp.service;

import ir.maktab.bankapp.base.service.BaseService;
import ir.maktab.bankapp.domain.Transaction;

public interface TransactionService extends BaseService<Transaction, Long> {
    Boolean validateTransaction(String sender, String receiver, Double amount);
}
