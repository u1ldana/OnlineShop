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
    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
        User userEmail = service.getByEmail(user.getEmail());
        if(userEmail.getPassword() == user.getPassword()){
            return new ResponseEntity<>(userEmail, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user){
        User ifExist = service.getByEmail(user.getEmail());
        if(ifExist == null){
            service.create(user);
            return  new ResponseEntity<>("Welcome!",HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("User with this email already exist!", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/buyers")
    public List<User> getAllBuyers(){
        return service.getAllBuyers();
    }
    @GetMapping("/salesmans")
    public List<User> getAllSalesmans(){
        return service.getAllSalesmans();
    }
    @GetMapping("/getByName/{name}")
    public List<User> getByName(@PathVariable("name") String name){
        return service.getUserByName(name);
    }
    @GetMapping("/getBySurname/{surname}")
    public List<User> getBySurname(@PathVariable("surname") String surname){
        return service.getUserBySurname(surname);
    }
    @GetMapping("/getBuyerByName/{name}")
    public List<User> getBuyerByName(@PathVariable("name") String name){
        return service.getBuyerByName(name);
    }
    @GetMapping("/getBuyerBySurname/{surname}")
    public List<User> getBuyerBySurname(@PathVariable("surname") String surname){
        return service.getBuyerBySurname(surname);
    }

}
