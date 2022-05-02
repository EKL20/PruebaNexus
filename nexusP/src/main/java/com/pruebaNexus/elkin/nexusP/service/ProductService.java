package com.pruebaNexus.elkin.nexusP.service;

import com.pruebaNexus.elkin.nexusP.dto.ProductCreateDTO;
import com.pruebaNexus.elkin.nexusP.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {

    void save(ProductCreateDTO ProductDTO);

    Page<ProductDTO> SearchProduct(String query, Pageable pageable);

    Optional<ProductDTO> findOne(Long id);

    ProductDTO update(ProductCreateDTO productDTO, Long id);

    void delete(Long id);
}
