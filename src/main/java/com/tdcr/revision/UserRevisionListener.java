package com.tdcr.revision;

import org.hibernate.envers.RevisionListener;

/**
 * Created by tdcr on 7/30/15.
 */
public class UserRevisionListener implements RevisionListener {

    public final static String USERNAME = "tdcr";

    @Override
    public void newRevision(Object revisionEntity) {
        UserRevEntity exampleRevEntity = (UserRevEntity) revisionEntity;
        exampleRevEntity.setUsername(USERNAME);
    }
}
