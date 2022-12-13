

package com.feliz.scorecard.service;

import com.feliz.scorecard.dto.PodRequestDto;
import com.feliz.scorecard.dto.PodResponseDto;

public interface PodService {
    PodResponseDto createPod(Long id, PodRequestDto requestDto);

    PodRequestDto updatePod(Long id, PodRequestDto requestDto);
}