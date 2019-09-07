package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="NAME")
    private String name;
    @Column(name="DIFFICULTY")
    private String difficulty;
    @Column(name="COMPLETED")
    private boolean completed;

    public Route() {
        super();
    }
    public Route(String name, String difficulty, boolean completed) {
        super();
        this.name = name;
        this.difficulty = difficulty;
        this.completed = completed;
    }

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
