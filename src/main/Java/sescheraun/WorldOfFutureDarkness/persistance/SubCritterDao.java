package sescheraun.WorldOfFutureDarkness.persistance;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.*;
import java.util.List;

import sescheraun.WorldOfFutureDarkness.generator.*;


public class SubCritterDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<SubCritter>  getAllSubCritters(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SubCritter> query = builder.createQuery(SubCritter.class);
        Root<SubCritter> root = query.from(SubCritter.class);

        Expression<Boolean> isDeleted = root.get("isDeleted");
        query.select(root).where(builder.isFalse(isDeleted));

        List<SubCritter> subCritters = session.createQuery(query).getResultList();
        session.close();

        return subCritters;
    }

    public List<User> getSubCritterBy(String field, String value) {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SubCritter> query = builder.createQuery(SubCritter.class);
        Root<SubCritter> root = query.from(SubCritter.class);
        Expression<Boolean> isDeleted = root.get("isDeleted");
        query.select(root).where(builder.isFalse(isDeleted));

        Expression<String> propertyPath = root.get(field);
        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<SubCritter> subCritters = session.createQuery(query).getResultList();
        session.close();

        return subCritters;
    }

    /**
     * Get user by id
     *
     * @return the user that matches the ID
     */
    public User getById(int id) {
        Session session = sessionFactory.openSession();
        SubCritter subCritter = session.get( SubCritter.class, id );
        session.close();
        return subCritter;
    }

    public int createSubCritter(SubCritter subCritter){
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(subCritter);
        transaction.commit();
        session.close();
        return id;
    }

    public void deleteSubCritter(int id){
        Critter critterToDelete = getById(id);
        critterToDelete.setIsDeleted(true);
        updateSubCritter(critterToDelete);
    }

    public void updateSubCritter(SubCritter subCritter){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(subCritter);
        session.getTransaction().commit();
        session.close();
    }
}
