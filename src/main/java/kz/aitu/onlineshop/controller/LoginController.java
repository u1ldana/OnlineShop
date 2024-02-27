package kz.aitu.onlineshop.controller;

import kz.aitu.onlineshop.models.User;
import kz.aitu.onlineshop.services.interfaces.UserServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("login")
public class LoginController {
    private final UserServiceInterface service;
    public LoginController(UserServiceInterface service) {
        this.service = service;
    }
    @GetMapping("/{user_email}/{user_password}")
    public ResponseEntity<User> login(@PathVariable("user_email") String email, @PathVariable("user_password") String password){

        List<User> passwordList = service.getByPassword(password);
        for(User user : passwordList){
            if(user == service.getByEmail(email)){
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
