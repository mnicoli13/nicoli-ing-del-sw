package IngDelSw.nicoli.controller;

import IngDelSw.nicoli.model.Product;
import IngDelSw.nicoli.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/store")
    public ResponseEntity<?> storeProduct(@RequestBody Product productRequest) {
        try {
            Product product = productService.storeProduct(
                    productRequest.getProductName()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) {
        try {
            Product product = productService.getProduct(id);

            return ResponseEntity.ok(product);  //200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());  //404
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody Product productRequest) {
        try {
            Product product = productService.updateProduct(
                    productRequest.getProductId(),
                    productRequest.getProductName()
            );

            return ResponseEntity.ok(product);  //200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());  //404
        }
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        try {
            productService.deleteProduct(id);

            return ResponseEntity.ok("patient deleted successfully");  //200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());  //404
        }
    }
}
