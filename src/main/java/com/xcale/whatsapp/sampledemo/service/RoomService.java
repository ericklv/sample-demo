package com.xcale.whatsapp.sampledemo.service;

import com.xcale.whatsapp.sampledemo.entity.Room;
import com.xcale.whatsapp.sampledemo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RoomService {
    @Autowired
    RoomRepository roomRepository;
    private int usersOnline=0;

    public synchronized void addUserOnline(){
        usersOnline++;
    }


    public synchronized void leftUserOnline(){
        usersOnline--;
    }

    public synchronized int getUsersOnline(){
        return usersOnline;
    }

    public ResponseEntity saveRoom(Room room){

        ResponseEntity responseEntity = ResponseEntity.ok().build();
        try {
            roomRepository.save(room);
        }catch (Exception e){
            responseEntity = ResponseEntity.badRequest().build();
        }finally {
            return responseEntity;
        }
    }

}
