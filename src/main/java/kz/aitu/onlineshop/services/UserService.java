package kz.aitu.onlineshop.services;

import kz.aitu.onlineshop.models.Buyer;
import kz.aitu.onlineshop.models.Salesman;
import kz.aitu.onlineshop.models.User;
import kz.aitu.onlineshop.repositories.UserRepositoryInterface;
import kz.aitu.onlineshop.services.interfaces.UserServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements UserServiceInterface {

    private final UserRepositoryInterface repo;

    public UserService(UserRepositoryInterface repo) {
        this.repo = repo;
    }

    @Override
    public List<User> getAll() {
        return repo.findAll();
    }

    @Override
    public User getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public User create(User user) {
        return repo.save(user);
    }
    @Override
    public User getByEmail(String email){
        return repo.findByEmail(email);
    }

    @Override
    public List<User> getByPassword(String password) {
        return repo.findByPassword(password);
    }

    @Override
    public List<User> getAllBuyers() {
        return repo.findByStatus(true);
    }

    @Override
    public List<User> getAllSalesmans() {
        return repo.findByStatus(false);
    }
    @Override
    public List<User> getUserByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public List<User> getUserBySurname(String surname) {
        return repo.findBySurname(surname);
    }

    @Override
    public List<User> getBuyerByName(String name) {
        return repo.findByNameAndStatus(name,true);
    }

    @Override
    public List<User> getBuyerBySurname(String surname) {
        return repo.findBySurnameAndStatus(surname,true);
    }
}
