package com.pruebaNexus.elkin.nexusP.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import com.pruebaNexus.elkin.nexusP.commons.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.validation.constraints.*;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@SQLDelete(sql = "UPDATE user SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@EqualsAndHashCode(callSuper = true)
@Table(name = "person")
public class User extends BaseEntity {

    @NotBlank
    @Size(min= 2, max = 50)
    @Column(name= "name", length = 50, nullable = false)
    private String name;

    @NotNull
    //@Min(1) @Max(999)
    @Column(name ="age", nullable = false)
    private Integer age;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    @NotNull
    @PastOrPresent
    @Column(name = "date_admission", nullable = false)
    private LocalDate dateAdmission;

}
