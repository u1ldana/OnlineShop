package kz.aitu.onlineshop.repositories;

import kz.aitu.onlineshop.models.Buyer;
import kz.aitu.onlineshop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BuyerRepositoryInterface extends JpaRepository<Buyer,Integer> {

    Buyer findByEmail(String email);


}
