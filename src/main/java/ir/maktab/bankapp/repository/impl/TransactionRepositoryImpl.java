package ir.maktab.bankapp.repository.impl;

import ir.maktab.bankapp.base.repository.BaseRepositoryImpl;
import ir.maktab.bankapp.domain.Transaction;
import ir.maktab.bankapp.repository.TransactionRepository;

import javax.persistence.EntityManager;

public class TransactionRepositoryImpl extends BaseRepositoryImpl<Transaction, Long> implements TransactionRepository {
    public TransactionRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Transaction> getEntityClass() {
        return Transaction.class;
    }

}
