package org.june.hackathon;

import org.hibernate.Session;
import org.june.hackathon.util.HibernatePersistence;


/**
 * Created by anshu on 5/6/16.
 */
public class Main {
    public static void main( String[] args )
    {
        Session session = HibernatePersistence.getSessionFactory().openSession();

        session.beginTransaction();
        Users user = new Users();

        //user.setUserId(2);
        user.setEmailAddress("anshu.kumar1@here.com");
        user.setisLoggedIn(true);
        user.setPassword("welcome");
        user.setUserName("8884210007");
        user.setTelephone("8884210007");

        //Save product to database
        Integer userId =(Integer) session.save(user);
        session.getTransaction().commit();

        //get data from  database
        user = (Users) session.get(Users.class, userId);
        System.out.println(user);

        //close session
        HibernatePersistence.shutdown();
    }
}
