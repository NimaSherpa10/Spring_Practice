package com.productApp.rest;

import com.productApp.entity.Product;
import com.productApp.model.ProductDto;
import com.productApp.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    private ProductServiceImpl productServiceImpl;
    @PostMapping("/products")
    public ResponseEntity saveProduct(@RequestBody ProductDto product) {
       ProductDto productInfo = productServiceImpl.createProduct(product);
        return new ResponseEntity<>(productInfo, HttpStatus.CREATED);
    }

    @GetMapping(value = "/view")
    public ResponseEntity<?> getProducts() {
        List<ProductDto> allProducts = productServiceImpl.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.CREATED);
    }

    @GetMapping("/byId/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productServiceImpl.getProductById(id);
    }

    //Delete item by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long id) {
        boolean deleteProduct = productServiceImpl.deleteProduct(id);
        if (deleteProduct) {
            return new ResponseEntity<>("Product deleted", HttpStatus.OK);

        } else return new ResponseEntity<>("Product does not exist", HttpStatus.OK);

    }

}
