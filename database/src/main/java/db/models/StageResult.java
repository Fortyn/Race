package db.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Entity
@Table(name = "stage_result")
public class StageResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tanso", nullable = false)
    private Integer tanso;

    @Column(name = "cuiso", nullable = false)
    private Integer cuiso;

    @Column(name = "place", nullable = false)
    private Integer place;

    @ManyToOne
    @JoinColumn(name = "qual_id", nullable = false)
    private StageQualification qualification;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTanso() {
        return tanso;
    }

    public void setTanso(String tanso) {
        this.tanso = tanso;
    }

    public String getCuiso() {
        return cuiso;
    }

    public void setCuiso(String cuiso) {
        this.cuiso = cuiso;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public StageQualification getQualification() {
        return qualification;
    }

    public void setQualification(StageQualification qualification) {
        this.qualification = qualification;
    }
}
