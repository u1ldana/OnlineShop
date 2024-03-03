package kz.aitu.onlineshop.services.interfaces;
import kz.aitu.onlineshop.models.User;

import java.util.List;
public interface UserServiceInterface {
    List<User> getAll();
    User getById(int id);
    User create(User user);
    User getByEmail(String email);
    List<User> getByPassword(String password);
    List<User> getAllBuyers();
    List<User> getAllSalesmans();
    List<User> getUserByName(String name);
    List<User> getUserBySurname(String surname);
    List<User> getBuyerByName(String name);
    List<User> getBuyerBySurname(String surname);

}
