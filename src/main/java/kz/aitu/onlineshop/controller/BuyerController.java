package kz.aitu.onlineshop.controller;

import kz.aitu.onlineshop.models.Buyer;
import kz.aitu.onlineshop.models.Order;
import kz.aitu.onlineshop.models.Product;
import kz.aitu.onlineshop.models.User;
import kz.aitu.onlineshop.services.interfaces.BuyerServiceInterface;
import kz.aitu.onlineshop.services.interfaces.SalesmanServiceInterface;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("buyer")
public class BuyerController {
    private final BuyerServiceInterface service;
    private final SalesmanServiceInterface salesmanService;

    public BuyerController(BuyerServiceInterface service, SalesmanServiceInterface salesmanService) {
        this.service = service;
        this.salesmanService = salesmanService;
    }

    @GetMapping("/allproduct")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }
    @GetMapping("/orders/{buyer_id}")
    public List<Order> getAllOrders(@PathVariable("buyer_id") int id){
        return service.getAllOrders(id);
    }
    @PostMapping("/buy/{product_id}/{quantity}")
    public ResponseEntity<Order> buy(@PathVariable("product_id") int productId,@PathVariable("quantity") int requestedQuantity, @RequestBody Buyer buyer){
        String buyerEmail = buyer.getEmail();
        String buyerPassword = buyer.getPassword();
        Buyer realBuyer = service.getByEmail(buyerEmail);
        if(realBuyer != null && realBuyer.getPassword().equals(buyer.getPassword())){
            Product product = service.getProductById(productId);
            int salesmanId = product.getSalesmanId();
            double totalPrice = requestedQuantity*product.getPrice();
            if (salesmanService.updateQuantity(productId,requestedQuantity)){
                salesmanService.updateBank(salesmanId, totalPrice);

                service.updateBank(realBuyer.getId(),totalPrice);
                Order order = new Order();
                order.setProductId(productId);
                order.setQuantity(requestedQuantity);
                order.setTotalPrice(totalPrice);
                order.setBuyerId(realBuyer.getId());
                service.create(order);
                return new ResponseEntity<>(order, HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>(HttpStatus.LOCKED);
    }
}
