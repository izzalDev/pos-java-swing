package izzal.dev.pos.view;

import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class SplashScreenView extends JFrame {
    public SplashScreenView(){
        setSize(200, 75);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }

    public void  initComponents(){
        add(new JLabel("SplashScreen"));
    }
}
