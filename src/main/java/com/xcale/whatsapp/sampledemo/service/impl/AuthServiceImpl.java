package com.xcale.whatsapp.sampledemo.service.impl;

import com.xcale.whatsapp.sampledemo.model.UserRequest;
import com.xcale.whatsapp.sampledemo.entity.User;
import com.xcale.whatsapp.sampledemo.repository.UserRepository;
import com.xcale.whatsapp.sampledemo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;
    @Override
    public ResponseEntity register(UserRequest userRequest){
        ResponseEntity responseEntity = ResponseEntity.ok().build();
        try {
            userRepository.save(User.builder()
                            .name(userRequest.getName())
                            .phone(userRequest.getPhone())
                            .password(userRequest.getPassword())
                            .lastConnection(Date.from(Instant.now()))
                    .build());
        }catch (Exception e){
            responseEntity = ResponseEntity.badRequest().build();
        }finally {
            return responseEntity;
        }
    }
}
