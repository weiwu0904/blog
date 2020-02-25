package com.weiwu.blog.service;

import com.github.pagehelper.PageInfo;
import com.weiwu.blog.domain.Tag;
import com.weiwu.blog.exception.ServiceException;

import java.util.List;

public interface TagService {

    Tag saveTag(Tag tag) throws ServiceException;

    Tag getTag(Long id);

    Tag getTagByName(String name);

    /**
     * 查询所有标签
     * @return
     */
    List<Tag> list();

    public PageInfo<Tag> listTag(int page, int pageNum);

    Tag updateTag(Tag type);

    void deleteTag(Long id);

    /**
     * 首页按照 tag 在博客中数量排序查询
     * @param nowPage
     * @param pageNum
     * @return
     */
    PageInfo<Tag> indexTagTopList(int nowPage, int pageNum);
}
