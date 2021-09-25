package ir.maktab.bankapp.service.impl;

import ir.maktab.bankapp.base.service.impl.BaseServiceImpl;
import ir.maktab.bankapp.domain.Account;
import ir.maktab.bankapp.repository.AccountRepository;
import ir.maktab.bankapp.service.AccountService;

public class AccountServiceImpl extends BaseServiceImpl<Account, Long, AccountRepository> implements AccountService {

    public AccountServiceImpl(AccountRepository repository) {
        super(repository);
    }

}
