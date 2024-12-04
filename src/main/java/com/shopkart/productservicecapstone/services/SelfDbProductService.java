package com.shopkart.productservicecapstone.services;

import com.shopkart.productservicecapstone.exceptions.ProductNotFoundException;
import com.shopkart.productservicecapstone.models.Category;
import com.shopkart.productservicecapstone.models.Product;
import com.shopkart.productservicecapstone.respositories.CategoryRepository;
import com.shopkart.productservicecapstone.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfDbProductService")
public class SelfDbProductService implements  ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    @Autowired
    public SelfDbProductService(ProductRepository productRepository,
                                CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product createProduct(String title, double price, String category, String description, String image) {
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageUrl(image);
        Category cat;
        Optional<Category> catOptional=categoryRepository.findByName(category);
        cat = catOptional.orElseGet(Category::new);
        cat.setName(category);
        product.setCategory(cat);
        productRepository.save(product);
        return product;
    }

    @Override
    public Product getProduct(Long productId) throws ProductNotFoundException {
        return productRepository.findById(productId).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findAllByCategory(categoryRepository.findByName(category).get());
    }

    @Override
    public Product updateProductById(Long productId, String title, double price, String description, String image, String category) throws ProductNotFoundException {
        boolean isProductExist=productRepository.existsById(productId);
        if(!isProductExist){
            throw new ProductNotFoundException("Product is not found");
        }
        Product product = new Product();
        product.setId(productId);
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageUrl(image);
        product.setCategory(category!=null?categoryRepository.findByName(category).get():null);
        productRepository.save(product);
        return product;
    }
}
