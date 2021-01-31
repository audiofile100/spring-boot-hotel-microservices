package com.synergisticit.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hotel_review")
public class HotelReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewId;

    private long cid;
    private int bookingId;
    private int hotelId;

    private int cleanliness;
    private int service;
    private int property;
    private int amenities;
    private int atmosphere;

    private String comments;
}
