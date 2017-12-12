package com.test.query;

import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

/**
 * Created by chenyunan on 2017/12/12.
 */
public class MatchOrigQueryBuilder implements OriginalQueryBuilder {

    private String field;
    private String value;

    public MatchOrigQueryBuilder(String field, String value) {
        this.field = field;
        this.value = value;
    }

    @Override
    public MatchQueryBuilder queryBuild() {
        return QueryBuilders.matchQuery(field, value);
    }
}
