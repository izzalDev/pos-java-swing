package izzal.dev.pos.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CustomerTest {

    @Test
    void testCostumerCreation(){
        Long id = 1L;
        String name = "Fulan";
        String address = "Indonesia";
        String city = "Semarang";

        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setAddress(address);
        customer.setCity(city);

        assertEquals(id, customer.getId());
        assertEquals(name, customer.getName());
        assertEquals(address, customer.getAddress());
        assertEquals(city, customer.getCity());
        assertThrows(IllegalStateException.class, () -> customer.setId(id));
    }

    @Test
    void testArgsConstructor(){
        Long id = 1L;
        String name = "Fulan";
        String address = "Indonesia";
        String city = "Semarang";

        Customer customer = new Customer(name, address, city);
        customer.setId(id);

        assertEquals(id, customer.getId());
        assertEquals(name, customer.getName());
        assertEquals(address, customer.getAddress());
        assertEquals(city, customer.getCity());
        assertThrows(IllegalStateException.class, () -> customer.setId(id));
    }

}
