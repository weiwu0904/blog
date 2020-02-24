package com.weiwu.blog.mapper;

import com.weiwu.blog.domain.Blog;
import com.weiwu.blog.req.AdminBlogReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogMapper {

    /**
     * 查询博客信息
     * @param id
     * @return
     */
    Blog getBlogById(Long id);

    /**
     * 列表查询
     * @return
     */
    List<Blog> list();

    /**
     * 根据条件查询博客列表
     */
    List<Blog> listByAdminBlogReq(AdminBlogReq blogReq);

    /**
     * 保存博客信息
     * @param blog
     * @return
     */
    Blog saveBlog(Blog blog);


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


}
