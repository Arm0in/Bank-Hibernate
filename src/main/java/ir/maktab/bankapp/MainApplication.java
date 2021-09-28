package ir.maktab.bankapp;

import com.github.javafaker.Faker;
import ir.maktab.bankapp.domain.*;
import ir.maktab.bankapp.domain.enumaration.AccountType;
import ir.maktab.bankapp.domain.enumaration.EmployeeType;
import ir.maktab.bankapp.util.ApplicationContext;
import ir.maktab.bankapp.view.MainMenu;

import java.time.LocalDate;
import java.time.ZoneId;

public class MainApplication {
    public static void main(String[] args) {
        enterFakeData();
        new MainMenu().run();
    }

    private static void enterFakeData() {
        Faker faker = new Faker();
        for (int i = 0; i < 5; i++) {
            ManagerEmployee manager = new ManagerEmployee();
            Branch branch = new Branch();
            branch.setBranchName(faker.funnyName().name());
            branch.setManager(manager);
            manager.setFirstname(faker.name().firstName());
            manager.setLastname(faker.name().lastName());
            manager.setBirthDate(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            manager.setEmail(faker.internet().emailAddress());
            manager.setCreatedDate(LocalDate.now());
            manager.setEmployeeType(EmployeeType.MANAGER);
            manager.setMobileNumber(faker.phoneNumber().phoneNumber());
            manager.setUsername(faker.name().username());
            manager.setPassword(faker.internet().password());
            manager.setBranch(branch);
            ApplicationContext.getBranchService().save(branch);
            ApplicationContext.getEmployeeService().save(manager);
            for (int j = 0; j < 5; j++) {
                Client client = new Client(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.name().username(),
                        faker.internet().password(),
                        faker.phoneNumber().phoneNumber(),
                        faker.internet().emailAddress(),
                        faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        LocalDate.now()
                );
                ApplicationContext.getClientService().save(client);
                for (int k = 0; k < 3; k++) {
                    Account account = new Account();
                    account.setAccountType(AccountType.typeOf(faker.number().numberBetween(0, 2)));
                    account.setBalance(faker.number().randomDouble(2, 0, 5000));
                    account.setCreatedDate(LocalDate.now());
                    account.setClient(client);
                    account.setBranch(branch);
                    account.setCard();
                    ApplicationContext.getAccountService().save(account);
                }
            }
        }


    }
}
