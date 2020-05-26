package com.ccm.dto;

import com.ccm.bean.ComputersDetail;

public class DetailInfoDTO extends ComputersDetail {
    private String firUrl;
    private String secUrl;
    private String thirdUrl;

    public String getFirUrl() {
        return firUrl;
    }

    public void setFirUrl(String firUrl) {
        this.firUrl = firUrl;
    }

    public String getSecUrl() {
        return secUrl;
    }

    public void setSecUrl(String secUrl) {
        this.secUrl = secUrl;
    }

    public String getThirdUrl() {
        return thirdUrl;
    }

    public void setThirdUrl(String thirdUrl) {
        this.thirdUrl = thirdUrl;
    }
}
