package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Route;

public class RouteHelper {
    static EntityManagerFactory emf;
    
    public RouteHelper() {
        try {
            emf = Persistence.createEntityManagerFactory("ClimbingRoutes");
        } catch (javax.persistence.PersistenceException pe) {
            throw pe;
        }
    }

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
 
    public void insertRoute(Route r) {                                    // needs exception handling
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close();
    }
    
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

    public void cleanUp() {                                                   // needs exception handling
        emf.close();
    }   
    
}
