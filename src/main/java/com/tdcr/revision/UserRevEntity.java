package com.tdcr.revision;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by tdcr on 7/30/15.
 */
@Entity
@RevisionEntity(UserRevisionListener.class)
public class UserRevEntity {

    @Id
    @GeneratedValue
    @RevisionNumber
    private int rev;
    @RevisionTimestamp
    private long timestamp;

    private String username;


    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
