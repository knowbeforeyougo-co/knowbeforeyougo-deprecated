package com.yakovliam.knowbeforeyougo.client.io.scanner;

import com.yakovliam.knowbeforeyougo.client.SpringApplicationContext;
import com.yakovliam.knowbeforeyougo.client.config.ClientYAMLConfig;
import com.yakovliam.knowbeforeyougo.client.io.CommandExecutorService;
import com.yakovliam.knowbeforeyougo.client.io.ExecutorFunction;
import com.yakovliam.knowbeforeyougo.client.model.InterfaceMode;
import com.yakovliam.knowbeforeyougo.client.model.TerminalCommand;
import com.yakovliam.knowbeforeyougo.client.model.WirelessInterface;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WifiScanner {

    private static final String SCAN_COMMAND = "sudo timeout 35s airodump-ng -w dump --output-format csv %s";
    private static final String SCAN_DUMP_FILE_NAME = "dump-01.csv";

    private final WirelessInterface wirelessInterface;

    /**
     * Wifi Scanner
     *
     * @param wirelessInterface interface
     */
    public WifiScanner(WirelessInterface wirelessInterface) {
        this.wirelessInterface = wirelessInterface;
    }

    /**
     * Scans the Wi-Fi network for nearby devices
     * Returns a string containing a CSV file with Wi-Fi scan results
     *
     * @return a string containing a CSV file with Wi-Fi scan results
     */
    public String scan() throws RuntimeException, IOException {
        if (wirelessInterface.getMode().equals(InterfaceMode.MANAGED)) {
            throw new RuntimeException("Wireless Interface mode must be Monitor to complete the action of scanning.");
        }

        // execute command
        String command = String.format(SCAN_COMMAND, wirelessInterface.getHandle());
        String userPassword = SpringApplicationContext.getApplicationContext().getBean(ClientYAMLConfig.class)
                .getClientProperties()
                .getUserPassword();

        CommandExecutorService.getInstance().executeCommand(new TerminalCommand().
                setCommand(command)
                .setSudo(true)
                .setUserPassword(userPassword), new ExecutorFunction().withWhenFailed((o) -> {
                    System.out.println("---- FAILED -----\n" + o);
                }
        ).withWhenSucceeded((o) -> {
            System.out.println("---- SUCCEEDED -----\n" + o);
        }));

        Path csvPath = new File(System.getProperty("user.dir"), SCAN_DUMP_FILE_NAME).toPath();

        // get file contents
        String contents = Files.readString(csvPath);
        // delete file
        Files.delete(csvPath);

        return contents;
    }

}
