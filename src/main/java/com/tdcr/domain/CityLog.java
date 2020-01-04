package com.tdcr.domain;

import com.tdcr.revision.UserRevEntity;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CITY_LOG")
public class CityLog extends CityLogPK implements Serializable {

	@OneToOne
	@JoinColumn(name = "rev")
	private UserRevEntity userRevEntity;

	@Column
	private String name;

	@Column
	private String state;

	@Column
	private String country;

	@Column
	private String map;

}
