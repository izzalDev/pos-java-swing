package izzal.my.id.pos.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.springframework.stereotype.Component;

@Component
public class MainView extends JFrame{
    public MainView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setVisible(true);
        initComponents();
    }

    private void initComponents() {
        add(new JLabel("Hello World"));
    }
}
