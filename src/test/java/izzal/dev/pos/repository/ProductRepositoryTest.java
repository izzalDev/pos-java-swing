package izzal.dev.pos.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import izzal.dev.pos.entity.Product;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    public void testSaveAndRetrieve() {
        Product product = new Product("Test Product", "Test Description", 100);
        repository.save(product);

        Product retrievedProduct = repository.findById(product.getId()).orElse(null);

        assertEquals(retrievedProduct.getName(), product.getName());
        assertEquals(retrievedProduct.getDescription(), product.getDescription());
        assertEquals(retrievedProduct.getPrice(), product.getPrice());
    }

    @Test
    public void testFindByDescriptionContaining() {
        Product product1 = new Product("Product 1", "Description 1", 100);
        repository.save(product1);

        Product product2 = new Product("Product 2", "Description 2", 200);
        repository.save(product2);

        List<Product> products = repository.findAll();

        assertEquals(products.size(), 2);
        assertThat(products).contains(product1, product2);
    }
}
