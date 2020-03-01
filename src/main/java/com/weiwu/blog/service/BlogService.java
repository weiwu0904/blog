package com.weiwu.blog.service;

import com.github.pagehelper.PageInfo;
import com.weiwu.blog.domain.Blog;
import com.weiwu.blog.req.AdminBlogReq;

import java.util.List;
import java.util.Map;

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
     * 查询首页博客列表VO
     * @param nowPage
     * @param pageNum
     * @return
     */
    PageInfo<Blog> indexListByType(int nowPage, int pageNum, Long typeId);

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

    /**
     * 首页博客搜索
     * @param nowPage
     * @param pageNum
     * @return
     */
    PageInfo<Blog> searchBlogList(String query,int nowPage, int pageNum);

    /**
     * 前台，获取博客详情
     * @param id
     * @return
     */
    Blog getBlogDetail(Long id);

    /**
     * 博客的 分组
     * @return
     */
    Map<String, List<Blog>> archiveBlog();

    /**
     * 博客总数
     * @return
     */
    Integer countBlog();

    /**
     * 增加浏览次数1
     */
    void updateBlogViews(Long id);
}
