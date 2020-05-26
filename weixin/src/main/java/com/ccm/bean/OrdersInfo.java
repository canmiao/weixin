package com.ccm.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "orders")
public class OrdersInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "good_detail")
    private String goodDetail;

    private String price;

    @Column(name = "is_check")
    private Byte isCheck = 0;

    private String status = "0";

    @Column(name = "create_time")
    private Date createTime = new Date();

    @Column(name = "modify_time")
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return good_detail
     */
    public String getGoodDetail() {
        return goodDetail;
    }

    /**
     * @param goodDetail
     */
    public void setGoodDetail(String goodDetail) {
        this.goodDetail = goodDetail;
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
     * @return is_check
     */
    public Byte getIsCheck() {
        return isCheck;
    }

    /**
     * @param isCheck
     */
    public void setIsCheck(Byte isCheck) {
        this.isCheck = isCheck;
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
        sb.append(", id=").append(id);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", goodDetail=").append(goodDetail);
        sb.append(", price=").append(price);
        sb.append(", isCheck=").append(isCheck);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append("]");
        return sb.toString();
    }
}