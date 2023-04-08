package com.project.yorkshirehotels.services;

import com.project.yorkshirehotels.data.dto.request.AddRoomRequest;
import com.project.yorkshirehotels.data.dto.request.UpdateRoomRequest;
import com.project.yorkshirehotels.data.dto.response.Response;
import com.project.yorkshirehotels.data.models.Room;

import java.util.List;

public interface RoomService {
    Response addRoom(String hotelManagerID, AddRoomRequest addRoomRequest);
    Room getRoomByNumber(String hotelManagerID, String roomNumber);
    List<Room> getAllRooms();
    List<Room> getAllAvailableRooms(String hotelManagerID);
    List<Room> getAllBookedRooms(String hotelManagerID);
    Response numberAndPriceOfAvailablePremiumRooms(String hotelManagerID);
    Response numberAndPriceOfAvailableEconomyRooms(String hotelManagerID);
    Response editRoomDetails(String hotelManagerID, String roomId, UpdateRoomRequest updateRoomRequest);
}
