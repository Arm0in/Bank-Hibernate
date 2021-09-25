package ir.maktab.bankapp.util;


import ir.maktab.bankapp.domain.Branch;
import ir.maktab.bankapp.domain.Client;

public class SecurityContext {

    private static Client currentClient;

    private static Branch currentBranch;

    private SecurityContext() {
    }

    public static Branch getCurrentBranch() {
        return currentBranch;
    }

    public static void setCurrentBranch(Branch currentBranch) {
        SecurityContext.currentBranch = currentBranch;
    }

    public static void logout() {
        currentClient = null;
        currentBranch = null;
    }

    public static Client getCurrentClient() {
        return currentClient;
    }

    public static void setCurrentClient(Client user) {
        currentClient = user;
    }
}
