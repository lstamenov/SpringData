package com.example.codefirstlab.entities.second.services.storeLocation;

import com.example.codefirstlab.entities.second.StoreLocation;
import com.example.codefirstlab.entities.second.repositories.StoreLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreLocationServiceImpl implements StoreLocationService{
    @Autowired
    StoreLocationRepository repository;

    @Override
    public StoreLocation getLocation(Long id) {
        return this.repository.findStoreLocationsById(id);
    }

    @Override
    public void changeLocation(Long id, String newLocation) {
        StoreLocation storeLocation = repository.findStoreLocationsById(id);
        storeLocation.setLocationName(newLocation);
        repository.save(storeLocation);
    }

    @Override
    public void createLocation(String location) {
        repository.save(new StoreLocation(location));
    }

    @Override
    public void deleteLocationById(Long id) {
        repository.deleteById(id);
    }
}
