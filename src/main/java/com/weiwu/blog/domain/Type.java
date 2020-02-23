package com.weiwu.blog.domain;

import lombok.Data;

/**
 * 博客分类
 */
@Data
public class Type {

    private Long id;
    /// 分类的名称
    private String name;
}
