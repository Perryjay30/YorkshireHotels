package com.project.yorkshirehotels.services;

import com.project.yorkshirehotels.data.dto.request.AddRoomRequest;
import com.project.yorkshirehotels.data.dto.request.UpdateRoomRequest;
import com.project.yorkshirehotels.data.dto.response.Response;
import com.project.yorkshirehotels.data.models.Room;
import com.project.yorkshirehotels.utils.YorkShireHotelsException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoomServiceImplTest {

    @Autowired
    private RoomService roomService;

    @Test
    void testThatRoomCanBeAdded() {
        AddRoomRequest addRoomRequest = new AddRoomRequest();
        addRoomRequest.setRoomPrice(BigDecimal.valueOf(65000.00));
        addRoomRequest.setRoomNumber("023");
        addRoomRequest.setRoomType("Economy");
        Response response = roomService.addRoom("643139bdc46c0d189cbf922b", addRoomRequest);
        assertEquals("Room added successfully!!", response.getMessage());
    }

    @Test
    void testThatRoomCanBeAddedThrowsException() {
        AddRoomRequest addRoomRequest = new AddRoomRequest();
        addRoomRequest.setRoomPrice(BigDecimal.valueOf(1000));
        addRoomRequest.setRoomNumber("131");
        addRoomRequest.setRoomType("Premium");
        assertThrows(YorkShireHotelsException.class, () -> roomService.addRoom("643139bdc46c0d189cbf922b", addRoomRequest));
    }

    @Test
    void testThatRoomCanBeFoundByNumber() {
        Room findRoom = roomService.getRoomByNumber("643139bdc46c0d189cbf922b", "306");
        assertEquals("6430ae49615b2d20ccf922cb", findRoom.getRoomId());
    }

    @Test
    void testThatRoomCanBeFoundByNumberThrowsException() {
        assertThrows(YorkShireHotelsException.class, () -> roomService.getRoomByNumber("643139bdc46c0d189cbf922b", "300"));
    }

    @Test
    void testThatRoomCanBeEdit() {
        UpdateRoomRequest updateRoomRequest = new UpdateRoomRequest();
//        updateRoomRequest.setRoomNumber("021");
        updateRoomRequest.setRoomPrice(BigDecimal.valueOf(100000.00));
        Response reply = roomService.editRoomDetails("643139bdc46c0d189cbf922b", "6430afdb77f3c257f685369d", updateRoomRequest);
        assertEquals("Room updated successfully", reply.getMessage());
    }

    @Test
    void testThatNumberAndPriceOfAvailableEconomyRoomsMethodWorks() {
        Response resp = roomService.numberAndPriceOfAvailableEconomyRooms("643139bdc46c0d189cbf922b");
        assertEquals("Available economy rooms are: 3 and their total amount is : 195000.0", resp.getMessage());
    }


}