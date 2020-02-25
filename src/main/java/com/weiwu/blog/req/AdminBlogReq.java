package com.weiwu.blog.req;

import lombok.Data;

@Data
public class AdminBlogReq {
    private String title;
    private Long typeId;
    /// 是否推荐
    private Boolean recommend;
}
