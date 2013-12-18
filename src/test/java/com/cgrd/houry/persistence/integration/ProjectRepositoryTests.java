package com.cgrd.houry.persistence.integration;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cgrd.houry.persistence.domain.Project;
import com.cgrd.houry.persistence.repository.ProjectRepository;

public class ProjectRepositoryTests extends AbstractIntegrationTests {

    @Autowired
    ProjectRepository projectRepository;

    @Test
    public void findAll() throws Exception {
        List<Project> projects = (List<Project>) projectRepository.findAll();
        assertEquals(3, projects.size());
    }
}
