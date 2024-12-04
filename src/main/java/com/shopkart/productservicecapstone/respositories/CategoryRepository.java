package com.shopkart.productservicecapstone.respositories;

import com.shopkart.productservicecapstone.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByName(String category);
}
