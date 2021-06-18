package com.yakovliam.knowbeforeyougo.client;

import com.yakovliam.knowbeforeyougo.client.service.wireless.WirelessInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class TestClass {

    @Autowired
    public TestClass(WirelessInterfaceService wirelessInterfaceService) {
        wirelessInterfaceService.switchModes();
    }
}
