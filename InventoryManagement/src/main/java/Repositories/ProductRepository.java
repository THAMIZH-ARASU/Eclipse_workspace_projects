package Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Custom query methods can be defined here if needed

    // Example: Find products by category
    List<Product> findByCategory(String category);

    // Example: Find products with interested count greater than specified value
    List<Product> findByInterestedGreaterThan(Integer interested);

    // Example: Find products by brand
    List<Product> findByBrand(String brand);

}