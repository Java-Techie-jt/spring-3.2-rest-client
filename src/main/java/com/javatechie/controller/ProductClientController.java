package com.javatechie.controller;

import com.javatechie.client.ProductServiceClient;
import com.javatechie.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-client/products")
public class ProductClientController {

    @Autowired
    private ProductServiceClient serviceClient;


    @PostMapping
    public Product saveNewProduct(@RequestBody Product product) {
        return serviceClient.saveNewProduct(product);
    }


    @GetMapping
    public List<Product> getAllProducts(){
        return serviceClient.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id){
        return serviceClient.getProduct(id);
    }


    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id,@RequestBody Product product){
        return serviceClient.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id){
        return serviceClient.deleteProduct(id);
    }

}
