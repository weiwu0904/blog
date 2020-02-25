package com.weiwu.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weiwu.blog.domain.Blog;
import com.weiwu.blog.domain.Tag;
import com.weiwu.blog.mapper.BlogMapper;
import com.weiwu.blog.mapper.BlogTagMapper;
import com.weiwu.blog.mapper.TagMapper;
import com.weiwu.blog.req.AdminBlogReq;
import com.weiwu.blog.service.BlogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {


    @Resource
    private BlogMapper blogMapper;

    @Resource
    private BlogTagMapper blogTagMapper;

    @Resource
    private TagMapper tagMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public Blog getBlog(Long id) {
        Blog blog = blogMapper.getBlogById(id);

        // 查询tag
        List<Tag> tagList = tagMapper.getTagByBlogId(id);
        blog.setTagList(tagList);
        blog.init();

        return blog;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public PageInfo<Blog> indexList(int nowPage, int pageNum) {
        PageHelper.startPage(nowPage, pageNum);
        List<Blog> blogListVOList = blogMapper.indexList();
        PageInfo<Blog> pageInfo = new PageInfo<>(blogListVOList);
        return pageInfo;
    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public PageInfo<Blog> adminListByReq(int nowPage, int pageNum, AdminBlogReq req) {
        PageHelper.startPage(nowPage, pageNum);
        List<Blog> list = blogMapper.listByAdminBlogReq(req);
        PageInfo<Blog> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public Blog saveBlog(Blog blog) {

        blog.setFlag("原创");
        blog.setViews(0);
        blog.setCreateTime(LocalDateTime.now());
        blog.setUpdateTime(LocalDateTime.now());
        blogMapper.saveBlog(blog);
        // 设置标签和博客关联关系
        String[] tagIds = blog.getTagIds().split(",");
        blogTagMapper.saveBlogTag(blog.getId(),tagIds);
        return blog;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void updateBlog(Blog blog) {
        blog.setUpdateTime(LocalDateTime.now());
        blogMapper.updateBlog(blog);
        // 修改标签的关联关系
        blogTagMapper.deleteTagsByBlogId(blog.getId());
        // 设置标签和博客关联关系
        String[] tagIds = blog.getTagIds().split(",");
        blogTagMapper.saveBlogTag(blog.getId(),tagIds);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int deleteBlog(Long id) {
        return blogMapper.deleteBlog(id);
    }

    @Override
    public PageInfo<Blog> indexRecommendBlogList(int nowPage, int pageNum) {
        PageHelper.startPage(nowPage, pageNum);
        List<Blog> list = blogMapper.indexRecommendBlogList();
        PageInfo<Blog> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}