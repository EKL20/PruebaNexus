package com.pruebaNexus.elkin.nexusP.dto;

import com.pruebaNexus.elkin.nexusP.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDTO implements Serializable {

    private static final long serialVersionUID = -6707139925302241424L;

    @NotBlank
    @Size(min= 2, max = 30)
    private String name;

    @NotNull
    private Integer quantity;

    @NotNull
    @PastOrPresent
    private LocalDate dateAdmission;

    @NotNull
    private User user;
}
