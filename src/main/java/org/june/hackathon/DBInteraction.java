package org.june.hackathon;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.june.hackathon.util.HibernatePersistence;

import java.util.ArrayList;

/**
 * Created by anshu on 5/6/16.
 */
public class DBInteraction {

    public Users fetchUser(String userName){
        Session session = HibernatePersistence.getSessionFactory().openSession();
        String hql = "From Users U where U.userName = '"+ userName + "'";
        Query query = session.createQuery(hql);
        if(query.list().size() > 0)
            return (Users)query.list().get(0);
        else
            return new Users();

    }

    public ArrayList<String> fetchOnlineUsers(){
        Session session = HibernatePersistence.getSessionFactory().openSession();
        String hql = "SELECT U.userName from Users U where logged_in = 't'";
        Query query = session.createQuery(hql);
        ArrayList<String> users = (ArrayList<String>) query.list();
        //HibernatePersistence.shutdown();
        return users;
    }

    public int logoutUser(String userName){
        Session session = HibernatePersistence.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "UPDATE Users U set logged_in = 'f' "  +
                "WHERE U.userName = '"+ userName + "'";
        Query query = session.createQuery(hql);
        int result = query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;

    }

    public int loginUser(String userName){
        Session session = HibernatePersistence.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "UPDATE Users U set logged_in = 't' "  +
                "WHERE U.userName = '"+ userName + "'";
        Query query = session.createQuery(hql);
        int result = query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;

    }

    public Boolean authenticateUser(String userName, String password){
        Session session = HibernatePersistence.getSessionFactory().openSession();
        String hql = "FROM Users where userName = '" + userName +
                "' and password = '"+ password + "'";
        Query query = session.createQuery(hql);
        return query.list().size() > 0 ;

    }

    public String registerUser(Users user){
        Session session = HibernatePersistence.getSessionFactory().openSession();
        session.beginTransaction();
        Integer userId =(Integer) session.save(user);
        session.getTransaction().commit();
        session.close();
        return userId.toString();
    }

    public Vehicles getVehicles(String vehicleNumber){
        Session session = HibernatePersistence.getSessionFactory().openSession();
        String hql = "From Vehicles V where V.vehicleNumber = '"+ vehicleNumber + "'";
        Query query = session.createQuery(hql);
        if(query.list().size() > 0)
            return (Vehicles)query.list().get(0);
        else
            return new Vehicles();

    }

    public String registerVehicle(Vehicles vehicle){
        Session session = HibernatePersistence.getSessionFactory().openSession();
        session.beginTransaction();
        Integer userId =(Integer) session.save(vehicle);
        session.getTransaction().commit();
        session.close();
        return userId.toString();
    }
}
