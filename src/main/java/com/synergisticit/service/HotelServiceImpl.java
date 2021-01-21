package com.synergisticit.service;

import com.synergisticit.domain.Hotel;
import com.synergisticit.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository repo;

    @Override
    public Hotel save(Hotel hotel) {
        return repo.save(hotel);
    }

    @Override
    public Hotel findById(int hotelId) {
        Optional<Hotel> opt = repo.findById(hotelId);
        return opt.orElse(null);
    }

    @Override
    public List<Hotel> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Hotel> findBySearch(String hotelName, String city, String state, String address) {
        return repo.findAllByHotelNameContainsOrCityContainsOrStateContainsOrAddressContains(hotelName, city, state, address);
    }
}
