package com.shimengjie.wpm.work.domain.model.news;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author shimengjie
 */
@Data
public class News {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    @NotBlank
    @ApiModelProperty(value = "标题")
    private String title;

    @NotBlank
    @ApiModelProperty(value = "pc端封面url")
    private String pcCoverUrl;

    @NotBlank
    @ApiModelProperty(value = "移动端封面url")
    private String mobileCoverUrl;

    @NotBlank
    @ApiModelProperty(value = "简介")
    private String intro;

    @NotNull
    @ApiModelProperty(value = "类型 1：文章，2：url", allowableValues = "1,2")
    private Integer type;

    @NotBlank
    @ApiModelProperty(value = "内容")
    private String content;

    @NotBlank
    @ApiModelProperty(value = "作者名")
    private String author;

    @NotNull
    @ApiModelProperty(value = "资讯日期", dataType = "java.lang.Long")
    private LocalDateTime newsDate;

    @ApiModelProperty(value = "是否推荐")
    private Boolean recommend;

    @NotNull
    @ApiModelProperty(value = "状态 1：草稿，2：发布，3：下线", allowableValues = "1,2,3")
    private Integer status;

    @ApiModelProperty(value = "创建者ID,user_info表ID")
    private Long creatorId;

    @ApiParam(hidden = true)
    @ApiModelProperty(value = "发布时间", dataType = "java.lang.Long")
    private LocalDateTime publishAt;

    @ApiModelProperty(value = "创建时间", dataType = "java.lang.Long")
    private LocalDateTime createdAt;

    @ApiModelProperty(value = "更新时间", dataType = "java.lang.Long")
    private LocalDateTime updatedAt;

}
