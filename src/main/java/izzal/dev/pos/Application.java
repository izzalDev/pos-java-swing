package izzal.dev.pos;

import izzal.dev.pos.view.SplashScreenView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationContext;

import java.awt.Font;

import javax.swing.*;

import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import izzal.dev.pos.controller.CustomerController;
import izzal.dev.pos.database.CustomerRepository;
import izzal.dev.pos.model.Customer;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Application {
	public static SplashScreenView splashScreen;

	@Autowired
	public Application(CustomerRepository repo) {
		splashScreen = new SplashScreenView();
		splashScreen.setVisible(true);
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
		splashScreen.dispose();
		context.getBean(CustomerController.class);

	}
}
