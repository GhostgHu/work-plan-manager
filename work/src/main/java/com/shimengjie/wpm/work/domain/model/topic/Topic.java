package com.shimengjie.wpm.work.domain.model.topic;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
public class Topic {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    @ApiModelProperty(value = "分类id")
    private Long categoryId;

    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 在之前是只有一个封面字段，后来区分移动端和web端，这个字段作为web封面
     *
     * @since 2021.06.07
     */
    @ApiModelProperty(value = "web封面url")
    private String coverUrl;

    @ApiModelProperty(value = "移动端封面url")
    private String mobileCoverUrl;

    @ApiModelProperty(value = "背景图url")
    private String backgroundUrl;

    @ApiModelProperty(value = "简介")
    private String intro;

    @ApiModelProperty(value = "课程数")
    private Integer courseNum;

    @ApiModelProperty(value = "状态 1：草稿，2：发布，3：下线", allowableValues = "1,2,3")
    private Integer status;

    @ApiParam(hidden = true)
    @ApiModelProperty(value = "发布时间", dataType = "java.lang.Long")
    private LocalDateTime publishAt;

    @ApiModelProperty(value = "创建时间", dataType = "java.lang.Long")
    private LocalDateTime createdAt;

    @ApiModelProperty(value = "更新时间", dataType = "java.lang.Long")
    private LocalDateTime updatedAt;


}
