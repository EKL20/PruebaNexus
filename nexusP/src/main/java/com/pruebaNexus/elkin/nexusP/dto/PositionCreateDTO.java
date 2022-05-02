package com.pruebaNexus.elkin.nexusP.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PositionCreateDTO implements Serializable {

    private static final long serialVersionUID = -8441499614121235452L;

    @NotBlank
    @Size(min = 2, max = 20)
    private String name;
}
