package com.tdcr.domain;

import com.tdcr.revision.UserRevEntity;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CITY_LOG")
public class CityLog extends BaseCityEnity implements Serializable {

	@OneToOne
	@JoinColumn(name = "REV",insertable = false ,updatable = false)
	private UserRevEntity userRevEntity;

	@EmbeddedId
	CityLogPK cityLogPK;

}
