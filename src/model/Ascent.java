package model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ascent")
public class Ascent {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ascent_id")
    private int id;
    @ManyToOne(fetch=FetchType.LAZY,
                cascade= {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="climber_id")
    private Climber climber;
    @ManyToOne(cascade= {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name="route_id")
    private Route route;
    @Column(name="send_date")
    private LocalDate date;

    public Ascent() {
        super();
    }

    public Ascent(int id, Climber climber, Route route, LocalDate date) {
        super();
        this.id = id;
        this.climber = climber;
        this.route = route;
        this.date = date;
    }

    public Ascent(Climber climber, Route route, LocalDate date) {
        super();
        this.climber = climber;
        this.route = route;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Climber getClimber() {
        return climber;
    }

    public void setClimber(Climber climber) {
        this.climber = climber;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Ascent [id=" + id + ", climber=" + climber.getId() + ", route=" + route
                + ", date=" + date + "]";
    }

}
