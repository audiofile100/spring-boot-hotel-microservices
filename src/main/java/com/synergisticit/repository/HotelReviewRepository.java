package com.synergisticit.repository;

import com.synergisticit.domain.HotelReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelReviewRepository extends JpaRepository<HotelReview, Long> {

    List<HotelReview> findAllByHotelId(int hotelId);
}
