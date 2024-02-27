package kz.aitu.onlineshop.controller;

import kz.aitu.onlineshop.models.User;
import kz.aitu.onlineshop.services.interfaces.UserServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("signup")
public class SignUpController {
    private final UserServiceInterface service;
    public SignUpController(UserServiceInterface service) {
        this.service = service;
    }
    @PostMapping("/")
    public ResponseEntity<User> create(@RequestBody User user){
        User createdUser = service.create(user);
        if (createdUser == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
