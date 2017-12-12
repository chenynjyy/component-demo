package com.test.query;

import org.elasticsearch.index.query.QueryBuilder;

/**
 * Created by chenyunan on 2017/12/12.
 */
public interface OriginalQueryBuilder {

    /**
     * 返回查询条件
     * @param <T>
     * @return
     */
    <T extends QueryBuilder> T queryBuild();

}
