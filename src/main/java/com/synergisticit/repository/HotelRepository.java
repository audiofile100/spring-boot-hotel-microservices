package com.synergisticit.repository;

import com.synergisticit.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    List<Hotel> findAllByHotelNameContainsOrCityContainsOrStateContainsOrAddressContains(String hotelName,
                                                                                        String city,
                                                                                        String state,
                                                                                        String address);
}
