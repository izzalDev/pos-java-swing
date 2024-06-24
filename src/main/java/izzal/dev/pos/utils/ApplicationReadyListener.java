package izzal.dev.pos.utils;

import izzal.dev.pos.view.SplashScreenView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationReadyListener implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private SplashScreenView splashScreenView;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        splashScreenView.dispose();
    }
}
