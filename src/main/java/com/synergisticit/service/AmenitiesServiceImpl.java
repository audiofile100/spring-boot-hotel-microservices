package com.synergisticit.service;

import com.synergisticit.domain.Amenities;
import com.synergisticit.repository.AmenitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmenitiesServiceImpl implements AmenitiesService {

    @Autowired
    private AmenitiesRepository repo;

    @Override
    public Amenities save(Amenities amenities) {
        return repo.save(amenities);
    }
}
