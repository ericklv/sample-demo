package com.xcale.whatsapp.sampledemo.controller;

import com.xcale.whatsapp.sampledemo.entity.Room;
import com.xcale.whatsapp.sampledemo.model.UserRequest;
import com.xcale.whatsapp.sampledemo.service.AuthService;
import com.xcale.whatsapp.sampledemo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    AuthService authService;
    @Autowired
    RoomService roomService;

    @PostMapping(
            value = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    ) public ResponseEntity register(@RequestBody UserRequest userRequest){
        return authService.register(userRequest);
    }

    @PostMapping(
            value = "/room",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    ) public ResponseEntity register(@RequestBody Room room){
        return roomService.saveRoom(room);
    }
}
