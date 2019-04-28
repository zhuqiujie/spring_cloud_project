package net.zqj.order_service.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import net.zqj.order_service.domain.ProductOrder;
import net.zqj.order_service.service.ProductClient;
import net.zqj.order_service.service.ProductOrderService;
import net.zqj.order_service.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private ProductClient productClient;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public ProductOrder save(int userId, int productId) {

/**
 *

       Map<String,Object> productMap = restTemplate.getForObject("http://product-service/api/v1/product/find?id="+productId,Map.class);
       // ServiceInstance instance = loadBalancer.choose("product-service");
       //System.out.println(object);

        ProductOrder productOrder = new ProductOrder();

        productOrder.setCreateDate(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradNo(UUID.randomUUID().toString());
        productOrder.setProductName(productMap.get("name").toString());
        productOrder.setPrice(Integer.parseInt(productMap.get("price").toString()));

        return productOrder;

 */
        logger.info("service saveOrder  userId:"+userId+"    productId:"+productId);
        if(userId==1){
            return null;
        }


        //调用商品服务 
      String response =  productClient.finfById(productId);

      JsonNode jsonNode = JsonUtils.str2JsonNode(response);


        ProductOrder productOrder = new ProductOrder();

        productOrder.setCreateDate(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradNo(UUID.randomUUID().toString());
        productOrder.setProductName(jsonNode.get("name").toString());
        productOrder.setPrice(Integer.parseInt(jsonNode.get("price").toString()));

    return productOrder;

    }
}
