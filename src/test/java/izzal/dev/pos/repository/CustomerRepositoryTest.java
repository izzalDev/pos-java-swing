package izzal.dev.pos.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import izzal.dev.pos.database.CustomerRepository;
import izzal.dev.pos.model.Customer;
@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository repository;

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
