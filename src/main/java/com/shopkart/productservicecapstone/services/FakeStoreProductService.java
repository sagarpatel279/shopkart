package com.shopkart.productservicecapstone.services;

import com.shopkart.productservicecapstone.dtos.FakeStoreProductDetailsDto;
import com.shopkart.productservicecapstone.exceptions.ProductNotFoundException;
import com.shopkart.productservicecapstone.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product createProduct(String title,double price,String category, String description, String image) {
        FakeStoreProductDetailsDto fakeStoreProductDetailsDto = new FakeStoreProductDetailsDto();
        fakeStoreProductDetailsDto.setTitle(title);
        fakeStoreProductDetailsDto.setPrice(price);
        fakeStoreProductDetailsDto.setCategory(category);
        fakeStoreProductDetailsDto.setDescription(description);
        fakeStoreProductDetailsDto.setImage(image);

        FakeStoreProductDetailsDto responseDTO=restTemplate.postForObject("https://fakestoreapi.com/products",fakeStoreProductDetailsDto,FakeStoreProductDetailsDto.class);
        return responseDTO.toProduct();
    }

    @Override
    public Product getProduct(Long productId) throws ProductNotFoundException {
        FakeStoreProductDetailsDto fakeStoreDto=restTemplate.getForObject("https://fakestoreapi.com/products/" + productId, FakeStoreProductDetailsDto.class);
        if(fakeStoreDto==null){
            throw new ProductNotFoundException("Product with id: "+productId+" is not found");
        }
        return fakeStoreDto.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<FakeStoreProductDetailsDto[]> responseEntity=restTemplate.getForEntity("https://fakestoreapi.com/products",FakeStoreProductDetailsDto[].class);
        FakeStoreProductDetailsDto[] fakeStoreProductDetailsDtosArr=responseEntity.getBody();
        List<Product>  list=Arrays.asList(fakeStoreProductDetailsDtosArr).stream().map(fakeStoreDto->fakeStoreDto.toProduct()).toList();
        return list;
    }
    @Override
    public List<Product> getProductsByCategory(String category) {
        FakeStoreProductDetailsDto[] fakeProductsArr= restTemplate.getForEntity("https://fakestoreapi.com/products/category/"+category,FakeStoreProductDetailsDto[].class).getBody();
        List<Product> products=Arrays.asList(fakeProductsArr).stream().map(fakeProduct->fakeProduct.toProduct()).toList();
        return products;
    }

    @Override
    public Product updateWholeProductById(Long productId, String title, double price, String description, String image, String category) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product updateProductById(Long productId, String title, double price, String description, String image, String category) {
        return null;
    }

    @Override
    public void deleteProductById(Long productId) throws ProductNotFoundException {

    }

    @Override
    public int removeProductById(Long productId) throws ProductNotFoundException {
        return 0;
    }
}