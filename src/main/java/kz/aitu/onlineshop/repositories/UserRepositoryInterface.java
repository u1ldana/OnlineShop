package kz.aitu.onlineshop.repositories;

import kz.aitu.onlineshop.models.Buyer;
import kz.aitu.onlineshop.models.Salesman;
import kz.aitu.onlineshop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepositoryInterface extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    List<User> findByPassword(String string);
    List<User> findByStatus(boolean status);
    List<User> findByName(String name);
    List<User> findBySurname(String surname);
    List<User> findBySurnameAndStatus(String surname, boolean status);
    List<User> findByNameAndStatus(String name, boolean status);

}
