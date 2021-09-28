package ir.maktab.bankapp.view;

import ir.maktab.bankapp.domain.Account;
import ir.maktab.bankapp.domain.Branch;
import ir.maktab.bankapp.domain.Client;
import ir.maktab.bankapp.domain.enumaration.AccountType;
import ir.maktab.bankapp.util.ApplicationContext;
import ir.maktab.bankapp.util.Helper;
import ir.maktab.bankapp.util.SecurityContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BranchMenu {
    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("*****WELCOME TO THE MAKTAB BANK BRANCH " + SecurityContext.getCurrentBranch().getBranchName() + " *****");
            System.out.println("1. Login(Client)");
            System.out.println("2. Register(Client)");
            System.out.println("3. Login(Employee)");
            System.out.println("0. Exit Branch");
            String chosenItem = scanner.nextLine();
            switch (chosenItem) {
                case "1":
                    System.out.println("Please enter your Username: ");
                    String username = scanner.nextLine();
                    System.out.println("Please enter your Password: ");
                    String password = scanner.nextLine();
                    try {
                        ApplicationContext.getClientService().authenticate(username, password);
                        new ClientMenu().run();
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    Client newClient = new Client();
                    Account newAccount = new Account();

                    System.out.println("Welcome, For the first time you have to create a bank Account, choose your account type:");
                    switch (Helper.choose(new String[]{"CURRENT", "SALARY", "SAVINGS"})) {
                        case 1:
                            newAccount.setAccountType(AccountType.CURRENT);
                            break;
                        case 2:
                            newAccount.setAccountType(AccountType.SALARY);
                            break;
                        case 3:
                            newAccount.setAccountType(AccountType.SAVINGS);
                            break;
                    }
                    newAccount.setCard();
                    newAccount.setCreatedDate(LocalDate.now());
                    newAccount.setBranch(SecurityContext.getCurrentBranch());
                    newAccount.setClient(newClient);

                    System.out.println("Enter your Firstname: ");
                    newClient.setFirstname(scanner.nextLine());

                    System.out.println("Enter your Lastname: ");
                    newClient.setLastname(scanner.nextLine());

                    System.out.println("Enter your Username: ");
                    newClient.setUsername(scanner.nextLine());

                    System.out.println("Enter your Password: ");
                    newClient.setPassword(scanner.nextLine());

                    System.out.println("Enter your Email: ");
                    newClient.setEmail(scanner.nextLine());

                    System.out.println("Please enter birthday yyyy-mm-dd: ");
                    String str = scanner.nextLine();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    newClient.setBirthDate(LocalDate.parse(str, dtf));

                    newClient.setCreatedDate(LocalDate.now());

                    System.out.println("Enter your Mobile Number: ");
                    newClient.setMobileNumber(scanner.nextLine());

                    ApplicationContext.getClientService().save(newClient);
                    ApplicationContext.getAccountService().save(newAccount);
                    System.out.println("Done! Your Pin Card is: " + newAccount.getCard().getPin() + " Change it in first login");
                    break;
                case "3":

                    break;
                case "0":
                    if (Helper.check("Are you sure you want to Exit Branch?"))
                        new MainMenu().run();
                    else
                        break;
                default:
                    System.out.println("Wrong!");
                    break;
            }
        }
    }
}
