package kz.aitu.onlineshop.services;

import kz.aitu.onlineshop.models.Product;
import kz.aitu.onlineshop.models.Salesman;
import kz.aitu.onlineshop.models.User;
import kz.aitu.onlineshop.repositories.ProductRepositoryInterface;
import kz.aitu.onlineshop.repositories.SalesmanRepositoryInterface;
import kz.aitu.onlineshop.repositories.UserRepositoryInterface;
import kz.aitu.onlineshop.services.interfaces.SalesmanServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class SalesmanService implements SalesmanServiceInterface {
    private final ProductRepositoryInterface repo;
    private final SalesmanRepositoryInterface salesmanRepo;

    public SalesmanService(ProductRepositoryInterface repo, SalesmanRepositoryInterface salesmanRepo) {
        this.repo = repo;
        this.salesmanRepo = salesmanRepo;
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

    @Override
    public boolean updateQuantity(int id, int requestedQuantity) {
        Product product = repo.getById(id);
        if(product.getQuantity()-requestedQuantity > 0){
            product.setQuantity(product.getQuantity() - requestedQuantity);
            repo.save(product);
            return true;
        } else if (product.getQuantity()-requestedQuantity == 0) {
            repo.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void updateBank(int id, double totalPrice) {
        Salesman salesman = salesmanRepo.getById(id);
        salesman.setBank(salesman.getBank() + totalPrice);
        salesmanRepo.save(salesman);
    }

    @Override
    public Salesman getByEmail(String email) {
        return salesmanRepo.findByEmail(email);
    }

}
