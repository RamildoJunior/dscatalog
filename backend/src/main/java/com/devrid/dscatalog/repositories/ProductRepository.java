package com.devrid.dscatalog.repositories;

import com.devrid.dscatalog.entities.Category;
import com.devrid.dscatalog.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
