package izzal.dev.pos;

import javax.swing.JFrame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application extends JFrame{

	public Application() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Halo World");
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class)
		.headless(false)
		.run(args);
	}

}
