package ir.maktab.bankapp.service;

import ir.maktab.bankapp.base.service.BaseService;
import ir.maktab.bankapp.domain.Client;

public interface ClientService extends BaseService<Client, Long> {
    Client getClientByUsername(String username);
    void authenticate(String username, String password);
}
