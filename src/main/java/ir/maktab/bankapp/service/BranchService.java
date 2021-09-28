package ir.maktab.bankapp.service;

import ir.maktab.bankapp.base.service.BaseService;
import ir.maktab.bankapp.domain.Branch;

public interface BranchService extends BaseService<Branch, Long> {
    Branch getBranchByName(String branchName);
}
