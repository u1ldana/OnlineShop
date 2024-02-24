package kz.aitu.onlineshop.repositories;

import kz.aitu.onlineshop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryInterface extends JpaRepository<User,Integer> {
}
