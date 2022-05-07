package com.pruebaNexus.elkin.nexusP.controller;


import com.pruebaNexus.elkin.nexusP.dto.ProductCreateDTO;
import com.pruebaNexus.elkin.nexusP.dto.ProductDTO;
import com.pruebaNexus.elkin.nexusP.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
    
    @org.springframework.beans.factory.annotation.Autowired
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductCreateDTO request) throws URISyntaxException {
        log.info("REST request to save Product : {}", request);
        productService.save(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Page<ProductDTO>> searchProduct
            (@RequestParam(name = "query", required = false, defaultValue = "")
                     String query, @RequestParam(defaultValue = "0") int pageNumber,
             @RequestParam(defaultValue = "3") int pageSize) {
        log.info("REST request to get a page of Product");
        Page<ProductDTO> page = productService.SearchProduct(query, PageRequest.of(pageNumber, pageSize));
        return ResponseEntity.ok().body(page);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> searchProductId(@PathVariable Long id) {
        log.info("REST request to get Product : {}", id);
        Optional<ProductDTO> productDTO = productService.findOne(id);
        return ResponseEntity.of(productDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@Valid @RequestBody ProductCreateDTO
                                                                    productCreateDTO,
                                              @PathVariable("id") Long id) {
        log.info("REST request to update Product : {}", productCreateDTO);
        ProductDTO result = productService.update(productCreateDTO, id);
        return ResponseEntity.ok()
                .body(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        log.info("REST request to delete Product : {}", id);
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
