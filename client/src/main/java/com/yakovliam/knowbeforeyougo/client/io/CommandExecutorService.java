package com.yakovliam.knowbeforeyougo.client.io;

import com.yakovliam.knowbeforeyougo.client.config.ClientYAMLConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class CommandExecutorService {

    /**
     * Configuration
     */
    private final ClientYAMLConfig config;

    /**
     * Command executor service
     *
     * @param config config
     */
    @Autowired
    public CommandExecutorService(ClientYAMLConfig config) {
        this.config = config;
    }

    /**
     * Executes a terminal command
     *
     * @param command          command
     * @param executorFunction callback function
     */
    public void executeCommand(String command, ExecutorFunction executorFunction) {
        // process
        Process process;
        // output block
        String out;
        // full output
        StringBuilder fullOutput = new StringBuilder();
        // exit code
        int exit;

        try {
            // spawn execution process
            process = Runtime.getRuntime().exec(command);

            // reader for output
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

            while ((out = br.readLine()) != null) {
                fullOutput.append(out).append("\n");
            }

            // wait until done
            process.waitFor();

            exit = process.exitValue();

            // destroy
            process.destroy();
        } catch (IOException | InterruptedException ignored) {
            executorFunction.acceptFailed(fullOutput.toString());
            return;
        }

        if (exit == 0) {
            executorFunction.acceptSucceeded(fullOutput.toString());
        } else {
            executorFunction.acceptFailed(fullOutput.toString());
        }
    }
}