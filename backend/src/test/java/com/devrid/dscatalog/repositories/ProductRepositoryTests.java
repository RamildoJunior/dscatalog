package com.devrid.dscatalog.repositories;


import com.devrid.dscatalog.entities.Product;
import com.devrid.dscatalog.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.Optional;

@DataJpaTest
public class ProductRepositoryTests {

    private long existingId;
    private long countTotalProducts;

    @Autowired
    private ProductRepository repository;

    @BeforeEach
    void setUp() throws Exception{
        existingId = 1L;
        countTotalProducts = 25L;

    }

    @Test
    public void saveShoulPersistWithAutoIncrementWhenIdIsNull(){

        Product product = Factory.createProduct();
        product.setId(null);

        product = repository.save(product);

        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals(countTotalProducts + 1, product.getId());

    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists(){

        long exintingId = 1L;

        repository.deleteById(exintingId);

        Optional<Product> result = repository.findById(exintingId);

        Assertions.assertFalse(result.isPresent());

    }

}
