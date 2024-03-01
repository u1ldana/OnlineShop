package kz.aitu.onlineshop.services.interfaces;

import kz.aitu.onlineshop.models.Buyer;
import kz.aitu.onlineshop.models.Order;
import kz.aitu.onlineshop.models.Product;
import kz.aitu.onlineshop.models.User;

import java.util.List;

public interface BuyerServiceInterface {
    List<Order> getAllOrders(int id);

    List<Product> getAllProducts();

    Product getProductById(int id);
    Order create(Order order);
    Buyer getByEmail(String email);
    void updateBank(int id, double totalPrice);

}
