package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Route;

/**
 * Database manager for climbing route tracking application.
 * 
 * @author Michael Day
 *
 */
public class RouteHelper {
    static EntityManagerFactory emf;
    
    /**
     * Constructor generates entity manager factory.
     */
    public RouteHelper() {
        try {
            emf = Persistence.createEntityManagerFactory("ClimbingRoutes");
        } catch (javax.persistence.PersistenceException pe) {
            throw pe;
        }
    }

    /**
     * Returns all routes.
     * @return a List containing all Route objects
     */
    public List<Route> getAllRoutes() {
        try {
            EntityManager em = emf.createEntityManager();
            List<Route> rl = em.createQuery("SELECT r FROM Route r")
                    .getResultList();
            return rl;
        } catch (javax.persistence.PersistenceException pe) {
            throw pe;
        }
    }
    
    /**
     * Returns a single route.
     * @param id the primary key for the Route object
     * @return the associated Route object
     */
    public Route getRouteById(int id) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Route found = em.find(Route.class, id);
            em.close();
            return found;
        } catch (javax.persistence.PersistenceException pe) {
            throw pe;
        }
    }
 
    /**
     * Adds a route to the database.
     * @param r the Route object to be inserted
     */
    public void insertRoute(Route r) {                                    // needs exception handling
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close();
    }
    
    /**
     * Removes a route from the database.
     * @param r the Route object to be deleted
     */
    public void deleteRoute(Route r) {                                     // needs exception handling
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.remove(r);
            em.getTransaction().commit();
            em.close();
        } catch (javax.persistence.PersistenceException pe) {
            throw pe;
        }
    }

    /**
     * Modifies an existing route.
     * @param r the updated Route object
     */
    public void updateRoute(Route r) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(r);
            em.getTransaction().commit();
            em.close();
        } catch (javax.persistence.PersistenceException pe) {
            throw pe;
        }
    }

    /**
     * Returns all routes with name exactly matching search string.
     * @param name String to be matched
     * @return a List of all Route objects with name matching search string
     */
    public List<Route> searchRouteByName(String name) {                   // needs exception handling
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Route> typedQuery = em.createQuery(
                "SELECT r FROM Route r WHERE r.name = :selectedName",
                Route.class);
        typedQuery.setParameter("selectedName", name);
        List<Route> foundRoutes = typedQuery.getResultList();
        em.close();
        return foundRoutes;
    }

    /**
     * Returns all routes with difficulty exactly matching search string.
     * @param difficulty String to be matched
     * @return a List of all Route objects with name matching search string.
     */
    public List<Route> searchRouteByDifficulty(String difficulty) {              // needs exception handling
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Route> typedQuery = em.createQuery(
                "SELECT r FROM Route r WHERE r.difficulty = :selectedDifficulty",
                Route.class);
        typedQuery.setParameter("selectedItem", difficulty);
        List<Route> foundRoutes = typedQuery.getResultList();
        em.close();
        return foundRoutes;
    }

    /**
     * Closes entity manager factory.
     */
    public void cleanUp() {                                                   // needs exception handling
        emf.close();
    }   
    
}
