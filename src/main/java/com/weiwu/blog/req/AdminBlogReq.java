package com.weiwu.blog.req;

import lombok.Data;

@Data
public class AdminBlogReq {

    private int nowPage = 1;
    private int pageSize = 10;

    private String title;
    private Long typeId;
    /// 是否推荐
    private Boolean isRecommend;
}
