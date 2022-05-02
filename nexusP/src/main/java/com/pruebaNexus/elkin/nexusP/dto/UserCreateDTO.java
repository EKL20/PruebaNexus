package com.pruebaNexus.elkin.nexusP.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pruebaNexus.elkin.nexusP.model.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDTO implements Serializable {

    private static final long serialVersionUID = 418467383515634382L;

    @NotBlank
    @Size(min= 2, max = 50)
    private String name;

    @NotNull
    @Min(1) @Max(999)
    private Integer age;

    @NotNull
    private Position position;

    @NotNull
    @PastOrPresent
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateAdmission;
}
