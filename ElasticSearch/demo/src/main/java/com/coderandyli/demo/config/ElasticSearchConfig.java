package com.coderandyli.demo.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.network.InetAddresses;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * Created by lizhen on 2019-01-06
 */
@Configuration
public class ElasticSearchConfig {

    @Bean
    public TransportClient client() throws UnknownHostException {

        TransportAddress node = new TransportAddress(
                InetAddress.getByName("localhost"),
                9300
        );

        Settings settings = Settings.builder()
                .put("cluster.name", "coderandyli")
                .build();
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(node);

        return client;
    }
}
