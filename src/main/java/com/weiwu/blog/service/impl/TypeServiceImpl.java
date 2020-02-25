package com.weiwu.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weiwu.blog.domain.Type;
import com.weiwu.blog.exception.ServiceException;
import com.weiwu.blog.mapper.TypeMapper;
import com.weiwu.blog.service.TypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Resource
    private TypeMapper typeMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Type saveType(Type type)  throws ServiceException {
        Type t = typeMapper.getTypeByName(type.getName());
        if (t != null) {
            throw new ServiceException("分类已存在");
        }
        typeMapper.saveType(type);
        return type;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.SUPPORTS)
    public Type getById(Long id) {
        Type type = typeMapper.getById(id);
        return type;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.SUPPORTS)
    public PageInfo<Type> list(int page, int pageNum) {
        PageHelper.startPage(page, pageNum);
        List<Type> list = typeMapper.list();
        PageInfo<Type> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<Type> listAll() {
        return typeMapper.list();
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.SUPPORTS)
    public Type updateType(Type type) {
        typeMapper.updateType(type);
        return type;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void deleteType(Long id) {
        typeMapper.deleteType(id);
    }

    @Override
    public PageInfo<Type> indexTypeTopList(int nowPage, int pageNum) {
        PageHelper.startPage(nowPage, pageNum);
        List<Type> list = typeMapper.indexTypeTopList();
        PageInfo<Type> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
