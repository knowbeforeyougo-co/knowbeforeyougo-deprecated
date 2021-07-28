package com.yakovliam.knowbeforeyougo.client;

import com.yakovliam.knowbeforeyougo.client.config.ConfigUtil;
import com.yakovliam.knowbeforeyougo.client.model.InterfaceMode;
import com.yakovliam.knowbeforeyougo.client.service.wireless.WirelessInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ClientBootstrapper implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private WirelessInterfaceService wirelessInterfaceService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        SpringApplicationContext.setApplicationContext(applicationContext);

        initialize();
    }

    private void initialize() {
        // prepare configurations
        ConfigUtil.prepareConfigurations();
        // prepare interfaces
        prepareWirelessInterface();
    }

    private void prepareWirelessInterface() {
        // set mode to managed
        wirelessInterfaceService.setMode(InterfaceMode.MANAGED);
        // now set mode to monitor
        wirelessInterfaceService.setMode(InterfaceMode.MONITOR);
    }
}
