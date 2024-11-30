package Controllers;

import Models.Product;
import Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")

public class ProductController {
	
	@Autowired
    private final ProductService productService;

    
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Create a new Product
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // Get all Products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Get Product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long itemId) {
        Optional<Product> product = productService.getProductById(itemId);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a Product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long itemId, @RequestBody Product productDetails) {
        Optional<Product> existingProduct = productService.getProductById(itemId);
        if (existingProduct.isPresent()) {
            Product productToUpdate = existingProduct.get();
            productToUpdate.setItemName(productDetails.getItemName());
            productToUpdate.setCategory(productDetails.getCategory());
            productToUpdate.setBrand(productDetails.getBrand());
            productToUpdate.setModel(productDetails.getModel());
            productToUpdate.setSpecification(productDetails.getSpecification());
            productToUpdate.setPrice(productDetails.getPrice());
            productToUpdate.setInterested(productDetails.getInterested());

            Product updatedProduct = productService.saveProduct(productToUpdate);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable("id") Long itemId) {
        if (productService.getProductById(itemId).isPresent()) {
            productService.deleteProductById(itemId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get Products by Category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("category") String category) {
        List<Product> products = productService.getProductsByCategory(category);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Get Products with Interested Count Greater than a Specified Value
    @GetMapping("/interested/{count}")
    public ResponseEntity<List<Product>> getProductsByInterestedGreaterThan(@PathVariable("count") Integer interested) {
        List<Product> products = productService.getProductsByInterestedGreaterThan(interested);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Get Products by Brand
    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Product>> getProductsByBrand(@PathVariable("brand") String brand) {
        List<Product> products = productService.getProductsByBrand(brand);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
