package kz.aitu.onlineshop.repositories;

import kz.aitu.onlineshop.models.Product;
import kz.aitu.onlineshop.models.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesmanRepositoryInterface extends JpaRepository<Product,Integer> {
}
