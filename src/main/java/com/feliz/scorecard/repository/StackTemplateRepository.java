package com.feliz.scorecard.repository;

import com.feliz.scorecard.model.StackTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StackTemplateRepository extends JpaRepository<StackTemplate,Long> {
    StackTemplate findByStackNameIgnoreCase(String stackName);
    boolean existsByStackName(String stackName);
}
