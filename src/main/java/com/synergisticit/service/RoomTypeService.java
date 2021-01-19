package com.synergisticit.service;

import com.synergisticit.domain.RoomType;

import java.util.List;

public interface RoomTypeService {

    RoomType save(RoomType roomType);
    List<RoomType> findAll();
}
