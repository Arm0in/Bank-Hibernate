package ir.maktab.bankapp.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static final EntityManagerFactory mainEntityMangerFactory;


    static {
        mainEntityMangerFactory = Persistence.createEntityManagerFactory("bankapp");

    }

    public static EntityManagerFactory getMainEntityMangerFactory() {
        return mainEntityMangerFactory;
    }

}
