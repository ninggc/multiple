package com.ninggc.esdemo;

import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @program: user-portrait-new
 * @author: Rk
 * @create: 2018-12-03 16:46
 **/
@Component
public class ConnectES {

    private TransportClient client;
    private IndicesAdminClient adminClient;
    private static String host = "10.1.192.124";
    //    private static String host = "127.0.0.1";
    private static int port = 9300;

    /**
     * 连接ES客户端
     * @return client
     */
    @Bean
    public TransportClient ConnectES(){
        Settings settings = Settings.builder().put("cluster.name", "my-application")
                .put("node.name","node-1").put("client.transport.sniff", false).build();
        client = new PreBuiltTransportClient(settings);
        TransportAddress address = null;
        try {
            address = new TransportAddress(InetAddress.getByName(host), port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        client.addTransportAddress(address);
        adminClient = client.admin().indices();
        return client;
    }

    public static void main(String[] args) {
        TransportClient client = new ConnectES().ConnectES();
    }
}

