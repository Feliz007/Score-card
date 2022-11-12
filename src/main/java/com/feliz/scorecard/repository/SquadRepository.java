
package com.feliz.scorecard.repository;

import com.feliz.scorecard.model.Squad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquadRepository  extends JpaRepository<Squad, Long> {
    Squad findBySquadName(String squadName);
    boolean existsBySquadName(String squadName);
    Page<Squad> findAll(Pageable pageable);

}

