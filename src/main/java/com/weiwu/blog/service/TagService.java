package com.weiwu.blog.service;

import com.github.pagehelper.PageInfo;
import com.weiwu.blog.domain.Tag;
import com.weiwu.blog.exception.ServiceException;

public interface TagService {

    Tag saveTag(Tag tag) throws ServiceException;

    Tag getTag(Long id);

    Tag getTagByName(String name);

    public PageInfo<Tag> listTag(int page, int pageNum);

    Tag updateTag(Tag type);

    void deleteTag(Long id);
}
