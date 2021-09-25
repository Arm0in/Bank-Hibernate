package ir.maktab.bankapp.repository.impl;

import ir.maktab.bankapp.base.repository.BaseRepositoryImpl;
import ir.maktab.bankapp.domain.Client;
import ir.maktab.bankapp.repository.ClientRepository;

import javax.persistence.EntityManager;

public class ClientRepositoryImpl extends BaseRepositoryImpl<Client, Long> implements ClientRepository {
    public ClientRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Client> getEntityClass() {
        return Client.class;
    }

    @Override
    public Client getClientByUsername(String username) {
        return entityManager.createQuery(
                "from Client c where c.username = :username", Client.class
        ).setParameter("username", username).getSingleResult();
    }
}
