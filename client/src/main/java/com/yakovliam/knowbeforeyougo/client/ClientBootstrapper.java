package com.yakovliam.knowbeforeyougo.client;

import com.yakovliam.knowbeforeyougo.client.config.ConfigUtil;
import com.yakovliam.knowbeforeyougo.client.service.wireless.WirelessInterfaceUtil;
import org.springframework.stereotype.Component;

@Component
public class ClientBootstrapper {

    /**
     * Construct bootstrapper
     */
    public ClientBootstrapper() {
        // prepare configurations
        ConfigUtil.prepareConfigurations();
        // prepare interfaces
        WirelessInterfaceUtil.prepareWirelessInterface();
    }
}
