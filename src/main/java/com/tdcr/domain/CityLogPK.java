package com.tdcr.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Embeddable
public class CityLogPK extends CityPK{

    @Column(name = "REV")
    private int rev;
}
