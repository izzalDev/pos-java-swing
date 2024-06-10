package izzal.dev.pos.repository;

import izzal.dev.pos.entity.Customer;
import izzal.dev.pos.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    private CostumerRepository repository;

    @Test
    public void testSaveAndRetrieve() {
        Customer customer = new Customer("Fulan", "Indonesia", "Semarang");
        repository.save(customer);

        Customer retrievedCustomer = repository.findById(customer.getId()).orElse(null);

        assertEquals(retrievedCustomer.getName(), customer.getName());
        assertEquals(retrievedCustomer.getAddress(), customer.getAddress());
        assertEquals(retrievedCustomer.getCity(), customer.getCity());
    }
}
