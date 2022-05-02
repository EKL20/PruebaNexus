package com.pruebaNexus.elkin.nexusP.mapper;

import com.pruebaNexus.elkin.nexusP.commons.model.EntityMapper;
import com.pruebaNexus.elkin.nexusP.dto.ProductCreateDTO;
import com.pruebaNexus.elkin.nexusP.dto.ProductDTO;
import com.pruebaNexus.elkin.nexusP.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses ={UserMapper.class})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {

    @Mapping(source = "userId", target = "user.id")
    Product toEntity(ProductCreateDTO request);

    @Mapping(source = "user", target = "user")
    ProductDTO toDto(Product product);
}
