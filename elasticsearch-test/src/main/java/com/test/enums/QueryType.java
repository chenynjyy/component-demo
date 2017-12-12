package com.test.enums;

import lombok.ToString;

/**
 * Created by chenyunan on 2017/12/12.
 */
@ToString
public enum QueryType {

    MATCH_QUERY("相似度匹配", "第一个参数field，第二个参数field对应value");

    private String knowledge;
    private String remark;
    QueryType(String knowledge, String remark) {
        this.knowledge = knowledge;
        this.remark = remark;
    }

}
