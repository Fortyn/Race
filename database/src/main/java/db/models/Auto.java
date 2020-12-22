package db.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Entity
@Table(name = "auto")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mark", nullable = false)
    private String mark;

    @Column(name = "engine", nullable = false)
    private String engine;

    @Column(name = "power", nullable = false)
    private Integer power;

    @Column(name = "engine_volume", nullable = false)
    private Integer engineVolume;

    @Column(name = "tire_mark", nullable = false)
    private String tireMark;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(Integer engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getTireMark() {
        return tireMark;
    }

    public void setTireMark(String tireMark) {
        this.tireMark = tireMark;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
