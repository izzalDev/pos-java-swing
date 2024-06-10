package izzal.dev.pos.repository;

import izzal.dev.pos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostumerRepository extends JpaRepository<Customer, Long> {
}
