package kz.aitu.onlineshop.controller;


import kz.aitu.onlineshop.models.Product;
import kz.aitu.onlineshop.models.RequestWrapper;
import kz.aitu.onlineshop.models.Salesman;
import kz.aitu.onlineshop.services.SalesmanService;
import kz.aitu.onlineshop.services.interfaces.SalesmanServiceInterface;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("salesman")
public class SalesmanController {
    private final SalesmanServiceInterface service;

    public SalesmanController(SalesmanService service) {
        this.service = service;
    }
    @PostMapping("/add")
    public ResponseEntity<Product> create(@RequestBody RequestWrapper request) {
        Product product = request.getProduct();
        Salesman salesman = request.getSalesman();

        Salesman realSalesman = service.getByEmail(salesman.getEmail());
        if (realSalesman != null && realSalesman.getPassword().equals(salesman.getPassword())) {
            product.setSalesmanId(realSalesman.getId());
            Product newProduct = service.create(product);
            if (newProduct != null) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{product_id}")
    public HttpStatus deleteById (@PathVariable("product_id") int id, @RequestBody Salesman salesman){
        String salesmanEmail = salesman.getEmail();
        Salesman realSalesman = service.getByEmail(salesmanEmail);
        if(realSalesman != null && realSalesman.getPassword().equals(salesman.getPassword())){
            if(service.getById(id) != null){
                service.deleteById(id);
                return HttpStatus.OK;
            }
            else{
                return HttpStatus.NOT_FOUND;
            }
        }else{
            return HttpStatus.NOT_FOUND;
        }
    }
}
