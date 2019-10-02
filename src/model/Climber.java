package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="climber")
public class Climber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="climber_id")
    private int id;
    @Column(name="first_name")
    private String fName;
    @Column(name="last_name")
    private String lName;
    @Column(name="dob")
    private LocalDate dob;
    @OneToMany(mappedBy="climber",
                cascade=CascadeType.ALL,
                orphanRemoval=true)
    private List<Ascent> ascents;


    public Climber() {
        super();
    }

    public Climber(int id, String fName, String lName, LocalDate dob,
            List<Ascent> ascents) {
        super();
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.dob = dob;
        this.ascents = ascents;
    }

    public Climber(String fName, String lName, LocalDate dob, List<Ascent> ascents) {
        super();
        this.fName = fName;
        this.lName = lName;
        this.dob = dob;
        this.ascents = ascents;
    }

    public Climber(String fName, String lName, LocalDate dob) {
        super();
        this.fName = fName;
        this.lName = lName;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<Ascent> getAscents() {
        return ascents;
    }

    public void setAscents(List<Ascent> ascents) {
        this.ascents = ascents;
    }

    @Override
    public String toString() {
        return "Climber [id=" + id + ", fName=" + fName + ", lName=" + lName
                + ", dob=" + dob + ", ascents=" + ascents + "]";
    }

}
