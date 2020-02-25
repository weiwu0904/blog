package com.weiwu.blog.mapper;

import com.weiwu.blog.domain.Blog;
import com.weiwu.blog.req.AdminBlogReq;

import java.util.List;

public interface BlogMapper {

    /**
     * 查询博客信息
     * @param id
     * @return
     */
    Blog getBlogById(Long id);

    /**
     * 根据条件查询博客列表
     */
    List<Blog> listByAdminBlogReq(AdminBlogReq blogReq);

    /**
     * 保存博客信息
     * @param blog
     * @return
     */
    int saveBlog(Blog blog);


    /**
     * 更新博客信息
     * @param blog
     * @return
     */
    int updateBlog(Blog blog);


    /**
     * 删除博客信息
     * @param id
     * @return
     */
    int deleteBlog(Long id);


    /**
     * 查询首页博客的VO
     * @return
     */
    List<Blog> indexList();

    /**
     * 首页推荐博客列表
     * @return
     */
    List<Blog> indexRecommendBlogList();

    /**
     * 首页内容搜索博客查询
     * @param query
     * @return
     */
    List<Blog> searchBlogList(String query);
}
