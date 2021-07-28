package com.yakovliam.knowbeforeyougo.client.io;

import com.yakovliam.knowbeforeyougo.client.model.TerminalCommand;

import java.io.*;

public class CommandExecutorService {

    private static CommandExecutorService instance;

    public static CommandExecutorService getInstance() {
        if (instance == null) {
            instance = new CommandExecutorService();
        }

        return instance;
    }

    /**
     * Executes a terminal command
     *
     * @param terminalCommand  command
     * @param executorFunction callback function
     */
    public void executeCommand(TerminalCommand terminalCommand, ExecutorFunction executorFunction) {
        // process
        Process process;
        // full output
        StringBuilder fullOutput = new StringBuilder();
        // exit code
        int exit;

        try {
            process = Runtime.getRuntime().exec(terminalCommand.getCommand());

            if (terminalCommand.isSudo()) {
                BufferedWriter output = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
                output.write(terminalCommand.getUserPassword());
                output.flush();
                output.close();
            }


            String line;
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = input.readLine()) != null) {
                fullOutput.append(line).append("\n");
            }


            // close input
            input.close();

            // wait for process to end, and get exit code
            exit = process.waitFor();

        } catch (IOException |
                InterruptedException e) {
            e.printStackTrace();
            executorFunction.acceptFailed(fullOutput.toString());
            return;
        }

        // succeed or fail
        if (exit == 0) {
            executorFunction.acceptSucceeded(fullOutput.toString());
        } else {
            executorFunction.acceptFailed(fullOutput.toString());
        }
    }
}