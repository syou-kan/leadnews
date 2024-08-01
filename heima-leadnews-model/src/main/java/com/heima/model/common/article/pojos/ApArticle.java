package com.heima.model.common.article.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 文章信息表，存储已发布的文章
 * </p>
 *
 * @author itheima
 */
@Data
@TableName("ap_article")
public class ApArticle implements Serializable {
    @TableId(value = "id",type = IdType.ID_WORKER)
    private Long id;
    /*
    * 标题
    * */
    private String title;
    /*
    * 作者id
    * */
    @TableId("author_id")
    private Long authorId;
    /*
    * 作者名称
    * */
    @TableId("author_name")
    private String authorName;
    /*
    * 发布日期
    * */
    @TableId("publish_time")
    private Date publishTime;
    /*
    * 创建日期
    * */
    @TableId("created_time")
    private Date createdTime;
    /*
    * 同步状态
    * */
    private Date syncStatus;
    /*
    * 来源
    * */
    private Date source;
    /*
    * 所属频道id
    * */
    private  Integer channelId;
    /*
    * 频道名称
    * */
    private String channelName;
    /*
    * 文章布局
    * */
    private Short layout;

    /*
    * 文章标记  0 普通文章   1 热点文章   2 置顶文章   3 精品文章   4 大V 文章
    * */
    private Byte falg;
     /**
     * 文章封面图片 多张逗号分隔
     */
    private String images;
     /**
     * 标签
     */
    private String labels;

    /**
     * 点赞数量
     */
    private Integer likes;

    /**
     * 收藏数量
     */
    private Integer collection;

    /**
     * 评论数量
     */
    private Integer comment;

    /**
     * 阅读数量
     */
    private Integer views;

    /**
     * 省市
     */
    @TableField("province_id")
    private Integer provinceId;

    /**
     * 市区
     */
    @TableField("city_id")
    private Integer cityId;

    /**
     * 区县
     */
    @TableField("county_id")
    private Integer countyId;
    /**
     * 来源
     */
    private Boolean origin;

    /**
     * 静态页面地址
     */
    @TableField("static_url")
    private String staticUrl;

}
