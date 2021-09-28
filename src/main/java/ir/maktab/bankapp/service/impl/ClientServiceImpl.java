package ir.maktab.bankapp.service.impl;

import ir.maktab.bankapp.base.service.impl.BaseServiceImpl;
import ir.maktab.bankapp.domain.Client;
import ir.maktab.bankapp.repository.ClientRepository;
import ir.maktab.bankapp.service.ClientService;
import ir.maktab.bankapp.util.SecurityContext;

public class ClientServiceImpl extends BaseServiceImpl<Client, Long, ClientRepository> implements ClientService {

    public ClientServiceImpl(ClientRepository repository) {
        super(repository);
    }

    @Override
    public Client getClientByUsername(String username) {
        return repository.getClientByUsername(username);
    }

    @Override
    public void authenticate(String username, String password) {
        Client client = getClientByUsername(username);
        if (client != null) {
            if (password.equals(client.getPassword())) {
                SecurityContext.setCurrentClient(client);
            } else {
                throw new RuntimeException("wrong password!!!");
            }
        } else {
            throw new RuntimeException("not found!!!");
        }
    }
}
