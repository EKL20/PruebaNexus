package com.pruebaNexus.elkin.nexusP.model;


import com.pruebaNexus.elkin.nexusP.commons.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@SQLDelete(sql = "UPDATE product SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@EqualsAndHashCode(callSuper = true)
@Table(name = "product")
public class Product extends BaseEntity {

    @NotBlank
    @Size(min= 2, max = 30)
    @Column(name= "name", length = 30, nullable = false)
    private String name;

    @NotNull
    @Column(name ="quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @Column(name = "date_admission", nullable = false)
    private LocalDate dateAdmission;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private User user;
}
