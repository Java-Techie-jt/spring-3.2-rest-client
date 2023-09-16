package com.javatechie.client;

import com.javatechie.dto.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ProductServiceClient {

    private final RestClient restClient;

    public ProductServiceClient() {
        restClient = RestClient.builder()
                .baseUrl("http://localhost:9191")
                .build();
    }

    public Product saveNewProduct(Product product) {
        return restClient.post()
                .uri("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .body(product)
                .retrieve()
                .body(Product.class);
    }


    public List<Product> getAllProducts(){
        return restClient.get()
                .uri("/products")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Product>>(){});
    }

    public Product getProduct(int id){
        return restClient.get()
                .uri("/products/find/{id}",id)
                .retrieve()
                .body(Product.class);
    }


    public Product updateProduct(int id,Product product){
     return restClient.put()
             .uri("/products/{id}",id)
             .contentType(MediaType.APPLICATION_JSON)
             .body(product)
             .retrieve()
             .body(Product.class);
    }

    public String deleteProduct(int id){
        restClient.delete()
                .uri("/products/{id}",id)
                .retrieve()
                .toBodilessEntity();
        return "product removed : "+id;
    }


}
