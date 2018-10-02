package sescheraun.WorldOfFutureDarkness.persistance;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import sescheraun.WorldOfFutureDarkness.generator.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.beans.Expression;
import java.util.List;

public class UserDAO {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();


    public List<User>  getAllUsers(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        List<User> users = session.createQuery(query).getResultList();
        session.close();

        return users;
    }

//    public List<User> getUserBy(String field, String value) {
//
//        Session session = sessionFactory.openSession();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<User> query = builder.createQuery(User.class);
//        Root<User> root = query.from(User.class);
//        //Expression<String> propertyPath = root.get("isDeleted");
//
//        List<User> users = session.createQuery(query).getResultList();
//        session.close();
//
//        return users;
//    }

}
