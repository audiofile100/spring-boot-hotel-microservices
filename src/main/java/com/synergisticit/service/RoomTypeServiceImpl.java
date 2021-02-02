package com.synergisticit.service;

import com.synergisticit.domain.RoomType;
import com.synergisticit.repository.RoomTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    private final RoomTypeRepository repo;

    public RoomTypeServiceImpl(RoomTypeRepository repo) {
        this.repo = repo;
    }

    @Override
    public RoomType save(RoomType roomType) {
        return repo.save(roomType);
    }
}
