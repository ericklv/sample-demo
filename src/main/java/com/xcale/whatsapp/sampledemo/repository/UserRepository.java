package com.xcale.whatsapp.sampledemo.repository;

import com.xcale.whatsapp.sampledemo.entity.Room;
import com.xcale.whatsapp.sampledemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
