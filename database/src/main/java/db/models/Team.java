package db.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Entity
@Table(name = "Team", schema = "public")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "score", nullable = false)
    private Integer score;

    @Column(name = "first_stage")
    private Integer firstStage;

    @Column(name = "second_stage")
    private Integer secondStage;

    @Column(name = "third_stage")
    private Integer thirdStage;

    @Column(name = "fourth_stage")
    private Integer fourthStage;

    @Column(name = "fifth_stage")
    private Integer fifthStage;

    @OneToMany(mappedBy = "team")
    private List<Driver> drivers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getFirstStage() {
        return firstStage;
    }

    public void setFirstStage(Integer firstStage) {
        this.firstStage = firstStage;
    }

    public Integer getSecondStage() {
        return secondStage;
    }

    public void setSecondStage(Integer secondStage) {
        this.secondStage = secondStage;
    }

    public Integer getThirdStage() {
        return thirdStage;
    }

    public void setThirdStage(Integer thirdStage) {
        this.thirdStage = thirdStage;
    }

    public Integer getFourthStage() {
        return fourthStage;
    }

    public void setFourthStage(Integer fourthStage) {
        this.fourthStage = fourthStage;
    }

    public Integer getFifthStage() {
        return fifthStage;
    }

    public void setFifthStage(Integer fifthStage) {
        this.fifthStage = fifthStage;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
}
