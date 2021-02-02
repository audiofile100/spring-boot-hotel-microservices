package com.synergisticit.utilities;

import com.synergisticit.domain.Hotel;
import com.synergisticit.domain.HotelRoom;
import com.synergisticit.domain.RoomType;
import com.synergisticit.service.HotelRoomService;
import com.synergisticit.service.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;

@Slf4j
@Component
public class MicroServiceUtilities {

    private final HotelService hotelService;
    private final HotelRoomService hotelRoomService;

    public MicroServiceUtilities(HotelService hotelService, HotelRoomService hotelRoomService) {
        this.hotelService = hotelService;
        this.hotelRoomService = hotelRoomService;
    }

    public void removeRoom(int hotelId, int typeId, int noRooms) {

        Hotel hotel = hotelService.findById(hotelId);
        if (hotel != null) {
            Set<HotelRoom> hotelRooms = hotel.getHotelRooms();
            for (HotelRoom room : hotelRooms) {
                RoomType type = room.getType();
                if (type.getTypeId() == typeId) {
                    int count = room.getNoRooms();
                    room.setNoRooms(count-noRooms);
                    hotelRoomService.save(room);
                    break;
                }
            }
        }
    }

    public void addRoom(int hotelId, int typeId, int noRooms) {

        Hotel hotel = hotelService.findById(hotelId);
        if (hotel != null) {
            Set<HotelRoom> hotelRooms = hotel.getHotelRooms();
            for (HotelRoom room : hotelRooms) {
                RoomType type = room.getType();
                if (type.getTypeId() == typeId) {
                    int count = room.getNoRooms();
                    room.setNoRooms(count+noRooms);
                    hotelRoomService.save(room);
                    break;
                }
            }
        }
    }
}
