package com.shimengjie.wpm.work.domain.model.activity;

import lombok.Getter;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.time.LocalDateTime;


/**
 * @author shimengjie
 */
@Getter
public class ActivityWork {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 名称
     */
    private String title;

    /**
     * 封面
     */
    private String coverUrl;

    /**
     * 简介
     */
    private String intro;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 作者id
     */
    private Long authorId;

    protected LocalDateTime createdAt;

    protected LocalDateTime updatedAt;
}
