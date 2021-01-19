package com.synergisticit.domain;

import lombok.Data;

@Data
public class SearchDetails {
	private String searchHotel;
	private String checkIn;
	private String checkOut;
	private int noOfRooms;
	private int noOfGuests;

}
