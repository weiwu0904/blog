package com.weiwu.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weiwu.blog.domain.Tag;
import com.weiwu.blog.exception.ServiceException;
import com.weiwu.blog.mapper.TagMapper;
import com.weiwu.blog.service.TagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.rmi.server.ServerCloneException;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Resource
    private TagMapper tagMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Tag saveTag(Tag tag) throws ServiceException {
        Tag t = tagMapper.getTagByName(tag.getName());
        if (t != null) {
            throw new ServiceException("标签已存在");
        }
        tagMapper.saveTag(tag);
        return tag;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.SUPPORTS)
    public Tag getTag(Long id) {
        return tagMapper.getTagById(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.SUPPORTS)
    public Tag getTagByName(String name) {
        return tagMapper.getTagByName(name);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.SUPPORTS)
    public PageInfo<Tag> listTag(int page, int pageNum) {
        PageHelper.startPage(page, pageNum);
        List<Tag> list = tagMapper.list();
        PageInfo<Tag> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Tag updateTag(Tag tag) {
        tagMapper.updateTag(tag);
        return tag;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void deleteTag(Long id) {
        tagMapper.deleteTag(id);
    }
}
