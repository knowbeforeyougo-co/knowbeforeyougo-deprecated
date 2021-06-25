package com.yakovliam.knowbeforeyougo.client.config;

import com.yakovliam.knowbeforeyougo.client.ClientApplication;
import com.yakovliam.knowbeforeyougo.client.ClientBootstrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class ConfigUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientApplication.class);

    /**
     * Prepare configurations
     * <p>
     * Creates directories and copies files
     */
    public static void prepareConfigurations() {
        Path configDirectory = Paths.get(System.getProperty("user.dir"), "config");
        Path applicationConfigFile = Paths.get(System.getProperty("user.dir"), "config", "application.yml");
        // create config directory
        try {
            if (Files.notExists(configDirectory)) {
                Files.createDirectories(configDirectory);
            }

            if (Files.notExists(applicationConfigFile)) {
                Files.copy(Objects.requireNonNull(ClientBootstrapper.class.getClassLoader().getResourceAsStream("application.yml")),
                        applicationConfigFile);
            }
        } catch (IOException e) {
            LOGGER.error("Unable to prepare configurations", e);
        }
    }
}
