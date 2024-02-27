package kz.aitu.onlineshop.services;

import kz.aitu.onlineshop.models.Product;
import kz.aitu.onlineshop.models.User;
import kz.aitu.onlineshop.repositories.SalesmanRepositoryInterface;
import kz.aitu.onlineshop.repositories.UserRepositoryInterface;
import kz.aitu.onlineshop.services.interfaces.SalesmanServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class SalesmanService implements SalesmanServiceInterface {
    private final SalesmanRepositoryInterface repo;

    public SalesmanService(SalesmanRepositoryInterface repo) {
        this.repo = repo;
    }
    @Override
    public Product create(Product product){
        return repo.save(product);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
    @Override
    public Product getById(int id) {
        return repo.findById(id).orElse(null);
    }
}
