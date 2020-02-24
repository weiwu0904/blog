package com.weiwu.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weiwu.blog.domain.Blog;
import com.weiwu.blog.mapper.BlogMapper;
import com.weiwu.blog.req.AdminBlogReq;
import com.weiwu.blog.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {


    @Resource
    private BlogMapper blogMapper;

    @Override
    public Blog getBlog(Long id) {
        return blogMapper.getBlogById(id);
    }

    @Override
    public PageInfo<Blog> adminList(int nowPage, int pageNum) {
        PageHelper.startPage(nowPage, pageNum);
        List<Blog> list = blogMapper.list();
        PageInfo<Blog> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Blog> adminListByReq(int nowPage, int pageNum, AdminBlogReq req) {
        return null;
    }


    @Override
    public Blog saveBlog(Blog blog) {
        return blogMapper.saveBlog(blog);
    }

    @Override
    public int updateBlog(Blog blog) {
        return blogMapper.updateBlog(blog);
    }

    @Override
    public int deleteBlog(Long id) {
        return blogMapper.deleteBlog(id);
    }
}
