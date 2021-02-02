package com.synergisticit.repository;

import com.synergisticit.domain.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRoomRepository extends JpaRepository<HotelRoom, Integer> {

}
