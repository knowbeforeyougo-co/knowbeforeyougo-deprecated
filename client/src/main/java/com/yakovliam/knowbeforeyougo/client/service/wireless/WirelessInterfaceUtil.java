package com.yakovliam.knowbeforeyougo.client.service.wireless;

import com.yakovliam.knowbeforeyougo.client.SpringContext;
import com.yakovliam.knowbeforeyougo.client.model.InterfaceMode;

public class WirelessInterfaceUtil {

    /**
     * Prepares wireless interfaces on startup
     * <p>
     * Sets the mode of the target interface to managed
     */
    public static void prepareWirelessInterface() {
        // get interface service
        WirelessInterfaceService wirelessInterfaceService = SpringContext.getBean(WirelessInterfaceService.class);
        // set mode to managed
        wirelessInterfaceService.setMode(InterfaceMode.MANAGED);
    }
}
