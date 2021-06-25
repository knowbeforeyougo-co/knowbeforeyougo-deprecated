package com.yakovliam.knowbeforeyougo.client.service.wireless;

import com.yakovliam.knowbeforeyougo.client.config.ClientYAMLConfig;
import com.yakovliam.knowbeforeyougo.client.model.InterfaceMode;
import com.yakovliam.knowbeforeyougo.client.model.WirelessInterface;
import com.yakovliam.knowbeforeyougo.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "com.yakovliam.knowbeforeyougo.client")
public class WirelessInterfaceService implements ClientService {

    /**
     * The target wireless interface of the current runtime session
     */
    private final WirelessInterface wirelessInterface;

    /**
     * The configuration
     */
    private final ClientYAMLConfig config;

    /**
     * Construct the wireless interface service
     */
    @Autowired
    @Lazy
    public WirelessInterfaceService(ClientYAMLConfig config) {
        this.config = config;

        // initialize/instantiate from values in the configuration
        this.wirelessInterface = new WirelessInterface(config.getClientProperties()
                .getInterfaceProperties()
                .getTarget());
    }

    /**
     * Returns the wireless interface
     *
     * @return interface
     */
    public WirelessInterface getWirelessInterface() {
        return wirelessInterface;
    }

    /**
     * Switches the mode of the wireless interface
     **/
    public void switchModes() {
        wirelessInterface.getManagerService().switchModes();
    }

    /**
     * Sets the interface mode to provided
     *
     * @param interfaceMode interface mode
     */
    public void setMode(InterfaceMode interfaceMode) {
        wirelessInterface.getManagerService().setMode(interfaceMode);
    }
}
