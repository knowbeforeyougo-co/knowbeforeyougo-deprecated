package com.yakovliam.knowbeforeyougo.client.io.mode;

import com.yakovliam.knowbeforeyougo.client.io.CommandExecutorService;
import com.yakovliam.knowbeforeyougo.client.io.ExecutorFunction;
import com.yakovliam.knowbeforeyougo.client.model.InterfaceMode;
import com.yakovliam.knowbeforeyougo.client.model.WirelessInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModeSwitcherUtil {

    private static final String SWITCH_TO_MONITOR = "sudo airmon-ng start {0}";
    private static final String SWITCH_TO_MANAGED = "sudo airmon-ng stop {0}";

    @Autowired
    private CommandExecutorService commandExecutorService;

    /**
     * Switches the mode of a wireless interface
     *
     * @param wirelessInterface wireless interface
     */
    public void switchModes(WirelessInterface wirelessInterface) {
        if (wirelessInterface.getMode() == InterfaceMode.MONITOR) {
            // stop, switch to managed
            commandExecutorService.executeCommand(SWITCH_TO_MANAGED, new ExecutorFunction());
        } else {
            // start, switch to monitor
            commandExecutorService.executeCommand(SWITCH_TO_MONITOR, new ExecutorFunction());
        }
    }
}
