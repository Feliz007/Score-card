package com.feliz.scorecard.serviceImpl;

import com.feliz.scorecard.exceptions.SquadNotFoundException;
import com.feliz.scorecard.model.Squad;
import com.feliz.scorecard.repository.SquadRepository;
import com.feliz.scorecard.service.SquadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SquadImpl implements SquadService {
   private  final SquadRepository squadRepository;


    @Override
    public Squad getSquad(Long id) {
        Squad squad = squadRepository.findById(id).orElseThrow(()-> new SquadNotFoundException("Squad not found"));

        return squad;
    }
}
