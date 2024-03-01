package kz.aitu.onlineshop.services;

import kz.aitu.onlineshop.models.*;
import kz.aitu.onlineshop.repositories.*;
import kz.aitu.onlineshop.services.interfaces.BuyerServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService implements BuyerServiceInterface {
    private final BuyerRepositoryInterface repo;
    private final ProductRepositoryInterface repoProduct;
    private final OrderRepositoryInterface repoOrder;
    public BuyerService(BuyerRepositoryInterface repo, ProductRepositoryInterface repoProduct, OrderRepositoryInterface repoOrder) {
        this.repo = repo;
        this.repoProduct = repoProduct;
        this.repoOrder = repoOrder;
    }

    @Override
    public List<Order> getAllOrders(int id   ) {
        return repoOrder.findByBuyerId(id);
    }



    @Override
    public List<Product> getAllProducts() {
        return repoProduct.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return repoProduct.findById(id).orElse(null);
    }

    @Override
    public Order create(Order order) {
        return repoOrder.save(order);
    }

    @Override
    public Buyer getByEmail(String email) {
        return repo.findByEmail(email);
    }
    @Override
    public void updateBank(int id, double totalPrice) {
        Buyer buyer = repo.getById(id);
        buyer.setBank(buyer.getBank() - totalPrice);
        repo.save(buyer);
    }

}
