package com.pruebaNexus.elkin.nexusP.controller;

import com.pruebaNexus.elkin.nexusP.dto.UserCreateDTO;
import com.pruebaNexus.elkin.nexusP.dto.UserDTO;
import com.pruebaNexus.elkin.nexusP.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserCreateDTO request) throws URISyntaxException {
        log.info("REST request to save Position : {}", request);
        userService.save(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Page<UserDTO>> searchUser
            (@RequestParam(name = "query", required = false, defaultValue = "")
                     String query, @RequestParam(defaultValue = "0") int pageNumber,
             @RequestParam(defaultValue = "3") int pageSize) {
        log.info("REST request to get a page of User");
        Page<UserDTO> page = userService.SearchUser(query, PageRequest.of(pageNumber, pageSize));
        return ResponseEntity.ok().body(page);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> searchUserId(@PathVariable Long id) {
        log.info("REST request to get User : {}", id);
        Optional<UserDTO> userDTO = userService.findOne(id);
        return ResponseEntity.of(userDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserCreateDTO
                                                                    userCreateDTO,
                                                      @PathVariable("id") Long id) {
        log.info("REST request to update User : {}", userCreateDTO);
        UserDTO result = userService.update(userCreateDTO, id);
        return ResponseEntity.ok()
                .body(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        log.info("REST request to delete User : {}", id);
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
