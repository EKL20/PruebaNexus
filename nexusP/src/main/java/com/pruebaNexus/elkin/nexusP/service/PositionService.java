package com.pruebaNexus.elkin.nexusP.service;

import com.pruebaNexus.elkin.nexusP.dto.PositionCreateDTO;
import com.pruebaNexus.elkin.nexusP.dto.PositionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface PositionService {

    void save(PositionCreateDTO PositionDTO);

    Page<PositionDTO> SearchPosition(String query, Pageable pageable);

    Optional<PositionDTO> findOne(Long id);

    PositionDTO update(PositionCreateDTO positionDTO, Long id);

    void delete(Long id);
}
