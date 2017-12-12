package com.test.enums;

import com.alibaba.fastjson.JSON;
import lombok.ToString;

/**
 * Created by chenyunan on 2017/12/12.
 */
public enum QueryType {

    MATCH_QUERY("相似度匹配", "第一个参数field，第二个参数field对应value");

    private String knowledge;
    private String remark;
    QueryType(String knowledge, String remark) {
        this.knowledge = knowledge;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "QueryType{\n" +
                " knowledge='" + knowledge + '\'' +
                ",\n remark='" + remark + '\'' +
                "\n" + '}';
    }
}
