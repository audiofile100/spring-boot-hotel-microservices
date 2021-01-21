package com.synergisticit.service;

import com.synergisticit.domain.Hotel;

import java.util.List;

public interface HotelService {

    Hotel save(Hotel hotel);

    Hotel findById(int hotelId);
    List<Hotel> findAll();
    List<Hotel> findBySearch(String hotelName, String city, String state, String address);
}
