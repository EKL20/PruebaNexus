package com.pruebaNexus.elkin.nexusP.commons.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -7317668465603269974L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected boolean deleted;

    @Column(name = "created_by", updatable = false)
    protected String createdBy;

    @CreationTimestamp
    @Column(name = "created_At", updatable = false)
    protected LocalDateTime createdAt;

    @Column(name = "updated_by")
    protected String updatedBy;

    @UpdateTimestamp
    @Column(name = "updated_At")
    protected LocalDateTime updatedAt;
}
