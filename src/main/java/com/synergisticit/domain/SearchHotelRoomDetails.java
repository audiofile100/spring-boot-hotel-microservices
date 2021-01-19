package com.synergisticit.domain;

import lombok.Data;

@Data
public class SearchHotelRoomDetails {
	private int hotelId;
	private String checkInDate;
	private String checkOutDate;
	private int noRooms;
	private int noGuests;

}
