package com.tdcr.domain;

import java.io.Serializable;
public class CityPK implements Serializable {

    private Long cityId;
    private String cityCode;


    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
