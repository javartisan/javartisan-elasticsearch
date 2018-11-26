package com.javartisan.springboot.javartisanspringboot;

import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.net.InetAddress;

public class TransportClientTest {

    public static void main(String[] args) throws Exception {

        Settings settings = Settings.settingsBuilder()
                .put("cluster.name", "elasticsearch")
                .build();

        TransportClient client = TransportClient.builder()
                .settings(settings)
                .build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("node"), 9300));


        GetRequest get = new GetRequest();
        get.index("userindex");
        get.type("user");
        get.id("1");
        ActionFuture<GetResponse> res = client.get(get);

        GetResponse finishedRes = res.get();

        System.out.println(finishedRes.getSource());
        System.out.println(finishedRes);

    }
}
