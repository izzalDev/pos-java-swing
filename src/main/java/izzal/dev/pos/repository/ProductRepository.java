package izzal.dev.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import izzal.dev.pos.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
