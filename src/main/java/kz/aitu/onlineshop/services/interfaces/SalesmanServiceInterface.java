package kz.aitu.onlineshop.services.interfaces;

import kz.aitu.onlineshop.models.Product;
import kz.aitu.onlineshop.models.Salesman;

public interface SalesmanServiceInterface {
    Product create(Product product);
    void deleteById(int id);
    Product getById(int id);
    boolean updateQuantity(int id, int requestedQuantity);
    void updateBank(int id, double totalPrice);
    Salesman getByEmail(String email);
}
