package com.weiwu.blog.vo;

import lombok.Data;

@Data
public class AdminBlogListVO {

    private Long id;

    private String title;

    private Long typeId;

    private String typeName;

    private Boolean isRecommend;
}
