package com.cgrd.houry.persistence.integration;

import static com.cgrd.houry.persistence.domain.fixture.JPAAssertions.assertTableExists;

import org.junit.Test;

public class SchemaTests extends AbstractIntegrationTests {

    @Test
    public void checkTables() throws Exception {
        assertTableExists(entityManager, "project");
        assertTableExists(entityManager, "task");
        assertTableExists(entityManager, "entry");
    }
}
