    package peaksoft.dao;


    import jakarta.persistence.EntityManager;
    import jakarta.persistence.EntityManagerFactory;
    import peaksoft.model.User;
    import peaksoft.util.Util;

    import java.util.List;

    public class UserDaoHibernateImpl implements UserDao {

        EntityManagerFactory entityManagerFactory = Util.entityManagerFactory();
        public UserDaoHibernateImpl() {

        }

        @Override
        public void createUsersTable() {

        }

        @Override
        public void dropUsersTable() {

        }

        @Override
        public void saveUser(String name, String lastName, byte age) {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(new User(name,lastName,age));
            entityManager.getTransaction().commit();
            entityManager.close();
        }

    @Override
    public void removeUserById(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(id);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<User> users = entityManager.createQuery("select u from User u ", User.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return users;
    }

    @Override
    public void cleanUsersTable() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<User> allUsers = getAllUsers();
        for (User allUser : allUsers) {
            entityManager.remove(allUser);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
