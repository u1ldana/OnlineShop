package kz.aitu.onlineshop.repositories;

import kz.aitu.onlineshop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryInterface extends JpaRepository<Product,Integer> {
}
