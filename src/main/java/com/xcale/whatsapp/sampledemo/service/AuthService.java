package com.xcale.whatsapp.sampledemo.service;

import com.xcale.whatsapp.sampledemo.model.UserRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity register(UserRequest userRequest);
}
