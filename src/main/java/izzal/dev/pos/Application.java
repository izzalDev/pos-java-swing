package izzal.dev.pos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.awt.Font;

import javax.swing.UIManager;

import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import izzal.dev.pos.controller.CustomerController;
import izzal.dev.pos.database.CustomerRepository;
import izzal.dev.pos.model.Customer;

@SpringBootApplication
public class Application {

	@Autowired
	public Application(CustomerRepository repo) {
		repo.save(new Customer("Rizal Fadlullah", "Semarang", "Semarang"));
		System.setProperty( "apple.awt.application.name", "Aplikasi Kasir" );
		System.setProperty( "apple.awt.application.appearance", "system" );
		FlatRobotoFont.install();
		UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
		FlatMacDarkLaf.setup();
	}

	public static void main(String[] args) {
		ApplicationContext context = new SpringApplicationBuilder(Application.class)
				.headless(false)
				.run(args);
		context.getBean(CustomerController.class);
	}
}
