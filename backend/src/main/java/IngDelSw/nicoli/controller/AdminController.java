package IngDelSw.nicoli.controller;

import IngDelSw.nicoli.dto.LoginRequest;
import IngDelSw.nicoli.dto.LoginResponse;
import IngDelSw.nicoli.model.Admin;
import IngDelSw.nicoli.model.User;
import IngDelSw.nicoli.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final UserService userService;

    public AdminController (UserService userService){
        this.userService = userService;
    }

    @GetMapping("allUsers")
    public ResponseEntity<List<User>> allUsers() {
        try {
            List<User> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
}
}
