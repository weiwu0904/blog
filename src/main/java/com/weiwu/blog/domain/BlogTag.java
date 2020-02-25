package com.weiwu.blog.domain;

import lombok.Data;

@Data
public class BlogTag {
    private Long id;
    private Long blogId;
    private Long tagId;
}
