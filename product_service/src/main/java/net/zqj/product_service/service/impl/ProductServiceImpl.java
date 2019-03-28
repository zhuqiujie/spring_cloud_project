package net.zqj.product_service.service.impl;

import net.zqj.product_service.domain.Product;
import net.zqj.product_service.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService{

    private static Map<Integer,Product> daoMap = new HashMap<Integer,Product>();

    static {
        Product product0 = new Product(1,"aa1",1,1);
        Product product1 = new Product(2,"aa2",1,1);
        Product product2 = new Product(3,"aa3",1,1);
        Product product3 = new Product(4,"aa4",1,1);
        Product product4 = new Product(5,"aa5",1,1);
        Product product5 = new Product(6,"aa6",1,1);
        Product product6 = new Product(7,"aa7",1,1);

        daoMap.put(product0.getId(),product0);
        daoMap.put(product1.getId(),product1);
        daoMap.put(product2.getId(),product2);
        daoMap.put(product3.getId(),product3);
        daoMap.put(product4.getId(),product4);
        daoMap.put(product5.getId(),product5);
        daoMap.put(product6.getId(),product6);
    }


    @Override
    public List<Product> listProduct() {
        Collection<Product> collection = daoMap.values();

        List<Product> list = new ArrayList<>(collection);

        return list;
    }

    @Override
    public Product findProductById(int id) {
        return daoMap.get(id);
    }
}
