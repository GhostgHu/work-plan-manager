package com.shimengjie.wpm.work.domain.model.activity.query;

import lombok.Getter;

import java.util.Random;

/**
 * ActivityWork 列表查询条件
 *
 * @author shimengjie
 * @date 2021/10/14 20:46
 **/
@Getter
public class ActivityWorkListQuery {

    /**
     * 查询条件：标题
     */
    private String title;

    /**
     * 随机种子
     */
    private Integer seed;

    /**
     * 当前页码
     */
    private Integer pageNum;

    /**
     * 每页数量
     */
    private Integer pageSize;

    public ActivityWorkListQuery() {
    }

    public ActivityWorkListQuery(String title, Integer seed, Integer pageNum, Integer pageSize) {
        this.title = title;
        // 如果是第一页或 seed 为 null，就生成一个新的 seed
        if (seed == null || seed == 0 || pageNum == 1) {
            this.seed = new Random().nextInt();
        } else {
            this.seed = seed;
        }

        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
