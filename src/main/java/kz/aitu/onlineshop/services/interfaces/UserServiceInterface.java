package kz.aitu.onlineshop.services.interfaces;

import kz.aitu.onlineshop.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserServiceInterface {
    List<User> getAll();
    User getById(int id);
    User create(User user);
}
