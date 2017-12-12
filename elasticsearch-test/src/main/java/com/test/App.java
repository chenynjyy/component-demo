package com.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.IOUtils;
import com.test.enums.QueryType;
import com.test.util.EsTemplate;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

/**
 * elasticsearch 6.x
 * Created by chenyunan on 2017/12/12.
 */
public class App {

    public static void main(String[] args) {
        try {
            client();
//            insert();
            query();
//            update();
//            delete();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private static void insert() {
        EsTemplate.insert(new HashMap<String, Object>() {
            {
                put("content0", "today is a good day");
                put("content1", "today is a bad day");
            }
        });
    }
    private static void query() {
        QueryType queryType = QueryType.MATCH_QUERY;
        System.out.println(queryType);
        EsTemplate.search(queryType, "content0", "today");
    }
    private static void update() {

    }
    private static void delete() {

    }

    private static final String CLUSTER_NAME = "cluster1";
    private static final String IP = "192.168.50.91";
    // 9200 Netty4HttpServerTransport
    // 9300 TransportService
    private static final int PORT = 9300;

    /**
     * 相当于table
     */
    private static final String INDEX = "test_client_query_3";
    /**
     * es后续版本会去掉
      */
    private static final String TYPE = "json";

    static TransportClient client = null;
    static boolean isSetting = true;

    private static final void utilInit() {
        EsTemplate.init(client, INDEX, TYPE);
    }

    private static final void client() throws UnknownHostException {

        Settings settings;
        // 加载配置
        if(isSetting) {
            settings = Settings.builder()
                    .put("cluster.name", CLUSTER_NAME)
                    .put("client.transport.sniff", true)
                    .build();
        } else {
            settings = Settings.EMPTY;
        }

        client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(IP), PORT));

        utilInit();
    }

    private static final void close() {
        IOUtils.close(client);
    }

}
