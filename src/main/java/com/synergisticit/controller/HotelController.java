package com.synergisticit.controller;

import com.synergisticit.domain.Hotel;
import com.synergisticit.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping(value = "/api/hotel", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveHotel(@RequestBody Hotel hotel) {

        return new ResponseEntity<>(hotelService.save(hotel), HttpStatus.CREATED);
    }

    @GetMapping(value = "api/hotel", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findHotelByName(@RequestParam String hotelName, @RequestParam String city,
                                             @RequestParam String state, @RequestParam String address) {

        return new ResponseEntity<>(hotelService.findBySearch(hotelName, city, state, address), HttpStatus.OK);
    }
}
