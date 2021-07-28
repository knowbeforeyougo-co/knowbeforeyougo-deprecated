package com.yakovliam.knowbeforeyougo.client.calculator;

import com.yakovliam.knowbeforeyougo.client.SpringApplicationContext;
import com.yakovliam.knowbeforeyougo.client.io.scanner.WifiScanner;
import com.yakovliam.knowbeforeyougo.client.model.WirelessInterface;
import com.yakovliam.knowbeforeyougo.client.service.wireless.WirelessInterfaceService;

import java.io.IOException;
import java.util.List;

public class WirelessMobileStationMacAddressCalculator implements Calculator<WirelessInterface, List<String>> {


    private WifiScanner wifiScanner;

    public WirelessMobileStationMacAddressCalculator() {
        WirelessInterface wirelessInterface = SpringApplicationContext.getApplicationContext().getBean(WirelessInterfaceService.class).getWirelessInterface();
        wifiScanner = new WifiScanner(wirelessInterface);
    }

    /**
     * Calculate a list of mobile phone mac addresses given a wireless interface
     *
     * @param wirelessInterface k
     * @return v
     */
    @Override
    public List<String> calculate(WirelessInterface wirelessInterface) {
        String csv;
        try {
            csv = wifiScanner.scan();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // TODO parse csv into mac addresses, and look through OUI to detect the manufacturer, and only add to list if it's a cell phone
        return null;
    }
}
