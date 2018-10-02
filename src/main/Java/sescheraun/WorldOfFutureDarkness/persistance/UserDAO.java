package sescheraun.WorldOfFutureDarkness.persistance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sescheraun.WorldOfFutureDarkness.generator.User;

import javax.persistence.criteria.*;

import java.util.List;

public class UserDAO {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();


    public List<User>  getAllUsers(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        Expression<Boolean> isDeleted = root.get("isDeleted");
        query.select(root).where(builder.isFalse(isDeleted));

        List<User> users = session.createQuery(query).getResultList();
        session.close();

        return users;
    }

    public List<User> getUserBy(String field, String value) {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Expression<Boolean> isDeleted = root.get("isDeleted");
        query.select(root).where(builder.isFalse(isDeleted));

        Expression<String> propertyPath = root.get(field);
        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<User> users = session.createQuery(query).getResultList();
        session.close();

        return users;
    }

    /**
     * Get user by id
     */
    public User getById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get( User.class, id );
        session.close();
        return user;
    }

}
