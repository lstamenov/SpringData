package com.example.codefirstlab.entities.second;

import javax.persistence.*;

@Entity
@Table(name = "store_location")
public class StoreLocation {
    private Long id;
    private String locationName;

    public StoreLocation(){}

    public StoreLocation(String locationName) {
        this.locationName = locationName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "location_name")
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
