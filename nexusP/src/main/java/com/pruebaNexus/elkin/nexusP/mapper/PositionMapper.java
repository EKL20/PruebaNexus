package com.pruebaNexus.elkin.nexusP.mapper;

import com.pruebaNexus.elkin.nexusP.commons.model.EntityMapper;
import com.pruebaNexus.elkin.nexusP.dto.PositionCreateDTO;
import com.pruebaNexus.elkin.nexusP.dto.PositionDTO;
import com.pruebaNexus.elkin.nexusP.model.Position;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface PositionMapper extends EntityMapper<PositionDTO, Position> {

    Position toEntity(PositionCreateDTO position);
}
