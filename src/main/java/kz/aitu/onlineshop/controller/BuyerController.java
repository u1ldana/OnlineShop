package kz.aitu.onlineshop.controller;

import kz.aitu.onlineshop.models.Order;
import kz.aitu.onlineshop.models.Product;
import kz.aitu.onlineshop.services.interfaces.BuyerServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("buyer")
public class BuyerController {
    private final BuyerServiceInterface service;

    public BuyerController(BuyerServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/allproduct")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }
    @GetMapping("/orders/{buyer_id}")
    public List<Order> getAllOrders(@PathVariable("buyer_id") int id){
        return service.getAllOrders(id);
    }
}
