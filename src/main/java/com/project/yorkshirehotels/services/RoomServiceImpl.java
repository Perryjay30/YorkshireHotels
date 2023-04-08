package com.project.yorkshirehotels.services;

import com.project.yorkshirehotels.data.dto.request.AddRoomRequest;
import com.project.yorkshirehotels.data.dto.request.UpdateRoomRequest;
import com.project.yorkshirehotels.data.dto.response.Response;
import com.project.yorkshirehotels.data.models.HotelManager;
import com.project.yorkshirehotels.data.models.Room;
import com.project.yorkshirehotels.data.models.RoomStatus;
import com.project.yorkshirehotels.data.models.RoomType;
import com.project.yorkshirehotels.data.repository.RoomRepository;
import com.project.yorkshirehotels.utils.YorkShireHotelsException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final HotelManagerService hotelManagerService;

    private final RoomRepository roomRepository;

    public RoomServiceImpl(HotelManagerService hotelManagerService, RoomRepository roomRepository) {
        this.hotelManagerService = hotelManagerService;
        this.roomRepository = roomRepository;
    }

    @Override
    public Response addRoom(String hotelManagerID, AddRoomRequest addRoomRequest) {
        HotelManager hotelManager = hotelManagerService.findHotelManagerById(hotelManagerID);
        if(roomRepository.findRoomByRoomNumber(addRoomRequest.getRoomNumber()).isPresent())
            throw new YorkShireHotelsException("A room with the number " + addRoomRequest.getRoomNumber() + " " + "already exists!!");
        Room newRoom = Room.builder()
                .roomNumber(addRoomRequest.getRoomNumber())
                .roomPrice(addRoomRequest.getRoomPrice())
                .roomStatus(RoomStatus.valueOf(addRoomRequest.getRoomStatus().toUpperCase()))
                .roomType(RoomType.valueOf(addRoomRequest.getRoomType().toUpperCase()))
                .build();
        roomRepository.save(newRoom);
        return new Response("Room added successfully!!");
    }

    @Override
    public Room getRoomByNumber(String roomNumber) {
        return roomRepository.findRoomByRoomNumber(roomNumber).orElseThrow(()
                -> new YorkShireHotelsException("Room doesn't exist"));
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public List<Room> getAvailableRooms() {
        return null;
    }

    @Override
    public List<Room> getBookedRooms() {
        return null;
    }

    @Override
    public Response editRoomDetails(String roomId, UpdateRoomRequest updateRoomRequest) {
        return null;
    }
}
