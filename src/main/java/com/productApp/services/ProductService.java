package com.productApp.services;

import com.productApp.model.ProductDto;
import com.productApp.entity.Product;
import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto product);

    Product getProductById(Long id);

    List<ProductDto> getAllProducts();

    boolean deleteProduct(long id);
}
