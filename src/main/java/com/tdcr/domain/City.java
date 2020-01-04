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

import java.io.Serializable;
import java.util.Random;

import javax.persistence.*;

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
	private String name;

	@Column
	private String state;

	@Column
	private String country;

	@Column
	private String map;

	protected City() {
	}

	public City(String name, String country) {
		super();

		this.cityPK= new CityPK(Long.valueOf(random.ints(0,(50+1)).findFirst().getAsInt())
				,(""+name.charAt(0)+country.charAt(0)+"".toUpperCase()));
		this.name = name;
		this.country = country;
	}

	public Long getCityId() {
		return this.cityPK.getCityId();
	}


	public String getName() {
		return this.name;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return this.country;
	}

	public String getMap() {
		return this.map;
	}


	@Override
	public String toString() {
		return getName() + "," + getState() + "," + getCountry();
	}
}
