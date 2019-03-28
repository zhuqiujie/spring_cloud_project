package net.zqj.product_service.controller;

import net.zqj.product_service.domain.Product;
import net.zqj.product_service.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1/product")
public class ProductControllor {

    @Value("${server.port}")
    private  String port;

    @Autowired
    private ProductService productService;

    @RequestMapping("list")
    public Object list(){
        return productService.listProduct();
    }

    @RequestMapping("find")
    public Object findProduct(@RequestParam("id")int id){


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Product product = productService.findProductById(id);

        Product result = new Product();

        BeanUtils.copyProperties(product,result);

        result.setName(result.getName() + "data from port:"+port);

        return result;
    }

}
