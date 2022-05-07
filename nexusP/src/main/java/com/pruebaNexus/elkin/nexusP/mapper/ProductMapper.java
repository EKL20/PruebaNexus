package com.pruebaNexus.elkin.nexusP.mapper;

import com.pruebaNexus.elkin.nexusP.commons.model.EntityMapper;
import com.pruebaNexus.elkin.nexusP.dto.ProductCreateDTO;
import com.pruebaNexus.elkin.nexusP.dto.ProductDTO;
import com.pruebaNexus.elkin.nexusP.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses ={UserMapper.class})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {

    Product toEntity(ProductCreateDTO request);

    ProductDTO toDto(Product product);
}
