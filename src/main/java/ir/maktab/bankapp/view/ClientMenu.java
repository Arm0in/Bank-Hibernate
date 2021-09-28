package ir.maktab.bankapp.view;

import ir.maktab.bankapp.domain.Account;
import ir.maktab.bankapp.domain.Card;
import ir.maktab.bankapp.domain.Client;
import ir.maktab.bankapp.domain.Transaction;
import ir.maktab.bankapp.domain.enumaration.AccountType;
import ir.maktab.bankapp.service.AccountService;
import ir.maktab.bankapp.service.CardService;
import ir.maktab.bankapp.service.TransactionService;
import ir.maktab.bankapp.util.ApplicationContext;
import ir.maktab.bankapp.util.Helper;
import ir.maktab.bankapp.util.SecurityContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ClientMenu {
    public void run() {
        Client currentClient = SecurityContext.getCurrentClient();
        AccountService accountService = ApplicationContext.getAccountService();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("*****" + currentClient.getFirstname() + " " + currentClient.getLastname() + "'s Profile*****");
            System.out.println("1. Create Account");
            System.out.println("2. Edit Account");
            System.out.println("3. Delete Account");
            System.out.println("4. View All Accounts");
            System.out.println("5. Edit Personal Info");
            System.out.println("6. Transfer Money");
            System.out.println("0. Logout");
            String chosenItem = scanner.nextLine();
            switch (chosenItem) {
                case "1":
                    Account newAccount = new Account();
                    System.out.println("Choose your account type:");
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
                    newAccount.setClient(currentClient);
                    accountService.save(newAccount);
                    System.out.println("Done!");
                    break;
                case "2":
//                    String[] accounts = accountService.findAll().stream().map(Account::toString).toArray(String[]::new);
                    List<Account> accountList = accountService.findAll();
                    for (int i = 0; i < accountList.size(); i++) {
                        System.out.print(i + 1);
                        System.out.println(". " + accountList.get(i));
                    }
                    int accountIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    Account selectedAccount = accountList.get(accountIndex);
                    System.out.println("1. Edit Account Type");
                    System.out.println("2. Edit Branch");
                    System.out.println("3. Edit Pin Card");
                    System.out.println("0. Back");
                    String item = scanner.nextLine();
                    switch (item) {
                        case "1":
                            System.out.println("Choose your account type:");
                            switch (Helper.choose(new String[]{"CURRENT", "SALARY", "SAVINGS"})) {
                                case 1:
                                    selectedAccount.setAccountType(AccountType.CURRENT);
                                    break;
                                case 2:
                                    selectedAccount.setAccountType(AccountType.SALARY);
                                    break;
                                case 3:
                                    selectedAccount.setAccountType(AccountType.SAVINGS);
                                    break;
                            }
                            break;
                        case "2":
                            System.out.println("Enter Branch name: ");
                            selectedAccount.setBranch(ApplicationContext.getBranchService().getBranchByName(scanner.nextLine()));
                            break;
                        case "3":
                            System.out.println("Enter Old Pin: ");
                            if (selectedAccount.getCard().getPin().equals(scanner.nextLine())) {
                                System.out.println("Enter New Pin: ");
                                selectedAccount.getCard().setPin(scanner.nextLine());
                            } else {
                                System.out.println("Wrong Pin!");
                            }
                            break;
                        case "0":
                    }
                    accountService.save(selectedAccount);
                    break;
                case "3":
                    System.out.println(accountService.findAll());
                    Long idToDelete = scanner.nextLong();
                    scanner.nextLine();
                    if (Helper.check("Are you sure want to Delete?"))
                        accountService.delete(accountService.findById(idToDelete));
                    System.out.println("Done!");
                    break;
                case "4":
                    System.out.println(accountService.findAll());
                    break;
                case "5":
                    editInfo();
                    break;
                case "6":
                    transferMoney();
                    break;
                case "0":
                    if (Helper.check("Are you sure you want to Logout?")) {
                        SecurityContext.logout();

                        new MainMenu().run();
                    } else
                        break;
                default:
                    System.out.println("Wrong!");
                    break;
            }
        }
    }

    private void transferMoney() {
        CardService cardService = ApplicationContext.getCardService();
        TransactionService transactionService = ApplicationContext.getTransactionService();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter Sender Card Number: ");
            String senderCardNumber = scanner.nextLine();
            Card sender = cardService.getCardByNumber(senderCardNumber);
            System.out.println("Enter Receiver Card Number: ");
            String receiverCardNumber = scanner.nextLine();
            Card receiver = cardService.getCardByNumber(receiverCardNumber);
            System.out.println("Enter Amount to transfer: ");
            Double amount = scanner.nextDouble();
            scanner.nextLine();
            transactionService.validateTransaction(senderCardNumber, receiverCardNumber, amount);
            try {
                System.out.println("Enter pin: ");
                String pin = scanner.nextLine();
                System.out.println("Enter expire Date: ");
                String str = scanner.nextLine();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate expireDate = LocalDate.parse(str, dtf);
                System.out.println("Enter CVV: ");
                String cvv = scanner.nextLine();
                cardService.authenticatePin(senderCardNumber, pin, expireDate, cvv);
                transactionService.save(new Transaction(amount, sender, receiver));
                sender.getAccount().setBalance(sender.getAccount().getBalance() - amount - Transaction.FEE);
                receiver.getAccount().setBalance(receiver.getAccount().getBalance() + amount);
                cardService.save(sender);
                cardService.save(receiver);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    private void editInfo() {
        System.out.println("1. Edit Email");
        System.out.println("2. Edit Password");
        System.out.println("0. Back");
        Scanner scanner = new Scanner(System.in);
        String chosenItem = scanner.nextLine();
        switch (chosenItem) {
            case "1":
                System.out.println("Enter new email: ");
                SecurityContext.getCurrentClient().setEmail(scanner.nextLine());
                break;
            case "2":
                System.out.println("Enter new password: ");
                SecurityContext.getCurrentClient().setPassword(scanner.nextLine());
                break;
            case "0":
        }

    }
}
