package ir.maktab.bankapp.util;


import ir.maktab.bankapp.repository.*;
import ir.maktab.bankapp.repository.impl.*;
import ir.maktab.bankapp.service.*;
import ir.maktab.bankapp.service.impl.*;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final AccountRepository ACCOUNT_REPOSITORY;
    private static final AccountService ACCOUNT_SERVICE;

    private static final BranchRepository BRANCH_REPOSITORY;
    private static final BranchService BRANCH_SERVICE;

    private static final CardRepository CARD_REPOSITORY;
    private static final CardService CARD_SERVICE;

    private static final ClientRepository CLIENT_REPOSITORY;
    private static final ClientService CLIENT_SERVICE;

    private static final EmployeeRepository EMPLOYEE_REPOSITORY;
    private static final EmployeeService EMPLOYEE_SERVICE;

    private static final TransactionRepository TRANSACTION_REPOSITORY;
    private static final TransactionService TRANSACTION_SERVICE;

    static {
        EntityManager entityManager = HibernateUtil.getMainEntityMangerFactory().createEntityManager();

        ACCOUNT_REPOSITORY = new AccountRepositoryImpl(entityManager);
        ACCOUNT_SERVICE = new AccountServiceImpl(ACCOUNT_REPOSITORY);

        BRANCH_REPOSITORY = new BranchRepositoryImpl(entityManager);
        BRANCH_SERVICE = new BranchServiceImpl(BRANCH_REPOSITORY);

        CARD_REPOSITORY = new CardRepositoryImpl(entityManager);
        CARD_SERVICE = new CardServiceImpl(CARD_REPOSITORY);

        CLIENT_REPOSITORY = new ClientRepositoryImpl(entityManager);
        CLIENT_SERVICE = new ClientServiceImpl(CLIENT_REPOSITORY);

        EMPLOYEE_REPOSITORY = new EmployeeRepositoryImpl(entityManager);
        EMPLOYEE_SERVICE = new EmployeeServiceImpl(EMPLOYEE_REPOSITORY);

        TRANSACTION_REPOSITORY = new TransactionRepositoryImpl(entityManager);
        TRANSACTION_SERVICE = new TransactionServiceImpl(TRANSACTION_REPOSITORY);

    }

    private ApplicationContext() {
    }

    public static AccountRepository getAccountRepository() {
        return ACCOUNT_REPOSITORY;
    }

    public static AccountService getAccountService() {
        return ACCOUNT_SERVICE;
    }

    public static BranchRepository getBranchRepository() {
        return BRANCH_REPOSITORY;
    }

    public static BranchService getBranchService() {
        return BRANCH_SERVICE;
    }

    public static CardRepository getCardRepository() {
        return CARD_REPOSITORY;
    }

    public static CardService getCardService() {
        return CARD_SERVICE;
    }

    public static ClientRepository getClientRepository() {
        return CLIENT_REPOSITORY;
    }

    public static ClientService getClientService() {
        return CLIENT_SERVICE;
    }

    public static EmployeeRepository getEmployeeRepository() {
        return EMPLOYEE_REPOSITORY;
    }

    public static EmployeeService getEmployeeService() {
        return EMPLOYEE_SERVICE;
    }

    public static TransactionRepository getTransactionRepository() {
        return TRANSACTION_REPOSITORY;
    }

    public static TransactionService getTransactionService() {
        return TRANSACTION_SERVICE;
    }
}
