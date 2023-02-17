package com.xcale.whatsapp.sampledemo.repository;

import com.xcale.whatsapp.sampledemo.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, String> {
}
