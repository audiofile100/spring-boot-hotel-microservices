package com.synergisticit.service;

import com.synergisticit.domain.HotelReview;

import java.util.List;

public interface HotelReviewService {

    HotelReview save(HotelReview review);
    List<HotelReview> findByHotelId(int hotelId);
}
