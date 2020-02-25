package com.weiwu.blog.domain;

import lombok.Data;

import java.util.List;

/**
 * 博客标签
 */
@Data
public class Tag {

    private Long id;

    /**
     * 标签名称
     */
    private String name;

    /**
     * 首页展示用，博客的数量
     */
    private Integer blogCount;
}
