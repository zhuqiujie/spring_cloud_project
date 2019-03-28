package net.zqj.order_service.failback;

import net.zqj.order_service.service.ProductClient;
import org.springframework.stereotype.Component;

/**
 * 针对商品服务做降级处理
 *
 */
@Component
public class ProductClientFailback implements ProductClient{
    @Override
    public String finfById(int id) {
        System.out.println("feign调用productClient失败");
        return null;
    }
}
