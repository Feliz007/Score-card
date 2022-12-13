package com.feliz.scorecard.repository;

import com.feliz.scorecard.model.Pod;
import com.feliz.scorecard.model.Stack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PodRepository extends JpaRepository<Pod, Long> {

    boolean existsByPodName(String podName);

    List<Pod> findAllByStack(Stack stack);

}
