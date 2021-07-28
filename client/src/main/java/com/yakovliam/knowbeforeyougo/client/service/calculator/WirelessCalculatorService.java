package com.yakovliam.knowbeforeyougo.client.service.calculator;

import com.yakovliam.knowbeforeyougo.client.config.ClientYAMLConfig;
import com.yakovliam.knowbeforeyougo.client.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@ComponentScan(basePackages = "com.yakovliam.knowbeforeyougo.client")
public class WirelessCalculatorService extends TaskService {

    /**
     * The configuration for the current client
     */
    private final ClientYAMLConfig config;

    /**
     * Construct wireless io service
     *
     * @param config config
     */
    @Autowired
    public WirelessCalculatorService(ClientYAMLConfig config) {
        this.config = config;
    }

    /**
     * Starts the service
     */
    @Override
    @Scheduled(fixedDelayString = "#{@clientYAMLConfig.clientProperties.nearbyCalculatorDelay}")
    public void start() {
        // use nearby calculator to normalize data, then

    }
}
