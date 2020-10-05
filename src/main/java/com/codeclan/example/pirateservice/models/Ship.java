package com.codeclan.example.pirateservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ships")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String shipName;

    @JsonIgnoreProperties({"ship"})
    @OneToMany(mappedBy="ship")
    private List<Pirate> crew;

    public Ship(String shipName) {
        this.shipName = shipName;
        this.crew = new ArrayList<>();
    }

    public Ship() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public List<Pirate> getCrew() {
        return crew;
    }

    public void setCrew(ArrayList<Pirate> crew) {
        this.crew = crew;
    }
}
