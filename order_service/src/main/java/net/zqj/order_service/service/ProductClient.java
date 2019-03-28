package net.zqj.order_service.service;

import net.zqj.order_service.failback.ProductClientFailback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="product-service",fallback = ProductClientFailback.class)
public interface ProductClient {


    @GetMapping("/api/v1/product/find")
    String finfById(@RequestParam(value = "id")int id);
}
