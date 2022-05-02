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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@SQLDelete(sql = "UPDATE position SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@EqualsAndHashCode(callSuper = true)
@Table(name = "position")
public class Position extends BaseEntity {

    @NotBlank
    @Size(min= 2, max = 20)
    @Column(name= "name", length = 20, nullable = false)
    private String name;

}
