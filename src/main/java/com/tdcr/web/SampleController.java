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

package com.tdcr.web;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tdcr.domain.City;
import com.tdcr.domain.Hotel;
import com.tdcr.service.CityService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;

@Controller
public class SampleController {

	Long cityId;

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	private CityService cityService;

	@RequestMapping("/")
	@ResponseBody
	@Transactional(readOnly = true)
	public String helloWorld() {
		return this.cityService.getCity("Bath", "UK").getName();
	}

	@RequestMapping("/addCity")
	@ResponseBody
	@Transactional(readOnly = true)
	public String addCity() {
		City city = new City("Oxford", "UK");
		city.setState("Wrong state");
		entityManager.persist(city);
		entityManager.flush();
		cityId = city.getCityId();

		return city.toString();
	}

	@RequestMapping("/changeCity")
	@ResponseBody
	@Transactional(readOnly = true)
	public String changeCity() {
		City updateCity = this.cityService.getCity("Oxford", "UK");
		updateCity.setState("Oxfordshire");
		updateCity.setUpdate(new Timestamp(System.currentTimeMillis()));
		entityManager.persist(updateCity);
		entityManager.flush();
		return this.cityService.getCity("Oxford", "UK").toString();
	}

	@RequestMapping("/showCity")
	@ResponseBody
	@Transactional(readOnly = true)
	public String showRevision() {
		AuditReader reader = AuditReaderFactory.get(entityManager);
		City city_rev1 = reader.find(City.class, cityId, 1);
		City city_rev2 = reader.find(City.class, cityId, 2);
		return "Revision 1: " + city_rev1.toString() + "\n Revision 2: " + city_rev2.toString();
	}

	@RequestMapping("/addHotel")
	@ResponseBody
	@Transactional(readOnly = true)
	public String addHotel() {
		Hotel hotel = new Hotel(this.cityService.getCity("Oxford", "UK"), "Bath hotel");
		entityManager.persist(hotel);
		entityManager.flush();

		return hotel.getName();
	}


}
