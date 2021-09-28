package ir.maktab.bankapp.repository.impl;

import ir.maktab.bankapp.base.repository.BaseRepositoryImpl;
import ir.maktab.bankapp.domain.Account;
import ir.maktab.bankapp.repository.AccountRepository;

import javax.persistence.EntityManager;

public class AccountRepositoryImpl extends BaseRepositoryImpl<Account, Long> implements AccountRepository {
    public AccountRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Account> getEntityClass() {
        return Account.class;
    }

}
