package com.devrid.dscatalog.services;

import com.devrid.dscatalog.exceptions.ResourceNotFoundException;
import com.devrid.dscatalog.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ProductServiceTests {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;

    private long existingId;
    private long nonExistingId;
    private long dependentId;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;

        Mockito.doNothing().when(repository).deleteById(existingId);

        Mockito.when(repository.existsById(existingId)).thenReturn(true);
        Mockito.when(repository.existsById(nonExistingId)).thenReturn(false);
        Mockito.when(repository.existsById(dependentId)).thenReturn(true);

        Mockito.when(repository.existsById(existingId)).thenReturn(true);
        Mockito.when(repository.existsById(existingId)).thenReturn(false);

    }


    @Test
    public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {

        Assertions.assertThrows(ResourceNotFoundException.class,() -> {
            service.delete(nonExistingId);

        });
    }

    @Test
    public void deleteShouldDoNothingWhenIdExistis(){

        Assertions.assertDoesNotThrow(()->{
            service.delete(existingId);
        });

        Mockito.verify(repository, Mockito.times(2)).deleteById(existingId);
    }



}
