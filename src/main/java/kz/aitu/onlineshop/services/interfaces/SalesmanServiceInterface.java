package kz.aitu.onlineshop.services.interfaces;

import kz.aitu.onlineshop.models.Product;
import kz.aitu.onlineshop.models.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesmanServiceInterface {
    Product create(Product product);
    void deleteById(int id);
    Product getById(int id);
}
