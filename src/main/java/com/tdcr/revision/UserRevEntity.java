package com.tdcr.revision;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.*;

/**
 * Created by tdcr on 7/30/15.
 */
@Entity
@RevisionEntity(UserRevisionListener.class)
public class UserRevEntity {

    @Id
    @GeneratedValue // TODO custom-sequence
    @RevisionNumber
    private int rev;
    @RevisionTimestamp
    private long timestamp;

    private String username;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public int getRev() {
        return rev;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
