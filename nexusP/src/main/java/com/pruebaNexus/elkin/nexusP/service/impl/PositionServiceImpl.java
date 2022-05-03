package com.pruebaNexus.elkin.nexusP.service.impl;

import com.pruebaNexus.elkin.nexusP.commons.exceptions.GenericConflictException;
import com.pruebaNexus.elkin.nexusP.dto.PositionCreateDTO;
import com.pruebaNexus.elkin.nexusP.dto.PositionDTO;
import com.pruebaNexus.elkin.nexusP.mapper.PositionMapper;
import com.pruebaNexus.elkin.nexusP.model.Position;
import com.pruebaNexus.elkin.nexusP.repository.PositionRepository;
import com.pruebaNexus.elkin.nexusP.service.PositionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.pruebaNexus.elkin.nexusP.exceptions.PositionError.ELEMENT_NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;
    private final PositionMapper mapper;

    @Override
    @Transactional
    public void save(PositionCreateDTO PositionDTO) {
        log.debug("Request to save Position : {}", PositionDTO);
        positionRepository.save(mapper.toEntity(PositionDTO));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PositionDTO> SearchPosition(String query, Pageable pageable) {
        log.debug("Request to search Position");
        return positionRepository.search(query, pageable).map(mapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PositionDTO> findOne(Long id) {
        log.debug("Request to get Position : {}", id);
        return positionRepository.findById(id)
                .map(mapper::toDto);
    }

    @Override
    @Transactional
    public PositionDTO update(PositionCreateDTO positionDTO, Long id) {
        if(!positionRepository.findById(id).isPresent()){
            throw new GenericConflictException(ELEMENT_NOT_FOUND);
        }
        log.debug("Request to Update Position : {}",positionDTO);
        Position position = mapper.toEntity(positionDTO);
        position.setId(id);
        return mapper.toDto(positionRepository.save(position));
    }

    @Override
    public void delete(Long id) {
        positionRepository.deleteById(id);
    }
}
