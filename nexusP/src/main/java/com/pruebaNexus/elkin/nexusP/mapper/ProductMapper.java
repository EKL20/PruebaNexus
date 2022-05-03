package com.pruebaNexus.elkin.nexusP.mapper;

import com.pruebaNexus.elkin.nexusP.commons.model.EntityMapper;
import com.pruebaNexus.elkin.nexusP.dto.ProductCreateDTO;
import com.pruebaNexus.elkin.nexusP.dto.ProductDTO;
import com.pruebaNexus.elkin.nexusP.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses ={UserMapper.class})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {

    @Mapping(source = "personId", target = "person.id")
    Product toEntity(ProductCreateDTO request);

    @Mapping(source = "person", target = "person")
    ProductDTO toDto(Product product);
}
