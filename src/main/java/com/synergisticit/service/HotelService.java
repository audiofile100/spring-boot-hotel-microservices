package com.synergisticit.service;

import com.synergisticit.domain.Hotel;
import com.synergisticit.domain.HotelRoom;
import com.synergisticit.domain.RoomType;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface HotelService {

    Hotel save(Hotel hotel);

    Hotel findById(int hotelId);
    List<Hotel> findAll();
    List<Hotel> findBySearch(String hotelName, String city, String state, String address);

    List<HotelRoom> findHotelRooms(int hotelId);
}
