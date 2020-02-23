package com.weiwu.blog.domain;

import lombok.Data;

import javax.swing.text.StyledEditorKit;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 博客内容实体
 */
@Data
public class Blog {

    /**
     * 主键ID
      */
    private Long id;

    /**
     * 博客标题
     */
    private String title;

    /**
     * 博客正文
     */
    private String content;

    /**
     * 博客首图
     */
    private String firstPicture;

    /**
     * 博客标记 如：原创、转载
     */
    private String flag;

    /**
     * 浏览次数
     */
    private Integer views;

    /**
     * 赞赏是否开启
     */
    private boolean appreciateFlag;

    /**
     * 转载声明是否开启
     */
    private boolean shareFlag;

    /**
     * 评论是否开启
     */
    private boolean commentFlag;

    /**
     * 是否发布，还是草稿
     */
    private boolean publishedFalg;

    /**
     * 是否推荐
     */
    private boolean recommendFlag;

    /**
     * 所属分类
     */
    private Type type;

    /**
     * 博客的一些标记,建立关联关系表
     */
    private List<Tag> tagList;

    /**
     * 博客的评论信息,这里存储一级评论信息, 这里数据库不维护评论ID
     */
    private List<Comment> commentList;

    /**
     * 发布博客的用户
     */
    private User user;


    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
