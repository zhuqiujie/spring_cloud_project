package net.zqj.order_service.domain;

import java.util.Date;

/**
 * 商品订单实体类
 */
public class ProductOrder {
    private int id;

    private int userId;

    private String userName;

    private String productName;
    private String tradNo;//流水号

    private int price;

    private Date createDate;

    public ProductOrder() {
    }

    public ProductOrder(int id, int userId, String userName, String productName, String tradNo, int price, Date createDate) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.productName = productName;
        this.tradNo = tradNo;
        this.price = price;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTradNo() {
        return tradNo;
    }

    public void setTradNo(String tradNo) {
        this.tradNo = tradNo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
