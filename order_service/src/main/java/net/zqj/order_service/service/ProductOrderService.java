package net.zqj.order_service.service;

import net.zqj.order_service.domain.ProductOrder;

public interface ProductOrderService {

    public ProductOrder save(int userId,int productId);
}
