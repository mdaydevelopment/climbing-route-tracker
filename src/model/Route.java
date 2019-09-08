package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Main entity for route tracking application.
 * 
 * @author Michael Day
 *
 */
@Entity
@Table(name="route")
public class Route {
    /**
     * Auto-generated route ID.
     * Serves as primary key for persistence and simple identifier for UI.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Name of climbing route.
     */
    @Column(name="NAME")
    private String name;
    /**
     * Difficulty of route. YDS or other.
     */
    @Column(name="DIFFICULTY")
    private String difficulty;
    /**
     * Denoted if user has successfully sent the route.
     */
    @Column(name="COMPLETED")
    private boolean completed;

    /**
     * Constructor.
     */
    public Route() {
        super();
    }
    /**
     * Constructor with all user defined fields.
     * 
     * @param name
     * @param difficulty
     * @param completed
     */
    public Route(String name, String difficulty, boolean completed) {
        super();
        this.name = name;
        this.difficulty = difficulty;
        this.completed = completed;
    }

    /**
     * @return a formatted string containing route information matching:
     * Route ID  Name                                Difficulty     Completed
     */
    public String display() {
        return String.format("%8d  %-30s    %10s     %b", id, name, difficulty, completed);
    }
 
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Route [id=" + id + ", name=" + name + ", difficulty="
                + difficulty + ", completed=" + completed + "]";
    }
    
}
