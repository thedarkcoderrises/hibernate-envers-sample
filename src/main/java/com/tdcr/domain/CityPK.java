package com.tdcr.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CityPK implements Serializable {

    @Column
    private Long cityId;

    @Column
    private String cityCode;

    public CityPK() {
    }

    public CityPK(Long cityId, String cityCode) {
        super();
        this.cityCode =cityCode;
        this.cityId =cityId;
    }


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
