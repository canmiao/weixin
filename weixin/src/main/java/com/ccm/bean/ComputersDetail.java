package com.ccm.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "computers")
public class ComputersDetail implements Serializable {
    @Id
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "goods_describe")
    private String goodsDescribe;

    private String price;

    @Column(name = "image_url")
    private String imageUrl;

    private Date date;

    private String status = "0";

    @Column(name = "create_time")
    private Date createTime = new Date();

    @Column(name = "modify_time")
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return order_id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return goods_describe
     */
    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    /**
     * @param goodsDescribe
     */
    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    /**
     * @return price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return image_url
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", goodsDescribe=").append(goodsDescribe);
        sb.append(", price=").append(price);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", date=").append(date);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append("]");
        return sb.toString();
    }
}