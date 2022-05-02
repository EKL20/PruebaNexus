package com.pruebaNexus.elkin.nexusP.repository;

import com.pruebaNexus.elkin.nexusP.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query("SELECT u FROM User u WHERE LOWER(p.name) LIKE LOWER(concat('%', :query, '%'))")
    Page<User> search(@Param("query") String query, Pageable pageable);

    @Query("SELECT COUNT(u) FROM User u WHERE LOWER(u.name) = LOWER(:name)")
    String FindtByName(String code);

    @Query("SELECT COUNT(u) FROM User u WHERE LOWER(u.name) = LOWER(:name)")
    String CounttByName(String code);
}