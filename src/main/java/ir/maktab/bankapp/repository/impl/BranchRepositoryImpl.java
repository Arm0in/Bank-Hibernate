package ir.maktab.bankapp.repository.impl;

import ir.maktab.bankapp.base.repository.BaseRepositoryImpl;
import ir.maktab.bankapp.domain.Branch;
import ir.maktab.bankapp.repository.BranchRepository;

import javax.persistence.EntityManager;

public class BranchRepositoryImpl extends BaseRepositoryImpl<Branch, Long> implements BranchRepository {
    public BranchRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Branch> getEntityClass() {
        return Branch.class;
    }

    @Override
    public Branch getBranchByName(String branchName) {
        return entityManager.createQuery(
                "from Branch b where b.branchName = :branchName", Branch.class
        ).setParameter("branchName", branchName).getSingleResult();
    }
}
