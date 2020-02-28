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


    /**
     * 获取详情页博客详情
     * @param id
     * @return
     */
    Blog getBlogDetailById(Long id);

    /**
     * 查询博客年份分组
     * @return
     */
    List<String> findGroupYear();

    /**
     * 查询年份的博客
     * @param year
     * @return
     */
    List<Blog> getBlogByYear(String year);

    /**
     * 查询博客总数
     * @return
     */
    Integer getBlogCount();

    /**
     * 分类列表blog，根据分类查询
     * @param typeId
     * @return
     */
    List<Blog> indexListByType(Long typeId);
}
