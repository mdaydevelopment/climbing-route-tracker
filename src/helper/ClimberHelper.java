package helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Climber;

public class ClimberHelper {
    static EntityManagerFactory emf;
    
    /**
     * Constructor generates entity manager factory.
     */
    public ClimberHelper() {
        try {
            emf = Persistence.createEntityManagerFactory("ClimbingRoutes");
        } catch (javax.persistence.PersistenceException pe) {
            throw pe;
        }
    }

    /**
     * Returns all climbers.
     * @return a List containing all Climber objects
     */
    public List<Climber> getAllClimbers() {
        try {
            EntityManager em = emf.createEntityManager();
            List<Climber> cl = em.createQuery("SELECT c FROM Climber c")
                    .getResultList();
            return cl;
        } catch (javax.persistence.PersistenceException pe) {
            throw pe;
        }
    }
    
    /**
     * Returns a single climber.
     * @param id the primary key for the Climber object
     * @return the associated Climber object
     */
    public Climber getClimberById(int id) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Climber found = em.find(Climber.class, id);
            em.close();
            return found;
        } catch (javax.persistence.PersistenceException pe) {
            throw pe;
        }
    }
 
    /**
     * Adds a climber to the database.
     * @param c the Climber object to be inserted
     */
    public void insertClimber(Climber c) {                                    // needs exception handling
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
    }
    
    /**
     * Removes a route from the database.
     * @param r the Climber object to be deleted
     */
    public void deleteClimber(Climber c) {                                     // needs exception handling
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Climber found = em.find(Climber.class, c.getId());
            em.remove(found);
            em.getTransaction().commit();
            em.close();
        } catch (javax.persistence.PersistenceException pe) {
            throw pe;
        }
    }

    /**
     * Modifies an existing climber.
     * @param c the updated Climber object
     */
    public void updateClimber(Climber c) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(c);
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
