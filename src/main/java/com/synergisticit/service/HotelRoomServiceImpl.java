package com.synergisticit.service;

import com.synergisticit.domain.HotelRoom;
import com.synergisticit.repository.HotelRoomRepository;
import org.springframework.stereotype.Service;

@Service
public class HotelRoomServiceImpl implements HotelRoomService {

    private final HotelRoomRepository repo;

    public HotelRoomServiceImpl(HotelRoomRepository repo) {
        this.repo = repo;
    }

    @Override
    public HotelRoom save(HotelRoom hotelRoom) {
        return repo.save(hotelRoom);
    }
}
