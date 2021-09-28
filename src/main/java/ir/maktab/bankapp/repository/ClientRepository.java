package ir.maktab.bankapp.repository;

import ir.maktab.bankapp.base.repository.BaseRepository;
import ir.maktab.bankapp.domain.Client;

public interface ClientRepository extends BaseRepository<Client, Long> {
    Client getClientByUsername(String username);
}
