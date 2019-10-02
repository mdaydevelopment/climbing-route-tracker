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
    @Column(name="route_id")
    private int id;
    /**
     * Name of climbing route.
     */
    @Column(name="name")
    private String name;
    /**
     * Difficulty of route. YDS or other.
     */
    @Column(name="difficulty")
    private String difficulty;
    /**
     * Denoted if user has successfully sent the route.
     */
    @Column(name="notes")
    private String notes;

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
    public Route(String name, String difficulty, String notes) {
        super();
        this.name = name;
        this.difficulty = difficulty;
        this.notes = notes;
    }

    /**
     * @return a formatted string containing route information matching:
     * Route ID  Name                                Difficulty     Completed
     */
    public String display() {
        return String.format("%8d  %-30s    %10s     %b", id, name, difficulty, notes);
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Route [id=" + id + ", name=" + name + ", difficulty="
                + difficulty + ", notes=" + notes + "]";
    }
    
}
