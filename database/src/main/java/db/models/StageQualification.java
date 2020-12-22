package db.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Entity
@Table(name = "Stage_qualification")
public class StageQualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "stage_number", nullable = false)
    private Integer stageNumber;

    @Column(name = "place", nullable = false)
    private Integer place;

    @Column(name = "best", nullable = false)
    private Integer best;

    @Column(name = "worst", nullable = false)
    private Integer worst;

    @Column(name = "points", nullable = false)
    private Integer points;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Auto auto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber(Integer stageNumber) {
        this.stageNumber = stageNumber;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Integer getBest() {
        return best;
    }

    public void setBest(Integer best) {
        this.best = best;
    }

    public Integer getWorst() {
        return worst;
    }

    public void setWorst(Integer worst) {
        this.worst = worst;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }
}
