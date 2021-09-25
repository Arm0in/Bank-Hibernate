package ir.maktab.bankapp.service.impl;

import ir.maktab.bankapp.base.service.impl.BaseServiceImpl;
import ir.maktab.bankapp.domain.Branch;
import ir.maktab.bankapp.repository.BranchRepository;
import ir.maktab.bankapp.service.BranchService;

public class BranchServiceImpl extends BaseServiceImpl<Branch, Long, BranchRepository> implements BranchService {

    public BranchServiceImpl(BranchRepository repository) {
        super(repository);
    }

    @Override
    public Branch getBranchByName(String branchName) {
        return repository.getBranchByName(branchName);
    }
}
