package com.synergisticit.service;

import com.synergisticit.domain.HotelReview;
import com.synergisticit.repository.HotelReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelReviewServiceImpl implements HotelReviewService {

    private final HotelReviewRepository repo;

    public HotelReviewServiceImpl(HotelReviewRepository repo) {
        this.repo = repo;
    }

    @Override
    public HotelReview save(HotelReview review) {
        return repo.save(review);
    }

    @Override
    public List<HotelReview> findByHotelId(int hotelId) {
        return repo.findAllByHotelId(hotelId);
    }
}
