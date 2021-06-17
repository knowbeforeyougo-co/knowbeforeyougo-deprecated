package com.yakovliam.knowbeforeyougo.client.config;

import com.yakovliam.knowbeforeyougo.client.config.factory.YamlPropertySourceFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.UUID;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "kbyg")
@PropertySource(value = "classpath:application.yml", factory = YamlPropertySourceFactory.class)
public class ClientYAMLConfig {

    /**
     * Server properties
     */
    private ServerProperties serverProperties;

    /**
     * Client properties
     */
    private ClientProperties clientProperties;

    public ServerProperties getServerProperties() {
        return serverProperties;
    }

    public void setServerProperties(ServerProperties serverProperties) {
        this.serverProperties = serverProperties;
    }

    public ClientProperties getClientProperties() {
        return clientProperties;
    }

    public void setClientProperties(ClientProperties clientProperties) {
        this.clientProperties = clientProperties;
    }

    public static class ServerProperties {

        /**
         * The server's host
         * <p>
         * Usually something like {@code kbyg.domain.tld or api.domain.tld}
         */
        private String serverHost;

        public String getServerHost() {
            return serverHost;
        }

        public void setServerHost(String serverHost) {
            this.serverHost = serverHost;
        }
    }

    public static class ClientProperties {

        /**
         * The client's unique id
         */
        private UUID clientUuid;

        /**
         * The delay (in milliseconds) between checks for nearby devices
         */
        private long nearbyCalculatorDelay;

        /**
         * The interface properties
         */
        private InterfaceProperties interfaceProperties;

        public UUID getClientUuid() {
            return clientUuid;
        }

        public void setClientUuid(UUID clientUuid) {
            this.clientUuid = clientUuid;
        }

        public long getNearbyCalculatorDelay() {
            return nearbyCalculatorDelay;
        }

        public void setNearbyCalculatorDelay(long nearbyCalculatorDelay) {
            this.nearbyCalculatorDelay = nearbyCalculatorDelay;
        }

        public InterfaceProperties getInterfaceProperties() {
            return interfaceProperties;
        }

        public void setInterfaceProperties(InterfaceProperties interfaceProperties) {
            this.interfaceProperties = interfaceProperties;
        }

        public static class InterfaceProperties {

            /**
             * The target wireless interface handle
             */
            private String target;

            public String getTarget() {
                return target;
            }

            public void setTarget(String target) {
                this.target = target;
            }
        }
    }
}
