package com.productApp.services.impl;

import com.productApp.entity.Product;
import com.productApp.model.ProductDto;
import com.productApp.repo.ProductRepo;
import com.productApp.services.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    public ProductDto createProduct(ProductDto prod) {
        Product product = new Product();
        BeanUtils.copyProperties(prod, product);
        Product saveEnt = productRepo.save(product);
        ProductDto prodDto = new ProductDto();
        BeanUtils.copyProperties(saveEnt,prodDto);
        return prodDto;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> productById = productRepo.findById(id);
        return productById.get();
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> prodRecords = productRepo.findAll();
        List<ProductDto> viewRecords = new ArrayList<>();
        for(Product product : prodRecords) {
            ProductDto dto = new ProductDto();
            BeanUtils.copyProperties(product, dto);
            viewRecords.add(dto);
        }
        return viewRecords;
    }

    @Override
    public boolean deleteProduct(long id) {
        boolean flag = false;
        Product productById = productRepo.findById(id).get();
        if (productById != null) {  // Fixed the typo here
            productRepo.deleteById(id);
            flag = true;
        }
        return false;
    }
}
