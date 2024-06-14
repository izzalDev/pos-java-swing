package izzal.dev.pos.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import izzal.dev.pos.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
