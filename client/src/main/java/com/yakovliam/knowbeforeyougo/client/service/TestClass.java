package com.yakovliam.knowbeforeyougo.client.service;

import com.yakovliam.knowbeforeyougo.client.service.wireless.WirelessInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestClass {

    private WirelessInterfaceService wirelessInterfaceService;

    @Autowired
    public TestClass(WirelessInterfaceService wirelessInterfaceService) throws InterruptedException {
        this.wirelessInterfaceService = wirelessInterfaceService;

        a();
    }

    private void a() throws InterruptedException {
        System.out.println("wirelessInterfaceService.getWirelessInterface().getMode() = " + wirelessInterfaceService.getWirelessInterface().getMode());

        wirelessInterfaceService.switchModes();

        Thread.sleep(1000);

        System.out.println("wirelessInterfaceService.getWirelessInterface().getMode() = " + wirelessInterfaceService.getWirelessInterface().getMode());
    }
}
