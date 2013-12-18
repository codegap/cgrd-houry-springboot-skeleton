package com.cgrd.houry.persistence.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cgrd.houry.persistence.domain.Project;

public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
    List<Project> findByDescription(String description);
}