package com.xcale.whatsapp.sampledemo.repository;

import com.xcale.whatsapp.sampledemo.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
}
