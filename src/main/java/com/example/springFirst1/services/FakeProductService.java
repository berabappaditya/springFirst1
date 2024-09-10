package com.example.springFirst1.services;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import com.example.springFirst1.dtos.FakeStoreProductdto;
import com.example.springFirst1.extensions.ProductNotFoundException;
import com.example.springFirst1.models.Category;
import com.example.springFirst1.models.Product;

@Service
public class FakeProductService implements ProductService {

     private static final String FAKESTORE_API_URL = "https://api.escuelajs.co/api/v1/products/";

    
     
    private RestTemplate restTemplate;
    FakeProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Product createProduct(Product product) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        // TODO Auto-generated method stub
        String url = FAKESTORE_API_URL;

     /**  VVI:::: below code is Error because we are using generics in List<Product> and at runtime  it will be List<Object> for generics
          -> At runtime  typeErasure will happe it cannot convert response to List
          List<Product> products = restTemplate.getForObject(url, List<Product>.class);  */

        //In array we are not using generics so we are using Object class
        Product[] products = restTemplate.getForObject(url, Product[].class);

            System.err.println("________________>>>>"+products);
        if (products != null) {
            return List.of(products);
        }

        return null; 
    }

    private Product convertToProduct(FakeStoreProductdto productDto) {

        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());
        Category category = new Category();
        category.setId(productDto.getId());
       // category.(productDto.getCategory());
        return product;
    }

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        // TODO Auto-generated method stub
        // int[] arr = {1,2,3};
        // System.out.println(arr[4]);
        // int n = 2/0;
        String url = FAKESTORE_API_URL + id;
        Product product =null;
        try{
              product = restTemplate.getForObject(url, Product.class);
        }catch(HttpClientErrorException e){
            if (e.getStatusCode().value() >= 400) {
                throw new ProductNotFoundException(id,"Product not found CUSTOM EXCEPTION");
            }
            throw e;
        }
        if(product == null){
            throw new ProductNotFoundException(id, "Product not found");
           // return null;

        }
        return product;
       // return new Product();
        
    }

    @Override
    public Product putProduct(long id, Product product) {
        // VVI custom request callback put call with return type Product
        String url = FAKESTORE_API_URL + id;
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, Product.class);
		HttpMessageConverterExtractor<Product> responseExtractor =
				new HttpMessageConverterExtractor<>( Product.class,restTemplate.getMessageConverters());
		return restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor);

    }
    
    
}
