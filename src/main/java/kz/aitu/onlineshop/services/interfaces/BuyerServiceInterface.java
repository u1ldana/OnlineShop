package kz.aitu.onlineshop.services.interfaces;

import kz.aitu.onlineshop.models.Buyer;
import kz.aitu.onlineshop.models.Order;
import kz.aitu.onlineshop.models.Product;

import java.util.List;

public interface BuyerServiceInterface {
    List<Order> getAllOrders(int id);

    List<Product> getAllProducts();

}
