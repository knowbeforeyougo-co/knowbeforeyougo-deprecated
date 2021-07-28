package com.yakovliam.knowbeforeyougo.client.calculator;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.yakovliam.knowbeforeyougo.client.SpringApplicationContext;
import com.yakovliam.knowbeforeyougo.client.csv.AirodumpMacCSVParser;
import com.yakovliam.knowbeforeyougo.client.csv.CSVStringParser;
import com.yakovliam.knowbeforeyougo.client.io.scanner.WifiScanner;
import com.yakovliam.knowbeforeyougo.client.model.WirelessInterface;
import com.yakovliam.knowbeforeyougo.client.service.wireless.WirelessInterfaceService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class WirelessMobileStationMacAddressCalculator implements Calculator<WirelessInterface, List<String>> {

    private final WifiScanner wifiScanner;

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
            return null;
        }

        List<String[]> records = new CSVStringParser().parse(csv);
        List<String> nearbyDeviceMacAddresses = new AirodumpMacCSVParser().parse(records);

        // TODO filter devices by manufacturer


        return null;
    }
}
