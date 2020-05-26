package com.ccm.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "swiper")
public class SwiperInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "computer_id")
    private Long computerId;

    @Column(name = "fir_url")
    private String firUrl;

    @Column(name = "sec_url")
    private String secUrl;

    @Column(name = "third_url")
    private String thirdUrl;

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
     * @return computer_id
     */
    public Long getComputerId() {
        return computerId;
    }

    /**
     * @param computerId
     */
    public void setComputerId(Long computerId) {
        this.computerId = computerId;
    }

    /**
     * @return fir_url
     */
    public String getFirUrl() {
        return firUrl;
    }

    /**
     * @param firUrl
     */
    public void setFirUrl(String firUrl) {
        this.firUrl = firUrl;
    }

    /**
     * @return sec_url
     */
    public String getSecUrl() {
        return secUrl;
    }

    /**
     * @param secUrl
     */
    public void setSecUrl(String secUrl) {
        this.secUrl = secUrl;
    }

    /**
     * @return third_url
     */
    public String getThirdUrl() {
        return thirdUrl;
    }

    /**
     * @param thirdUrl
     */
    public void setThirdUrl(String thirdUrl) {
        this.thirdUrl = thirdUrl;
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
        sb.append(", computerId=").append(computerId);
        sb.append(", firUrl=").append(firUrl);
        sb.append(", secUrl=").append(secUrl);
        sb.append(", thirdUrl=").append(thirdUrl);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append("]");
        return sb.toString();
    }
}