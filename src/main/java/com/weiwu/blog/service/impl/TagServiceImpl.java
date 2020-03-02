package com.weiwu.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weiwu.blog.domain.Tag;
import com.weiwu.blog.exception.ServiceException;
import com.weiwu.blog.mapper.TagMapper;
import com.weiwu.blog.service.TagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Resource
    private TagMapper tagMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public Tag saveTag(Tag tag) throws ServiceException {
        Tag t = tagMapper.getTagByName(tag.getName());
        if (t != null) {
            throw new ServiceException("标签已存在");
        }
        tagMapper.saveTag(tag);
        return tag;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public Tag getTag(Long id) {
        return tagMapper.getTagById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public Tag getTagByName(String name) {
        return tagMapper.getTagByName(name);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public List<Tag> list() {
        return tagMapper.list();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public PageInfo<Tag> listTag(int page, int pageNum) {
        PageHelper.startPage(page, pageNum);
        List<Tag> list = tagMapper.list();
        PageInfo<Tag> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Tag updateTag(Tag tag) {
        tagMapper.updateTag(tag);
        return tag;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteTag(Long id) {
        tagMapper.deleteTag(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public PageInfo<Tag> indexTagTopList(int nowPage, int pageNum) {
        PageHelper.startPage(nowPage, pageNum);
        List<Tag> list = tagMapper.indexTagTopList();
        PageInfo<Tag> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
