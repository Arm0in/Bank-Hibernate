package ir.maktab.bankapp.domain.enumaration;

import java.util.HashMap;
import java.util.Map;

public enum AccountType {
    CURRENT(0), SALARY(1), SAVINGS(2);
    private int index;
    private static Map map = new HashMap<>();
    static {
        for (AccountType type :
                AccountType.values()) {
            map.put(type.index, type);
        }
    }
    AccountType (int index) {
        this.index = index;
    }

    public static AccountType typeOf(int index) {
        return (AccountType) map.get(index);
    }
}
