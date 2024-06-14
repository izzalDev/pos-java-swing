package izzal.dev.pos;

import java.awt.Desktop;
import java.awt.desktop.AppReopenedEvent;
import java.awt.desktop.AppReopenedListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class)
				.headless(false)
				.run(args);

	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			javax.swing.SwingUtilities.invokeLater(() -> {
				JFrame frame = new JFrame();
				frame.getContentPane().add(new JLabel("Hello, World!"));
				frame.pack();
				frame.setVisible(true);
				
				Desktop.getDesktop().addAppEventListener(new AppReopenedListener() {
					@Override
					public void appReopened(AppReopenedEvent e) {
						frame.setVisible(true);
					}
				});
			});
		};
	}
}
