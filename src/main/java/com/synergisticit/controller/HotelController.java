package com.synergisticit.controller;

import com.synergisticit.domain.Hotel;
import com.synergisticit.service.HotelService;
import com.synergisticit.utilities.MicroServiceUtilities;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HotelController {

    private final HotelService hotelService;
    private final MicroServiceUtilities util;

    public HotelController(HotelService hotelService, MicroServiceUtilities util) {
        this.hotelService = hotelService;
        this.util = util;
    }

    @PostMapping(value = "api/hotel", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveHotel(@RequestBody Hotel hotel) {

        return new ResponseEntity<>(hotelService.save(hotel), HttpStatus.CREATED);
    }

    @GetMapping(value = "api/hotel/{id}")
    public ResponseEntity<?> findHotelById(@PathVariable int id) {

        return new ResponseEntity<>(hotelService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "api/hotel", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findHotelByName(@RequestParam String hotelName, @RequestParam String city,
                                             @RequestParam String state, @RequestParam String address) {

        return new ResponseEntity<>(hotelService.findBySearch(hotelName, city, state, address), HttpStatus.OK);
    }

    @GetMapping(value = "api/hotel/hotelrooms/{hid}")
    public ResponseEntity<?> getHotelRooms(@PathVariable int hid) {

        return new ResponseEntity<>(hotelService.findHotelRooms(hid), HttpStatus.OK);
    }

    @GetMapping(value = "api/hotel/removeroom/{hid}/{type}/{rooms}")
    public ResponseEntity<?> removeRooms(@PathVariable int hid, @PathVariable int type, @PathVariable int rooms) {

        util.removeRoom(hid, type, rooms);
        return new ResponseEntity<>(hotelService.findHotelRooms(hid), HttpStatus.OK);
    }

    @GetMapping(value = "api/hotel/addroom/{hid}/{type}/{rooms}")
    public ResponseEntity<?> addRooms(@PathVariable int hid, @PathVariable int type, @PathVariable int rooms) {

        util.addRoom(hid, type, rooms);
        return new ResponseEntity<>(hotelService.findHotelRooms(hid), HttpStatus.OK);
    }
}
