package com.weiwu.blog.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 博客分类
 */
@Data
public class Type {

    private Long id;
    /// 分类的名称
    @NotBlank(message = "分类名称不能为空")
    private String name;


    // 拥有博客的数量，给首页展示用的
    private Integer blogCount;

}
