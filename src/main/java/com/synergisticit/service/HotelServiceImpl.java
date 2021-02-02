package com.synergisticit.service;

import com.synergisticit.domain.Hotel;
import com.synergisticit.domain.HotelRoom;
import com.synergisticit.domain.RoomType;
import com.synergisticit.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public List<HotelRoom> findHotelRooms(int hotelId) {
        Hotel hotel = findById(hotelId);
        Set<HotelRoom> set = new HashSet<>();
        if (hotel != null) {
            set = hotel.getHotelRooms();
        }
        return new ArrayList<>(set);
    }
}
