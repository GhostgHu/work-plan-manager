package com.shimengjie.wpm.common.response;


import com.shimengjie.wpm.common.utils.MathUtil;
import lombok.Getter;

import java.util.List;

/**
 * 分页的时候返回的对象
 *
 * @author shimengjie
 */
@Getter
public class PageResponse<T> extends ArrayResponse<T> {

    /**
     * 记录总数
     */
    private Integer total;

    /**
     * 分页总数
     */
    private Integer pages;

    /**
     * 随机数种子，做随即分页查询的时候，随机种子要返回给前端
     */
    private Integer seed;

    public PageResponse() {
        super();
        this.total = 0;
        this.pages = 0;
    }

    public PageResponse(Integer total, List<T> dataList) {
        super(dataList);
        this.total = total;
    }

    public PageResponse(Integer total, Integer pageSize, int seed, List<T> dataList) {
        super(dataList);
        this.total = total;
        this.seed = seed;
        this.pages = MathUtil.computePageNum(total, pageSize);
    }
}
