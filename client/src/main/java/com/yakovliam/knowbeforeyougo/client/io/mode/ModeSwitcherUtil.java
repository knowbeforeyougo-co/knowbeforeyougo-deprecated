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
        } else {
            // start, switch to monitor
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
    }
}
