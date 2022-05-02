package com.pruebaNexus.elkin.nexusP.controller;

import com.pruebaNexus.elkin.nexusP.dto.PositionCreateDTO;
import com.pruebaNexus.elkin.nexusP.dto.PositionDTO;
import com.pruebaNexus.elkin.nexusP.service.PositionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/position")
public class PositionController {

    private final PositionService positionService;

    @PostMapping
    public ResponseEntity<Void> createPosition(@Valid @RequestBody PositionCreateDTO request) throws URISyntaxException {
        log.info("REST request to save Position : {}", request);
        positionService.save(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Page<PositionDTO>> searchPosition
            (@RequestParam(name = "query", required = false, defaultValue = "")
                     String query, @RequestParam(defaultValue = "0") int pageNumber,
             @RequestParam(defaultValue = "3") int pageSize) {
        log.info("REST request to get a page of Position");
        Page<PositionDTO> page = positionService.SearchPosition(query, PageRequest.of(pageNumber, pageSize));
        return ResponseEntity.ok().body(page);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PositionDTO> searchPositionId(@PathVariable Long id) {
        log.info("REST request to get Position : {}", id);
        Optional<PositionDTO> positionDTO = positionService.findOne(id);
        return ResponseEntity.of(positionDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PositionDTO> updatePosition(@Valid @RequestBody PositionCreateDTO
                                                                          positionCreateDTO,
                                                                  @PathVariable("id") Long id) {
        log.info("REST request to update Position : {}", positionCreateDTO);
        PositionDTO result = positionService.update(positionCreateDTO, id);
        return ResponseEntity.ok()
                .body(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePosition(@PathVariable Long id) {
        log.info("REST request to delete Position : {}", id);
        positionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
