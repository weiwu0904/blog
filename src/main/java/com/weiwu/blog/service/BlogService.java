package com.weiwu.blog.service;

import com.github.pagehelper.PageInfo;
import com.weiwu.blog.domain.Blog;
import com.weiwu.blog.req.AdminBlogReq;

public interface BlogService {

    /**
     * 查询博客
     * @param id
     * @return
     */
    Blog getBlog(Long id);

    /**
     * 查询首页博客列表VO
     * @param nowPage
     * @param pageNum
     * @return
     */
    PageInfo<Blog> indexList(int nowPage, int pageNum);

    /**
     * 根据条件分页查询博客数据
     * @return
     */
    PageInfo<Blog> adminListByReq(int nowPage, int pageNum, AdminBlogReq req);
    /**
     * 新增blog
     * @return
     */
    Blog saveBlog(Blog blog);

    /**
     * 修改blog
     * @param blog
     * @return
     */
    void updateBlog(Blog blog);

    /**
     * 删除博客
     * @param id
     * @return
     */
    int deleteBlog(Long id);

    /**
     * 首页被推荐的博客列表
     * @param nowPage
     * @param pageNum
     * @return
     */
    PageInfo<Blog> indexRecommendBlogList(int nowPage, int pageNum);
}