package izzal.my.id.pos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import izzal.my.id.pos.entity.Product;
import izzal.my.id.pos.repository.ProductRepository;

@SpringBootApplication
public class PosApplication{
	private final ProductRepository productRepository;

	public PosApplication(ProductRepository productRepository) {
		this.productRepository = productRepository;
		Product product = new Product();
		product.setName("Product 1");
		product.setDescription("Product 1 Description");
		product.setPrice(1000);
		this.productRepository.save(product);
	}
	public static void main(String[] args) {
		new SpringApplicationBuilder(PosApplication.class)
		.headless(false)
		.web(WebApplicationType.NONE)
		.run(args);
	}
}
