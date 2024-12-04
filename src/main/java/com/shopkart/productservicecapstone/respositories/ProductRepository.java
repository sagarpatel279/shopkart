package com.shopkart.productservicecapstone.respositories;

import com.shopkart.productservicecapstone.models.Category;
import com.shopkart.productservicecapstone.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProductRepository  extends JpaRepository<Product,Long> {
    List<Product> findAllByCategory(Category category);
}
