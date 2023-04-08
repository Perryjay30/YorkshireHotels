package com.project.yorkshirehotels.services;

import com.project.yorkshirehotels.data.dto.request.AddRoomRequest;
import com.project.yorkshirehotels.data.dto.response.Response;
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
        addRoomRequest.setRoomPrice(BigDecimal.valueOf(1000));
        addRoomRequest.setRoomNumber("024");
        addRoomRequest.setRoomStatus("Unbooked");
        addRoomRequest.setRoomType("Premium");
        Response response = roomService.addRoom("643139bdc46c0d189cbf922b", addRoomRequest);
        assertEquals("Room added successfully!!", response.getMessage());
    }

    @Test
    void testThatRoomCanBeAddedThrowsException() {
        AddRoomRequest addRoomRequest = new AddRoomRequest();
        addRoomRequest.setRoomPrice(BigDecimal.valueOf(1000));
        addRoomRequest.setRoomNumber("131");
        addRoomRequest.setRoomStatus("Unbooked");
        addRoomRequest.setRoomType("Premium");
        assertThrows(YorkShireHotelsException.class, () -> roomService.addRoom("643139bdc46c0d189cbf922b", addRoomRequest));
    }

}