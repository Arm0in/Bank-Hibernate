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
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            List<Branch> branchList = ApplicationContext.getBranchService().findAll();
            System.out.println("*****WELCOME TO THE BANK OF MAKTAB*****");
            System.out.println("Select Bank Branch: ");
            for (int i = 0; i < branchList.size(); i++) {
                System.out.print(i + 1);
                System.out.println(". " + branchList.get(i).getBranchName());
            }
            System.out.println("0. Exit");
            Integer chosenItem = scanner.nextInt();
            scanner.nextLine();
            System.out.println("loooooooooooooool");
            if (chosenItem == 0) {
                if (Helper.check("Are you sure you want to Exit?"))
                    System.exit(0);
            } else {
                SecurityContext.setCurrentBranch(branchList.get(chosenItem - 1));
                new BranchMenu().run();
            }
        }
    }
}
