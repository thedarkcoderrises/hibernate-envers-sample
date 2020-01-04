package com.tdcr.revision;

import com.tdcr.config.ContextLookup;
import com.tdcr.domain.CityLog;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.RevisionListener;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;

import javax.persistence.EntityManager;

/**
 * Created by tdcr on 7/30/15.
 */
public class UserRevisionListener implements RevisionListener {


    public final static String USERNAME = "tdcr";

    @Override
    public void newRevision(Object revisionEntity) {
        UserRevEntity exampleRevEntity = (UserRevEntity) revisionEntity;
        EntityManager entityManager = ContextLookup.getStaticContext().getBean(EntityManager.class);
        AuditReader reader = AuditReaderFactory.get(entityManager);

        AuditQuery q =reader.createQuery().forRevisionsOfEntity(CityLog.class, true, true);
        q.add(AuditEntity.id().eq(exampleRevEntity.getRev()));
//        List<CityLog> audit = q.getResultList();

        exampleRevEntity.setUsername(USERNAME);
    }


}
