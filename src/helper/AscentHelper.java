package helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Ascent;

public class AscentHelper {
    static EntityManagerFactory emf;
    
    /**
     * Constructor generates entity manager factory.
     */
    public AscentHelper() {
        try {
            emf = Persistence.createEntityManagerFactory("ClimbingRoutes");
        } catch (javax.persistence.PersistenceException pe) {
            throw pe;
        }
    }

    /**
     * Returns all ascents.
     * @return a List containing all Ascent objects
     */
    public List<Ascent> getAllAscents() {
        try {
            EntityManager em = emf.createEntityManager();
            List<Ascent> cl = em.createQuery("SELECT a FROM Ascent a")
                    .getResultList();
            return cl;
        } catch (javax.persistence.PersistenceException pe) {
            throw pe;
        }
    }
    
    /**
     * Returns a single ascent.
     * @param id the primary key for the Ascent object
     * @return the associated Ascent object
     */
    public Ascent getAscentById(int id) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Ascent found = em.find(Ascent.class, id);
            em.close();
            return found;
        } catch (javax.persistence.PersistenceException pe) {
            throw pe;
        }
    }
 
    /**
     * Adds a ascent to the database.
     * @param c the Ascent object to be inserted
     */
    public void insertAscent(Ascent a) {                                    // needs exception handling
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
    }
    
    /**
     * Removes a route from the database.
     * @param r the Ascent object to be deleted
     */
    public void deleteAscent(Ascent a) {                                     // needs exception handling
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Ascent found = em.find(Ascent.class, a.getId());
            em.remove(found);
            em.getTransaction().commit();
            em.close();
        } catch (javax.persistence.PersistenceException pe) {
            throw pe;
        }
    }

    /**
     * Modifies an existing ascent.
     * @param c the updated Ascent object
     */
    public void updateAscent(Ascent a) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(a);
            em.getTransaction().commit();
            em.close();
        } catch (javax.persistence.PersistenceException pe) {
            throw pe;
        }
    }

    /**
     * Closes entity manager factory.
     */
    public void cleanUp() {                                                   // needs exception handling
        emf.close();
    }   
    
}
