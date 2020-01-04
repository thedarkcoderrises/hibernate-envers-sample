/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tdcr.domain;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Random;

@Entity
@Audited
@AuditTable("CITY_LOG")
@Table (name = "CITY")
public class City implements Serializable {
	@Transient
	Random random = new Random();

	@EmbeddedId
	private CityPK cityPK;

    @Column
    @Audited(withModifiedFlag = true)
    private String name;

    @Audited(withModifiedFlag = true)
    @Column
    private String state;

    @Column
    private String country;

    @Column
    private String map;

    @Column
    private Timestamp insert;

    @Column
    private Timestamp update;

    @Column
    private String action;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }


	protected City() {
	}

	public City(String name, String country) {
		super();

		this.cityPK= new CityPK(Long.valueOf(random.ints(0,(50+1)).findFirst().getAsInt())
				,(""+name.charAt(0)+country.charAt(0)+"".toUpperCase()));
		setName(name);
		setCountry(country);
		insert = new Timestamp(System.currentTimeMillis());
		update = insert;
	}

	public Long getCityId() {
		return this.cityPK.getCityId();
	}

	@Override
	public String toString() {
		return getName() + "," + getState() + "," + getCountry();
	}

    public void setUpdate(Timestamp timestamp) {
        this.update = timestamp;
    }

    public Timestamp getInsert() {
        return insert;
    }

    public Timestamp getUpdate() {
        return update;
    }

    @PrePersist
    @PreUpdate
    public void setAction(){
        if(this.insert == this.update){
            this.action ="I";
        }else{
            this.action ="U";
        }
    }
}
