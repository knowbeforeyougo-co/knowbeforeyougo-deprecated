package com.yakovliam.knowbeforeyougo.client.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

public class TerminalCommand {

    /**
     * Is sudo?
     */
    private boolean sudo;

    /**
     * The user's password (linux user)
     * <p>
     * Only used when sudo is true, all else null
     */
    private String userPassword;

    /**
     * The command itself (multiple commands, each element)
     */
    private String[] command;

    public TerminalCommand setSudo(boolean sudo) {
        this.sudo = sudo;
        return this;
    }

    public TerminalCommand setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public TerminalCommand setCommand(String... command) {
        this.command = command;
        return this;
    }

    public boolean isSudo() {
        return sudo;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String[] getCommand() {
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("/bin/bash");
        arguments.add("-c");
        arguments.add((sudo ? "sudo -S " : "") + String.join(";", command));

        // String[] commands = new String[]{
        //         "/bin/bash",
        //         "-c",
        //         sudo ? "sudo -S " + command : command <- where command = a single string
        // };

        return arguments.toArray(String[]::new);
    }
}
