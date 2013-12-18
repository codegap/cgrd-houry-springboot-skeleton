package com.cgrd.houry.persistence.integration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cgrd.houry.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@ActiveProfiles("test")
public abstract class AbstractIntegrationTests {
    @Autowired
    ApplicationContext context;

    protected EntityManager entityManager;

    @Before
    public void init() {
        EntityManagerFactory entityManagerFactory =
            context.getBean(EntityManagerFactory.class);
        entityManager = entityManagerFactory.createEntityManager();
    }

    @After
    public void close() {
        entityManager.close();
    }
}
