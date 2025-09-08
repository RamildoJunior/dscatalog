package com.devrid.dscatalog.resources;


import com.devrid.dscatalog.dto.ProductDTO;
import com.devrid.dscatalog.services.ProductService;
import com.devrid.dscatalog.tests.Factory;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

@WebMvcTest(ProductResource.class)
public class ProductResourceTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ProductService productService;

    private ProductDTO productDTO;
    private PageImpl<ProductDTO> page;
    @BeforeEach
    void setUp() throws Exception{

        productDTO = Factory.createProductDTO();

        page = new PageImpl<>(List.of(productDTO));

        Mockito.when(productService.findAllPaged(ArgumentMatchers.any())).thenReturn(page);
    }

    @Test
    public void  findAllShouldReturnPage(){
        mockMvc.perform(getClass("/products"));
    }

}
