package izzal.dev.pos.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import izzal.dev.pos.model.Product;

@SpringBootTest
public class ProductTest {
    @Test
    public void testProductCreation() {
        // Arrange
        Long id = 1L;
        String name = "Test Product";
        String description = "This is a test product";
        int price = 10;

        // Act
        Product product1 = new Product();
        product1.setId(id);
        product1.setName(name);
        product1.setDescription(description);
        product1.setPrice(price);

        Product product2 = new Product(name, description, price);
        product2.setId(id);
        
        // Assert
        assertEquals(id, product1.getId());
        assertEquals(name, product1.getName());
        assertEquals(description, product1.getDescription());
        assertEquals(price, product1.getPrice(), 0.01);
        assertThrows(IllegalStateException.class, () -> product1.setId(id));
        assertEquals(id, product2.getId());
        assertEquals(name, product2.getName());
        assertEquals(description, product2.getDescription());
        assertEquals(price, product2.getPrice(), 0.01);
        assertThrows(IllegalStateException.class, () -> product2.setId(id));
    }
}
