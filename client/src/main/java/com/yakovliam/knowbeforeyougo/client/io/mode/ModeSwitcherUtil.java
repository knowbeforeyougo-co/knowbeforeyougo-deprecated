package com.yakovliam.knowbeforeyougo.client.io.mode;

import com.yakovliam.knowbeforeyougo.client.SpringContext;
import com.yakovliam.knowbeforeyougo.client.config.ClientYAMLConfig;
import com.yakovliam.knowbeforeyougo.client.io.CommandExecutorService;
import com.yakovliam.knowbeforeyougo.client.io.ExecutorFunction;
import com.yakovliam.knowbeforeyougo.client.model.InterfaceMode;
import com.yakovliam.knowbeforeyougo.client.model.TerminalCommand;
import com.yakovliam.knowbeforeyougo.client.model.WirelessInterface;

public class ModeSwitcherUtil {

    private static final String SWITCH_TO_MONITOR = "sudo airmon-ng start %s";
    private static final String SWITCH_TO_MANAGED = "sudo airmon-ng stop %s";

    /**
     * Command executor service
     */
    private static final CommandExecutorService commandExecutorService = new CommandExecutorService();

    /**
     * Switches the mode of a wireless interface
     *
     * @param wirelessInterface wireless interface
     */
    public static void switchModes(WirelessInterface wirelessInterface) {
        String userPassword = SpringContext.getBean(ClientYAMLConfig.class)
                .getClientProperties()
                .getUserPassword();

        if (wirelessInterface.getMode() == InterfaceMode.MONITOR) {
            // stop, switch to managed
            setModeManaged(wirelessInterface, userPassword);
        } else {
            // start, switch to monitor
            setModeMonitor(wirelessInterface, userPassword);
        }
    }

    /**
     * Sets the mode of a wireless interface to provided
     *
     * @param wirelessInterface wireless interface
     * @param interfaceMode     interface mode
     */
    public static void setMode(WirelessInterface wirelessInterface, InterfaceMode interfaceMode) {
        String userPassword = SpringContext.getBean(ClientYAMLConfig.class)
                .getClientProperties()
                .getUserPassword();

        // stop, switch to managed
        setModeManaged(wirelessInterface, userPassword);

        if (interfaceMode == InterfaceMode.MONITOR) {
            // start, switch to monitor
            setModeMonitor(wirelessInterface, userPassword);
        }
    }

    /**
     * Sets the mode to monitor
     *
     * @param wirelessInterface wireless interface
     * @param userPassword      password
     */
    private static void setModeMonitor(WirelessInterface wirelessInterface, String userPassword) {
        commandExecutorService.executeCommand(new TerminalCommand().
                setCommand(String.format(SWITCH_TO_MONITOR, wirelessInterface.getHandle()))
                .setSudo(true)
                .setUserPassword(userPassword), new ExecutorFunction().withWhenFailed((o) -> {
                    System.out.println("---- FAILED -----\n" + o);
                }
        ).withWhenSucceeded((o) -> {
            System.out.println("---- SUCCEEDED -----\n" + o);
        }));
        wirelessInterface.setMode(InterfaceMode.MONITOR);
    }

    /**
     * Sets the mode to managed
     *
     * @param wirelessInterface wireless interface
     * @param userPassword      password
     */
    private static void setModeManaged(WirelessInterface wirelessInterface, String userPassword) {
        commandExecutorService.executeCommand(new TerminalCommand().
                setCommand(String.format(SWITCH_TO_MANAGED, wirelessInterface.getHandle()))
                .setSudo(true)
                .setUserPassword(userPassword), new ExecutorFunction().withWhenFailed((o) -> {
                    System.out.println("---- FAILED -----\n" + o);
                }
        ).withWhenSucceeded((o) -> {
            System.out.println("---- SUCCEEDED -----\n" + o);
        }));

        wirelessInterface.setMode(InterfaceMode.MANAGED);
    }
}
