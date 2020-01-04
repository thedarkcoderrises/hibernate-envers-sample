package com.tdcr.envers;

import com.tdcr.envers.impl.CustomEnversPreInsertEventListenerImpl;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

@Component
public class EnversListenerConfiguration {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @PostConstruct
    public void init(){

        SessionFactoryImpl sessionFactory = entityManagerFactory.unwrap(SessionFactoryImpl.class);
        EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);

        registry.getEventListenerGroup(EventType.PRE_INSERT).appendListener(new CustomEnversPreInsertEventListenerImpl());
//        registry.getEventListenerGroup(EventType.PRE_UPDATE).appendListener(new CustomEnversPreUpdateEventListenerImpl(enversService));
    }
}
