package net.zqj.product_service.service;

import net.zqj.product_service.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> listProduct();

    Product findProductById(int id);
}
