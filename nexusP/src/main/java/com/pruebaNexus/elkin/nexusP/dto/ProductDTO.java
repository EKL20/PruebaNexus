package com.pruebaNexus.elkin.nexusP.dto;


import com.pruebaNexus.elkin.nexusP.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private Integer quantity;
    private LocalDate dateAdmission;
    private User user;
}
