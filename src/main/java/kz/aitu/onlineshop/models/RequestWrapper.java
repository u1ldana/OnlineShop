package kz.aitu.onlineshop.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestWrapper {
    private Product product;
    private Salesman salesman;
}
