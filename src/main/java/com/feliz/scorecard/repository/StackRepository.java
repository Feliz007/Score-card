package com.feliz.scorecard.repository;

import com.feliz.scorecard.model.Stack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StackRepository extends JpaRepository<Stack, Long> {
    List<Stack> findAllStackBySquadId(Long squadId);

    Stack findByStackName(String stackName);
    Optional<Stack> findById(Long id);



}
