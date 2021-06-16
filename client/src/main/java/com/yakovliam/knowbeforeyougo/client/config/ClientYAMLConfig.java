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
         *
         * Usually something like {@code kbyg.domani.tld or api.domain.tld}
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

        public UUID getClientUuid() {
            return clientUuid;
        }

        public void setClientUuid(UUID clientUuid) {
            this.clientUuid = clientUuid;
        }
    }
}
