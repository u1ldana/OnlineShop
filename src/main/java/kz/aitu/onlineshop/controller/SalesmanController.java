package kz.aitu.onlineshop.controller;

import kz.aitu.onlineshop.models.Product;
import kz.aitu.onlineshop.services.SalesmanService;
import kz.aitu.onlineshop.services.interfaces.SalesmanServiceInterface;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
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
    public ResponseEntity<Product> create(@RequestBody Product product){
        Product newProduct = service.create(product);
        if(newProduct!=null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(newProduct,HttpStatus.OK);
        }
    }
    @DeleteMapping("/delete/{product_id}")
    public HttpStatus deleteById (@PathVariable("product_id") int id){
        if(service.getById(id) != null){
            service.deleteById(id);
            return HttpStatus.OK;
        }
        else{
            return HttpStatus.NOT_FOUND;
        }
    }
}
