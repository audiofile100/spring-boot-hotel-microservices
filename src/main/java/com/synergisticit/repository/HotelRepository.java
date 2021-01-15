package com.synergisticit.repository;

import com.synergisticit.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    List<Hotel> findAllByHotelNameContainsOrCityContainsOrCityContainsOrAddressContains(String hotelName,
                                                                                        String city,
                                                                                        String city2,
                                                                                        String address);
}
