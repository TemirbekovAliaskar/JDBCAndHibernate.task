package peaksoft;

import jakarta.persistence.EntityManagerFactory;
import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь


//        EntityManagerFactory entityManagerFactory = Util.entityManagerFactory();
        UserService userService = new UserServiceImpl();
//        userService.saveUser("Jigit","Turumbekov",(byte) 39);
//        userService.saveUser("Urmat","Toichikov",(byte) 45);
//        userService.saveUser("Kim","Asuva",(byte) 12);
//        userService.removeUserById(1L);
//        System.out.println( userService.getAllUsers());
        userService.cleanUsersTable();




    }
}
