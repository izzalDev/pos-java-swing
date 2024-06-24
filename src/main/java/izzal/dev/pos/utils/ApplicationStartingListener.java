package izzal.dev.pos.utils;

import izzal.dev.pos.view.SplashScreenView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationStartingListener implements ApplicationListener<ApplicationStartingEvent> {
    @Autowired
    private SplashScreenView splashScreenView;
    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        this.splashScreenView.setVisible(true);
    }
}
