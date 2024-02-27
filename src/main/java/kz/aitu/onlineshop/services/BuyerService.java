package kz.aitu.onlineshop.services;

import kz.aitu.onlineshop.models.Order;
import kz.aitu.onlineshop.models.Product;
import kz.aitu.onlineshop.repositories.BuyerRepositoryInterface;
import kz.aitu.onlineshop.repositories.SalesmanRepositoryInterface;
import kz.aitu.onlineshop.services.interfaces.BuyerServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService implements BuyerServiceInterface {
    private final BuyerRepositoryInterface repo;
    private final SalesmanRepositoryInterface repoProduct;

    public BuyerService(BuyerRepositoryInterface repo, SalesmanRepositoryInterface repoProduct) {
        this.repo = repo;
        this.repoProduct = repoProduct;
    }

    @Override
    public List<Order> getAllOrders(int id   ) {
        return repo.findByBuyerId(id);
    }



    @Override
    public List<Product> getAllProducts() {
        return repoProduct.findAll();
    }
}
