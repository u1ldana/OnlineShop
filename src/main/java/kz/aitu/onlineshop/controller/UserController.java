package kz.aitu.onlineshop.controller;

import kz.aitu.onlineshop.models.Buyer;
import kz.aitu.onlineshop.models.Salesman;
import kz.aitu.onlineshop.models.User;
import kz.aitu.onlineshop.services.interfaces.UserServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")

public class UserController {
    private final UserServiceInterface service;

    public UserController(UserServiceInterface service) {
        this.service = service;
    }
    @GetMapping("/")
    public List<User> getAll(){
        return service.getAll();
    }
    @GetMapping("/{user_id}")
    public ResponseEntity<User> getById(@PathVariable("user_id") int id){
        User user = service.getById(id);
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK );
    }
    @PostMapping("/")
    public ResponseEntity<User> create(@RequestBody User user){
        User createdUser = service.create(user);
        if (createdUser == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @GetMapping("/login/{user_email}/{user_password}")
    public ResponseEntity<User> login(@PathVariable("user_email") String email, @PathVariable("user_password") String password){
        User userEmail = service.getByEmail(email);
        List<User> passwordList = service.getByPassword(password);
        for(User user : passwordList){
            if(user == userEmail){
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/buyers")
    public List<User> getAllBuyers(){
        return service.getAllBuyers();
    }
    @GetMapping("/salesmans")
    public List<User> getAllSalesmans(){
        return service.getAllSalesmans();
    }
}
