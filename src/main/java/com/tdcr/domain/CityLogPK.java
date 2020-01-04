package com.tdcr.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class CityLogPK extends CityPK implements Serializable {

    @Id
    @Column(name = "REV")
    private int rev;
}
