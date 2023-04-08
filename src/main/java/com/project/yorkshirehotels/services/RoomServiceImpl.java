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
        hotelManagerService.findHotelManagerById(hotelManagerID);
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
    public Room getRoomByNumber(String hotelManagerID, String roomNumber) {
        hotelManagerService.findHotelManagerById(hotelManagerID);
        return roomRepository.findRoomByRoomNumber(roomNumber).orElseThrow(()
                -> new YorkShireHotelsException("Room doesn't exist"));
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public List<Room> getAllAvailableRooms(String hotelManagerID) {
        hotelManagerService.findHotelManagerById(hotelManagerID);
        List<Room> allRooms = getAllRooms();
        List<Room> availableRoom = new ArrayList<>();
        for(Room room : allRooms) {
            if(room.getRoomStatus().equals(RoomStatus.UNBOOKED))
                availableRoom.add(room);
        }
        return availableRoom;
    }

    @Override
    public List<Room> getAllBookedRooms(String hotelManagerID) {
        hotelManagerService.findHotelManagerById(hotelManagerID);
        List<Room> allTheRooms = getAllRooms();
        List<Room> unavailableRooms = new ArrayList<>();
        for(Room room : allTheRooms) {
            if(room.getRoomStatus().equals(RoomStatus.BOOKED))
                unavailableRooms.add(room);
        }
        return unavailableRooms;
    }

    @Override
    public Response numberAndPriceOfAvailablePremiumRooms(String hotelManagerID) {
        hotelManagerService.findHotelManagerById(hotelManagerID);
        List<Room> hotelRooms = getAllRooms();
        List<Room> availablePremiumRooms = new ArrayList<>();
        for(Room rooms : hotelRooms) {
            if(rooms.getRoomType().equals(RoomType.PREMIUM) && rooms.getRoomStatus().equals(RoomStatus.UNBOOKED))
                availablePremiumRooms.add(rooms);
        }
        return new Response("Available premium rooms are: " + availablePremiumRooms.size() +
                "and their total amount is : " + availablePremiumRooms.size() * 100.00);
    }

    @Override
    public Response numberAndPriceOfAvailableEconomyRooms(String hotelManagerID) {
        hotelManagerService.findHotelManagerById(hotelManagerID);
        List<Room> availableEconomyRooms = new ArrayList<>();
        List<Room> ourHotelRooms = getAllRooms();
        for(Room rooms : ourHotelRooms) {
            if(rooms.getRoomType().equals(RoomType.ECONOMY) && rooms.getRoomStatus().equals(RoomStatus.UNBOOKED))
                availableEconomyRooms.add(rooms);
        }
        return new Response("Available premium rooms are: " + availableEconomyRooms.size() +
                "and their total amount is : " + availableEconomyRooms.size() * 65.00);
    }

    @Override
    public Response editRoomDetails(String hotelManagerID, String roomId, UpdateRoomRequest updateRoomRequest) {
        hotelManagerService.findHotelManagerById(hotelManagerID);
        return null;
    }
}
