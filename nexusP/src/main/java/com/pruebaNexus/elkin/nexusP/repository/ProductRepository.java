package com.pruebaNexus.elkin.nexusP.repository;

import com.pruebaNexus.elkin.nexusP.model.Product;
import com.pruebaNexus.elkin.nexusP.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    @Query("SELECT pr FROM User pr WHERE LOWER(pr.name) LIKE LOWER(concat('%', :query, '%'))")
    Page<Product> search(@Param("query") String query, Pageable pageable);

    //@Query("SELECT pr FROM Product pr WHERE pr.user.id =:userId ORDER BY pr.id")
    //List<User> findProductByUser(@Param("userId") Long idUser);

    @Query("SELECT COUNT(pr) FROM Product pr WHERE LOWER(pr.name) = LOWER(:name)")
    Long CountByName(String name);
}
