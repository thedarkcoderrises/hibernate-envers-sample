package com.tdcr.domain;

import com.tdcr.revision.UserRevEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "CITY_LOG")
public class CityLog implements Serializable {

	@OneToOne
	@JoinColumn(name = "REV",insertable = false ,updatable = false)
	private UserRevEntity userRevEntity;

	@EmbeddedId
	CityLogPK cityLogPK;

	@Column
	private String name;

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

}
