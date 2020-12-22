package db.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_num", nullable = false)
    private Integer startNum;

    @Column(name = "initials", nullable = false)
    private String initials;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "instagram", nullable = false)
    private String instagram;

    @Column(name = "license", nullable = false)
    private String license;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
