package com.test.util;

import com.test.enums.QueryType;
import com.test.query.MatchOrigQueryBuilder;
import com.test.query.OriginalQueryBuilder;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.VersionType;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chenyunan on 2017/12/12.
 */
public class EsTemplate {

    static TransportClient transportClient = null;
    static String index;
    static String type;

    public static void init(TransportClient transportClient, String index, String type) {
        EsTemplate.transportClient = transportClient;
        EsTemplate.index = index;
        EsTemplate.type = type;
    }

    //--------------- insert
    static final AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void insert(Map<String, Object> source) {
        String ID = String.valueOf(atomicInteger.incrementAndGet());
        for(String field : source.keySet()) {
            Object obj = source.get(field);
            if(obj != null && obj instanceof String) {
                source.put(field, obj + " " + ID);
            }
        }
        IndexResponse indexResponse = transportClient.prepareIndex()
                .setIndex(index)
                .setType(type)
                .setOpType(DocWriteRequest.OpType.CREATE)
                .setVersionType(VersionType.INTERNAL)
                .setId(ID)
                .setSource(source)
                .get();
        System.out.println(indexResponse);
    }

    //----------------insert end

    //------------ search
    public static void search(QueryType queryType, String... params) {
        if(queryType == null) {
            return ;
        }
        OriginalQueryBuilder originQueryBuilder = null;
        switch (queryType) {
            case MATCH_QUERY:
                originQueryBuilder = new MatchOrigQueryBuilder(params[0], params[1]);

        }

        search(originQueryBuilder);
    }

    private static void search(OriginalQueryBuilder originQueryBuilder) {
        SearchResponse searchResponse = transportClient.prepareSearch(index)
                .setTypes(type)
                .setQuery(originQueryBuilder.queryBuild())
                .setFrom(0)
                .setSize(10)
                .get();
        System.out.println(searchResponse);
    }

    //------------------search end

}
