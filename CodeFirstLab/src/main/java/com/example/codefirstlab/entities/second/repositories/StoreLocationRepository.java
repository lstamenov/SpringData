package com.example.codefirstlab.entities.second.repositories;

import com.example.codefirstlab.entities.second.StoreLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreLocationRepository extends JpaRepository<StoreLocation, Long> {
    StoreLocation findStoreLocationsById(Long id);
    void deleteById(Long id);
}
