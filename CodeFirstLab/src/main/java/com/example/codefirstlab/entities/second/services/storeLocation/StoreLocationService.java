package com.example.codefirstlab.entities.second.services.storeLocation;

import com.example.codefirstlab.entities.second.StoreLocation;

public interface StoreLocationService {
    StoreLocation getLocation(Long id);
    void changeLocation(Long id, String newLocation);
    void createLocation(String location);
    void deleteLocationById(Long id);
}
