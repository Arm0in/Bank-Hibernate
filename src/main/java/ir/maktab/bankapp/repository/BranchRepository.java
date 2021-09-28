package ir.maktab.bankapp.repository;

import ir.maktab.bankapp.base.repository.BaseRepository;
import ir.maktab.bankapp.domain.Branch;

public interface BranchRepository extends BaseRepository<Branch, Long> {
    Branch getBranchByName(String branchName);
}
