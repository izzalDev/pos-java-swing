package izzal.my.id.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import izzal.my.id.pos.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
