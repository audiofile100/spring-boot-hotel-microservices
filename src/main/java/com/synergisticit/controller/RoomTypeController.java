package com.synergisticit.controller;

import com.synergisticit.service.RoomTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomTypeController {

    private final RoomTypeService roomTypeService;

    public RoomTypeController(RoomTypeService roomTypeService) { this.roomTypeService = roomTypeService; }

    @GetMapping(value = "api/roomtype", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllRoomTypes() {

        return new ResponseEntity<>(roomTypeService.findAll(), HttpStatus.OK);
    }
}
