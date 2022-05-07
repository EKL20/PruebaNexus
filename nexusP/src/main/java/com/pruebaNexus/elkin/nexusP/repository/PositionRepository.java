package com.pruebaNexus.elkin.nexusP.repository;

import com.pruebaNexus.elkin.nexusP.model.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long>{

    @Query("SELECT p FROM Position p WHERE LOWER(p.name) LIKE LOWER(concat('%', :query, '%'))")
    Page<Position> search(@Param("query") String query, Pageable pageable);

    @Query("SELECT COUNT(p) FROM Position p WHERE LOWER(p.name) = LOWER(:name)")
    Long counttByName(String name);
}
