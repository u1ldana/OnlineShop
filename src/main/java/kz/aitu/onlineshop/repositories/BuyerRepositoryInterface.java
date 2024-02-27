package kz.aitu.onlineshop.repositories;

import kz.aitu.onlineshop.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuyerRepositoryInterface extends JpaRepository<Order,Integer> {
    List<Order> findByBuyerId(int id);

}
