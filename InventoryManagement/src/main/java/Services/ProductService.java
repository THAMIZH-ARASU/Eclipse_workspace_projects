package Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Models.Product;
import Repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
    private final ProductRepository productRepository;

    
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Create or Update Product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Get all Products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get Product by ID
    public Optional<Product> getProductById(Long itemId) {
        return productRepository.findById(itemId);
    }

    // Delete Product by ID
    public void deleteProductById(Long itemId) {
        productRepository.deleteById(itemId);
    }

    // Find Products by Category
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    // Find Products with Interested Count Greater than a Specified Value
    public List<Product> getProductsByInterestedGreaterThan(Integer interested) {
        return productRepository.findByInterestedGreaterThan(interested);
    }

    // Find Products by Brand
    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }
}