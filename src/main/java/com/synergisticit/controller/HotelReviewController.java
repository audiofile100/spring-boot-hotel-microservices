package com.synergisticit.controller;

import com.synergisticit.domain.HotelReview;
import com.synergisticit.service.HotelReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HotelReviewController {

    private final HotelReviewService service;

    public HotelReviewController(HotelReviewService service) {
        this.service = service;
    }

    @PostMapping(value = "/api/hotelreview", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveHotelReview(@RequestBody HotelReview review) {

        return new ResponseEntity<>(service.save(review), HttpStatus.OK);
    }

    @GetMapping(value = "/api/hotelreview/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getHotelReviewsById(@PathVariable int id) {

        return new ResponseEntity<>(service.findByHotelId(id), HttpStatus.OK);
    }
}
