package ir.maktab.bankapp.util;

import java.util.Scanner;

public class Helper {

    public static boolean check(String question) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(question + " (y/n)");
            char chosenItem = scanner.nextLine().charAt(0);
            switch (chosenItem) {
                case 'y':
                    scanner.close();
                    return true;
                case 'n':
                    scanner.close();
                    return false;
                default:
                    System.out.println("Wrong!");
                    break;
            }
        }
    }

    public static String inputString(String msg) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();

        }
    }

    public static Integer choose(String[] choices) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=================================");
            for (int i = 0; i < choices.length; i++) {
                System.out.print(i + 1);
                System.out.println(choices[i]);
            }
            if (scanner.hasNextInt())
                return scanner.nextInt();
        }
    }

}
