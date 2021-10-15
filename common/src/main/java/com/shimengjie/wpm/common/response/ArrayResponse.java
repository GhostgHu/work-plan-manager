package com.shimengjie.wpm.common.response;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回的数组对象
 *
 * @param <T>
 * @author shimengjie
 */
@Getter
public class ArrayResponse<T> extends AbstractResponse {

    /**
     * 数据列表
     */
    private List<T> dataList;

    public ArrayResponse() {
        super();
        this.dataList = new ArrayList<>(1);
    }

    public ArrayResponse(List<T> dataList) {
        super();
        this.dataList = dataList;
    }
}
