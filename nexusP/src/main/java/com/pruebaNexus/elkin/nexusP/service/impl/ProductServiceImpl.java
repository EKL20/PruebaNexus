package com.pruebaNexus.elkin.nexusP.service.impl;


import com.pruebaNexus.elkin.nexusP.commons.exceptions.GenericConflictException;
import com.pruebaNexus.elkin.nexusP.dto.ProductCreateDTO;
import com.pruebaNexus.elkin.nexusP.dto.ProductDTO;
import com.pruebaNexus.elkin.nexusP.mapper.ProductMapper;
import com.pruebaNexus.elkin.nexusP.model.Product;
import com.pruebaNexus.elkin.nexusP.repository.ProductRepository;
import com.pruebaNexus.elkin.nexusP.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.pruebaNexus.elkin.nexusP.exceptions.UserError.USER_NOT_FOUNT;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    
   private final ProductRepository productRepository;
   private final ProductMapper mapper;

    @Override
    public void save(ProductCreateDTO ProductDTO) {
        log.debug("Request to save Product : {}", ProductDTO);
        productRepository.save(mapper.toEntity(ProductDTO));
    }

    @Override
    public Page<ProductDTO> SearchProduct(String query, Pageable pageable) {
        log.debug("Request to search Product");
        return productRepository.search(query, pageable).map(mapper::toDto);
    }

    @Override
    public Optional<ProductDTO> findOne(Long id) {
        log.debug("Request to get Product : {}", id);
        return productRepository.findById(id)
                .map(mapper::toDto);
    }

    @Override
    public ProductDTO update(ProductCreateDTO productDTO, Long id) {
        if(!productRepository.findById(id).isPresent()){
            throw new GenericConflictException(USER_NOT_FOUNT);
        }
        log.debug("Request to Update User : {}",productDTO);
        Product product = mapper.toEntity(productDTO);
        product.setId(id);
        return mapper.toDto(productRepository.save(product));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
