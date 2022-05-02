package com.pruebaNexus.elkin.nexusP.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private Integer age;
    private PositionDTO position;
    private LocalDate dateAdmission;
}
