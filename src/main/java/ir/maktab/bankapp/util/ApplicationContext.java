package ir.maktab.bankapp.util;


import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final UserRepository userRepository;
    private static final UserService userService;

    static {
        EntityManager entityManager = HibernateUtil.getMainEntityMangerFactory().createEntityManager();

        userRepository = new UserRepositoryImpl(entityManager);
        userService = new UserServiceImpl(userRepository);

    }

    private ApplicationContext() {
    }

    public static UserRepository getUserRepository() {
        return userRepository;
    }

    public static UserService getUserService() {
        return userService;
    }

}
